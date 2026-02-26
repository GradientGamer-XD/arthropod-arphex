package net.arphex.procedures;

import java.util.concurrent.atomic.AtomicReference;
import net.arphex.init.ArphexModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandlerModifiable;

public class PlaceholderSatchelItemInInventoryTickProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         double slot_iterate = 0.0;
         slot_iterate = 0.0;

         for (int index0 = 0; index0 < 40; index0++) {
            if ((new Object() {
               public ItemStack getItemStack(int sltid, Entity entity) {
                  AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                  entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(sltid).copy()));
                  return _retval.get();
               }
            }).getItemStack((int)slot_iterate, entity).getItem() == ArphexModItems.PLACEHOLDER_PACK.get()) {
               int _slotid = (int)slot_iterate;
               ItemStack _setstack = new ItemStack((ItemLike)ArphexModItems.PROWLER_PACK.get()).copy();
               _setstack.setCount(1);
               entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                  if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot) {
                     _modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
                  }
               });
            }

            if ((new Object() {
               public ItemStack getItemStack(int sltid, Entity entity) {
                  AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                  entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(sltid).copy()));
                  return _retval.get();
               }
            }).getItemStack((int)slot_iterate, entity).getItem() == ArphexModItems.PLACEHOLDER_SATCHEL.get()) {
               int _slotid = (int)slot_iterate;
               ItemStack _setstack = new ItemStack((ItemLike)ArphexModItems.SINGULARITY_SATCHEL.get()).copy();
               _setstack.setCount(1);
               entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                  if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot) {
                     _modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
                  }
               });
            }

            slot_iterate++;
         }
      }
   }
}
