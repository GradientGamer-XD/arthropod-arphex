package net.arphex.procedures;

import net.arphex.entity.EnormousSpiderHallucinationEntity;
import net.minecraft.world.entity.Entity;

public class RandomSpiderSizeProcedure {
   public static double execute(Entity entity) {
      if (entity == null) {
         return 0.0;
      } else {
         return entity instanceof EnormousSpiderHallucinationEntity _datEntI
            ? (double)((Integer)_datEntI.getEntityData().get(EnormousSpiderHallucinationEntity.DATA_size)).intValue()
            : 0.0;
      }
   }
}
