package net.arphex.procedures;

import net.arphex.entity.SpiderLarvaeEntity;
import net.minecraft.world.entity.Entity;

public class NonShinyProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean shiny = false;
         if (entity instanceof SpiderLarvaeEntity _datEntL0 && (Boolean)_datEntL0.getEntityData().get(SpiderLarvaeEntity.DATA_shiny)) {
            return false;
         }

         return true;
      }
   }
}
