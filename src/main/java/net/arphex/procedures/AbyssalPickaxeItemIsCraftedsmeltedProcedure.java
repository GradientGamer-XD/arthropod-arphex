package net.arphex.procedures;

import net.arphex.init.ArphexModEnchantments;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

public class AbyssalPickaxeItemIsCraftedsmeltedProcedure {
   public static void execute(ItemStack itemstack) {
      itemstack.enchant((Enchantment)ArphexModEnchantments.WITHER_AURA.get(), 3);
      itemstack.enchant(Enchantments.BLOCK_EFFICIENCY, 5);
      itemstack.enchant(Enchantments.BLOCK_FORTUNE, 3);
      itemstack.getOrCreateTag().putBoolean("crafted", true);
   }
}
