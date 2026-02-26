package net.arphex.item;

import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SealedGoldenScarabItem extends Item {
   public SealedGoldenScarabItem() {
      super(new Properties().stacksTo(10).rarity(Rarity.EPIC));
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFoil(ItemStack itemstack) {
      return true;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(
         Component.literal("A sealed golden scarab beetle, providing a permanent protective ally that can summon when in your inventory if you are attacked")
      );
      list.add(
         Component.literal(
            "§b1 in 10 chance to spawn per scarab, each time you are hit, so if you have 10 sealed scarabs of this type, it is a guaranteed spawn when attacked"
         )
      );
      list.add(Component.literal("§6Resistance 4 while present"));
   }
}
