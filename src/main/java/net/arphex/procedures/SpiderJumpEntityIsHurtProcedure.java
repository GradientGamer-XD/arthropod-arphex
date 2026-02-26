package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class SpiderJumpEntityIsHurtProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!world.isEmptyBlock(BlockPos.containing(x, y + 2.0, z)) || !world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z))) {
            entity.setDeltaMovement(
               new Vec3(
                  Math.cos((double)(entity.getYRot() + (float)Mth.nextInt(RandomSource.create(), 0, 90)) * (Math.PI / 180.0)) / 2.0,
                  -2.0,
                  Math.sin((double)(entity.getYRot() + (float)Mth.nextInt(RandomSource.create(), 0, 90)) * (Math.PI / 180.0)) / 2.0
               )
            );
            ArphexMod.queueServerWork(
               1,
               () -> {
                  entity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(entity.getYRot() + (float)Mth.nextInt(RandomSource.create(), 0, 90)) * (Math.PI / 180.0)) / 2.0,
                        -2.0,
                        Math.sin((double)(entity.getYRot() + (float)Mth.nextInt(RandomSource.create(), 0, 90)) * (Math.PI / 180.0)) / 2.0
                     )
                  );
                  ArphexMod.queueServerWork(
                     1,
                     () -> entity.setDeltaMovement(
                           new Vec3(
                              Math.cos((double)(entity.getYRot() + (float)Mth.nextInt(RandomSource.create(), 0, 90)) * (Math.PI / 180.0)) / 2.0,
                              -2.0,
                              Math.sin((double)(entity.getYRot() + (float)Mth.nextInt(RandomSource.create(), 0, 90)) * (Math.PI / 180.0)) / 2.0
                           )
                        )
                  );
               }
            );
         }
      }
   }
}
