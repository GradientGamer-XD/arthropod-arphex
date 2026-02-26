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

public class CrawlingCompostBlockDestroyedByPlayerProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (Mth.nextInt(RandomSource.create(), 1, 20) == 5) {
         if (Mth.nextInt(RandomSource.create(), 1, 5) == 2) {
            if (world instanceof ServerLevel _level) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE_TINY.get())
                  .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
               }
            }
         } else if (Mth.nextInt(RandomSource.create(), 1, 4) == 2) {
            if (world instanceof ServerLevel _levelx) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.BEETLE_TICK_MITE.get())
                  .spawn(_levelx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
               }
            }
         } else if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
            if (world instanceof ServerLevel _levelxx) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.BLOOD_WORM.get()).spawn(_levelxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
               }
            }
         } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
            if (world instanceof ServerLevel _levelxxx) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.LONG_LEGS_TINY.get())
                  .spawn(_levelxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
               }
            }
         } else if (world instanceof ServerLevel _levelxxxx) {
            Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPION_LARVAE.get())
               .spawn(_levelxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
            }
         }
      }
   }
}
