package net.arphex.procedures;

import net.arphex.entity.ArachnoidTrisectorEntity;
import net.minecraft.world.entity.Entity;

public class ArachnoidTimeCloneEntityIsHurtProcedure {
   public static void execute(Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         if (entity.getPersistentData().getDouble("arachnoid_time_clone") > 20.0
            && !(sourceentity instanceof ArachnoidTrisectorEntity)
            && !entity.level().isClientSide()) {
            entity.discard();
         }
      }
   }
}
