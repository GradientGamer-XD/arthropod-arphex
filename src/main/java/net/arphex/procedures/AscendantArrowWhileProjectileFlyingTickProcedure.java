package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class AscendantArrowWhileProjectileFlyingTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         immediatesourceentity.setNoGravity(true);
         ArphexMod.queueServerWork(60, () -> {
            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }
         });
         if (world instanceof ServerLevel _level) {
            _level.sendParticles(ParticleTypes.SWEEP_ATTACK, x, y - 0.3, z, 1, 0.0, 0.0, 0.0, 0.0);
         }
      }
   }
}
