package net.arphex.item;

import java.util.List;
import net.arphex.procedures.HemoplasmPlayerFinishesUsingItemProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties.Builder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;

public class HemoplasmItem extends Item {
   public HemoplasmItem() {
      super(new Properties().stacksTo(64).rarity(Rarity.RARE).food(new Builder().nutrition(10).saturationMod(0.4F).build()));
   }

   public int getUseDuration(ItemStack itemstack) {
      return 20;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("An unstable microbial fluid that lashes out at healthy hosts, but regenerates the weakened."));
      list.add(Component.literal("§7Effects: Regeneration 2 (5s) if below half health, or Poison 2 (5s) otherwise"));
   }

   public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
      ItemStack retval = super.finishUsingItem(itemstack, world, entity);
      double x = entity.getX();
      double y = entity.getY();
      double z = entity.getZ();
      HemoplasmPlayerFinishesUsingItemProcedure.execute(entity);
      return retval;
   }
}
