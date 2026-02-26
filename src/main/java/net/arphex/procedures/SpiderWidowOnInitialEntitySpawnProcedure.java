package net.arphex.procedures;

import net.minecraft.world.entity.Entity;

public class SpiderWidowOnInitialEntitySpawnProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putDouble("climbradius", 1.42);
      }
   }
}
