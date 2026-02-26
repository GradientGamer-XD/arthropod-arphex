package net.arphex.procedures;

import net.arphex.entity.TormentorSummonEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class TormentorSummonScaleProcedure {
   public static double execute(Entity entity) {
      return entity == null
         ? 0.0
         : 0.1
            + Mth.nextDouble(
                  RandomSource.create(),
                  entity instanceof TormentorSummonEntity _datEntIxxx
                     ? (double)((Integer)_datEntIxxx.getEntityData().get(TormentorSummonEntity.DATA_ownerkills)).intValue()
                     : 0.0,
                  entity instanceof TormentorSummonEntity _datEntIxx
                     ? (double)((Integer)_datEntIxx.getEntityData().get(TormentorSummonEntity.DATA_ownerkills)).intValue()
                     : 0.0
               )
               / 100.0
            + Mth.nextDouble(
               RandomSource.create(),
               entity instanceof TormentorSummonEntity _datEntIx
                  ? (double)((Integer)_datEntIx.getEntityData().get(TormentorSummonEntity.DATA_patreon_reskin)).intValue()
                  : 0.0,
               entity instanceof TormentorSummonEntity _datEntI
                  ? (double)((Integer)_datEntI.getEntityData().get(TormentorSummonEntity.DATA_patreon_reskin)).intValue()
                  : 0.0
            );
   }
}
