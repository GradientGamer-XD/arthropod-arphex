package net.arphex.procedures;

import net.arphex.entity.SpiderRecluseEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.fml.ModList;

public class RecluseHitboxScaleProcedure {
   public static double execute(Entity entity) {
      if (entity == null) {
         return 0.0;
      } else {
         return !ModList.get().isLoaded("nyfsspiders")
               || (entity instanceof SpiderRecluseEntity _datEntIxxxx ? _datEntIxxxx.getEntityData().get(SpiderRecluseEntity.DATA_hangweb) : 0) <= 0
                  && !(
                     Mth.nextDouble(
                           RandomSource.create(),
                           (double)(
                              (entity instanceof SpiderRecluseEntity _datEntIxxx ? (Integer)_datEntIxxx.getEntityData().get(SpiderRecluseEntity.DATA_size) : 0)
                                 / 15
                           ),
                           (double)(
                              (entity instanceof SpiderRecluseEntity _datEntIxx ? (Integer)_datEntIxx.getEntityData().get(SpiderRecluseEntity.DATA_size) : 0)
                                 / 15
                           )
                        )
                        > 0.99
                  )
            ? Mth.nextDouble(
               RandomSource.create(),
               (double)((entity instanceof SpiderRecluseEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SpiderRecluseEntity.DATA_size) : 0) / 15),
               (double)((entity instanceof SpiderRecluseEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderRecluseEntity.DATA_size) : 0) / 15)
            )
            : 0.99;
      }
   }
}
