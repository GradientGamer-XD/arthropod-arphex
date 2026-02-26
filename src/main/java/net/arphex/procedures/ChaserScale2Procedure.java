package net.arphex.procedures;

import net.arphex.entity.SpiderChaserHallucination2Entity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class ChaserScale2Procedure {
   public static double execute(Entity entity) {
      return entity == null
         ? 0.0
         : Mth.nextDouble(
            RandomSource.create(),
            (double)(
               (
                     entity instanceof SpiderChaserHallucination2Entity _datEntIx
                        ? (Integer)_datEntIx.getEntityData().get(SpiderChaserHallucination2Entity.DATA_random_size)
                        : 0
                  )
                  / 10
            ),
            (double)(
               (
                     entity instanceof SpiderChaserHallucination2Entity _datEntI
                        ? (Integer)_datEntI.getEntityData().get(SpiderChaserHallucination2Entity.DATA_random_size)
                        : 0
                  )
                  / 10
            )
         );
   }
}
