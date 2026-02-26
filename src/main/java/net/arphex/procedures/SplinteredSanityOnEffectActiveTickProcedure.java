package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class SplinteredSanityOnEffectActiveTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         int var10000;
         label32: {
            if (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
               var10000 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
               break label32;
            }

            var10000 = 0;
         }

         if (var10000 == 3 && world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.ETERNAL_FLAME.get(), x, y, z, 3, 0.4, 0.4, 0.4, 0.4);
         }

         if (!(entity.getPersistentData().getDouble("splintered_saturation") > 0.0)) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 1, 0, false, false));
            }

            entity.getPersistentData().putDouble("splintered_saturation", 200.0);
         } else {
            entity.getPersistentData().putDouble("splintered_saturation", entity.getPersistentData().getDouble("splintered_saturation") - 1.0);
         }

         ArphexMod.queueServerWork(2, () -> {
            if (entity.isAlive()) {
               if (entity instanceof LivingEntity _entityx && !_entityx.level().isClientSide()) {
                  _entityx.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.SPLINTERED_SANITY.get(), 99999, 0, false, false));
               }
            } else {
               ArphexMod.queueServerWork(2, () -> {
                  if (entity.isAlive() && entity instanceof LivingEntity _entityxx && !_entityxx.level().isClientSide()) {
                     _entityxx.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.SPLINTERED_SANITY.get(), 99999, 0, false, false));
                  }
               });
            }
         });
      }
   }
}
