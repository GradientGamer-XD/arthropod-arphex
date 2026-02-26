package net.arphex.procedures;

import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;

public class JudgementBlastProjectileHitsLivingEntityProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world instanceof ServerLevel _level) {
         _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARRED_BLOOD.get(), x, y, z, 30, 0.3, 0.3, 0.3, 0.5);
      }
   }
}
