package net.arphex.procedures;

import net.minecraft.world.item.ItemStack;

public class TemporalTransmitterPropertyValueProviderProcedure {
   public static double execute(ItemStack itemstack) {
      return itemstack.getOrCreateTag().getDouble("flatmodetemp");
   }
}
