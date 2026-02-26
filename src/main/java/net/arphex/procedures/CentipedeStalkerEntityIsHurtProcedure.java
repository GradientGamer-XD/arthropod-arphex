package net.arphex.procedures;

import net.minecraft.world.entity.Entity;

public class CentipedeStalkerEntityIsHurtProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putBoolean("triggered", true);
      }
   }
}
