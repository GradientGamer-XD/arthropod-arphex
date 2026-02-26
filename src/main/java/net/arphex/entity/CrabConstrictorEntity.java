package net.arphex.entity;

import net.arphex.init.ArphexModEntities;
import net.arphex.procedures.ConstrictingUpwardsProcedure;
import net.arphex.procedures.CrabConstrictorEntityDiesProcedure;
import net.arphex.procedures.CrabConstrictorOnEntityTickUpdateProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.TryFindWaterGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.level.Level;
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

public class CrabConstrictorEntity extends Monster implements GeoEntity {
   public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(CrabConstrictorEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(CrabConstrictorEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(CrabConstrictorEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<Integer> DATA_grabbingtime = SynchedEntityData.defineId(CrabConstrictorEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<Integer> DATA_grabwait = SynchedEntityData.defineId(CrabConstrictorEntity.class, EntityDataSerializers.INT);
   private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
   private boolean swinging;
   private boolean lastloop;
   private long lastSwing;
   public String animationprocedure = "empty";

   public CrabConstrictorEntity(SpawnEntity packet, Level world) {
      this((EntityType<CrabConstrictorEntity>)ArphexModEntities.CRAB_CONSTRICTOR.get(), world);
   }

   public CrabConstrictorEntity(EntityType<CrabConstrictorEntity> type, Level world) {
      super(type, world);
      this.xpReward = 300;
      this.setNoAi(false);
      this.setMaxUpStep(0.6F);
      this.setPersistenceRequired();
   }

   protected void defineSynchedData() {
      super.defineSynchedData();
      this.entityData.define(SHOOT, false);
      this.entityData.define(ANIMATION, "undefined");
      this.entityData.define(TEXTURE, "crabconstrictor");
      this.entityData.define(DATA_grabbingtime, 0);
      this.entityData.define(DATA_grabwait, 0);
   }

   public void setTexture(String texture) {
      this.entityData.set(TEXTURE, texture);
   }

   public String getTexture() {
      return (String)this.entityData.get(TEXTURE);
   }

   protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
      return 1.9F;
   }

   public Packet<ClientGamePacketListener> getAddEntityPacket() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   protected void registerGoals() {
      super.registerGoals();
      this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 0.5, false) {
         protected double getAttackReachSqr(LivingEntity entity) {
            return 169.0;
         }

         public boolean canUse() {
            double x = CrabConstrictorEntity.this.getX();
            double y = CrabConstrictorEntity.this.getY();
            double z = CrabConstrictorEntity.this.getZ();
            Entity entity = CrabConstrictorEntity.this;
            Level world = CrabConstrictorEntity.this.level();
            return super.canUse() && ConstrictingUpwardsProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = CrabConstrictorEntity.this.getX();
            double y = CrabConstrictorEntity.this.getY();
            double z = CrabConstrictorEntity.this.getZ();
            Entity entity = CrabConstrictorEntity.this;
            Level world = CrabConstrictorEntity.this.level();
            return super.canContinueToUse() && ConstrictingUpwardsProcedure.execute(entity);
         }
      });
      this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Player.class, false, false));
      this.targetSelector.addGoal(3, (new HurtByTargetGoal(this) {
         public boolean canUse() {
            double x = CrabConstrictorEntity.this.getX();
            double y = CrabConstrictorEntity.this.getY();
            double z = CrabConstrictorEntity.this.getZ();
            Entity entity = CrabConstrictorEntity.this;
            Level world = CrabConstrictorEntity.this.level();
            return super.canUse() && ConstrictingUpwardsProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = CrabConstrictorEntity.this.getX();
            double y = CrabConstrictorEntity.this.getY();
            double z = CrabConstrictorEntity.this.getZ();
            Entity entity = CrabConstrictorEntity.this;
            Level world = CrabConstrictorEntity.this.level();
            return super.canContinueToUse() && ConstrictingUpwardsProcedure.execute(entity);
         }
      }).setAlertOthers(new Class[0]));
      this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 60.0F));
      this.goalSelector.addGoal(5, new RandomSwimmingGoal(this, 2.0, 40) {
         public boolean canUse() {
            double x = CrabConstrictorEntity.this.getX();
            double y = CrabConstrictorEntity.this.getY();
            double z = CrabConstrictorEntity.this.getZ();
            Entity entity = CrabConstrictorEntity.this;
            Level world = CrabConstrictorEntity.this.level();
            return super.canUse() && ConstrictingUpwardsProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = CrabConstrictorEntity.this.getX();
            double y = CrabConstrictorEntity.this.getY();
            double z = CrabConstrictorEntity.this.getZ();
            Entity entity = CrabConstrictorEntity.this;
            Level world = CrabConstrictorEntity.this.level();
            return super.canContinueToUse() && ConstrictingUpwardsProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(6, new RandomStrollGoal(this, 1.0) {
         public boolean canUse() {
            double x = CrabConstrictorEntity.this.getX();
            double y = CrabConstrictorEntity.this.getY();
            double z = CrabConstrictorEntity.this.getZ();
            Entity entity = CrabConstrictorEntity.this;
            Level world = CrabConstrictorEntity.this.level();
            return super.canUse() && ConstrictingUpwardsProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = CrabConstrictorEntity.this.getX();
            double y = CrabConstrictorEntity.this.getY();
            double z = CrabConstrictorEntity.this.getZ();
            Entity entity = CrabConstrictorEntity.this;
            Level world = CrabConstrictorEntity.this.level();
            return super.canContinueToUse() && ConstrictingUpwardsProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(7, new TryFindWaterGoal(this));
   }

   public MobType getMobType() {
      return MobType.ARTHROPOD;
   }

   public boolean removeWhenFarAway(double distanceToClosestPlayer) {
      return false;
   }

   public SoundEvent getHurtSound(DamageSource ds) {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:creepy_arthropod_large"));
   }

   public SoundEvent getDeathSound() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:creepy_arthropod_large"));
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
      CrabConstrictorEntityDiesProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ());
   }

   public void addAdditionalSaveData(CompoundTag compound) {
      super.addAdditionalSaveData(compound);
      compound.putString("Texture", this.getTexture());
      compound.putInt("Datagrabbingtime", (Integer)this.entityData.get(DATA_grabbingtime));
      compound.putInt("Datagrabwait", (Integer)this.entityData.get(DATA_grabwait));
   }

   public void readAdditionalSaveData(CompoundTag compound) {
      super.readAdditionalSaveData(compound);
      if (compound.contains("Texture")) {
         this.setTexture(compound.getString("Texture"));
      }

      if (compound.contains("Datagrabbingtime")) {
         this.entityData.set(DATA_grabbingtime, compound.getInt("Datagrabbingtime"));
      }

      if (compound.contains("Datagrabwait")) {
         this.entityData.set(DATA_grabwait, compound.getInt("Datagrabwait"));
      }
   }

   public void baseTick() {
      super.baseTick();
      CrabConstrictorOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
      this.refreshDimensions();
   }

   public EntityDimensions getDimensions(Pose p_33597_) {
      return super.getDimensions(p_33597_).scale(1.99F);
   }

   public static void init() {
   }

   public static Builder createAttributes() {
      Builder builder = Mob.createMobAttributes();
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.5);
      builder = builder.add(Attributes.MAX_HEALTH, 300.0);
      builder = builder.add(Attributes.ARMOR, 20.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 16.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 150.0);
      builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
      return builder.add(Attributes.ATTACK_KNOCKBACK, 0.2);
   }

   private PlayState movementPredicate(AnimationState event) {
      if (this.animationprocedure.equals("empty")) {
         if (event.isMoving() || !(event.getLimbSwingAmount() > -0.15F) || !(event.getLimbSwingAmount() < 0.15F)) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("animation.crabconstrictor.scurrying"));
         } else if (this.isDeadOrDying()) {
            return event.setAndContinue(RawAnimation.begin().thenPlay("animation.crabconstrictor.death"));
         } else if (this.isShiftKeyDown()) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("animation.crabconstrictor.grabbing"));
         } else {
            return this.isSprinting()
               ? event.setAndContinue(RawAnimation.begin().thenLoop("animation.crabconstrictor.grabbingup"))
               : event.setAndContinue(RawAnimation.begin().thenLoop("animation.crabconstrictor.idle"));
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
         return event.setAndContinue(RawAnimation.begin().thenPlay("animation.crabconstrictor.attack"));
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
      if (this.deathTime == 90) {
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
      data.add(new AnimationController[]{new AnimationController(this, "movement", 20, this::movementPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "attacking", 20, this::attackingPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "procedure", 20, this::procedurePredicate)});
   }

   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
   }

   public void aiStep() {
      super.aiStep();
      this.updateSwingTime();
      if (this.getTarget() != null && !this.swinging && !this.getPersistentData().getBoolean("disable_rotation")) {
         double dx = this.getTarget().getX() - this.getX();
         double dz = this.getTarget().getZ() - this.getZ();
         float targetYaw = (float)Math.toDegrees(Math.atan2(-dx, dz));
         this.setYRot(targetYaw);
         this.yBodyRot = targetYaw;
         this.yHeadRot = targetYaw;
      }
   }

   public void travel(Vec3 movement) {
      float prevYaw = this.getYRot();
      super.travel(movement);
      this.setYRot(prevYaw);
   }
}
