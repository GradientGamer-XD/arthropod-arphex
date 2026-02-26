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
import net.minecraft.world.level.block.Blocks;

public class AntNestOnTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (!world.isClientSide() && Mth.nextInt(RandomSource.create(), 1, 10) == 5) {
         if (world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z))) {
            if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
               if (Mth.nextInt(RandomSource.create(), 1, 10) == 5) {
                  if (world instanceof ServerLevel _level) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.ANT_ARSONIST_ALATE_QUEEN.get())
                        .spawn(_level, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (world instanceof ServerLevel _levelx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.ANT_ARSONIST_WORKER.get())
                     .spawn(_levelx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }
            } else if (Mth.nextInt(RandomSource.create(), 1, 5) == 3) {
               if (world instanceof ServerLevel _levelxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.ANT_ARSONIST_DRONE.get())
                     .spawn(_levelxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }
            } else if (world instanceof ServerLevel _levelxxx) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.ANT_ARSONIST.get())
                  .spawn(_levelxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
               }
            }
         }

         world.setBlock(BlockPos.containing(x, y, z), Blocks.DIRT.defaultBlockState(), 3);
      }
   }
}
