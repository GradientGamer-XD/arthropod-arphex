package net.arphex.procedures;

import net.arphex.entity.SummonSunBlastEntity;
import net.minecraft.world.entity.Entity;

public class SummonSunBlastEntityVisualScaleProcedure {
   public static double execute(Entity entity) {
      if (entity == null) {
         return 0.0;
      } else {
         return entity instanceof SummonSunBlastEntity _datEntI
            ? (double)((Integer)_datEntI.getEntityData().get(SummonSunBlastEntity.DATA_size)).intValue()
            : 0.0;
      }
   }
}
