package net.arphex.procedures;

import net.arphex.entity.CrabLarvaeEntity;
import net.minecraft.world.entity.Entity;

public class CrabFollowProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         if (entity instanceof CrabLarvaeEntity _datEntL0 && (Boolean)_datEntL0.getEntityData().get(CrabLarvaeEntity.DATA_following)) {
            return true;
         }

         return false;
      }
   }
}
