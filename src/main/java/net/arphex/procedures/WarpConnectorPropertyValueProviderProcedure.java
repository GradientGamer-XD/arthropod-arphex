package net.arphex.procedures;

import net.minecraft.world.item.ItemStack;

public class WarpConnectorPropertyValueProviderProcedure {
   public static double execute(ItemStack itemstack) {
      return itemstack.getOrCreateTag().getDouble("portal_lock_x") == 0.0 ? 0.0 : 1.0;
   }
}
