package net.arphex.procedures;

import net.arphex.entity.ArachnoidTrisectorEntity;
import net.minecraft.world.entity.Entity;

public class ArachnoidTrisectorEntityIsHurtProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity instanceof ArachnoidTrisectorEntity _datEntSetL) {
            _datEntSetL.getEntityData().set(ArachnoidTrisectorEntity.DATA_primed, true);
         }
      }
   }
}
