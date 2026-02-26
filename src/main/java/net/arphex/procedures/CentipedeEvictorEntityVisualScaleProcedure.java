package net.arphex.procedures;

import net.minecraft.world.entity.Entity;

public class CentipedeEvictorEntityVisualScaleProcedure {
   public static double execute(Entity entity) {
      if (entity == null) {
         return 0.0;
      } else {
         return entity.getDisplayName().getString().equals("Small Evictor") ? 3.5 : 4.5;
      }
   }
}
