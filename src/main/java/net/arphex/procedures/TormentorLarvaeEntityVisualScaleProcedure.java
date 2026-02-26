package net.arphex.procedures;

import net.arphex.entity.TormentorLarvaeEntity;
import net.minecraft.world.entity.Entity;

public class TormentorLarvaeEntityVisualScaleProcedure {
   public static double execute(Entity entity) {
      return entity == null
         ? 0.0
         : (double)((entity instanceof TormentorLarvaeEntity _datEntI ? (Integer)_datEntI.getEntityData().get(TormentorLarvaeEntity.DATA_sizevar) : 0) / 8);
   }
}
