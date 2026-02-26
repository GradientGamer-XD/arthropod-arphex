package net.arphex.procedures;

import net.arphex.entity.WaspNemesisEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class WaspNemesisHitboxProcedure {
   public static double execute(Entity entity) {
      return entity == null
         ? 0.0
         : 0.49
            + Mth.nextDouble(
               RandomSource.create(),
               (double)((entity instanceof WaspNemesisEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(WaspNemesisEntity.DATA_size) : 0) / 18),
               (double)((entity instanceof WaspNemesisEntity _datEntI ? (Integer)_datEntI.getEntityData().get(WaspNemesisEntity.DATA_size) : 0) / 18)
            );
   }
}
