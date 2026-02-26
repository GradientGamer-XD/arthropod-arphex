package net.arphex.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

public class VitalityViewfinderItemInInventoryTickProcedure {
   public static void execute(Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (itemstack.getOrCreateTag().getDouble("lensmode") > 0.0) {
            entity.getPersistentData().putDouble("lensmode", 5.0);
         }
      }
   }
}
