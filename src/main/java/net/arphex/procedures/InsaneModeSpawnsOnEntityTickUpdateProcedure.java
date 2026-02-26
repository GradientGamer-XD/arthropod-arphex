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

public class InsaneModeSpawnsOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity.isInWall()) {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         } else if (!entity.getPersistentData().getBoolean("insane_done_spawn")) {
            entity.getPersistentData().putBoolean("insane_done_spawn", true);
            if (Mth.nextInt(RandomSource.create(), 1, 2) == 2 && world instanceof ServerLevel _level) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.RANDOM_AR_PH_EX.get())
                  .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(Mth.nextDouble(RandomSource.create(), -0.1, 0.1), 0.0, Mth.nextDouble(RandomSource.create(), -0.1, 0.1));
               }
            }

            if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
               if (world instanceof ServerLevel _levelx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.RANDOM_AR_PH_EX.get())
                     .spawn(_levelx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(Mth.nextDouble(RandomSource.create(), -0.1, 0.1), 0.0, Mth.nextDouble(RandomSource.create(), -0.1, 0.1));
                  }
               }

               if (Mth.nextInt(RandomSource.create(), 1, 200) == 2 && world instanceof ServerLevel _levelxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_GOLIATH.get())
                     .spawn(_levelxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(Mth.nextDouble(RandomSource.create(), -0.1, 0.1), 0.0, Mth.nextDouble(RandomSource.create(), -0.1, 0.1));
                  }
               }
            }

            if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
               if (Mth.nextInt(RandomSource.create(), 1, 200) == 2 && world instanceof ServerLevel _levelxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.CRAWLING_RANDOM.get())
                     .spawn(_levelxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(Mth.nextDouble(RandomSource.create(), -0.1, 0.1), 0.0, Mth.nextDouble(RandomSource.create(), -0.1, 0.1));
                  }
               }
            } else if (Mth.nextInt(RandomSource.create(), 1, 4) == 2) {
               if (Mth.nextInt(RandomSource.create(), 1, 200) == 2 && world instanceof ServerLevel _levelxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_PROWLER.get())
                     .spawn(_levelxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(Mth.nextDouble(RandomSource.create(), -0.1, 0.1), 0.0, Mth.nextDouble(RandomSource.create(), -0.1, 0.1));
                  }
               }
            } else if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
               if (Mth.nextInt(RandomSource.create(), 1, 200) == 2 && world instanceof ServerLevel _levelxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.CENTIPEDE_EVICTOR.get())
                     .spawn(_levelxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(Mth.nextDouble(RandomSource.create(), -0.1, 0.1), 0.0, Mth.nextDouble(RandomSource.create(), -0.1, 0.1));
                  }
               }
            } else if (Mth.nextInt(RandomSource.create(), 1, 20) == 2) {
               if (Mth.nextInt(RandomSource.create(), 1, 5) == 2) {
                  if (world instanceof ServerLevel _levelxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.MANTIS_MUTILATOR.get())
                        .spawn(_levelxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(Mth.nextDouble(RandomSource.create(), -0.1, 0.1), 0.0, Mth.nextDouble(RandomSource.create(), -0.1, 0.1));
                     }
                  }
               } else if (Mth.nextInt(RandomSource.create(), 1, 4) == 2) {
                  if (world instanceof ServerLevel _levelxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.ARTHROPLEURA_ABOMINATION.get())
                        .spawn(_levelxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(Mth.nextDouble(RandomSource.create(), -0.1, 0.1), 0.0, Mth.nextDouble(RandomSource.create(), -0.1, 0.1));
                     }
                  }
               } else if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
                  if (world instanceof ServerLevel _levelxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_INFESTOR.get())
                        .spawn(_levelxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(Mth.nextDouble(RandomSource.create(), -0.1, 0.1), 0.0, Mth.nextDouble(RandomSource.create(), -0.1, 0.1));
                     }
                  }
               } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                  if (world instanceof ServerLevel _levelxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_AMBUSHER.get())
                        .spawn(_levelxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(Mth.nextDouble(RandomSource.create(), -0.1, 0.1), 0.0, Mth.nextDouble(RandomSource.create(), -0.1, 0.1));
                     }
                  }
               } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_MATRIARCH.get())
                        .spawn(_levelxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(Mth.nextDouble(RandomSource.create(), -0.1, 0.1), 0.0, Mth.nextDouble(RandomSource.create(), -0.1, 0.1));
                     }
                  }
               } else if (world instanceof ServerLevel _levelxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.WASP_NEMESIS.get())
                     .spawn(_levelxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(Mth.nextDouble(RandomSource.create(), -0.1, 0.1), 0.0, Mth.nextDouble(RandomSource.create(), -0.1, 0.1));
                  }
               }
            }
         } else if (!entity.level().isClientSide()) {
            entity.discard();
         }
      }
   }
}
