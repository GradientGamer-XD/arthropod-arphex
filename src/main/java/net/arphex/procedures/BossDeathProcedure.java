package net.arphex.procedures;

import net.arphex.entity.ScorpioidBloodlusterEntity;
import net.arphex.entity.SpiderMothEntity;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class BossDeathProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 10, 1.0, 1.0, 1.0, 0.5);
         }

         if (entity instanceof SpiderMothEntity) {
            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 10, 1.0, 1.0, 1.0, 0.5);
            }
         } else if (entity instanceof ScorpioidBloodlusterEntity) {
            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(), x, y, z, 10, 1.0, 1.0, 1.0, 0.5);
            }
         } else if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_PURPLE_SMOKE.get(), x, y, z, 10, 1.0, 1.0, 1.0, 0.5);
         }
      }
   }
}
