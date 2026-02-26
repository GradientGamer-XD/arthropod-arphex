package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AbyssExplosiveProjectileHitsBlockProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      boolean found = false;
      double randomxside = 0.0;
      double expand = 0.0;
      double lineZ = 0.0;
      double yhalf = 0.0;
      double sx = 0.0;
      double lineY = 0.0;
      double sy = 0.0;
      double lineX = 0.0;
      double randomzside = 0.0;
      double sz = 0.0;
      Vec3 _center = new Vec3(x, y, z);

      for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3.0), e -> true)
         .stream()
         .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
         .toList()) {
         if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) >= 1) {
            entityiterator.hurt(
               new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)),
               (float)(15 / (((entityiterator instanceof LivingEntity _livEntx ? _livEntx.getArmorValue() : 0) + 9) / 10))
            );
         } else {
            entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 10.0F);
         }
      }

      if ((Boolean)ConfigurationSettingsConfiguration.ARPHEX_ITEM_GRIEFING.get() && world instanceof Level _level && !_level.isClientSide()) {
         _level.explode(null, x, y, z, 1.0F, ExplosionInteraction.TNT);
      }

      if (world instanceof ServerLevel _level) {
         _level.sendParticles(ParticleTypes.FIREWORK, x, y, z, 2, 0.3, 0.3, 0.3, 0.5);
      }

      if (world instanceof ServerLevel _level) {
         _level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x, y, z, 2, 0.3, 0.3, 0.3, 0.5);
      }

      ArphexMod.queueServerWork(10, () -> {
         if ((Boolean)ConfigurationSettingsConfiguration.ARPHEX_ITEM_GRIEFING.get() && world instanceof Level _levelxxx && !_levelxxx.isClientSide()) {
            _levelxxx.explode(null, x, y, z, 6.0F, ExplosionInteraction.TNT);
         }

         if (world instanceof ServerLevel _levelxx) {
            _levelxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 40, 0.5, 0.5, 0.5, 0.4);
         }

         if (world instanceof ServerLevel _levelx) {
            _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.SOLID_SMOKE.get(), x, y, z, 5, 0.3, 0.3, 0.3, 0.1);
         }
      });
   }
}
