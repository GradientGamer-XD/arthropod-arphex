package net.arphex.procedures;

import net.arphex.entity.SpiderMatriarchLarvaeEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class MatriarchLarvaeVisualScaleProcedure {
   public static double execute(Entity entity) {
      if (entity == null) {
         return 0.0;
      } else if ((entity instanceof SpiderMatriarchLarvaeEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderMatriarchLarvaeEntity.DATA_grow) : 0)
         > 11990) {
         return 4.5;
      } else {
         return (entity instanceof SpiderMatriarchLarvaeEntity _datEntIxx ? _datEntIxx.getEntityData().get(SpiderMatriarchLarvaeEntity.DATA_grow) : 0) > 3000
            ? Mth.nextDouble(
                  RandomSource.create(),
                  entity instanceof SpiderMatriarchLarvaeEntity _datEntIx
                     ? (double)((Integer)_datEntIx.getEntityData().get(SpiderMatriarchLarvaeEntity.DATA_grow)).intValue()
                     : 0.0,
                  entity instanceof SpiderMatriarchLarvaeEntity _datEntI
                     ? (double)((Integer)_datEntI.getEntityData().get(SpiderMatriarchLarvaeEntity.DATA_grow)).intValue()
                     : 0.0
               )
               / 3000.0
            : 1.0;
      }
   }
}
