package net.arphex.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;

public class MangledSpiderFleshUpdateTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world instanceof ServerLevel _level) {
         _level.sendParticles(ParticleTypes.CRIMSON_SPORE, x, y, z, 1, 2.0, 2.0, 2.0, 0.0);
      }
   }
}
