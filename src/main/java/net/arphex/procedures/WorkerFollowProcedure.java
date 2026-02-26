package net.arphex.procedures;

import net.arphex.entity.AntArsonistWorkerEntity;
import net.minecraft.world.entity.Entity;

public class WorkerFollowProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         if (entity instanceof AntArsonistWorkerEntity _datEntL0 && (Boolean)_datEntL0.getEntityData().get(AntArsonistWorkerEntity.DATA_following)) {
            return true;
         }

         return false;
      }
   }
}
