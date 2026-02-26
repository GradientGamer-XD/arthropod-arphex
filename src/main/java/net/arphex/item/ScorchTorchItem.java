package net.arphex.item;

import java.util.List;
import net.arphex.procedures.ScorchTorchRightclickedOnBlockProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class ScorchTorchItem extends Item {
   public ScorchTorchItem() {
      super(new Properties().stacksTo(64).fireResistant().rarity(Rarity.RARE));
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("A torch burning with incredible heat intensity. Right click placed torches to attract nearby weak arthropods"));
   }

   public InteractionResult useOn(UseOnContext context) {
      super.useOn(context);
      ScorchTorchRightclickedOnBlockProcedure.execute(
         context.getLevel(),
         (double)context.getClickedPos().getX(),
         (double)context.getClickedPos().getY(),
         (double)context.getClickedPos().getZ(),
         context.getLevel().getBlockState(context.getClickedPos()),
         context.getClickedFace(),
         context.getPlayer(),
         context.getItemInHand()
      );
      return InteractionResult.SUCCESS;
   }
}
