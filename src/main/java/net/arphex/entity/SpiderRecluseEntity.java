package net.arphex.entity;

import javax.annotation.Nullable;
import net.arphex.init.ArphexModEntities;
import net.arphex.procedures.ArphexSpawnConfigUndergroundProcedure;
import net.arphex.procedures.LooklimRecluseProcedure;
import net.arphex.procedures.OnFireProcedure;
import net.arphex.procedures.RecluseHitboxScaleProcedure;
import net.arphex.procedures.SpiderFunnelEntityIsHurtProcedure;
import net.arphex.procedures.SpiderRecluseOnInitialEntitySpawnProcedure;
import net.arphex.procedures.SpiderRecluseTickProcedure;
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
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.ClimbOnTopOfPowderSnowGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveBackToVillageGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
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

public class SpiderRecluseEntity extends Spider implements GeoEntity {
   public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(SpiderRecluseEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(SpiderRecluseEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(SpiderRecluseEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<Integer> DATA_size = SynchedEntityData.defineId(SpiderRecluseEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<Integer> DATA_anim_cycle = SynchedEntityData.defineId(SpiderRecluseEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<Integer> DATA_hangweb = SynchedEntityData.defineId(SpiderRecluseEntity.class, EntityDataSerializers.INT);
   private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
   private boolean swinging;
   private boolean lastloop;
   private long lastSwing;
   public String animationprocedure = "empty";

   public SpiderRecluseEntity(SpawnEntity packet, Level world) {
      this((EntityType<SpiderRecluseEntity>)ArphexModEntities.SPIDER_RECLUSE.get(), world);
   }

   public SpiderRecluseEntity(EntityType<SpiderRecluseEntity> type, Level world) {
      super(type, world);
      this.xpReward = 5;
      this.setNoAi(false);
      this.setMaxUpStep(0.6F);
   }

   protected void defineSynchedData() {
      super.defineSynchedData();
      this.entityData.define(SHOOT, false);
      this.entityData.define(ANIMATION, "undefined");
      this.entityData.define(TEXTURE, "spider_recluse_2");
      this.entityData.define(DATA_size, 5);
      this.entityData.define(DATA_anim_cycle, 0);
      this.entityData.define(DATA_hangweb, 0);
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
      this.goalSelector.addGoal(1, new AvoidEntityGoal<Player>(this, Player.class, 20.0F, 1.6, 1.2) {
         public boolean canUse() {
            double x = SpiderRecluseEntity.this.getX();
            double y = SpiderRecluseEntity.this.getY();
            double z = SpiderRecluseEntity.this.getZ();
            Entity entity = SpiderRecluseEntity.this;
            Level world = SpiderRecluseEntity.this.level();
            return super.canUse() && OnFireProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = SpiderRecluseEntity.this.getX();
            double y = SpiderRecluseEntity.this.getY();
            double z = SpiderRecluseEntity.this.getZ();
            Entity entity = SpiderRecluseEntity.this;
            Level world = SpiderRecluseEntity.this.level();
            return super.canContinueToUse() && OnFireProcedure.execute(entity);
         }
      });
      this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Player.class, false, false));
      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Bat.class, true, true));
      this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, Silverfish.class, true, true));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, MosquitoMorbidityEntity.class, true, true));
      this.targetSelector.addGoal(6, new NearestAttackableTargetGoal(this, FlyFestererEntity.class, true, true));
      this.targetSelector.addGoal(7, new NearestAttackableTargetGoal(this, SilverfishSpectreEntity.class, true, true));
      this.goalSelector.addGoal(8, new MeleeAttackGoal(this, 1.2, false) {
         protected double getAttackReachSqr(LivingEntity entity) {
            return 2.56;
         }
      });
      this.targetSelector.addGoal(9, new HurtByTargetGoal(this, new Class[0]).setAlertOthers(new Class[0]));
      this.goalSelector.addGoal(10, new ClimbOnTopOfPowderSnowGoal(this, this.level()));
      this.goalSelector.addGoal(11, new MoveBackToVillageGoal(this, 0.6, false));
      this.goalSelector.addGoal(12, new RandomStrollGoal(this, 1.0) {
         public boolean canUse() {
            double x = SpiderRecluseEntity.this.getX();
            double y = SpiderRecluseEntity.this.getY();
            double z = SpiderRecluseEntity.this.getZ();
            Entity entity = SpiderRecluseEntity.this;
            Level world = SpiderRecluseEntity.this.level();
            return super.canUse() && LooklimRecluseProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = SpiderRecluseEntity.this.getX();
            double y = SpiderRecluseEntity.this.getY();
            double z = SpiderRecluseEntity.this.getZ();
            Entity entity = SpiderRecluseEntity.this;
            Level world = SpiderRecluseEntity.this.level();
            return super.canContinueToUse() && LooklimRecluseProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(13, new RandomLookAroundGoal(this) {
         public boolean canUse() {
            double x = SpiderRecluseEntity.this.getX();
            double y = SpiderRecluseEntity.this.getY();
            double z = SpiderRecluseEntity.this.getZ();
            Entity entity = SpiderRecluseEntity.this;
            Level world = SpiderRecluseEntity.this.level();
            return super.canUse() && LooklimRecluseProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = SpiderRecluseEntity.this.getX();
            double y = SpiderRecluseEntity.this.getY();
            double z = SpiderRecluseEntity.this.getZ();
            Entity entity = SpiderRecluseEntity.this;
            Level world = SpiderRecluseEntity.this.level();
            return super.canContinueToUse() && LooklimRecluseProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(14, new FloatGoal(this));
   }

   public MobType getMobType() {
      return MobType.ARTHROPOD;
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
      SpiderFunnelEntityIsHurtProcedure.execute(this.level(), this);
      if (source.getDirectEntity() instanceof ThrownPotion || source.getDirectEntity() instanceof AreaEffectCloud) {
         return false;
      } else if (source.is(DamageTypes.FALL)) {
         return false;
      } else if (source.is(DamageTypes.CACTUS)) {
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
      SpiderRecluseOnInitialEntitySpawnProcedure.execute(this);
      return retval;
   }

   public void addAdditionalSaveData(CompoundTag compound) {
      super.addAdditionalSaveData(compound);
      compound.putString("Texture", this.getTexture());
      compound.putInt("Datasize", (Integer)this.entityData.get(DATA_size));
      compound.putInt("Dataanim_cycle", (Integer)this.entityData.get(DATA_anim_cycle));
      compound.putInt("Datahangweb", (Integer)this.entityData.get(DATA_hangweb));
   }

   public void readAdditionalSaveData(CompoundTag compound) {
      super.readAdditionalSaveData(compound);
      if (compound.contains("Texture")) {
         this.setTexture(compound.getString("Texture"));
      }

      if (compound.contains("Datasize")) {
         this.entityData.set(DATA_size, compound.getInt("Datasize"));
      }

      if (compound.contains("Dataanim_cycle")) {
         this.entityData.set(DATA_anim_cycle, compound.getInt("Dataanim_cycle"));
      }

      if (compound.contains("Datahangweb")) {
         this.entityData.set(DATA_hangweb, compound.getInt("Datahangweb"));
      }
   }

   public void baseTick() {
      super.baseTick();
      SpiderRecluseTickProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
      this.refreshDimensions();
   }

   public EntityDimensions getDimensions(Pose p_33597_) {
      Level world = this.level();
      double x = this.getX();
      double y = this.getY();
      double z = this.getZ();
      return super.getDimensions(p_33597_).scale((float)RecluseHitboxScaleProcedure.execute(this));
   }

   public void aiStep() {
      super.aiStep();
      this.updateSwingTime();
   }

   public static void init() {
      SpawnPlacements.register(
         (EntityType)ArphexModEntities.SPIDER_RECLUSE.get(), Type.ON_GROUND, Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();
            return ArphexSpawnConfigUndergroundProcedure.execute(world, (double)x, (double)y, (double)z);
         }
      );
   }

   public static Builder createAttributes() {
      Builder builder = Mob.createMobAttributes();
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.28);
      builder = builder.add(Attributes.MAX_HEALTH, 50.0);
      builder = builder.add(Attributes.ARMOR, 0.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 6.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 20.0);
      return builder.add(Attributes.ATTACK_KNOCKBACK, 1.0);
   }

   private PlayState movementPredicate(AnimationState event) {
      if (this.animationprocedure.equals("empty")) {
         if (event.isMoving() || !(event.getLimbSwingAmount() > -0.15F) || !(event.getLimbSwingAmount() < 0.15F)) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("animation.spider_recluse.prowling"));
         } else if (this.isDeadOrDying()) {
            return event.setAndContinue(RawAnimation.begin().thenPlay("animation.spider_recluse.death"));
         } else if (this.isInWaterOrBubble()) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("animation.spider_recluse.prowling"));
         } else {
            return this.isShiftKeyDown()
               ? event.setAndContinue(RawAnimation.begin().thenLoop("animation.spider_recluse.grab"))
               : event.setAndContinue(RawAnimation.begin().thenLoop("animation.spider_recluse.idle"));
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
         return event.setAndContinue(RawAnimation.begin().thenPlay("animation.spider_recluse.attack"));
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
      data.add(new AnimationController[]{new AnimationController(this, "movement", 5, this::movementPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "attacking", 5, this::attackingPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "procedure", 5, this::procedurePredicate)});
   }

   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
   }
}
