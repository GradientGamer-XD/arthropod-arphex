package net.arphex.entity;

import net.arphex.init.ArphexModEntities;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages.SpawnEntity;

@OnlyIn(
   value = Dist.CLIENT,
   _interface = ItemSupplier.class
)
public class SpiderBroodEntityProjectile extends AbstractArrow implements ItemSupplier {
   public SpiderBroodEntityProjectile(SpawnEntity packet, Level world) {
      super((EntityType)ArphexModEntities.SPIDER_BROOD_PROJECTILE.get(), world);
   }

   public SpiderBroodEntityProjectile(EntityType<? extends SpiderBroodEntityProjectile> type, Level world) {
      super(type, world);
   }

   public SpiderBroodEntityProjectile(EntityType<? extends SpiderBroodEntityProjectile> type, double x, double y, double z, Level world) {
      super(type, x, y, z, world);
   }

   public SpiderBroodEntityProjectile(EntityType<? extends SpiderBroodEntityProjectile> type, LivingEntity entity, Level world) {
      super(type, entity, world);
   }

   public Packet<ClientGamePacketListener> getAddEntityPacket() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   protected void doPostHurtEffects(LivingEntity livingEntity) {
      super.doPostHurtEffects(livingEntity);
      livingEntity.setArrowCount(livingEntity.getArrowCount() - 1);
   }

   @OnlyIn(Dist.CLIENT)
   public ItemStack getItem() {
      return new ItemStack(Blocks.COBWEB);
   }

   protected ItemStack getPickupItem() {
      return new ItemStack(Blocks.COBWEB);
   }
}
