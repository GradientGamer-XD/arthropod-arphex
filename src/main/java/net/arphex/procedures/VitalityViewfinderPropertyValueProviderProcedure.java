package net.arphex.procedures;

import net.minecraft.world.item.ItemStack;

public class VitalityViewfinderPropertyValueProviderProcedure {
   public static double execute(ItemStack itemstack) {
      return itemstack.getOrCreateTag().getDouble("lensmode");
   }
}
