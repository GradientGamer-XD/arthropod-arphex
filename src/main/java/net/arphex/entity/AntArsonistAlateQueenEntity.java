package net.arphex.entity;

import java.util.List;
import net.arphex.init.ArphexModEntities;
import net.arphex.procedures.AntArsonistQueenOnEntityTickUpdateProcedure;
import net.arphex.procedures.AntQueenHitboxProcedure;
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
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveBackToVillageGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
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

public class AntArsonistAlateQueenEntity extends TamableAnimal implements GeoEntity {
   public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(AntArsonistAlateQueenEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(AntArsonistAlateQueenEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(AntArsonistAlateQueenEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<Boolean> DATA_alatequeen = SynchedEntityData.defineId(
      AntArsonistAlateQueenEntity.class, EntityDataSerializers.BOOLEAN
   );
   public static final EntityDataAccessor<Integer> DATA_queenlevel = SynchedEntityData.defineId(AntArsonistAlateQueenEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<String> DATA_antcommand = SynchedEntityData.defineId(AntArsonistAlateQueenEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<Integer> DATA_Xarea = SynchedEntityData.defineId(AntArsonistAlateQueenEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<Integer> DATA_Yarea = SynchedEntityData.defineId(AntArsonistAlateQueenEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<Integer> DATA_Zarea = SynchedEntityData.defineId(AntArsonistAlateQueenEntity.class, EntityDataSerializers.INT);
   private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
   private boolean swinging;
   private boolean lastloop;
   private long lastSwing;
   public String animationprocedure = "empty";

   public AntArsonistAlateQueenEntity(SpawnEntity packet, Level world) {
      this((EntityType<AntArsonistAlateQueenEntity>)ArphexModEntities.ANT_ARSONIST_ALATE_QUEEN.get(), world);
   }

   public AntArsonistAlateQueenEntity(EntityType<AntArsonistAlateQueenEntity> type, Level world) {
      super(type, world);
      this.xpReward = 3;
      this.setNoAi(false);
      this.setMaxUpStep(0.6F);
   }

   protected void defineSynchedData() {
      super.defineSynchedData();
      this.entityData.define(SHOOT, false);
      this.entityData.define(ANIMATION, "undefined");
      this.entityData.define(TEXTURE, "antsoldier");
      this.entityData.define(DATA_alatequeen, false);
      this.entityData.define(DATA_queenlevel, 0);
      this.entityData.define(DATA_antcommand, "none");
      this.entityData.define(DATA_Xarea, 0);
      this.entityData.define(DATA_Yarea, 0);
      this.entityData.define(DATA_Zarea, 0);
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
      this.goalSelector.addGoal(1, new TemptGoal(this, 1.0, Ingredient.of(new ItemLike[]{Items.GOLDEN_APPLE}), false));
      this.goalSelector.addGoal(2, new TemptGoal(this, 1.0, Ingredient.of(new ItemLike[]{Items.ENCHANTED_GOLDEN_APPLE}), false));
      this.goalSelector.addGoal(3, new MoveBackToVillageGoal(this, 0.6, false));
      this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.2, false) {
         protected double getAttackReachSqr(LivingEntity entity) {
            return 16.0;
         }
      });
      this.targetSelector.addGoal(5, new HurtByTargetGoal(this, new Class[0]).setAlertOthers(new Class[0]));
      this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0));
      this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
      this.goalSelector.addGoal(8, new FloatGoal(this));
      this.goalSelector.addGoal(9, new RandomSwimmingGoal(this, 1.0, 40));
   }

   public MobType getMobType() {
      return MobType.ARTHROPOD;
   }

   public double getPassengersRidingOffset() {
      return super.getPassengersRidingOffset() + -0.4;
   }

   public SoundEvent getAmbientSound() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:creepy_arthropod_tiny"));
   }

   public SoundEvent getDeathSound() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
   }

   public boolean hurt(DamageSource source, float amount) {
      if (source.is(DamageTypes.IN_FIRE)) {
         return false;
      } else if (source.getDirectEntity() instanceof AbstractArrow) {
         return false;
      } else if (source.is(DamageTypes.FALL)) {
         return false;
      } else {
         return source.is(DamageTypes.CACTUS) ? false : super.hurt(source, amount);
      }
   }

   public void addAdditionalSaveData(CompoundTag compound) {
      super.addAdditionalSaveData(compound);
      compound.putString("Texture", this.getTexture());
      compound.putBoolean("Dataalatequeen", (Boolean)this.entityData.get(DATA_alatequeen));
      compound.putInt("Dataqueenlevel", (Integer)this.entityData.get(DATA_queenlevel));
      compound.putString("Dataantcommand", (String)this.entityData.get(DATA_antcommand));
      compound.putInt("DataXarea", (Integer)this.entityData.get(DATA_Xarea));
      compound.putInt("DataYarea", (Integer)this.entityData.get(DATA_Yarea));
      compound.putInt("DataZarea", (Integer)this.entityData.get(DATA_Zarea));
   }

   public void readAdditionalSaveData(CompoundTag compound) {
      super.readAdditionalSaveData(compound);
      if (compound.contains("Texture")) {
         this.setTexture(compound.getString("Texture"));
      }

      if (compound.contains("Dataalatequeen")) {
         this.entityData.set(DATA_alatequeen, compound.getBoolean("Dataalatequeen"));
      }

      if (compound.contains("Dataqueenlevel")) {
         this.entityData.set(DATA_queenlevel, compound.getInt("Dataqueenlevel"));
      }

      if (compound.contains("Dataantcommand")) {
         this.entityData.set(DATA_antcommand, compound.getString("Dataantcommand"));
      }

      if (compound.contains("DataXarea")) {
         this.entityData.set(DATA_Xarea, compound.getInt("DataXarea"));
      }

      if (compound.contains("DataYarea")) {
         this.entityData.set(DATA_Yarea, compound.getInt("DataYarea"));
      }

      if (compound.contains("DataZarea")) {
         this.entityData.set(DATA_Zarea, compound.getInt("DataZarea"));
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
      AntArsonistQueenOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
      this.refreshDimensions();
   }

   public EntityDimensions getDimensions(Pose p_33597_) {
      Level world = this.level();
      double x = this.getX();
      double y = this.getY();
      double z = this.getZ();
      return super.getDimensions(p_33597_).scale((float)AntQueenHitboxProcedure.execute(this));
   }

   public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
      AntArsonistAlateQueenEntity retval = (AntArsonistAlateQueenEntity)((EntityType)ArphexModEntities.ANT_ARSONIST_ALATE_QUEEN.get()).create(serverWorld);
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
      builder = builder.add(Attributes.MAX_HEALTH, 50.0);
      builder = builder.add(Attributes.ARMOR, 6.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 8.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 60.0);
      builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.5);
      return builder.add(Attributes.ATTACK_KNOCKBACK, 0.2);
   }

