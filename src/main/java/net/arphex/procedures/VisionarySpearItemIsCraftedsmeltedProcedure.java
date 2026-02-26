package net.arphex.procedures;

import net.arphex.init.ArphexModEnchantments;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;

public class VisionarySpearItemIsCraftedsmeltedProcedure {
   public static void execute(ItemStack itemstack) {
      itemstack.enchant((Enchantment)ArphexModEnchantments.WITHER_AURA.get(), 5);
   }
}
