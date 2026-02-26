package net.arphex.procedures;

import net.arphex.init.ArphexModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class EternalSustenanceTickProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.SPLINTERED_SANITY.get(), 99999, 0, false, false));
         }

         if (!(entity.getPersistentData().getDouble("slow_saturation_repeat") > 0.0)) {
            entity.getPersistentData().putDouble("slow_saturation_repeat", 200.0);
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 1, 0, false, false));
            }
         } else {
            entity.getPersistentData().putDouble("slow_saturation_repeat", entity.getPersistentData().getDouble("slow_saturation_repeat") - 1.0);
         }
      }
   }
}
