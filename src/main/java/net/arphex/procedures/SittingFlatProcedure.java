package net.arphex.procedures;

import net.arphex.entity.SpiderFlatEntity;
import net.minecraft.world.entity.Entity;

public class SittingFlatProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         if (entity instanceof SpiderFlatEntity _datEntL0 && (Boolean)_datEntL0.getEntityData().get(SpiderFlatEntity.DATA_sit)) {
            return false;
         }

         return true;
      }
   }
}
