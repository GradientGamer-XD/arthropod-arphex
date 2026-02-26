package net.arphex.procedures;

import net.arphex.entity.TormentorVoidlasherSummonEntity;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class DraconFireProjectileHitsLivingEntityProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_PURPLE_SMOKE.get(), x, y, z, 5, 0.6, 0.6, 0.6, 0.5);
         }

         if (entity != sourceentity) {
            if (sourceentity instanceof TormentorVoidlasherSummonEntity) {
               entity.hurt(
                  new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), sourceentity),
                  (float)Math.round((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 20.0F)
               );
               entity.setDeltaMovement(new Vec3(0.0, -5.0, 0.0));
            }

            if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 60, 9, false, false));
               }
            } else if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.VOIDLASHER_CHAOS_CONTROL.get(), 180, 0, false, false));
            }
         }
      }
   }
}
