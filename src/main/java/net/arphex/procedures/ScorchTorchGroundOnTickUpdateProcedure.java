package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;

public class ScorchTorchGroundOnTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
         if (world instanceof ServerLevel _level) {
            _level.sendParticles(ParticleTypes.SMOKE, x + 0.5, y + 0.5, z + 0.5, 1, 0.0, 0.0, 0.0, 0.05);
         }

         ArphexMod.queueServerWork(10, () -> {
            if (world instanceof ServerLevel _levelx) {
               _levelx.sendParticles(ParticleTypes.SMOKE, x + 0.5, y + 0.5, z + 0.5, 1, 0.0, 0.0, 0.0, 0.05);
            }
         });
      }

      if (Mth.nextInt(RandomSource.create(), 1, 10) == 1 && world instanceof ServerLevel _level) {
         _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.SCORCH_FLAME.get(), x + 0.5, y + 0.5, z + 0.5, 1, 0.0, 0.0, 0.0, 0.05);
      }
   }
}
