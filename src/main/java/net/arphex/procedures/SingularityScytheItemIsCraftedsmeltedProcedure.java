package net.arphex.procedures;

import net.arphex.init.ArphexModEnchantments;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

public class SingularityScytheItemIsCraftedsmeltedProcedure {
   public static void execute(ItemStack itemstack) {
      itemstack.getOrCreateTag().putBoolean("crafted", true);
      itemstack.enchant((Enchantment)ArphexModEnchantments.WITHER_AURA.get(), 10);
      itemstack.enchant(Enchantments.FIRE_ASPECT, 2);
      itemstack.enchant(Enchantments.MOB_LOOTING, 3);
   }
}
