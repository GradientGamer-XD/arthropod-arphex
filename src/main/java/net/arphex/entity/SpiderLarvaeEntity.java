package net.arphex.entity;

import javax.annotation.Nullable;
import net.arphex.init.ArphexModEntities;
import net.arphex.procedures.ArPhExSpawnConfigProcedure;
import net.arphex.procedures.NonShinyProcedure;
import net.arphex.procedures.SpiderLarvaeEntityDiesProcedure;
import net.arphex.procedures.SpiderLarvaeEntityIsHurtProcedure;
import net.arphex.procedures.SpiderLarvaeOnEntityTickUpdateProcedure;
import net.arphex.procedures.SpiderLarvaeOnInitialEntitySpawnProcedure;
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
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.SpawnPlacements.Type;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveBackToVillageGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraftforge.common.DungeonHooks;
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

public class SpiderLarvaeEntity extends Spider implements GeoEntity {
   public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(SpiderLarvaeEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(SpiderLarvaeEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(SpiderLarvaeEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<Boolean> DATA_shiny = SynchedEntityData.defineId(SpiderLarvaeEntity.class, EntityDataSerializers.BOOLEAN);
   private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
   private boolean swinging;
   private boolean lastloop;
   private long lastSwing;
   public String animationprocedure = "empty";

   public SpiderLarvaeEntity(SpawnEntity packet, Level world) {
      this((EntityType<SpiderLarvaeEntity>)ArphexModEntities.SPIDER_LARVAE.get(), world);
   }

   public SpiderLarvaeEntity(EntityType<SpiderLarvaeEntity> type, Level world) {
      super(type, world);
      this.xpReward = 1;
      this.setNoAi(false);
      this.setMaxUpStep(0.6F);
   }

   protected void defineSynchedData() {
      super.defineSynchedData();
      this.entityData.define(SHOOT, false);
      this.entityData.define(ANIMATION, "undefined");
      this.entityData.define(TEXTURE, "spiderlarvae");
      this.entityData.define(DATA_shiny, false);
   }

   public void setTexture(String texture) {
      this.entityData.set(TEXTURE, texture);
   }

   public String getTexture() {
      return (String)this.entityData.get(TEXTURE);
   }

   protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
      return 0.6F;
   }

   public Packet<ClientGamePacketListener> getAddEntityPacket() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   protected void registerGoals() {
      super.registerGoals();
      this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Player.class, true, true) {
         public boolean canUse() {
            double x = SpiderLarvaeEntity.this.getX();
            double y = SpiderLarvaeEntity.this.getY();
            double z = SpiderLarvaeEntity.this.getZ();
            Entity entity = SpiderLarvaeEntity.this;
            Level world = SpiderLarvaeEntity.this.level();
            return super.canUse() && NonShinyProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = SpiderLarvaeEntity.this.getX();
            double y = SpiderLarvaeEntity.this.getY();
            double z = SpiderLarvaeEntity.this.getZ();
            Entity entity = SpiderLarvaeEntity.this;
            Level world = SpiderLarvaeEntity.this.level();
            return super.canContinueToUse() && NonShinyProcedure.execute(entity);
         }
      });
      this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, FlyFestererEntity.class, true, true));
      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, MosquitoMorbidityEntity.class, true, true));
      this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, Bee.class, true, true));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, Bat.class, true, true));
      this.goalSelector.addGoal(6, new MeleeAttackGoal(this, 1.2, false) {
         protected double getAttackReachSqr(LivingEntity entity) {
            return 0.64;
         }
      });
      this.targetSelector.addGoal(7, new HurtByTargetGoal(this, new Class[0]).setAlertOthers(new Class[0]));
      this.goalSelector.addGoal(8, new LeapAtTargetGoal(this, 0.5F));
      this.goalSelector.addGoal(9, new MoveBackToVillageGoal(this, 0.6, false));
      this.goalSelector.addGoal(10, new RandomStrollGoal(this, 1.3));
      this.goalSelector.addGoal(11, new RandomLookAroundGoal(this));
      this.goalSelector.addGoal(12, new FloatGoal(this));
   }

   public MobType getMobType() {
      return MobType.ARTHROPOD;
   }

   public SoundEvent getAmbientSound() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:creepy_arthropod_tiny"));
   }

   public SoundEvent getHurtSound(DamageSource ds) {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.hurt"));
   }

   public SoundEvent getDeathSound() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.death"));
   }

   public boolean hurt(DamageSource source, float amount) {
      SpiderLarvaeEntityIsHurtProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
      if (source.getDirectEntity() instanceof ThrownPotion || source.getDirectEntity() instanceof AreaEffectCloud) {
         return false;
      } else if (source.is(DamageTypes.FALL)) {
         return false;
      } else if (source.is(DamageTypes.CACTUS)) {
         return false;
      } else if (source.is(DamageTypes.LIGHTNING_BOLT)) {
         return false;
      } else if (source.is(DamageTypes.WITHER)) {
         return false;
      } else {
         return source.is(DamageTypes.WITHER_SKULL) ? false : super.hurt(source, amount);
      }
   }

   public void die(DamageSource source) {
      super.die(source);
      SpiderLarvaeEntityDiesProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
   }

   public SpawnGroupData finalizeSpawn(
      ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag
   ) {
      SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
      SpiderLarvaeOnInitialEntitySpawnProcedure.execute(world, this.getX(), this.getY(), this.getZ(), this);
      return retval;
   }

   public void addAdditionalSaveData(CompoundTag compound) {
      super.addAdditionalSaveData(compound);
      compound.putString("Texture", this.getTexture());
      compound.putBoolean("Datashiny", (Boolean)this.entityData.get(DATA_shiny));
   }

   public void readAdditionalSaveData(CompoundTag compound) {
      super.readAdditionalSaveData(compound);
      if (compound.contains("Texture")) {
         this.setTexture(compound.getString("Texture"));
      }

      if (compound.contains("Datashiny")) {
         this.entityData.set(DATA_shiny, compound.getBoolean("Datashiny"));
      }
   }

   public void baseTick() {
      super.baseTick();
      SpiderLarvaeOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
      this.refreshDimensions();
   }

   public EntityDimensions getDimensions(Pose p_33597_) {
      return super.getDimensions(p_33597_).scale(0.8F);
   }

   public void aiStep() {
      super.aiStep();
      this.updateSwingTime();
   }

   public static void init() {
      SpawnPlacements.register(
         (EntityType)ArphexModEntities.SPIDER_LARVAE.get(), Type.ON_GROUND, Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();
            return ArPhExSpawnConfigProcedure.execute(world, (double)x, (double)y, (double)z);
         }
      );
      DungeonHooks.addDungeonMob((EntityType)ArphexModEntities.SPIDER_LARVAE.get(), 180);
   }

   public static Builder createAttributes() {
      Builder builder = Mob.createMobAttributes();
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.25);
      builder = builder.add(Attributes.MAX_HEALTH, 3.0);
      builder = builder.add(Attributes.ARMOR, 0.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 1.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 12.0);
      builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 100.0);
      return builder.add(Attributes.ATTACK_KNOCKBACK, 0.1);
   }

   private PlayState movementPredicate(AnimationState event) {
      if (this.animationprocedure.equals("empty")) {
         if (event.isMoving() || !(event.getLimbSwingAmount() > -0.15F) || !(event.getLimbSwingAmount() < 0.15F)) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("animation.spiderlarvae.scurrying"));
         } else if (this.isDeadOrDying()) {
            return event.setAndContinue(RawAnimation.begin().thenPlay("animation.spiderlarvae.death"));
         } else if (this.isInWaterOrBubble()) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("animation.spiderlarvae.idle"));
         } else if (this.isShiftKeyDown()) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("animation.spiderlarvae.grab"));
         } else {
            return this.isSprinting()
               ? event.setAndContinue(RawAnimation.begin().thenLoop("animation.spiderlarvae.ceiling"))
               : event.setAndContinue(RawAnimation.begin().thenLoop("animation.spiderlarvae.idle"));
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
         return event.setAndContinue(RawAnimation.begin().thenPlay("animation.spiderlarvae.aggressive"));
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
      if (this.deathTime == 30) {
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
