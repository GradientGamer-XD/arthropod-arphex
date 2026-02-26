package net.arphex.item;

import java.util.List;
import net.arphex.procedures.TrophyItemItemInHandTickProcedure;
import net.arphex.procedures.TrophyPlaceProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class TrophyItemItem extends Item {
   public TrophyItemItem() {
      super(new Properties().stacksTo(64).rarity(Rarity.EPIC));
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFoil(ItemStack itemstack) {
      return true;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("Mob Trophy - Place down to show off your mob kill milestone!"));
      list.add(Component.literal("§7Drops from almost any ArPhEx mob, with a rarity corresponding to the health of the mob"));
   }

   public InteractionResult useOn(UseOnContext context) {
      super.useOn(context);
      TrophyPlaceProcedure.execute(
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

   public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.inventoryTick(itemstack, world, entity, slot, selected);
      if (selected) {
         TrophyItemItemInHandTickProcedure.execute(entity, itemstack);
      }
   }
}
