package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class ParalysisOnEffectActiveTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double amplifier) {
      if (entity != null) {
         double particleRadius = 0.0;
         double particleAmount = 0.0;
         if (!(entity.getPersistentData().getDouble("paralysis_speed") > 0.0)) {
            entity.getPersistentData().putDouble("paralysis_speed", Math.max(10.0 - amplifier, 0.0));
            entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x() * 0.6, entity.getDeltaMovement().y(), entity.getDeltaMovement().z() * 0.6));
            if (!(entity.getDeltaMovement().y() < -0.2)) {
               entity.setDeltaMovement(
                  new Vec3(entity.getDeltaMovement().x() * 0.3, entity.getDeltaMovement().y() * 0.3 - 0.1, entity.getDeltaMovement().z() * 0.3)
               );
            }

            if (amplifier > 9.0) {
               entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x() * 0.05, entity.getDeltaMovement().y(), entity.getDeltaMovement().z() * 0.05));
            }

            ArphexMod.queueServerWork(
               (int)(entity.getPersistentData().getDouble("paralysis_speed") / 2.0),
               () -> {
                  entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x() * 0.3, entity.getDeltaMovement().y(), entity.getDeltaMovement().z() * 0.3));
                  if (!(entity.getDeltaMovement().y() < -0.2)) {
                     entity.setDeltaMovement(
                        new Vec3(entity.getDeltaMovement().x() * 0.3, entity.getDeltaMovement().y() * 0.3 - 0.1, entity.getDeltaMovement().z() * 0.3)
                     );
                  }
               }
            );
         } else {
            entity.getPersistentData().putDouble("paralysis_speed", entity.getPersistentData().getDouble("paralysis_speed") - 1.0);
         }

         particleAmount = Math.min(20.0, amplifier * 2.0);
         particleRadius = 2.0;

         for (int index0 = 0; index0 < (int)particleAmount; index0++) {
            world.addParticle(
               (SimpleParticleType)ArphexModParticleTypes.CHARRED_BLOOD.get(),
               x + 0.0 + Mth.nextDouble(RandomSource.create(), -1.0, 1.0) * particleRadius,
               y + 0.0 + Mth.nextDouble(RandomSource.create(), -1.0, 1.0) * particleRadius,
               z + 0.0 + Mth.nextDouble(RandomSource.create(), -1.0, 1.0) * particleRadius,
               Mth.nextDouble(RandomSource.create(), -0.001, 0.001),
               Mth.nextDouble(RandomSource.create(), -0.001, 0.001),
               Mth.nextDouble(RandomSource.create(), -0.001, 0.001)
            );
         }
      }
   }
}
