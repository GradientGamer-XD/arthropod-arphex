package net.arphex.item;

import java.util.List;
import net.arphex.procedures.AbyssalStewPlayerFinishesUsingItemProcedure;
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

public class AbyssalStewItem extends Item {
   public AbyssalStewItem() {
      super(new Properties().stacksTo(64).fireResistant().rarity(Rarity.EPIC).food(new Builder().nutrition(50).saturationMod(2.0F).alwaysEat().build()));
   }

   public int getUseDuration(ItemStack itemstack) {
      return 50;
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFoil(ItemStack itemstack) {
      return true;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("The nightmarish power of the abyss, brutally distilled into a form edible only by the worthy. "));
      list.add(Component.literal("- §cBeware, it deals heavy damage to those not wearing strong armour (netherite+)"));
      list.add(Component.literal("§7Effects: Resistance (120s), Regeneration 2 (120s), Darkness (30s)"));
   }

   public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
      ItemStack retval = super.finishUsingItem(itemstack, world, entity);
      double x = entity.getX();
      double y = entity.getY();
      double z = entity.getZ();
      AbyssalStewPlayerFinishesUsingItemProcedure.execute(entity);
      return retval;
   }
}
