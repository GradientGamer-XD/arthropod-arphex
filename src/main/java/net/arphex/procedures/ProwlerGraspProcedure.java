package net.arphex.procedures;

import net.minecraft.world.item.ItemStack;

public class ProwlerGraspProcedure {
   public static boolean execute(ItemStack itemstack) {
      return itemstack.getOrCreateTag().getBoolean("graspmode");
   }
}
