package net.arphex.item;

import java.util.List;
import net.arphex.procedures.EggRightClickBlockProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class VenusFlytrapEggItem extends Item {
   public VenusFlytrapEggItem() {
      super(new Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("(non-arthropod)"));
   }

   public InteractionResult useOn(UseOnContext context) {
      super.useOn(context);
      EggRightClickBlockProcedure.execute(
         context.getLevel(),
         (double)context.getClickedPos().getX(),
         (double)context.getClickedPos().getY(),
         (double)context.getClickedPos().getZ(),
         context.getItemInHand()
      );
      return InteractionResult.SUCCESS;
   }
}
