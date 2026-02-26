package net.arphex.entity;

import java.util.List;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModItems;
import net.arphex.procedures.CheckOwnedProcedure;
import net.arphex.procedures.NotTamedConditionProcedure;
import net.arphex.procedures.SegmentedHeadOnEntityTickUpdateProcedure;
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
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
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

public class ArthropleuraAbominationEntity extends TamableAnimal implements GeoEntity {
   public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(ArthropleuraAbominationEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(ArthropleuraAbominationEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(ArthropleuraAbominationEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<Integer> DATA_rotationlimiter = SynchedEntityData.defineId(
      ArthropleuraAbominationEntity.class, EntityDataSerializers.INT
   );
   public static final EntityDataAccessor<Integer> DATA_cooldown_head = SynchedEntityData.defineId(
      ArthropleuraAbominationEntity.class, EntityDataSerializers.INT
   );
   public static final EntityDataAccessor<String> DATA_uuidmap = SynchedEntityData.defineId(ArthropleuraAbominationEntity.class, EntityDataSerializers.STRING);
   private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
   private boolean swinging;
   private boolean lastloop;
   private long lastSwing;
   public String animationprocedure = "empty";

   public ArthropleuraAbominationEntity(SpawnEntity packet, Level world) {
      this((EntityType<ArthropleuraAbominationEntity>)ArphexModEntities.ARTHROPLEURA_ABOMINATION.get(), world);
   }

   public ArthropleuraAbominationEntity(EntityType<ArthropleuraAbominationEntity> type, Level world) {
      super(type, world);
      this.xpReward = 250;
      this.setNoAi(false);
      this.setMaxUpStep(1.1F);
   }

   protected void defineSynchedData() {
      super.defineSynchedData();
      this.entityData.define(SHOOT, false);
      this.entityData.define(ANIMATION, "undefined");
      this.entityData.define(TEXTURE, "arthropleura");
      this.entityData.define(DATA_rotationlimiter, 0);
      this.entityData.define(DATA_cooldown_head, 20);
      this.entityData.define(DATA_uuidmap, "none");
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
      this.targetSelector.addGoal(1, new OwnerHurtTargetGoal(this));
      this.goalSelector.addGoal(2, new OwnerHurtByTargetGoal(this));
      this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2, false) {
         protected double getAttackReachSqr(LivingEntity entity) {
            return 9.0;
         }

         public boolean canUse() {
            double x = ArthropleuraAbominationEntity.this.getX();
            double y = ArthropleuraAbominationEntity.this.getY();
            double z = ArthropleuraAbominationEntity.this.getZ();
            Entity entity = ArthropleuraAbominationEntity.this;
            Level world = ArthropleuraAbominationEntity.this.level();
            return super.canUse() && CheckOwnedProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = ArthropleuraAbominationEntity.this.getX();
            double y = ArthropleuraAbominationEntity.this.getY();
            double z = ArthropleuraAbominationEntity.this.getZ();
            Entity entity = ArthropleuraAbominationEntity.this;
            Level world = ArthropleuraAbominationEntity.this.level();
            return super.canContinueToUse() && CheckOwnedProcedure.execute(entity);
         }
      });
      this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, Player.class, false, false) {
         public boolean canUse() {
            double x = ArthropleuraAbominationEntity.this.getX();
            double y = ArthropleuraAbominationEntity.this.getY();
            double z = ArthropleuraAbominationEntity.this.getZ();
            Entity entity = ArthropleuraAbominationEntity.this;
            Level world = ArthropleuraAbominationEntity.this.level();
            return super.canUse() && NotTamedConditionProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = ArthropleuraAbominationEntity.this.getX();
            double y = ArthropleuraAbominationEntity.this.getY();
            double z = ArthropleuraAbominationEntity.this.getZ();
            Entity entity = ArthropleuraAbominationEntity.this;
            Level world = ArthropleuraAbominationEntity.this.level();
            return super.canContinueToUse() && NotTamedConditionProcedure.execute(entity);
         }
      });
      this.targetSelector.addGoal(5, new HurtByTargetGoal(this) {
         public boolean canUse() {
            double x = ArthropleuraAbominationEntity.this.getX();
            double y = ArthropleuraAbominationEntity.this.getY();
            double z = ArthropleuraAbominationEntity.this.getZ();
            Entity entity = ArthropleuraAbominationEntity.this;
            Level world = ArthropleuraAbominationEntity.this.level();
            return super.canUse() && CheckOwnedProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = ArthropleuraAbominationEntity.this.getX();
            double y = ArthropleuraAbominationEntity.this.getY();
            double z = ArthropleuraAbominationEntity.this.getZ();
            Entity entity = ArthropleuraAbominationEntity.this;
            Level world = ArthropleuraAbominationEntity.this.level();
            return super.canContinueToUse() && CheckOwnedProcedure.execute(entity);
         }
      });
      this.targetSelector.addGoal(6, new NearestAttackableTargetGoal(this, RoachRiverspawnEntity.class, false, false));
      this.goalSelector.addGoal(7, new AvoidEntityGoal<SegmentedBodyEntity>(this, SegmentedBodyEntity.class, 6.0F, 1.0, 1.2) {
         public boolean canUse() {
            double x = ArthropleuraAbominationEntity.this.getX();
            double y = ArthropleuraAbominationEntity.this.getY();
            double z = ArthropleuraAbominationEntity.this.getZ();
            Entity entity = ArthropleuraAbominationEntity.this;
            Level world = ArthropleuraAbominationEntity.this.level();
            return super.canUse() && NotTamedConditionProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = ArthropleuraAbominationEntity.this.getX();
            double y = ArthropleuraAbominationEntity.this.getY();
            double z = ArthropleuraAbominationEntity.this.getZ();
            Entity entity = ArthropleuraAbominationEntity.this;
            Level world = ArthropleuraAbominationEntity.this.level();
            return super.canContinueToUse() && NotTamedConditionProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(8, new RandomStrollGoal(this, 1.6) {
         public boolean canUse() {
            double x = ArthropleuraAbominationEntity.this.getX();
            double y = ArthropleuraAbominationEntity.this.getY();
            double z = ArthropleuraAbominationEntity.this.getZ();
            Entity entity = ArthropleuraAbominationEntity.this;
            Level world = ArthropleuraAbominationEntity.this.level();
            return super.canUse() && NotTamedConditionProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = ArthropleuraAbominationEntity.this.getX();
            double y = ArthropleuraAbominationEntity.this.getY();
            double z = ArthropleuraAbominationEntity.this.getZ();
            Entity entity = ArthropleuraAbominationEntity.this;
            Level world = ArthropleuraAbominationEntity.this.level();
            return super.canContinueToUse() && NotTamedConditionProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(9, new FloatGoal(this));
   }

   public MobType getMobType() {
      return MobType.ARTHROPOD;
   }

   public double getPassengersRidingOffset() {
      return super.getPassengersRidingOffset() + 0.2;
   }

   public SoundEvent getHurtSound(DamageSource ds) {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
   }

   public SoundEvent getDeathSound() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
   }

   public boolean hurt(DamageSource source, float amount) {
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
      } else if (source.is(DamageTypes.WITHER)) {
         return false;
      } else {
         return source.is(DamageTypes.WITHER_SKULL) ? false : super.hurt(source, amount);
      }
   }

   public void addAdditionalSaveData(CompoundTag compound) {
      super.addAdditionalSaveData(compound);
      compound.putString("Texture", this.getTexture());
      compound.putInt("Datarotationlimiter", (Integer)this.entityData.get(DATA_rotationlimiter));
      compound.putInt("Datacooldown_head", (Integer)this.entityData.get(DATA_cooldown_head));
      compound.putString("Datauuidmap", (String)this.entityData.get(DATA_uuidmap));
   }

   public void readAdditionalSaveData(CompoundTag compound) {
      super.readAdditionalSaveData(compound);
      if (compound.contains("Texture")) {
         this.setTexture(compound.getString("Texture"));
      }

      if (compound.contains("Datarotationlimiter")) {
         this.entityData.set(DATA_rotationlimiter, compound.getInt("Datarotationlimiter"));
      }

      if (compound.contains("Datacooldown_head")) {
         this.entityData.set(DATA_cooldown_head, compound.getInt("Datacooldown_head"));
      }

      if (compound.contains("Datauuidmap")) {
         this.entityData.set(DATA_uuidmap, compound.getString("Datauuidmap"));
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

      sourceentity.startRiding(this);
      return retval;
   }

   public void baseTick() {
      super.baseTick();
      SegmentedHeadOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
      this.refreshDimensions();
   }

   public EntityDimensions getDimensions(Pose p_33597_) {
      return super.getDimensions(p_33597_).scale(1.0F);
   }

   public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
      ArthropleuraAbominationEntity retval = (ArthropleuraAbominationEntity)((EntityType)ArphexModEntities.ARTHROPLEURA_ABOMINATION.get()).create(serverWorld);
      retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
      return retval;
   }

   public boolean isFood(ItemStack stack) {
      return List.of((Item)ArphexModItems.PURPLE_SCARAB.get()).contains(stack.getItem());
   }

   public void travel(Vec3 dir) {
      Entity entity = this.getPassengers().isEmpty() ? null : (Entity)this.getPassengers().get(0);
      if (this.isVehicle()) {
         this.setYRot(entity.getYRot());
         this.yRotO = this.getYRot();
         this.setXRot(entity.getXRot() * 0.5F);
         this.setRot(this.getYRot(), this.getXRot());
         this.yBodyRot = entity.getYRot();
         this.yHeadRot = entity.getYRot();
         if (entity instanceof LivingEntity passenger) {
            this.setSpeed((float)this.getAttributeValue(Attributes.MOVEMENT_SPEED));
            float forward = passenger.zza;
            float strafe = 0.0F;
            super.travel(new Vec3((double)strafe, 0.0, (double)forward));
         }

         double d1 = this.getX() - this.xo;
         double d0 = this.getZ() - this.zo;
         float f1 = (float)Math.sqrt(d1 * d1 + d0 * d0) * 4.0F;
         if (f1 > 1.0F) {
            f1 = 1.0F;
         }

         this.walkAnimation.setSpeed(this.walkAnimation.speed() + (f1 - this.walkAnimation.speed()) * 0.4F);
         this.walkAnimation.position(this.walkAnimation.position() + this.walkAnimation.speed());
         this.calculateEntityAnimation(true);
      } else {
         super.travel(dir);
      }
   }

   public void aiStep() {
      super.aiStep();
      this.updateSwingTime();
   }

   public static void init() {
   }

   public static Builder createAttributes() {
      Builder builder = Mob.createMobAttributes();
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
      builder = builder.add(Attributes.MAX_HEALTH, 300.0);
      builder = builder.add(Attributes.ARMOR, 10.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 15.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 64.0);
      builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.3);
      return builder.add(Attributes.ATTACK_KNOCKBACK, 0.2);
   }

   private PlayState movementPredicate(AnimationState event) {
      if (this.animationprocedure.equals("empty")) {
         return !event.isMoving() && event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F
            ? event.setAndContinue(RawAnimation.begin().thenLoop("animation.arthropleura_head.idle"))
            : event.setAndContinue(RawAnimation.begin().thenLoop("animation.arthropleura_head.scurrying"));
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
      if (this.deathTime == 40) {
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

   public void makeStuckInBlock(BlockState state, Vec3 motionMultiplier) {
      if (!state.is(Blocks.COBWEB)) {
         super.makeStuckInBlock(state, motionMultiplier);
      }
   }
}
