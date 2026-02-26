package net.arphex.entity;

import javax.annotation.Nullable;
import net.arphex.init.ArphexModEntities;
import net.arphex.procedures.DiabolosDecimatorEntityIsHurtProcedure;
import net.arphex.procedures.DiabolosDiesProcedure;
import net.arphex.procedures.DiabolosKillsEntityProcedure;
import net.arphex.procedures.DiabolosSpawnProcedure;
import net.arphex.procedures.DiabolosTickProcedure;
import net.arphex.procedures.GiantModeDiabolosProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
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
import net.minecraft.world.entity.ai.goal.ClimbOnTopOfPowderSnowGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
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

public class DiabolosDecimatorEntity extends Monster implements GeoEntity {
   public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(DiabolosDecimatorEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(DiabolosDecimatorEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(DiabolosDecimatorEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<Integer> DATA_lunge_time = SynchedEntityData.defineId(DiabolosDecimatorEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<Integer> DATA_attack_trigger_time = SynchedEntityData.defineId(
      DiabolosDecimatorEntity.class, EntityDataSerializers.INT
   );
   public static final EntityDataAccessor<Integer> DATA_store_target_distance = SynchedEntityData.defineId(
      DiabolosDecimatorEntity.class, EntityDataSerializers.INT
   );
   public static final EntityDataAccessor<Integer> DATA_time_since_landing_attack = SynchedEntityData.defineId(
      DiabolosDecimatorEntity.class, EntityDataSerializers.INT
   );
   public static final EntityDataAccessor<String> DATA_shuffle = SynchedEntityData.defineId(DiabolosDecimatorEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<Integer> DATA_shuffle_number = SynchedEntityData.defineId(DiabolosDecimatorEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<Integer> DATA_attack_switch_time = SynchedEntityData.defineId(
      DiabolosDecimatorEntity.class, EntityDataSerializers.INT
   );
   public static final EntityDataAccessor<Integer> DATA_current_final = SynchedEntityData.defineId(DiabolosDecimatorEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<Integer> DATA_flash = SynchedEntityData.defineId(DiabolosDecimatorEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<Boolean> DATA_primed = SynchedEntityData.defineId(DiabolosDecimatorEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<Integer> DATA_float_time = SynchedEntityData.defineId(DiabolosDecimatorEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<Integer> DATA_size_num = SynchedEntityData.defineId(DiabolosDecimatorEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<Integer> DATA_animation_limit = SynchedEntityData.defineId(DiabolosDecimatorEntity.class, EntityDataSerializers.INT);
   private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
   private boolean swinging;
   private boolean lastloop;
   private long lastSwing;
   public String animationprocedure = "empty";

   public DiabolosDecimatorEntity(SpawnEntity packet, Level world) {
      this((EntityType<DiabolosDecimatorEntity>)ArphexModEntities.DIABOLOS_DECIMATOR.get(), world);
   }

   public DiabolosDecimatorEntity(EntityType<DiabolosDecimatorEntity> type, Level world) {
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
      this.entityData.define(TEXTURE, "diabolos_decimator");
      this.entityData.define(DATA_lunge_time, 0);
      this.entityData.define(DATA_attack_trigger_time, 0);
      this.entityData.define(DATA_store_target_distance, 0);
      this.entityData.define(DATA_time_since_landing_attack, 0);
      this.entityData.define(DATA_shuffle, "");
      this.entityData.define(DATA_shuffle_number, 0);
      this.entityData.define(DATA_attack_switch_time, 0);
      this.entityData.define(DATA_current_final, 0);
      this.entityData.define(DATA_flash, 0);
      this.entityData.define(DATA_primed, false);
      this.entityData.define(DATA_float_time, 0);
      this.entityData.define(DATA_size_num, 1000);
      this.entityData.define(DATA_animation_limit, 0);
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
      this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, true) {
         protected double getAttackReachSqr(LivingEntity entity) {
            return 225.0;
         }

         public boolean canUse() {
            double x = DiabolosDecimatorEntity.this.getX();
            double y = DiabolosDecimatorEntity.this.getY();
            double z = DiabolosDecimatorEntity.this.getZ();
            Entity entity = DiabolosDecimatorEntity.this;
            Level world = DiabolosDecimatorEntity.this.level();
            return super.canUse() && GiantModeDiabolosProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = DiabolosDecimatorEntity.this.getX();
            double y = DiabolosDecimatorEntity.this.getY();
            double z = DiabolosDecimatorEntity.this.getZ();
            Entity entity = DiabolosDecimatorEntity.this;
            Level world = DiabolosDecimatorEntity.this.level();
            return super.canContinueToUse() && GiantModeDiabolosProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2, true) {
         protected double getAttackReachSqr(LivingEntity entity) {
            return 64.0;
         }
      });
      this.targetSelector.addGoal(4, new HurtByTargetGoal(this, new Class[0]).setAlertOthers(new Class[0]));
      this.goalSelector.addGoal(5, new ClimbOnTopOfPowderSnowGoal(this, this.level()));
      this.goalSelector.addGoal(6, new FloatGoal(this));
   }

   public MobType getMobType() {
      return MobType.ARTHROPOD;
   }

   public boolean removeWhenFarAway(double distanceToClosestPlayer) {
      return false;
   }

   public SoundEvent getHurtSound(DamageSource ds) {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.hurt"));
   }

   public SoundEvent getDeathSound() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.death"));
   }

   public boolean hurt(DamageSource source, float amount) {
      DiabolosDecimatorEntityIsHurtProcedure.execute(this);
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
      } else if (source.is(DamageTypes.FALLING_ANVIL)) {
         return false;
      } else if (source.is(DamageTypes.DRAGON_BREATH)) {
         return false;
      } else if (source.is(DamageTypes.WITHER)) {
         return false;
      } else {
         return source.is(DamageTypes.WITHER_SKULL) ? false : super.hurt(source, amount);
      }
   }

   public void die(DamageSource source) {
      super.die(source);
      DiabolosDiesProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ());
   }

   public SpawnGroupData finalizeSpawn(
      ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag
   ) {
      SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
      DiabolosSpawnProcedure.execute(world, this.getX(), this.getY(), this.getZ(), this);
      return retval;
   }

   public void addAdditionalSaveData(CompoundTag compound) {
      super.addAdditionalSaveData(compound);
      compound.putString("Texture", this.getTexture());
      compound.putInt("Datalunge_time", (Integer)this.entityData.get(DATA_lunge_time));
      compound.putInt("Dataattack_trigger_time", (Integer)this.entityData.get(DATA_attack_trigger_time));
      compound.putInt("Datastore_target_distance", (Integer)this.entityData.get(DATA_store_target_distance));
      compound.putInt("Datatime_since_landing_attack", (Integer)this.entityData.get(DATA_time_since_landing_attack));
      compound.putString("Datashuffle", (String)this.entityData.get(DATA_shuffle));
      compound.putInt("Datashuffle_number", (Integer)this.entityData.get(DATA_shuffle_number));
      compound.putInt("Dataattack_switch_time", (Integer)this.entityData.get(DATA_attack_switch_time));
      compound.putInt("Datacurrent_final", (Integer)this.entityData.get(DATA_current_final));
      compound.putInt("Dataflash", (Integer)this.entityData.get(DATA_flash));
      compound.putBoolean("Dataprimed", (Boolean)this.entityData.get(DATA_primed));
      compound.putInt("Datafloat_time", (Integer)this.entityData.get(DATA_float_time));
      compound.putInt("Datasize_num", (Integer)this.entityData.get(DATA_size_num));
      compound.putInt("Dataanimation_limit", (Integer)this.entityData.get(DATA_animation_limit));
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

      if (compound.contains("Datatime_since_landing_attack")) {
         this.entityData.set(DATA_time_since_landing_attack, compound.getInt("Datatime_since_landing_attack"));
      }

      if (compound.contains("Datashuffle")) {
         this.entityData.set(DATA_shuffle, compound.getString("Datashuffle"));
      }

      if (compound.contains("Datashuffle_number")) {
         this.entityData.set(DATA_shuffle_number, compound.getInt("Datashuffle_number"));
      }

      if (compound.contains("Dataattack_switch_time")) {
         this.entityData.set(DATA_attack_switch_time, compound.getInt("Dataattack_switch_time"));
      }

      if (compound.contains("Datacurrent_final")) {
         this.entityData.set(DATA_current_final, compound.getInt("Datacurrent_final"));
      }

      if (compound.contains("Dataflash")) {
         this.entityData.set(DATA_flash, compound.getInt("Dataflash"));
      }

      if (compound.contains("Dataprimed")) {
         this.entityData.set(DATA_primed, compound.getBoolean("Dataprimed"));
      }

      if (compound.contains("Datafloat_time")) {
         this.entityData.set(DATA_float_time, compound.getInt("Datafloat_time"));
      }

      if (compound.contains("Datasize_num")) {
         this.entityData.set(DATA_size_num, compound.getInt("Datasize_num"));
      }

      if (compound.contains("Dataanimation_limit")) {
         this.entityData.set(DATA_animation_limit, compound.getInt("Dataanimation_limit"));
      }
   }

   public void awardKillScore(Entity entity, int score, DamageSource damageSource) {
      super.awardKillScore(entity, score, damageSource);
      DiabolosKillsEntityProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), entity);
   }

   public void baseTick() {
      super.baseTick();
      DiabolosTickProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
      this.refreshDimensions();
   }

   public EntityDimensions getDimensions(Pose p_33597_) {
      return super.getDimensions(p_33597_).scale(1.49F);
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
      builder = builder.add(Attributes.MAX_HEALTH, 750.0);
      builder = builder.add(Attributes.ARMOR, 30.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 110.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 250.0);
      builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
      return builder.add(Attributes.ATTACK_KNOCKBACK, 1.0);
   }

   private PlayState movementPredicate(AnimationState event) {
      if (this.animationprocedure.equals("empty")) {
         return this.isShiftKeyDown()
            ? event.setAndContinue(RawAnimation.begin().thenLoop("animation.diabolos.curl"))
            : event.setAndContinue(RawAnimation.begin().thenLoop("animation.diabolos.idle"));
      } else {
         return PlayState.STOP;
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
      if (this.deathTime == 200) {
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
      data.add(new AnimationController[]{new AnimationController(this, "movement", 30, this::movementPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "procedure", 30, this::procedurePredicate)});
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
