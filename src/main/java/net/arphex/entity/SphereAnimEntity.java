package net.arphex.entity;

import net.arphex.init.ArphexModEntities;
import net.arphex.procedures.SphereAnimOnEntityTickUpdateProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages.SpawnEntity;

public class SphereAnimEntity extends Monster {
   public static final EntityDataAccessor<Integer> DATA_sphere_size = SynchedEntityData.defineId(SphereAnimEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<Boolean> DATA_revert = SynchedEntityData.defineId(SphereAnimEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<Integer> DATA_max_size = SynchedEntityData.defineId(SphereAnimEntity.class, EntityDataSerializers.INT);
   public static final EntityDataAccessor<String> DATA_color = SynchedEntityData.defineId(SphereAnimEntity.class, EntityDataSerializers.STRING);
   public static final EntityDataAccessor<Boolean> DATA_black_hole = SynchedEntityData.defineId(SphereAnimEntity.class, EntityDataSerializers.BOOLEAN);
   public static final EntityDataAccessor<Integer> DATA_opacity = SynchedEntityData.defineId(SphereAnimEntity.class, EntityDataSerializers.INT);

   public SphereAnimEntity(SpawnEntity packet, Level world) {
      this((EntityType<SphereAnimEntity>)ArphexModEntities.SPHERE_ANIM.get(), world);
   }

   public SphereAnimEntity(EntityType<SphereAnimEntity> type, Level world) {
      super(type, world);
      this.setMaxUpStep(0.6F);
      this.xpReward = 0;
      this.setNoAi(true);
      this.setPersistenceRequired();
      this.moveControl = new FlyingMoveControl(this, 10, true);
   }

   public Packet<ClientGamePacketListener> getAddEntityPacket() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   protected void defineSynchedData() {
      super.defineSynchedData();
      this.entityData.define(DATA_sphere_size, 0);
      this.entityData.define(DATA_revert, false);
      this.entityData.define(DATA_max_size, 0);
      this.entityData.define(DATA_color, "-");
      this.entityData.define(DATA_black_hole, false);
      this.entityData.define(DATA_opacity, 0);
   }

   protected PathNavigation createNavigation(Level world) {
      return new FlyingPathNavigation(this, world);
   }

   public MobType getMobType() {
      return MobType.UNDEFINED;
   }

   public boolean removeWhenFarAway(double distanceToClosestPlayer) {
      return false;
   }

   public boolean causeFallDamage(float l, float d, DamageSource source) {
      return false;
   }

   public boolean hurt(DamageSource damagesource, float amount) {
      if (damagesource.is(DamageTypes.IN_FIRE)) {
         return false;
      } else if (damagesource.getDirectEntity() instanceof AbstractArrow) {
         return false;
      } else if (damagesource.getDirectEntity() instanceof Player) {
         return false;
      } else if (damagesource.getDirectEntity() instanceof ThrownPotion || damagesource.getDirectEntity() instanceof AreaEffectCloud) {
         return false;
      } else if (damagesource.is(DamageTypes.FALL)) {
         return false;
      } else if (damagesource.is(DamageTypes.CACTUS)) {
         return false;
      } else if (damagesource.is(DamageTypes.DROWN)) {
         return false;
      } else if (damagesource.is(DamageTypes.LIGHTNING_BOLT)) {
         return false;
      } else if (damagesource.is(DamageTypes.EXPLOSION) || damagesource.is(DamageTypes.PLAYER_EXPLOSION)) {
         return false;
      } else if (damagesource.is(DamageTypes.TRIDENT)) {
         return false;
      } else if (damagesource.is(DamageTypes.FALLING_ANVIL)) {
         return false;
      } else if (damagesource.is(DamageTypes.DRAGON_BREATH)) {
         return false;
      } else {
         return !damagesource.is(DamageTypes.WITHER) && !damagesource.is(DamageTypes.WITHER_SKULL) ? super.hurt(damagesource, amount) : false;
      }
   }

   public boolean ignoreExplosion() {
      return true;
   }

   public boolean fireImmune() {
      return true;
   }

   public void addAdditionalSaveData(CompoundTag compound) {
      super.addAdditionalSaveData(compound);
      compound.putInt("Datasphere_size", (Integer)this.entityData.get(DATA_sphere_size));
      compound.putBoolean("Datarevert", (Boolean)this.entityData.get(DATA_revert));
      compound.putInt("Datamax_size", (Integer)this.entityData.get(DATA_max_size));
      compound.putString("Datacolor", (String)this.entityData.get(DATA_color));
      compound.putBoolean("Datablack_hole", (Boolean)this.entityData.get(DATA_black_hole));
      compound.putInt("Dataopacity", (Integer)this.entityData.get(DATA_opacity));
   }

   public void readAdditionalSaveData(CompoundTag compound) {
      super.readAdditionalSaveData(compound);
      if (compound.contains("Datasphere_size")) {
         this.entityData.set(DATA_sphere_size, compound.getInt("Datasphere_size"));
      }

      if (compound.contains("Datarevert")) {
         this.entityData.set(DATA_revert, compound.getBoolean("Datarevert"));
      }

      if (compound.contains("Datamax_size")) {
         this.entityData.set(DATA_max_size, compound.getInt("Datamax_size"));
      }

      if (compound.contains("Datacolor")) {
         this.entityData.set(DATA_color, compound.getString("Datacolor"));
      }

      if (compound.contains("Datablack_hole")) {
         this.entityData.set(DATA_black_hole, compound.getBoolean("Datablack_hole"));
      }

      if (compound.contains("Dataopacity")) {
         this.entityData.set(DATA_opacity, compound.getInt("Dataopacity"));
      }
   }

   public void baseTick() {
      super.baseTick();
      SphereAnimOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
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
      this.setNoGravity(true);
   }

   public static void init() {
   }

   public static Builder createAttributes() {
      Builder builder = Mob.createMobAttributes();
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
      builder = builder.add(Attributes.MAX_HEALTH, 1024.0);
      builder = builder.add(Attributes.ARMOR, 0.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 0.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 16.0);
      return builder.add(Attributes.FLYING_SPEED, 0.3);
   }
}
