package net.arphex.procedures;

import net.arphex.init.ArphexModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class TimeFreezeEffectExpiresProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         int var10000;
         label19: {
            if (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect((MobEffect)ArphexModMobEffects.TIME_FREEZE.get())) {
               var10000 = _livEnt.getEffect((MobEffect)ArphexModMobEffects.TIME_FREEZE.get()).getAmplifier();
               break label19;
            }

            var10000 = 0;
         }

         if (var10000 < 1) {
            entity.getPersistentData().putDouble("back_time_x_vx", 0.0);
            entity.getPersistentData().putDouble("back_time_y_vx", 0.0);
            entity.getPersistentData().putDouble("back_time_z_vx", 0.0);
         }
      }
   }
}
