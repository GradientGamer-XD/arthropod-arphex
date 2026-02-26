package net.arphex.item;

import java.util.List;
import net.arphex.procedures.ElixirOfSplinteredSanityPlayerFinishesUsingItemProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties.Builder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ElixirOfSplinteredSanityItem extends Item {
   public ElixirOfSplinteredSanityItem() {
      super(new Properties().stacksTo(64).rarity(Rarity.EPIC).food(new Builder().nutrition(999).saturationMod(20.0F).alwaysEat().build()));
   }

   public int getUseDuration(ItemStack itemstack) {
      return 200;
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFoil(ItemStack itemstack) {
      return true;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(
         Component.literal(
            "The elixir provides permanent sustenance at the cost of your sanity — hallucination entities become able to deal heavy damage to you, but you become able to attack them (just attack towards their direction) and gain random buffs"
         )
      );
      list.add(Component.literal("§7Effects: Splintered Sanity / Eternal Sustenance (permanent), Resistance IV (120s) "));
   }

   public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
      ItemStack retval = super.finishUsingItem(itemstack, world, entity);
      double x = entity.getX();
      double y = entity.getY();
      double z = entity.getZ();
      ElixirOfSplinteredSanityPlayerFinishesUsingItemProcedure.execute(world, x, y, z, entity);
      return retval;
   }
}
