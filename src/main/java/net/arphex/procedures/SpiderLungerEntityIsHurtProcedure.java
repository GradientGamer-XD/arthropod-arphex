package net.arphex.procedures;

import net.arphex.entity.SpiderLungerEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.TamableAnimal;

public class SpiderLungerEntityIsHurtProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if ((!(entity instanceof TamableAnimal _tamEnt) || !_tamEnt.isTame()) && entity instanceof SpiderLungerEntity _datEntSetI) {
            _datEntSetI.getEntityData().set(SpiderLungerEntity.DATA_attack_trigger_time, 1200);
         }
      }
   }
}
