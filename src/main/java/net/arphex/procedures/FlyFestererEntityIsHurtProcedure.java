package net.arphex.procedures;

import net.minecraft.world.entity.Entity;

public class FlyFestererEntityIsHurtProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putDouble("flywalk", 1000.0);
      }
   }
}
