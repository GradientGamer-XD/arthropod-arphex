package net.arphex.item;

import java.util.List;
import net.arphex.procedures.PlaceholderSatchelItemInInventoryTickProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class PlaceholderSatchelItem extends Item {
   public PlaceholderSatchelItem() {
      super(new Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC));
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFoil(ItemStack itemstack) {
      return true;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("§6Backpack made from dense cosmic minerals, capable of storing large amounts of items"));
      list.add(Component.literal("- Right click to open "));
      list.add(Component.literal("- Crouch+right click to toggle item magnet special ability "));
      list.add(Component.literal("§e- Using the special slots for scarab seals and vitality items will retain their abilities"));
   }

   public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.inventoryTick(itemstack, world, entity, slot, selected);
      PlaceholderSatchelItemInInventoryTickProcedure.execute(entity);
   }
}
