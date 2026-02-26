package net.arphex.procedures;

import java.util.concurrent.atomic.AtomicReference;
import net.arphex.init.ArphexModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

public class GreengoldTooltipProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         return ArphexModItems.SINGULARITY_SATCHEL.get()
               == (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getItem()
            ? (new Object() {
               public ItemStack getItemStack(int sltid, ItemStack _isc) {
                  AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                  _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(sltid).copy()));
                  return _retval.get();
               }
            }).getItemStack(87, entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getCount() == 0
            : (new Object() {
               public ItemStack getItemStack(int sltid, ItemStack _isc) {
                  AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                  _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(sltid).copy()));
                  return _retval.get();
               }
            }).getItemStack(87, entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getCount() == 0;
      }
   }
}
