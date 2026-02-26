package net.arphex.procedures;

import net.minecraft.world.entity.Entity;

public class TimeDistortionWaveOnInitialEntitySpawnProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putDouble("fix_x", entity.getX());
         entity.getPersistentData().putDouble("fix_y", entity.getY());
         entity.getPersistentData().putDouble("fix_z", entity.getZ());
         entity.getPersistentData().putDouble("despawn_timer", 0.0);
      }
   }
}
