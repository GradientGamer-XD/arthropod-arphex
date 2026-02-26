package net.arphex.item;

import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;

public class ScarabSealItem extends Item {
   public ScarabSealItem() {
      super(new Properties().stacksTo(64).rarity(Rarity.COMMON));
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(
         Component.literal(
            "An ethereal seal for harnessing the power of scarab beetles, forcing them to fight for you. Craft with any type of scarab beetle to apply"
         )
      );
      list.add(Component.literal("§7Drops from Solifuge Skulker [MINIBOSS]"));
   }
}
