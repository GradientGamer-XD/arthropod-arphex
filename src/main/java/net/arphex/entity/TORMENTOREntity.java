package net.arphex.entity;

import javax.annotation.Nullable;
import net.arphex.init.ArphexModEntities;
import net.arphex.procedures.AlwaysTrueProcedure;
import net.arphex.procedures.TORMENTOREntityDiesProcedure;
import net.arphex.procedures.TORMENTOREntityIsHurtProcedure;
import net.arphex.procedures.TORMENTOROnInitialEntitySpawnProcedure;
import net.arphex.procedures.TORMENTORThisEntityKillsAnotherOneProcedure;
import net.arphex.procedures.TormentorLookAroundProcedure;
import net.arphex.procedures.TranscendentalTormentorOnEntityTickUpdateProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.BossEvent.BossBarColor;
import net.minecraft.world.BossEvent.BossBarOverlay;
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
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
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

public class TORMENTOREntity extends Monster implements GeoEntity {
   public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(TORMENTOREntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(TORMENTOREntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(TORMENTOREntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<Integer> DATA_tormenttimer = SynchedEntityData.defineId(TORMENTOREntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<String> DATA_tormentcycle = SynchedEntityData.defineId(TORMENTOREntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<Integer> DATA_tormentswitch = SynchedEntityData.defineId(TORMENTOREntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<Integer> DATA_time_since_attacked = SynchedEntityData.defineId(TORMENTOREntity.class, EntityDataSerializers.INT);
   private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
   private boolean swinging;
   private boolean lastloop;
   private long lastSwing;
   public String animationprocedure = "empty";
   private final ServerBossEvent bossInfo = new ServerBossEvent(this.getDisplayName(), BossBarColor.RED, BossBarOverlay.NOTCHED_20);

   public TORMENTOREntity(SpawnEntity packet, Level world) {
      this((EntityType<TORMENTOREntity>)ArphexModEntities.TORMENTOR.get(), world);
   }

   public TORMENTOREntity(EntityType<TORMENTOREntity> type, Level world) {
      super(type, world);
      this.xpReward = 100000;
      this.setNoAi(false);
      this.setMaxUpStep(0.6F);
      this.setPersistenceRequired();
      this.moveControl = new FlyingMoveControl(this, 10, true);
   }

   protected void defineSynchedData() {
      super.defineSynchedData();
      this.entityData.define(SHOOT, false);
      this.entityData.define(ANIMATION, "undefined");
      this.entityData.define(TEXTURE, "invisible");
      this.entityData.define(DATA_tormenttimer, 0);
      this.entityData.define(DATA_tormentcycle, "none");
      this.entityData.define(DATA_tormentswitch, 0);
      this.entityData.define(DATA_time_since_attacked, 12000);
   }

   public void setTexture(String texture) {
      this.entityData.set(TEXTURE, texture);
   }

   public String getTexture() {
      return (String)this.entityData.get(TEXTURE);
   }

   protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
      return 5.0F;
   }

   public boolean canCollideWith(Entity entity) {
      return true;
   }

   public boolean canBeCollidedWith() {
      Level world = this.level();
      double x = this.getX();
      double y = this.getY();
      double z = this.getZ();
      return AlwaysTrueProcedure.execute();
   }

   public Packet<ClientGamePacketListener> getAddEntityPacket() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   protected PathNavigation createNavigation(Level world) {
      return new FlyingPathNavigation(this, world);
   }

   protected void registerGoals() {
      super.registerGoals();
      this.goalSelector.addGoal(1, new RandomLookAroundGoal(this) {
         public boolean canUse() {
            double x = TORMENTOREntity.this.getX();
            double y = TORMENTOREntity.this.getY();
            double z = TORMENTOREntity.this.getZ();
            Entity entity = TORMENTOREntity.this;
            Level world = TORMENTOREntity.this.level();
            return super.canUse() && TormentorLookAroundProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = TORMENTOREntity.this.getX();
            double y = TORMENTOREntity.this.getY();
            double z = TORMENTOREntity.this.getZ();
            Entity entity = TORMENTOREntity.this;
            Level world = TORMENTOREntity.this.level();
            return super.canContinueToUse() && TormentorLookAroundProcedure.execute(entity);
         }
      });
   }

   public MobType getMobType() {
      return MobType.UNDEFINED;
   }

   public boolean removeWhenFarAway(double distanceToClosestPlayer) {
      return false;
   }

   public SoundEvent getAmbientSound() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:heartbeats"));
   }

   public SoundEvent getHurtSound(DamageSource ds) {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:heartbeats"));
   }

   public SoundEvent getDeathSound() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
   }

   public boolean causeFallDamage(float l, float d, DamageSource source) {
      return false;
   }

   public boolean hurt(DamageSource source, float amount) {
      TORMENTOREntityIsHurtProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
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

   public void die(DamageSource source) {
      super.die(source);
      TORMENTOREntityDiesProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ());
   }

   public SpawnGroupData finalizeSpawn(
      ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag
   ) {
      SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
      TORMENTOROnInitialEntitySpawnProcedure.execute(world, this.getX(), this.getY(), this.getZ(), this);
      return retval;
   }

   public void addAdditionalSaveData(CompoundTag compound) {
      super.addAdditionalSaveData(compound);
      compound.putString("Texture", this.getTexture());
      compound.putInt("Datatormenttimer", (Integer)this.entityData.get(DATA_tormenttimer));
      compound.putString("Datatormentcycle", (String)this.entityData.get(DATA_tormentcycle));
      compound.putInt("Datatormentswitch", (Integer)this.entityData.get(DATA_tormentswitch));
      compound.putInt("Datatime_since_attacked", (Integer)this.entityData.get(DATA_time_since_attacked));
   }

   public void readAdditionalSaveData(CompoundTag compound) {
      super.readAdditionalSaveData(compound);
      if (compound.contains("Texture")) {
         this.setTexture(compound.getString("Texture"));
      }

      if (compound.contains("Datatormenttimer")) {
         this.entityData.set(DATA_tormenttimer, compound.getInt("Datatormenttimer"));
      }

      if (compound.contains("Datatormentcycle")) {
         this.entityData.set(DATA_tormentcycle, compound.getString("Datatormentcycle"));
      }

      if (compound.contains("Datatormentswitch")) {
         this.entityData.set(DATA_tormentswitch, compound.getInt("Datatormentswitch"));
      }

      if (compound.contains("Datatime_since_attacked")) {
         this.entityData.set(DATA_time_since_attacked, compound.getInt("Datatime_since_attacked"));
      }
   }

   public void awardKillScore(Entity entity, int score, DamageSource damageSource) {
      super.awardKillScore(entity, score, damageSource);
      TORMENTORThisEntityKillsAnotherOneProcedure.execute(this.level());
   }

   public void baseTick() {
      super.baseTick();
      TranscendentalTormentorOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
      this.refreshDimensions();
   }

   public EntityDimensions getDimensions(Pose p_33597_) {
      return super.getDimensions(p_33597_).scale(1.0F);
   }

   public boolean isPushable() {
      return false;
   }

   protected void doPush(Entity entityIn) {
   }

   protected void pushEntities() {
   }

   public boolean canChangeDimensions() {
      return false;
   }

   public void startSeenByPlayer(ServerPlayer player) {
      super.startSeenByPlayer(player);
      this.bossInfo.addPlayer(player);
   }

   public void stopSeenByPlayer(ServerPlayer player) {
      super.stopSeenByPlayer(player);
      this.bossInfo.removePlayer(player);
   }

   public void customServerAiStep() {
      super.customServerAiStep();
      this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
      this.bossInfo.setName(this.getDisplayName());
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
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
      builder = builder.add(Attributes.MAX_HEALTH, 1024.0);
      builder = builder.add(Attributes.ARMOR, 100.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 70.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 500.0);
      builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 10.0);
      builder = builder.add(Attributes.ATTACK_KNOCKBACK, 20.0);
      return builder.add(Attributes.FLYING_SPEED, 0.3);
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
      if (this.deathTime == 1300) {
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
      data.add(new AnimationController[]{new AnimationController(this, "movement", 60, this::movementPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "procedure", 60, this::procedurePredicate)});
   }

   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
   }
}
