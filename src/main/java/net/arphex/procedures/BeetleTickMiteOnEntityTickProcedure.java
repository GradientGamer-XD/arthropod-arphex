package net.arphex.procedures;

import net.minecraft.world.entity.Entity;

public class BeetleTickMiteOnEntityTickProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         entity.setMaxUpStep(2.0F);
      }
   }
}