   private PlayState movementPredicate(AnimationState event) {
      if (!this.animationprocedure.equals("empty")) {
         return PlayState.STOP;
      } else if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F) || !(event.getLimbSwingAmount() < 0.15F)) && this.onGround()) {
         return event.setAndContinue(RawAnimation.begin().thenLoop("animation.antalate.scurrying"));
      } else if (this.isDeadOrDying()) {
         return event.setAndContinue(RawAnimation.begin().thenPlay("animation.antalate.death"));
      } else if (this.isInWaterOrBubble()) {
         return event.setAndContinue(RawAnimation.begin().thenLoop("animation.antalate.scurrying"));
      } else if (this.isShiftKeyDown()) {
         return event.setAndContinue(RawAnimation.begin().thenLoop("animation.antalate.grab"));
      } else {
         return !this.onGround()
            ? event.setAndContinue(RawAnimation.begin().thenLoop("animation.antalate.flying"))
            : event.setAndContinue(RawAnimation.begin().thenLoop("animation.antalate.idle"));
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
         return event.setAndContinue(RawAnimation.begin().thenPlay("animation.antalate.attack"));
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
      if (this.deathTime == 10) {
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
      data.add(new AnimationController[]{new AnimationController(this, "movement", 1, this::movementPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "attacking", 1, this::attackingPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "procedure", 1, this::procedurePredicate)});
   }

   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
   }
}
