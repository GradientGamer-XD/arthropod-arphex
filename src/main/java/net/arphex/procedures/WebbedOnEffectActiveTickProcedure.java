package net.arphex.procedures;

import net.arphex.entity.FlyFestererEntity;
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
import net.minecraft.world.phys.Vec3;

public class WebbedOnEffectActiveTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         int var10000;
         label147: {
            if (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect((MobEffect)ArphexModMobEffects.WEBBED.get())) {
               var10000 = _livEnt.getEffect((MobEffect)ArphexModMobEffects.WEBBED.get()).getAmplifier();
               break label147;
            }

            var10000 = 0;
         }

         if (var10000 == 0) {
            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.THIN_WEB.get(), x, y, z, 10, 0.8, 0.8, 0.8, 0.0);
            }

            if (!entity.getPersistentData().getBoolean("spidertype") && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 1, true, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 3, 1, true, false));
            }
         }

         label141: {
            if (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect((MobEffect)ArphexModMobEffects.WEBBED.get())) {
               var10000 = _livEnt.getEffect((MobEffect)ArphexModMobEffects.WEBBED.get()).getAmplifier();
               break label141;
            }

            var10000 = 0;
         }

         if (var10000 == 1) {
            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.THIN_WEB.get(), x, y, z, 20, 0.8, 0.8, 0.8, 0.0);
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 2, true, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 3, 2, true, false));
            }
         }

         label135: {
            if (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect((MobEffect)ArphexModMobEffects.WEBBED.get())) {
               var10000 = _livEnt.getEffect((MobEffect)ArphexModMobEffects.WEBBED.get()).getAmplifier();
               break label135;
            }

            var10000 = 0;
         }

         if (var10000 == 2) {
            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.THIN_WEB.get(), x, y, z, 30, 0.8, 0.8, 0.8, 0.0);
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 3, true, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 3, 3, true, false));
            }
         }

         label129: {
            if (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect((MobEffect)ArphexModMobEffects.WEBBED.get())) {
               var10000 = _livEnt.getEffect((MobEffect)ArphexModMobEffects.WEBBED.get()).getAmplifier();
               break label129;
            }

            var10000 = 0;
         }

         if (var10000 == 3) {
            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.THIN_WEB.get(), x, y, z, 50, 0.8, 0.8, 0.8, 0.0);
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 4, true, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 3, 4, true, false));
            }
         }

         label123: {
            if (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect((MobEffect)ArphexModMobEffects.WEBBED.get())) {
               var10000 = _livEnt.getEffect((MobEffect)ArphexModMobEffects.WEBBED.get()).getAmplifier();
               break label123;
            }

            var10000 = 0;
         }

         if (var10000 >= 4) {
            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.THIN_WEB.get(), x, y, z, 60, 0.6, 0.6, 0.6, 0.0);
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 5, true, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 3, 5, true, false));
            }
         }

         if (entity instanceof FlyFestererEntity) {
            entity.setDeltaMovement(new Vec3(0.0, -0.2, 0.0));
         }
      }
   }
}
