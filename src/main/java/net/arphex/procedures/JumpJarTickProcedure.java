package net.arphex.procedures;

import net.minecraft.world.item.ItemStack;

public class JumpJarTickProcedure {
   public static void execute(ItemStack itemstack) {
      if (itemstack.getOrCreateTag().getDouble("spiderhealth") < 40.0) {
         itemstack.getOrCreateTag().putDouble("spiderhealth", itemstack.getOrCreateTag().getDouble("spiderhealth") + 0.05);
      }
   }
}
