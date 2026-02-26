package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ChronoSpearShotWhileProjectileFlyingTickProcedure {
   public static void execute(LevelAccessor world, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         if (world instanceof ServerLevel _level) {
            _level.sendParticles(
               (SimpleParticleType)ArphexModParticleTypes.SMALL_TIME.get(),
               immediatesourceentity.getX(),
               immediatesourceentity.getY(),
               immediatesourceentity.getZ(),
               1,
               3.0,
               3.0,
               3.0,
               1.0
            );
         }

         immediatesourceentity.setNoGravity(true);
         ArphexMod.queueServerWork(20, () -> {
            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }
         });
      }
   }
}
