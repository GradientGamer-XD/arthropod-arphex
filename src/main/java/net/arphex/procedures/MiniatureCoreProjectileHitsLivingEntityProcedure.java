package net.arphex.procedures;

import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

public class MiniatureCoreProjectileHitsLivingEntityProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
      if (entity != null && immediatesourceentity != null && sourceentity != null) {
         if (!immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }

         if (entity instanceof LivingEntity && sourceentity != entity) {
            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 20, 0.6, 0.7, 0.6, 0.5);
            }

            if ((float)(15 / (((entity instanceof LivingEntity _livEntx ? _livEntx.getArmorValue() : 0) + 4) / 4))
               > (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 100.0F) {
               entity.hurt(
                  new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_PROJECTILE), sourceentity),
                  (float)(15 / (((entity instanceof LivingEntity _livEntxx ? _livEntxx.getArmorValue() : 0) + 4) / 4))
               );
            } else {
               entity.hurt(
                  new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_PROJECTILE), sourceentity),
                  (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 100.0F
               );
            }

            entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
         }
      }
   }
}
