package net.arphex.procedures;

import net.minecraft.world.entity.Entity;

public class AbyssalBladeOnPlayerStoppedUsingProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putDouble("abysstimer", 20.0);
      }
   }
}
