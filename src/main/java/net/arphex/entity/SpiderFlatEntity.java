package net.arphex.entity;

import java.util.List;
import javax.annotation.Nullable;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModItems;
import net.arphex.procedures.ArPhExSpawnConfigProcedure;
import net.arphex.procedures.CheckOwnedProcedure;
import net.arphex.procedures.SittingFlatProcedure;
import net.arphex.procedures.SpiderBroodOnEntityTickUpdateProcedure;
import net.arphex.procedures.SpiderFlatEntityIsHurtProcedure;
import net.arphex.procedures.SpiderFlatOnInitialEntitySpawnProcedure;
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
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.ClimbOnTopOfPowderSnowGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveBackToVillageGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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

public class SpiderFlatEntity extends TamableAnimal implements GeoEntity {
   public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(SpiderFlatEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(SpiderFlatEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(SpiderFlatEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<Boolean> DATA_sit = SynchedEntityData.defineId(SpiderFlatEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<Integer> DATA_patreon_reskin = SynchedEntityData.defineId(SpiderFlatEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<String> DATA_reskin_model = SynchedEntityData.defineId(SpiderFlatEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> DATA_idle = SynchedEntityData.defineId(SpiderFlatEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> DATA_walk = SynchedEntityData.defineId(SpiderFlatEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> DATA_death = SynchedEntityData.defineId(SpiderFlatEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> DATA_attack = SynchedEntityData.defineId(SpiderFlatEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> DATA_sneak = SynchedEntityData.defineId(SpiderFlatEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> DATA_sprint = SynchedEntityData.defineId(SpiderFlatEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> DATA_swim = SynchedEntityData.defineId(SpiderFlatEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<String> DATA_test = SynchedEntityData.defineId(SpiderFlatEntity.class, EntityDataSerializers.STRING);
   private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
   private boolean swinging;
   private boolean lastloop;
   private long lastSwing;
   public String animationprocedure = "empty";

   public SpiderFlatEntity(SpawnEntity packet, Level world) {
      this((EntityType<SpiderFlatEntity>)ArphexModEntities.SPIDER_FLAT.get(), world);
   }

   public SpiderFlatEntity(EntityType<SpiderFlatEntity> type, Level world) {
      super(type, world);
      this.xpReward = 20;
      this.setNoAi(false);
      this.setMaxUpStep(0.6F);
   }

   protected void defineSynchedData() {
      super.defineSynchedData();
      this.entityData.define(SHOOT, false);
      this.entityData.define(ANIMATION, "undefined");
      this.entityData.define(TEXTURE, "spiderflat");
      this.entityData.define(DATA_sit, false);
      this.entityData.define(DATA_patreon_reskin, 0);
      this.entityData.define(DATA_reskin_model, "spiderflat");
      this.entityData.define(DATA_idle, "idle");
      this.entityData.define(DATA_walk, "scurrying");
      this.entityData.define(DATA_death, "death");
      this.entityData.define(DATA_attack, "attack");
      this.entityData.define(DATA_sneak, "grab");
      this.entityData.define(DATA_sprint, "aggressive");
      this.entityData.define(DATA_swim, "scurrying");
      this.entityData.define(DATA_test, "");
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
            double x = SpiderFlatEntity.this.getX();
            double y = SpiderFlatEntity.this.getY();
            double z = SpiderFlatEntity.this.getZ();
            Entity entity = SpiderFlatEntity.this;
            Level world = SpiderFlatEntity.this.level();
            return super.canUse() && CheckOwnedProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = SpiderFlatEntity.this.getX();
            double y = SpiderFlatEntity.this.getY();
            double z = SpiderFlatEntity.this.getZ();
            Entity entity = SpiderFlatEntity.this;
            Level world = SpiderFlatEntity.this.level();
            return super.canContinueToUse() && CheckOwnedProcedure.execute(entity);
         }
      });
      this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this) {
         public boolean canUse() {
            double x = SpiderFlatEntity.this.getX();
            double y = SpiderFlatEntity.this.getY();
            double z = SpiderFlatEntity.this.getZ();
            Entity entity = SpiderFlatEntity.this;
            Level world = SpiderFlatEntity.this.level();
            return super.canUse() && CheckOwnedProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = SpiderFlatEntity.this.getX();
            double y = SpiderFlatEntity.this.getY();
            double z = SpiderFlatEntity.this.getZ();
            Entity entity = SpiderFlatEntity.this;
            Level world = SpiderFlatEntity.this.level();
            return super.canContinueToUse() && CheckOwnedProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(3, new BreedGoal(this, 1.0));
      this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.0, 10.0F, 8.0F, false) {
         public boolean canUse() {
            double x = SpiderFlatEntity.this.getX();
            double y = SpiderFlatEntity.this.getY();
            double z = SpiderFlatEntity.this.getZ();
            Entity entity = SpiderFlatEntity.this;
            Level world = SpiderFlatEntity.this.level();
            return super.canUse() && SittingFlatProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = SpiderFlatEntity.this.getX();
            double y = SpiderFlatEntity.this.getY();
            double z = SpiderFlatEntity.this.getZ();
            Entity entity = SpiderFlatEntity.this;
            Level world = SpiderFlatEntity.this.level();
            return super.canContinueToUse() && SittingFlatProcedure.execute(entity);
         }
      });
      this.targetSelector.addGoal(5, new HurtByTargetGoal(this, new Class[0]).setAlertOthers(new Class[0]));
      this.targetSelector.addGoal(6, new NearestAttackableTargetGoal(this, FlyFestererEntity.class, true, true));
      this.targetSelector.addGoal(7, new NearestAttackableTargetGoal(this, Bee.class, true, true));
      this.targetSelector.addGoal(8, new NearestAttackableTargetGoal(this, MaggotLarvaeEntity.class, true, true));
      this.targetSelector.addGoal(9, new NearestAttackableTargetGoal(this, AntArsonistEntity.class, true, true));
      this.targetSelector.addGoal(10, new NearestAttackableTargetGoal(this, RoachRiverspawnEntity.class, true, true));
      this.goalSelector.addGoal(11, new MeleeAttackGoal(this, 1.2, false) {
         protected double getAttackReachSqr(LivingEntity entity) {
            return 2.56;
         }
      });
      this.goalSelector.addGoal(12, new MeleeAttackGoal(this, 1.2, false) {
         protected double getAttackReachSqr(LivingEntity entity) {
            return (double)(this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth());
         }
      });
      this.goalSelector.addGoal(13, new LeapAtTargetGoal(this, 0.1F));
      this.goalSelector.addGoal(14, new ClimbOnTopOfPowderSnowGoal(this, this.level()));
      this.goalSelector.addGoal(15, new MoveBackToVillageGoal(this, 0.6, false));
      this.goalSelector.addGoal(16, new RandomStrollGoal(this, 1.0) {
         public boolean canUse() {
            double x = SpiderFlatEntity.this.getX();
            double y = SpiderFlatEntity.this.getY();
            double z = SpiderFlatEntity.this.getZ();
            Entity entity = SpiderFlatEntity.this;
            Level world = SpiderFlatEntity.this.level();
            return super.canUse() && SittingFlatProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = SpiderFlatEntity.this.getX();
            double y = SpiderFlatEntity.this.getY();
            double z = SpiderFlatEntity.this.getZ();
            Entity entity = SpiderFlatEntity.this;
            Level world = SpiderFlatEntity.this.level();
            return super.canContinueToUse() && SittingFlatProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(17, new FloatGoal(this));
   }

   public MobType getMobType() {
      return MobType.ARTHROPOD;
   }

   protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
      super.dropCustomDeathLoot(source, looting, recentlyHitIn);
      this.spawnAtLocation(new ItemStack(Items.FERMENTED_SPIDER_EYE));
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
      SpiderFlatEntityIsHurtProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
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
      SpiderFlatOnInitialEntitySpawnProcedure.execute(world, this);
      return retval;
   }

   public void addAdditionalSaveData(CompoundTag compound) {
      super.addAdditionalSaveData(compound);
      compound.putString("Texture", this.getTexture());
      compound.putBoolean("Datasit", (Boolean)this.entityData.get(DATA_sit));
      compound.putInt("Datapatreon_reskin", (Integer)this.entityData.get(DATA_patreon_reskin));
      compound.putString("Datareskin_model", (String)this.entityData.get(DATA_reskin_model));
      compound.putString("Dataidle", (String)this.entityData.get(DATA_idle));
      compound.putString("Datawalk", (String)this.entityData.get(DATA_walk));
      compound.putString("Datadeath", (String)this.entityData.get(DATA_death));
      compound.putString("Dataattack", (String)this.entityData.get(DATA_attack));
      compound.putString("Datasneak", (String)this.entityData.get(DATA_sneak));
      compound.putString("Datasprint", (String)this.entityData.get(DATA_sprint));
      compound.putString("Dataswim", (String)this.entityData.get(DATA_swim));
      compound.putString("Datatest", (String)this.entityData.get(DATA_test));
   }

   public void readAdditionalSaveData(CompoundTag compound) {
      super.readAdditionalSaveData(compound);
      if (compound.contains("Texture")) {
         this.setTexture(compound.getString("Texture"));
      }

      if (compound.contains("Datasit")) {
         this.entityData.set(DATA_sit, compound.getBoolean("Datasit"));
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

      if (compound.contains("Datatest")) {
         this.entityData.set(DATA_test, compound.getString("Datatest"));
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
      return super.getDimensions(p_33597_).scale(0.95F);
   }

   public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
      SpiderFlatEntity retval = (SpiderFlatEntity)((EntityType)ArphexModEntities.SPIDER_FLAT.get()).create(serverWorld);
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
         (EntityType)ArphexModEntities.SPIDER_FLAT.get(), Type.ON_GROUND, Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();
            return ArPhExSpawnConfigProcedure.execute(world, (double)x, (double)y, (double)z);
         }
      );
   }

   public static Builder createAttributes() {
      Builder builder = Mob.createMobAttributes();
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.38);
      builder = builder.add(Attributes.MAX_HEALTH, 60.0);
      builder = builder.add(Attributes.ARMOR, 0.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 2.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 80.0);
      return builder.add(Attributes.ATTACK_KNOCKBACK, 0.2);
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
      data.add(new AnimationController[]{new AnimationController(this, "movement", 6, this::movementPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "attacking", 6, this::attackingPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "procedure", 6, this::procedurePredicate)});
   }

   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
   }
}
