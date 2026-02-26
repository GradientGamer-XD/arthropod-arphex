package net.arphex.procedures;

import net.minecraft.world.entity.Entity;

public class StillCondButterflyProcedure {
   public static boolean execute(Entity entity) {
      return entity == null ? false : !(entity.getPersistentData().getDouble("flywalk") < 300.0);
   }
}
