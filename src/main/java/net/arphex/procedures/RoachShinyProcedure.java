package net.arphex.procedures;

import net.arphex.entity.RoachRiverspawnEntity;
import net.minecraft.world.entity.Entity;

public class RoachShinyProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean shiny = false;
         if (entity instanceof RoachRiverspawnEntity _datEntL0 && (Boolean)_datEntL0.getEntityData().get(RoachRiverspawnEntity.DATA_shiny)) {
            return false;
         }

         return true;
      }
   }
}
