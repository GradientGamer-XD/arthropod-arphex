package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class InfiniteTormentItemInHandTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double partilim = 0.0;
         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 5, 255, false, false));
         }

         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5, 4, false, false));
         }

         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get(), 5, 0, false, false));
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect((MobEffect)ArphexModMobEffects.NECROSIS.get());
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect(MobEffects.WITHER);
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect(MobEffects.POISON);
         }

         partilim = 20.0;
         if ((entity instanceof LivingEntity _entUseTicks6 ? _entUseTicks6.getTicksUsingItem() : 0) > 0) {
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiterator instanceof LivingEntity && !(entityiterator instanceof ArmorStand)) {
                  entityiterator.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                  if (entityiterator != entity) {
                     entityiterator.hurt(
                        new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)),
                        (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 3.0F
                     );
                     entityiterator.hurt(
                        new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)),
                        (entityiterator instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F) / 3.0F
                     );
                  }

                  if (partilim > 0.0) {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles(
                           (SimpleParticleType)ArphexModParticleTypes.HEAVY_GOLD_SMOKE.get(),
                           entityiterator.getX(),
                           entityiterator.getY(),
                           entityiterator.getZ(),
                           5,
                           0.0,
                           0.0,
                           0.0,
                           0.3
                        );
                     }

                     partilim--;
                  }
               }
            }
         }
      }
   }
}
