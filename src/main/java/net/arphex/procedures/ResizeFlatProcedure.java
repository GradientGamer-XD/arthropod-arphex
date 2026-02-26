package net.arphex.procedures;

import net.arphex.entity.SpiderFlatEntity;
import net.minecraft.world.entity.Entity;

public class ResizeFlatProcedure {
   public static double execute(Entity entity) {
      if (entity == null) {
         return 0.0;
      } else {
         return (entity instanceof SpiderFlatEntity _datEntI ? _datEntI.getEntityData().get(SpiderFlatEntity.DATA_patreon_reskin) : 0) == 2 ? 3.0 : 2.0;
      }
   }
}
