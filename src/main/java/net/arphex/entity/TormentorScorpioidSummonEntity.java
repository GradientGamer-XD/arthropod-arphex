package net.arphex.entity;

import javax.annotation.Nullable;
import net.arphex.init.ArphexModEntities;
import net.arphex.procedures.BossDeathProcedure;
import net.arphex.procedures.GoToTormentorProcedure;
import net.arphex.procedures.TormentorScorpioidSummonOnEntityTickUpdateProcedure;
import net.arphex.procedures.TormentorScorpioidSummonOnInitialEntitySpawnProcedure;
import net.arphex.procedures.TormentorVoidlasherSummonEntityDiesProcedure;
import net.arphex.procedures.TormentorVoidlasherSummonEntityIsHurtProcedure;
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
import net.minecraft.world.entity.ai.goal.BreathAirGoal;
import net.minecraft.world.entity.ai.goal.FollowMobGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
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

public class TormentorScorpioidSummonEntity extends Monster implements GeoEntity {
   public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(TormentorScorpioidSummonEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(TormentorScorpioidSummonEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(TormentorScorpioidSummonEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<Boolean> DATA_flee_mode = SynchedEntityData.defineId(
      TormentorScorpioidSummonEntity.class, EntityDataSerializers.BOOLEAN
   );
   private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
   private boolean swinging;
   private boolean lastloop;
   private long lastSwing;
   public String animationprocedure = "empty";

   public TormentorScorpioidSummonEntity(SpawnEntity packet, Level world) {
      this((EntityType<TormentorScorpioidSummonEntity>)ArphexModEntities.TORMENTOR_SCORPIOID_SUMMON.get(), world);
   }

   public TormentorScorpioidSummonEntity(EntityType<TormentorScorpioidSummonEntity> type, Level world) {
      super(type, world);
      this.xpReward = 500;
      this.setNoAi(false);
      this.setMaxUpStep(0.6F);
      this.setPersistenceRequired();
      this.moveControl = new FlyingMoveControl(this, 10, true);
   }

   protected void defineSynchedData() {
      super.defineSynchedData();
      this.entityData.define(SHOOT, false);
      this.entityData.define(ANIMATION, "undefined");
      this.entityData.define(TEXTURE, "tormentluster");
      this.entityData.define(DATA_flee_mode, false);
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
      this.targetSelector.addGoal(1, (new HurtByTargetGoal(this) {
         public boolean canUse() {
            double x = TormentorScorpioidSummonEntity.this.getX();
            double y = TormentorScorpioidSummonEntity.this.getY();
            double z = TormentorScorpioidSummonEntity.this.getZ();
            Entity entity = TormentorScorpioidSummonEntity.this;
            Level world = TormentorScorpioidSummonEntity.this.level();
            return super.canUse() && GoToTormentorProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = TormentorScorpioidSummonEntity.this.getX();
            double y = TormentorScorpioidSummonEntity.this.getY();
            double z = TormentorScorpioidSummonEntity.this.getZ();
            Entity entity = TormentorScorpioidSummonEntity.this;
            Level world = TormentorScorpioidSummonEntity.this.level();
            return super.canContinueToUse() && GoToTormentorProcedure.execute(entity);
         }
      }).setAlertOthers(new Class[0]));
      this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 2.0, false) {
         protected double getAttackReachSqr(LivingEntity entity) {
            return 100.0;
         }

         public boolean canUse() {
            double x = TormentorScorpioidSummonEntity.this.getX();
            double y = TormentorScorpioidSummonEntity.this.getY();
            double z = TormentorScorpioidSummonEntity.this.getZ();
            Entity entity = TormentorScorpioidSummonEntity.this;
            Level world = TormentorScorpioidSummonEntity.this.level();
            return super.canUse() && GoToTormentorProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = TormentorScorpioidSummonEntity.this.getX();
            double y = TormentorScorpioidSummonEntity.this.getY();
            double z = TormentorScorpioidSummonEntity.this.getZ();
            Entity entity = TormentorScorpioidSummonEntity.this;
            Level world = TormentorScorpioidSummonEntity.this.level();
            return super.canContinueToUse() && GoToTormentorProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(3, new BreathAirGoal(this) {
         public boolean canUse() {
            double x = TormentorScorpioidSummonEntity.this.getX();
            double y = TormentorScorpioidSummonEntity.this.getY();
            double z = TormentorScorpioidSummonEntity.this.getZ();
            Entity entity = TormentorScorpioidSummonEntity.this;
            Level world = TormentorScorpioidSummonEntity.this.level();
            return super.canUse() && GoToTormentorProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = TormentorScorpioidSummonEntity.this.getX();
            double y = TormentorScorpioidSummonEntity.this.getY();
            double z = TormentorScorpioidSummonEntity.this.getZ();
            Entity entity = TormentorScorpioidSummonEntity.this;
            Level world = TormentorScorpioidSummonEntity.this.level();
            return super.canContinueToUse() && GoToTormentorProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(4, new FollowMobGoal(this, 1.0, 50.0F, 50.0F) {
         public boolean canUse() {
            double x = TormentorScorpioidSummonEntity.this.getX();
            double y = TormentorScorpioidSummonEntity.this.getY();
            double z = TormentorScorpioidSummonEntity.this.getZ();
            Entity entity = TormentorScorpioidSummonEntity.this;
            Level world = TormentorScorpioidSummonEntity.this.level();
            return super.canUse() && GoToTormentorProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = TormentorScorpioidSummonEntity.this.getX();
            double y = TormentorScorpioidSummonEntity.this.getY();
            double z = TormentorScorpioidSummonEntity.this.getZ();
            Entity entity = TormentorScorpioidSummonEntity.this;
            Level world = TormentorScorpioidSummonEntity.this.level();
            return super.canContinueToUse() && GoToTormentorProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.5, 20) {
         protected Vec3 getPosition() {
            RandomSource random = TormentorScorpioidSummonEntity.this.getRandom();
            double dir_x = TormentorScorpioidSummonEntity.this.getX() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double dir_y = TormentorScorpioidSummonEntity.this.getY() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double dir_z = TormentorScorpioidSummonEntity.this.getZ() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            return new Vec3(dir_x, dir_y, dir_z);
         }

         public boolean canUse() {
            double x = TormentorScorpioidSummonEntity.this.getX();
            double y = TormentorScorpioidSummonEntity.this.getY();
            double z = TormentorScorpioidSummonEntity.this.getZ();
            Entity entity = TormentorScorpioidSummonEntity.this;
            Level world = TormentorScorpioidSummonEntity.this.level();
            return super.canUse() && GoToTormentorProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = TormentorScorpioidSummonEntity.this.getX();
            double y = TormentorScorpioidSummonEntity.this.getY();
            double z = TormentorScorpioidSummonEntity.this.getZ();
            Entity entity = TormentorScorpioidSummonEntity.this;
            Level world = TormentorScorpioidSummonEntity.this.level();
            return super.canContinueToUse() && GoToTormentorProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 100.0F) {
         public boolean canUse() {
            double x = TormentorScorpioidSummonEntity.this.getX();
            double y = TormentorScorpioidSummonEntity.this.getY();
            double z = TormentorScorpioidSummonEntity.this.getZ();
            Entity entity = TormentorScorpioidSummonEntity.this;
            Level world = TormentorScorpioidSummonEntity.this.level();
            return super.canUse() && GoToTormentorProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = TormentorScorpioidSummonEntity.this.getX();
            double y = TormentorScorpioidSummonEntity.this.getY();
            double z = TormentorScorpioidSummonEntity.this.getZ();
            Entity entity = TormentorScorpioidSummonEntity.this;
            Level world = TormentorScorpioidSummonEntity.this.level();
            return super.canContinueToUse() && GoToTormentorProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(7, new RandomLookAroundGoal(this) {
         public boolean canUse() {
            double x = TormentorScorpioidSummonEntity.this.getX();
            double y = TormentorScorpioidSummonEntity.this.getY();
            double z = TormentorScorpioidSummonEntity.this.getZ();
            Entity entity = TormentorScorpioidSummonEntity.this;
            Level world = TormentorScorpioidSummonEntity.this.level();
            return super.canUse() && GoToTormentorProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = TormentorScorpioidSummonEntity.this.getX();
            double y = TormentorScorpioidSummonEntity.this.getY();
            double z = TormentorScorpioidSummonEntity.this.getZ();
            Entity entity = TormentorScorpioidSummonEntity.this;
            Level world = TormentorScorpioidSummonEntity.this.level();
            return super.canContinueToUse() && GoToTormentorProcedure.execute(entity);
         }
      });
   }

   public MobType getMobType() {
      return MobType.ARTHROPOD;
   }

   public boolean removeWhenFarAway(double distanceToClosestPlayer) {
      return false;
   }

   public SoundEvent getAmbientSound() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:creepy_arthropod_large"));
   }

   public SoundEvent getHurtSound(DamageSource ds) {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:heartbeats"));
   }

   public SoundEvent getDeathSound() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.death"));
   }

   public boolean causeFallDamage(float l, float d, DamageSource source) {
      return false;
   }

   public boolean hurt(DamageSource source, float amount) {
      TormentorVoidlasherSummonEntityIsHurtProcedure.execute(source.getEntity());
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
      } else if (source.is(DamageTypes.EXPLOSION)) {
         return false;
      } else if (source.is(DamageTypes.WITHER)) {
         return false;
      } else {
         return source.is(DamageTypes.WITHER_SKULL) ? false : super.hurt(source, amount);
      }
   }

   public void die(DamageSource source) {
      super.die(source);
      TormentorVoidlasherSummonEntityDiesProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), source.getEntity());
   }

   public SpawnGroupData finalizeSpawn(
      ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag
   ) {
      SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
      TormentorScorpioidSummonOnInitialEntitySpawnProcedure.execute(world, this.getX(), this.getY(), this.getZ(), this);
      return retval;
   }

   public void addAdditionalSaveData(CompoundTag compound) {
      super.addAdditionalSaveData(compound);
      compound.putString("Texture", this.getTexture());
      compound.putBoolean("Dataflee_mode", (Boolean)this.entityData.get(DATA_flee_mode));
   }

   public void readAdditionalSaveData(CompoundTag compound) {
      super.readAdditionalSaveData(compound);
      if (compound.contains("Texture")) {
         this.setTexture(compound.getString("Texture"));
      }

      if (compound.contains("Dataflee_mode")) {
         this.entityData.set(DATA_flee_mode, compound.getBoolean("Dataflee_mode"));
      }
   }

   public void baseTick() {
      super.baseTick();
      TormentorScorpioidSummonOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
      this.refreshDimensions();
   }

   public EntityDimensions getDimensions(Pose p_33597_) {
      return super.getDimensions(p_33597_).scale(1.0F);
   }

   protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
   }

   public void setNoGravity(boolean ignored) {
      super.setNoGravity(true);
   }

   public void aiStep() {
      super.aiStep();
      if (this.getTarget() != null && !this.swinging && !this.getPersistentData().getBoolean("disable_rotation")) {
         double dx = this.getTarget().getX() - this.getX();
         double dz = this.getTarget().getZ() - this.getZ();
         float targetYaw = (float)Math.toDegrees(Math.atan2(-dx, dz));
         this.setYRot(targetYaw);
         this.yBodyRot = targetYaw;
         this.yHeadRot = targetYaw;
      }

      this.setNoGravity(true);
   }

   public static void init() {
   }

   public static Builder createAttributes() {
      Builder builder = Mob.createMobAttributes();
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
      builder = builder.add(Attributes.MAX_HEALTH, 450.0);
      builder = builder.add(Attributes.ARMOR, 20.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 60.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 200.0);
      builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 1.1);
      return builder.add(Attributes.FLYING_SPEED, 0.3);
   }

   private PlayState movementPredicate(AnimationState event) {
      if (this.animationprocedure.equals("empty")) {
         if (this.isDeadOrDying()) {
            return event.setAndContinue(RawAnimation.begin().thenPlay("animation.bloodscorpion.idle"));
         } else if (this.isShiftKeyDown()) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("animation.bloodscorpion.ground"));
         } else if (this.isSprinting()) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("animation.bloodscorpion.crawl"));
         } else {
            return this.isAggressive() && event.isMoving()
               ? event.setAndContinue(RawAnimation.begin().thenLoop("animation.bloodscorpion.chase"))
               : event.setAndContinue(RawAnimation.begin().thenLoop("animation.bloodscorpion.idle"));
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
         return event.setAndContinue(RawAnimation.begin().thenPlay("animation.bloodscorpion.attack"));
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
      if (this.deathTime == 100) {
         this.remove(RemovalReason.KILLED);
         this.dropExperience();
         BossDeathProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
      }
   }

   public String getSyncedAnimation() {
      return (String)this.entityData.get(ANIMATION);
   }

   public void setAnimation(String animation) {
      this.entityData.set(ANIMATION, animation);
   }

   public void registerControllers(ControllerRegistrar data) {
      data.add(new AnimationController[]{new AnimationController(this, "movement", 3, this::movementPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "attacking", 3, this::attackingPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "procedure", 3, this::procedurePredicate)});
   }

   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
   }

   public void travel(Vec3 movement) {
      float prevYaw = this.getYRot();
      super.travel(movement);
      this.setYRot(prevYaw);
   }
}
