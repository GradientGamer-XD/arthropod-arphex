package net.arphex.procedures;

import net.arphex.entity.WaspNemesisEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class WaspNemesisEntityVisualScaleProcedure {
   public static double execute(Entity entity) {
      if (entity == null) {
         return 0.0;
      } else {
         double distance_level = 0.0;
         return Mth.nextDouble(
            RandomSource.create(),
            entity instanceof WaspNemesisEntity _datEntIx ? (double)((Integer)_datEntIx.getEntityData().get(WaspNemesisEntity.DATA_size)).intValue() : 0.0,
            entity instanceof WaspNemesisEntity _datEntI ? (double)((Integer)_datEntI.getEntityData().get(WaspNemesisEntity.DATA_size)).intValue() : 0.0
         );
      }
   }
}
