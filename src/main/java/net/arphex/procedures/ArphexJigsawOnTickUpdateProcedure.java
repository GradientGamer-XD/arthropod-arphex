package net.arphex.procedures;

import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.init.ArphexModBlocks;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class ArphexJigsawOnTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      boolean limitone = false;
      boolean found = false;
      double pitch_variance = 0.0;
      double random_once = 0.0;
      double store_dist = 0.0;
      double distance_scaling_factor = 0.0;
      double yaw_variance = 0.0;
      double sx = 0.0;
      double sy = 0.0;
      double sz = 0.0;
      double store_y_limit = 0.0;
      if (!world.isClientSide() && !(new Object() {
         public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
         }
      }).getValue(world, BlockPos.containing(x, y, z), "done")) {
         if (!world.isClientSide()) {
            BlockPos _bp = BlockPos.containing(x, y, z);
            BlockEntity _blockEntity = world.getBlockEntity(_bp);
            BlockState _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().putBoolean("done", true);
            }

            if (world instanceof Level _level) {
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }

         if ((Boolean)ConfigurationSettingsConfiguration.STRUCTURE_GENERATION.get()) {
            if (world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getBlock() != ArphexModBlocks.ANT_NEST.get()
               && world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getBlock() != ArphexModBlocks.ANT_NEST.get()
               && world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() != ArphexModBlocks.ANT_NEST.get()
               && world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getBlock() != ArphexModBlocks.ANT_NEST.get()) {
               if (world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getBlock() != Blocks.POLISHED_BLACKSTONE
                  && world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getBlock() != Blocks.POLISHED_BLACKSTONE
                  && world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() != Blocks.POLISHED_BLACKSTONE
                  && world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getBlock() != Blocks.POLISHED_BLACKSTONE) {
                  if (world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getBlock() != Blocks.MANGROVE_ROOTS
                     && world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getBlock() != Blocks.MANGROVE_ROOTS
                     && world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() != Blocks.MANGROVE_ROOTS
                     && world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getBlock() != Blocks.MANGROVE_ROOTS) {
                     if (world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getBlock() != Blocks.OBSIDIAN
                        && world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getBlock() != Blocks.OBSIDIAN
                        && world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() != Blocks.OBSIDIAN
                        && world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getBlock() != Blocks.OBSIDIAN) {
                        if (world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getBlock() != Blocks.REINFORCED_DEEPSLATE
                           && world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getBlock() != Blocks.REINFORCED_DEEPSLATE
                           && world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() != Blocks.REINFORCED_DEEPSLATE
                           && world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getBlock() != Blocks.REINFORCED_DEEPSLATE) {
                           if (world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getBlock() != ArphexModBlocks.SILKEN_STONE.get()
                              && world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getBlock() != ArphexModBlocks.SILKEN_STONE.get()
                              && world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() != ArphexModBlocks.SILKEN_STONE.get()
                              && world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getBlock() != ArphexModBlocks.SILKEN_STONE.get()) {
                              world.setBlock(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z + 1.0)), 3);
                           } else {
                              if (!world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("cold_ocean"))
                                 && !world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("deep_cold_ocean"))
                                 && !world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("deep_frozen_ocean"))
                                 && !world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("deep_lukewarm_ocean"))
                                 && !world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("deep_ocean"))
                                 && !world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("frozen_ocean"))
                                 && !world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("lukewarm_ocean"))
                                 && !world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("ocean"))
                                 && !world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("warm_ocean"))) {
                                 if (world instanceof ServerLevel _serverworld) {
                                    StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("arphex", "spider_cave"));
                                    if (template != null) {
                                       template.placeInWorld(
                                          _serverworld,
                                          BlockPos.containing(x - 30.0, 20.0, z - 30.0),
                                          BlockPos.containing(x - 30.0, 20.0, z - 30.0),
                                          new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
                                          _serverworld.random,
                                          3
                                       );
                                    }
                                 }
                              } else if (world instanceof ServerLevel _serverworldx) {
                                 StructureTemplate template = _serverworldx.getStructureManager().getOrCreate(new ResourceLocation("arphex", "spider_cave"));
                                 if (template != null) {
                                    template.placeInWorld(
                                       _serverworldx,
                                       BlockPos.containing(x - 30.0, -20.0, z - 30.0),
                                       BlockPos.containing(x - 30.0, -20.0, z - 30.0),
                                       new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
                                       _serverworldx.random,
                                       3
                                    );
                                 }
                              }

                              if (world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getBlock() == ArphexModBlocks.SILKEN_STONE.get()) {
                                 world.setBlock(BlockPos.containing(x + 1.0, y, z), world.getBlockState(BlockPos.containing(x + 2.0, y, z)), 3);
                              }

                              if (world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getBlock() == ArphexModBlocks.SILKEN_STONE.get()) {
                                 world.setBlock(BlockPos.containing(x - 1.0, y, z), world.getBlockState(BlockPos.containing(x - 2.0, y, z)), 3);
                              }

                              if (world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getBlock() == ArphexModBlocks.SILKEN_STONE.get()) {
                                 world.setBlock(BlockPos.containing(x, y, z - 1.0), world.getBlockState(BlockPos.containing(x, y, z - 2.0)), 3);
                              }

                              if (world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() == ArphexModBlocks.SILKEN_STONE.get()) {
                                 world.setBlock(BlockPos.containing(x, y, z + 1.0), world.getBlockState(BlockPos.containing(x, y, z + 2.0)), 3);
                              }

                              world.setBlock(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z + 2.0)), 3);
                           }
                        } else {
                           if (world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getBlock() == Blocks.REINFORCED_DEEPSLATE) {
                              world.setBlock(BlockPos.containing(x + 1.0, y, z), world.getBlockState(BlockPos.containing(x + 2.0, y, z)), 3);
                           }

                           if (world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getBlock() == Blocks.REINFORCED_DEEPSLATE) {
                              world.setBlock(BlockPos.containing(x - 1.0, y, z), world.getBlockState(BlockPos.containing(x - 2.0, y, z)), 3);
                           }

                           if (world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getBlock() == Blocks.REINFORCED_DEEPSLATE) {
                              world.setBlock(BlockPos.containing(x, y, z - 1.0), world.getBlockState(BlockPos.containing(x, y, z - 2.0)), 3);
                           }

                           if (world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() == Blocks.REINFORCED_DEEPSLATE) {
                              world.setBlock(BlockPos.containing(x, y, z + 1.0), world.getBlockState(BlockPos.containing(x, y, z + 2.0)), 3);
                           }

                           world.setBlock(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z + 2.0)), 3);
                           if ((Boolean)ConfigurationSettingsConfiguration.CRAWLING_CASTLE_SURFACE.get()
                              && !(
                                 world.getBlockState(
                                       BlockPos.containing(
                                          x + 10.0, (double)(world.getHeight(Types.MOTION_BLOCKING, Mth.floor(x + 10.0), Mth.floor(z + 2.0)) - 2), z + 2.0
                                       )
                                    )
                                    .getBlock() instanceof LiquidBlock
                              )
                              && (
                                 !((double)world.getLevelData().getZSpawn() < x + 100.0)
                                    || !((double)world.getLevelData().getZSpawn() > x - 230.0)
                                    || !((double)world.getLevelData().getZSpawn() < z + 100.0)
                                    || !((double)world.getLevelData().getZSpawn() > z - 230.0)
                              )) {
                              store_y_limit = (double)(world.getHeight(Types.MOTION_BLOCKING, Mth.floor(x + 10.0), Mth.floor(z + 2.0)) - 1);
                              if (world instanceof ServerLevel _serverworldxx) {
                                 StructureTemplate template = _serverworldxx.getStructureManager()
                                    .getOrCreate(new ResourceLocation("arphex", "crawling_castle_portal"));
                                 if (template != null) {
                                    template.placeInWorld(
                                       _serverworldxx,
                                       BlockPos.containing(x - 50.0, store_y_limit + 1.0, z - 50.0),
                                       BlockPos.containing(x - 50.0, store_y_limit + 1.0, z - 50.0),
                                       new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
                                       _serverworldxx.random,
                                       3
                                    );
                                 }
                              }

                              sx = x - 44.0;

                              for (int index0 = 0; index0 < 108; index0++) {
                                 sz = z - 50.0;

                                 for (int index1 = 0; index1 < 105; index1++) {
                                    if (world.getBlockState(BlockPos.containing(sx, store_y_limit + 1.0, sz)).canOcclude()
                                       && !world.getBlockState(BlockPos.containing(sx, store_y_limit, sz)).canOcclude()) {
                                       world.setBlock(
                                          BlockPos.containing(sx, store_y_limit, sz),
                                          ((Block)ArphexModBlocks.STRUCTURE_FILL_BLOCK.get()).defaultBlockState(),
                                          3
                                       );
                                    }

                                    sz++;
                                 }

                                 sx++;
                              }
                           } else if (world instanceof ServerLevel _serverworldxxx) {
                              StructureTemplate template = _serverworldxxx.getStructureManager()
                                 .getOrCreate(new ResourceLocation("arphex", "crawling_castle_portal"));
                              if (template != null) {
                                 template.placeInWorld(
                                    _serverworldxxx,
                                    BlockPos.containing(x - 50.0, (double)Mth.nextInt(RandomSource.create(), -40, 20), z - 50.0),
                                    BlockPos.containing(x - 50.0, (double)Mth.nextInt(RandomSource.create(), -40, 20), z - 50.0),
                                    new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
                                    _serverworldxxx.random,
                                    3
                                 );
                              }
                           }

                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "kill @e[type=arphex:dungeon_trigger,distance=..5]"
                                 );
                           }
                        }
                     } else {
                        if (world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getBlock() == Blocks.OBSIDIAN) {
                           if (world.getBlockState(BlockPos.containing(x + 2.0, y, z)).getBlock() == ArphexModBlocks.CRAWLING_BARRIER.get()) {
                              world.setBlock(BlockPos.containing(x + 1.0, y, z), ((Block)ArphexModBlocks.CRAWLING_BARRIER.get()).defaultBlockState(), 3);
                           } else {
                              world.setBlock(BlockPos.containing(x + 1.0, y, z), Blocks.AIR.defaultBlockState(), 3);
                           }
                        }

                        if (world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getBlock() == Blocks.OBSIDIAN) {
                           if (world.getBlockState(BlockPos.containing(x - 2.0, y, z)).getBlock() == ArphexModBlocks.CRAWLING_BARRIER.get()) {
                              world.setBlock(BlockPos.containing(x - 1.0, y, z), ((Block)ArphexModBlocks.CRAWLING_BARRIER.get()).defaultBlockState(), 3);
                           } else {
                              world.setBlock(BlockPos.containing(x - 1.0, y, z), Blocks.AIR.defaultBlockState(), 3);
                           }
                        }

                        if (world.getBlockState(BlockPos.containing(x - 2.0, y, z)).getBlock() == ArphexModBlocks.CRAWLING_BARRIER.get()) {
                           world.setBlock(BlockPos.containing(x, y, z), ((Block)ArphexModBlocks.CRAWLING_BARRIER.get()).defaultBlockState(), 3);
                        } else {
                           world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
                        }

                        if (world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getBlock() == Blocks.OBSIDIAN) {
                           if (world.getBlockState(BlockPos.containing(x, y, z - 2.0)).getBlock() == ArphexModBlocks.CRAWLING_BARRIER.get()) {
                              world.setBlock(BlockPos.containing(x, y, z - 1.0), ((Block)ArphexModBlocks.CRAWLING_BARRIER.get()).defaultBlockState(), 3);
                           } else {
                              world.setBlock(BlockPos.containing(x, y, z - 1.0), Blocks.AIR.defaultBlockState(), 3);
                           }
                        }

                        if (world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() == Blocks.OBSIDIAN) {
                           if (world.getBlockState(BlockPos.containing(x, y, z + 2.0)).getBlock() == ArphexModBlocks.CRAWLING_BARRIER.get()) {
                              world.setBlock(BlockPos.containing(x, y, z + 1.0), ((Block)ArphexModBlocks.CRAWLING_BARRIER.get()).defaultBlockState(), 3);
                           } else {
                              world.setBlock(BlockPos.containing(x, y, z + 1.0), Blocks.AIR.defaultBlockState(), 3);
                           }
                        }

                        if (world instanceof ServerLevel _serverworldxxxx) {
                           StructureTemplate template = _serverworldxxxx.getStructureManager()
                              .getOrCreate(new ResourceLocation("arphex", "final_layer_dungeon"));
                           if (template != null) {
                              template.placeInWorld(
                                 _serverworldxxxx,
                                 BlockPos.containing(x - 19.0, 40.0, z - 16.0),
                                 BlockPos.containing(x - 19.0, 40.0, z - 16.0),
                                 new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
                                 _serverworldxxxx.random,
                                 3
                              );
                           }
                        }

                        if (world instanceof ServerLevel _level) {
                           _level.getServer()
                              .getCommands()
                              .performPrefixedCommand(
                                 new CommandSourceStack(
                                       CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                    )
                                    .withSuppressedOutput(),
                                 "kill @e[type=arphex:dungeon_trigger,distance=..5]"
                              );
                        }
                     }
                  } else {
                     if (world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getBlock() == Blocks.MANGROVE_ROOTS) {
                        if (world.getBlockState(BlockPos.containing(x + 2.0, y, z)).getBlock() == ArphexModBlocks.CRAWLING_BARRIER.get()) {
                           world.setBlock(BlockPos.containing(x + 1.0, y, z), ((Block)ArphexModBlocks.CRAWLING_BARRIER.get()).defaultBlockState(), 3);
                        } else {
                           world.setBlock(BlockPos.containing(x + 1.0, y, z), Blocks.AIR.defaultBlockState(), 3);
                        }
                     }

                     if (world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getBlock() == Blocks.MANGROVE_ROOTS) {
                        if (world.getBlockState(BlockPos.containing(x - 2.0, y, z)).getBlock() == ArphexModBlocks.CRAWLING_BARRIER.get()) {
                           world.setBlock(BlockPos.containing(x - 1.0, y, z), ((Block)ArphexModBlocks.CRAWLING_BARRIER.get()).defaultBlockState(), 3);
                        } else {
                           world.setBlock(BlockPos.containing(x - 1.0, y, z), Blocks.AIR.defaultBlockState(), 3);
                        }
                     }

                     if (world.getBlockState(BlockPos.containing(x - 2.0, y, z)).getBlock() == ArphexModBlocks.CRAWLING_BARRIER.get()) {
                        world.setBlock(BlockPos.containing(x, y, z), ((Block)ArphexModBlocks.CRAWLING_BARRIER.get()).defaultBlockState(), 3);
                     } else {
                        world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
                     }

                     if (world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getBlock() == Blocks.MANGROVE_ROOTS) {
                        if (world.getBlockState(BlockPos.containing(x, y, z - 2.0)).getBlock() == ArphexModBlocks.CRAWLING_BARRIER.get()) {
                           world.setBlock(BlockPos.containing(x, y, z - 1.0), ((Block)ArphexModBlocks.CRAWLING_BARRIER.get()).defaultBlockState(), 3);
                        } else {
                           world.setBlock(BlockPos.containing(x, y, z - 1.0), Blocks.AIR.defaultBlockState(), 3);
                        }
                     }

                     if (world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() == Blocks.MANGROVE_ROOTS) {
                        if (world.getBlockState(BlockPos.containing(x, y, z + 2.0)).getBlock() == ArphexModBlocks.CRAWLING_BARRIER.get()) {
                           world.setBlock(BlockPos.containing(x, y, z + 1.0), ((Block)ArphexModBlocks.CRAWLING_BARRIER.get()).defaultBlockState(), 3);
                        } else {
                           world.setBlock(BlockPos.containing(x, y, z + 1.0), Blocks.AIR.defaultBlockState(), 3);
                        }
                     }

                     if (Math.abs(x) > 50.0 && Math.abs(z) > 50.0) {
                        if (world instanceof ServerLevel _serverworldxxxxx) {
                           StructureTemplate template = _serverworldxxxxx.getStructureManager().getOrCreate(new ResourceLocation("arphex", "layer_one_bypass"));
                           if (template != null) {
                              template.placeInWorld(
                                 _serverworldxxxxx,
                                 BlockPos.containing(x - 19.0, 210.0, z - 16.0),
                                 BlockPos.containing(x - 19.0, 210.0, z - 16.0),
                                 new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
                                 _serverworldxxxxx.random,
                                 3
                              );
                           }
                        }
                     } else if (world instanceof ServerLevel _serverworldxxxxxx) {
                        StructureTemplate template = _serverworldxxxxxx.getStructureManager().getOrCreate(new ResourceLocation("arphex", "layer_one_bypass"));
                        if (template != null) {
                           template.placeInWorld(
                              _serverworldxxxxxx,
                              BlockPos.containing(x - 160.0, 210.0, z - 130.0),
                              BlockPos.containing(x - 160.0, 210.0, z - 130.0),
                              new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
                              _serverworldxxxxxx.random,
                              3
                           );
                        }
                     }

                     if (world instanceof ServerLevel _level) {
                        _level.getServer()
                           .getCommands()
                           .performPrefixedCommand(
                              new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                 )
                                 .withSuppressedOutput(),
                              "kill @e[type=arphex:dungeon_trigger,distance=..5]"
                           );
                     }
                  }
               } else {
                  if (world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getBlock() == Blocks.POLISHED_BLACKSTONE) {
                     if (world.getBlockState(BlockPos.containing(x + 2.0, y, z)).getBlock() == ArphexModBlocks.CRAWLING_BARRIER.get()) {
                        world.setBlock(BlockPos.containing(x + 1.0, y, z), ((Block)ArphexModBlocks.CRAWLING_BARRIER.get()).defaultBlockState(), 3);
                     } else {
                        world.setBlock(BlockPos.containing(x + 1.0, y, z), Blocks.AIR.defaultBlockState(), 3);
                     }
                  }

                  if (world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getBlock() == Blocks.POLISHED_BLACKSTONE) {
                     if (world.getBlockState(BlockPos.containing(x - 2.0, y, z)).getBlock() == ArphexModBlocks.CRAWLING_BARRIER.get()) {
                        world.setBlock(BlockPos.containing(x - 1.0, y, z), ((Block)ArphexModBlocks.CRAWLING_BARRIER.get()).defaultBlockState(), 3);
                     } else {
                        world.setBlock(BlockPos.containing(x - 1.0, y, z), Blocks.AIR.defaultBlockState(), 3);
                     }
                  }

                  if (world.getBlockState(BlockPos.containing(x - 2.0, y, z)).getBlock() == ArphexModBlocks.CRAWLING_BARRIER.get()) {
                     world.setBlock(BlockPos.containing(x, y, z), ((Block)ArphexModBlocks.CRAWLING_BARRIER.get()).defaultBlockState(), 3);
                  } else {
                     world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
                  }

                  if (world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getBlock() == Blocks.POLISHED_BLACKSTONE) {
                     if (world.getBlockState(BlockPos.containing(x, y, z - 2.0)).getBlock() == ArphexModBlocks.CRAWLING_BARRIER.get()) {
                        world.setBlock(BlockPos.containing(x, y, z - 1.0), ((Block)ArphexModBlocks.CRAWLING_BARRIER.get()).defaultBlockState(), 3);
                     } else {
                        world.setBlock(BlockPos.containing(x, y, z - 1.0), Blocks.AIR.defaultBlockState(), 3);
                     }
                  }

                  if (world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() == Blocks.POLISHED_BLACKSTONE) {
                     if (world.getBlockState(BlockPos.containing(x, y, z + 2.0)).getBlock() == ArphexModBlocks.CRAWLING_BARRIER.get()) {
                        world.setBlock(BlockPos.containing(x, y, z + 1.0), ((Block)ArphexModBlocks.CRAWLING_BARRIER.get()).defaultBlockState(), 3);
                     } else {
                        world.setBlock(BlockPos.containing(x, y, z + 1.0), Blocks.AIR.defaultBlockState(), 3);
                     }
                  }

                  if (world instanceof ServerLevel _serverworldxxxxxxx) {
                     StructureTemplate template = _serverworldxxxxxxx.getStructureManager()
                        .getOrCreate(new ResourceLocation("arphex", "cryptic_building_giant"));
                     if (template != null) {
                        template.placeInWorld(
                           _serverworldxxxxxxx,
                           BlockPos.containing(x - 19.0, 110.0, z - 16.0),
                           BlockPos.containing(x - 19.0, 110.0, z - 16.0),
                           new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
                           _serverworldxxxxxxx.random,
                           3
                        );
                     }
                  }

                  if (world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "kill @e[type=arphex:dungeon_trigger,distance=..5]"
                        );
                  }
               }
            } else if (!(world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getBlock() instanceof LiquidBlock)
               && !(world.getBlockState(BlockPos.containing(x + 1.0, y, z + 1.0)).getBlock() instanceof LiquidBlock)
               && !(world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() instanceof LiquidBlock)) {
               world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
               if (world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getBlock() == Blocks.DIRT
                  || world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getBlock() == ArphexModBlocks.ANT_NEST.get()) {
                  world.setBlock(BlockPos.containing(x + 1.0, y, z), Blocks.AIR.defaultBlockState(), 3);
               }

               if (world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getBlock() == Blocks.DIRT
                  || world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getBlock() == ArphexModBlocks.ANT_NEST.get()) {
                  world.setBlock(BlockPos.containing(x - 1.0, y, z), Blocks.AIR.defaultBlockState(), 3);
               }

               if (world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getBlock() == Blocks.DIRT
                  || world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getBlock() == ArphexModBlocks.ANT_NEST.get()) {
                  world.setBlock(BlockPos.containing(x, y, z - 1.0), Blocks.AIR.defaultBlockState(), 3);
               }

               if (world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() == Blocks.DIRT
                  || world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() == ArphexModBlocks.ANT_NEST.get()) {
                  world.setBlock(BlockPos.containing(x, y, z + 1.0), Blocks.AIR.defaultBlockState(), 3);
               }

               if (world instanceof ServerLevel _serverworldxxxxxxxx) {
                  StructureTemplate template = _serverworldxxxxxxxx.getStructureManager().getOrCreate(new ResourceLocation("arphex", "anthill_upside"));
                  if (template != null) {
                     template.placeInWorld(
                        _serverworldxxxxxxxx,
                        BlockPos.containing(x - 9.0, y - 0.0, z - 9.0),
                        BlockPos.containing(x - 9.0, y - 0.0, z - 9.0),
                        new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
                        _serverworldxxxxxxxx.random,
                        3
                     );
                  }
               }

               if (world instanceof ServerLevel _serverworldxxxxxxxxx) {
                  StructureTemplate template = _serverworldxxxxxxxxx.getStructureManager().getOrCreate(new ResourceLocation("arphex", "anthill_undervoid"));
                  if (template != null) {
                     template.placeInWorld(
                        _serverworldxxxxxxxxx,
                        BlockPos.containing(x - 9.0, y - 48.0, z - 9.0),
                        BlockPos.containing(x - 9.0, y - 48.0, z - 9.0),
                        new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
                        _serverworldxxxxxxxxx.random,
                        3
                     );
                  }
               }

               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                           .withSuppressedOutput(),
                        "kill @e[type=arphex:dungeon_trigger,distance=..5]"
                     );
               }
            } else {
               world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
               if (world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getBlock() == Blocks.DIRT
                  || world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getBlock() == ArphexModBlocks.ANT_NEST.get()) {
                  world.setBlock(BlockPos.containing(x + 1.0, y, z), Blocks.AIR.defaultBlockState(), 3);
               }

               if (world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getBlock() == Blocks.DIRT
                  || world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getBlock() == ArphexModBlocks.ANT_NEST.get()) {
                  world.setBlock(BlockPos.containing(x - 1.0, y, z), Blocks.AIR.defaultBlockState(), 3);
               }

               if (world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getBlock() == Blocks.DIRT
                  || world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getBlock() == ArphexModBlocks.ANT_NEST.get()) {
                  world.setBlock(BlockPos.containing(x, y, z - 1.0), Blocks.AIR.defaultBlockState(), 3);
               }

               if (world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() == Blocks.DIRT
                  || world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() == ArphexModBlocks.ANT_NEST.get()) {
                  world.setBlock(BlockPos.containing(x, y, z + 1.0), Blocks.AIR.defaultBlockState(), 3);
               }
            }
         } else {
            world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
         }
      }
   }
}
