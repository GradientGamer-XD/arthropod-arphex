package net.arphex.item;

import java.util.List;
import net.arphex.procedures.BucketOfWormGrubRightclickedProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;

public class BucketOfWormGrubItem extends Item {
   public BucketOfWormGrubItem() {
      super(new Properties().stacksTo(16).rarity(Rarity.COMMON));
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("Bloodworms are aggressive and Crab Larvae like to eat them"));
   }

   public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
      BucketOfWormGrubRightclickedProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
      return ar;
   }
}
