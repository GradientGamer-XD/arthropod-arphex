package net.arphex.procedures;

import net.arphex.entity.AntArsonistEntity;
import net.minecraft.world.entity.Entity;

public class AntShinyProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean shiny = false;
         if (entity instanceof AntArsonistEntity _datEntL0 && (Boolean)_datEntL0.getEntityData().get(AntArsonistEntity.DATA_shiny)) {
            return false;
         }

         return true;
      }
   }
}
