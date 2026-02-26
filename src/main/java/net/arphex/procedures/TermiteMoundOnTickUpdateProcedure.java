package net.arphex.procedures;

import net.arphex.init.ArphexModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TermiteMoundOnTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (!world.isClientSide()) {
         if (Mth.nextInt(RandomSource.create(), 1, 4) == 2) {
            if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()
               && Mth.nextInt(RandomSource.create(), 1, 30) == 5
               && world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z))) {
               if (world instanceof ServerLevel _level) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.RANDOM_TERMITE.get())
                     .spawn(_level, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               if (Mth.nextInt(RandomSource.create(), 1, 4) == 5) {
                  world.setBlock(BlockPos.containing(x, y, z), Blocks.ROOTED_DIRT.defaultBlockState(), 3);
               }
            }
         } else if (Mth.nextInt(RandomSource.create(), 1, 40) == 5 && world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z))) {
            if (world instanceof ServerLevel _levelx) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.RANDOM_TERMITE.get())
                  .spawn(_levelx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
               }
            }

            if (Mth.nextInt(RandomSource.create(), 1, 4) == 4) {
               world.setBlock(BlockPos.containing(x, y, z), Blocks.ROOTED_DIRT.defaultBlockState(), 3);
            }
         }
      }
   }
}
