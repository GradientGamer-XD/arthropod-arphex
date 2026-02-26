package net.arphex.entity;

import net.arphex.init.ArphexModEntities;
import net.arphex.procedures.OnGroundReturnProcedure;
import net.arphex.procedures.TermiteTunnelerAlateOnEntityTickUpdateProcedure;
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
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveBackToVillageGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.level.Level;
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

public class TermiteTunnelerAlateEntity extends Monster implements GeoEntity {
   public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(TermiteTunnelerAlateEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(TermiteTunnelerAlateEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(TermiteTunnelerAlateEntity.class, EntityDataSerializers.STRING);
   private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
   private boolean swinging;
   private boolean lastloop;
   private long lastSwing;
   public String animationprocedure = "empty";

   public TermiteTunnelerAlateEntity(SpawnEntity packet, Level world) {
      this((EntityType<TermiteTunnelerAlateEntity>)ArphexModEntities.TERMITE_TUNNELER_ALATE.get(), world);
   }

   public TermiteTunnelerAlateEntity(EntityType<TermiteTunnelerAlateEntity> type, Level world) {
      super(type, world);
      this.xpReward = 3;
      this.setNoAi(false);
      this.setMaxUpStep(0.6F);
   }

   protected void defineSynchedData() {
      super.defineSynchedData();
      this.entityData.define(SHOOT, false);
      this.entityData.define(ANIMATION, "undefined");
      this.entityData.define(TEXTURE, "termitealate");
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

   protected void registerGoals() {
      super.registerGoals();
      this.goalSelector.addGoal(1, new AvoidEntityGoal<AntArsonistSoldierEntity>(this, AntArsonistSoldierEntity.class, 10.0F, 1.0, 1.2) {
         public boolean canUse() {
            double x = TermiteTunnelerAlateEntity.this.getX();
            double y = TermiteTunnelerAlateEntity.this.getY();
            double z = TermiteTunnelerAlateEntity.this.getZ();
            Entity entity = TermiteTunnelerAlateEntity.this;
            Level world = TermiteTunnelerAlateEntity.this.level();
            return super.canUse() && OnGroundReturnProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = TermiteTunnelerAlateEntity.this.getX();
            double y = TermiteTunnelerAlateEntity.this.getY();
            double z = TermiteTunnelerAlateEntity.this.getZ();
            Entity entity = TermiteTunnelerAlateEntity.this;
            Level world = TermiteTunnelerAlateEntity.this.level();
            return super.canContinueToUse() && OnGroundReturnProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(2, new MoveBackToVillageGoal(this, 0.6, false) {
         public boolean canUse() {
            double x = TermiteTunnelerAlateEntity.this.getX();
            double y = TermiteTunnelerAlateEntity.this.getY();
            double z = TermiteTunnelerAlateEntity.this.getZ();
            Entity entity = TermiteTunnelerAlateEntity.this;
            Level world = TermiteTunnelerAlateEntity.this.level();
            return super.canUse() && OnGroundReturnProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = TermiteTunnelerAlateEntity.this.getX();
            double y = TermiteTunnelerAlateEntity.this.getY();
            double z = TermiteTunnelerAlateEntity.this.getZ();
            Entity entity = TermiteTunnelerAlateEntity.this;
            Level world = TermiteTunnelerAlateEntity.this.level();
            return super.canContinueToUse() && OnGroundReturnProcedure.execute(entity);
         }
      });
      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Player.class, true, true));
      this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, AntArsonistEntity.class, true, true));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, AntArsonistAlateQueenEntity.class, true, true));
      this.targetSelector.addGoal(6, new NearestAttackableTargetGoal(this, AntArsonistWorkerEntity.class, true, true));
      this.goalSelector.addGoal(7, new MeleeAttackGoal(this, 1.2, false) {
         protected double getAttackReachSqr(LivingEntity entity) {
            return 4.0;
         }
      });
      this.targetSelector.addGoal(8, new HurtByTargetGoal(this, new Class[0]).setAlertOthers(new Class[0]));
      this.goalSelector.addGoal(9, new WaterAvoidingRandomStrollGoal(this, 1.0) {
         public boolean canUse() {
            double x = TermiteTunnelerAlateEntity.this.getX();
            double y = TermiteTunnelerAlateEntity.this.getY();
            double z = TermiteTunnelerAlateEntity.this.getZ();
            Entity entity = TermiteTunnelerAlateEntity.this;
            Level world = TermiteTunnelerAlateEntity.this.level();
            return super.canUse() && OnGroundReturnProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = TermiteTunnelerAlateEntity.this.getX();
            double y = TermiteTunnelerAlateEntity.this.getY();
            double z = TermiteTunnelerAlateEntity.this.getZ();
            Entity entity = TermiteTunnelerAlateEntity.this;
            Level world = TermiteTunnelerAlateEntity.this.level();
            return super.canContinueToUse() && OnGroundReturnProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(10, new RandomLookAroundGoal(this) {
         public boolean canUse() {
            double x = TermiteTunnelerAlateEntity.this.getX();
            double y = TermiteTunnelerAlateEntity.this.getY();
            double z = TermiteTunnelerAlateEntity.this.getZ();
            Entity entity = TermiteTunnelerAlateEntity.this;
            Level world = TermiteTunnelerAlateEntity.this.level();
            return super.canUse() && OnGroundReturnProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = TermiteTunnelerAlateEntity.this.getX();
            double y = TermiteTunnelerAlateEntity.this.getY();
            double z = TermiteTunnelerAlateEntity.this.getZ();
            Entity entity = TermiteTunnelerAlateEntity.this;
            Level world = TermiteTunnelerAlateEntity.this.level();
            return super.canContinueToUse() && OnGroundReturnProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(11, new FloatGoal(this));
      this.goalSelector.addGoal(12, new RandomSwimmingGoal(this, 1.0, 40));
   }

   public MobType getMobType() {
      return MobType.ARTHROPOD;
   }

   public double getPassengersRidingOffset() {
      return super.getPassengersRidingOffset() + -0.4;
   }

   public SoundEvent getAmbientSound() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:creepy_arthropod_tiny"));
   }

   public SoundEvent getDeathSound() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
   }

   public boolean hurt(DamageSource source, float amount) {
      if (source.getDirectEntity() instanceof AbstractArrow) {
         return false;
      } else if (source.getDirectEntity() instanceof ThrownPotion || source.getDirectEntity() instanceof AreaEffectCloud) {
         return false;
      } else if (source.is(DamageTypes.FALL)) {
         return false;
      } else {
         return source.is(DamageTypes.CACTUS) ? false : super.hurt(source, amount);
      }
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
      TermiteTunnelerAlateOnEntityTickUpdateProcedure.execute(this.level(), this);
      this.refreshDimensions();
   }

   public EntityDimensions getDimensions(Pose p_33597_) {
      return super.getDimensions(p_33597_).scale(0.96F);
   }

   public static void init() {
   }

   public static Builder createAttributes() {
      Builder builder = Mob.createMobAttributes();
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.15);
      builder = builder.add(Attributes.MAX_HEALTH, 25.0);
      builder = builder.add(Attributes.ARMOR, 4.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 3.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 20.0);
      return builder.add(Attributes.ATTACK_KNOCKBACK, 0.2);
   }

   private PlayState movementPredicate(AnimationState event) {
      if (!this.animationprocedure.equals("empty")) {
         return PlayState.STOP;
      } else if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F) || !(event.getLimbSwingAmount() < 0.15F)) && this.onGround()) {
         return event.setAndContinue(RawAnimation.begin().thenLoop("animation.termite.scurrying"));
      } else if (this.isDeadOrDying()) {
         return event.setAndContinue(RawAnimation.begin().thenPlay("animation.termite.death"));
      } else if (this.isInWaterOrBubble()) {
         return event.setAndContinue(RawAnimation.begin().thenLoop("animation.termite.scurrying"));
      } else if (this.isShiftKeyDown()) {
         return event.setAndContinue(RawAnimation.begin().thenLoop("animation.termite.grab"));
      } else {
         return !this.onGround()
            ? event.setAndContinue(RawAnimation.begin().thenLoop("animation.termite.flying"))
            : event.setAndContinue(RawAnimation.begin().thenLoop("animation.termite.idle"));
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
         return event.setAndContinue(RawAnimation.begin().thenPlay("animation.termite.attack"));
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
      if (this.deathTime == 10) {
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
      data.add(new AnimationController[]{new AnimationController(this, "attacking", 1, this::attackingPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "procedure", 1, this::procedurePredicate)});
   }

   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
   }
}
