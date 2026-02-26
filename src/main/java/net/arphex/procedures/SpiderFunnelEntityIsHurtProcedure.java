package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class SpiderFunnelEntityIsHurtProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         entity.setDeltaMovement(new Vec3(Mth.nextDouble(RandomSource.create(), -0.3, 0.3), -2.0, Mth.nextDouble(RandomSource.create(), -0.3, 0.3)));
         ArphexMod.queueServerWork(
            1,
            () -> {
               entity.setDeltaMovement(new Vec3(Mth.nextDouble(RandomSource.create(), -0.3, 0.3), -2.0, Mth.nextDouble(RandomSource.create(), -0.3, 0.3)));
               ArphexMod.queueServerWork(
                  1,
                  () -> entity.setDeltaMovement(
                        new Vec3(Mth.nextDouble(RandomSource.create(), -0.3, 0.3), -2.0, Mth.nextDouble(RandomSource.create(), -0.3, 0.3))
                     )
               );
            }
         );
      }
   }
}
