package net.arphex.entity;

import java.util.EnumSet;
import javax.annotation.Nullable;
import net.arphex.init.ArphexModEntities;
import net.arphex.procedures.ArPhExSpawnConfigProcedure;
import net.arphex.procedures.SpiderBroodEntityDiesProcedure;
import net.arphex.procedures.SpiderBroodEntityIsHurtProcedure;
import net.arphex.procedures.SpiderBroodOnEntityTickUpdateProcedure;
import net.arphex.procedures.SpiderBroodOnInitialEntitySpawnProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AreaEffectCloud;
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
import net.minecraft.world.entity.ai.goal.ClimbOnTopOfPowderSnowGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveBackToVillageGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.Goal.Flag;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
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

public class SpiderBroodEntity extends Spider implements RangedAttackMob, GeoEntity {
   public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(SpiderBroodEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(SpiderBroodEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(SpiderBroodEntity.class, EntityDataSerializers.STRING);
   private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
   private boolean swinging;
   private boolean lastloop;
   private long lastSwing;
   public String animationprocedure = "empty";

   public SpiderBroodEntity(SpawnEntity packet, Level world) {
      this((EntityType<SpiderBroodEntity>)ArphexModEntities.SPIDER_BROOD.get(), world);
   }

   public SpiderBroodEntity(EntityType<SpiderBroodEntity> type, Level world) {
      super(type, world);
      this.xpReward = 8;
      this.setNoAi(false);
      this.setMaxUpStep(0.6F);
   }

   protected void defineSynchedData() {
      super.defineSynchedData();
      this.entityData.define(SHOOT, false);
      this.entityData.define(ANIMATION, "undefined");
      this.entityData.define(TEXTURE, "spiderbrood");
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
      this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Player.class, true, true));
      this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, FlyFestererEntity.class, true, true));
      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Silverfish.class, true, true));
      this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.2, false) {
         protected double getAttackReachSqr(LivingEntity entity) {
            return 4.0;
         }
      });
      this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.2, false) {
         protected double getAttackReachSqr(LivingEntity entity) {
            return (double)(this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth());
         }
      });
      this.targetSelector.addGoal(6, new HurtByTargetGoal(this, new Class[0]).setAlertOthers(new Class[0]));
      this.goalSelector.addGoal(7, new ClimbOnTopOfPowderSnowGoal(this, this.level()));
      this.goalSelector.addGoal(8, new MoveBackToVillageGoal(this, 0.6, false));
      this.goalSelector.addGoal(9, new RandomStrollGoal(this, 1.0));
      this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
      this.goalSelector.addGoal(11, new FloatGoal(this));
      this.goalSelector.addGoal(1, new SpiderBroodEntity.RangedAttackGoal(this, 1.25, 100, 10.0F) {
         @Override
         public boolean canContinueToUse() {
            return this.canUse();
         }
      });
   }

   public MobType getMobType() {
      return MobType.ARTHROPOD;
   }

   public SoundEvent getAmbientSound() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:creepy_arthropod"));
   }

   public SoundEvent getHurtSound(DamageSource ds) {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:creepy_arthropod_tiny"));
   }

   public SoundEvent getDeathSound() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.death"));
   }

   public boolean hurt(DamageSource source, float amount) {
      SpiderBroodEntityIsHurtProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
      if (source.getDirectEntity() instanceof AbstractArrow) {
         return false;
      } else if (source.getDirectEntity() instanceof ThrownPotion || source.getDirectEntity() instanceof AreaEffectCloud) {
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
      SpiderBroodEntityDiesProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ());
   }

   public SpawnGroupData finalizeSpawn(
      ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag
   ) {
      SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
      SpiderBroodOnInitialEntitySpawnProcedure.execute(this);
      return retval;
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
      SpiderBroodOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
      this.refreshDimensions();
   }

   public EntityDimensions getDimensions(Pose p_33597_) {
      return super.getDimensions(p_33597_).scale(0.9F);
   }

   public void performRangedAttack(LivingEntity target, float flval) {
      SpiderBroodEntityProjectile entityarrow = new SpiderBroodEntityProjectile(
         (EntityType<? extends SpiderBroodEntityProjectile>)ArphexModEntities.SPIDER_BROOD_PROJECTILE.get(), this, this.level()
      );
      double d0 = target.getY() + (double)target.getEyeHeight() - 1.1;
      double d1 = target.getX() - this.getX();
      double d3 = target.getZ() - this.getZ();
      entityarrow.shoot(d1, d0 - entityarrow.getY() + Math.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 1.6F, 12.0F);
      this.level().addFreshEntity(entityarrow);
   }

   public void aiStep() {
      super.aiStep();
      this.updateSwingTime();
   }

   public static void init() {
      SpawnPlacements.register(
         (EntityType)ArphexModEntities.SPIDER_BROOD.get(), Type.ON_GROUND, Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();
            return ArPhExSpawnConfigProcedure.execute(world, (double)x, (double)y, (double)z);
         }
      );
   }

   public static Builder createAttributes() {
      Builder builder = Mob.createMobAttributes();
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.25);
      builder = builder.add(Attributes.MAX_HEALTH, 15.0);
      builder = builder.add(Attributes.ARMOR, 0.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 4.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 20.0);
      builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 100.0);
      return builder.add(Attributes.ATTACK_KNOCKBACK, 0.1);
   }

   private PlayState movementPredicate(AnimationState event) {
      if (this.animationprocedure.equals("empty")) {
         if (event.isMoving() || !(event.getLimbSwingAmount() > -0.15F) || !(event.getLimbSwingAmount() < 0.15F)) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("animation.spiderbrood.scurrying"));
         } else if (this.isDeadOrDying()) {
            return event.setAndContinue(RawAnimation.begin().thenPlay("animation.spiderbrood.death"));
         } else if (this.isInWaterOrBubble()) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("animation.spiderbrood.scurrying"));
         } else {
            return this.isShiftKeyDown()
               ? event.setAndContinue(RawAnimation.begin().thenLoop("animation.spiderbrood.grab"))
               : event.setAndContinue(RawAnimation.begin().thenLoop("animation.spiderbrood.idle"));
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

      if ((this.swinging || (Boolean)this.entityData.get(SHOOT)) && event.getController().getAnimationState() == State.STOPPED) {
         event.getController().forceAnimationReset();
         return event.setAndContinue(RawAnimation.begin().thenPlay("animation.spiderbrood.aggressive"));
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
      data.add(new AnimationController[]{new AnimationController(this, "movement", 4, this::movementPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "attacking", 4, this::attackingPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "procedure", 4, this::procedurePredicate)});
   }

   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
   }

   public class RangedAttackGoal extends Goal {
      private final Mob mob;
      private final RangedAttackMob rangedAttackMob;
      @Nullable
      private LivingEntity target;
      private int attackTime = -1;
      private final double speedModifier;
      private int seeTime;
      private final int attackIntervalMin;
      private final int attackIntervalMax;
      private final float attackRadius;
      private final float attackRadiusSqr;

      public RangedAttackGoal(RangedAttackMob p_25768_, double p_25769_, int p_25770_, float p_25771_) {
         this(p_25768_, p_25769_, p_25770_, p_25770_, p_25771_);
      }

      public RangedAttackGoal(RangedAttackMob p_25773_, double p_25774_, int p_25775_, int p_25776_, float p_25777_) {
         if (!(p_25773_ instanceof LivingEntity)) {
            throw new IllegalArgumentException("ArrowAttackGoal requires Mob implements RangedAttackMob");
         } else {
            this.rangedAttackMob = p_25773_;
            this.mob = (Mob)p_25773_;
            this.speedModifier = p_25774_;
            this.attackIntervalMin = p_25775_;
            this.attackIntervalMax = p_25776_;
            this.attackRadius = p_25777_;
            this.attackRadiusSqr = p_25777_ * p_25777_;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
         }
      }

      public boolean canUse() {
         LivingEntity livingentity = this.mob.getTarget();
         if (livingentity != null && livingentity.isAlive()) {
            this.target = livingentity;
            return true;
         } else {
            return false;
         }
      }

      public boolean canContinueToUse() {
         return this.canUse() || this.target.isAlive() && !this.mob.getNavigation().isDone();
      }

      public void stop() {
         this.target = null;
         this.seeTime = 0;
         this.attackTime = -1;
         ((SpiderBroodEntity)this.rangedAttackMob).entityData.set(SpiderBroodEntity.SHOOT, false);
      }

      public boolean requiresUpdateEveryTick() {
         return true;
      }

      public void tick() {
         double d0 = this.mob.distanceToSqr(this.target.getX(), this.target.getY(), this.target.getZ());
         boolean flag = this.mob.getSensing().hasLineOfSight(this.target);
         if (flag) {
            this.seeTime++;
         } else {
            this.seeTime = 0;
         }

         if (!(d0 > (double)this.attackRadiusSqr) && this.seeTime >= 5) {
            this.mob.getNavigation().stop();
         } else {
            this.mob.getNavigation().moveTo(this.target, this.speedModifier);
         }

         this.mob.getLookControl().setLookAt(this.target, 30.0F, 30.0F);
         if (--this.attackTime == 0) {
            if (!flag) {
               ((SpiderBroodEntity)this.rangedAttackMob).entityData.set(SpiderBroodEntity.SHOOT, false);
               return;
            }

            ((SpiderBroodEntity)this.rangedAttackMob).entityData.set(SpiderBroodEntity.SHOOT, true);
            float f = (float)Math.sqrt(d0) / this.attackRadius;
            float f1 = Mth.clamp(f, 0.1F, 1.0F);
            this.rangedAttackMob.performRangedAttack(this.target, f1);
            this.attackTime = Mth.floor(f * (float)(this.attackIntervalMax - this.attackIntervalMin) + (float)this.attackIntervalMin);
         } else if (this.attackTime < 0) {
            this.attackTime = Mth.floor(Mth.lerp(Math.sqrt(d0) / (double)this.attackRadius, (double)this.attackIntervalMin, (double)this.attackIntervalMax));
         } else {
            ((SpiderBroodEntity)this.rangedAttackMob).entityData.set(SpiderBroodEntity.SHOOT, false);
         }
      }
   }
}
