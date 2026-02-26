package net.arphex.procedures;

import net.arphex.entity.AntArsonistAlateQueenEntity;
import net.minecraft.world.entity.Entity;

public class AntQueenHitboxProcedure {
   public static double execute(Entity entity) {
      if (entity == null) {
         return 0.0;
      } else {
         double queenscale = 0.0;
         if ((entity instanceof AntArsonistAlateQueenEntity _datEntI ? (Integer)_datEntI.getEntityData().get(AntArsonistAlateQueenEntity.DATA_queenlevel) : 0)
            > 36000) {
            queenscale = 2.45;
         } else if ((
               entity instanceof AntArsonistAlateQueenEntity _datEntI ? (Integer)_datEntI.getEntityData().get(AntArsonistAlateQueenEntity.DATA_queenlevel) : 0
            )
            > 12000) {
            queenscale = 1.95;
         } else if ((
               entity instanceof AntArsonistAlateQueenEntity _datEntI ? (Integer)_datEntI.getEntityData().get(AntArsonistAlateQueenEntity.DATA_queenlevel) : 0
            )
            > 1200) {
            queenscale = 1.46;
         } else {
            queenscale = 0.96;
         }

         return queenscale;
      }
   }
}
