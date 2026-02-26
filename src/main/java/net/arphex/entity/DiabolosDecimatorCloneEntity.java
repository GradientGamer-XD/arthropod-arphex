package net.arphex.entity;

import net.arphex.init.ArphexModEntities;
import net.arphex.procedures.DiabolosDecimatorCloneOnEntityTickUpdateProcedure;
import net.arphex.procedures.DiabolosDecimatorEntityIsHurtProcedure;
import net.arphex.procedures.HasAttackTargetReturnProcedure;
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
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.ClimbOnTopOfPowderSnowGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.level.Level;
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

public class DiabolosDecimatorCloneEntity extends Monster implements GeoEntity {
   public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(DiabolosDecimatorCloneEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(DiabolosDecimatorCloneEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(DiabolosDecimatorCloneEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<Integer> DATA_lunge_time = SynchedEntityData.defineId(DiabolosDecimatorCloneEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<Integer> DATA_attack_trigger_time = SynchedEntityData.defineId(
      DiabolosDecimatorCloneEntity.class, EntityDataSerializers.INT
   );
   public static final EntityDataAccessor<Integer> DATA_store_target_distance = SynchedEntityData.defineId(
      DiabolosDecimatorCloneEntity.class, EntityDataSerializers.INT
   );
   public static final EntityDataAccessor<Integer> DATA_time_since_landing_attack = SynchedEntityData.defineId(
      DiabolosDecimatorCloneEntity.class, EntityDataSerializers.INT
   );
   public static final EntityDataAccessor<String> DATA_shuffle = SynchedEntityData.defineId(DiabolosDecimatorCloneEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<Integer> DATA_shuffle_number = SynchedEntityData.defineId(
      DiabolosDecimatorCloneEntity.class, EntityDataSerializers.INT
   );
   public static final EntityDataAccessor<Integer> DATA_attack_switch_time = SynchedEntityData.defineId(
      DiabolosDecimatorCloneEntity.class, EntityDataSerializers.INT
   );
   public static final EntityDataAccessor<Integer> DATA_current_final = SynchedEntityData.defineId(
      DiabolosDecimatorCloneEntity.class, EntityDataSerializers.INT
   );
   public static final EntityDataAccessor<Integer> DATA_flash = SynchedEntityData.defineId(DiabolosDecimatorCloneEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<Boolean> DATA_primed = SynchedEntityData.defineId(DiabolosDecimatorCloneEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<Integer> DATA_float_time = SynchedEntityData.defineId(DiabolosDecimatorCloneEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<Boolean> DATA_switch_updown = SynchedEntityData.defineId(
      DiabolosDecimatorCloneEntity.class, EntityDataSerializers.BOOLEAN
   );
   public static final EntityDataAccessor<Integer> DATA_size_switch = SynchedEntityData.defineId(DiabolosDecimatorCloneEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<Integer> DATA_size_num = SynchedEntityData.defineId(DiabolosDecimatorCloneEntity.class, EntityDataSerializers.INT);
   private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
   private boolean swinging;
   private boolean lastloop;
   private long lastSwing;
   public String animationprocedure = "empty";

   public DiabolosDecimatorCloneEntity(SpawnEntity packet, Level world) {
      this((EntityType<DiabolosDecimatorCloneEntity>)ArphexModEntities.DIABOLOS_DECIMATOR_CLONE.get(), world);
   }

   public DiabolosDecimatorCloneEntity(EntityType<DiabolosDecimatorCloneEntity> type, Level world) {
      super(type, world);
      this.xpReward = 500;
      this.setNoAi(false);
      this.setMaxUpStep(3.0F);
      this.setPersistenceRequired();
      this.moveControl = new FlyingMoveControl(this, 10, true);
   }

   protected void defineSynchedData() {
      super.defineSynchedData();
      this.entityData.define(SHOOT, false);
      this.entityData.define(ANIMATION, "undefined");
      this.entityData.define(TEXTURE, "diabolos_decimator_glow");
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
      this.entityData.define(DATA_switch_updown, false);
      this.entityData.define(DATA_size_switch, 0);
      this.entityData.define(DATA_size_num, 0);
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
      this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, true) {
         protected double getAttackReachSqr(LivingEntity entity) {
            return 81.0;
         }
      });
      this.targetSelector.addGoal(3, new HurtByTargetGoal(this, new Class[0]).setAlertOthers(new Class[0]));
      this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.8, 20) {
         protected Vec3 getPosition() {
            RandomSource random = DiabolosDecimatorCloneEntity.this.getRandom();
            double dir_x = DiabolosDecimatorCloneEntity.this.getX() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double dir_y = DiabolosDecimatorCloneEntity.this.getY() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double dir_z = DiabolosDecimatorCloneEntity.this.getZ() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            return new Vec3(dir_x, dir_y, dir_z);
         }

         public boolean canUse() {
            double x = DiabolosDecimatorCloneEntity.this.getX();
            double y = DiabolosDecimatorCloneEntity.this.getY();
            double z = DiabolosDecimatorCloneEntity.this.getZ();
            Entity entity = DiabolosDecimatorCloneEntity.this;
            Level world = DiabolosDecimatorCloneEntity.this.level();
            return super.canUse() && HasAttackTargetReturnProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = DiabolosDecimatorCloneEntity.this.getX();
            double y = DiabolosDecimatorCloneEntity.this.getY();
            double z = DiabolosDecimatorCloneEntity.this.getZ();
            Entity entity = DiabolosDecimatorCloneEntity.this;
            Level world = DiabolosDecimatorCloneEntity.this.level();
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

   public SoundEvent getHurtSound(DamageSource ds) {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.hurt"));
   }

   public SoundEvent getDeathSound() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.death"));
   }

   public boolean causeFallDamage(float l, float d, DamageSource source) {
      return false;
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
      compound.putBoolean("Dataswitch_updown", (Boolean)this.entityData.get(DATA_switch_updown));
      compound.putInt("Datasize_switch", (Integer)this.entityData.get(DATA_size_switch));
      compound.putInt("Datasize_num", (Integer)this.entityData.get(DATA_size_num));
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

      if (compound.contains("Dataswitch_updown")) {
         this.entityData.set(DATA_switch_updown, compound.getBoolean("Dataswitch_updown"));
      }

      if (compound.contains("Datasize_switch")) {
         this.entityData.set(DATA_size_switch, compound.getInt("Datasize_switch"));
      }

      if (compound.contains("Datasize_num")) {
         this.entityData.set(DATA_size_num, compound.getInt("Datasize_num"));
      }
   }

   public void baseTick() {
      super.baseTick();
      DiabolosDecimatorCloneOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
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
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.28);
      builder = builder.add(Attributes.MAX_HEALTH, 750.0);
      builder = builder.add(Attributes.ARMOR, 30.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 150.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 200.0);
      builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
      builder = builder.add(Attributes.ATTACK_KNOCKBACK, 1.0);
      return builder.add(Attributes.FLYING_SPEED, 0.28);
   }

   private PlayState movementPredicate(AnimationState event) {
      if (this.animationprocedure.equals("empty")) {
         return !this.onGround()
            ? event.setAndContinue(RawAnimation.begin().thenLoop("animation.diabolos.curl"))
            : event.setAndContinue(RawAnimation.begin().thenLoop("animation.diabolos.curl"));
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
      data.add(new AnimationController[]{new AnimationController(this, "movement", 80, this::movementPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "procedure", 80, this::procedurePredicate)});
   }

   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
   }
}
