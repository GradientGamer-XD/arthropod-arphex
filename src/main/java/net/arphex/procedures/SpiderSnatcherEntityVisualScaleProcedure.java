package net.arphex.procedures;

import net.minecraft.world.entity.Entity;

public class SpiderSnatcherEntityVisualScaleProcedure {
   public static double execute(Entity entity) {
      if (entity == null) {
         return 0.0;
      } else {
         return entity.getDisplayName().getString().equals("Overgrown Snatcher") ? 6.7 : 5.7;
      }
   }
}
