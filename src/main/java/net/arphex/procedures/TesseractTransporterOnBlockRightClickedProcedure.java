package net.arphex.procedures;

import net.arphex.init.ArphexModBlocks;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class TesseractTransporterOnBlockRightClickedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double minimum_met = 0.0;
         minimum_met = 0.0;
         if (world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getBlock() == Blocks.POLISHED_BLACKSTONE) {
            minimum_met++;
         }

         if (world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getBlock() == Blocks.POLISHED_BLACKSTONE) {
            minimum_met++;
         }

         if (world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() == Blocks.POLISHED_BLACKSTONE) {
            minimum_met++;
         }

         if (world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getBlock() == Blocks.POLISHED_BLACKSTONE) {
            minimum_met++;
         }

         if (minimum_met >= 3.0) {
            minimum_met = 0.0;
            if (world.getBlockState(BlockPos.containing(x + 1.0, y + 1.0, z)).getBlock() == ArphexModBlocks.SCORCHED_GLASS.get()) {
               minimum_met++;
            }

            if (world.getBlockState(BlockPos.containing(x - 1.0, y + 1.0, z)).getBlock() == ArphexModBlocks.SCORCHED_GLASS.get()) {
               minimum_met++;
            }

            if (world.getBlockState(BlockPos.containing(x, y + 1.0, z + 1.0)).getBlock() == ArphexModBlocks.SCORCHED_GLASS.get()) {
               minimum_met++;
            }

            if (world.getBlockState(BlockPos.containing(x, y + 1.0, z - 1.0)).getBlock() == ArphexModBlocks.SCORCHED_GLASS.get()) {
               minimum_met++;
            }
         }

         if (minimum_met >= 3.0) {
            minimum_met = 0.0;
            if (world.getBlockState(BlockPos.containing(x + 1.0, y + 2.0, z)).getBlock() == ArphexModBlocks.SCORCHED_GLASS.get()) {
               minimum_met++;
            }

            if (world.getBlockState(BlockPos.containing(x - 1.0, y + 2.0, z)).getBlock() == ArphexModBlocks.SCORCHED_GLASS.get()) {
               minimum_met++;
            }

            if (world.getBlockState(BlockPos.containing(x, y + 2.0, z + 1.0)).getBlock() == ArphexModBlocks.SCORCHED_GLASS.get()) {
               minimum_met++;
            }

            if (world.getBlockState(BlockPos.containing(x, y + 2.0, z - 1.0)).getBlock() == ArphexModBlocks.SCORCHED_GLASS.get()) {
               minimum_met++;
            }
         }

         if (minimum_met >= 3.0) {
            if (!world.isClientSide()) {
               BlockPos _bp = BlockPos.containing(x, y, z);
               BlockEntity _blockEntity = world.getBlockEntity(_bp);
               BlockState _bs = world.getBlockState(_bp);
               if (_blockEntity != null) {
                  _blockEntity.getPersistentData().putBoolean("activatedportal", true);
               }

               if (world instanceof Level _level) {
                  _level.sendBlockUpdated(_bp, _bs, _bs, 3);
               }
            }
         } else if (!world.isClientSide()) {
            BlockPos _bpx = BlockPos.containing(x, y, z);
            BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
            BlockState _bsx = world.getBlockState(_bpx);
            if (_blockEntityx != null) {
               _blockEntityx.getPersistentData().putBoolean("activatedportal", false);
            }

            if (world instanceof Level _level) {
               _level.sendBlockUpdated(_bpx, _bsx, _bsx, 3);
            }
         }

         if ((new Object() {
            public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
            }
         }).getValue(world, BlockPos.containing(x, y, z), "activatedportal")) {
            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.WARP_CONNECTOR.get()) {
               if (entity instanceof Player _plrCldCheck30
                  && _plrCldCheck30.getCooldowns()
                     .isOnCooldown((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem())) {
                  return;
               }

               if (entity instanceof Player _player) {
                  _player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem(), 20);
               }

               if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("portal_lock_x") == 0.0) {
                  if (entity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal("Coordinates Added"), true);
                  }

                  if (world instanceof ServerLevel _level) {
                     _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.SCORCH_FLAME.get(), x, y, z, 40, 0.3, 0.3, 0.3, 0.3);
                  }

                  (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                     .getOrCreateTag()
                     .putString(
                        "portal_lock_dimension",
                        (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
                           + ""
                     );
                  (entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY)
                     .getOrCreateTag()
                     .putDouble("portal_lock_x", x + 0.5);
                  (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY)
                     .getOrCreateTag()
                     .putDouble("portal_lock_y", y + 1.0);
                  (entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMainHandItem() : ItemStack.EMPTY)
                     .getOrCreateTag()
                     .putDouble("portal_lock_z", z + 0.5);
               } else if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY)
                        .getOrCreateTag()
                        .getDouble("portal_lock_x")
                     == x + 0.5
                  && (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("portal_lock_y")
                     == y + 1.0
                  && (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("portal_lock_z")
                     == z + 0.5) {
                  if (entity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal("Cannot bind teleporter to itself"), true);
                  }
               } else {
                  if (entity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal("Teleporter Configured Successfully"), true);
                  }

                  if (!world.isClientSide()) {
                     BlockPos _bpxx = BlockPos.containing(x, y, z);
                     BlockEntity _blockEntityxx = world.getBlockEntity(_bpxx);
                     BlockState _bsxx = world.getBlockState(_bpxx);
                     if (_blockEntityxx != null) {
                        _blockEntityxx.getPersistentData()
                           .putString(
                              "portal_lock_dimension",
                              (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY)
                                 .getOrCreateTag()
                                 .getString("portal_lock_dimension")
                           );
                     }

                     if (world instanceof Level _level) {
                        _level.sendBlockUpdated(_bpxx, _bsxx, _bsxx, 3);
                     }
                  }

                  if (!world.isClientSide()) {
                     BlockPos _bpxxx = BlockPos.containing(x, y, z);
                     BlockEntity _blockEntityxxx = world.getBlockEntity(_bpxxx);
                     BlockState _bsxxx = world.getBlockState(_bpxxx);
                     if (_blockEntityxxx != null) {
                        _blockEntityxxx.getPersistentData()
                           .putDouble(
                              "portal_lock_x",
                              (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY)
                                 .getOrCreateTag()
                                 .getDouble("portal_lock_x")
                           );
                     }

                     if (world instanceof Level _level) {
                        _level.sendBlockUpdated(_bpxxx, _bsxxx, _bsxxx, 3);
                     }
                  }

                  if (!world.isClientSide()) {
                     BlockPos _bpxxxx = new BlockPos((int)x, (int)y, (int)z);
                     BlockEntity _blockEntityxxxx = world.getBlockEntity(_bpxxxx);
                     if (_blockEntityxxxx != null) {
                        _blockEntityxxxx.setChanged();
                     }
                  }

                  if (!world.isClientSide()) {
                     BlockPos _bpxxxx = BlockPos.containing(x, y, z);
                     BlockEntity _blockEntityxxxx = world.getBlockEntity(_bpxxxx);
                     BlockState _bsxxxx = world.getBlockState(_bpxxxx);
                     if (_blockEntityxxxx != null) {
                        _blockEntityxxxx.getPersistentData()
                           .putDouble(
                              "portal_lock_y",
                              (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY)
                                 .getOrCreateTag()
                                 .getDouble("portal_lock_y")
                           );
                     }

                     if (world instanceof Level _level) {
                        _level.sendBlockUpdated(_bpxxxx, _bsxxxx, _bsxxxx, 3);
                     }
                  }

                  if (!world.isClientSide()) {
                     BlockPos _bpxxxxx = new BlockPos((int)x, (int)y, (int)z);
                     BlockEntity _blockEntityxxxxx = world.getBlockEntity(_bpxxxxx);
                     if (_blockEntityxxxxx != null) {
                        _blockEntityxxxxx.setChanged();
                     }
                  }

                  if (!world.isClientSide()) {
                     BlockPos _bpxxxxx = BlockPos.containing(x, y, z);
                     BlockEntity _blockEntityxxxxx = world.getBlockEntity(_bpxxxxx);
                     BlockState _bsxxxxx = world.getBlockState(_bpxxxxx);
                     if (_blockEntityxxxxx != null) {
                        _blockEntityxxxxx.getPersistentData()
                           .putDouble(
                              "portal_lock_z",
                              (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY)
                                 .getOrCreateTag()
                                 .getDouble("portal_lock_z")
                           );
                     }

                     if (world instanceof Level _level) {
                        _level.sendBlockUpdated(_bpxxxxx, _bsxxxxx, _bsxxxxx, 3);
                     }
                  }

                  if (!world.isClientSide()) {
                     BlockPos _bpxxxxxx = new BlockPos((int)x, (int)y, (int)z);
                     BlockEntity _blockEntityxxxxxx = world.getBlockEntity(_bpxxxxxx);
                     if (_blockEntityxxxxxx != null) {
                        _blockEntityxxxxxx.setChanged();
                     }
                  }

                  (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY)
                     .getOrCreateTag()
                     .putDouble("portal_lock_x", 0.0);
                  (entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMainHandItem() : ItemStack.EMPTY)
                     .getOrCreateTag()
                     .putDouble("portal_lock_y", 0.0);
                  (entity instanceof LivingEntity _livEntxxxxxx ? _livEntxxxxxx.getMainHandItem() : ItemStack.EMPTY)
                     .getOrCreateTag()
                     .putDouble("portal_lock_z", 0.0);
                  (entity instanceof LivingEntity _livEntxxxxxxx ? _livEntxxxxxxx.getMainHandItem() : ItemStack.EMPTY)
                     .getOrCreateTag()
                     .putString("portal_lock_dimension", "0");
               }
            } else if ((new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0;
               }
            }).getValue(world, BlockPos.containing(x, y, z), "portal_lock_x") == 0.0) {
               if (entity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("No teleporter destination configured (use Warp Connector)"), true);
               }
            } else if (!world.isClientSide()) {
               BlockPos _bpxxxxxx = BlockPos.containing(x, y, z);
               BlockEntity _blockEntityxxxxxx = world.getBlockEntity(_bpxxxxxx);
               BlockState _bsxxxxxx = world.getBlockState(_bpxxxxxx);
               if (_blockEntityxxxxxx != null) {
                  _blockEntityxxxxxx.getPersistentData().putDouble("teleportation_time", 16.0);
               }

               if (world instanceof Level _level) {
                  _level.sendBlockUpdated(_bpxxxxxx, _bsxxxxxx, _bsxxxxxx, 3);
               }
            }
         } else if (entity instanceof Player _player && !_player.level().isClientSide()) {
            _player.displayClientMessage(Component.literal("§cTeleporter structure needs 3 x Polished Blackstone / 6 x Scorched Glass"), true);
         }
      }
   }
}
