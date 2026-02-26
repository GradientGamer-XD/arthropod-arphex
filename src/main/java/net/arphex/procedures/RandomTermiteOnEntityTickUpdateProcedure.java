package net.arphex.procedures;

import net.arphex.init.ArphexModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;

public class RandomTermiteOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!entity.getPersistentData().getBoolean("done")) {
            entity.getPersistentData().putBoolean("done", true);
            if (!entity.level().isClientSide()) {
               entity.discard();
            }

            if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
               if (world instanceof ServerLevel _level) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.TERMITE_TUNNELER_WORKER.get())
                     .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }
            } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2
               && world.isEmptyBlock(BlockPos.containing(x + 1.0, y, z))
               && world.isEmptyBlock(BlockPos.containing(x + 1.0, y, z + 1.0))
               && world.isEmptyBlock(BlockPos.containing(x, y, z + 1.0))) {
               if (world instanceof ServerLevel _levelx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.TERMITE_TUNNELER_SOLDIER.get())
                     .spawn(_levelx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }
            } else if (world instanceof ServerLevel _levelxx) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.TERMITE_TUNNELER_ALATE.get())
                  .spawn(_levelxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
               }
            }
         }
      }
   }
}
