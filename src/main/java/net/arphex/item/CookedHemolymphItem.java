package net.arphex.item;

import java.util.List;
import net.arphex.procedures.CookedHemolymphPlayerFinishesUsingItemProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties.Builder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;

public class CookedHemolymphItem extends Item {
   public CookedHemolymphItem() {
      super(new Properties().stacksTo(64).rarity(Rarity.RARE).food(new Builder().nutrition(10).saturationMod(0.3F).alwaysEat().build()));
   }

   public int getUseDuration(ItemStack itemstack) {
      return 20;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("Edible arthropod circulatory fluid pulsing with mysterious energy"));
      list.add(Component.literal("§7Effects: Absorption (60s)"));
   }

   public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
      ItemStack retval = super.finishUsingItem(itemstack, world, entity);
      double x = entity.getX();
      double y = entity.getY();
      double z = entity.getZ();
      CookedHemolymphPlayerFinishesUsingItemProcedure.execute(entity);
      return retval;
   }
}
