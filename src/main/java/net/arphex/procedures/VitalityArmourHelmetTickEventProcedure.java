package net.arphex.procedures;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class VitalityArmourHelmetTickEventProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect(MobEffects.CONFUSION);
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect(MobEffects.BLINDNESS);
         }
      }
   }
}
