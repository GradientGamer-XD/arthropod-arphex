package net.arphex.item;

import net.arphex.procedures.EggRightClickBlockProcedure;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.context.UseOnContext;

public class SolifugeSkulkerEggItem extends Item {
   public SolifugeSkulkerEggItem() {
      super(new Properties().stacksTo(64).rarity(Rarity.RARE));
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
