package net.arphex.procedures;

import net.arphex.entity.SmallTormentSphereEntity;
import net.minecraft.world.entity.Entity;

public class SmallTormentSphereEntityVisualScaleProcedure {
   public static double execute(Entity entity) {
      if (entity == null) {
         return 0.0;
      } else {
         return entity instanceof SmallTormentSphereEntity _datEntI
            ? (double)((Integer)_datEntI.getEntityData().get(SmallTormentSphereEntity.DATA_randomsize)).intValue()
            : 0.0;
      }
   }
}
