package net.arphex.item;

import java.util.List;
import net.arphex.init.ArphexModItems;
import net.arphex.procedures.CrawlingCakeItemInHandTickProcedure;
import net.arphex.procedures.CrawlingCakePlayerFinishesUsingItemProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties.Builder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;

public class CrawlingCakeItem extends Item {
   public CrawlingCakeItem() {
      super(new Properties().durability(10).rarity(Rarity.RARE).food(new Builder().nutrition(4).saturationMod(0.3F).alwaysEat().build()));
   }

   public int getUseDuration(ItemStack itemstack) {
      return 40;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(
         Component.literal(
            "The Crawling Cake is an amalgamation of nutritious ingredients, recommended only for those with the strongest of stomachs - Can be consumed multiple times."
         )
      );
      list.add(Component.literal("§7Effects: Night Vision (20s), Regeneration (20s), Absorption 2 (20s), Poison (3s) "));
   }

   public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
      ItemStack retval = new ItemStack((ItemLike)ArphexModItems.CRAWLING_CAKE.get());
      super.finishUsingItem(itemstack, world, entity);
      double x = entity.getX();
      double y = entity.getY();
      double z = entity.getZ();
      CrawlingCakePlayerFinishesUsingItemProcedure.execute(world, entity);
      if (itemstack.isEmpty()) {
         return retval;
      } else {
         if (entity instanceof Player player && !player.getAbilities().instabuild && !player.getInventory().add(retval)) {
            player.drop(retval, false);
         }

         return itemstack;
      }
   }

   public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.inventoryTick(itemstack, world, entity, slot, selected);
      if (selected) {
         CrawlingCakeItemInHandTickProcedure.execute(entity, itemstack);
      }
   }
}
