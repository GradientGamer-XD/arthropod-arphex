package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.init.ArphexModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;

public class SpiderBroodEntityDiesProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world instanceof ServerLevel _level) {
         Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE_TINY.get()).spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
         if (entityToSpawn != null) {
            entityToSpawn.setDeltaMovement(0.3, 0.0, 0.0);
         }
      }

      if (world instanceof ServerLevel _levelx) {
         Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE_TINY.get())
            .spawn(_levelx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
         if (entityToSpawn != null) {
            entityToSpawn.setDeltaMovement(-0.3, 0.0, 0.0);
         }
      }

      if (world instanceof ServerLevel _levelxx) {
         Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE_TINY.get())
            .spawn(_levelxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
         if (entityToSpawn != null) {
            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.3);
         }
      }

      if (world instanceof ServerLevel _levelxxx) {
         Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE_TINY.get())
            .spawn(_levelxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
         if (entityToSpawn != null) {
            entityToSpawn.setDeltaMovement(0.0, 0.0, -0.3);
         }
      }

      if (world instanceof ServerLevel _levelxxxx) {
         Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE_TINY.get())
            .spawn(_levelxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
         if (entityToSpawn != null) {
            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
         }
      }

      ArphexMod.queueServerWork(
         5,
         () -> {
            if (world instanceof ServerLevel _levelxxxxx) {
               Entity entityToSpawnxxxxx = ((EntityType)ArphexModEntities.SPIDER_LARVAE_TINY.get())
                  .spawn(_levelxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawnxxxxx != null) {
                  entityToSpawnxxxxx.setDeltaMovement(0.1, 0.0, 0.0);
               }
            }

            if (world instanceof ServerLevel _levelxxxxxx) {
               Entity entityToSpawnxxxx = ((EntityType)ArphexModEntities.SPIDER_LARVAE_TINY.get())
                  .spawn(_levelxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawnxxxx != null) {
                  entityToSpawnxxxx.setDeltaMovement(-0.1, 0.0, 0.0);
               }
            }

            if (world instanceof ServerLevel _levelxxxxxxx) {
               Entity entityToSpawnxxx = ((EntityType)ArphexModEntities.SPIDER_LARVAE_TINY.get())
                  .spawn(_levelxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawnxxx != null) {
                  entityToSpawnxxx.setDeltaMovement(0.0, 0.0, 0.1);
               }
            }

            if (world instanceof ServerLevel _levelxxxxxxxx) {
               Entity entityToSpawnxx = ((EntityType)ArphexModEntities.SPIDER_LARVAE_TINY.get())
                  .spawn(_levelxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawnxx != null) {
                  entityToSpawnxx.setDeltaMovement(0.0, 0.0, -0.1);
               }
            }

            if (world instanceof ServerLevel _levelxxxxxxxxx) {
               Entity entityToSpawnx = ((EntityType)ArphexModEntities.SPIDER_LARVAE_TINY.get())
                  .spawn(_levelxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawnx != null) {
                  entityToSpawnx.setDeltaMovement(0.0, 0.1, 0.0);
               }
            }
         }
      );
   }
}
