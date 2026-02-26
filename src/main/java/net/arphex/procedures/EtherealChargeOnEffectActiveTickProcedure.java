package net.arphex.procedures;

import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class EtherealChargeOnEffectActiveTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double particleRadius = 0.0;
         double particleAmount = 0.0;
         if (world instanceof ServerLevel _level) {
            _level.sendParticles(
               (SimpleParticleType)ArphexModParticleTypes.GHOST_TELEPORT.get(),
               entity.getPersistentData().getDouble("ethportalx"),
               entity.getPersistentData().getDouble("ethportaly") + 1.0,
               entity.getPersistentData().getDouble("ethportalz"),
               2,
               0.1,
               0.1,
               0.1,
               0.0
            );
         }

         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.GHOST_TELEPORT.get(), x, y, z, 3, 0.2, 0.2, 0.2, 0.1);
         }
      }
   }
}
