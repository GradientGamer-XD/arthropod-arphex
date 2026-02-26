package net.arphex.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;

public class AscendantStaffItemIsCraftedsmeltedProcedure {
   public static void execute(ItemStack itemstack) {
      itemstack.enchant(Enchantments.KNOCKBACK, 2);
   }
}
