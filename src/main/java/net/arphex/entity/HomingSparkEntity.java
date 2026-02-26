package net.arphex.entity;

import net.arphex.init.ArphexModBlocks;
import net.arphex.init.ArphexModEntities;
import net.arphex.procedures.GenesisShotProjectileHitsBlockProcedure;
import net.arphex.procedures.SparkProjectileHitsLivingEntityProcedure;
import net.arphex.procedures.SparkWhileFlyingProcedure;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages.SpawnEntity;
import net.minecraftforge.registries.ForgeRegistries;

@OnlyIn(
   value = Dist.CLIENT,
   _interface = ItemSupplier.class
)
public class HomingSparkEntity extends AbstractArrow implements ItemSupplier {
   public static final ItemStack PROJECTILE_ITEM = new ItemStack((ItemLike)ArphexModBlocks.INVISIBLE_DETECTOR_BLOCK.get());

   public HomingSparkEntity(SpawnEntity packet, Level world) {
      super((EntityType)ArphexModEntities.HOMING_SPARK.get(), world);
   }

   public HomingSparkEntity(EntityType<? extends HomingSparkEntity> type, Level world) {
      super(type, world);
   }

   public HomingSparkEntity(EntityType<? extends HomingSparkEntity> type, double x, double y, double z, Level world) {
      super(type, x, y, z, world);
   }

   public HomingSparkEntity(EntityType<? extends HomingSparkEntity> type, LivingEntity entity, Level world) {
      super(type, entity, world);
   }

   public Packet<ClientGamePacketListener> getAddEntityPacket() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   @OnlyIn(Dist.CLIENT)
   public ItemStack getItem() {
      return PROJECTILE_ITEM;
   }

   protected ItemStack getPickupItem() {
      return PROJECTILE_ITEM;
   }

   protected void doPostHurtEffects(LivingEntity entity) {
      super.doPostHurtEffects(entity);
      entity.setArrowCount(entity.getArrowCount() - 1);
   }

   public void onHitEntity(EntityHitResult entityHitResult) {
      super.onHitEntity(entityHitResult);
      SparkProjectileHitsLivingEntityProcedure.execute(this.level(), entityHitResult.getEntity(), this, this.getOwner());
   }

   public void onHitBlock(BlockHitResult blockHitResult) {
      super.onHitBlock(blockHitResult);
      GenesisShotProjectileHitsBlockProcedure.execute(
         this.level(),
         (double)blockHitResult.getBlockPos().getX(),
         (double)blockHitResult.getBlockPos().getY(),
         (double)blockHitResult.getBlockPos().getZ(),
         this.getOwner(),
         this
      );
   }

   public void tick() {
      super.tick();
      SparkWhileFlyingProcedure.execute(this.level(), this);
      if (this.inGround) {
         this.discard();
      }
   }

   public static HomingSparkEntity shoot(Level world, LivingEntity entity, RandomSource source) {
      return shoot(world, entity, source, 1.0F, 5.0, 5);
   }

   public static HomingSparkEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
      HomingSparkEntity entityarrow = new HomingSparkEntity((EntityType<? extends HomingSparkEntity>)ArphexModEntities.HOMING_SPARK.get(), entity, world);
      entityarrow.shoot(entity.getViewVector(1.0F).x, entity.getViewVector(1.0F).y, entity.getViewVector(1.0F).z, power * 2.0F, 0.0F);
      entityarrow.setSilent(true);
      entityarrow.setCritArrow(false);
      entityarrow.setBaseDamage(damage);
      entityarrow.setKnockback(knockback);
      world.addFreshEntity(entityarrow);
      world.playSound(
         null,
         entity.getX(),
         entity.getY(),
         entity.getZ(),
         (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")),
         SoundSource.PLAYERS,
         1.0F,
         1.0F / (random.nextFloat() * 0.5F + 1.0F) + power / 2.0F
      );
      return entityarrow;
   }

   public static HomingSparkEntity shoot(LivingEntity entity, LivingEntity target) {
      HomingSparkEntity entityarrow = new HomingSparkEntity(
         (EntityType<? extends HomingSparkEntity>)ArphexModEntities.HOMING_SPARK.get(), entity, entity.level()
      );
      double dx = target.getX() - entity.getX();
      double dy = target.getY() + (double)target.getEyeHeight() - 1.1;
      double dz = target.getZ() - entity.getZ();
      entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 2.0F, 12.0F);
      entityarrow.setSilent(true);
      entityarrow.setBaseDamage(5.0);
      entityarrow.setKnockback(5);
      entityarrow.setCritArrow(false);
      entity.level().addFreshEntity(entityarrow);
      entity.level()
         .playSound(
            null,
            entity.getX(),
            entity.getY(),
            entity.getZ(),
            (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")),
            SoundSource.PLAYERS,
            1.0F,
            1.0F / (RandomSource.create().nextFloat() * 0.5F + 1.0F)
         );
      return entityarrow;
   }
}
