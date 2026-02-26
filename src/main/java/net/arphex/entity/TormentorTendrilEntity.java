package net.arphex.entity;

import java.util.EnumSet;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModItems;
import net.arphex.procedures.TormentorTendrilOnEntityTickUpdateProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.Goal.Flag;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages.SpawnEntity;
import net.minecraftforge.registries.ForgeRegistries;

public class TormentorTendrilEntity extends Monster {
   public TormentorTendrilEntity(SpawnEntity packet, Level world) {
      this((EntityType<TormentorTendrilEntity>)ArphexModEntities.TORMENTOR_TENDRIL.get(), world);
   }

   public TormentorTendrilEntity(EntityType<TormentorTendrilEntity> type, Level world) {
      super(type, world);
      this.setMaxUpStep(0.6F);
      this.xpReward = 0;
      this.setNoAi(false);
      this.moveControl = new FlyingMoveControl(this, 10, true);
      this.refreshDimensions();
   }

   public Packet<ClientGamePacketListener> getAddEntityPacket() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   protected PathNavigation createNavigation(Level world) {
      return new FlyingPathNavigation(this, world);
   }

   protected void registerGoals() {
      super.registerGoals();
      this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Player.class, false, true));
      this.goalSelector
         .addGoal(
            2,
            new Goal() {
               {
                  this.setFlags(EnumSet.of(Flag.MOVE));
               }

               public boolean canUse() {
                  return TormentorTendrilEntity.this.getTarget() != null && !TormentorTendrilEntity.this.getMoveControl().hasWanted();
               }

               public boolean canContinueToUse() {
                  return TormentorTendrilEntity.this.getMoveControl().hasWanted()
                     && TormentorTendrilEntity.this.getTarget() != null
                     && TormentorTendrilEntity.this.getTarget().isAlive();
               }

               public void start() {
                  LivingEntity livingentity = TormentorTendrilEntity.this.getTarget();
                  Vec3 vec3d = livingentity.getEyePosition(1.0F);
                  TormentorTendrilEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 0.2);
               }

               public void tick() {
                  LivingEntity livingentity = TormentorTendrilEntity.this.getTarget();
                  if (TormentorTendrilEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
                     TormentorTendrilEntity.this.doHurtTarget(livingentity);
                  } else {
                     double d0 = TormentorTendrilEntity.this.distanceToSqr(livingentity);
                     if (d0 < 5.0) {
                        Vec3 vec3d = livingentity.getEyePosition(1.0F);
                        TormentorTendrilEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 0.2);
                     }
                  }
               }
            }
         );
   }

   public MobType getMobType() {
      return MobType.UNDEFINED;
   }

   protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
      super.dropCustomDeathLoot(source, looting, recentlyHitIn);
      this.spawnAtLocation(new ItemStack((ItemLike)ArphexModItems.SCORCH_CHARGE.get()));
   }

   public SoundEvent getAmbientSound() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:teleportermoth"));
   }

   public SoundEvent getHurtSound(DamageSource ds) {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:teleportermoth"));
   }

   public SoundEvent getDeathSound() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
   }

   public boolean causeFallDamage(float l, float d, DamageSource source) {
      return false;
   }

   public boolean hurt(DamageSource damagesource, float amount) {
      if (damagesource.is(DamageTypes.IN_FIRE)) {
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

   public void baseTick() {
      super.baseTick();
      TormentorTendrilOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
   }

   public boolean canBreatheUnderwater() {
      double x = this.getX();
      double y = this.getY();
      double z = this.getZ();
      Level world = this.level();
      return true;
   }

   public boolean isPushable() {
      return false;
   }

   protected void doPush(Entity entityIn) {
   }

   protected void pushEntities() {
   }

   public EntityDimensions getDimensions(Pose pose) {
      return super.getDimensions(pose).scale(0.8F);
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
      builder = builder.add(Attributes.MAX_HEALTH, 100.0);
      builder = builder.add(Attributes.ARMOR, 0.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 2.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 30.0);
      builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 10.0);
      builder = builder.add(Attributes.ATTACK_KNOCKBACK, 3.0);
      return builder.add(Attributes.FLYING_SPEED, 0.3);
   }
}
