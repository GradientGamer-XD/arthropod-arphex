package net.arphex.procedures;

import net.arphex.entity.SpiderRecluseEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class SpiderRecluseEntityVisualScaleProcedure {
   public static double execute(Entity entity) {
      return entity == null
         ? 0.0
         : Mth.nextDouble(
            RandomSource.create(),
            (double)((entity instanceof SpiderRecluseEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SpiderRecluseEntity.DATA_size) : 0) / 10),
            (double)((entity instanceof SpiderRecluseEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderRecluseEntity.DATA_size) : 0) / 10)
         );
   }
}
