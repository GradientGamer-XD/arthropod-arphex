package net.arphex.procedures;

import net.minecraft.world.entity.Entity;

public class AscendantAnimProcedure {
   public static double execute(Entity entity) {
      return entity == null ? 0.0 : (double)(Math.round(entity.getPersistentData().getDouble("floatingsequence") / 2.0) % 2L);
   }
}
