package net.arphex.item;

import java.util.List;
import net.arphex.procedures.CrawlingCompostChunkPlayerFinishesUsingItemProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties.Builder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;

public class CrawlingCompostChunkItem extends Item {
   public CrawlingCompostChunkItem() {
      super(new Properties().stacksTo(64).rarity(Rarity.COMMON).food(new Builder().nutrition(2).saturationMod(0.2F).meat().build()));
   }

   public int getUseDuration(ItemStack itemstack) {
      return 60;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("Crafts into bonemeal (9) or compost blocks (4)"));
      list.add(Component.literal("§7Drops from Spider Obstructer"));
   }

   public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
      ItemStack retval = super.finishUsingItem(itemstack, world, entity);
      double x = entity.getX();
      double y = entity.getY();
      double z = entity.getZ();
      CrawlingCompostChunkPlayerFinishesUsingItemProcedure.execute(entity);
      return retval;
   }
}
