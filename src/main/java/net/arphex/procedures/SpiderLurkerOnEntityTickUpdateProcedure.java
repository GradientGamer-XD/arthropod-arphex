package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class SpiderLurkerOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (!entity.isInWater()) {
            ArphexMod.queueServerWork(100, () -> {
               if (entity.getPersistentData().getDouble("drowntime") == 10.0) {
                  entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 1.0F);
               }
            });
         }

         if (entity.getPersistentData().getDouble("drowntime") < 20.0) {
            entity.getPersistentData().putDouble("drowntime", entity.getPersistentData().getDouble("drowntime") + 1.0);
         } else {
            entity.getPersistentData().putDouble("drowntime", 1.0);
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect(MobEffects.POISON);
         }

         if ((!(entity instanceof LivingEntity _livEnt10) || !_livEnt10.hasEffect(MobEffects.REGENERATION))
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 0, false, false));
         }

         if (!entity.isInWater() && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 3, false, false));
         }
      }
   }
}
