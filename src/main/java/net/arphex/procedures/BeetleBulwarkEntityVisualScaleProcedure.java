package net.arphex.procedures;

import net.arphex.entity.BeetleBulwarkEntity;
import net.minecraft.world.entity.Entity;

public class BeetleBulwarkEntityVisualScaleProcedure {
   public static double execute(Entity entity) {
      if (entity == null) {
         return 0.0;
      } else {
         double sizever = 0.0;
         if ((entity instanceof BeetleBulwarkEntity _datEntI ? (Integer)_datEntI.getEntityData().get(BeetleBulwarkEntity.DATA_randsize) : 0) == 0) {
            sizever = 0.7;
         }

         if ((entity instanceof BeetleBulwarkEntity _datEntI ? (Integer)_datEntI.getEntityData().get(BeetleBulwarkEntity.DATA_randsize) : 0) == 1) {
            sizever = 1.0;
         }

         if ((entity instanceof BeetleBulwarkEntity _datEntI ? (Integer)_datEntI.getEntityData().get(BeetleBulwarkEntity.DATA_randsize) : 0) == 2) {
            sizever = 1.4;
         }

         if ((entity instanceof BeetleBulwarkEntity _datEntI ? (Integer)_datEntI.getEntityData().get(BeetleBulwarkEntity.DATA_randsize) : 0) == 3) {
            sizever = 2.0;
         }

         return sizever;
      }
   }
}
