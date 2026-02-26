package net.arphex.entity;

import java.util.List;
import net.arphex.init.ArphexModEntities;
import net.arphex.procedures.CheckOwnedProcedure;
import net.arphex.procedures.ConstrictingUpwardsProcedure;
import net.arphex.procedures.CrabFollowProcedure;
import net.arphex.procedures.CrabLarvaeEntityIsHurtProcedure;
import net.arphex.procedures.CrabLarvaeHitboxProcedure;
import net.arphex.procedures.CrabLarvaeOnEntityTickUpdateProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.TryFindWaterGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.Level;
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

public class CrabLarvaeEntity extends TamableAnimal implements GeoEntity {
   public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(CrabLarvaeEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(CrabLarvaeEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(CrabLarvaeEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<Integer> DATA_grabbingtime = SynchedEntityData.defineId(CrabLarvaeEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<Integer> DATA_grabwait = SynchedEntityData.defineId(CrabLarvaeEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<Boolean> DATA_sittingmode = SynchedEntityData.defineId(CrabLarvaeEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<Integer> DATA_crab_growth = SynchedEntityData.defineId(CrabLarvaeEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<Boolean> DATA_following = SynchedEntityData.defineId(CrabLarvaeEntity.class, EntityDataSerializers.BOOLEAN);
   private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
   private boolean swinging;
   private boolean lastloop;
   private long lastSwing;
   public String animationprocedure = "empty";

   public CrabLarvaeEntity(SpawnEntity packet, Level world) {
      this((EntityType<CrabLarvaeEntity>)ArphexModEntities.CRAB_LARVAE.get(), world);
   }

   public CrabLarvaeEntity(EntityType<CrabLarvaeEntity> type, Level world) {
      super(type, world);
      this.xpReward = 5;
      this.setNoAi(false);
      this.setMaxUpStep(1.0F);
   }

   protected void defineSynchedData() {
      super.defineSynchedData();
      this.entityData.define(SHOOT, false);
      this.entityData.define(ANIMATION, "undefined");
      this.entityData.define(TEXTURE, "crablarvae");
      this.entityData.define(DATA_grabbingtime, 0);
      this.entityData.define(DATA_grabwait, 0);
      this.entityData.define(DATA_sittingmode, false);
      this.entityData.define(DATA_crab_growth, 0);
      this.entityData.define(DATA_following, true);
   }

   public void setTexture(String texture) {
      this.entityData.set(TEXTURE, texture);
   }

   public String getTexture() {
      return (String)this.entityData.get(TEXTURE);
   }

   protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
      return 1.5F;
   }

   public Packet<ClientGamePacketListener> getAddEntityPacket() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   protected void registerGoals() {
      super.registerGoals();
      this.targetSelector.addGoal(1, new OwnerHurtTargetGoal(this) {
         public boolean canUse() {
            double x = CrabLarvaeEntity.this.getX();
            double y = CrabLarvaeEntity.this.getY();
            double z = CrabLarvaeEntity.this.getZ();
            Entity entity = CrabLarvaeEntity.this;
            Level world = CrabLarvaeEntity.this.level();
            return super.canUse() && CheckOwnedProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = CrabLarvaeEntity.this.getX();
            double y = CrabLarvaeEntity.this.getY();
            double z = CrabLarvaeEntity.this.getZ();
            Entity entity = CrabLarvaeEntity.this;
            Level world = CrabLarvaeEntity.this.level();
            return super.canContinueToUse() && CheckOwnedProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(2, new OwnerHurtByTargetGoal(this) {
         public boolean canUse() {
            double x = CrabLarvaeEntity.this.getX();
            double y = CrabLarvaeEntity.this.getY();
            double z = CrabLarvaeEntity.this.getZ();
            Entity entity = CrabLarvaeEntity.this;
            Level world = CrabLarvaeEntity.this.level();
            return super.canUse() && CheckOwnedProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = CrabLarvaeEntity.this.getX();
            double y = CrabLarvaeEntity.this.getY();
            double z = CrabLarvaeEntity.this.getZ();
            Entity entity = CrabLarvaeEntity.this;
            Level world = CrabLarvaeEntity.this.level();
            return super.canContinueToUse() && CheckOwnedProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 1.3, 11.0F, 8.0F, false) {
         public boolean canUse() {
            double x = CrabLarvaeEntity.this.getX();
            double y = CrabLarvaeEntity.this.getY();
            double z = CrabLarvaeEntity.this.getZ();
            Entity entity = CrabLarvaeEntity.this;
            Level world = CrabLarvaeEntity.this.level();
            return super.canUse() && CrabFollowProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = CrabLarvaeEntity.this.getX();
            double y = CrabLarvaeEntity.this.getY();
            double z = CrabLarvaeEntity.this.getZ();
            Entity entity = CrabLarvaeEntity.this;
            Level world = CrabLarvaeEntity.this.level();
            return super.canContinueToUse() && CrabFollowProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 0.9, false) {
         protected double getAttackReachSqr(LivingEntity entity) {
            return 16.0;
         }

         public boolean canUse() {
            double x = CrabLarvaeEntity.this.getX();
            double y = CrabLarvaeEntity.this.getY();
            double z = CrabLarvaeEntity.this.getZ();
            Entity entity = CrabLarvaeEntity.this;
            Level world = CrabLarvaeEntity.this.level();
            return super.canUse() && ConstrictingUpwardsProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = CrabLarvaeEntity.this.getX();
            double y = CrabLarvaeEntity.this.getY();
            double z = CrabLarvaeEntity.this.getZ();
            Entity entity = CrabLarvaeEntity.this;
            Level world = CrabLarvaeEntity.this.level();
            return super.canContinueToUse() && ConstrictingUpwardsProcedure.execute(entity);
         }
      });
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, Player.class, false, false));
      this.targetSelector.addGoal(6, (new HurtByTargetGoal(this) {
         public boolean canUse() {
            double x = CrabLarvaeEntity.this.getX();
            double y = CrabLarvaeEntity.this.getY();
            double z = CrabLarvaeEntity.this.getZ();
            Entity entity = CrabLarvaeEntity.this;
            Level world = CrabLarvaeEntity.this.level();
            return super.canUse() && ConstrictingUpwardsProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = CrabLarvaeEntity.this.getX();
            double y = CrabLarvaeEntity.this.getY();
            double z = CrabLarvaeEntity.this.getZ();
            Entity entity = CrabLarvaeEntity.this;
            Level world = CrabLarvaeEntity.this.level();
            return super.canContinueToUse() && ConstrictingUpwardsProcedure.execute(entity);
         }
      }).setAlertOthers(new Class[0]));
      this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 60.0F));
      this.goalSelector.addGoal(8, new RandomSwimmingGoal(this, 2.0, 40) {
         public boolean canUse() {
            double x = CrabLarvaeEntity.this.getX();
            double y = CrabLarvaeEntity.this.getY();
            double z = CrabLarvaeEntity.this.getZ();
            Entity entity = CrabLarvaeEntity.this;
            Level world = CrabLarvaeEntity.this.level();
            return super.canUse() && ConstrictingUpwardsProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = CrabLarvaeEntity.this.getX();
            double y = CrabLarvaeEntity.this.getY();
            double z = CrabLarvaeEntity.this.getZ();
            Entity entity = CrabLarvaeEntity.this;
            Level world = CrabLarvaeEntity.this.level();
            return super.canContinueToUse() && ConstrictingUpwardsProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(9, new RandomStrollGoal(this, 1.0) {
         public boolean canUse() {
            double x = CrabLarvaeEntity.this.getX();
            double y = CrabLarvaeEntity.this.getY();
            double z = CrabLarvaeEntity.this.getZ();
            Entity entity = CrabLarvaeEntity.this;
            Level world = CrabLarvaeEntity.this.level();
            return super.canUse() && ConstrictingUpwardsProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = CrabLarvaeEntity.this.getX();
            double y = CrabLarvaeEntity.this.getY();
            double z = CrabLarvaeEntity.this.getZ();
            Entity entity = CrabLarvaeEntity.this;
            Level world = CrabLarvaeEntity.this.level();
            return super.canContinueToUse() && ConstrictingUpwardsProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(10, new TryFindWaterGoal(this));
   }

   public MobType getMobType() {
      return MobType.ARTHROPOD;
   }

   public SoundEvent getHurtSound(DamageSource ds) {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:creepy_arthropod_large"));
   }

   public SoundEvent getDeathSound() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:creepy_arthropod_large"));
   }

   public boolean hurt(DamageSource source, float amount) {
      CrabLarvaeEntityIsHurtProcedure.execute(this);
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
      } else if (source.is(DamageTypes.EXPLOSION)) {
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
      compound.putInt("Datagrabbingtime", (Integer)this.entityData.get(DATA_grabbingtime));
      compound.putInt("Datagrabwait", (Integer)this.entityData.get(DATA_grabwait));
      compound.putBoolean("Datasittingmode", (Boolean)this.entityData.get(DATA_sittingmode));
      compound.putInt("Datacrab_growth", (Integer)this.entityData.get(DATA_crab_growth));
      compound.putBoolean("Datafollowing", (Boolean)this.entityData.get(DATA_following));
   }

   public void readAdditionalSaveData(CompoundTag compound) {
      super.readAdditionalSaveData(compound);
      if (compound.contains("Texture")) {
         this.setTexture(compound.getString("Texture"));
      }

      if (compound.contains("Datagrabbingtime")) {
         this.entityData.set(DATA_grabbingtime, compound.getInt("Datagrabbingtime"));
      }

      if (compound.contains("Datagrabwait")) {
         this.entityData.set(DATA_grabwait, compound.getInt("Datagrabwait"));
      }

      if (compound.contains("Datasittingmode")) {
         this.entityData.set(DATA_sittingmode, compound.getBoolean("Datasittingmode"));
      }

      if (compound.contains("Datacrab_growth")) {
         this.entityData.set(DATA_crab_growth, compound.getInt("Datacrab_growth"));
      }

      if (compound.contains("Datafollowing")) {
         this.entityData.set(DATA_following, compound.getBoolean("Datafollowing"));
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
      CrabLarvaeOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
      this.refreshDimensions();
   }

   public EntityDimensions getDimensions(Pose p_33597_) {
      Level world = this.level();
      double x = this.getX();
      double y = this.getY();
      double z = this.getZ();
      return super.getDimensions(p_33597_).scale((float)CrabLarvaeHitboxProcedure.execute(this));
   }

   public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
      CrabLarvaeEntity retval = (CrabLarvaeEntity)((EntityType)ArphexModEntities.CRAB_LARVAE.get()).create(serverWorld);
      retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
      return retval;
   }

   public boolean isFood(ItemStack stack) {
      return List.of().contains(stack.getItem());
   }

   public void aiStep() {
      super.aiStep();
      this.updateSwingTime();
   }

   public static void init() {
   }

   public static Builder createAttributes() {
      Builder builder = Mob.createMobAttributes();
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.35);
      builder = builder.add(Attributes.MAX_HEALTH, 200.0);
      builder = builder.add(Attributes.ARMOR, 5.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 8.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 70.0);
      builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
      return builder.add(Attributes.ATTACK_KNOCKBACK, 3.0);
   }

   private PlayState movementPredicate(AnimationState event) {
      if (this.animationprocedure.equals("empty")) {
         if (event.isMoving() || !(event.getLimbSwingAmount() > -0.15F) || !(event.getLimbSwingAmount() < 0.15F)) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("animation.crabconstrictor.scurrying"));
         } else if (this.isDeadOrDying()) {
            return event.setAndContinue(RawAnimation.begin().thenPlay("animation.crabconstrictor.death"));
         } else {
            return this.isShiftKeyDown()
               ? event.setAndContinue(RawAnimation.begin().thenLoop("animation.crabconstrictor.larvaegrab"))
               : event.setAndContinue(RawAnimation.begin().thenLoop("animation.crabconstrictor.idle"));
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
         return event.setAndContinue(RawAnimation.begin().thenPlay("animation.crabconstrictor.attack"));
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
      if (this.deathTime == 90) {
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
