package net.arphex.entity;

import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModItems;
import net.arphex.procedures.OpalArrowProjectileHitsBlockProcedure;
import net.arphex.procedures.OpalArrowProjectileHitsLivingEntityProcedure;
import net.arphex.procedures.OpalArrowTickProcedure;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
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

@OnlyIn(
   value = Dist.CLIENT,
   _interface = ItemSupplier.class
)
public class OpalArrowEntity extends AbstractArrow implements ItemSupplier {
   public static final ItemStack PROJECTILE_ITEM = new ItemStack((ItemLike)ArphexModItems.FIRE_OPAL_SHARD.get());

   public OpalArrowEntity(SpawnEntity packet, Level world) {
      super((EntityType)ArphexModEntities.OPAL_ARROW.get(), world);
   }

   public OpalArrowEntity(EntityType<? extends OpalArrowEntity> type, Level world) {
      super(type, world);
   }

   public OpalArrowEntity(EntityType<? extends OpalArrowEntity> type, double x, double y, double z, Level world) {
      super(type, x, y, z, world);
   }

   public OpalArrowEntity(EntityType<? extends OpalArrowEntity> type, LivingEntity entity, Level world) {
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
      OpalArrowProjectileHitsLivingEntityProcedure.execute(this.level(), entityHitResult.getEntity(), this.getOwner());
   }

   public void onHitBlock(BlockHitResult blockHitResult) {
      super.onHitBlock(blockHitResult);
      OpalArrowProjectileHitsBlockProcedure.execute(
         this.level(),
         (double)blockHitResult.getBlockPos().getX(),
         (double)blockHitResult.getBlockPos().getY(),
         (double)blockHitResult.getBlockPos().getZ(),
         this.getOwner()
      );
   }

   public void tick() {
      super.tick();
      OpalArrowTickProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
      if (this.inGround) {
         this.discard();
      }
   }

   public static OpalArrowEntity shoot(Level world, LivingEntity entity, RandomSource source) {
      return shoot(world, entity, source, 7.0F, 0.0, 0);
   }

   public static OpalArrowEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
      OpalArrowEntity entityarrow = new OpalArrowEntity((EntityType<? extends OpalArrowEntity>)ArphexModEntities.OPAL_ARROW.get(), entity, world);
      entityarrow.shoot(entity.getViewVector(1.0F).x, entity.getViewVector(1.0F).y, entity.getViewVector(1.0F).z, power * 2.0F, 0.0F);
      entityarrow.setSilent(true);
      entityarrow.setCritArrow(false);
      entityarrow.setBaseDamage(damage);
      entityarrow.setKnockback(knockback);
      world.addFreshEntity(entityarrow);
      return entityarrow;
   }

   public static OpalArrowEntity shoot(LivingEntity entity, LivingEntity target) {
      OpalArrowEntity entityarrow = new OpalArrowEntity((EntityType<? extends OpalArrowEntity>)ArphexModEntities.OPAL_ARROW.get(), entity, entity.level());
      double dx = target.getX() - entity.getX();
      double dy = target.getY() + (double)target.getEyeHeight() - 1.1;
      double dz = target.getZ() - entity.getZ();
      entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 14.0F, 12.0F);
      entityarrow.setSilent(true);
      entityarrow.setBaseDamage(0.0);
      entityarrow.setKnockback(0);
      entityarrow.setCritArrow(false);
      entity.level().addFreshEntity(entityarrow);
      return entityarrow;
   }
}
