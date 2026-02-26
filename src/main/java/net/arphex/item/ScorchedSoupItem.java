package net.arphex.item;

import java.util.List;
import net.arphex.procedures.ScorchedSoupPlayerFinishesUsingItemProcedure;
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

public class ScorchedSoupItem extends Item {
   public ScorchedSoupItem() {
      super(new Properties().stacksTo(64).fireResistant().rarity(Rarity.EPIC).food(new Builder().nutrition(50).saturationMod(2.0F).alwaysEat().build()));
   }

   public int getUseDuration(ItemStack itemstack) {
      return 40;
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFoil(ItemStack itemstack) {
      return true;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(
         Component.literal("Soup with a supernaturally powerful burning flavour, granting a volcanic surge of vitality to those who can endure its heat. ")
      );
      list.add(Component.literal("- §cBeware, it deals heavy damage to those not wearing strong armour (netherite+)"));
      list.add(Component.literal("§7Effects: Strength III (180s), Regeneration II (120s), Fire Resistance (180s), Necrosis (20s) "));
   }

   public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
      ItemStack retval = super.finishUsingItem(itemstack, world, entity);
      double x = entity.getX();
      double y = entity.getY();
      double z = entity.getZ();
      ScorchedSoupPlayerFinishesUsingItemProcedure.execute(entity);
      return retval;
   }
}
