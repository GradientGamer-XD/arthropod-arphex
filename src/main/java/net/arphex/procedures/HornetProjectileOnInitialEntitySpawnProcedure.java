package net.arphex.procedures;

import net.minecraft.world.entity.Entity;

public class HornetProjectileOnInitialEntitySpawnProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putDouble("boostlim_wasp", 20.0);
      }
   }
}
