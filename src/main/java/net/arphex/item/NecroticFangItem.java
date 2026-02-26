package net.arphex.item;

import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;

public class NecroticFangItem extends Item {
   public NecroticFangItem() {
      super(new Properties().stacksTo(64).rarity(Rarity.COMMON));
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("Used for crafting deadly weapons and grappling hooks"));
      list.add(Component.literal("§7Drops from Spider Funnel + Centipede Stalker + Hornet Harbinger Giant"));
   }
}
