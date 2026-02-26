package net.arphex.procedures;

import net.arphex.entity.HornetHarbingerEntity;
import net.minecraft.world.entity.Entity;

public class HornetShinyProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean shiny = false;
         if (entity instanceof HornetHarbingerEntity _datEntL0 && (Boolean)_datEntL0.getEntityData().get(HornetHarbingerEntity.DATA_shiny)) {
            return false;
         }

         return true;
      }
   }
}
