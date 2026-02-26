package net.arphex.entity;

import javax.annotation.Nullable;
import net.arphex.init.ArphexModEntities;
import net.arphex.procedures.ArphexSpawnConfigSurfaceProcedure;
import net.arphex.procedures.AttackTargetReturnProcedure;
import net.arphex.procedures.BeingRiddenProcedure;
import net.arphex.procedures.ObstructMoveProcedure;
import net.arphex.procedures.SpiderObstructerEntityIsHurtProcedure;
import net.arphex.procedures.SpiderObstructerOnEntityTickUpdateProcedure;
import net.arphex.procedures.SpiderObstructerOnInitialEntitySpawnProcedure;
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
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.ClimbOnTopOfPowderSnowGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveBackToVillageGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
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

public class SpiderObstructerEntity extends Monster implements GeoEntity {
   public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(SpiderObstructerEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(SpiderObstructerEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(SpiderObstructerEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<Boolean> DATA_plugmode = SynchedEntityData.defineId(SpiderObstructerEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<Integer> DATA_cooldown = SynchedEntityData.defineId(SpiderObstructerEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<Integer> DATA_trapdoor_x = SynchedEntityData.defineId(SpiderObstructerEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<Integer> DATA_trapdoor_y = SynchedEntityData.defineId(SpiderObstructerEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<Integer> DATA_trapdoor_z = SynchedEntityData.defineId(SpiderObstructerEntity.class, EntityDataSerializers.INT);
   private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
   private boolean swinging;
   private boolean lastloop;
   private long lastSwing;
   public String animationprocedure = "empty";

   public SpiderObstructerEntity(SpawnEntity packet, Level world) {
      this((EntityType<SpiderObstructerEntity>)ArphexModEntities.SPIDER_OBSTRUCTER.get(), world);
   }

   public SpiderObstructerEntity(EntityType<SpiderObstructerEntity> type, Level world) {
      super(type, world);
      this.xpReward = 8;
      this.setNoAi(false);
      this.setMaxUpStep(1.0F);
   }

   protected void defineSynchedData() {
      super.defineSynchedData();
      this.entityData.define(SHOOT, false);
      this.entityData.define(ANIMATION, "undefined");
      this.entityData.define(TEXTURE, "spider_obstructer");
      this.entityData.define(DATA_plugmode, false);
      this.entityData.define(DATA_cooldown, 0);
      this.entityData.define(DATA_trapdoor_x, 0);
      this.entityData.define(DATA_trapdoor_y, 0);
      this.entityData.define(DATA_trapdoor_z, 0);
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
      this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
         protected double getAttackReachSqr(LivingEntity entity) {
            return 2.25;
         }

         public boolean canUse() {
            double x = SpiderObstructerEntity.this.getX();
            double y = SpiderObstructerEntity.this.getY();
            double z = SpiderObstructerEntity.this.getZ();
            Entity entity = SpiderObstructerEntity.this;
            Level world = SpiderObstructerEntity.this.level();
            return super.canUse() && BeingRiddenProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = SpiderObstructerEntity.this.getX();
            double y = SpiderObstructerEntity.this.getY();
            double z = SpiderObstructerEntity.this.getZ();
            Entity entity = SpiderObstructerEntity.this;
            Level world = SpiderObstructerEntity.this.level();
            return super.canContinueToUse() && BeingRiddenProcedure.execute(entity);
         }
      });
      this.targetSelector.addGoal(2, new HurtByTargetGoal(this, new Class[0]).setAlertOthers(new Class[0]));
      this.goalSelector.addGoal(3, new AvoidEntityGoal<Player>(this, Player.class, 8.0F, 1.0, 1.2) {
         public boolean canUse() {
            double x = SpiderObstructerEntity.this.getX();
            double y = SpiderObstructerEntity.this.getY();
            double z = SpiderObstructerEntity.this.getZ();
            Entity entity = SpiderObstructerEntity.this;
            Level world = SpiderObstructerEntity.this.level();
            return super.canUse() && AttackTargetReturnProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = SpiderObstructerEntity.this.getX();
            double y = SpiderObstructerEntity.this.getY();
            double z = SpiderObstructerEntity.this.getZ();
            Entity entity = SpiderObstructerEntity.this;
            Level world = SpiderObstructerEntity.this.level();
            return super.canContinueToUse() && AttackTargetReturnProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(4, new ClimbOnTopOfPowderSnowGoal(this, this.level()));
      this.goalSelector.addGoal(5, new MoveBackToVillageGoal(this, 0.6, false));
      this.goalSelector.addGoal(6, new RandomStrollGoal(this, 1.0) {
         public boolean canUse() {
            double x = SpiderObstructerEntity.this.getX();
            double y = SpiderObstructerEntity.this.getY();
            double z = SpiderObstructerEntity.this.getZ();
            Entity entity = SpiderObstructerEntity.this;
            Level world = SpiderObstructerEntity.this.level();
            return super.canUse() && ObstructMoveProcedure.execute(world, x, y, z);
         }

         public boolean canContinueToUse() {
            double x = SpiderObstructerEntity.this.getX();
            double y = SpiderObstructerEntity.this.getY();
            double z = SpiderObstructerEntity.this.getZ();
            Entity entity = SpiderObstructerEntity.this;
            Level world = SpiderObstructerEntity.this.level();
            return super.canContinueToUse() && ObstructMoveProcedure.execute(world, x, y, z);
         }
      });
      this.goalSelector.addGoal(7, new RandomLookAroundGoal(this) {
         public boolean canUse() {
            double x = SpiderObstructerEntity.this.getX();
            double y = SpiderObstructerEntity.this.getY();
            double z = SpiderObstructerEntity.this.getZ();
            Entity entity = SpiderObstructerEntity.this;
            Level world = SpiderObstructerEntity.this.level();
            return super.canUse() && ObstructMoveProcedure.execute(world, x, y, z);
         }

         public boolean canContinueToUse() {
            double x = SpiderObstructerEntity.this.getX();
            double y = SpiderObstructerEntity.this.getY();
            double z = SpiderObstructerEntity.this.getZ();
            Entity entity = SpiderObstructerEntity.this;
            Level world = SpiderObstructerEntity.this.level();
            return super.canContinueToUse() && ObstructMoveProcedure.execute(world, x, y, z);
         }
      });
      this.goalSelector.addGoal(8, new FloatGoal(this));
   }

   public MobType getMobType() {
      return MobType.ARTHROPOD;
   }

   public double getPassengersRidingOffset() {
      return super.getPassengersRidingOffset() + -0.7;
   }

   public SoundEvent getHurtSound(DamageSource ds) {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.hurt"));
   }

   public SoundEvent getDeathSound() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.death"));
   }

   public boolean hurt(DamageSource source, float amount) {
      SpiderObstructerEntityIsHurtProcedure.execute(this);
      if (source.is(DamageTypes.FALL)) {
         return false;
      } else if (source.is(DamageTypes.CACTUS)) {
         return false;
      } else if (source.is(DamageTypes.DROWN)) {
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
      SpiderObstructerOnInitialEntitySpawnProcedure.execute(this);
      return retval;
   }

   public void addAdditionalSaveData(CompoundTag compound) {
      super.addAdditionalSaveData(compound);
      compound.putString("Texture", this.getTexture());
      compound.putBoolean("Dataplugmode", (Boolean)this.entityData.get(DATA_plugmode));
      compound.putInt("Datacooldown", (Integer)this.entityData.get(DATA_cooldown));
      compound.putInt("Datatrapdoor_x", (Integer)this.entityData.get(DATA_trapdoor_x));
      compound.putInt("Datatrapdoor_y", (Integer)this.entityData.get(DATA_trapdoor_y));
      compound.putInt("Datatrapdoor_z", (Integer)this.entityData.get(DATA_trapdoor_z));
   }

   public void readAdditionalSaveData(CompoundTag compound) {
      super.readAdditionalSaveData(compound);
      if (compound.contains("Texture")) {
         this.setTexture(compound.getString("Texture"));
      }

      if (compound.contains("Dataplugmode")) {
         this.entityData.set(DATA_plugmode, compound.getBoolean("Dataplugmode"));
      }

      if (compound.contains("Datacooldown")) {
         this.entityData.set(DATA_cooldown, compound.getInt("Datacooldown"));
      }

      if (compound.contains("Datatrapdoor_x")) {
         this.entityData.set(DATA_trapdoor_x, compound.getInt("Datatrapdoor_x"));
      }

      if (compound.contains("Datatrapdoor_y")) {
         this.entityData.set(DATA_trapdoor_y, compound.getInt("Datatrapdoor_y"));
      }

      if (compound.contains("Datatrapdoor_z")) {
         this.entityData.set(DATA_trapdoor_z, compound.getInt("Datatrapdoor_z"));
      }
   }

   public void baseTick() {
      super.baseTick();
      SpiderObstructerOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
      this.refreshDimensions();
   }

   public EntityDimensions getDimensions(Pose p_33597_) {
      return super.getDimensions(p_33597_).scale(0.9F);
   }

   public static void init() {
      SpawnPlacements.register(
         (EntityType)ArphexModEntities.SPIDER_OBSTRUCTER.get(), Type.ON_GROUND, Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();
            return ArphexSpawnConfigSurfaceProcedure.execute(world, (double)x, (double)y, (double)z);
         }
      );
   }

   public static Builder createAttributes() {
      Builder builder = Mob.createMobAttributes();
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.37);
      builder = builder.add(Attributes.MAX_HEALTH, 50.0);
      builder = builder.add(Attributes.ARMOR, 3.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 5.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 35.0);
      builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.4);
      return builder.add(Attributes.ATTACK_KNOCKBACK, 2.0);
   }

   private PlayState movementPredicate(AnimationState event) {
      if (!this.animationprocedure.equals("empty")) {
         return PlayState.STOP;
      } else if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F) || !(event.getLimbSwingAmount() < 0.15F)) && !this.isVehicle()) {
         return event.setAndContinue(RawAnimation.begin().thenLoop("animation.spiderobstructer.scurrying"));
      } else if (this.isDeadOrDying()) {
         return event.setAndContinue(RawAnimation.begin().thenPlay("animation.spiderobstructer.death"));
      } else if (this.isShiftKeyDown()) {
         return event.setAndContinue(RawAnimation.begin().thenLoop("animation.spiderobstructer.plug"));
      } else {
         return this.isVehicle() && event.isMoving()
            ? event.setAndContinue(RawAnimation.begin().thenLoop("animation.spiderobstructer.ride"))
            : event.setAndContinue(RawAnimation.begin().thenLoop("animation.spiderobstructer.idle"));
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
         return event.setAndContinue(RawAnimation.begin().thenPlay("animation.spiderobstructer.attack"));
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
      data.add(new AnimationController[]{new AnimationController(this, "movement", 6, this::movementPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "attacking", 6, this::attackingPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "procedure", 6, this::procedurePredicate)});
   }

   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
   }
}
