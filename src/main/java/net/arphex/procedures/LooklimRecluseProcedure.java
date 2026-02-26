package net.arphex.procedures;

import net.arphex.entity.SpiderRecluseEntity;
import net.minecraft.world.entity.Entity;

public class LooklimRecluseProcedure {
   public static boolean execute(Entity entity) {
      return entity == null
         ? false
         : (entity instanceof SpiderRecluseEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderRecluseEntity.DATA_hangweb) : 0) <= 0;
   }
}
