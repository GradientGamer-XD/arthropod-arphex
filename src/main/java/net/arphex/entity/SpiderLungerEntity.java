package net.arphex.entity;

import java.util.List;
import javax.annotation.Nullable;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModItems;
import net.arphex.procedures.ArphexSpawnConfigUndergroundProcedure;
import net.arphex.procedures.LooklimRecluseProcedure;
import net.arphex.procedures.LungerFollowProcedure;
import net.arphex.procedures.NotTamedConditionProcedure;
import net.arphex.procedures.SpiderLungerEntityIsHurtProcedure;
import net.arphex.procedures.SpiderLungerOnEntityTickUpdateProcedure;
import net.arphex.procedures.SpiderLungerOnInitialEntitySpawnProcedure;
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
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.SpawnPlacements.Type;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.ai.goal.ClimbOnTopOfPowderSnowGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveBackToVillageGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
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
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap.Types;
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

public class SpiderLungerEntity extends TamableAnimal implements GeoEntity {
   public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(SpiderLungerEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(SpiderLungerEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(SpiderLungerEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<Integer> DATA_lunge_time = SynchedEntityData.defineId(SpiderLungerEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<Integer> DATA_attack_trigger_time = SynchedEntityData.defineId(SpiderLungerEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<Boolean> DATA_follow = SynchedEntityData.defineId(SpiderLungerEntity.class, EntityDataSerializers.BOOLEAN);
   private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
   private boolean swinging;
   private boolean lastloop;
   private long lastSwing;
   public String animationprocedure = "empty";

   public SpiderLungerEntity(SpawnEntity packet, Level world) {
      this((EntityType<SpiderLungerEntity>)ArphexModEntities.SPIDER_LUNGER.get(), world);
   }

   public SpiderLungerEntity(EntityType<SpiderLungerEntity> type, Level world) {
      super(type, world);
      this.xpReward = 5;
      this.setNoAi(false);
      this.setMaxUpStep(0.6F);
   }

   protected void defineSynchedData() {
      super.defineSynchedData();
      this.entityData.define(SHOOT, false);
      this.entityData.define(ANIMATION, "undefined");
      this.entityData.define(TEXTURE, "gianthuntsman");
      this.entityData.define(DATA_lunge_time, 0);
      this.entityData.define(DATA_attack_trigger_time, 0);
      this.entityData.define(DATA_follow, false);
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
      this.goalSelector.addGoal(1, new FollowOwnerGoal(this, 1.5, 10.0F, 2.0F, false) {
         public boolean canUse() {
            double x = SpiderLungerEntity.this.getX();
            double y = SpiderLungerEntity.this.getY();
            double z = SpiderLungerEntity.this.getZ();
            Entity entity = SpiderLungerEntity.this;
            Level world = SpiderLungerEntity.this.level();
            return super.canUse() && LungerFollowProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = SpiderLungerEntity.this.getX();
            double y = SpiderLungerEntity.this.getY();
            double z = SpiderLungerEntity.this.getZ();
            Entity entity = SpiderLungerEntity.this;
            Level world = SpiderLungerEntity.this.level();
            return super.canContinueToUse() && LungerFollowProcedure.execute(entity);
         }
      });
      this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this) {
         public boolean canUse() {
            double x = SpiderLungerEntity.this.getX();
            double y = SpiderLungerEntity.this.getY();
            double z = SpiderLungerEntity.this.getZ();
            Entity entity = SpiderLungerEntity.this;
            Level world = SpiderLungerEntity.this.level();
            return super.canUse() && LungerFollowProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = SpiderLungerEntity.this.getX();
            double y = SpiderLungerEntity.this.getY();
            double z = SpiderLungerEntity.this.getZ();
            Entity entity = SpiderLungerEntity.this;
            Level world = SpiderLungerEntity.this.level();
            return super.canContinueToUse() && LungerFollowProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(3, new OwnerHurtByTargetGoal(this) {
         public boolean canUse() {
            double x = SpiderLungerEntity.this.getX();
            double y = SpiderLungerEntity.this.getY();
            double z = SpiderLungerEntity.this.getZ();
            Entity entity = SpiderLungerEntity.this;
            Level world = SpiderLungerEntity.this.level();
            return super.canUse() && LungerFollowProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = SpiderLungerEntity.this.getX();
            double y = SpiderLungerEntity.this.getY();
            double z = SpiderLungerEntity.this.getZ();
            Entity entity = SpiderLungerEntity.this;
            Level world = SpiderLungerEntity.this.level();
            return super.canContinueToUse() && LungerFollowProcedure.execute(entity);
         }
      });
      this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, Player.class, false, false) {
         public boolean canUse() {
            double x = SpiderLungerEntity.this.getX();
            double y = SpiderLungerEntity.this.getY();
            double z = SpiderLungerEntity.this.getZ();
            Entity entity = SpiderLungerEntity.this;
            Level world = SpiderLungerEntity.this.level();
            return super.canUse() && NotTamedConditionProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = SpiderLungerEntity.this.getX();
            double y = SpiderLungerEntity.this.getY();
            double z = SpiderLungerEntity.this.getZ();
            Entity entity = SpiderLungerEntity.this;
            Level world = SpiderLungerEntity.this.level();
            return super.canContinueToUse() && NotTamedConditionProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.2, false) {
         protected double getAttackReachSqr(LivingEntity entity) {
            return 4.0;
         }
      });
      this.targetSelector.addGoal(6, new HurtByTargetGoal(this, new Class[0]).setAlertOthers(new Class[0]));
      this.goalSelector.addGoal(7, new ClimbOnTopOfPowderSnowGoal(this, this.level()));
      this.goalSelector.addGoal(8, new MoveBackToVillageGoal(this, 0.6, false));
      this.goalSelector.addGoal(9, new RandomStrollGoal(this, 1.0) {
         public boolean canUse() {
            double x = SpiderLungerEntity.this.getX();
            double y = SpiderLungerEntity.this.getY();
            double z = SpiderLungerEntity.this.getZ();
            Entity entity = SpiderLungerEntity.this;
            Level world = SpiderLungerEntity.this.level();
            return super.canUse() && LooklimRecluseProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = SpiderLungerEntity.this.getX();
            double y = SpiderLungerEntity.this.getY();
            double z = SpiderLungerEntity.this.getZ();
            Entity entity = SpiderLungerEntity.this;
            Level world = SpiderLungerEntity.this.level();
            return super.canContinueToUse() && LooklimRecluseProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(10, new RandomLookAroundGoal(this) {
         public boolean canUse() {
            double x = SpiderLungerEntity.this.getX();
            double y = SpiderLungerEntity.this.getY();
            double z = SpiderLungerEntity.this.getZ();
            Entity entity = SpiderLungerEntity.this;
            Level world = SpiderLungerEntity.this.level();
            return super.canUse() && LooklimRecluseProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = SpiderLungerEntity.this.getX();
            double y = SpiderLungerEntity.this.getY();
            double z = SpiderLungerEntity.this.getZ();
            Entity entity = SpiderLungerEntity.this;
            Level world = SpiderLungerEntity.this.level();
            return super.canContinueToUse() && LooklimRecluseProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(11, new FloatGoal(this));
   }

   public MobType getMobType() {
      return MobType.ARTHROPOD;
   }

   public double getPassengersRidingOffset() {
      return super.getPassengersRidingOffset() + -0.58;
   }

   public SoundEvent getAmbientSound() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:creepy_arthropod"));
   }

   public SoundEvent getHurtSound(DamageSource ds) {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.hurt"));
   }

   public SoundEvent getDeathSound() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.death"));
   }

   public boolean hurt(DamageSource source, float amount) {
      SpiderLungerEntityIsHurtProcedure.execute(this);
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
      SpiderLungerOnInitialEntitySpawnProcedure.execute(world, this);
      return retval;
   }

   public void addAdditionalSaveData(CompoundTag compound) {
      super.addAdditionalSaveData(compound);
      compound.putString("Texture", this.getTexture());
      compound.putInt("Datalunge_time", (Integer)this.entityData.get(DATA_lunge_time));
      compound.putInt("Dataattack_trigger_time", (Integer)this.entityData.get(DATA_attack_trigger_time));
      compound.putBoolean("Datafollow", (Boolean)this.entityData.get(DATA_follow));
   }

   public void readAdditionalSaveData(CompoundTag compound) {
      super.readAdditionalSaveData(compound);
      if (compound.contains("Texture")) {
         this.setTexture(compound.getString("Texture"));
      }

      if (compound.contains("Datalunge_time")) {
         this.entityData.set(DATA_lunge_time, compound.getInt("Datalunge_time"));
      }

      if (compound.contains("Dataattack_trigger_time")) {
         this.entityData.set(DATA_attack_trigger_time, compound.getInt("Dataattack_trigger_time"));
      }

      if (compound.contains("Datafollow")) {
         this.entityData.set(DATA_follow, compound.getBoolean("Datafollow"));
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
      SpiderLungerOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
      this.refreshDimensions();
   }

   public EntityDimensions getDimensions(Pose p_33597_) {
      return super.getDimensions(p_33597_).scale(1.0F);
   }

   public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
      SpiderLungerEntity retval = (SpiderLungerEntity)((EntityType)ArphexModEntities.SPIDER_LUNGER.get()).create(serverWorld);
      retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
      return retval;
   }

   public boolean isFood(ItemStack stack) {
      return List.of((Item)ArphexModItems.GREEN_GOLD_SCARAB.get()).contains(stack.getItem());
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
            float strafe = passenger.xxa;
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
      SpawnPlacements.register(
         (EntityType)ArphexModEntities.SPIDER_LUNGER.get(), Type.ON_GROUND, Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
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
      builder = builder.add(Attributes.MAX_HEALTH, 150.0);
      builder = builder.add(Attributes.ARMOR, 0.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 8.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 100.0);
      return builder.add(Attributes.ATTACK_KNOCKBACK, 1.0);
   }

   private PlayState movementPredicate(AnimationState event) {
      if (this.animationprocedure.equals("empty")) {
         if (event.isMoving() || !(event.getLimbSwingAmount() > -0.15F) || !(event.getLimbSwingAmount() < 0.15F)) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("animation.spider_lunger.prowling"));
         } else if (this.isDeadOrDying()) {
            return event.setAndContinue(RawAnimation.begin().thenPlay("animation.spider_lunger.death"));
         } else {
            return this.isInWaterOrBubble()
               ? event.setAndContinue(RawAnimation.begin().thenLoop("animation.spider_lunger.prowling"))
               : event.setAndContinue(RawAnimation.begin().thenLoop("animation.spider_lunger.idle"));
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
         return event.setAndContinue(RawAnimation.begin().thenPlay("animation.spider_lunger.attack"));
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
      data.add(new AnimationController[]{new AnimationController(this, "movement", 12, this::movementPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "attacking", 12, this::attackingPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "procedure", 12, this::procedurePredicate)});
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
