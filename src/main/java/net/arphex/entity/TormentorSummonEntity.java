package net.arphex.entity;

import java.util.List;
import javax.annotation.Nullable;
import net.arphex.init.ArphexModEntities;
import net.arphex.procedures.CheckOwnedProcedure;
import net.arphex.procedures.SpiderMothSummonOnInitialEntitySpawnProcedure;
import net.arphex.procedures.TormentorSummonHitboxProcedure;
import net.arphex.procedures.TormentorSummonTickProcedure;
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
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.BreathAirGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
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

public class TormentorSummonEntity extends TamableAnimal implements GeoEntity {
   public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(TormentorSummonEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(TormentorSummonEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(TormentorSummonEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<Integer> DATA_ownerkills = SynchedEntityData.defineId(TormentorSummonEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<Integer> DATA_patreon_reskin = SynchedEntityData.defineId(TormentorSummonEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<String> DATA_reskin_model = SynchedEntityData.defineId(TormentorSummonEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> DATA_idle = SynchedEntityData.defineId(TormentorSummonEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> DATA_walk = SynchedEntityData.defineId(TormentorSummonEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> DATA_death = SynchedEntityData.defineId(TormentorSummonEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> DATA_attack = SynchedEntityData.defineId(TormentorSummonEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> DATA_sneak = SynchedEntityData.defineId(TormentorSummonEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> DATA_sprint = SynchedEntityData.defineId(TormentorSummonEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> DATA_swim = SynchedEntityData.defineId(TormentorSummonEntity.class, EntityDataSerializers.STRING);
   private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
   private boolean swinging;
   private boolean lastloop;
   private long lastSwing;
   public String animationprocedure = "empty";

   public TormentorSummonEntity(SpawnEntity packet, Level world) {
      this((EntityType<TormentorSummonEntity>)ArphexModEntities.TORMENTOR_SUMMON.get(), world);
   }

   public TormentorSummonEntity(EntityType<TormentorSummonEntity> type, Level world) {
      super(type, world);
      this.xpReward = 0;
      this.setNoAi(false);
      this.setMaxUpStep(0.6F);
      this.setPersistenceRequired();
      this.moveControl = new FlyingMoveControl(this, 10, true);
   }

   protected void defineSynchedData() {
      super.defineSynchedData();
      this.entityData.define(SHOOT, false);
      this.entityData.define(ANIMATION, "undefined");
      this.entityData.define(TEXTURE, "tormentorsummon");
      this.entityData.define(DATA_ownerkills, 0);
      this.entityData.define(DATA_patreon_reskin, 0);
      this.entityData.define(DATA_reskin_model, "tormentor");
      this.entityData.define(DATA_idle, "idleride");
      this.entityData.define(DATA_walk, "idleride");
      this.entityData.define(DATA_death, "death");
      this.entityData.define(DATA_attack, "foldride");
      this.entityData.define(DATA_sneak, "");
      this.entityData.define(DATA_sprint, "");
      this.entityData.define(DATA_swim, "");
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
      this.goalSelector.addGoal(1, new OwnerHurtByTargetGoal(this) {
         public boolean canUse() {
            double x = TormentorSummonEntity.this.getX();
            double y = TormentorSummonEntity.this.getY();
            double z = TormentorSummonEntity.this.getZ();
            Entity entity = TormentorSummonEntity.this;
            Level world = TormentorSummonEntity.this.level();
            return super.canUse() && CheckOwnedProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = TormentorSummonEntity.this.getX();
            double y = TormentorSummonEntity.this.getY();
            double z = TormentorSummonEntity.this.getZ();
            Entity entity = TormentorSummonEntity.this;
            Level world = TormentorSummonEntity.this.level();
            return super.canContinueToUse() && CheckOwnedProcedure.execute(entity);
         }
      });
      this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this) {
         public boolean canUse() {
            double x = TormentorSummonEntity.this.getX();
            double y = TormentorSummonEntity.this.getY();
            double z = TormentorSummonEntity.this.getZ();
            Entity entity = TormentorSummonEntity.this;
            Level world = TormentorSummonEntity.this.level();
            return super.canUse() && CheckOwnedProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = TormentorSummonEntity.this.getX();
            double y = TormentorSummonEntity.this.getY();
            double z = TormentorSummonEntity.this.getZ();
            Entity entity = TormentorSummonEntity.this;
            Level world = TormentorSummonEntity.this.level();
            return super.canContinueToUse() && CheckOwnedProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 1.0, 50.0F, 100.0F, false));
      this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 2.0, true) {
         protected double getAttackReachSqr(LivingEntity entity) {
            return 36.0;
         }
      });
      this.targetSelector.addGoal(5, new HurtByTargetGoal(this, new Class[0]));
      this.goalSelector.addGoal(6, new BreathAirGoal(this));
   }

   public MobType getMobType() {
      return MobType.UNDEFINED;
   }

   public boolean removeWhenFarAway(double distanceToClosestPlayer) {
      return false;
   }

   public double getPassengersRidingOffset() {
      return super.getPassengersRidingOffset() + 1.7;
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

   public boolean causeFallDamage(float l, float d, DamageSource source) {
      return false;
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
      } else if (source.is(DamageTypes.LIGHTNING_BOLT)) {
         return false;
      } else if (source.is(DamageTypes.EXPLOSION)) {
         return false;
      } else if (source.is(DamageTypes.FALLING_ANVIL)) {
         return false;
      } else if (source.is(DamageTypes.DRAGON_BREATH)) {
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
      SpiderMothSummonOnInitialEntitySpawnProcedure.execute(world, this.getX(), this.getY(), this.getZ(), this);
      return retval;
   }

   public void addAdditionalSaveData(CompoundTag compound) {
      super.addAdditionalSaveData(compound);
      compound.putString("Texture", this.getTexture());
      compound.putInt("Dataownerkills", (Integer)this.entityData.get(DATA_ownerkills));
      compound.putInt("Datapatreon_reskin", (Integer)this.entityData.get(DATA_patreon_reskin));
      compound.putString("Datareskin_model", (String)this.entityData.get(DATA_reskin_model));
      compound.putString("Dataidle", (String)this.entityData.get(DATA_idle));
      compound.putString("Datawalk", (String)this.entityData.get(DATA_walk));
      compound.putString("Datadeath", (String)this.entityData.get(DATA_death));
      compound.putString("Dataattack", (String)this.entityData.get(DATA_attack));
      compound.putString("Datasneak", (String)this.entityData.get(DATA_sneak));
      compound.putString("Datasprint", (String)this.entityData.get(DATA_sprint));
      compound.putString("Dataswim", (String)this.entityData.get(DATA_swim));
   }

   public void readAdditionalSaveData(CompoundTag compound) {
      super.readAdditionalSaveData(compound);
      if (compound.contains("Texture")) {
         this.setTexture(compound.getString("Texture"));
      }

      if (compound.contains("Dataownerkills")) {
         this.entityData.set(DATA_ownerkills, compound.getInt("Dataownerkills"));
      }

      if (compound.contains("Datapatreon_reskin")) {
         this.entityData.set(DATA_patreon_reskin, compound.getInt("Datapatreon_reskin"));
      }

      if (compound.contains("Datareskin_model")) {
         this.entityData.set(DATA_reskin_model, compound.getString("Datareskin_model"));
      }

      if (compound.contains("Dataidle")) {
         this.entityData.set(DATA_idle, compound.getString("Dataidle"));
      }

      if (compound.contains("Datawalk")) {
         this.entityData.set(DATA_walk, compound.getString("Datawalk"));
      }

      if (compound.contains("Datadeath")) {
         this.entityData.set(DATA_death, compound.getString("Datadeath"));
      }

      if (compound.contains("Dataattack")) {
         this.entityData.set(DATA_attack, compound.getString("Dataattack"));
      }

      if (compound.contains("Datasneak")) {
         this.entityData.set(DATA_sneak, compound.getString("Datasneak"));
      }

      if (compound.contains("Datasprint")) {
         this.entityData.set(DATA_sprint, compound.getString("Datasprint"));
      }

      if (compound.contains("Dataswim")) {
         this.entityData.set(DATA_swim, compound.getString("Dataswim"));
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
      TormentorSummonTickProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
      this.refreshDimensions();
   }

   public EntityDimensions getDimensions(Pose p_33597_) {
      Level world = this.level();
      double x = this.getX();
      double y = this.getY();
      double z = this.getZ();
      return super.getDimensions(p_33597_).scale((float)TormentorSummonHitboxProcedure.execute(this));
   }

   public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
      TormentorSummonEntity retval = (TormentorSummonEntity)((EntityType)ArphexModEntities.TORMENTOR_SUMMON.get()).create(serverWorld);
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
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.31);
      builder = builder.add(Attributes.MAX_HEALTH, 1024.0);
      builder = builder.add(Attributes.ARMOR, 10.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 50.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 200.0);
      builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 100.0);
      builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0.6);
      return builder.add(Attributes.FLYING_SPEED, 0.31);
   }

   private PlayState movementPredicate(AnimationState event) {
      if (this.animationprocedure.equals("empty")) {
         String entityName = (String)this.entityData.get(DATA_reskin_model);
         if (event.isMoving() || !(event.getLimbSwingAmount() > -0.15F) || !(event.getLimbSwingAmount() < 0.15F)) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("animation." + entityName + "." + (String)this.entityData.get(DATA_walk)));
         } else if (this.isDeadOrDying()) {
            return event.setAndContinue(RawAnimation.begin().thenPlay("animation." + entityName + "." + (String)this.entityData.get(DATA_death)));
         } else if (this.isInWaterOrBubble()) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("animation." + entityName + "." + (String)this.entityData.get(DATA_swim)));
         } else if (this.isShiftKeyDown()) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("animation." + entityName + "." + (String)this.entityData.get(DATA_sneak)));
         } else {
            return this.isSprinting()
               ? event.setAndContinue(RawAnimation.begin().thenLoop("animation." + entityName + "." + (String)this.entityData.get(DATA_sprint)))
               : event.setAndContinue(RawAnimation.begin().thenLoop("animation." + entityName + "." + (String)this.entityData.get(DATA_idle)));
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
         String entityName = (String)this.entityData.get(DATA_reskin_model);
         event.getController().forceAnimationReset();
         return event.setAndContinue(RawAnimation.begin().thenPlay("animation." + entityName + "." + (String)this.entityData.get(DATA_attack)));
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
      data.add(new AnimationController[]{new AnimationController(this, "movement", 20, this::movementPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "attacking", 20, this::attackingPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "procedure", 20, this::procedurePredicate)});
   }

   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
   }
}
