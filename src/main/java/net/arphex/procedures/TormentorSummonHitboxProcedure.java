package net.arphex.procedures;

import net.arphex.entity.TormentorSummonEntity;
import net.minecraft.world.entity.Entity;

public class TormentorSummonHitboxProcedure {
   public static double execute(Entity entity) {
      if (entity == null) {
         return 0.0;
      } else {
         return (entity instanceof TormentorSummonEntity _datEntIx ? _datEntIx.getEntityData().get(TormentorSummonEntity.DATA_ownerkills) : 0) > 200
            ? 3.0
            : 0.9
               + (double)(
                  (entity instanceof TormentorSummonEntity _datEntI ? (Integer)_datEntI.getEntityData().get(TormentorSummonEntity.DATA_ownerkills) : 0) / 100
               );
      }
   }
}
