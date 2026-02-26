package net.arphex.item.inventory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.arphex.client.gui.WayfinderScreen;
import net.arphex.init.ArphexModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.items.ItemStackHandler;

@EventBusSubscriber({Dist.CLIENT})
public class WarpWayfinderInventoryCapability implements ICapabilitySerializable<CompoundTag> {
   private final LazyOptional<ItemStackHandler> inventory = LazyOptional.of(this::createItemHandler);

   @SubscribeEvent
   @OnlyIn(Dist.CLIENT)
   public static void onItemDropped(ItemTossEvent event) {
      if (event.getEntity().getItem().getItem() == ArphexModItems.WARP_WAYFINDER.get() && Minecraft.getInstance().screen instanceof WayfinderScreen) {
         Minecraft.getInstance().player.closeContainer();
      }
   }

   public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, @Nullable Direction side) {
      return capability == ForgeCapabilities.ITEM_HANDLER ? this.inventory.cast() : LazyOptional.empty();
   }

   public CompoundTag serializeNBT() {
      return this.getItemHandler().serializeNBT();
   }

   public void deserializeNBT(CompoundTag nbt) {
      this.getItemHandler().deserializeNBT(nbt);
   }

   private ItemStackHandler createItemHandler() {
      return new ItemStackHandler(3) {
         public int getSlotLimit(int slot) {
            return 64;
         }

         public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
            return stack.getItem() != ArphexModItems.WARP_WAYFINDER.get();
         }

         public void setSize(int size) {
         }
      };
   }

   private ItemStackHandler getItemHandler() {
      return (ItemStackHandler)this.inventory.orElseThrow(RuntimeException::new);
   }
}
