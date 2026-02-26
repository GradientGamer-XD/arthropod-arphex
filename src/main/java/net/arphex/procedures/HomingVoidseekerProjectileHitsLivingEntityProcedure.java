package net.arphex.procedures;

import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.ParticleTypes;
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

public class HomingVoidseekerProjectileHitsLivingEntityProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
      if (entity != null && immediatesourceentity != null && sourceentity != null) {
         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_PURPLE_SMOKE.get(), x, y, z, 5, 0.6, 0.6, 0.6, 0.5);
         }

         if (world instanceof ServerLevel _level) {
            _level.sendParticles(ParticleTypes.EXPLOSION, x, y, z, 5, 0.3, 0.3, 0.3, 0.5);
         }

         entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
         if (!immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }

         if ((entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) + 1 > 8) {
            entity.hurt(
               new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.ARROW), sourceentity),
               (float)Math.round((float)(40 / (((entity instanceof LivingEntity _livEntx ? _livEntx.getArmorValue() : 0) + 1) / 8)))
            );
         } else {
            entity.hurt(
               new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.ARROW), sourceentity), 40.0F
            );
         }
      }
   }
}
