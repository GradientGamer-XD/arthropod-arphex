package net.arphex.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;

public class EtherealStaffItemIsCraftedsmeltedProcedure {
   public static void execute(ItemStack itemstack) {
      itemstack.enchant(Enchantments.MOB_LOOTING, 2);
   }
}
