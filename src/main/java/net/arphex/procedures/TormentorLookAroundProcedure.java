package net.arphex.procedures;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class TormentorLookAroundProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MobEffects.BLINDNESS)) {
            return true;
         }

         return false;
      }
   }
}
