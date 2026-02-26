package net.arphex.procedures;

import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class StaffOfVitalityToolInHandTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!(entity.getPersistentData().getDouble("autoheal") > 0.0)) {
            label31: {
               if (entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(MobEffects.REGENERATION)) {
                  break label31;
               }

               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 0, false, false));
               }

               if (world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.GOLDEN_OPAL.get(), x, y, z, 5, 0.2, 0.2, 0.2, 0.2);
               }
            }

            entity.getPersistentData().putDouble("autoheal", 150.0);
         } else {
            entity.getPersistentData().putDouble("autoheal", entity.getPersistentData().getDouble("autoheal") - 1.0);
         }
      }
   }
}
