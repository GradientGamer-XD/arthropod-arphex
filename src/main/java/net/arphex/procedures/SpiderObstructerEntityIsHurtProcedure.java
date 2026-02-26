package net.arphex.procedures;

import net.arphex.entity.SpiderObstructerEntity;
import net.minecraft.world.entity.Entity;

public class SpiderObstructerEntityIsHurtProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity instanceof SpiderObstructerEntity _datEntSetI) {
            _datEntSetI.getEntityData().set(SpiderObstructerEntity.DATA_cooldown, 1200);
         }
      }
   }
}
