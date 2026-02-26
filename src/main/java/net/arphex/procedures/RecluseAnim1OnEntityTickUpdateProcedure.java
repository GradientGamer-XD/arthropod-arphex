package net.arphex.procedures;

import net.minecraft.world.entity.Entity;

public class RecluseAnim1OnEntityTickUpdateProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (!entity.level().isClientSide()) {
            entity.discard();
         }
      }
   }
}
