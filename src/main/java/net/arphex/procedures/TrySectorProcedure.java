package net.arphex.procedures;

import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.ArachnoidTrisectorEntity;
import net.arphex.init.ArphexModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TrySectorProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if ((Boolean)ConfigurationSettingsConfiguration.SPAWN_DWELLERS_NATURALLY.get()) {
         if (Mth.nextInt(RandomSource.create(), 1, 4) == 2) {
            if (world.getEntitiesOfClass(ArachnoidTrisectorEntity.class, AABB.ofSize(new Vec3(x, y, z), 500.0, 500.0, 500.0), e -> true).isEmpty()) {
               if (world.isEmptyBlock(BlockPos.containing((double)Math.round(x), (double)(Math.round(y) + 2L), (double)Math.round(z)))
                  && world.isEmptyBlock(BlockPos.containing((double)Math.round(x), (double)(Math.round(y) + 3L), (double)Math.round(z)))
                  && world.isEmptyBlock(BlockPos.containing((double)(Math.round(x) - 1L), (double)(Math.round(y) + 2L), (double)Math.round(z)))
                  && world.isEmptyBlock(BlockPos.containing((double)(Math.round(x) - 1L), (double)(Math.round(y) + 3L), (double)Math.round(z)))
                  && world.isEmptyBlock(BlockPos.containing((double)(Math.round(x) + 1L), (double)(Math.round(y) + 2L), (double)Math.round(z)))
                  && world.isEmptyBlock(BlockPos.containing((double)(Math.round(x) + 1L), (double)(Math.round(y) + 3L), (double)Math.round(z)))
                  && world.isEmptyBlock(BlockPos.containing((double)(Math.round(x) + 1L), (double)(Math.round(y) + 2L), (double)(Math.round(z) + 1L)))
                  && world.isEmptyBlock(BlockPos.containing((double)(Math.round(x) + 1L), (double)(Math.round(y) + 3L), (double)(Math.round(z) + 1L)))
                  && world.isEmptyBlock(BlockPos.containing((double)Math.round(x), (double)(Math.round(y) + 2L), (double)(Math.round(z) + 1L)))
                  && world.isEmptyBlock(BlockPos.containing((double)Math.round(x), (double)(Math.round(y) + 3L), (double)(Math.round(z) + 1L)))
                  && world.isEmptyBlock(BlockPos.containing((double)Math.round(x), (double)(Math.round(y) + 2L), (double)(Math.round(z) - 1L)))
                  && world.isEmptyBlock(BlockPos.containing((double)Math.round(x), (double)(Math.round(y) + 3L), (double)(Math.round(z) - 1L)))
                  && world.isEmptyBlock(BlockPos.containing((double)(Math.round(x) - 1L), (double)(Math.round(y) + 2L), (double)(Math.round(z) - 1L)))
                  && world.isEmptyBlock(BlockPos.containing((double)(Math.round(x) - 1L), (double)(Math.round(y) + 3L), (double)(Math.round(z) - 1L)))
                  && world.isEmptyBlock(BlockPos.containing((double)(Math.round(x) - 1L), (double)(Math.round(y) + 2L), (double)(Math.round(z) + 1L)))
                  && world.isEmptyBlock(BlockPos.containing((double)(Math.round(x) - 1L), (double)(Math.round(y) + 3L), (double)(Math.round(z) + 1L)))
                  && world.isEmptyBlock(BlockPos.containing((double)(Math.round(x) + 1L), (double)(Math.round(y) + 2L), (double)(Math.round(z) - 1L)))
                  && world.isEmptyBlock(BlockPos.containing((double)(Math.round(x) + 1L), (double)(Math.round(y) + 3L), (double)(Math.round(z) - 1L)))
                  && world.isEmptyBlock(BlockPos.containing((double)Math.round(x), (double)(Math.round(y) + 4L), (double)Math.round(z)))
                  && world.isEmptyBlock(BlockPos.containing((double)Math.round(x), (double)(Math.round(y) + 5L), (double)Math.round(z)))
                  && world.isEmptyBlock(BlockPos.containing((double)(Math.round(x) - 1L), (double)(Math.round(y) + 4L), (double)Math.round(z)))
                  && world.isEmptyBlock(BlockPos.containing((double)(Math.round(x) - 1L), (double)(Math.round(y) + 5L), (double)Math.round(z)))
                  && world.isEmptyBlock(BlockPos.containing((double)(Math.round(x) + 1L), (double)(Math.round(y) + 4L), (double)Math.round(z)))
                  && world.isEmptyBlock(BlockPos.containing((double)(Math.round(x) + 1L), (double)(Math.round(y) + 5L), (double)Math.round(z)))
                  && world.isEmptyBlock(BlockPos.containing((double)(Math.round(x) + 1L), (double)(Math.round(y) + 4L), (double)(Math.round(z) + 1L)))
                  && world.isEmptyBlock(BlockPos.containing((double)(Math.round(x) + 1L), (double)(Math.round(y) + 5L), (double)(Math.round(z) + 1L)))
                  && world.isEmptyBlock(BlockPos.containing((double)Math.round(x), (double)(Math.round(y) + 4L), (double)(Math.round(z) + 1L)))
                  && world.isEmptyBlock(BlockPos.containing((double)Math.round(x), (double)(Math.round(y) + 5L), (double)(Math.round(z) + 1L)))
                  && world.isEmptyBlock(BlockPos.containing((double)Math.round(x), (double)(Math.round(y) + 4L), (double)(Math.round(z) - 1L)))
                  && world.isEmptyBlock(BlockPos.containing((double)Math.round(x), (double)(Math.round(y) + 5L), (double)(Math.round(z) - 1L)))
                  && world.isEmptyBlock(BlockPos.containing((double)(Math.round(x) - 1L), (double)(Math.round(y) + 4L), (double)(Math.round(z) - 1L)))
                  && world.isEmptyBlock(BlockPos.containing((double)(Math.round(x) - 1L), (double)(Math.round(y) + 5L), (double)(Math.round(z) - 1L)))
                  && world.isEmptyBlock(BlockPos.containing((double)(Math.round(x) - 1L), (double)(Math.round(y) + 4L), (double)(Math.round(z) + 1L)))
                  && world.isEmptyBlock(BlockPos.containing((double)(Math.round(x) - 1L), (double)(Math.round(y) + 5L), (double)(Math.round(z) + 1L)))
                  && world.isEmptyBlock(BlockPos.containing((double)(Math.round(x) + 1L), (double)(Math.round(y) + 4L), (double)(Math.round(z) - 1L)))
                  && world.isEmptyBlock(BlockPos.containing((double)(Math.round(x) + 1L), (double)(Math.round(y) + 5L), (double)(Math.round(z) - 1L)))
                  && world instanceof ServerLevel _level) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.ARACHNOID_TRISECTOR.get())
                     .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }
            } else if (world instanceof ServerLevel _levelx) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.ARACHNOID_SHADOW_CLONE.get())
                  .spawn(_levelx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
               }
            }
         } else if (world instanceof ServerLevel _levelxx) {
            Entity entityToSpawn = ((EntityType)ArphexModEntities.ARACHNOID_SHADOW_CLONE.get())
               .spawn(_levelxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
            }
         }
      }
   }
}
