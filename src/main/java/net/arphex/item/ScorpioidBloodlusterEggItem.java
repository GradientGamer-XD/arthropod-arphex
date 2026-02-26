package net.arphex.item;

import net.arphex.procedures.ScorpioidBloodlusterEggRightclickedOnBlockProcedure;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.context.UseOnContext;

public class ScorpioidBloodlusterEggItem extends Item {
   public ScorpioidBloodlusterEggItem() {
      super(new Properties().stacksTo(64).rarity(Rarity.EPIC));
   }

   public InteractionResult useOn(UseOnContext context) {
      super.useOn(context);
      ScorpioidBloodlusterEggRightclickedOnBlockProcedure.execute(
         context.getLevel(), (double)context.getClickedPos().getX(), (double)context.getClickedPos().getY(), (double)context.getClickedPos().getZ()
      );
      return InteractionResult.SUCCESS;
   }
}
