package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.entity.SpiderProwlerEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class SpiderProwlerEntityIsHurtProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity instanceof SpiderProwlerEntity _datEntSetI) {
            _datEntSetI.getEntityData().set(SpiderProwlerEntity.DATA_ontheprowl, 1200);
         }

         if (Mth.nextInt(RandomSource.create(), 1, 10) == 2) {
            entity.setDeltaMovement(
               new Vec3(
                  Math.cos((double)(entity.getYRot() + (float)Mth.nextInt(RandomSource.create(), 0, 90)) * (Math.PI / 180.0)) / 2.0,
                  1.3,
                  Math.sin((double)(entity.getYRot() + (float)Mth.nextInt(RandomSource.create(), 0, 90)) * (Math.PI / 180.0)) / 2.0
               )
            );
         } else if (!world.isEmptyBlock(BlockPos.containing(x, y + 2.0, z)) || !world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z))) {
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
}
