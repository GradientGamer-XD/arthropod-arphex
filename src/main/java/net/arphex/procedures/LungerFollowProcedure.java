package net.arphex.procedures;

import net.arphex.entity.SpiderLungerEntity;
import net.minecraft.world.entity.Entity;

public class LungerFollowProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         if (entity instanceof SpiderLungerEntity _datEntL0 && (Boolean)_datEntL0.getEntityData().get(SpiderLungerEntity.DATA_follow)) {
            return true;
         }

         return false;
      }
   }
}
