package net.arphex.item;

import java.util.List;
import net.arphex.procedures.ScorchChargeRightclickedOnBlockProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class ScorchChargeItem extends Item {
   public ScorchChargeItem() {
      super(new Properties().stacksTo(64).fireResistant().rarity(Rarity.UNCOMMON));
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(
         Component.literal(
            "Places scorch flames, a dangerous form of fire that gives necrosis and darkness in addition to burning and spreading regular fire. Craftable into powerful items"
         )
      );
   }

   public InteractionResult useOn(UseOnContext context) {
      super.useOn(context);
      ScorchChargeRightclickedOnBlockProcedure.execute(
         context.getLevel(),
         (double)context.getClickedPos().getX(),
         (double)context.getClickedPos().getY(),
         (double)context.getClickedPos().getZ(),
         context.getPlayer()
      );
      return InteractionResult.SUCCESS;
   }
}
