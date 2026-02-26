package net.arphex.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;

public class ForceGauntletItemIsCraftedsmeltedProcedure {
   public static void execute(ItemStack itemstack) {
      itemstack.getOrCreateTag().putBoolean("crafted", true);
      itemstack.enchant(Enchantments.KNOCKBACK, 5);
   }
}
