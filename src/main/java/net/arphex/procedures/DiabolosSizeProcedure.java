package net.arphex.procedures;

import net.arphex.entity.DiabolosDecimatorEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class DiabolosSizeProcedure {
   public static double execute(Entity entity) {
      return entity == null
         ? 0.0
         : Mth.nextDouble(
               RandomSource.create(),
               entity instanceof DiabolosDecimatorEntity _datEntIx
                  ? (double)((Integer)_datEntIx.getEntityData().get(DiabolosDecimatorEntity.DATA_size_num)).intValue()
                  : 0.0,
               entity instanceof DiabolosDecimatorEntity _datEntI
                  ? (double)((Integer)_datEntI.getEntityData().get(DiabolosDecimatorEntity.DATA_size_num)).intValue()
                  : 0.0
            )
            / 100.0;
   }
}
