package net.arphex.procedures;

import net.arphex.entity.SpiderMothDwellerEntity;
import net.minecraft.world.entity.Entity;

public class VoidlasherHurtProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity instanceof SpiderMothDwellerEntity _datEntSetL) {
            _datEntSetL.getEntityData().set(SpiderMothDwellerEntity.DATA_primed, true);
         }
      }
   }
}
