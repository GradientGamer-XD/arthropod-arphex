package net.arphex.procedures;

import net.arphex.entity.SpiderAmbusherEntity;
import net.minecraft.world.entity.Entity;

public class SpiderAmbusherEntityIsHurtProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity instanceof SpiderAmbusherEntity _datEntSetI) {
            _datEntSetI.getEntityData().set(SpiderAmbusherEntity.DATA_time_in_air, 0);
         }
      }
   }
}
