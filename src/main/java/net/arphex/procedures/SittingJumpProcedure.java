package net.arphex.procedures;

import net.arphex.entity.SpiderJumpEntity;
import net.minecraft.world.entity.Entity;

public class SittingJumpProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         if (entity instanceof SpiderJumpEntity _datEntL0 && (Boolean)_datEntL0.getEntityData().get(SpiderJumpEntity.DATA_sit)) {
            return false;
         }

         return true;
      }
   }
}
