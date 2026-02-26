package net.arphex.entity;

import net.arphex.init.ArphexModEntities;
import net.arphex.procedures.HasAttackTargetReturnProcedure;
import net.arphex.procedures.SpiderMatriarchEntityIsHurtProcedure;
import net.arphex.procedures.SpiderMatriarchOnEntityTickUpdateProcedure;
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
import net.minecraft.world.entity.ai.goal.ClimbOnTopOfPowderSnowGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
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

public class SpiderMatriarchEntity extends Monster implements GeoEntity {
   public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(SpiderMatriarchEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(SpiderMatriarchEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(SpiderMatriarchEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<Integer> DATA_lunge_time = SynchedEntityData.defineId(SpiderMatriarchEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<Integer> DATA_attack_trigger_time = SynchedEntityData.defineId(SpiderMatriarchEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<Integer> DATA_store_target_distance = SynchedEntityData.defineId(
      SpiderMatriarchEntity.class, EntityDataSerializers.INT
   );
   public static final EntityDataAccessor<Boolean> DATA_done_rot_clay = SynchedEntityData.defineId(SpiderMatriarchEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<Integer> DATA_eggs_grow = SynchedEntityData.defineId(SpiderMatriarchEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<Integer> DATA_time_since_landing_attack = SynchedEntityData.defineId(
      SpiderMatriarchEntity.class, EntityDataSerializers.INT
   );
   private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
   private boolean swinging;
   private boolean lastloop;
   private long lastSwing;
   public String animationprocedure = "empty";

   public SpiderMatriarchEntity(SpawnEntity packet, Level world) {
      this((EntityType<SpiderMatriarchEntity>)ArphexModEntities.SPIDER_MATRIARCH.get(), world);
   }

   public SpiderMatriarchEntity(EntityType<SpiderMatriarchEntity> type, Level world) {
      super(type, world);
      this.xpReward = 500;
      this.setNoAi(false);
      this.setMaxUpStep(3.0F);
      this.setPersistenceRequired();
   }

   protected void defineSynchedData() {
      super.defineSynchedData();
      this.entityData.define(SHOOT, false);
      this.entityData.define(ANIMATION, "undefined");
      this.entityData.define(TEXTURE, "wolfspider3egg");
      this.entityData.define(DATA_lunge_time, 0);
      this.entityData.define(DATA_attack_trigger_time, 0);
      this.entityData.define(DATA_store_target_distance, 0);
      this.entityData.define(DATA_done_rot_clay, false);
      this.entityData.define(DATA_eggs_grow, 900);
      this.entityData.define(DATA_time_since_landing_attack, 0);
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
      this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Player.class, false, false));
      this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false) {
         protected double getAttackReachSqr(LivingEntity entity) {
            return 36.0;
         }
      });
      this.targetSelector.addGoal(3, new HurtByTargetGoal(this, new Class[0]).setAlertOthers(new Class[0]));
      this.goalSelector.addGoal(4, new RandomStrollGoal(this, 1.0) {
         public boolean canUse() {
            double x = SpiderMatriarchEntity.this.getX();
            double y = SpiderMatriarchEntity.this.getY();
            double z = SpiderMatriarchEntity.this.getZ();
            Entity entity = SpiderMatriarchEntity.this;
            Level world = SpiderMatriarchEntity.this.level();
            return super.canUse() && HasAttackTargetReturnProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = SpiderMatriarchEntity.this.getX();
            double y = SpiderMatriarchEntity.this.getY();
            double z = SpiderMatriarchEntity.this.getZ();
            Entity entity = SpiderMatriarchEntity.this;
            Level world = SpiderMatriarchEntity.this.level();
            return super.canContinueToUse() && HasAttackTargetReturnProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(5, new ClimbOnTopOfPowderSnowGoal(this, this.level()));
      this.goalSelector.addGoal(6, new FloatGoal(this));
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
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.hurt"));
   }

   public SoundEvent getDeathSound() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.death"));
   }

   public boolean hurt(DamageSource source, float amount) {
      SpiderMatriarchEntityIsHurtProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
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
      } else if (source.is(DamageTypes.DRAGON_BREATH)) {
         return false;
      } else if (source.is(DamageTypes.WITHER)) {
         return false;
      } else {
         return source.is(DamageTypes.WITHER_SKULL) ? false : super.hurt(source, amount);
      }
   }

   public void addAdditionalSaveData(CompoundTag compound) {
      super.addAdditionalSaveData(compound);
      compound.putString("Texture", this.getTexture());
      compound.putInt("Datalunge_time", (Integer)this.entityData.get(DATA_lunge_time));
      compound.putInt("Dataattack_trigger_time", (Integer)this.entityData.get(DATA_attack_trigger_time));
      compound.putInt("Datastore_target_distance", (Integer)this.entityData.get(DATA_store_target_distance));
      compound.putBoolean("Datadone_rot_clay", (Boolean)this.entityData.get(DATA_done_rot_clay));
      compound.putInt("Dataeggs_grow", (Integer)this.entityData.get(DATA_eggs_grow));
      compound.putInt("Datatime_since_landing_attack", (Integer)this.entityData.get(DATA_time_since_landing_attack));
   }

   public void readAdditionalSaveData(CompoundTag compound) {
      super.readAdditionalSaveData(compound);
      if (compound.contains("Texture")) {
         this.setTexture(compound.getString("Texture"));
      }

      if (compound.contains("Datalunge_time")) {
         this.entityData.set(DATA_lunge_time, compound.getInt("Datalunge_time"));
      }

      if (compound.contains("Dataattack_trigger_time")) {
         this.entityData.set(DATA_attack_trigger_time, compound.getInt("Dataattack_trigger_time"));
      }

      if (compound.contains("Datastore_target_distance")) {
         this.entityData.set(DATA_store_target_distance, compound.getInt("Datastore_target_distance"));
      }

      if (compound.contains("Datadone_rot_clay")) {
         this.entityData.set(DATA_done_rot_clay, compound.getBoolean("Datadone_rot_clay"));
      }

      if (compound.contains("Dataeggs_grow")) {
         this.entityData.set(DATA_eggs_grow, compound.getInt("Dataeggs_grow"));
      }

      if (compound.contains("Datatime_since_landing_attack")) {
         this.entityData.set(DATA_time_since_landing_attack, compound.getInt("Datatime_since_landing_attack"));
      }
   }

   public void baseTick() {
      super.baseTick();
      SpiderMatriarchOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
      this.refreshDimensions();
   }

   public EntityDimensions getDimensions(Pose p_33597_) {
      return super.getDimensions(p_33597_).scale(1.99F);
   }

   public boolean isPushable() {
      return false;
   }

   protected void doPush(Entity entityIn) {
   }

   protected void pushEntities() {
   }

   public static void init() {
   }

   public static Builder createAttributes() {
      Builder builder = Mob.createMobAttributes();
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.28);
      builder = builder.add(Attributes.MAX_HEALTH, 350.0);
      builder = builder.add(Attributes.ARMOR, 10.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 25.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 200.0);
      builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
      return builder.add(Attributes.ATTACK_KNOCKBACK, 1.0);
   }

   private PlayState movementPredicate(AnimationState event) {
      if (this.animationprocedure.equals("empty")) {
         if (event.isMoving() || !(event.getLimbSwingAmount() > -0.15F) || !(event.getLimbSwingAmount() < 0.15F)) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("animation.spider_wolf.prowling"));
         } else if (this.isDeadOrDying()) {
            return event.setAndContinue(RawAnimation.begin().thenPlay("animation.spider_wolf.death"));
         } else {
            return this.isInWaterOrBubble()
               ? event.setAndContinue(RawAnimation.begin().thenLoop("animation.spider_wolf.prowling"))
               : event.setAndContinue(RawAnimation.begin().thenLoop("animation.spider_wolf.idle"));
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
         return event.setAndContinue(RawAnimation.begin().thenPlay("animation.spider_wolf.attack"));
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
      data.add(new AnimationController[]{new AnimationController(this, "movement", 19, this::movementPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "attacking", 19, this::attackingPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "procedure", 19, this::procedurePredicate)});
   }

   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
   }

   public void makeStuckInBlock(BlockState state, Vec3 motionMultiplier) {
      if (!state.is(Blocks.COBWEB)) {
         super.makeStuckInBlock(state, motionMultiplier);
      }
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
