package net.arphex.entity;

import java.util.EnumSet;
import java.util.List;
import net.arphex.init.ArphexModEntities;
import net.arphex.procedures.ScarabSummonEntityIsHurtProcedure;
import net.arphex.procedures.ScarabSummonOnEntityTickUpdateProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
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
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.Goal.Flag;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.Level;
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

public class ScarabSummonEntity extends TamableAnimal implements GeoEntity {
   public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(ScarabSummonEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(ScarabSummonEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(ScarabSummonEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> DATA_scarab = SynchedEntityData.defineId(ScarabSummonEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<Boolean> DATA_greenfound = SynchedEntityData.defineId(ScarabSummonEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<Boolean> DATA_brownfound = SynchedEntityData.defineId(ScarabSummonEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<Boolean> DATA_greengoldfound = SynchedEntityData.defineId(ScarabSummonEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<Boolean> DATA_iridescentfound = SynchedEntityData.defineId(ScarabSummonEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<Boolean> DATA_purplefound = SynchedEntityData.defineId(ScarabSummonEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<Boolean> DATA_goldfound = SynchedEntityData.defineId(ScarabSummonEntity.class, EntityDataSerializers.BOOLEAN);
   private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
   private boolean swinging;
   private boolean lastloop;
   private long lastSwing;
   public String animationprocedure = "empty";

   public ScarabSummonEntity(SpawnEntity packet, Level world) {
      this((EntityType<ScarabSummonEntity>)ArphexModEntities.SCARAB_SUMMON.get(), world);
   }

   public ScarabSummonEntity(EntityType<ScarabSummonEntity> type, Level world) {
      super(type, world);
      this.xpReward = 0;
      this.setNoAi(false);
      this.setMaxUpStep(0.6F);
      this.moveControl = new FlyingMoveControl(this, 10, true);
   }

   protected void defineSynchedData() {
      super.defineSynchedData();
      this.entityData.define(SHOOT, false);
      this.entityData.define(ANIMATION, "undefined");
      this.entityData.define(TEXTURE, "scarab2");
      this.entityData.define(DATA_scarab, "none");
      this.entityData.define(DATA_greenfound, false);
      this.entityData.define(DATA_brownfound, false);
      this.entityData.define(DATA_greengoldfound, false);
      this.entityData.define(DATA_iridescentfound, false);
      this.entityData.define(DATA_purplefound, false);
      this.entityData.define(DATA_goldfound, false);
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

   protected PathNavigation createNavigation(Level world) {
      return new FlyingPathNavigation(this, world);
   }

   protected void registerGoals() {
      super.registerGoals();
      this.goalSelector
         .addGoal(
            1,
            new Goal() {
               {
                  this.setFlags(EnumSet.of(Flag.MOVE));
               }

               public boolean canUse() {
                  return ScarabSummonEntity.this.getTarget() != null && !ScarabSummonEntity.this.getMoveControl().hasWanted();
               }

               public boolean canContinueToUse() {
                  return ScarabSummonEntity.this.getMoveControl().hasWanted()
                     && ScarabSummonEntity.this.getTarget() != null
                     && ScarabSummonEntity.this.getTarget().isAlive();
               }

               public void start() {
                  LivingEntity livingentity = ScarabSummonEntity.this.getTarget();
                  Vec3 vec3d = livingentity.getEyePosition(1.0F);
                  ScarabSummonEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1.0);
               }

               public void tick() {
                  LivingEntity livingentity = ScarabSummonEntity.this.getTarget();
                  if (ScarabSummonEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
                     ScarabSummonEntity.this.doHurtTarget(livingentity);
                  } else {
                     double d0 = ScarabSummonEntity.this.distanceToSqr(livingentity);
                     if (d0 < 16.0) {
                        Vec3 vec3d = livingentity.getEyePosition(1.0F);
                        ScarabSummonEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1.0);
                     }
                  }
               }
            }
         );
      this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
      this.goalSelector.addGoal(3, new RandomStrollGoal(this, 0.8, 20) {
         protected Vec3 getPosition() {
            RandomSource random = ScarabSummonEntity.this.getRandom();
            double dir_x = ScarabSummonEntity.this.getX() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double dir_y = ScarabSummonEntity.this.getY() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double dir_z = ScarabSummonEntity.this.getZ() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            return new Vec3(dir_x, dir_y, dir_z);
         }
      });
      this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
      this.goalSelector.addGoal(5, new FloatGoal(this));
   }

   public MobType getMobType() {
      return MobType.ARTHROPOD;
   }

   public void playStepSound(BlockPos pos, BlockState blockIn) {
      this.playSound((SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:rhinobeetlefly")), 0.15F, 1.0F);
   }

   public SoundEvent getHurtSound(DamageSource ds) {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
   }

   public SoundEvent getDeathSound() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
   }

   public boolean causeFallDamage(float l, float d, DamageSource source) {
      return false;
   }

   public boolean hurt(DamageSource source, float amount) {
      ScarabSummonEntityIsHurtProcedure.execute(this);
      if (source.getDirectEntity() instanceof ThrownPotion || source.getDirectEntity() instanceof AreaEffectCloud) {
         return false;
      } else if (source.is(DamageTypes.FALL)) {
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
      compound.putString("Datascarab", (String)this.entityData.get(DATA_scarab));
      compound.putBoolean("Datagreenfound", (Boolean)this.entityData.get(DATA_greenfound));
      compound.putBoolean("Databrownfound", (Boolean)this.entityData.get(DATA_brownfound));
      compound.putBoolean("Datagreengoldfound", (Boolean)this.entityData.get(DATA_greengoldfound));
      compound.putBoolean("Datairidescentfound", (Boolean)this.entityData.get(DATA_iridescentfound));
      compound.putBoolean("Datapurplefound", (Boolean)this.entityData.get(DATA_purplefound));
      compound.putBoolean("Datagoldfound", (Boolean)this.entityData.get(DATA_goldfound));
   }

   public void readAdditionalSaveData(CompoundTag compound) {
      super.readAdditionalSaveData(compound);
      if (compound.contains("Texture")) {
         this.setTexture(compound.getString("Texture"));
      }

      if (compound.contains("Datascarab")) {
         this.entityData.set(DATA_scarab, compound.getString("Datascarab"));
      }

      if (compound.contains("Datagreenfound")) {
         this.entityData.set(DATA_greenfound, compound.getBoolean("Datagreenfound"));
      }

      if (compound.contains("Databrownfound")) {
         this.entityData.set(DATA_brownfound, compound.getBoolean("Databrownfound"));
      }

      if (compound.contains("Datagreengoldfound")) {
         this.entityData.set(DATA_greengoldfound, compound.getBoolean("Datagreengoldfound"));
      }

      if (compound.contains("Datairidescentfound")) {
         this.entityData.set(DATA_iridescentfound, compound.getBoolean("Datairidescentfound"));
      }

      if (compound.contains("Datapurplefound")) {
         this.entityData.set(DATA_purplefound, compound.getBoolean("Datapurplefound"));
      }

      if (compound.contains("Datagoldfound")) {
         this.entityData.set(DATA_goldfound, compound.getBoolean("Datagoldfound"));
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
      ScarabSummonOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
      this.refreshDimensions();
   }

   public EntityDimensions getDimensions(Pose p_33597_) {
      return super.getDimensions(p_33597_).scale(0.3F);
   }

   public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
      ScarabSummonEntity retval = (ScarabSummonEntity)((EntityType)ArphexModEntities.SCARAB_SUMMON.get()).create(serverWorld);
      retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
      return retval;
   }

   public boolean isFood(ItemStack stack) {
      return List.of().contains(stack.getItem());
   }

   public boolean isPushable() {
      return false;
   }

   protected void doPush(Entity entityIn) {
   }

   protected void pushEntities() {
   }

   protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
   }

   public void setNoGravity(boolean ignored) {
      super.setNoGravity(true);
   }

   public void aiStep() {
      super.aiStep();
      this.updateSwingTime();
      this.setNoGravity(true);
   }

   public static void init() {
   }

   public static Builder createAttributes() {
      Builder builder = Mob.createMobAttributes();
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
      builder = builder.add(Attributes.MAX_HEALTH, 1024.0);
      builder = builder.add(Attributes.ARMOR, 100.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 3.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 16.0);
      return builder.add(Attributes.FLYING_SPEED, 0.3);
   }

   private PlayState movementPredicate(AnimationState event) {
      return this.animationprocedure.equals("empty") ? event.setAndContinue(RawAnimation.begin().thenLoop("animation.beetlerhino.flying")) : PlayState.STOP;
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
      data.add(new AnimationController[]{new AnimationController(this, "movement", 4, this::movementPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "procedure", 4, this::procedurePredicate)});
   }

   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
   }
}
