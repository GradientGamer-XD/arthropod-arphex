package net.arphex.procedures;

import net.arphex.entity.TormentorScorpioidSummonEntity;
import net.minecraft.world.entity.Entity;

public class GoToTormentorProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         if (entity instanceof TormentorScorpioidSummonEntity _datEntL0
            && (Boolean)_datEntL0.getEntityData().get(TormentorScorpioidSummonEntity.DATA_flee_mode)) {
            return false;
         }

         return true;
      }
   }
}
