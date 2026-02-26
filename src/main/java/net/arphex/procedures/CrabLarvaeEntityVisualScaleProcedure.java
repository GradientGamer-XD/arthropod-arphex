package net.arphex.procedures;

import net.arphex.entity.CrabLarvaeEntity;
import net.minecraft.world.entity.Entity;

public class CrabLarvaeEntityVisualScaleProcedure {
   public static double execute(Entity entity) {
      if (entity == null) {
         return 0.0;
      } else if ((entity instanceof CrabLarvaeEntity _datEntI ? (Integer)_datEntI.getEntityData().get(CrabLarvaeEntity.DATA_crab_growth) : 0) > 95999) {
         return 6.0;
      } else if ((entity instanceof CrabLarvaeEntity _datEntI ? (Integer)_datEntI.getEntityData().get(CrabLarvaeEntity.DATA_crab_growth) : 0) > 65000) {
         return 4.0;
      } else if ((entity instanceof CrabLarvaeEntity _datEntI ? (Integer)_datEntI.getEntityData().get(CrabLarvaeEntity.DATA_crab_growth) : 0) > 35000) {
         return 3.0;
      } else {
         return (entity instanceof CrabLarvaeEntity _datEntI ? _datEntI.getEntityData().get(CrabLarvaeEntity.DATA_crab_growth) : 0) > 15000 ? 2.5 : 2.0;
      }
   }
}
