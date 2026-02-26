package net.arphex.procedures;

import net.arphex.entity.SpiderGoliathEntity;
import net.minecraft.world.entity.Entity;

public class SpiderGoliathEntityVisualScaleProcedure {
   public static double execute(Entity entity) {
      if (entity == null) {
         return 0.0;
      } else {
         double tarantulasize = 0.0;
         if ((entity instanceof SpiderGoliathEntity animatable ? animatable.getTexture() : "null").equals("tarantula1")) {
            tarantulasize = 6.5;
         } else if ((entity instanceof SpiderGoliathEntity animatablexx ? animatablexx.getTexture() : "null").equals("tarantula3")
            || (entity instanceof SpiderGoliathEntity animatablex ? animatablex.getTexture() : "null").equals("tarantula5")
            || (entity instanceof SpiderGoliathEntity animatable ? animatable.getTexture() : "null").equals("tarantula6")) {
            tarantulasize = 6.0;
         } else if (!(entity instanceof SpiderGoliathEntity animatablex ? animatablex.getTexture() : "null").equals("tarantula7")
            && !(entity instanceof SpiderGoliathEntity animatable ? animatable.getTexture() : "null").equals("tarantula2")) {
            tarantulasize = 5.6;
         } else {
            tarantulasize = 5.8;
         }

         return tarantulasize;
      }
   }
}
