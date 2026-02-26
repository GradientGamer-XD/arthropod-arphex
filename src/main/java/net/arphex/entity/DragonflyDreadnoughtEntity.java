package net.arphex.entity;

import java.util.EnumSet;
import javax.annotation.Nullable;
import net.arphex.init.ArphexModEntities;
import net.arphex.procedures.DragonflyDreadnoughtOnInitialEntitySpawnProcedure;
import net.arphex.procedures.DragonflyTickProcedure;
import net.arphex.procedures.StillCondButterflyProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.BreathAirGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.TryFindWaterGoal;
import net.minecraft.world.entity.ai.goal.Goal.Flag;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages.SpawnEntity;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimatableManager.ControllerRegistrar;
import software.bernie.geckolib.core.animation.AnimationController.State;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class DragonflyDreadnoughtEntity extends Monster implements GeoEntity {
   public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(DragonflyDreadnoughtEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(DragonflyDreadnoughtEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(DragonflyDreadnoughtEntity.class, EntityDataSerializers.STRING);
   private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
   private boolean swinging;
   private boolean lastloop;
   private long lastSwing;
   public String animationprocedure = "empty";

   public DragonflyDreadnoughtEntity(SpawnEntity packet, Level world) {
      this((EntityType<DragonflyDreadnoughtEntity>)ArphexModEntities.DRAGONFLY_DREADNOUGHT.get(), world);
   }

   public DragonflyDreadnoughtEntity(EntityType<DragonflyDreadnoughtEntity> type, Level world) {
      super(type, world);
      this.xpReward = 18;
      this.setNoAi(false);
      this.setMaxUpStep(0.6F);
      this.moveControl = new FlyingMoveControl(this, 10, true);
   }

   protected void defineSynchedData() {
      super.defineSynchedData();
      this.entityData.define(SHOOT, false);
      this.entityData.define(ANIMATION, "undefined");
      this.entityData.define(TEXTURE, "dragonfly");
   }

   public void setTexture(String texture) {
      this.entityData.set(TEXTURE, texture);
   }

   public String getTexture() {
      return (String)this.entityData.get(TEXTURE);
   }

   public Packet<ClientGamePacketListener> getAddEntityPacket() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   protected PathNavigation createNavigation(Level world) {
      return new FlyingPathNavigation(this, world);
   }

   protected void registerGoals() {
      super.registerGoals();
      this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Player.class, false, false));
      this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, MosquitoMorbidityEntity.class, false, false));
      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, ButterflyBewitcherEntity.class, false, false));
      this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, FlyFestererEntity.class, false, false));
      this.goalSelector
         .addGoal(
            5,
            new Goal() {
               {
                  this.setFlags(EnumSet.of(Flag.MOVE));
               }

               public boolean canUse() {
                  return DragonflyDreadnoughtEntity.this.getTarget() != null && !DragonflyDreadnoughtEntity.this.getMoveControl().hasWanted();
               }

               public boolean canContinueToUse() {
                  return DragonflyDreadnoughtEntity.this.getMoveControl().hasWanted()
                     && DragonflyDreadnoughtEntity.this.getTarget() != null
                     && DragonflyDreadnoughtEntity.this.getTarget().isAlive();
               }

               public void start() {
                  LivingEntity livingentity = DragonflyDreadnoughtEntity.this.getTarget();
                  Vec3 vec3d = livingentity.getEyePosition(1.0F);
                  DragonflyDreadnoughtEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1.0);
               }

               public void tick() {
                  LivingEntity livingentity = DragonflyDreadnoughtEntity.this.getTarget();
                  if (DragonflyDreadnoughtEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
                     DragonflyDreadnoughtEntity.this.doHurtTarget(livingentity);
                  } else {
                     double d0 = DragonflyDreadnoughtEntity.this.distanceToSqr(livingentity);
                     if (d0 < 16.0) {
                        Vec3 vec3d = livingentity.getEyePosition(1.0F);
                        DragonflyDreadnoughtEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1.0);
                     }
                  }
               }
            }
         );
      this.targetSelector.addGoal(6, new HurtByTargetGoal(this, new Class[0]));
      this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1.3, 20) {
         protected Vec3 getPosition() {
            RandomSource random = DragonflyDreadnoughtEntity.this.getRandom();
            double dir_x = DragonflyDreadnoughtEntity.this.getX() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double dir_y = DragonflyDreadnoughtEntity.this.getY() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double dir_z = DragonflyDreadnoughtEntity.this.getZ() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            return new Vec3(dir_x, dir_y, dir_z);
         }

         public boolean canUse() {
            double x = DragonflyDreadnoughtEntity.this.getX();
            double y = DragonflyDreadnoughtEntity.this.getY();
            double z = DragonflyDreadnoughtEntity.this.getZ();
            Entity entity = DragonflyDreadnoughtEntity.this;
            Level world = DragonflyDreadnoughtEntity.this.level();
            return super.canUse() && StillCondButterflyProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = DragonflyDreadnoughtEntity.this.getX();
            double y = DragonflyDreadnoughtEntity.this.getY();
            double z = DragonflyDreadnoughtEntity.this.getZ();
            Entity entity = DragonflyDreadnoughtEntity.this;
            Level world = DragonflyDreadnoughtEntity.this.level();
            return super.canContinueToUse() && StillCondButterflyProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(8, new TryFindWaterGoal(this));
      this.goalSelector.addGoal(9, new BreathAirGoal(this));
      this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
   }

   public MobType getMobType() {
      return MobType.ARTHROPOD;
   }

   public void playStepSound(BlockPos pos, BlockState blockIn) {
      this.playSound((SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:rhinobeetlefly")), 0.15F, 1.0F);
   }

   public SoundEvent getHurtSound(DamageSource ds) {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
   }

   public SoundEvent getDeathSound() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:creepy_arthropod_tiny"));
   }

   public boolean causeFallDamage(float l, float d, DamageSource source) {
      return false;
   }

   public boolean hurt(DamageSource source, float amount) {
      if (source.is(DamageTypes.FALL)) {
         return false;
      } else if (source.is(DamageTypes.CACTUS)) {
         return false;
      } else {
         return source.is(DamageTypes.DROWN) ? false : super.hurt(source, amount);
      }
   }

   public SpawnGroupData finalizeSpawn(
      ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag
   ) {
      SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
      DragonflyDreadnoughtOnInitialEntitySpawnProcedure.execute(world, this.getX(), this.getY(), this.getZ(), this);
      return retval;
   }

   public void addAdditionalSaveData(CompoundTag compound) {
      super.addAdditionalSaveData(compound);
      compound.putString("Texture", this.getTexture());
   }

   public void readAdditionalSaveData(CompoundTag compound) {
      super.readAdditionalSaveData(compound);
      if (compound.contains("Texture")) {
         this.setTexture(compound.getString("Texture"));
      }
   }

   public void baseTick() {
      super.baseTick();
      DragonflyTickProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
      this.refreshDimensions();
   }

   public EntityDimensions getDimensions(Pose p_33597_) {
      return super.getDimensions(p_33597_).scale(1.4F);
   }

   protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
   }

   public void setNoGravity(boolean ignored) {
      super.setNoGravity(true);
   }

   public void aiStep() {
      super.aiStep();
      this.setNoGravity(true);
   }

   public static void init() {
   }

   public static Builder createAttributes() {
      Builder builder = Mob.createMobAttributes();
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.5);
      builder = builder.add(Attributes.MAX_HEALTH, 75.0);
      builder = builder.add(Attributes.ARMOR, 3.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 6.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 64.0);
      builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.3);
      builder = builder.add(Attributes.ATTACK_KNOCKBACK, 2.5);
      return builder.add(Attributes.FLYING_SPEED, 0.5);
   }

   private PlayState movementPredicate(AnimationState event) {
      if (this.animationprocedure.equals("empty")) {
         if (event.isMoving() || !(event.getLimbSwingAmount() > -0.15F) || !(event.getLimbSwingAmount() < 0.15F)) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("animation.dragonfly.flight"));
         } else if (this.isDeadOrDying()) {
            return event.setAndContinue(RawAnimation.begin().thenPlay("aanimation.dragonfly.death"));
         } else if (this.isInWaterOrBubble()) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("animation.dragonfly.flight"));
         } else if (this.isShiftKeyDown()) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("animation.dragonfly.attack"));
         } else {
            return this.isSprinting()
               ? event.setAndContinue(RawAnimation.begin().thenLoop("animation.dragonfly.flight"))
               : event.setAndContinue(RawAnimation.begin().thenLoop("animation.dragonfly.idle"));
         }
      } else {
         return PlayState.STOP;
      }
   }

   private PlayState attackingPredicate(AnimationState event) {
      double d1 = this.getX() - this.xOld;
      double d0 = this.getZ() - this.zOld;
      float velocity = (float)Math.sqrt(d1 * d1 + d0 * d0);
      if (this.getAttackAnim(event.getPartialTick()) > 0.0F && !this.swinging) {
         this.swinging = true;
         this.lastSwing = this.level().getGameTime();
      }

      if (this.swinging && this.lastSwing + 7L <= this.level().getGameTime()) {
         this.swinging = false;
      }

      if (this.swinging && event.getController().getAnimationState() == State.STOPPED) {
         event.getController().forceAnimationReset();
         return event.setAndContinue(RawAnimation.begin().thenPlay("animation.dragonfly.attack"));
      } else {
         return PlayState.CONTINUE;
      }
   }

   private PlayState procedurePredicate(AnimationState event) {
      if (!this.animationprocedure.equals("empty") && event.getController().getAnimationState() == State.STOPPED) {
         event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
         if (event.getController().getAnimationState() == State.STOPPED) {
            this.animationprocedure = "empty";
            event.getController().forceAnimationReset();
         }
      } else if (this.animationprocedure.equals("empty")) {
         return PlayState.STOP;
      }

      return PlayState.CONTINUE;
   }

   protected void tickDeath() {
      this.deathTime++;
      if (this.deathTime == 20) {
         this.remove(RemovalReason.KILLED);
         this.dropExperience();
      }
   }

   public String getSyncedAnimation() {
      return (String)this.entityData.get(ANIMATION);
   }

   public void setAnimation(String animation) {
      this.entityData.set(ANIMATION, animation);
   }

   public void registerControllers(ControllerRegistrar data) {
      data.add(new AnimationController[]{new AnimationController(this, "movement", 0, this::movementPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "attacking", 0, this::attackingPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "procedure", 0, this::procedurePredicate)});
   }

   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
   }
}
