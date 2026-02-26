package net.arphex.item;

import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;

public class SealedIridescentScarabItem extends Item {
   public SealedIridescentScarabItem() {
      super(new Properties().stacksTo(10).rarity(Rarity.RARE));
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(
         Component.literal(
            "A sealed iridescent scarab beetle, providing a permanent protective ally that can summon when in your inventory if you are attacked"
         )
      );
      list.add(
         Component.literal(
            "§b1 in 10 chance to spawn per scarab, each time you are hit, so if you have 10 sealed scarabs of this type, it is a guaranteed spawn when attacked"
         )
      );
      list.add(Component.literal("§3Resistance 3 while present"));
   }
}
