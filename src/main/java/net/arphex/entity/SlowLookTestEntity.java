package net.arphex.entity;

import javax.annotation.Nullable;
import net.arphex.init.ArphexModEntities;
import net.arphex.procedures.SlowLookTestOnEntityTickUpdateProcedure;
import net.arphex.procedures.SlowLookTestOnInitialEntitySpawnProcedure;
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
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
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

public class SlowLookTestEntity extends Monster implements GeoEntity {
   public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(SlowLookTestEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(SlowLookTestEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(SlowLookTestEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<Boolean> DATA_alt_pitch_yaw = SynchedEntityData.defineId(SlowLookTestEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<Integer> DATA_alt_pitch_yawslow = SynchedEntityData.defineId(SlowLookTestEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<Integer> DATA_laser_switch_time = SynchedEntityData.defineId(SlowLookTestEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<Integer> DATA_lifespan = SynchedEntityData.defineId(SlowLookTestEntity.class, EntityDataSerializers.INT);
   private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
   private boolean swinging;
   private boolean lastloop;
   private long lastSwing;
   public String animationprocedure = "empty";

   public SlowLookTestEntity(SpawnEntity packet, Level world) {
      this((EntityType<SlowLookTestEntity>)ArphexModEntities.SLOW_LOOK_TEST.get(), world);
   }

   public SlowLookTestEntity(EntityType<SlowLookTestEntity> type, Level world) {
      super(type, world);
      this.xpReward = 0;
      this.setNoAi(true);
      this.setMaxUpStep(0.6F);
      this.setPersistenceRequired();
   }

   protected void defineSynchedData() {
      super.defineSynchedData();
      this.entityData.define(SHOOT, false);
      this.entityData.define(ANIMATION, "undefined");
      this.entityData.define(TEXTURE, "invisible");
      this.entityData.define(DATA_alt_pitch_yaw, false);
      this.entityData.define(DATA_alt_pitch_yawslow, 0);
      this.entityData.define(DATA_laser_switch_time, 0);
      this.entityData.define(DATA_lifespan, 0);
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

   public MobType getMobType() {
      return MobType.UNDEFINED;
   }

   public boolean removeWhenFarAway(double distanceToClosestPlayer) {
      return false;
   }

   public SoundEvent getHurtSound(DamageSource ds) {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:silence"));
   }

   public SoundEvent getDeathSound() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:silence"));
   }

   public boolean hurt(DamageSource source, float amount) {
      if (source.is(DamageTypes.IN_FIRE)) {
         return false;
      } else if (source.getDirectEntity() instanceof AbstractArrow) {
         return false;
      } else if (source.getDirectEntity() instanceof Player) {
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
      } else if (source.is(DamageTypes.TRIDENT)) {
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

   public SpawnGroupData finalizeSpawn(
      ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag
   ) {
      SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
      SlowLookTestOnInitialEntitySpawnProcedure.execute(this);
      return retval;
   }

   public void addAdditionalSaveData(CompoundTag compound) {
      super.addAdditionalSaveData(compound);
      compound.putString("Texture", this.getTexture());
      compound.putBoolean("Dataalt_pitch_yaw", (Boolean)this.entityData.get(DATA_alt_pitch_yaw));
      compound.putInt("Dataalt_pitch_yawslow", (Integer)this.entityData.get(DATA_alt_pitch_yawslow));
      compound.putInt("Datalaser_switch_time", (Integer)this.entityData.get(DATA_laser_switch_time));
      compound.putInt("Datalifespan", (Integer)this.entityData.get(DATA_lifespan));
   }

   public void readAdditionalSaveData(CompoundTag compound) {
      super.readAdditionalSaveData(compound);
      if (compound.contains("Texture")) {
         this.setTexture(compound.getString("Texture"));
      }

      if (compound.contains("Dataalt_pitch_yaw")) {
         this.entityData.set(DATA_alt_pitch_yaw, compound.getBoolean("Dataalt_pitch_yaw"));
      }

      if (compound.contains("Dataalt_pitch_yawslow")) {
         this.entityData.set(DATA_alt_pitch_yawslow, compound.getInt("Dataalt_pitch_yawslow"));
      }

      if (compound.contains("Datalaser_switch_time")) {
         this.entityData.set(DATA_laser_switch_time, compound.getInt("Datalaser_switch_time"));
      }

      if (compound.contains("Datalifespan")) {
         this.entityData.set(DATA_lifespan, compound.getInt("Datalifespan"));
      }
   }

   public void baseTick() {
      super.baseTick();
      SlowLookTestOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
      this.refreshDimensions();
   }

   public EntityDimensions getDimensions(Pose p_33597_) {
      return super.getDimensions(p_33597_).scale(0.5F);
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
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
      builder = builder.add(Attributes.MAX_HEALTH, 1024.0);
      builder = builder.add(Attributes.ARMOR, 100.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 0.0);
      return builder.add(Attributes.FOLLOW_RANGE, 16.0);
   }

   private PlayState movementPredicate(AnimationState event) {
      return this.animationprocedure.equals("empty") ? event.setAndContinue(RawAnimation.begin().thenLoop("animation.maggot.idle")) : PlayState.STOP;
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
      data.add(new AnimationController[]{new AnimationController(this, "movement", 4, this::movementPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "procedure", 4, this::procedurePredicate)});
   }

   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
   }
}
