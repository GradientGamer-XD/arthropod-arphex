package net.arphex.entity;

import java.util.List;
import javax.annotation.Nullable;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModItems;
import net.arphex.procedures.ArPhExSpawnConfigProcedure;
import net.arphex.procedures.CheckOwnedProcedure;
import net.arphex.procedures.SittingJumpProcedure;
import net.arphex.procedures.SpiderBroodOnEntityTickUpdateProcedure;
import net.arphex.procedures.SpiderJumpEntityIsHurtProcedure;
import net.arphex.procedures.SpiderJumpOnInitialEntitySpawnProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AgeableMob;
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
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.SpawnPlacements.Type;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.ClimbOnTopOfPowderSnowGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveBackToVillageGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraftforge.event.ForgeEventFactory;
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

public class SpiderJumpEntity extends TamableAnimal implements GeoEntity {
   public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(SpiderJumpEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(SpiderJumpEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(SpiderJumpEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<Boolean> DATA_ritual = SynchedEntityData.defineId(SpiderJumpEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<Boolean> DATA_follow_mode = SynchedEntityData.defineId(SpiderJumpEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<Boolean> DATA_sit = SynchedEntityData.defineId(SpiderJumpEntity.class, EntityDataSerializers.BOOLEAN);
   private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
   private boolean swinging;
   private boolean lastloop;
   private long lastSwing;
   public String animationprocedure = "empty";

   public SpiderJumpEntity(SpawnEntity packet, Level world) {
      this((EntityType<SpiderJumpEntity>)ArphexModEntities.SPIDER_JUMP.get(), world);
   }

   public SpiderJumpEntity(EntityType<SpiderJumpEntity> type, Level world) {
      super(type, world);
      this.xpReward = 5;
      this.setNoAi(false);
      this.setMaxUpStep(0.6F);
   }

   protected void defineSynchedData() {
      super.defineSynchedData();
      this.entityData.define(SHOOT, false);
      this.entityData.define(ANIMATION, "undefined");
      this.entityData.define(TEXTURE, "spiderjumping");
      this.entityData.define(DATA_ritual, false);
      this.entityData.define(DATA_follow_mode, false);
      this.entityData.define(DATA_sit, false);
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
      this.goalSelector.addGoal(1, new OwnerHurtByTargetGoal(this) {
         public boolean canUse() {
            double x = SpiderJumpEntity.this.getX();
            double y = SpiderJumpEntity.this.getY();
            double z = SpiderJumpEntity.this.getZ();
            Entity entity = SpiderJumpEntity.this;
            Level world = SpiderJumpEntity.this.level();
            return super.canUse() && CheckOwnedProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = SpiderJumpEntity.this.getX();
            double y = SpiderJumpEntity.this.getY();
            double z = SpiderJumpEntity.this.getZ();
            Entity entity = SpiderJumpEntity.this;
            Level world = SpiderJumpEntity.this.level();
            return super.canContinueToUse() && CheckOwnedProcedure.execute(entity);
         }
      });
      this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this) {
         public boolean canUse() {
            double x = SpiderJumpEntity.this.getX();
            double y = SpiderJumpEntity.this.getY();
            double z = SpiderJumpEntity.this.getZ();
            Entity entity = SpiderJumpEntity.this;
            Level world = SpiderJumpEntity.this.level();
            return super.canUse() && CheckOwnedProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = SpiderJumpEntity.this.getX();
            double y = SpiderJumpEntity.this.getY();
            double z = SpiderJumpEntity.this.getZ();
            Entity entity = SpiderJumpEntity.this;
            Level world = SpiderJumpEntity.this.level();
            return super.canContinueToUse() && CheckOwnedProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(3, new BreedGoal(this, 1.0));
      this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 2.0, 11.0F, 8.0F, false) {
         public boolean canUse() {
            double x = SpiderJumpEntity.this.getX();
            double y = SpiderJumpEntity.this.getY();
            double z = SpiderJumpEntity.this.getZ();
            Entity entity = SpiderJumpEntity.this;
            Level world = SpiderJumpEntity.this.level();
            return super.canUse() && SittingJumpProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = SpiderJumpEntity.this.getX();
            double y = SpiderJumpEntity.this.getY();
            double z = SpiderJumpEntity.this.getZ();
            Entity entity = SpiderJumpEntity.this;
            Level world = SpiderJumpEntity.this.level();
            return super.canContinueToUse() && SittingJumpProcedure.execute(entity);
         }
      });
      this.targetSelector.addGoal(5, new HurtByTargetGoal(this, new Class[0]));
      this.targetSelector.addGoal(6, new NearestAttackableTargetGoal(this, Bee.class, true, true));
      this.targetSelector.addGoal(7, new NearestAttackableTargetGoal(this, FlyFestererEntity.class, true, true));
      this.targetSelector.addGoal(8, new NearestAttackableTargetGoal(this, MaggotLarvaeEntity.class, true, true));
      this.targetSelector.addGoal(9, new NearestAttackableTargetGoal(this, MosquitoMorbidityEntity.class, true, true));
      this.targetSelector.addGoal(10, new NearestAttackableTargetGoal(this, SilverfishSpectreEntity.class, true, true));
      this.targetSelector.addGoal(11, new NearestAttackableTargetGoal(this, AntArsonistEntity.class, true, true));
      this.targetSelector.addGoal(12, new NearestAttackableTargetGoal(this, RoachRiverspawnEntity.class, true, true));
      this.goalSelector.addGoal(13, new MeleeAttackGoal(this, 1.0, false) {
         protected double getAttackReachSqr(LivingEntity entity) {
            return 3.24;
         }
      });
      this.goalSelector.addGoal(14, new MeleeAttackGoal(this, 1.2, false) {
         protected double getAttackReachSqr(LivingEntity entity) {
            return (double)(this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth());
         }
      });
      this.goalSelector.addGoal(15, new LeapAtTargetGoal(this, 1.0F));
      this.goalSelector.addGoal(16, new ClimbOnTopOfPowderSnowGoal(this, this.level()));
      this.goalSelector.addGoal(17, new LookAtPlayerGoal(this, Player.class, 6.0F));
      this.goalSelector.addGoal(18, new MoveBackToVillageGoal(this, 0.6, false));
      this.goalSelector.addGoal(19, new RandomStrollGoal(this, 1.0) {
         public boolean canUse() {
            double x = SpiderJumpEntity.this.getX();
            double y = SpiderJumpEntity.this.getY();
            double z = SpiderJumpEntity.this.getZ();
            Entity entity = SpiderJumpEntity.this;
            Level world = SpiderJumpEntity.this.level();
            return super.canUse() && SittingJumpProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = SpiderJumpEntity.this.getX();
            double y = SpiderJumpEntity.this.getY();
            double z = SpiderJumpEntity.this.getZ();
            Entity entity = SpiderJumpEntity.this;
            Level world = SpiderJumpEntity.this.level();
            return super.canContinueToUse() && SittingJumpProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(20, new FloatGoal(this));
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
      SpiderJumpEntityIsHurtProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
      if (source.is(DamageTypes.FALL)) {
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
      SpiderJumpOnInitialEntitySpawnProcedure.execute(this);
      return retval;
   }

   public void addAdditionalSaveData(CompoundTag compound) {
      super.addAdditionalSaveData(compound);
      compound.putString("Texture", this.getTexture());
      compound.putBoolean("Dataritual", (Boolean)this.entityData.get(DATA_ritual));
      compound.putBoolean("Datafollow_mode", (Boolean)this.entityData.get(DATA_follow_mode));
      compound.putBoolean("Datasit", (Boolean)this.entityData.get(DATA_sit));
   }

   public void readAdditionalSaveData(CompoundTag compound) {
      super.readAdditionalSaveData(compound);
      if (compound.contains("Texture")) {
         this.setTexture(compound.getString("Texture"));
      }

      if (compound.contains("Dataritual")) {
         this.entityData.set(DATA_ritual, compound.getBoolean("Dataritual"));
      }

      if (compound.contains("Datafollow_mode")) {
         this.entityData.set(DATA_follow_mode, compound.getBoolean("Datafollow_mode"));
      }

      if (compound.contains("Datasit")) {
         this.entityData.set(DATA_sit, compound.getBoolean("Datasit"));
      }
   }

   public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
      ItemStack itemstack = sourceentity.getItemInHand(hand);
      InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());
      Item item = itemstack.getItem();
      if (itemstack.getItem() instanceof SpawnEggItem) {
         retval = super.mobInteract(sourceentity, hand);
      } else if (this.level().isClientSide()) {
         retval = (!this.isTame() || !this.isOwnedBy(sourceentity)) && !this.isFood(itemstack)
            ? InteractionResult.PASS
            : InteractionResult.sidedSuccess(this.level().isClientSide());
      } else if (this.isTame()) {
         if (this.isOwnedBy(sourceentity)) {
            if (item.isEdible() && this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
               this.usePlayerItem(sourceentity, hand, itemstack);
               this.heal((float)item.getFoodProperties().getNutrition());
               retval = InteractionResult.sidedSuccess(this.level().isClientSide());
            } else if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
               this.usePlayerItem(sourceentity, hand, itemstack);
               this.heal(4.0F);
               retval = InteractionResult.sidedSuccess(this.level().isClientSide());
            } else {
               retval = super.mobInteract(sourceentity, hand);
            }
         }
      } else if (this.isFood(itemstack)) {
         this.usePlayerItem(sourceentity, hand, itemstack);
         if (this.random.nextInt(3) == 0 && !ForgeEventFactory.onAnimalTame(this, sourceentity)) {
            this.tame(sourceentity);
            this.level().broadcastEntityEvent(this, (byte)7);
         } else {
            this.level().broadcastEntityEvent(this, (byte)6);
         }

         this.setPersistenceRequired();
         retval = InteractionResult.sidedSuccess(this.level().isClientSide());
      } else {
         retval = super.mobInteract(sourceentity, hand);
         if (retval == InteractionResult.SUCCESS || retval == InteractionResult.CONSUME) {
            this.setPersistenceRequired();
         }
      }

      return retval;
   }

   public void baseTick() {
      super.baseTick();
      SpiderBroodOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
      this.refreshDimensions();
   }

   public EntityDimensions getDimensions(Pose p_33597_) {
      return super.getDimensions(p_33597_).scale(0.65F);
   }

   public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
      SpiderJumpEntity retval = (SpiderJumpEntity)((EntityType)ArphexModEntities.SPIDER_JUMP.get()).create(serverWorld);
      retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
      return retval;
   }

   public boolean isFood(ItemStack stack) {
      return List.of((Item)ArphexModItems.MAGGOT_GRUB.get(), (Item)ArphexModItems.ROACH_NYMPH.get(), (Item)ArphexModItems.LOCUST_LARVAE.get())
         .contains(stack.getItem());
   }

   public void aiStep() {
      super.aiStep();
      this.updateSwingTime();
   }

   public static void init() {
      SpawnPlacements.register(
         (EntityType)ArphexModEntities.SPIDER_JUMP.get(), Type.ON_GROUND, Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();
            return ArPhExSpawnConfigProcedure.execute(world, (double)x, (double)y, (double)z);
         }
      );
   }

   public static Builder createAttributes() {
      Builder builder = Mob.createMobAttributes();
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.22);
      builder = builder.add(Attributes.MAX_HEALTH, 40.0);
      builder = builder.add(Attributes.ARMOR, 0.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 5.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 80.0);
      return builder.add(Attributes.ATTACK_KNOCKBACK, 0.1);
   }

   private PlayState movementPredicate(AnimationState event) {
      if (this.animationprocedure.equals("empty")) {
         if (event.isMoving() || !(event.getLimbSwingAmount() > -0.15F) || !(event.getLimbSwingAmount() < 0.15F)) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("animation.spiderjumping.scurrying"));
         } else if (this.isDeadOrDying()) {
            return event.setAndContinue(RawAnimation.begin().thenPlay("animation.spiderjumping.death"));
         } else if (this.isInWaterOrBubble()) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("animation.spiderjumping.idle"));
         } else if (this.isShiftKeyDown()) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("animation.spiderjumping.grab"));
         } else {
            return this.isSprinting()
               ? event.setAndContinue(RawAnimation.begin().thenLoop("animation.spiderjumping.ritual"))
               : event.setAndContinue(RawAnimation.begin().thenLoop("animation.spiderjumping.idle"));
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
         return event.setAndContinue(RawAnimation.begin().thenPlay("animation.spiderjumping.attack"));
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
      if (this.deathTime == 15) {
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
