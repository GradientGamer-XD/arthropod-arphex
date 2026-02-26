package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.init.ArphexModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;

public class RandomCrawlingSpawnsProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean found = false;
         double randomxside = 0.0;
         double expand = 0.0;
         double lineZ = 0.0;
         double yhalf = 0.0;
         double sx = 0.0;
         double lineY = 0.0;
         double sy = 0.0;
         double lineX = 0.0;
         double randomzside = 0.0;
         double sz = 0.0;
         ArphexMod.queueServerWork(3, () -> {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         });
         entity.getPersistentData().putDouble("randomchoice", (double)Mth.nextInt(RandomSource.create(), 1, 10));
         if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("arphex:crawling_canopy"))) {
            if (entity.getY() > 230.0) {
               if (entity.getPersistentData().getDouble("randomchoice") == 1.0) {
                  if (world instanceof ServerLevel _level) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.TERMITE_TUNNELER_WORKER.get())
                        .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 2.0) {
                  if (world instanceof ServerLevel _levelx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_RECLUSE.get())
                        .spawn(_levelx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 3.0) {
                  if (world instanceof ServerLevel _levelxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.BUTTERFLY_BEWITCHER_GIANT.get())
                        .spawn(_levelxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 4.0) {
                  for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 1, 3); index0++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.MOTH_MOONTRACKER.get())
                           .spawn(_levelxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 5.0) {
                  if (world instanceof ServerLevel _levelxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.MOTH_MOONTRACKER.get())
                        .spawn(_levelxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 6.0) {
                  for (int index1 = 0; index1 < Mth.nextInt(RandomSource.create(), 1, 3); index1++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.SILVERFISH_SPECTRE.get())
                           .spawn(_levelxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 7.0) {
                  if (world instanceof ServerLevel _levelxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_JUMP.get())
                        .spawn(_levelxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 8.0) {
                  if (world instanceof ServerLevel _levelxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE.get())
                        .spawn(_levelxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 9.0) {
                  for (int index2 = 0; index2 < Mth.nextInt(RandomSource.create(), 1, 3); index2++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.ROACH_RIVERSPAWN.get())
                           .spawn(_levelxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                  if (world instanceof ServerLevel _levelxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.ANT_ARSONIST.get())
                        .spawn(_levelxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (world instanceof ServerLevel _levelxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.VENUS_FLYTRAP.get())
                     .spawn(_levelxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               entity.getPersistentData().putBoolean("done", true);
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (entity.getY() > 120.0) {
               if (entity.getPersistentData().getDouble("randomchoice") == 1.0) {
                  for (int index3 = 0; index3 < Mth.nextInt(RandomSource.create(), 1, 3); index3++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.BUTTERFLY_BEWITCHER.get())
                           .spawn(_levelxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 2.0) {
                  for (int index4 = 0; index4 < Mth.nextInt(RandomSource.create(), 1, 3); index4++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.LONG_LEGS_FLY.get())
                           .spawn(_levelxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 3.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.MOTH_MOONTRACKER.get())
                        .spawn(_levelxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 4.0) {
                  for (int index5 = 0; index5 < Mth.nextInt(RandomSource.create(), 1, 3); index5++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.MOSQUITO_MORBIDITY.get())
                           .spawn(_levelxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 5.0) {
                  if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
                     if (world instanceof ServerLevel _levelxxxxxxxxx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.MANTIS_MUTILATOR.get())
                           .spawn(_levelxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  } else if (Mth.nextInt(RandomSource.create(), 1, 20) == 1) {
                     TrySectorProcedure.execute(world, x, y, z);
                  } else if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.DRAGONFLY_DREADNOUGHT.get())
                        .spawn(_levelxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 6.0) {
                  for (int index6 = 0; index6 < Mth.nextInt(RandomSource.create(), 1, 3); index6++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.BEETLE_BULWARK.get())
                           .spawn(_levelxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 7.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.CENTIPEDE_STALKER.get())
                        .spawn(_levelxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 8.0) {
                  for (int index7 = 0; index7 < Mth.nextInt(RandomSource.create(), 1, 3); index7++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.CENTIPEDE_EVICTOR_LARVAE.get())
                           .spawn(_levelxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 9.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_PROWLER.get())
                        .spawn(_levelxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.MILLIPEDE_MARAUDER.get())
                        .spawn(_levelxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.VENUS_FLYTRAP.get())
                     .spawn(_levelxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               entity.getPersistentData().putBoolean("done", true);
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (entity.getY() > 55.0) {
               if (entity.getPersistentData().getDouble("randomchoice") == 1.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SOLIFUGE_SKULKER.get())
                        .spawn(_levelxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 2.0) {
                  if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                     if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_PROWLER.get())
                           .spawn(_levelxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.VENUS_FLYTRAP.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 3.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.BEETLE_BULWARK.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 4.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_FUNNEL.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 5.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_GOLIATH.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 6.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.MILLIPEDE_MARAUDER.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 7.0) {
                  for (int index8 = 0; index8 < Mth.nextInt(RandomSource.create(), 1, 3); index8++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPION_STRIKER.get())
                           .spawn(_levelxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 8.0) {
                  for (int index9 = 0; index9 < Mth.nextInt(RandomSource.create(), 1, 3); index9++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_BROOD.get())
                           .spawn(_levelxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 9.0) {
                  if (Mth.nextInt(RandomSource.create(), 1, 3) == 2 && world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.WASP_NEMESIS.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.MANTIS_MUTILATOR.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               entity.getPersistentData().putBoolean("done", true);
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
               if (entity.getPersistentData().getDouble("randomchoice") == 1.0) {
                  for (int index10 = 0; index10 < Mth.nextInt(RandomSource.create(), 1, 2); index10++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.CENTIPEDE_EVICTOR.get())
                           .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               } else if ((Boolean)ConfigurationSettingsConfiguration.SPAWN_DWELLERS_NATURALLY.get()) {
                  if (entity.getPersistentData().getDouble("randomchoice") == 2.0) {
                     if (Mth.nextInt(RandomSource.create(), 1, 6) == 2) {
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxx) {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_MOTH.get())
                              .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (Mth.nextInt(RandomSource.create(), 1, 5) == 2) {
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxx) {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.MOTH_SHADOW_CLONE.get())
                              .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (Mth.nextInt(RandomSource.create(), 1, 4) == 2) {
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.INVISIBLE_STALKER.get())
                              .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
                        if (!world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("dripstone_caves"))
                           && !world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("lush_caves"))) {
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                              Entity entityToSpawn = ((EntityType)ArphexModEntities.RUSH_SCARE.get())
                                 .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                              if (entityToSpawn != null) {
                                 entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                              }
                           }
                        } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.DWELLER_SLEEP_SPAWNER.get())
                              .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.PURE_STALKING.get())
                              .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.SKY_STALKER.get())
                           .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  } else if (entity.getPersistentData().getDouble("randomchoice") == 3.0) {
                     if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPIOID_INITIAL.get())
                              .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPIOID_CHASER_HALLUCINATION.get())
                              .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPIOID_SHADOW_CLONE.get())
                           .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  } else if (entity.getPersistentData().getDouble("randomchoice") == 4.0) {
                     if (Mth.nextInt(RandomSource.create(), 1, 5) == 2) {
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
                           && world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.DRACONIC_VOIDLASHER.get())
                              .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.VOIDLASHER_SHADOW_CLONE.get())
                              .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (Mth.nextInt(RandomSource.create(), 1, 10) == 2) {
                        if (Mth.nextInt(RandomSource.create(), 1, 5) == 2) {
                           TryAbolosProcedure.execute(world, x, y, z);
                        } else {
                           TrySectorProcedure.execute(world, x, y, z);
                        }
                     } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.DRACONIC_FLY_STALK.get())
                           .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               }

               entity.getPersistentData().putBoolean("done", true);
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else {
               if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.WASP_NEMESIS.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.MANTIS_MUTILATOR.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               entity.getPersistentData().putBoolean("done", true);
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            }
         } else if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("arphex:cryptic_complex"))) {
            if (entity.getY() > 230.0) {
               if (entity.getPersistentData().getDouble("randomchoice") == 1.0) {
                  for (int index11 = 0; index11 < Mth.nextInt(RandomSource.create(), 1, 3); index11++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.LONG_LEGS.get())
                           .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 2.0) {
                  for (int index12 = 0; index12 < Mth.nextInt(RandomSource.create(), 1, 3); index12++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.LONG_LEGS_FLY.get())
                           .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 3.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.MOTH_MOONTRACKER.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 4.0) {
                  for (int index13 = 0; index13 < Mth.nextInt(RandomSource.create(), 1, 3); index13++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.MOSQUITO_MORBIDITY.get())
                           .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 5.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.MOSQUITO_MORBIDITY.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 6.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.MOTH_MOONTRACKER.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 7.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.ROACH_RIVERSPAWN.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 8.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 9.0) {
                  for (int index14 = 0; index14 < Mth.nextInt(RandomSource.create(), 1, 3); index14++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.BEETLE_TICK_MITE.get())
                           .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.ROACH_RIVERSPAWN.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               entity.getPersistentData().putBoolean("done", true);
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (entity.getY() > 120.0) {
               if (entity.getPersistentData().getDouble("randomchoice") == 1.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.LONG_LEGS_FLY.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 2.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.LONG_LEGS_FLY.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 3.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.MOTH_MOONTRACKER.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 4.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.MOSQUITO_MORBIDITY.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 5.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_FUNNEL.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 6.0) {
                  if (Mth.nextInt(RandomSource.create(), 1, 20) == 2) {
                     TrySectorProcedure.execute(world, x, y, z);
                  } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.BEETLE_BULWARK.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 7.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.BUTTERFLY_BEWITCHER_GIANT.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 8.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 9.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.ARTHROPLEURA_ABOMINATION.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else {
                  for (int index15 = 0; index15 < Mth.nextInt(RandomSource.create(), 1, 3); index15++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.ROACH_RIVERSPAWN.get())
                           .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               }

               entity.getPersistentData().putBoolean("done", true);
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (entity.getY() > 55.0) {
               if (entity.getPersistentData().getDouble("randomchoice") == 1.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SOLIFUGE_SKULKER.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 2.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.LONG_LEGS_FLY.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 3.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.BEETLE_BULWARK.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 4.0) {
                  if (Mth.nextInt(RandomSource.create(), 1, 20) == 2) {
                     TryAbolosProcedure.execute(world, x, y, z);
                  } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_FUNNEL.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 5.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.DRAGONFLY_DREADNOUGHT.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 6.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.BEETLE_BULWARK.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 7.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_GOLIATH.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 8.0) {
                  for (int index16 = 0; index16 < Mth.nextInt(RandomSource.create(), 1, 3); index16++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE.get())
                           .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 9.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.ARTHROPLEURA_ABOMINATION.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else {
                  for (int index17 = 0; index17 < Mth.nextInt(RandomSource.create(), 1, 3); index17++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.ROACH_RIVERSPAWN.get())
                           .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               }

               entity.getPersistentData().putBoolean("done", true);
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (Mth.nextInt(RandomSource.create(), 1, 3) == 3) {
               if (entity.getPersistentData().getDouble("randomchoice") == 1.0) {
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
                     && world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.CRAB_CONSTRICTOR.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if ((Boolean)ConfigurationSettingsConfiguration.SPAWN_DWELLERS_NATURALLY.get()) {
                  if (entity.getPersistentData().getDouble("randomchoice") == 2.0) {
                     if (Mth.nextInt(RandomSource.create(), 1, 6) == 2) {
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_MOTH.get())
                              .spawn(
                                 _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED
                              );
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (Mth.nextInt(RandomSource.create(), 1, 5) == 2) {
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.MOTH_SHADOW_CLONE.get())
                              .spawn(
                                 _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 BlockPos.containing(x, y, z),
                                 MobSpawnType.MOB_SUMMONED
                              );
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (Mth.nextInt(RandomSource.create(), 1, 4) == 2) {
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.INVISIBLE_STALKER.get())
                              .spawn(
                                 _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 BlockPos.containing(x, y, z),
                                 MobSpawnType.MOB_SUMMONED
                              );
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
                        if (!world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("dripstone_caves"))
                           && !world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("lush_caves"))) {
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                              Entity entityToSpawn = ((EntityType)ArphexModEntities.RUSH_SCARE.get())
                                 .spawn(
                                    _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                    BlockPos.containing(x, y, z),
                                    MobSpawnType.MOB_SUMMONED
                                 );
                              if (entityToSpawn != null) {
                                 entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                              }
                           }
                        } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.DWELLER_SLEEP_SPAWNER.get())
                              .spawn(
                                 _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 BlockPos.containing(x, y, z),
                                 MobSpawnType.MOB_SUMMONED
                              );
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.PURE_STALKING.get())
                              .spawn(
                                 _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 BlockPos.containing(x, y, z),
                                 MobSpawnType.MOB_SUMMONED
                              );
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.SKY_STALKER.get())
                           .spawn(
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              BlockPos.containing(x, y, z),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  } else if (entity.getPersistentData().getDouble("randomchoice") == 3.0) {
                     if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPIOID_INITIAL.get())
                              .spawn(
                                 _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 BlockPos.containing(x, y, z),
                                 MobSpawnType.MOB_SUMMONED
                              );
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPIOID_CHASER_HALLUCINATION.get())
                              .spawn(
                                 _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 BlockPos.containing(x, y, z),
                                 MobSpawnType.MOB_SUMMONED
                              );
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPIOID_SHADOW_CLONE.get())
                           .spawn(
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              BlockPos.containing(x, y, z),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  } else if (entity.getPersistentData().getDouble("randomchoice") == 4.0) {
                     if (Mth.nextInt(RandomSource.create(), 1, 5) == 2) {
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
                           && world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.DRACONIC_VOIDLASHER.get())
                              .spawn(
                                 _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 BlockPos.containing(x, y, z),
                                 MobSpawnType.MOB_SUMMONED
                              );
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.VOIDLASHER_SHADOW_CLONE.get())
                              .spawn(
                                 _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 BlockPos.containing(x, y, z),
                                 MobSpawnType.MOB_SUMMONED
                              );
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (Mth.nextInt(RandomSource.create(), 1, 10) == 2) {
                        if (Mth.nextInt(RandomSource.create(), 1, 5) == 2) {
                           TryAbolosProcedure.execute(world, x, y, z);
                        } else {
                           TrySectorProcedure.execute(world, x, y, z);
                        }
                     } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.DRACONIC_FLY_STALK.get())
                           .spawn(
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              BlockPos.containing(x, y, z),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               }

               entity.getPersistentData().putBoolean("done", true);
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else {
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.ARTHROPLEURA_ABOMINATION.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               entity.getPersistentData().putBoolean("done", true);
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            }
         } else if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("arphex:decadent_desert"))) {
            if (entity.getY() > 230.0) {
               if (entity.getPersistentData().getDouble("randomchoice") == 1.0) {
                  for (int index18 = 0; index18 < Mth.nextInt(RandomSource.create(), 1, 3); index18++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.TERMITE_TUNNELER_WORKER.get())
                           .spawn(
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              BlockPos.containing(x, y, z),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 2.0) {
                  for (int index19 = 0; index19 < Mth.nextInt(RandomSource.create(), 1, 3); index19++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.ANT_ARSONIST.get())
                           .spawn(
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              BlockPos.containing(x, y, z),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 3.0) {
                  for (int index20 = 0; index20 < Mth.nextInt(RandomSource.create(), 1, 3); index20++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.LOCUST_LANDSCOURGE.get())
                           .spawn(
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              BlockPos.containing(x, y, z),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 4.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_FLAT.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 5.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.MOSQUITO_MORBIDITY.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 6.0) {
                  for (int index21 = 0; index21 < Mth.nextInt(RandomSource.create(), 1, 3); index21++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPION_LARVAE.get())
                           .spawn(
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              BlockPos.containing(x, y, z),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 7.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.ROACH_RIVERSPAWN.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 8.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.LOCUST_LANDSCOURGE.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 9.0) {
                  for (int index22 = 0; index22 < Mth.nextInt(RandomSource.create(), 1, 3); index22++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.BEETLE_TICK_MITE.get())
                           .spawn(
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              BlockPos.containing(x, y, z),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.FLY_FESTERER.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               entity.getPersistentData().putBoolean("done", true);
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (entity.getY() > 120.0) {
               if (entity.getPersistentData().getDouble("randomchoice") == 1.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.MILLIPEDE_MARAUDER.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 2.0) {
                  for (int index23 = 0; index23 < Mth.nextInt(RandomSource.create(), 1, 3); index23++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.MOSQUITO_MORBIDITY.get())
                           .spawn(
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              BlockPos.containing(x, y, z),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 3.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.LOCUST_LANDSCOURGE.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 4.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.BEETLE_BULWARK.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 5.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SOLIFUGE_SKULKER.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 6.0) {
                  for (int index24 = 0; index24 < Mth.nextInt(RandomSource.create(), 1, 3); index24++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPION_STRIKER.get())
                           .spawn(
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              BlockPos.containing(x, y, z),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 7.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPION_STRIKER.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 8.0) {
                  if (Mth.nextInt(RandomSource.create(), 1, 20) == 2) {
                     TrySectorProcedure.execute(world, x, y, z);
                  } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_FLAT.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 9.0) {
                  for (int index25 = 0; index25 < Mth.nextInt(RandomSource.create(), 1, 3); index25++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.HORNET_HARBINGER.get())
                           .spawn(
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              BlockPos.containing(x, y, z),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPION_LARVAE.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               entity.getPersistentData().putBoolean("done", true);
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (entity.getY() > 55.0) {
               if (entity.getPersistentData().getDouble("randomchoice") == 1.0) {
                  if (Mth.nextInt(RandomSource.create(), 1, 6) == 2
                     && world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_INFESTOR.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 2.0) {
                  for (int index26 = 0; index26 < Mth.nextInt(RandomSource.create(), 1, 3); index26++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPION_STRIKER.get())
                           .spawn(
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              BlockPos.containing(x, y, z),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 3.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SOLIFUGE_SKULKER.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 4.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.ANT_ARSONIST.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 5.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPION_STRIKER.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 6.0) {
                  if (Mth.nextInt(RandomSource.create(), 1, 20) == 1) {
                     TryAbolosProcedure.execute(world, x, y, z);
                  } else {
                     for (int index27 = 0; index27 < Mth.nextInt(RandomSource.create(), 1, 3); index27++) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.TERMITE_TUNNELER_WORKER.get())
                              .spawn(
                                 _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 BlockPos.containing(x, y, z),
                                 MobSpawnType.MOB_SUMMONED
                              );
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 7.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SOLIFUGE_SKULKER.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 8.0) {
                  for (int index28 = 0; index28 < Mth.nextInt(RandomSource.create(), 1, 3); index28++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.BEETLE_BULWARK.get())
                           .spawn(
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              BlockPos.containing(x, y, z),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 9.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.ROACH_RIVERSPAWN.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.MOSQUITO_MORBIDITY.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               entity.getPersistentData().putBoolean("done", true);
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (Mth.nextInt(RandomSource.create(), 1, 3) == 3) {
               if (entity.getPersistentData().getDouble("randomchoice") == 1.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_INFESTOR.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if ((Boolean)ConfigurationSettingsConfiguration.SPAWN_DWELLERS_NATURALLY.get()) {
                  if (entity.getPersistentData().getDouble("randomchoice") == 2.0) {
                     if (Mth.nextInt(RandomSource.create(), 1, 6) == 2) {
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           )
                         {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_MOTH.get())
                              .spawn(
                                 _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 BlockPos.containing(x, y, z),
                                 MobSpawnType.MOB_SUMMONED
                              );
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (Mth.nextInt(RandomSource.create(), 1, 5) == 2) {
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           )
                         {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.MOTH_SHADOW_CLONE.get())
                              .spawn(
                                 _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 BlockPos.containing(x, y, z),
                                 MobSpawnType.MOB_SUMMONED
                              );
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (Mth.nextInt(RandomSource.create(), 1, 4) == 2) {
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           )
                         {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.INVISIBLE_STALKER.get())
                              .spawn(
                                 _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 BlockPos.containing(x, y, z),
                                 MobSpawnType.MOB_SUMMONED
                              );
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
                        if (!world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("dripstone_caves"))
                           && !world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("lush_caves"))) {
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                              )
                            {
                              Entity entityToSpawn = ((EntityType)ArphexModEntities.RUSH_SCARE.get())
                                 .spawn(
                                    _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                    BlockPos.containing(x, y, z),
                                    MobSpawnType.MOB_SUMMONED
                                 );
                              if (entityToSpawn != null) {
                                 entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                              }
                           }
                        } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           )
                         {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.DWELLER_SLEEP_SPAWNER.get())
                              .spawn(
                                 _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 BlockPos.containing(x, y, z),
                                 MobSpawnType.MOB_SUMMONED
                              );
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           )
                         {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.PURE_STALKING.get())
                              .spawn(
                                 _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 BlockPos.containing(x, y, z),
                                 MobSpawnType.MOB_SUMMONED
                              );
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                        )
                      {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.SKY_STALKER.get())
                           .spawn(
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              BlockPos.containing(x, y, z),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  } else if (entity.getPersistentData().getDouble("randomchoice") == 3.0) {
                     if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           )
                         {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPIOID_INITIAL.get())
                              .spawn(
                                 _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 BlockPos.containing(x, y, z),
                                 MobSpawnType.MOB_SUMMONED
                              );
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           )
                         {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPIOID_CHASER_HALLUCINATION.get())
                              .spawn(
                                 _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 BlockPos.containing(x, y, z),
                                 MobSpawnType.MOB_SUMMONED
                              );
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                        )
                      {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPIOID_SHADOW_CLONE.get())
                           .spawn(
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              BlockPos.containing(x, y, z),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  } else if (entity.getPersistentData().getDouble("randomchoice") == 4.0) {
                     if (Mth.nextInt(RandomSource.create(), 1, 4) == 2) {
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
                           && world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           )
                         {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.DRACONIC_VOIDLASHER.get())
                              .spawn(
                                 _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 BlockPos.containing(x, y, z),
                                 MobSpawnType.MOB_SUMMONED
                              );
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           )
                         {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.VOIDLASHER_SHADOW_CLONE.get())
                              .spawn(
                                 _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 BlockPos.containing(x, y, z),
                                 MobSpawnType.MOB_SUMMONED
                              );
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (Mth.nextInt(RandomSource.create(), 1, 10) == 2) {
                        if (Mth.nextInt(RandomSource.create(), 1, 5) == 2) {
                           TryAbolosProcedure.execute(world, x, y, z);
                        } else {
                           TrySectorProcedure.execute(world, x, y, z);
                        }
                     } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                        )
                      {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.DRACONIC_FLY_STALK.get())
                           .spawn(
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              BlockPos.containing(x, y, z),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               }

               entity.getPersistentData().putBoolean("done", true);
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else {
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                  )
                {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SOLIFUGE_SKULKER.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               entity.getPersistentData().putBoolean("done", true);
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            }
         } else if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("arphex:tormented_tunnels"))) {
            if (entity.getY() > 230.0) {
               if (entity.getPersistentData().getDouble("randomchoice") == 1.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                     )
                   {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_RECLUSE.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 2.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                     )
                   {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.ANT_ARSONIST.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 3.0) {
                  for (int index29 = 0; index29 < Mth.nextInt(RandomSource.create(), 1, 3); index29++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.BUTTERFLY_BEWITCHER.get())
                           .spawn(
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              BlockPos.containing(x, y, z),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 4.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                     )
                   {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.BEETLE_BULWARK.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 5.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                     )
                   {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.BEETLE_BULWARK.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 6.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                     )
                   {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.CENTIPEDE_EVICTOR.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 7.0) {
                  for (int index30 = 0; index30 < Mth.nextInt(RandomSource.create(), 1, 5); index30++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.MAGGOT_LARVAE.get())
                           .spawn(
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              BlockPos.containing(x, y, z),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 8.0) {
                  for (int index31 = 0; index31 < Mth.nextInt(RandomSource.create(), 1, 3); index31++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.ROACH_RIVERSPAWN.get())
                           .spawn(
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              BlockPos.containing(x, y, z),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 9.0) {
                  for (int index32 = 0; index32 < Mth.nextInt(RandomSource.create(), 1, 3); index32++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.LONG_LEGS.get())
                           .spawn(
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              BlockPos.containing(x, y, z),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                  )
                {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPION_LARVAE.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               entity.getPersistentData().putBoolean("done", true);
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (entity.getY() > 120.0) {
               if (entity.getPersistentData().getDouble("randomchoice") == 1.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                     )
                   {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.MILLIPEDE_MARAUDER.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 2.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                     )
                   {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.MILLIPEDE_MARAUDER.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 3.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                     )
                   {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.FLY_FESTERER.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 4.0) {
                  for (int index33 = 0; index33 < Mth.nextInt(RandomSource.create(), 1, 3); index33++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.CENTIPEDE_STALKER.get())
                           .spawn(
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              BlockPos.containing(x, y, z),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 5.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                     )
                   {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_FUNNEL.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 6.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                     )
                   {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 7.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                     )
                   {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.ROACH_RIVERSPAWN.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 8.0) {
                  if (Mth.nextInt(RandomSource.create(), 1, 20) == 2) {
                     TrySectorProcedure.execute(world, x, y, z);
                  } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                     )
                   {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SILVERFISH_SPECTRE.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 9.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                     )
                   {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.HORNET_HARBINGER_GIANT.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                  )
                {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.BEETLE_BULWARK.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               entity.getPersistentData().putBoolean("done", true);
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (entity.getY() > 60.0) {
               if (entity.getPersistentData().getDouble("randomchoice") == 1.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                     )
                   {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_FUNNEL.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 2.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                     )
                   {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPION_STRIKER.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 3.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                     )
                   {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_PROWLER.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 4.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                     )
                   {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.HORNET_HARBINGER_GIANT.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 5.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                     )
                   {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_BROOD.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 6.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                     )
                   {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.RANDOM_TERMITE.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 7.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                     )
                   {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.BEETLE_BULWARK.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 8.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                     )
                   {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_FLAT.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 9.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                     )
                   {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_REAPER.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                  )
                {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.MOSQUITO_MORBIDITY.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               entity.getPersistentData().putBoolean("done", true);
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
               if (entity.getPersistentData().getDouble("randomchoice") == 1.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                     )
                   {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_PROWLER.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if ((Boolean)ConfigurationSettingsConfiguration.SPAWN_DWELLERS_NATURALLY.get()) {
                  if (entity.getPersistentData().getDouble("randomchoice") == 2.0) {
                     if (Mth.nextInt(RandomSource.create(), 1, 6) == 2) {
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           )
                         {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_MOTH.get())
                              .spawn(
                                 _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 BlockPos.containing(x, y, z),
                                 MobSpawnType.MOB_SUMMONED
                              );
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (Mth.nextInt(RandomSource.create(), 1, 5) == 2) {
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           )
                         {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.MOTH_SHADOW_CLONE.get())
                              .spawn(
                                 _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 BlockPos.containing(x, y, z),
                                 MobSpawnType.MOB_SUMMONED
                              );
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (Mth.nextInt(RandomSource.create(), 1, 4) == 2) {
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           )
                         {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.INVISIBLE_STALKER.get())
                              .spawn(
                                 _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 BlockPos.containing(x, y, z),
                                 MobSpawnType.MOB_SUMMONED
                              );
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
                        if (!world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("dripstone_caves"))
                           && !world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("lush_caves"))) {
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                              )
                            {
                              Entity entityToSpawn = ((EntityType)ArphexModEntities.RUSH_SCARE.get())
                                 .spawn(
                                    _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                    BlockPos.containing(x, y, z),
                                    MobSpawnType.MOB_SUMMONED
                                 );
                              if (entityToSpawn != null) {
                                 entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                              }
                           }
                        } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           )
                         {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.DWELLER_SLEEP_SPAWNER.get())
                              .spawn(
                                 _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 BlockPos.containing(x, y, z),
                                 MobSpawnType.MOB_SUMMONED
                              );
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           )
                         {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.PURE_STALKING.get())
                              .spawn(
                                 _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 BlockPos.containing(x, y, z),
                                 MobSpawnType.MOB_SUMMONED
                              );
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                        )
                      {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.SKY_STALKER.get())
                           .spawn(
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              BlockPos.containing(x, y, z),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  } else if (entity.getPersistentData().getDouble("randomchoice") == 3.0) {
                     if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           )
                         {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPIOID_INITIAL.get())
                              .spawn(
                                 _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 BlockPos.containing(x, y, z),
                                 MobSpawnType.MOB_SUMMONED
                              );
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           )
                         {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPIOID_CHASER_HALLUCINATION.get())
                              .spawn(
                                 _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 BlockPos.containing(x, y, z),
                                 MobSpawnType.MOB_SUMMONED
                              );
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                        )
                      {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPIOID_SHADOW_CLONE.get())
                           .spawn(
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              BlockPos.containing(x, y, z),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  } else if (entity.getPersistentData().getDouble("randomchoice") == 4.0) {
                     if (Mth.nextInt(RandomSource.create(), 1, 4) == 2) {
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
                           && world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           )
                         {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.DRACONIC_VOIDLASHER.get())
                              .spawn(
                                 _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 BlockPos.containing(x, y, z),
                                 MobSpawnType.MOB_SUMMONED
                              );
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           )
                         {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.VOIDLASHER_SHADOW_CLONE.get())
                              .spawn(
                                 _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 BlockPos.containing(x, y, z),
                                 MobSpawnType.MOB_SUMMONED
                              );
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (Mth.nextInt(RandomSource.create(), 1, 10) == 2) {
                        if (Mth.nextInt(RandomSource.create(), 1, 5) == 2) {
                           TryAbolosProcedure.execute(world, x, y, z);
                        } else {
                           TrySectorProcedure.execute(world, x, y, z);
                        }
                     } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                        )
                      {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.DRACONIC_FLY_STALK.get())
                           .spawn(
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              BlockPos.containing(x, y, z),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               }

               entity.getPersistentData().putBoolean("done", true);
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else {
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                  )
                {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPION_STRIKER.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               entity.getPersistentData().putBoolean("done", true);
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            }
         } else if (entity.getY() > 230.0
            && (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
               == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))) {
            if (entity.getPersistentData().getDouble("randomchoice") == 1.0) {
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                  )
                {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_FUNNEL.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 2.0) {
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                  )
                {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_FUNNEL.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 3.0) {
               for (int index34 = 0; index34 < Mth.nextInt(RandomSource.create(), 1, 3); index34++) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 4.0) {
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                  )
                {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_OBSTRUCTER.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 5.0) {
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                  )
                {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_BROOD.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 6.0) {
               if (Mth.nextInt(RandomSource.create(), 1, 2) == 2
                  && world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                  )
                {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_SNATCHER.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 7.0) {
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                  )
                {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_JUMP.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 8.0) {
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                  )
                {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_FLAT.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 9.0) {
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                  )
                {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }
            } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
               )
             {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.FLY_FESTERER.get())
                  .spawn(
                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                     BlockPos.containing(x, y, z),
                     MobSpawnType.MOB_SUMMONED
                  );
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
               }
            }

            entity.getPersistentData().putBoolean("done", true);
            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         } else if (entity.getY() > 120.0
            && (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
               == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))) {
            if (entity.getPersistentData().getDouble("randomchoice") == 1.0) {
               if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                     )
                   {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_FUNNEL.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                  )
                {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_RECLUSE.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 2.0) {
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                  )
                {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_PROWLER.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 3.0) {
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                  )
                {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_SNATCHER.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 4.0) {
               if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                     )
                   {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LUNGER.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else {
                  for (int index35 = 0; index35 < Mth.nextInt(RandomSource.create(), 1, 2); index35++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_BROOD.get())
                           .spawn(
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              BlockPos.containing(x, y, z),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 5.0) {
               if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                     )
                   {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_SINKER.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                  )
                {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_OBSTRUCTER.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 6.0) {
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                  )
                {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_GOLIATH.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 7.0) {
               if (Mth.nextInt(RandomSource.create(), 1, 20) == 2) {
                  TrySectorProcedure.execute(world, x, y, z);
               } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                  )
                {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_FUNNEL.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 8.0) {
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                  )
                {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_AMBUSHER.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 9.0) {
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                  )
                {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.FLY_FESTERER.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }
            } else {
               for (int index36 = 0; index36 < Mth.nextInt(RandomSource.create(), 1, 3); index36++) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.LONG_LEGS_FLY.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               }
            }

            entity.getPersistentData().putBoolean("done", true);
            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         } else if (entity.getY() > 60.0
            && (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
               == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))) {
            if (entity.getPersistentData().getDouble("randomchoice") == 1.0) {
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                  )
                {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_REAPER.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 2.0) {
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                  )
                {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_PROWLER.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 3.0) {
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                  )
                {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_SNATCHER.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 4.0) {
               if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                  if (Mth.nextInt(RandomSource.create(), 1, 20) == 2) {
                     TryAbolosProcedure.execute(world, x, y, z);
                  } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                     )
                   {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_FUNNEL.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                  )
                {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LUNGER.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 5.0) {
               if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                     )
                   {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_GOLIATH.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                     )
                   {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_MATRIARCH.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                  )
                {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_RECLUSE.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 6.0) {
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                  )
                {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_BROOD.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 7.0) {
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                  )
                {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_GOLIATH.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 8.0) {
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                  )
                {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_AMBUSHER.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 9.0) {
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                  )
                {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.LONG_LEGS_FLY.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }
            } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
               )
             {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.MOSQUITO_MORBIDITY.get())
                  .spawn(
                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                     BlockPos.containing(x, y, z),
                     MobSpawnType.MOB_SUMMONED
                  );
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
               }
            }

            entity.getPersistentData().putBoolean("done", true);
            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         } else if (Mth.nextInt(RandomSource.create(), 1, 5) == 2) {
            if (entity.getPersistentData().getDouble("randomchoice") == 1.0) {
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                  )
                {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_MATRIARCH.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }
            } else if ((Boolean)ConfigurationSettingsConfiguration.SPAWN_DWELLERS_NATURALLY.get()) {
               if (entity.getPersistentData().getDouble("randomchoice") == 2.0) {
                  if (Mth.nextInt(RandomSource.create(), 1, 6) == 2) {
                     if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                        )
                      {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_MOTH.get())
                           .spawn(
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              BlockPos.containing(x, y, z),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  } else if (Mth.nextInt(RandomSource.create(), 1, 5) == 2) {
                     if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                        )
                      {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.MOTH_SHADOW_CLONE.get())
                           .spawn(
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              BlockPos.containing(x, y, z),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  } else if (Mth.nextInt(RandomSource.create(), 1, 4) == 2) {
                     if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                        )
                      {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.INVISIBLE_STALKER.get())
                           .spawn(
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              BlockPos.containing(x, y, z),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  } else if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
                     if (!world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("dripstone_caves"))
                        && !world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("lush_caves"))) {
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           )
                         {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.RUSH_SCARE.get())
                              .spawn(
                                 _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                 BlockPos.containing(x, y, z),
                                 MobSpawnType.MOB_SUMMONED
                              );
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                        )
                      {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.DWELLER_SLEEP_SPAWNER.get())
                           .spawn(
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              BlockPos.containing(x, y, z),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                     if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                        )
                      {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.PURE_STALKING.get())
                           .spawn(
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              BlockPos.containing(x, y, z),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                     )
                   {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SKY_STALKER.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 3.0) {
                  if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
                     if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                        )
                      {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPIOID_INITIAL.get())
                           .spawn(
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              BlockPos.containing(x, y, z),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                     if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                        )
                      {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPIOID_CHASER_HALLUCINATION.get())
                           .spawn(
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              BlockPos.containing(x, y, z),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                     )
                   {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPIOID_SHADOW_CLONE.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("randomchoice") == 4.0) {
                  if (Mth.nextInt(RandomSource.create(), 1, 4) == 2) {
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
                        && world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                        )
                      {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.DRACONIC_VOIDLASHER.get())
                           .spawn(
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              BlockPos.containing(x, y, z),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                     if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                        )
                      {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.VOIDLASHER_SHADOW_CLONE.get())
                           .spawn(
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              BlockPos.containing(x, y, z),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  } else if (Mth.nextInt(RandomSource.create(), 1, 10) == 2) {
                     if (Mth.nextInt(RandomSource.create(), 1, 5) == 2) {
                        TryAbolosProcedure.execute(world, x, y, z);
                     } else {
                        TrySectorProcedure.execute(world, x, y, z);
                     }
                  } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                     )
                   {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.DRACONIC_FLY_STALK.get())
                        .spawn(
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           BlockPos.containing(x, y, z),
                           MobSpawnType.MOB_SUMMONED
                        );
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               }
            }

            entity.getPersistentData().putBoolean("done", true);
            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         } else {
            if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                  )
                {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_AMBUSHER.get())
                     .spawn(
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }
            } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
               )
             {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_REAPER.get())
                  .spawn(
                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                     BlockPos.containing(x, y, z),
                     MobSpawnType.MOB_SUMMONED
                  );
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
               }
            }

            entity.getPersistentData().putBoolean("done", true);
            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         }
      }
   }
}
