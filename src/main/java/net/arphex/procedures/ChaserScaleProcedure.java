package net.arphex.procedures;

import net.arphex.entity.SpiderChaserHallucinationEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class ChaserScaleProcedure {
   public static double execute(Entity entity) {
      return entity == null
         ? 0.0
         : Mth.nextDouble(
            RandomSource.create(),
            (double)(
               (
                     entity instanceof SpiderChaserHallucinationEntity _datEntIx
                        ? (Integer)_datEntIx.getEntityData().get(SpiderChaserHallucinationEntity.DATA_random_size)
                        : 0
                  )
                  / 10
            ),
            (double)(
               (
                     entity instanceof SpiderChaserHallucinationEntity _datEntI
                        ? (Integer)_datEntI.getEntityData().get(SpiderChaserHallucinationEntity.DATA_random_size)
                        : 0
                  )
                  / 10
            )
         );
   }
}
