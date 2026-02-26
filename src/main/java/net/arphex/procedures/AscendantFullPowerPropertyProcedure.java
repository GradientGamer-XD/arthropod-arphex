package net.arphex.procedures;

import net.minecraft.world.entity.Entity;

public class AscendantFullPowerPropertyProcedure {
   public static double execute(Entity entity) {
      if (entity == null) {
         return 0.0;
      } else {
         double flin = 0.0;
         if (entity.getPersistentData().getDouble("abflytime") > 78.0) {
            flin = 1.0;
         } else {
            flin = -1.0;
         }

         return flin;
      }
   }
}
