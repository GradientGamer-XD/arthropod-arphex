package net.arphex.procedures;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class VitalityArmourChestplateTickEventProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (!(entity.getPersistentData().getDouble("vitalchesttick") > 0.0)) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 610, 2, false, false));
            }

            entity.getPersistentData().putDouble("vitalchesttick", 600.0);
         } else {
            entity.getPersistentData().putDouble("vitalchesttick", entity.getPersistentData().getDouble("vitalchesttick") - 1.0);
         }
      }
   }
}
