package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockwaveProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world instanceof ServerLevel _level) {
         Entity entityToSpawn = ((EntityType)ArphexModEntities.BLOCK_TEST.get()).spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
         if (entityToSpawn != null) {
            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
         }
      }

      if (world instanceof ServerLevel _levelx) {
         _levelx.sendParticles(ParticleTypes.EXPLOSION, x, y, z, 10, 0.4, 0.2, 0.4, 0.2);
      }

      if (world instanceof ServerLevel _levelx) {
         _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARRED_BLOOD.get(), x, y, z, 20, 0.4, 0.4, 0.4, 0.2);
      }

      if (world instanceof Level _levelx) {
         if (!_levelx.isClientSide()) {
            _levelx.playSound(
               null,
               BlockPos.containing(x, y, z),
               (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
               SoundSource.NEUTRAL,
               1.0F,
               0.2F
            );
         } else {
            _levelx.playLocalSound(
               x,
               y,
               z,
               (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
               SoundSource.NEUTRAL,
               1.0F,
               0.2F,
               false
            );
         }
      }

      ArphexMod.queueServerWork(
         4,
         () -> {
            if (world instanceof ServerLevel _levelxxxx) {
               Entity entityToSpawnxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                  .spawn(_levelxxxx, BlockPos.containing(x + 1.0, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawnxxxx != null) {
                  entityToSpawnxxxx.setDeltaMovement(0.0, 0.0, 0.0);
               }
            }

            if (world instanceof ServerLevel _levelx) {
               Entity entityToSpawnxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                  .spawn(_levelx, BlockPos.containing(x - 1.0, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawnxxx != null) {
                  entityToSpawnxxx.setDeltaMovement(0.0, 0.0, 0.0);
               }
            }

            if (world instanceof ServerLevel _levelxx) {
               Entity entityToSpawnxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                  .spawn(_levelxx, BlockPos.containing(x, y, z + 1.0), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawnxx != null) {
                  entityToSpawnxx.setDeltaMovement(0.0, 0.0, 0.0);
               }
            }

            if (world instanceof ServerLevel _levelxxxxx) {
               Entity entityToSpawnx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                  .spawn(_levelxxxxx, BlockPos.containing(x, y, z - 1.0), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawnx != null) {
                  entityToSpawnx.setDeltaMovement(0.0, 0.0, 0.0);
               }
            }

            ArphexMod.queueServerWork(
               4,
               () -> {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxx) {
                     Entity entityToSpawnxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                        .spawn(_levelxxxxxxxxxxxx, BlockPos.containing(x + 2.0, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawnxxxxxxxxxxxx != null) {
                        entityToSpawnxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }

                  if (world instanceof ServerLevel _levelx) {
                     Entity entityToSpawnxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                        .spawn(_levelx, BlockPos.containing(x - 2.0, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawnxxxxxxxxxxx != null) {
                        entityToSpawnxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }

                  if (world instanceof ServerLevel _levelxx) {
                     Entity entityToSpawnxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                        .spawn(_levelxx, BlockPos.containing(x, y, z + 2.0), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawnxxxxxxxxxx != null) {
                        entityToSpawnxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }

                  if (world instanceof ServerLevel _levelxxx) {
                     Entity entityToSpawnxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                        .spawn(_levelxxx, BlockPos.containing(x, y, z - 2.0), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawnxxxxxxxxx != null) {
                        entityToSpawnxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }

                  if (world instanceof ServerLevel _levelxxxx) {
                     Entity entityToSpawnxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                        .spawn(_levelxxxx, BlockPos.containing(x - 1.0, y, z - 1.0), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawnxxxxxxxx != null) {
                        entityToSpawnxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }

                  if (world instanceof ServerLevel _levelxxxxx) {
                     Entity entityToSpawnxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                        .spawn(_levelxxxxx, BlockPos.containing(x + 1.0, y, z - 1.0), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawnxxxxxxx != null) {
                        entityToSpawnxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }

                  if (world instanceof ServerLevel _levelxxxxxx) {
                     Entity entityToSpawnxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                        .spawn(_levelxxxxxx, BlockPos.containing(x + 1.0, y, z + 1.0), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawnxxxxxx != null) {
                        entityToSpawnxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }

                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxx) {
                     Entity entityToSpawnxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                        .spawn(_levelxxxxxxxxxxxxx, BlockPos.containing(x - 1.0, y, z + 1.0), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawnxxxxx != null) {
                        entityToSpawnxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }

                  ArphexMod.queueServerWork(
                     3,
                     () -> {
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxx) {
                           Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                              .spawn(_levelxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x + 3.0, y, z), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                              entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }

                        if (world instanceof ServerLevel _levelx) {
                           Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                              .spawn(_levelx, BlockPos.containing(x - 3.0, y, z), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxx != null) {
                              entityToSpawnxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }

                        if (world instanceof ServerLevel _levelxx) {
                           Entity entityToSpawnxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                              .spawn(_levelxx, BlockPos.containing(x, y, z + 3.0), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawnxxxxxxxxxxxxxxxxx != null) {
                              entityToSpawnxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }

                        if (world instanceof ServerLevel _levelxxx) {
                           Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                              .spawn(_levelxxx, BlockPos.containing(x, y, z - 3.0), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxx != null) {
                              entityToSpawnxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }

                        if (world instanceof ServerLevel _levelxxxx) {
                           Entity entityToSpawnxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                              .spawn(_levelxxxx, BlockPos.containing(x - 1.0, y, z + 2.0), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawnxxxxxxxxxxxxxxxx != null) {
                              entityToSpawnxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }

                        if (world instanceof ServerLevel _levelxxxxx) {
                           Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                              .spawn(_levelxxxxx, BlockPos.containing(x + 1.0, y, z + 2.0), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawnxxxxxxxxxxxxxxxxxxxxx != null) {
                              entityToSpawnxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }

                        if (world instanceof ServerLevel _levelxxxxxx) {
                           Entity entityToSpawnxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                              .spawn(_levelxxxxxx, BlockPos.containing(x + 1.0, y, z - 2.0), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawnxxxxxxxxxxxxxxx != null) {
                              entityToSpawnxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }

                        if (world instanceof ServerLevel _levelxxxxxxx) {
                           Entity entityToSpawnxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                              .spawn(_levelxxxxxxx, BlockPos.containing(x - 1.0, y, z - 2.0), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawnxxxxxxxxxxxxxxxxxxxx != null) {
                              entityToSpawnxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }

                        if (world instanceof ServerLevel _levelxxxxxxxx) {
                           Entity entityToSpawnxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                              .spawn(_levelxxxxxxxx, BlockPos.containing(x - 2.0, y, z + 1.0), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawnxxxxxxxxxxxxxx != null) {
                              entityToSpawnxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }

                        if (world instanceof ServerLevel _levelxxxxxxxxx) {
                           Entity entityToSpawnxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                              .spawn(_levelxxxxxxxxx, BlockPos.containing(x - 2.0, y, z - 1.0), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawnxxxxxxxxxxxxxxxxxxx != null) {
                              entityToSpawnxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }

                        if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                           Entity entityToSpawnxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                              .spawn(_levelxxxxxxxxxx, BlockPos.containing(x + 2.0, y, z + 1.0), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawnxxxxxxxxxxxxx != null) {
                              entityToSpawnxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }

                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxx) {
                           Entity entityToSpawnxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                              .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x + 2.0, y, z - 1.0), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawnxxxxxxxxxxxxxxxxxx != null) {
                              entityToSpawnxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }

                        ArphexMod.queueServerWork(
                           3,
                           () -> {
                              if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                 Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                                    .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x + 4.0, y, z), MobSpawnType.MOB_SUMMONED);
                                 if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                    entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                 }
                              }

                              if (world instanceof ServerLevel _levelx) {
                                 Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                                    .spawn(_levelx, BlockPos.containing(x - 4.0, y, z), MobSpawnType.MOB_SUMMONED);
                                 if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                    entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                 }
                              }

                              if (world instanceof ServerLevel _levelxx) {
                                 Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                                    .spawn(_levelxx, BlockPos.containing(x, y, z + 4.0), MobSpawnType.MOB_SUMMONED);
                                 if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                    entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                 }
                              }

                              if (world instanceof ServerLevel _levelxxx) {
                                 Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                                    .spawn(_levelxxx, BlockPos.containing(x, y, z - 4.0), MobSpawnType.MOB_SUMMONED);
                                 if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                    entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                 }
                              }

                              if (world instanceof ServerLevel _levelxxxx) {
                                 Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                                    .spawn(_levelxxxx, BlockPos.containing(x - 1.0, y, z + 3.0), MobSpawnType.MOB_SUMMONED);
                                 if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                    entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                 }
                              }

                              if (world instanceof ServerLevel _levelxxxxx) {
                                 Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                                    .spawn(_levelxxxxx, BlockPos.containing(x + 1.0, y, z + 3.0), MobSpawnType.MOB_SUMMONED);
                                 if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                    entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                 }
                              }

                              if (world instanceof ServerLevel _levelxxxxxx) {
                                 Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                                    .spawn(_levelxxxxxx, BlockPos.containing(x + 1.0, y, z - 3.0), MobSpawnType.MOB_SUMMONED);
                                 if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                    entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                 }
                              }

                              if (world instanceof ServerLevel _levelxxxxxxx) {
                                 Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                                    .spawn(_levelxxxxxxx, BlockPos.containing(x - 1.0, y, z - 3.0), MobSpawnType.MOB_SUMMONED);
                                 if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                    entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                 }
                              }

                              if (world instanceof ServerLevel _levelxxxxxxxx) {
                                 Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                                    .spawn(_levelxxxxxxxx, BlockPos.containing(x - 3.0, y, z + 1.0), MobSpawnType.MOB_SUMMONED);
                                 if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                    entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                 }
                              }

                              if (world instanceof ServerLevel _levelxxxxxxxxx) {
                                 Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                                    .spawn(_levelxxxxxxxxx, BlockPos.containing(x - 3.0, y, z - 1.0), MobSpawnType.MOB_SUMMONED);
                                 if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                    entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                 }
                              }

                              if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                                 Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                                    .spawn(_levelxxxxxxxxxx, BlockPos.containing(x + 3.0, y, z + 1.0), MobSpawnType.MOB_SUMMONED);
                                 if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                    entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                 }
                              }

                              if (world instanceof ServerLevel _levelxxxxxxxxxxx) {
                                 Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                                    .spawn(_levelxxxxxxxxxxx, BlockPos.containing(x + 3.0, y, z - 1.0), MobSpawnType.MOB_SUMMONED);
                                 if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                    entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                 }
                              }

                              if (world instanceof ServerLevel _levelxxxxxxxxxxxx) {
                                 Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                                    .spawn(_levelxxxxxxxxxxxx, BlockPos.containing(x + 2.0, y, z - 2.0), MobSpawnType.MOB_SUMMONED);
                                 if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                    entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                 }
                              }

                              if (world instanceof ServerLevel _levelxxxxxxxxxxxxx) {
                                 Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                                    .spawn(_levelxxxxxxxxxxxxx, BlockPos.containing(x + 2.0, y, z + 2.0), MobSpawnType.MOB_SUMMONED);
                                 if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                    entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                 }
                              }

                              if (world instanceof ServerLevel _levelxxxxxxxxxxxxxx) {
                                 Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                                    .spawn(_levelxxxxxxxxxxxxxx, BlockPos.containing(x - 2.0, y, z + 2.0), MobSpawnType.MOB_SUMMONED);
                                 if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                    entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                 }
                              }

                              if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                 Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                                    .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x - 2.0, y, z - 2.0), MobSpawnType.MOB_SUMMONED);
                                 if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                    entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                 }
                              }

                              ArphexMod.queueServerWork(
                                 3,
                                 () -> {
                                    if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                       Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                             .get())
                                          .spawn(
                                             _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                             BlockPos.containing(x + 5.0, y, z),
                                             MobSpawnType.MOB_SUMMONED
                                          );
                                       if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                          entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                       }
                                    }

                                    if (world instanceof ServerLevel _levelx) {
                                       Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                             .get())
                                          .spawn(_levelx, BlockPos.containing(x - 5.0, y, z), MobSpawnType.MOB_SUMMONED);
                                       if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                          entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                       }
                                    }

                                    if (world instanceof ServerLevel _levelxx) {
                                       Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                             .get())
                                          .spawn(_levelxx, BlockPos.containing(x, y, z + 5.0), MobSpawnType.MOB_SUMMONED);
                                       if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                          entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                       }
                                    }

                                    if (world instanceof ServerLevel _levelxxx) {
                                       Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                                          .spawn(_levelxxx, BlockPos.containing(x, y, z - 5.0), MobSpawnType.MOB_SUMMONED);
                                       if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                          entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                       }
                                    }

                                    if (world instanceof ServerLevel _levelxxxx) {
                                       Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                             .get())
                                          .spawn(_levelxxxx, BlockPos.containing(x - 2.0, y, z + 3.0), MobSpawnType.MOB_SUMMONED);
                                       if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                          entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                       }
                                    }

                                    if (world instanceof ServerLevel _levelxxxxx) {
                                       Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                             .get())
                                          .spawn(_levelxxxxx, BlockPos.containing(x + 2.0, y, z + 3.0), MobSpawnType.MOB_SUMMONED);
                                       if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                          entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                       }
                                    }

                                    if (world instanceof ServerLevel _levelxxxxxx) {
                                       Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                             .get())
                                          .spawn(_levelxxxxxx, BlockPos.containing(x + 2.0, y, z - 3.0), MobSpawnType.MOB_SUMMONED);
                                       if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                          entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                       }
                                    }

                                    if (world instanceof ServerLevel _levelxxxxxxx) {
                                       Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                                          .spawn(_levelxxxxxxx, BlockPos.containing(x - 2.0, y, z - 3.0), MobSpawnType.MOB_SUMMONED);
                                       if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                          entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                       }
                                    }

                                    if (world instanceof ServerLevel _levelxxxxxxxx) {
                                       Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                                          .spawn(_levelxxxxxxxx, BlockPos.containing(x - 3.0, y, z + 2.0), MobSpawnType.MOB_SUMMONED);
                                       if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                          entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                       }
                                    }

                                    if (world instanceof ServerLevel _levelxxxxxxxxx) {
                                       Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                             .get())
                                          .spawn(_levelxxxxxxxxx, BlockPos.containing(x - 3.0, y, z - 2.0), MobSpawnType.MOB_SUMMONED);
                                       if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                          entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                       }
                                    }

                                    if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                                       Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                             .get())
                                          .spawn(_levelxxxxxxxxxx, BlockPos.containing(x + 3.0, y, z + 2.0), MobSpawnType.MOB_SUMMONED);
                                       if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                          entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                       }
                                    }

                                    if (world instanceof ServerLevel _levelxxxxxxxxxxx) {
                                       Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                                          .spawn(_levelxxxxxxxxxxx, BlockPos.containing(x + 3.0, y, z - 2.0), MobSpawnType.MOB_SUMMONED);
                                       if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                          entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                       }
                                    }

                                    if (world instanceof ServerLevel _levelxxxxxxxxxxxx) {
                                       Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                                          .spawn(_levelxxxxxxxxxxxx, BlockPos.containing(x + 2.0, y, z - 3.0), MobSpawnType.MOB_SUMMONED);
                                       if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                          entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                       }
                                    }

                                    if (world instanceof ServerLevel _levelxxxxxxxxxxxxx) {
                                       Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                             .get())
                                          .spawn(_levelxxxxxxxxxxxxx, BlockPos.containing(x + 2.0, y, z + 3.0), MobSpawnType.MOB_SUMMONED);
                                       if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                          entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                       }
                                    }

                                    if (world instanceof ServerLevel _levelxxxxxxxxxxxxxx) {
                                       Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                             .get())
                                          .spawn(_levelxxxxxxxxxxxxxx, BlockPos.containing(x - 3.0, y, z + 2.0), MobSpawnType.MOB_SUMMONED);
                                       if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                          entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                       }
                                    }

                                    if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxx) {
                                       Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                                          .spawn(_levelxxxxxxxxxxxxxxx, BlockPos.containing(x - 3.0, y, z - 2.0), MobSpawnType.MOB_SUMMONED);
                                       if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                          entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                       }
                                    }

                                    if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxx) {
                                       Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                                          .spawn(_levelxxxxxxxxxxxxxxxx, BlockPos.containing(x - 4.0, y, z - 1.0), MobSpawnType.MOB_SUMMONED);
                                       if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                          entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                       }
                                    }

                                    if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxx) {
                                       Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                             .get())
                                          .spawn(_levelxxxxxxxxxxxxxxxxx, BlockPos.containing(x + 4.0, y, z - 1.0), MobSpawnType.MOB_SUMMONED);
                                       if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                          entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                       }
                                    }

                                    if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxx) {
                                       Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                             .get())
                                          .spawn(_levelxxxxxxxxxxxxxxxxxx, BlockPos.containing(x + 4.0, y, z + 1.0), MobSpawnType.MOB_SUMMONED);
                                       if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                          entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                       }
                                    }

                                    if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxx) {
                                       Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                                          .spawn(_levelxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x - 4.0, y, z + 1.0), MobSpawnType.MOB_SUMMONED);
                                       if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                          entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                       }
                                    }

                                    if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxx) {
                                       Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                                          .spawn(_levelxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x - 1.0, y, z + 4.0), MobSpawnType.MOB_SUMMONED);
                                       if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                          entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                       }
                                    }

                                    if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                       Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                             .get())
                                          .spawn(
                                             _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                             BlockPos.containing(x + 1.0, y, z + 4.0),
                                             MobSpawnType.MOB_SUMMONED
                                          );
                                       if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                          entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                       }
                                    }

                                    if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                       Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                             .get())
                                          .spawn(
                                             _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                             BlockPos.containing(x + 1.0, y, z - 4.0),
                                             MobSpawnType.MOB_SUMMONED
                                          );
                                       if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                          entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                       }
                                    }

                                    if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                       Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST.get())
                                          .spawn(
                                             _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                             BlockPos.containing(x - 1.0, y, z - 4.0),
                                             MobSpawnType.MOB_SUMMONED
                                          );
                                       if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                          entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                       }
                                    }

                                    ArphexMod.queueServerWork(
                                       3,
                                       () -> {
                                          if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                             )
                                           {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(
                                                   _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                   BlockPos.containing(x + 6.0, y, z),
                                                   MobSpawnType.MOB_SUMMONED
                                                );
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                != null) {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                   0.0, 0.0, 0.0
                                                );
                                             }
                                          }

                                          if (world instanceof ServerLevel _levelx) {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(_levelx, BlockPos.containing(x - 6.0, y, z), MobSpawnType.MOB_SUMMONED);
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                   0.0, 0.0, 0.0
                                                );
                                             }
                                          }

                                          if (world instanceof ServerLevel _levelxx) {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(_levelxx, BlockPos.containing(x, y, z + 6.0), MobSpawnType.MOB_SUMMONED);
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                != null) {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                   0.0, 0.0, 0.0
                                                );
                                             }
                                          }

                                          if (world instanceof ServerLevel _levelxxx) {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(_levelxxx, BlockPos.containing(x, y, z - 6.0), MobSpawnType.MOB_SUMMONED);
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                   0.0, 0.0, 0.0
                                                );
                                             }
                                          }

                                          if (world instanceof ServerLevel _levelxxxx) {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(_levelxxxx, BlockPos.containing(x - 2.0, y, z + 4.0), MobSpawnType.MOB_SUMMONED);
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                   0.0, 0.0, 0.0
                                                );
                                             }
                                          }

                                          if (world instanceof ServerLevel _levelxxxxx) {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(_levelxxxxx, BlockPos.containing(x + 2.0, y, z + 4.0), MobSpawnType.MOB_SUMMONED);
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                   0.0, 0.0, 0.0
                                                );
                                             }
                                          }

                                          if (world instanceof ServerLevel _levelxxxxxx) {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(_levelxxxxxx, BlockPos.containing(x + 2.0, y, z - 4.0), MobSpawnType.MOB_SUMMONED);
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                != null) {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                   0.0, 0.0, 0.0
                                                );
                                             }
                                          }

                                          if (world instanceof ServerLevel _levelxxxxxxx) {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(_levelxxxxxxx, BlockPos.containing(x - 2.0, y, z - 4.0), MobSpawnType.MOB_SUMMONED);
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                   0.0, 0.0, 0.0
                                                );
                                             }
                                          }

                                          if (world instanceof ServerLevel _levelxxxxxxxx) {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(_levelxxxxxxxx, BlockPos.containing(x - 4.0, y, z + 2.0), MobSpawnType.MOB_SUMMONED);
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                   0.0, 0.0, 0.0
                                                );
                                             }
                                          }

                                          if (world instanceof ServerLevel _levelxxxxxxxxx) {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(_levelxxxxxxxxx, BlockPos.containing(x - 4.0, y, z - 2.0), MobSpawnType.MOB_SUMMONED);
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                   0.0, 0.0, 0.0
                                                );
                                             }
                                          }

                                          if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(_levelxxxxxxxxxx, BlockPos.containing(x + 4.0, y, z + 2.0), MobSpawnType.MOB_SUMMONED);
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                != null) {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                   0.0, 0.0, 0.0
                                                );
                                             }
                                          }

                                          if (world instanceof ServerLevel _levelxxxxxxxxxxx) {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(_levelxxxxxxxxxxx, BlockPos.containing(x + 4.0, y, z - 2.0), MobSpawnType.MOB_SUMMONED);
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                             }
                                          }

                                          if (world instanceof ServerLevel _levelxxxxxxxxxxxx) {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(_levelxxxxxxxxxxxx, BlockPos.containing(x + 2.0, y, z - 4.0), MobSpawnType.MOB_SUMMONED);
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                   0.0, 0.0, 0.0
                                                );
                                             }
                                          }

                                          if (world instanceof ServerLevel _levelxxxxxxxxxxxxx) {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(_levelxxxxxxxxxxxxx, BlockPos.containing(x + 2.0, y, z + 4.0), MobSpawnType.MOB_SUMMONED);
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                   0.0, 0.0, 0.0
                                                );
                                             }
                                          }

                                          if (world instanceof ServerLevel _levelxxxxxxxxxxxxxx) {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(_levelxxxxxxxxxxxxxx, BlockPos.containing(x - 4.0, y, z + 2.0), MobSpawnType.MOB_SUMMONED);
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                != null) {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                   0.0, 0.0, 0.0
                                                );
                                             }
                                          }

                                          if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxx) {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(_levelxxxxxxxxxxxxxxx, BlockPos.containing(x - 4.0, y, z - 2.0), MobSpawnType.MOB_SUMMONED);
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                             }
                                          }

                                          if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxx) {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(_levelxxxxxxxxxxxxxxxx, BlockPos.containing(x - 4.0, y, z - 2.0), MobSpawnType.MOB_SUMMONED);
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                   0.0, 0.0, 0.0
                                                );
                                             }
                                          }

                                          if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxx) {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(_levelxxxxxxxxxxxxxxxxx, BlockPos.containing(x + 4.0, y, z - 2.0), MobSpawnType.MOB_SUMMONED);
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                   0.0, 0.0, 0.0
                                                );
                                             }
                                          }

                                          if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxx) {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(_levelxxxxxxxxxxxxxxxxxx, BlockPos.containing(x + 4.0, y, z + 2.0), MobSpawnType.MOB_SUMMONED);
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                != null) {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                   0.0, 0.0, 0.0
                                                );
                                             }
                                          }

                                          if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxx) {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(_levelxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x - 4.0, y, z + 2.0), MobSpawnType.MOB_SUMMONED);
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(0.0, 0.0, 0.0);
                                             }
                                          }

                                          if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxx) {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(_levelxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x - 2.0, y, z + 4.0), MobSpawnType.MOB_SUMMONED);
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                   0.0, 0.0, 0.0
                                                );
                                             }
                                          }

                                          if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(
                                                   _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                   BlockPos.containing(x + 2.0, y, z + 4.0),
                                                   MobSpawnType.MOB_SUMMONED
                                                );
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                   0.0, 0.0, 0.0
                                                );
                                             }
                                          }

                                          if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxx) {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(_levelxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x + 2.0, y, z - 4.0), MobSpawnType.MOB_SUMMONED);
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                != null) {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                   0.0, 0.0, 0.0
                                                );
                                             }
                                          }

                                          if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxx) {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x - 2.0, y, z - 4.0), MobSpawnType.MOB_SUMMONED);
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                != null) {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                   0.0, 0.0, 0.0
                                                );
                                             }
                                          }

                                          if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxx) {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x - 3.0, y, z - 3.0), MobSpawnType.MOB_SUMMONED);
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                   0.0, 0.0, 0.0
                                                );
                                             }
                                          }

                                          if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x + 3.0, y, z - 3.0), MobSpawnType.MOB_SUMMONED);
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                   0.0, 0.0, 0.0
                                                );
                                             }
                                          }

                                          if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x + 3.0, y, z + 3.0), MobSpawnType.MOB_SUMMONED);
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null
                                                )
                                              {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                   0.0, 0.0, 0.0
                                                );
                                             }
                                          }

                                          if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x - 3.0, y, z + 3.0), MobSpawnType.MOB_SUMMONED);
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                != null) {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                   0.0, 0.0, 0.0
                                                );
                                             }
                                          }

                                          if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x - 5.0, y, z + 1.0), MobSpawnType.MOB_SUMMONED);
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                   0.0, 0.0, 0.0
                                                );
                                             }
                                          }

                                          if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x + 5.0, y, z + 1.0), MobSpawnType.MOB_SUMMONED);
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                   0.0, 0.0, 0.0
                                                );
                                             }
                                          }

                                          if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(
                                                   _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x + 5.0, y, z - 1.0), MobSpawnType.MOB_SUMMONED
                                                );
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                   0.0, 0.0, 0.0
                                                );
                                             }
                                          }

                                          if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(
                                                   _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x - 5.0, y, z - 1.0), MobSpawnType.MOB_SUMMONED
                                                );
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                != null) {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                   0.0, 0.0, 0.0
                                                );
                                             }
                                          }

                                          if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(
                                                   _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x - 1.0, y, z - 5.0), MobSpawnType.MOB_SUMMONED
                                                );
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                   0.0, 0.0, 0.0
                                                );
                                             }
                                          }

                                          if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(
                                                   _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x + 1.0, y, z - 5.0), MobSpawnType.MOB_SUMMONED
                                                );
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                   0.0, 0.0, 0.0
                                                );
                                             }
                                          }

                                          if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                             )
                                           {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(
                                                   _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                   BlockPos.containing(x + 1.0, y, z + 5.0),
                                                   MobSpawnType.MOB_SUMMONED
                                                );
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                   0.0, 0.0, 0.0
                                                );
                                             }
                                          }

                                          if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                             )
                                           {
                                             Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                   .get())
                                                .spawn(
                                                   _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                   BlockPos.containing(x - 1.0, y, z + 5.0),
                                                   MobSpawnType.MOB_SUMMONED
                                                );
                                             if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                != null) {
                                                entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                   0.0, 0.0, 0.0
                                                );
                                             }
                                          }

                                          ArphexMod.queueServerWork(
                                             2,
                                             () -> {
                                                if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                   )
                                                 {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(
                                                         _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                         BlockPos.containing(x + 7.0, y, z),
                                                         MobSpawnType.MOB_SUMMONED
                                                      );
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(_levelx, BlockPos.containing(x - 7.0, y, z), MobSpawnType.MOB_SUMMONED);
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(_levelxx, BlockPos.containing(x, y, z + 7.0), MobSpawnType.MOB_SUMMONED);
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(_levelxxx, BlockPos.containing(x, y, z - 7.0), MobSpawnType.MOB_SUMMONED);
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(_levelxxxx, BlockPos.containing(x - 2.0, y, z + 5.0), MobSpawnType.MOB_SUMMONED);
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(_levelxxxxx, BlockPos.containing(x + 2.0, y, z + 5.0), MobSpawnType.MOB_SUMMONED);
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(_levelxxxxxx, BlockPos.containing(x + 2.0, y, z - 5.0), MobSpawnType.MOB_SUMMONED);
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(_levelxxxxxxx, BlockPos.containing(x - 2.0, y, z - 5.0), MobSpawnType.MOB_SUMMONED);
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(_levelxxxxxxxx, BlockPos.containing(x - 5.0, y, z + 2.0), MobSpawnType.MOB_SUMMONED);
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(_levelxxxxxxxxx, BlockPos.containing(x - 5.0, y, z - 2.0), MobSpawnType.MOB_SUMMONED);
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(_levelxxxxxxxxxx, BlockPos.containing(x + 5.0, y, z + 2.0), MobSpawnType.MOB_SUMMONED);
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(_levelxxxxxxxxxxx, BlockPos.containing(x + 5.0, y, z - 2.0), MobSpawnType.MOB_SUMMONED);
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(_levelxxxxxxxxxxxx, BlockPos.containing(x + 2.0, y, z - 5.0), MobSpawnType.MOB_SUMMONED);
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxxxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(_levelxxxxxxxxxxxxx, BlockPos.containing(x + 2.0, y, z + 5.0), MobSpawnType.MOB_SUMMONED);
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxxxxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(_levelxxxxxxxxxxxxxx, BlockPos.containing(x - 5.0, y, z + 2.0), MobSpawnType.MOB_SUMMONED);
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(_levelxxxxxxxxxxxxxxx, BlockPos.containing(x - 5.0, y, z - 2.0), MobSpawnType.MOB_SUMMONED);
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(_levelxxxxxxxxxxxxxxxx, BlockPos.containing(x - 5.0, y, z - 2.0), MobSpawnType.MOB_SUMMONED);
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(_levelxxxxxxxxxxxxxxxxx, BlockPos.containing(x + 5.0, y, z - 2.0), MobSpawnType.MOB_SUMMONED);
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(_levelxxxxxxxxxxxxxxxxxx, BlockPos.containing(x + 5.0, y, z + 2.0), MobSpawnType.MOB_SUMMONED);
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(_levelxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x - 5.0, y, z + 2.0), MobSpawnType.MOB_SUMMONED);
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(_levelxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x - 2.0, y, z + 5.0), MobSpawnType.MOB_SUMMONED);
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                   )
                                                 {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(
                                                         _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                         BlockPos.containing(x + 2.0, y, z + 5.0),
                                                         MobSpawnType.MOB_SUMMONED
                                                      );
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(_levelxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x + 2.0, y, z - 5.0), MobSpawnType.MOB_SUMMONED);
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x - 2.0, y, z - 5.0), MobSpawnType.MOB_SUMMONED);
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(
                                                         _levelxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x - 4.0, y, z - 3.0), MobSpawnType.MOB_SUMMONED
                                                      );
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(
                                                         _levelxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x + 4.0, y, z - 3.0), MobSpawnType.MOB_SUMMONED
                                                      );
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(
                                                         _levelxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x + 4.0, y, z + 3.0), MobSpawnType.MOB_SUMMONED
                                                      );
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(
                                                         _levelxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x - 4.0, y, z + 3.0), MobSpawnType.MOB_SUMMONED
                                                      );
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(
                                                         _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                         BlockPos.containing(x - 6.0, y, z + 1.0),
                                                         MobSpawnType.MOB_SUMMONED
                                                      );
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(
                                                         _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                         BlockPos.containing(x + 6.0, y, z + 1.0),
                                                         MobSpawnType.MOB_SUMMONED
                                                      );
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(
                                                         _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                         BlockPos.containing(x + 6.0, y, z - 1.0),
                                                         MobSpawnType.MOB_SUMMONED
                                                      );
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(
                                                         _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                         BlockPos.containing(x - 6.0, y, z - 1.0),
                                                         MobSpawnType.MOB_SUMMONED
                                                      );
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(
                                                         _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                         BlockPos.containing(x - 1.0, y, z - 6.0),
                                                         MobSpawnType.MOB_SUMMONED
                                                      );
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(
                                                         _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                         BlockPos.containing(x + 1.0, y, z - 6.0),
                                                         MobSpawnType.MOB_SUMMONED
                                                      );
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(
                                                         _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                         BlockPos.containing(x + 1.0, y, z + 6.0),
                                                         MobSpawnType.MOB_SUMMONED
                                                      );
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(
                                                         _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                         BlockPos.containing(x - 1.0, y, z + 6.0),
                                                         MobSpawnType.MOB_SUMMONED
                                                      );
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(
                                                         _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                         BlockPos.containing(x - 4.0, y, z + 3.0),
                                                         MobSpawnType.MOB_SUMMONED
                                                      );
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(
                                                         _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                         BlockPos.containing(x + 4.0, y, z + 3.0),
                                                         MobSpawnType.MOB_SUMMONED
                                                      );
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(
                                                         _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                         BlockPos.containing(x + 4.0, y, z - 3.0),
                                                         MobSpawnType.MOB_SUMMONED
                                                      );
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(
                                                         _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                         BlockPos.containing(x - 4.0, y, z - 3.0),
                                                         MobSpawnType.MOB_SUMMONED
                                                      );
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(
                                                         _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                         BlockPos.containing(x + 3.0, y, z - 4.0),
                                                         MobSpawnType.MOB_SUMMONED
                                                      );
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(
                                                         _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                         BlockPos.containing(x - 3.0, y, z + 4.0),
                                                         MobSpawnType.MOB_SUMMONED
                                                      );
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                   )
                                                 {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(
                                                         _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                         BlockPos.containing(x + 3.0, y, z + 4.0),
                                                         MobSpawnType.MOB_SUMMONED
                                                      );
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                   )
                                                 {
                                                   Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                         .get())
                                                      .spawn(
                                                         _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                         BlockPos.containing(x - 3.0, y, z - 4.0),
                                                         MobSpawnType.MOB_SUMMONED
                                                      );
                                                   if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      != null) {
                                                      entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                         0.0, 0.0, 0.0
                                                      );
                                                   }
                                                }

                                                ArphexMod.queueServerWork(
                                                   2,
                                                   () -> {
                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                         )
                                                       {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(
                                                               _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                               BlockPos.containing(x + 8.0, y, z),
                                                               MobSpawnType.MOB_SUMMONED
                                                            );
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(_levelx, BlockPos.containing(x - 8.0, y, z), MobSpawnType.MOB_SUMMONED);
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(_levelxx, BlockPos.containing(x, y, z + 8.0), MobSpawnType.MOB_SUMMONED);
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(_levelxxx, BlockPos.containing(x, y, z - 8.0), MobSpawnType.MOB_SUMMONED);
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(_levelxxxx, BlockPos.containing(x - 2.0, y, z + 6.0), MobSpawnType.MOB_SUMMONED);
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(_levelxxxxx, BlockPos.containing(x + 2.0, y, z + 6.0), MobSpawnType.MOB_SUMMONED);
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(_levelxxxxxx, BlockPos.containing(x + 2.0, y, z - 6.0), MobSpawnType.MOB_SUMMONED);
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(_levelxxxxxxx, BlockPos.containing(x - 2.0, y, z - 6.0), MobSpawnType.MOB_SUMMONED);
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(_levelxxxxxxxx, BlockPos.containing(x - 6.0, y, z + 2.0), MobSpawnType.MOB_SUMMONED);
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(_levelxxxxxxxxx, BlockPos.containing(x - 6.0, y, z - 2.0), MobSpawnType.MOB_SUMMONED);
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(_levelxxxxxxxxxx, BlockPos.containing(x + 6.0, y, z + 2.0), MobSpawnType.MOB_SUMMONED);
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(_levelxxxxxxxxxxx, BlockPos.containing(x + 6.0, y, z - 2.0), MobSpawnType.MOB_SUMMONED);
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(_levelxxxxxxxxxxxx, BlockPos.containing(x + 2.0, y, z - 6.0), MobSpawnType.MOB_SUMMONED);
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(_levelxxxxxxxxxxxxx, BlockPos.containing(x + 2.0, y, z + 6.0), MobSpawnType.MOB_SUMMONED);
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(_levelxxxxxxxxxxxxxx, BlockPos.containing(x - 6.0, y, z + 2.0), MobSpawnType.MOB_SUMMONED);
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(_levelxxxxxxxxxxxxxxx, BlockPos.containing(x - 6.0, y, z - 2.0), MobSpawnType.MOB_SUMMONED);
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(_levelxxxxxxxxxxxxxxxx, BlockPos.containing(x - 6.0, y, z - 2.0), MobSpawnType.MOB_SUMMONED);
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                         )
                                                       {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(
                                                               _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                               BlockPos.containing(x + 6.0, y, z - 2.0),
                                                               MobSpawnType.MOB_SUMMONED
                                                            );
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(
                                                               _levelxxxxxxxxxxxxxxxxxx, BlockPos.containing(x + 6.0, y, z + 2.0), MobSpawnType.MOB_SUMMONED
                                                            );
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(
                                                               _levelxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x - 6.0, y, z + 2.0), MobSpawnType.MOB_SUMMONED
                                                            );
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(
                                                               _levelxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x - 2.0, y, z + 6.0), MobSpawnType.MOB_SUMMONED
                                                            );
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(
                                                               _levelxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x + 2.0, y, z + 6.0), MobSpawnType.MOB_SUMMONED
                                                            );
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(
                                                               _levelxxxxxxxxxxxxxxxxxxxxxx,
                                                               BlockPos.containing(x + 2.0, y, z - 6.0),
                                                               MobSpawnType.MOB_SUMMONED
                                                            );
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(
                                                               _levelxxxxxxxxxxxxxxxxxxxxxxx,
                                                               BlockPos.containing(x - 2.0, y, z - 6.0),
                                                               MobSpawnType.MOB_SUMMONED
                                                            );
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(
                                                               _levelxxxxxxxxxxxxxxxxxxxxxxxx,
                                                               BlockPos.containing(x - 5.0, y, z - 3.0),
                                                               MobSpawnType.MOB_SUMMONED
                                                            );
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(
                                                               _levelxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                               BlockPos.containing(x + 5.0, y, z - 3.0),
                                                               MobSpawnType.MOB_SUMMONED
                                                            );
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(
                                                               _levelxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                               BlockPos.containing(x + 5.0, y, z + 3.0),
                                                               MobSpawnType.MOB_SUMMONED
                                                            );
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(
                                                               _levelxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                               BlockPos.containing(x - 5.0, y, z + 3.0),
                                                               MobSpawnType.MOB_SUMMONED
                                                            );
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(
                                                               _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                               BlockPos.containing(x - 7.0, y, z + 1.0),
                                                               MobSpawnType.MOB_SUMMONED
                                                            );
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(
                                                               _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                               BlockPos.containing(x + 7.0, y, z + 1.0),
                                                               MobSpawnType.MOB_SUMMONED
                                                            );
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(
                                                               _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                               BlockPos.containing(x + 7.0, y, z - 1.0),
                                                               MobSpawnType.MOB_SUMMONED
                                                            );
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(
                                                               _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                               BlockPos.containing(x - 7.0, y, z - 1.0),
                                                               MobSpawnType.MOB_SUMMONED
                                                            );
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(
                                                               _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                               BlockPos.containing(x - 1.0, y, z - 7.0),
                                                               MobSpawnType.MOB_SUMMONED
                                                            );
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(
                                                               _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                               BlockPos.containing(x + 1.0, y, z - 7.0),
                                                               MobSpawnType.MOB_SUMMONED
                                                            );
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(
                                                               _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                               BlockPos.containing(x + 1.0, y, z + 7.0),
                                                               MobSpawnType.MOB_SUMMONED
                                                            );
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(
                                                               _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                               BlockPos.containing(x - 1.0, y, z + 7.0),
                                                               MobSpawnType.MOB_SUMMONED
                                                            );
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(
                                                               _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                               BlockPos.containing(x - 5.0, y, z + 3.0),
                                                               MobSpawnType.MOB_SUMMONED
                                                            );
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(
                                                               _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                               BlockPos.containing(x + 5.0, y, z + 3.0),
                                                               MobSpawnType.MOB_SUMMONED
                                                            );
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(
                                                               _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                               BlockPos.containing(x + 5.0, y, z - 3.0),
                                                               MobSpawnType.MOB_SUMMONED
                                                            );
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(
                                                               _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                               BlockPos.containing(x - 5.0, y, z - 3.0),
                                                               MobSpawnType.MOB_SUMMONED
                                                            );
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(
                                                               _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                               BlockPos.containing(x + 3.0, y, z - 5.0),
                                                               MobSpawnType.MOB_SUMMONED
                                                            );
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(
                                                               _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                               BlockPos.containing(x - 3.0, y, z + 5.0),
                                                               MobSpawnType.MOB_SUMMONED
                                                            );
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                         )
                                                       {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(
                                                               _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                               BlockPos.containing(x + 3.0, y, z + 5.0),
                                                               MobSpawnType.MOB_SUMMONED
                                                            );
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                         )
                                                       {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(
                                                               _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                               BlockPos.containing(x - 3.0, y, z - 5.0),
                                                               MobSpawnType.MOB_SUMMONED
                                                            );
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                         )
                                                       {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(
                                                               _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                               BlockPos.containing(x - 4.0, y, z - 4.0),
                                                               MobSpawnType.MOB_SUMMONED
                                                            );
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                         )
                                                       {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(
                                                               _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                               BlockPos.containing(x + 4.0, y, z - 4.0),
                                                               MobSpawnType.MOB_SUMMONED
                                                            );
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                         )
                                                       {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(
                                                               _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                               BlockPos.containing(x - 4.0, y, z + 4.0),
                                                               MobSpawnType.MOB_SUMMONED
                                                            );
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                         )
                                                       {
                                                         Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                               .get())
                                                            .spawn(
                                                               _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                               BlockPos.containing(x + 4.0, y, z + 4.0),
                                                               MobSpawnType.MOB_SUMMONED
                                                            );
                                                         if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            != null) {
                                                            entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                               0.0, 0.0, 0.0
                                                            );
                                                         }
                                                      }

                                                      ArphexMod.queueServerWork(
                                                         2,
                                                         () -> {
                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                               )
                                                             {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x + 9.0, y, z),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(_levelx, BlockPos.containing(x - 9.0, y, z), MobSpawnType.MOB_SUMMONED);
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(_levelxx, BlockPos.containing(x, y, z + 9.0), MobSpawnType.MOB_SUMMONED);
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(_levelxxx, BlockPos.containing(x, y, z - 9.0), MobSpawnType.MOB_SUMMONED);
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(_levelxxxx, BlockPos.containing(x - 2.0, y, z + 7.0), MobSpawnType.MOB_SUMMONED);
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(_levelxxxxx, BlockPos.containing(x + 2.0, y, z + 7.0), MobSpawnType.MOB_SUMMONED);
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(_levelxxxxxx, BlockPos.containing(x + 2.0, y, z - 7.0), MobSpawnType.MOB_SUMMONED);
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(_levelxxxxxxx, BlockPos.containing(x - 2.0, y, z - 7.0), MobSpawnType.MOB_SUMMONED);
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(_levelxxxxxxxx, BlockPos.containing(x - 7.0, y, z + 2.0), MobSpawnType.MOB_SUMMONED);
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(_levelxxxxxxxxx, BlockPos.containing(x - 7.0, y, z - 2.0), MobSpawnType.MOB_SUMMONED);
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(_levelxxxxxxxxxx, BlockPos.containing(x + 7.0, y, z + 2.0), MobSpawnType.MOB_SUMMONED);
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(_levelxxxxxxxxxxx, BlockPos.containing(x + 7.0, y, z - 2.0), MobSpawnType.MOB_SUMMONED);
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxx, BlockPos.containing(x + 2.0, y, z - 7.0), MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxx, BlockPos.containing(x + 2.0, y, z + 7.0), MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxx, BlockPos.containing(x - 7.0, y, z + 2.0), MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxx, BlockPos.containing(x - 7.0, y, z - 2.0), MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x - 7.0, y, z - 2.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x + 7.0, y, z - 2.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x + 7.0, y, z + 2.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x - 7.0, y, z + 2.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x - 2.0, y, z + 7.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x + 2.0, y, z + 7.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x + 2.0, y, z - 7.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x - 2.0, y, z - 7.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x - 6.0, y, z - 3.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x + 6.0, y, z - 3.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x + 6.0, y, z + 3.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x - 6.0, y, z + 3.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x - 8.0, y, z + 1.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x + 8.0, y, z + 1.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x + 8.0, y, z - 1.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x - 8.0, y, z - 1.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x - 1.0, y, z - 8.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x + 1.0, y, z - 8.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x + 1.0, y, z + 8.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x - 1.0, y, z + 8.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x - 6.0, y, z + 3.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x + 6.0, y, z + 3.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x + 6.0, y, z - 3.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x - 6.0, y, z - 3.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x + 3.0, y, z - 6.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x - 3.0, y, z + 6.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x + 3.0, y, z + 6.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x - 3.0, y, z - 6.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x - 5.0, y, z - 4.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x + 5.0, y, z - 4.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x - 5.0, y, z + 4.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x + 5.0, y, z + 4.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x - 4.0, y, z - 5.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x - 4.0, y, z + 5.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                               )
                                                             {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x + 4.0, y, z - 5.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }

                                                            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                               )
                                                             {
                                                               Entity entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = ((EntityType)ArphexModEntities.BLOCK_TEST
                                                                     .get())
                                                                  .spawn(
                                                                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                                                     BlockPos.containing(x + 4.0, y, z + 5.0),
                                                                     MobSpawnType.MOB_SUMMONED
                                                                  );
                                                               if (entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                  != null) {
                                                                  entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setDeltaMovement(
                                                                     0.0, 0.0, 0.0
                                                                  );
                                                               }
                                                            }
                                                         }
                                                      );
                                                   }
                                                );
                                             }
                                          );
                                       }
                                    );
                                 }
                              );
                           }
                        );
                     }
                  );
               }
            );
         }
      );
   }
}
