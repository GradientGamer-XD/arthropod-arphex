package net.arphex.procedures;

import net.minecraft.world.entity.Entity;

public class BeingRiddenProcedure {
   public static boolean execute(Entity entity) {
      return entity == null ? false : !entity.isVehicle();
   }
}
