package net.arphex.entity;

import net.arphex.init.ArphexModBlocks;
import net.arphex.init.ArphexModEntities;
import net.arphex.procedures.AscendantArrowWhileProjectileFlyingTickProcedure;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages.SpawnEntity;

@OnlyIn(
   value = Dist.CLIENT,
   _interface = ItemSupplier.class
)
public class AscendantArrowEntity extends AbstractArrow implements ItemSupplier {
   public static final ItemStack PROJECTILE_ITEM = new ItemStack((ItemLike)ArphexModBlocks.INVISIBLE_DETECTOR_BLOCK.get());

   public AscendantArrowEntity(SpawnEntity packet, Level world) {
      super((EntityType)ArphexModEntities.ASCENDANT_ARROW.get(), world);
   }

   public AscendantArrowEntity(EntityType<? extends AscendantArrowEntity> type, Level world) {
      super(type, world);
   }

   public AscendantArrowEntity(EntityType<? extends AscendantArrowEntity> type, double x, double y, double z, Level world) {
      super(type, x, y, z, world);
   }

   public AscendantArrowEntity(EntityType<? extends AscendantArrowEntity> type, LivingEntity entity, Level world) {
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

   public void tick() {
      super.tick();
      AscendantArrowWhileProjectileFlyingTickProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
      if (this.inGround) {
         this.discard();
      }
   }

   public static AscendantArrowEntity shoot(Level world, LivingEntity entity, RandomSource source) {
      return shoot(world, entity, source, 7.0F, 0.0, 0);
   }

   public static AscendantArrowEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
      AscendantArrowEntity entityarrow = new AscendantArrowEntity(
         (EntityType<? extends AscendantArrowEntity>)ArphexModEntities.ASCENDANT_ARROW.get(), entity, world
      );
      entityarrow.shoot(entity.getViewVector(1.0F).x, entity.getViewVector(1.0F).y, entity.getViewVector(1.0F).z, power * 2.0F, 0.0F);
      entityarrow.setSilent(true);
      entityarrow.setCritArrow(false);
      entityarrow.setBaseDamage(damage);
      entityarrow.setKnockback(knockback);
      world.addFreshEntity(entityarrow);
      return entityarrow;
   }

   public static AscendantArrowEntity shoot(LivingEntity entity, LivingEntity target) {
      AscendantArrowEntity entityarrow = new AscendantArrowEntity(
         (EntityType<? extends AscendantArrowEntity>)ArphexModEntities.ASCENDANT_ARROW.get(), entity, entity.level()
      );
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
