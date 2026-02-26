package net.arphex.entity;

import javax.annotation.Nullable;
import net.arphex.init.ArphexModEntities;
import net.arphex.procedures.BossDeathProcedure;
import net.arphex.procedures.ConstrictingUpwardsProcedure;
import net.arphex.procedures.DraconicTickProcedure;
import net.arphex.procedures.DraconicVoidlasherKillsAnotherEntityProcedure;
import net.arphex.procedures.VoidlasherDiesProcedure;
import net.arphex.procedures.VoidlasherHurtProcedure;
import net.arphex.procedures.VoidlasherNaturalSpawnProcedure;
import net.arphex.procedures.VoidlasherSpawnProcedure;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.entity.ai.goal.BreathAirGoal;
import net.minecraft.world.entity.ai.goal.ClimbOnTopOfPowderSnowGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowMobGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.RemoveBlockGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap.Types;
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

public class SpiderMothDwellerEntity extends Monster implements GeoEntity {
   public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(SpiderMothDwellerEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(SpiderMothDwellerEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(SpiderMothDwellerEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> DATA_currentattack = SynchedEntityData.defineId(SpiderMothDwellerEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<Integer> DATA_attacktimer = SynchedEntityData.defineId(SpiderMothDwellerEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<Boolean> DATA_primed = SynchedEntityData.defineId(SpiderMothDwellerEntity.class, EntityDataSerializers.BOOLEAN);
   private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
   private boolean swinging;
   private boolean lastloop;
   private long lastSwing;
   public String animationprocedure = "empty";

   public SpiderMothDwellerEntity(SpawnEntity packet, Level world) {
      this((EntityType<SpiderMothDwellerEntity>)ArphexModEntities.DRACONIC_VOIDLASHER.get(), world);
   }

   public SpiderMothDwellerEntity(EntityType<SpiderMothDwellerEntity> type, Level world) {
      super(type, world);
      this.xpReward = 600;
      this.setNoAi(false);
      this.setMaxUpStep(0.6F);
      this.setPersistenceRequired();
   }

   protected void defineSynchedData() {
      super.defineSynchedData();
      this.entityData.define(SHOOT, false);
      this.entityData.define(ANIMATION, "undefined");
      this.entityData.define(TEXTURE, "draconicvoidlasher");
      this.entityData.define(DATA_currentattack, "none");
      this.entityData.define(DATA_attacktimer, 0);
      this.entityData.define(DATA_primed, false);
   }

   public void setTexture(String texture) {
      this.entityData.set(TEXTURE, texture);
   }

   public String getTexture() {
      return (String)this.entityData.get(TEXTURE);
   }

   protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
      return 3.0F;
   }

   public Packet<ClientGamePacketListener> getAddEntityPacket() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   protected void registerGoals() {
      super.registerGoals();
      this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Player.class, false, false));
      this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0, true) {
         protected double getAttackReachSqr(LivingEntity entity) {
            return 16.0;
         }
      });
      this.targetSelector.addGoal(3, new HurtByTargetGoal(this, new Class[0]).setAlertOthers(new Class[0]));
      this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 127.0F) {
         public boolean canUse() {
            double x = SpiderMothDwellerEntity.this.getX();
            double y = SpiderMothDwellerEntity.this.getY();
            double z = SpiderMothDwellerEntity.this.getZ();
            Entity entity = SpiderMothDwellerEntity.this;
            Level world = SpiderMothDwellerEntity.this.level();
            return super.canUse() && ConstrictingUpwardsProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = SpiderMothDwellerEntity.this.getX();
            double y = SpiderMothDwellerEntity.this.getY();
            double z = SpiderMothDwellerEntity.this.getZ();
            Entity entity = SpiderMothDwellerEntity.this;
            Level world = SpiderMothDwellerEntity.this.level();
            return super.canContinueToUse() && ConstrictingUpwardsProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(5, new RemoveBlockGoal(Blocks.CHORUS_PLANT, this, 1.0, 5));
      this.goalSelector.addGoal(6, new RandomStrollGoal(this, 1.0) {
         public boolean canUse() {
            double x = SpiderMothDwellerEntity.this.getX();
            double y = SpiderMothDwellerEntity.this.getY();
            double z = SpiderMothDwellerEntity.this.getZ();
            Entity entity = SpiderMothDwellerEntity.this;
            Level world = SpiderMothDwellerEntity.this.level();
            return super.canUse() && ConstrictingUpwardsProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = SpiderMothDwellerEntity.this.getX();
            double y = SpiderMothDwellerEntity.this.getY();
            double z = SpiderMothDwellerEntity.this.getZ();
            Entity entity = SpiderMothDwellerEntity.this;
            Level world = SpiderMothDwellerEntity.this.level();
            return super.canContinueToUse() && ConstrictingUpwardsProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(7, new RandomLookAroundGoal(this) {
         public boolean canUse() {
            double x = SpiderMothDwellerEntity.this.getX();
            double y = SpiderMothDwellerEntity.this.getY();
            double z = SpiderMothDwellerEntity.this.getZ();
            Entity entity = SpiderMothDwellerEntity.this;
            Level world = SpiderMothDwellerEntity.this.level();
            return super.canUse() && ConstrictingUpwardsProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = SpiderMothDwellerEntity.this.getX();
            double y = SpiderMothDwellerEntity.this.getY();
            double z = SpiderMothDwellerEntity.this.getZ();
            Entity entity = SpiderMothDwellerEntity.this;
            Level world = SpiderMothDwellerEntity.this.level();
            return super.canContinueToUse() && ConstrictingUpwardsProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(8, new RandomSwimmingGoal(this, 2.0, 40));
      this.goalSelector.addGoal(9, new FloatGoal(this));
      this.goalSelector.addGoal(10, new ClimbOnTopOfPowderSnowGoal(this, this.level()));
      this.goalSelector.addGoal(11, new BreathAirGoal(this));
      this.goalSelector.addGoal(12, new FollowMobGoal(this, 1.0, 50.0F, 30.0F));
   }

   public MobType getMobType() {
      return MobType.ARTHROPOD;
   }

   public boolean removeWhenFarAway(double distanceToClosestPlayer) {
      return false;
   }

   public double getPassengersRidingOffset() {
      return super.getPassengersRidingOffset() + 1.0;
   }

   public SoundEvent getAmbientSound() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:heartbeats"));
   }

   public void playStepSound(BlockPos pos, BlockState blockIn) {
      this.playSound((SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.break")), 0.15F, 1.0F);
   }

   public SoundEvent getHurtSound(DamageSource ds) {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
   }

   public SoundEvent getDeathSound() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.death"));
   }

   public boolean hurt(DamageSource source, float amount) {
      VoidlasherHurtProcedure.execute(this);
      if (source.is(DamageTypes.IN_FIRE)) {
         return false;
      } else if (source.getDirectEntity() instanceof AbstractArrow) {
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
      VoidlasherDiesProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ());
   }

   public SpawnGroupData finalizeSpawn(
      ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag
   ) {
      SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
      VoidlasherSpawnProcedure.execute(world, this.getX(), this.getY(), this.getZ(), this);
      return retval;
   }

   public void addAdditionalSaveData(CompoundTag compound) {
      super.addAdditionalSaveData(compound);
      compound.putString("Texture", this.getTexture());
      compound.putString("Datacurrentattack", (String)this.entityData.get(DATA_currentattack));
      compound.putInt("Dataattacktimer", (Integer)this.entityData.get(DATA_attacktimer));
      compound.putBoolean("Dataprimed", (Boolean)this.entityData.get(DATA_primed));
   }

   public void readAdditionalSaveData(CompoundTag compound) {
      super.readAdditionalSaveData(compound);
      if (compound.contains("Texture")) {
         this.setTexture(compound.getString("Texture"));
      }

      if (compound.contains("Datacurrentattack")) {
         this.entityData.set(DATA_currentattack, compound.getString("Datacurrentattack"));
      }

      if (compound.contains("Dataattacktimer")) {
         this.entityData.set(DATA_attacktimer, compound.getInt("Dataattacktimer"));
      }

      if (compound.contains("Dataprimed")) {
         this.entityData.set(DATA_primed, compound.getBoolean("Dataprimed"));
      }
   }

   public void awardKillScore(Entity entity, int score, DamageSource damageSource) {
      super.awardKillScore(entity, score, damageSource);
      DraconicVoidlasherKillsAnotherEntityProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), entity);
   }

   public void baseTick() {
      super.baseTick();
      DraconicTickProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
      this.refreshDimensions();
   }

   public EntityDimensions getDimensions(Pose p_33597_) {
      return super.getDimensions(p_33597_).scale(1.49F);
   }

   public static void init() {
      SpawnPlacements.register(
         (EntityType)ArphexModEntities.DRACONIC_VOIDLASHER.get(),
         Type.ON_GROUND,
         Types.MOTION_BLOCKING_NO_LEAVES,
         (entityType, world, reason, pos, random) -> {
            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();
            return VoidlasherNaturalSpawnProcedure.execute(world, (double)x, (double)y, (double)z);
         }
      );
   }

   public static Builder createAttributes() {
      Builder builder = Mob.createMobAttributes();
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.15);
      builder = builder.add(Attributes.MAX_HEALTH, 500.0);
      builder = builder.add(Attributes.ARMOR, 10.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 17.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 130.0);
      builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 100.0);
      return builder.add(Attributes.ATTACK_KNOCKBACK, 0.1);
   }

   private PlayState movementPredicate(AnimationState event) {
      if (!this.animationprocedure.equals("empty")) {
         return PlayState.STOP;
      } else if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F) || !(event.getLimbSwingAmount() < 0.15F)) && this.onGround()) {
         return event.setAndContinue(RawAnimation.begin().thenLoop("animation.dvl.moving"));
      } else if (this.isDeadOrDying()) {
         return event.setAndContinue(RawAnimation.begin().thenPlay("animation.dvl.idle"));
      } else if (this.isInWaterOrBubble()) {
         return event.setAndContinue(RawAnimation.begin().thenLoop("animation.dvl.moving"));
      } else if (this.isShiftKeyDown()) {
         return event.setAndContinue(RawAnimation.begin().thenLoop("animation.dvl.power"));
      } else if (this.isSprinting()) {
         return event.setAndContinue(RawAnimation.begin().thenLoop("animation.dvl.idleaggro"));
      } else {
         return !this.onGround()
            ? event.setAndContinue(RawAnimation.begin().thenLoop("animation.dvl.moving"))
            : event.setAndContinue(RawAnimation.begin().thenLoop("animation.dvl.idle"));
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
         return event.setAndContinue(RawAnimation.begin().thenPlay("animation.dvl.attack"));
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
      data.add(new AnimationController[]{new AnimationController(this, "movement", 20, this::movementPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "attacking", 20, this::attackingPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "procedure", 20, this::procedurePredicate)});
   }

   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
   }
}
