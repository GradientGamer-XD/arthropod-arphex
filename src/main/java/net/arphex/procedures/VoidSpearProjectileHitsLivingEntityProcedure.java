package net.arphex.procedures;

import net.arphex.entity.TormentorVoidlasherSummonEntity;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class VoidSpearProjectileHitsLivingEntityProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
      if (entity != null && immediatesourceentity != null && sourceentity != null) {
         if (!entity.getPersistentData().getBoolean("creativespectator") && !entity.isInvulnerable()) {
            if (entity instanceof TormentorVoidlasherSummonEntity) {
               entity.hurt(
                  new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC), sourceentity),
                  (entity instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F) / 18.0F
                     + 5.0F
                     - (float)((entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) / 5)
                     + 10.0F
               );
            } else {
               entity.hurt(
                  new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC), sourceentity),
                  (float)(5 - (entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) / 5 + 10)
               );
            }
         }

         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.SOLID_SMOKE.get(), x, y, z, 1, 0.0, 0.0, 0.0, 0.0);
         }

         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 20, 0.3, 0.3, 0.2, 0.6);
         }

         if (!immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }
      }
   }
}
