package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class SpiderBroodEntityIsHurtProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.THIN_WEB.get(), x, y, z, 30, 1.0, 1.0, 1.0, 0.5);
         }

         entity.setSprinting(true);
         ArphexMod.queueServerWork(20, () -> entity.setSprinting(false));
      }
   }
}
