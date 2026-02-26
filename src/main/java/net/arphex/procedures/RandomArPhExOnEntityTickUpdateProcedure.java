package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.SpiderMothEntity;
import net.arphex.init.ArphexModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class RandomArPhExOnEntityTickUpdateProcedure {
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
         entity.getPersistentData().putDouble("randomchoice", (double)Mth.nextInt(RandomSource.create(), 1, 35));
         if (entity.isInWall()) {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         } else if (!entity.getPersistentData().getBoolean("done")) {
            if (entity.getPersistentData().getDouble("randomchoice") == 1.0) {
               if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
                  entity.getPersistentData().putBoolean("done", true);
                  if (world instanceof ServerLevel _level) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_SNATCHER.get())
                        .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }

                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 2.0) {
               entity.getPersistentData().putBoolean("done", true);
               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 24.0, 24.0, 24.0), e -> true).isEmpty()) {
                  if (world instanceof ServerLevel _levelx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.ANT_ARSONIST.get())
                        .spawn(_levelx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else {
                  for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 1, 5); index0++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.ANT_ARSONIST.get())
                           .spawn(_levelxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(
                              Mth.nextDouble(RandomSource.create(), -0.5, 0.5), 0.0, Mth.nextDouble(RandomSource.create(), -0.5, 0.5)
                           );
                        }
                     }
                  }

                  ArphexMod.queueServerWork(
                     1,
                     () -> {
                        for (int index1 = 0; index1 < Mth.nextInt(RandomSource.create(), 1, 5); index1++) {
                           if (world instanceof ServerLevel) {
                              ServerLevel _levelxx = (ServerLevel)world;
                              Entity entityToSpawnx = ((EntityType)ArphexModEntities.ANT_ARSONIST.get())
                                 .spawn(_levelxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                              if (entityToSpawnx != null) {
                                 entityToSpawnx.setDeltaMovement(
                                    Mth.nextDouble(RandomSource.create(), -0.5, 0.5), 0.0, Mth.nextDouble(RandomSource.create(), -0.5, 0.5)
                                 );
                              }
                           }
                        }
                     }
                  );
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 3.0) {
               entity.getPersistentData().putBoolean("done", true);
               if (world instanceof ServerLevel _levelxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.BEETLE_BULWARK.get())
                     .spawn(_levelxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 4.0) {
               entity.getPersistentData().putBoolean("done", true);
               if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                  if (world instanceof ServerLevel _levelxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.BEETLE_TICK_MITE.get())
                        .spawn(_levelxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (world instanceof ServerLevel _levelxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_OBSTRUCTER.get())
                     .spawn(_levelxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 5.0) {
               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 24.0, 24.0, 24.0), e -> true).isEmpty()) {
                  if (world instanceof ServerLevel _levelxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.ROACH_RIVERSPAWN.get())
                        .spawn(_levelxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else {
                  for (int index2 = 0; index2 < Mth.nextInt(RandomSource.create(), 1, 5); index2++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.ROACH_RIVERSPAWN.get())
                           .spawn(_levelxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(
                              Mth.nextDouble(RandomSource.create(), -0.5, 0.5), 0.0, Mth.nextDouble(RandomSource.create(), -0.5, 0.5)
                           );
                        }
                     }
                  }

                  ArphexMod.queueServerWork(
                     1,
                     () -> {
                        for (int index3 = 0; index3 < Mth.nextInt(RandomSource.create(), 1, 5); index3++) {
                           if (world instanceof ServerLevel) {
                              ServerLevel _levelxxxxxx = (ServerLevel)world;
                              Entity entityToSpawnx = ((EntityType)ArphexModEntities.ROACH_RIVERSPAWN.get())
                                 .spawn(_levelxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                              if (entityToSpawnx != null) {
                                 entityToSpawnx.setDeltaMovement(
                                    Mth.nextDouble(RandomSource.create(), -0.5, 0.5), 0.0, Mth.nextDouble(RandomSource.create(), -0.5, 0.5)
                                 );
                              }
                           }
                        }
                     }
                  );
               }

               entity.getPersistentData().putBoolean("done", true);
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 6.0) {
               entity.getPersistentData().putBoolean("done", true);
               if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
                  if (world instanceof ServerLevel _levelxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.BUTTERFLY_BEWITCHER.get())
                        .spawn(_levelxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (world instanceof ServerLevel _levelxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_RECLUSE.get())
                     .spawn(_levelxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 7.0) {
               if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
                  entity.getPersistentData().putBoolean("done", true);
                  if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
                     if (world instanceof ServerLevel _levelxxxxxxxx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.BUTTERFLY_BEWITCHER_GIANT.get())
                           .spawn(_levelxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  } else if (Mth.nextInt(RandomSource.create(), 1, 8) == 2) {
                     if (world instanceof ServerLevel _levelxxxxxxxxx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LUNGER.get())
                           .spawn(_levelxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  } else {
                     if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_RECLUSE.get())
                           .spawn(_levelxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }

                     if (Mth.nextInt(RandomSource.create(), 1, 3) == 2 && world instanceof ServerLevel _levelxxxxxxxxxxx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_RECLUSE.get())
                           .spawn(_levelxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }

                     if (Mth.nextInt(RandomSource.create(), 1, 3) == 2 && world instanceof ServerLevel _levelxxxxxxxxxxxx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_RECLUSE.get())
                           .spawn(_levelxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  }

                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 8.0) {
               entity.getPersistentData().putBoolean("done", true);
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.CENTIPEDE_EVICTOR_LARVAE.get())
                     .spawn(_levelxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 9.0) {
               entity.getPersistentData().putBoolean("done", true);
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.CENTIPEDE_STALKER.get())
                     .spawn(_levelxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 10.0) {
               if (Mth.nextInt(RandomSource.create(), 1, 4) == 2) {
                  entity.getPersistentData().putBoolean("done", true);
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.ROACH_RIVERSPAWN.get())
                        .spawn(_levelxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }

                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 11.0) {
               entity.getPersistentData().putBoolean("done", true);
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.FLY_FESTERER.get())
                     .spawn(_levelxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 12.0) {
               entity.getPersistentData().putBoolean("done", true);
               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 24.0, 24.0, 24.0), e -> true).isEmpty()) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.HORNET_HARBINGER.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else {
                  for (int index4 = 0; index4 < Mth.nextInt(RandomSource.create(), 1, 4); index4++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.HORNET_HARBINGER.get())
                           .spawn(_levelxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(
                              Mth.nextDouble(RandomSource.create(), -0.5, 0.5), 0.0, Mth.nextDouble(RandomSource.create(), -0.5, 0.5)
                           );
                        }
                     }
                  }
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 13.0) {
               if (Mth.nextInt(RandomSource.create(), 1, 4) == 2) {
                  entity.getPersistentData().putBoolean("done", true);
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.HORNET_HARBINGER_GIANT.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }

                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 14.0) {
               entity.getPersistentData().putBoolean("done", true);
               if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 24.0, 24.0, 24.0), e -> true).isEmpty()
                  && !((double)(((Biome)world.getBiome(BlockPos.containing(x, y, z)).value()).getBaseTemperature() * 100.0F) < 1.8)) {
                  for (int index5 = 0; index5 < Mth.nextInt(RandomSource.create(), 1, 10); index5++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.LOCUST_LANDSCOURGE.get())
                           .spawn(_levelxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(
                              Mth.nextDouble(RandomSource.create(), -0.5, 0.5), 0.0, Mth.nextDouble(RandomSource.create(), -0.5, 0.5)
                           );
                        }
                     }
                  }

                  ArphexMod.queueServerWork(
                     1,
                     () -> {
                        for (int index6 = 0; index6 < Mth.nextInt(RandomSource.create(), 1, 10); index6++) {
                           if (world instanceof ServerLevel) {
                              ServerLevel _levelxxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                              Entity entityToSpawnx = ((EntityType)ArphexModEntities.LOCUST_LANDSCOURGE.get())
                                 .spawn(_levelxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                              if (entityToSpawnx != null) {
                                 entityToSpawnx.setDeltaMovement(
                                    Mth.nextDouble(RandomSource.create(), -0.5, 0.5), 0.0, Mth.nextDouble(RandomSource.create(), -0.5, 0.5)
                                 );
                              }
                           }
                        }
                     }
                  );
               } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.LOCUST_LANDSCOURGE.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 15.0) {
               entity.getPersistentData().putBoolean("done", true);
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.LONG_LEGS.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 16.0) {
               entity.getPersistentData().putBoolean("done", true);
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.LONG_LEGS_FLY.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 17.0) {
               entity.getPersistentData().putBoolean("done", true);
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.MAGGOT_LARVAE.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 18.0) {
               if (Mth.nextInt(RandomSource.create(), 1, 4) == 2) {
                  entity.getPersistentData().putBoolean("done", true);
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.MILLIPEDE_MARAUDER.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }

                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 19.0) {
               entity.getPersistentData().putBoolean("done", true);
               if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.MOSQUITO_MORBIDITY.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.WEB_FUNNEL.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 20.0) {
               entity.getPersistentData().putBoolean("done", true);
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.MOTH_MOONTRACKER.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.MOTH_MOONTRACKER.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 21.0) {
               entity.getPersistentData().putBoolean("done", true);
               if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 24.0, 24.0, 24.0), e -> true).isEmpty()
                  && Mth.nextInt(RandomSource.create(), 1, 3) == 3) {
                  for (int index7 = 0; index7 < Mth.nextInt(RandomSource.create(), 1, 10); index7++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.ROACH_RIVERSPAWN.get())
                           .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(
                              Mth.nextDouble(RandomSource.create(), -0.5, 0.5), 0.0, Mth.nextDouble(RandomSource.create(), -0.5, 0.5)
                           );
                        }
                     }
                  }

                  ArphexMod.queueServerWork(
                     1,
                     () -> {
                        for (int index8 = 0; index8 < Mth.nextInt(RandomSource.create(), 1, 10); index8++) {
                           if (world instanceof ServerLevel) {
                              ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                              Entity entityToSpawnx = ((EntityType)ArphexModEntities.ROACH_RIVERSPAWN.get())
                                 .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                              if (entityToSpawnx != null) {
                                 entityToSpawnx.setDeltaMovement(
                                    Mth.nextDouble(RandomSource.create(), -0.5, 0.5), 0.0, Mth.nextDouble(RandomSource.create(), -0.5, 0.5)
                                 );
                              }
                           }
                        }
                     }
                  );
               } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.ROACH_RIVERSPAWN.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 22.0) {
               entity.getPersistentData().putBoolean("done", true);
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPION_STRIKER.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 23.0) {
               entity.getPersistentData().putBoolean("done", true);
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SILVERFISH_SPECTRE.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 24.0) {
               entity.getPersistentData().putBoolean("done", true);
               if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_BROOD.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_SINKER.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 25.0) {
               entity.getPersistentData().putBoolean("done", true);
               if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_FLAT.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.WEB_FUNNEL.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 26.0) {
               if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
                  entity.getPersistentData().putBoolean("done", true);
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_GOLIATH.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }

                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 27.0) {
               entity.getPersistentData().putBoolean("done", true);
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_JUMP.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 28.0) {
               entity.getPersistentData().putBoolean("done", true);
               if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 24.0, 24.0, 24.0), e -> true).isEmpty()
                  && Mth.nextInt(RandomSource.create(), 1, 6) == 3) {
                  for (int index9 = 0; index9 < Mth.nextInt(RandomSource.create(), 1, 5); index9++) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE.get())
                           .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(
                              Mth.nextDouble(RandomSource.create(), -0.5, 0.5), 0.0, Mth.nextDouble(RandomSource.create(), -0.5, 0.5)
                           );
                        }
                     }
                  }

                  ArphexMod.queueServerWork(
                     1,
                     () -> {
                        for (int index10 = 0; index10 < Mth.nextInt(RandomSource.create(), 1, 13); index10++) {
                           if (world instanceof ServerLevel) {
                              ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel)world;
                              Entity entityToSpawnx = ((EntityType)ArphexModEntities.SPIDER_LARVAE_TINY.get())
                                 .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                              if (entityToSpawnx != null) {
                                 entityToSpawnx.setDeltaMovement(
                                    Mth.nextDouble(RandomSource.create(), -0.5, 0.5), 0.0, Mth.nextDouble(RandomSource.create(), -0.5, 0.5)
                                 );
                              }
                           }
                        }
                     }
                  );
               } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 29.0) {
               entity.getPersistentData().putBoolean("done", true);
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 30.0) {
               if (Mth.nextInt(RandomSource.create(), 1, 4) == 2) {
                  entity.getPersistentData().putBoolean("done", true);
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_PROWLER.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }

                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 31.0) {
               entity.getPersistentData().putBoolean("done", true);
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.CENTIPEDE_EVICTOR_LARVAE.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 32.0) {
               if (Mth.nextInt(RandomSource.create(), 1, 4) == 2) {
                  entity.getPersistentData().putBoolean("done", true);
                  if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
                     if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.SOLIFUGE_SKULKER.get())
                           .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_RECLUSE.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }

                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 33.0) {
               entity.getPersistentData().putBoolean("done", true);
               if (entity.level().dimension() == Level.OVERWORLD) {
                  if (world.getEntitiesOfClass(SpiderMothEntity.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).isEmpty()
                     && (
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).isEmpty()
                           || !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 24.0, 24.0, 24.0), e -> true).isEmpty()
                     )
                     && (
                        (Double)ConfigurationSettingsConfiguration.DWELLERS_FREQUENCY.get() == 2.0 && Mth.nextInt(RandomSource.create(), 1, 2) == 2
                           || (Double)ConfigurationSettingsConfiguration.DWELLERS_FREQUENCY.get() == 3.0 && Mth.nextInt(RandomSource.create(), 1, 3) == 2
                           || (Double)ConfigurationSettingsConfiguration.DWELLERS_FREQUENCY.get() == 3.0 && Mth.nextInt(RandomSource.create(), 1, 4) == 2
                           || (Double)ConfigurationSettingsConfiguration.DWELLERS_FREQUENCY.get() <= 1.0
                           || (Double)ConfigurationSettingsConfiguration.DWELLERS_FREQUENCY.get() >= 5.0
                     )
                     && (world.getLevelData().isThundering() || !(Boolean)ConfigurationSettingsConfiguration.DWELLERS_REQUIRE_WEATHER.get())
                     && (Boolean)ConfigurationSettingsConfiguration.SPAWN_DWELLERS_NATURALLY.get()) {
                     if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 24.0, 24.0, 24.0), e -> true).isEmpty()) {
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_MOTH.get())
                              .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (Mth.nextInt(RandomSource.create(), 1, 6) == 2) {
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_MOTH.get())
                              .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (Mth.nextInt(RandomSource.create(), 1, 5) == 2) {
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.MOTH_SHADOW_CLONE.get())
                              .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (Mth.nextInt(RandomSource.create(), 1, 4) == 2) {
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.INVISIBLE_STALKER.get())
                              .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
                        if (!world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("dripstone_caves"))
                           && !world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("lush_caves"))) {
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                              Entity entityToSpawn = ((EntityType)ArphexModEntities.RUSH_SCARE.get())
                                 .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                              if (entityToSpawn != null) {
                                 entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                              }
                           }
                        } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.DWELLER_SLEEP_SPAWNER.get())
                              .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.PURE_STALKING.get())
                              .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     } else if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.SKY_STALKER.get())
                           .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }

                     if (!entity.level().isClientSide()) {
                        entity.discard();
                     }
                  }
               } else if (entity.level().dimension() == Level.NETHER) {
                  if ((
                        !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true).isEmpty()
                           || (
                                 (Double)ConfigurationSettingsConfiguration.DWELLERS_FREQUENCY.get() == 2.0 && Mth.nextInt(RandomSource.create(), 1, 2) == 2
                                    || (Double)ConfigurationSettingsConfiguration.DWELLERS_FREQUENCY.get() == 3.0
                                       && Mth.nextInt(RandomSource.create(), 1, 3) == 2
                                    || (Double)ConfigurationSettingsConfiguration.DWELLERS_FREQUENCY.get() == 3.0
                                       && Mth.nextInt(RandomSource.create(), 1, 4) == 2
                                    || (Double)ConfigurationSettingsConfiguration.DWELLERS_FREQUENCY.get() <= 1.0
                                    || (Double)ConfigurationSettingsConfiguration.DWELLERS_FREQUENCY.get() >= 5.0
                              )
                              && (
                                 (world.getLevelData().isThundering() || world.getLevelData().isRaining())
                                       && (Boolean)ConfigurationSettingsConfiguration.DWELLERS_REQUIRE_WEATHER.get()
                                    || !(Boolean)ConfigurationSettingsConfiguration.DWELLERS_REQUIRE_WEATHER.get()
                              )
                              && (Boolean)ConfigurationSettingsConfiguration.SPAWN_DWELLERS_NATURALLY.get()
                     )
                     && world.isEmptyBlock(BlockPos.containing((double)Math.round(x), (double)(Math.round(y) + 2L), (double)Math.round(z)))
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
                     && world.isEmptyBlock(BlockPos.containing((double)(Math.round(x) + 1L), (double)(Math.round(y) + 3L), (double)(Math.round(z) - 1L)))) {
                     if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPIOID_INITIAL.get())
                           .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }

                     if (!entity.level().isClientSide()) {
                        entity.discard();
                     }
                  }
               } else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true).isEmpty()
                  && entity.level().dimension() == Level.END
                  && world.isEmptyBlock(BlockPos.containing((double)Math.round(x), (double)(Math.round(y) + 2L), (double)Math.round(z)))
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
                  && world.isEmptyBlock(BlockPos.containing((double)(Math.round(x) + 1L), (double)(Math.round(y) + 3L), (double)(Math.round(z) - 1L)))) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.DRACONIC_VOIDLASHER.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }

                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 34.0) {
               if (Mth.nextInt(RandomSource.create(), 1, 5) == 2) {
                  entity.getPersistentData().putBoolean("done", true);
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_REAPER.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }

                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }
               }
            } else if (entity.getPersistentData().getDouble("randomchoice") == 35.0) {
               entity.getPersistentData().putBoolean("done", true);
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LUNGER.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            }
         }
      }
   }
}
