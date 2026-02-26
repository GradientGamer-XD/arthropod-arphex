package net.arphex.procedures;

import net.arphex.entity.TermiteTunnelerKingEntity;
import net.minecraft.world.entity.Entity;

public class KingFollowProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         if (entity instanceof TermiteTunnelerKingEntity _datEntL0 && (Boolean)_datEntL0.getEntityData().get(TermiteTunnelerKingEntity.DATA_following)) {
            return true;
         }

         return false;
      }
   }
}
