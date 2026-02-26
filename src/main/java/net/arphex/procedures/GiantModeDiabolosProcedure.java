package net.arphex.procedures;

import net.arphex.entity.DiabolosDecimatorEntity;
import net.minecraft.world.entity.Entity;

public class GiantModeDiabolosProcedure {
   public static boolean execute(Entity entity) {
      return entity == null
         ? false
         : (entity instanceof DiabolosDecimatorEntity _datEntI ? (Integer)_datEntI.getEntityData().get(DiabolosDecimatorEntity.DATA_size_num) : 0) > 2000;
   }
}
