package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;

public class SpiderWidowEntityDiesProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world instanceof ServerLevel _level) {
         _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARRED_BLOOD.get(), x, y, z, 300, 1.0, 1.0, 1.0, 0.3);
      }

      ArphexMod.queueServerWork(5, () -> {
         if (world instanceof ServerLevel _levelx) {
            _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARRED_BLOOD.get(), x, y, z, 300, 1.0, 1.0, 1.0, 0.3);
         }
      });
   }
}
