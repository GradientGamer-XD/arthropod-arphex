package net.arphex.procedures;

import net.arphex.init.ArphexModEnchantments;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

public class AbyssalBladeItemIsCraftedsmeltedProcedure {
   public static void execute(ItemStack itemstack) {
      itemstack.enchant((Enchantment)ArphexModEnchantments.WITHER_AURA.get(), 3);
      itemstack.enchant(Enchantments.BANE_OF_ARTHROPODS, 3);
      itemstack.enchant(Enchantments.MOB_LOOTING, 3);
      itemstack.getOrCreateTag().putBoolean("crafted", true);
   }
}
