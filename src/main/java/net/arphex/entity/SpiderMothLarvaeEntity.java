package net.arphex.entity;

import java.util.EnumSet;
import javax.annotation.Nullable;
import net.arphex.init.ArphexModEntities;
import net.arphex.procedures.SpiderMothLarvaeOnEntityTickUpdateProcedure;
import net.arphex.procedures.SpiderMothLarvaeOnInitialEntitySpawnProcedure;
import net.arphex.procedures.SpiderMothLarvaeThisEntityKillsAnotherOneProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AreaEffectCloud;
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
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.Goal.Flag;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
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

public class SpiderMothLarvaeEntity extends Spider implements RangedAttackMob, GeoEntity {
   public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(SpiderMothLarvaeEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(SpiderMothLarvaeEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(SpiderMothLarvaeEntity.class, EntityDataSerializers.STRING);
   private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
   private boolean swinging;
   private boolean lastloop;
   private long lastSwing;
   public String animationprocedure = "empty";

   public SpiderMothLarvaeEntity(SpawnEntity packet, Level world) {
      this((EntityType<SpiderMothLarvaeEntity>)ArphexModEntities.SPIDER_MOTH_LARVAE.get(), world);
   }

   public SpiderMothLarvaeEntity(EntityType<SpiderMothLarvaeEntity> type, Level world) {
      super(type, world);
      this.xpReward = 0;
      this.setNoAi(false);
      this.setMaxUpStep(0.6F);
      this.setPersistenceRequired();
      this.moveControl = new FlyingMoveControl(this, 10, true);
   }

   protected void defineSynchedData() {
      super.defineSynchedData();
      this.entityData.define(SHOOT, false);
      this.entityData.define(ANIMATION, "undefined");
      this.entityData.define(TEXTURE, "spidermothlarvae");
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
      this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Player.class, true, true));
      this.targetSelector.addGoal(2, new HurtByTargetGoal(this, new Class[0]).setAlertOthers(new Class[0]));
      this.goalSelector
         .addGoal(
            3,
            new Goal() {
               {
                  this.setFlags(EnumSet.of(Flag.MOVE));
               }

               public boolean canUse() {
                  return SpiderMothLarvaeEntity.this.getTarget() != null && !SpiderMothLarvaeEntity.this.getMoveControl().hasWanted();
               }

               public boolean canContinueToUse() {
                  return SpiderMothLarvaeEntity.this.getMoveControl().hasWanted()
                     && SpiderMothLarvaeEntity.this.getTarget() != null
                     && SpiderMothLarvaeEntity.this.getTarget().isAlive();
               }

               public void start() {
                  LivingEntity livingentity = SpiderMothLarvaeEntity.this.getTarget();
                  Vec3 vec3d = livingentity.getEyePosition(1.0F);
                  SpiderMothLarvaeEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1.0);
               }

               public void tick() {
                  LivingEntity livingentity = SpiderMothLarvaeEntity.this.getTarget();
                  if (SpiderMothLarvaeEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
                     SpiderMothLarvaeEntity.this.doHurtTarget(livingentity);
                  } else {
                     double d0 = SpiderMothLarvaeEntity.this.distanceToSqr(livingentity);
                     if (d0 < 40.0) {
                        Vec3 vec3d = livingentity.getEyePosition(1.0F);
                        SpiderMothLarvaeEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1.0);
                     }
                  }
               }
            }
         );
      this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 2.0, true) {
         protected double getAttackReachSqr(LivingEntity entity) {
            return (double)(this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth());
         }
      });
      this.goalSelector.addGoal(5, new RandomStrollGoal(this, 0.8, 20) {
         protected Vec3 getPosition() {
            RandomSource random = SpiderMothLarvaeEntity.this.getRandom();
            double dir_x = SpiderMothLarvaeEntity.this.getX() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double dir_y = SpiderMothLarvaeEntity.this.getY() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double dir_z = SpiderMothLarvaeEntity.this.getZ() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            return new Vec3(dir_x, dir_y, dir_z);
         }
      });
      this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
      this.goalSelector.addGoal(7, new FloatGoal(this));
      this.goalSelector.addGoal(1, new SpiderMothLarvaeEntity.RangedAttackGoal(this, 1.25, 120, 40.0F) {
         @Override
         public boolean canContinueToUse() {
            return this.canUse();
         }
      });
   }

   public MobType getMobType() {
      return MobType.ARTHROPOD;
   }

   public boolean removeWhenFarAway(double distanceToClosestPlayer) {
      return false;
   }

   public double getPassengersRidingOffset() {
      return super.getPassengersRidingOffset() + 0.1;
   }

   public SoundEvent getAmbientSound() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:creepy_arthropod"));
   }

   public void playStepSound(BlockPos pos, BlockState blockIn) {
      this.playSound((SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:creepy_arthropod_tiny")), 0.15F, 1.0F);
   }

   public SoundEvent getHurtSound(DamageSource ds) {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
   }

   public SoundEvent getDeathSound() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
   }

   public boolean causeFallDamage(float l, float d, DamageSource source) {
      return false;
   }

   public boolean hurt(DamageSource source, float amount) {
      if (source.is(DamageTypes.IN_FIRE)) {
         return false;
      } else if (source.getDirectEntity() instanceof ThrownPotion || source.getDirectEntity() instanceof AreaEffectCloud) {
         return false;
      } else if (source.is(DamageTypes.FALL)) {
         return false;
      } else if (source.is(DamageTypes.CACTUS)) {
         return false;
      } else if (source.is(DamageTypes.DROWN)) {
         return false;
      } else if (source.is(DamageTypes.LIGHTNING_BOLT)) {
         return false;
      } else if (source.is(DamageTypes.WITHER)) {
         return false;
      } else {
         return source.is(DamageTypes.WITHER_SKULL) ? false : super.hurt(source, amount);
      }
   }

   public SpawnGroupData finalizeSpawn(
      ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag
   ) {
      SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
      SpiderMothLarvaeOnInitialEntitySpawnProcedure.execute(world, this.getX(), this.getY(), this.getZ());
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

   public void awardKillScore(Entity entity, int score, DamageSource damageSource) {
      super.awardKillScore(entity, score, damageSource);
      SpiderMothLarvaeThisEntityKillsAnotherOneProcedure.execute(entity, this);
   }

   public void baseTick() {
      super.baseTick();
      SpiderMothLarvaeOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
      this.refreshDimensions();
   }

   public EntityDimensions getDimensions(Pose p_33597_) {
      return super.getDimensions(p_33597_).scale(0.8F);
   }

   public void performRangedAttack(LivingEntity target, float flval) {
      BloodProjectileEntity.shoot(this, target);
   }

   protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
   }

   public void setNoGravity(boolean ignored) {
      super.setNoGravity(true);
   }

   public void aiStep() {
      super.aiStep();
      this.updateSwingTime();
      this.setNoGravity(true);
   }

   public static void init() {
   }

   public static Builder createAttributes() {
      Builder builder = Mob.createMobAttributes();
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
      builder = builder.add(Attributes.MAX_HEALTH, 25.0);
      builder = builder.add(Attributes.ARMOR, 0.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 3.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 32.0);
      builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 1.5);
      return builder.add(Attributes.FLYING_SPEED, 0.3);
   }

   private PlayState movementPredicate(AnimationState event) {
      if (!this.animationprocedure.equals("empty")) {
         return PlayState.STOP;
      } else if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F) || !(event.getLimbSwingAmount() < 0.15F)) && this.onGround()) {
         return event.setAndContinue(RawAnimation.begin().thenLoop("animation.spider_moth_dweller.walking"));
      } else if (this.isShiftKeyDown()) {
         return event.setAndContinue(RawAnimation.begin().thenLoop("animation.spider_moth_dweller.grabbing"));
      } else if (this.isSprinting()) {
         return event.setAndContinue(RawAnimation.begin().thenLoop("animation.spider_moth_dweller.flying"));
      } else {
         return !this.onGround()
            ? event.setAndContinue(RawAnimation.begin().thenLoop("animation.spider_moth_dweller.walking"))
            : event.setAndContinue(RawAnimation.begin().thenLoop("animation.spider_moth_dweller.walking"));
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
      data.add(new AnimationController[]{new AnimationController(this, "movement", 1, this::movementPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "procedure", 1, this::procedurePredicate)});
   }

   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
   }

   public class RangedAttackGoal extends Goal {
      private final Mob mob;
      private final RangedAttackMob rangedAttackMob;
      @Nullable
      private LivingEntity target;
      private int attackTime = -1;
      private final double speedModifier;
      private int seeTime;
      private final int attackIntervalMin;
      private final int attackIntervalMax;
      private final float attackRadius;
      private final float attackRadiusSqr;

      public RangedAttackGoal(RangedAttackMob p_25768_, double p_25769_, int p_25770_, float p_25771_) {
         this(p_25768_, p_25769_, p_25770_, p_25770_, p_25771_);
      }

      public RangedAttackGoal(RangedAttackMob p_25773_, double p_25774_, int p_25775_, int p_25776_, float p_25777_) {
         if (!(p_25773_ instanceof LivingEntity)) {
            throw new IllegalArgumentException("ArrowAttackGoal requires Mob implements RangedAttackMob");
         } else {
            this.rangedAttackMob = p_25773_;
            this.mob = (Mob)p_25773_;
            this.speedModifier = p_25774_;
            this.attackIntervalMin = p_25775_;
            this.attackIntervalMax = p_25776_;
            this.attackRadius = p_25777_;
            this.attackRadiusSqr = p_25777_ * p_25777_;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
         }
      }

      public boolean canUse() {
         LivingEntity livingentity = this.mob.getTarget();
         if (livingentity != null && livingentity.isAlive()) {
            this.target = livingentity;
            return true;
         } else {
            return false;
         }
      }

      public boolean canContinueToUse() {
         return this.canUse() || this.target.isAlive() && !this.mob.getNavigation().isDone();
      }

      public void stop() {
         this.target = null;
         this.seeTime = 0;
         this.attackTime = -1;
         ((SpiderMothLarvaeEntity)this.rangedAttackMob).entityData.set(SpiderMothLarvaeEntity.SHOOT, false);
      }

      public boolean requiresUpdateEveryTick() {
         return true;
      }

      public void tick() {
         double d0 = this.mob.distanceToSqr(this.target.getX(), this.target.getY(), this.target.getZ());
         boolean flag = this.mob.getSensing().hasLineOfSight(this.target);
         if (flag) {
            this.seeTime++;
         } else {
            this.seeTime = 0;
         }

         if (!(d0 > (double)this.attackRadiusSqr) && this.seeTime >= 5) {
            this.mob.getNavigation().stop();
         } else {
            this.mob.getNavigation().moveTo(this.target, this.speedModifier);
         }

         this.mob.getLookControl().setLookAt(this.target, 30.0F, 30.0F);
         if (--this.attackTime == 0) {
            if (!flag) {
               ((SpiderMothLarvaeEntity)this.rangedAttackMob).entityData.set(SpiderMothLarvaeEntity.SHOOT, false);
               return;
            }

            ((SpiderMothLarvaeEntity)this.rangedAttackMob).entityData.set(SpiderMothLarvaeEntity.SHOOT, true);
            float f = (float)Math.sqrt(d0) / this.attackRadius;
            float f1 = Mth.clamp(f, 0.1F, 1.0F);
            this.rangedAttackMob.performRangedAttack(this.target, f1);
            this.attackTime = Mth.floor(f * (float)(this.attackIntervalMax - this.attackIntervalMin) + (float)this.attackIntervalMin);
         } else if (this.attackTime < 0) {
            this.attackTime = Mth.floor(Mth.lerp(Math.sqrt(d0) / (double)this.attackRadius, (double)this.attackIntervalMin, (double)this.attackIntervalMax));
         } else {
            ((SpiderMothLarvaeEntity)this.rangedAttackMob).entityData.set(SpiderMothLarvaeEntity.SHOOT, false);
         }
      }
   }
}
