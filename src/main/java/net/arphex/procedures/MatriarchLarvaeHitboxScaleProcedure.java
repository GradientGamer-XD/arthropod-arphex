package net.arphex.procedures;

import net.arphex.entity.SpiderMatriarchLarvaeEntity;
import net.minecraft.world.entity.Entity;

public class MatriarchLarvaeHitboxScaleProcedure {
   public static double execute(Entity entity) {
      if (entity == null) {
         return 0.0;
      } else if ((entity instanceof SpiderMatriarchLarvaeEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderMatriarchLarvaeEntity.DATA_grow) : 0)
         > 11990) {
         return 1.0;
      } else {
         return (entity instanceof SpiderMatriarchLarvaeEntity _datEntI ? _datEntI.getEntityData().get(SpiderMatriarchLarvaeEntity.DATA_grow) : 0) > 6000
            ? 0.7
            : 0.4;
      }
   }
}
