package net.arphex.procedures;

import net.arphex.entity.DiabolosDecimatorEntity;
import net.minecraft.world.entity.Entity;

public class DiabolosDecimatorEntityIsHurtProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity instanceof DiabolosDecimatorEntity _datEntSetL) {
            _datEntSetL.getEntityData().set(DiabolosDecimatorEntity.DATA_primed, true);
         }
      }
   }
}
