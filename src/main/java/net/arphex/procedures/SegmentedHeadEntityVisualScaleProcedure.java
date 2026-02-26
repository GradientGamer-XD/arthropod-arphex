package net.arphex.procedures;

import net.arphex.entity.SegmentedBodyEntity;
import net.minecraft.world.entity.Entity;

public class SegmentedHeadEntityVisualScaleProcedure {
   public static double execute(Entity entity) {
      if (entity == null) {
         return 0.0;
      } else {
         double numreturn = 0.0;
         if ((entity instanceof SegmentedBodyEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SegmentedBodyEntity.DATA_segmentnum_arphex) : 0) > 11) {
            if ((entity instanceof SegmentedBodyEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SegmentedBodyEntity.DATA_segmentnum_arphex) : 0)
               == 15) {
               numreturn = 1.6;
            } else if ((
                  entity instanceof SegmentedBodyEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SegmentedBodyEntity.DATA_segmentnum_arphex) : 0
               )
               == 14) {
               numreturn = 2.0;
            } else if ((
                  entity instanceof SegmentedBodyEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SegmentedBodyEntity.DATA_segmentnum_arphex) : 0
               )
               == 13) {
               numreturn = 2.5;
            } else {
               numreturn = 2.8;
            }
         } else {
            numreturn = 3.0;
         }

         return numreturn;
      }
   }
}
