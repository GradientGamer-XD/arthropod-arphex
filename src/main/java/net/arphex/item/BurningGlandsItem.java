package net.arphex.item;

import java.util.List;
import net.arphex.procedures.BurningGlandsPlayerFinishesUsingItemProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties.Builder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;

public class BurningGlandsItem extends Item {
   public BurningGlandsItem() {
      super(new Properties().stacksTo(64).fireResistant().rarity(Rarity.COMMON).food(new Builder().nutrition(1).saturationMod(0.3F).alwaysEat().build()));
   }

   public int getUseDuration(ItemStack itemstack) {
      return 20;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("Used to craft scorch charges (flamethrower component). Eat for 10 seconds of fire resistance"));
      list.add(Component.literal("§7Drops from Ant Arsonists"));
   }

   public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
      ItemStack retval = super.finishUsingItem(itemstack, world, entity);
      double x = entity.getX();
      double y = entity.getY();
      double z = entity.getZ();
      BurningGlandsPlayerFinishesUsingItemProcedure.execute(entity);
      return retval;
   }
}
