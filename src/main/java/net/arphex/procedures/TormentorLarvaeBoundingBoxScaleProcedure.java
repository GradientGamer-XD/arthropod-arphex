package net.arphex.procedures;

import net.arphex.entity.TormentorLarvaeEntity;
import net.minecraft.world.entity.Entity;

public class TormentorLarvaeBoundingBoxScaleProcedure {
   public static double execute(Entity entity) {
      return entity == null
         ? 0.0
         : (double)Math.round(
            (float)((entity instanceof TormentorLarvaeEntity _datEntI ? (Integer)_datEntI.getEntityData().get(TormentorLarvaeEntity.DATA_sizevar) : 0) / 10)
         );
   }
}
