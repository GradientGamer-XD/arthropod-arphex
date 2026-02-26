package net.arphex.procedures;

import net.arphex.entity.CentipedeEvictorLarvaeEntity;
import net.minecraft.world.entity.Entity;

public class NotShinyProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         if (entity instanceof CentipedeEvictorLarvaeEntity _datEntL0 && (Boolean)_datEntL0.getEntityData().get(CentipedeEvictorLarvaeEntity.DATA_shinier)) {
            return false;
         }

         return true;
      }
   }
}
