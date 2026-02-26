package net.arphex.procedures;

import net.minecraft.world.item.ItemStack;

public class OblivionRayPropertyValueProviderProcedure {
   public static double execute(ItemStack itemstack) {
      return itemstack.getOrCreateTag().getBoolean("oblivion_ray_mining_mode") ? 1.0 : 0.0;
   }
}
