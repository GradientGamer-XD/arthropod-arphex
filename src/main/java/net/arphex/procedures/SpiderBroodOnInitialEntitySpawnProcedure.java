package net.arphex.procedures;

import net.minecraft.world.entity.Entity;

public class SpiderBroodOnInitialEntitySpawnProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putDouble("webtime", 0.0);
         entity.getPersistentData().putDouble("climbradius", 1.0);
      }
   }
}
