package net.arphex.procedures;

import net.minecraft.world.entity.Entity;

public class LongLegsFlyEntityVisualScaleProcedure {
   public static double execute(Entity entity) {
      if (entity == null) {
         return 0.0;
      } else {
         double sizevar = 0.0;
         if (entity.getPersistentData().getBoolean("longlarvae")) {
            sizevar = 1.5;
         } else {
            sizevar = 1.0;
         }

         return sizevar;
      }
   }
}
