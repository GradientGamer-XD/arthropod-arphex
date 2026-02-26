package net.arphex.procedures;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class ProwlMoveProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean glowup = false;
         if (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
            return _livEnt.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getAmplifier() != 20;
         }

         return 0 != 20;
      }
   }
}
