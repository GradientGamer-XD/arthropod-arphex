package net.arphex.procedures;

import net.arphex.entity.TormentorSphereEntity;
import net.minecraft.world.entity.Entity;

public class TormentorSphereEntityVisualScaleProcedure {
   public static double execute(Entity entity) {
      return entity == null
         ? 0.0
         : (double)((entity instanceof TormentorSphereEntity _datEntI ? (Integer)_datEntI.getEntityData().get(TormentorSphereEntity.DATA_growsize) : 0) / 10);
   }
}
