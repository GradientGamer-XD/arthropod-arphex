package net.arphex.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Map.Entry;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

public class TemporalTransmitterRightclickedOnBlockProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Direction direction, Entity entity, ItemStack itemstack) {
      if (direction != null && entity != null) {
         double sx = 0.0;
         double sy = 0.0;
         double sz = 0.0;
         double crouchbigger = 0.0;
         double lookoffsetx = 0.0;
         double lookoffsetz = 0.0;
         boolean found = false;
         boolean northsouth = false;
         if (!(Boolean)ConfigurationSettingsConfiguration.ARPHEX_BLOCK_GRIEFING.get()) {
            if (entity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("§cTransmitter block placing abilities have been disabled in config"), true);
            }
         } else if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
               == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))
            && y > 254.0) {
            if (entity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("Cannot use the Temporospatial Transmitter item inside Crawling Containers"), true);
            }
         } else {
            if (entity instanceof Player _plrCldCheck7 && _plrCldCheck7.getCooldowns().isOnCooldown(itemstack.getItem())) {
               return;
            }

            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getCount() <= 1) {
               if (entity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("You need 2+ blocks in offhand to use this item"), true);
               }
            } else {
               if (itemstack.getItem() == (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem()) {
                  if (world instanceof ServerLevel _level) {
                     _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.SMALL_TIME.get(), x, y, z, 5, 0.2, 0.2, 0.2, 0.2);
                  }

                  if (entity instanceof LivingEntity _entity) {
                     _entity.swing(InteractionHand.MAIN_HAND, true);
                  }
               }

               if (itemstack.getOrCreateTag().getDouble("flatmodetemp") == 1.0) {
                  if (entity.getDirection() != Direction.NORTH && entity.getDirection() != Direction.SOUTH) {
                     northsouth = false;
                     if (entity.getDirection() == Direction.EAST) {
                        if (entity.isShiftKeyDown()) {
                           lookoffsetx = 0.0;
                           lookoffsetz = 0.0;
                        } else {
                           lookoffsetx = 0.0;
                           lookoffsetz = 0.0;
                        }
                     } else if (entity.isShiftKeyDown()) {
                        lookoffsetx = 0.0;
                        lookoffsetz = -15.0;
                     } else {
                        lookoffsetx = 0.0;
                        lookoffsetz = -8.0;
                     }
                  } else {
                     northsouth = true;
                     if (entity.getDirection() == Direction.NORTH) {
                        if (entity.isShiftKeyDown()) {
                           lookoffsetx = 0.0;
                           lookoffsetz = 0.0;
                        } else {
                           lookoffsetx = 0.0;
                           lookoffsetz = 0.0;
                        }
                     } else if (entity.isShiftKeyDown()) {
                        lookoffsetx = -15.0;
                        lookoffsetz = 0.0;
                     } else {
                        lookoffsetx = -8.0;
                        lookoffsetz = 0.0;
                     }
                  }

                  if (entity.isShiftKeyDown()) {
                     crouchbigger = 4.0;
                  } else {
                     crouchbigger = 3.0;
                  }

                  sx = lookoffsetx;
                  sz = lookoffsetz;

                  for (int index0 = 0; index0 < (int)Math.pow(crouchbigger, 2.0); index0++) {
                     if (direction == Direction.UP) {
                        sy = 1.0;
                     } else {
                        sy = 0.0;
                     }

                     for (int index1 = 0; index1 < (int)crouchbigger; index1++) {
                        if (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).getBlock() == Blocks.AIR) {
                           if (((entity instanceof LivingEntity _livEntx ? _livEntx.getOffhandItem() : ItemStack.EMPTY).getItem() instanceof BlockItem _bi
                                    ? _bi.getBlock().defaultBlockState()
                                    : Blocks.AIR.defaultBlockState())
                                 .getBlock()
                              == Blocks.AIR) {
                              if (entity instanceof Player _player && !_player.level().isClientSide()) {
                                 _player.displayClientMessage(Component.literal("Ran out of blocks in offhand"), true);
                              }
                           } else {
                              BlockPos _bp = BlockPos.containing(x + sx, y + sy, z + sz);
                              BlockState _bs = (entity instanceof LivingEntity _livEntxx ? _livEntxx.getOffhandItem() : ItemStack.EMPTY).getItem() instanceof BlockItem _bix
                                 ? _bix.getBlock().defaultBlockState()
                                 : Blocks.AIR.defaultBlockState();
                              BlockState _bso = world.getBlockState(_bp);
                              UnmodifiableIterator var77 = _bso.getValues().entrySet().iterator();

                              while (var77.hasNext()) {
                                 Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var77.next();
                                 Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                 if (_property != null && _bs.getValue(_property) != null) {
                                    try {
                                       _bs = (BlockState)_bs.setValue(_property, entry.getValue());
                                    } catch (Exception var43) {
                                    }
                                 }
                              }

                              BlockEntity _be = world.getBlockEntity(_bp);
                              CompoundTag _bnbt = null;
                              if (_be != null) {
                                 _bnbt = _be.saveWithFullMetadata();
                                 _be.setRemoved();
                              }

                              world.setBlock(_bp, _bs, 3);
                              if (_bnbt != null) {
                                 BlockEntity var79 = world.getBlockEntity(_bp);
                                 if (var79 != null) {
                                    try {
                                       var79.load(_bnbt);
                                    } catch (Exception var42) {
                                    }
                                 }
                              }

                              world.addParticle(
                                 (SimpleParticleType)ArphexModParticleTypes.TIME_SPLASH_PARTICLE.get(),
                                 x + 0.5 + sx,
                                 y + 2.5 + sy,
                                 z + 0.5 + sz,
                                 0.0,
                                 -0.5,
                                 0.0
                              );
                              if (!entity.getPersistentData().getBoolean("creativespectator")) {
                                 (entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getOffhandItem() : ItemStack.EMPTY).shrink(1);
                              }
                           }
                        }

                        sy++;
                     }

                     if (northsouth) {
                        sx++;
                     } else {
                        sz++;
                     }
                  }
               } else {
                  if (entity.getDirection() != Direction.NORTH && entity.getDirection() != Direction.SOUTH) {
                     if (entity.getDirection() == Direction.EAST) {
                        if (entity.isShiftKeyDown()) {
                           lookoffsetx = 2.0;
                           lookoffsetz = 1.0;
                        } else {
                           lookoffsetx = 1.0;
                           lookoffsetz = 0.0;
                        }
                     } else if (entity.isShiftKeyDown()) {
                        lookoffsetx = -1.0;
                        lookoffsetz = 0.0;
                     } else {
                        lookoffsetx = -1.0;
                        lookoffsetz = 0.0;
                     }
                  } else if (entity.getDirection() == Direction.NORTH) {
                     if (entity.isShiftKeyDown()) {
                        lookoffsetx = 1.0;
                        lookoffsetz = -1.0;
                     } else {
                        lookoffsetx = 0.0;
                        lookoffsetz = -1.0;
                     }
                  } else if (entity.isShiftKeyDown()) {
                     lookoffsetx = 0.0;
                     lookoffsetz = 2.0;
                  } else {
                     lookoffsetx = 0.0;
                     lookoffsetz = 1.0;
                  }

                  if (entity.isShiftKeyDown()) {
                     crouchbigger = 4.0;
                  } else {
                     crouchbigger = 3.0;
                  }

                  sx = -1.0 + lookoffsetx;
                  if (entity.isShiftKeyDown()) {
                     sx--;
                  }

                  for (int index2 = 0; index2 < (int)crouchbigger; index2++) {
                     if (direction == Direction.UP) {
                        sy = 1.0;
                     } else {
                        sy = 0.0;
                     }

                     for (int index3 = 0; index3 < (int)crouchbigger; index3++) {
                        sz = -1.0 + lookoffsetz;
                        if (entity.isShiftKeyDown()) {
                           sz--;
                        }

                        for (int index4 = 0; index4 < (int)crouchbigger; index4++) {
                           if (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).getBlock() == Blocks.AIR) {
                              if (((entity instanceof LivingEntity _livEntxx ? _livEntxx.getOffhandItem() : ItemStack.EMPTY).getItem() instanceof BlockItem _bix
                                       ? _bix.getBlock().defaultBlockState()
                                       : Blocks.AIR.defaultBlockState())
                                    .getBlock()
                                 == Blocks.AIR) {
                                 if (entity instanceof Player _player && !_player.level().isClientSide()) {
                                    _player.displayClientMessage(Component.literal("Ran out of blocks in offhand"), true);
                                 }
                              } else {
                                 BlockPos _bp = BlockPos.containing(x + sx, y + sy, z + sz);
                                 BlockState _bs = (entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getOffhandItem() : ItemStack.EMPTY).getItem() instanceof BlockItem _bixx
                                    ? _bixx.getBlock().defaultBlockState()
                                    : Blocks.AIR.defaultBlockState();
                                 BlockState _bso = world.getBlockState(_bp);
                                 UnmodifiableIterator var85 = _bso.getValues().entrySet().iterator();

                                 while (var85.hasNext()) {
                                    Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var85.next();
                                    Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                    if (_property != null && _bs.getValue(_property) != null) {
                                       try {
                                          _bs = (BlockState)_bs.setValue(_property, entry.getValue());
                                       } catch (Exception var41) {
                                       }
                                    }
                                 }

                                 BlockEntity _bex = world.getBlockEntity(_bp);
                                 CompoundTag _bnbtx = null;
                                 if (_bex != null) {
                                    _bnbtx = _bex.saveWithFullMetadata();
                                    _bex.setRemoved();
                                 }

                                 world.setBlock(_bp, _bs, 3);
                                 if (_bnbtx != null) {
                                    BlockEntity var87 = world.getBlockEntity(_bp);
                                    if (var87 != null) {
                                       try {
                                          var87.load(_bnbtx);
                                       } catch (Exception var40) {
                                       }
                                    }
                                 }

                                 world.addParticle(
                                    (SimpleParticleType)ArphexModParticleTypes.TIME_SPLASH_PARTICLE.get(),
                                    x + 0.5 + sx,
                                    y + 2.5 + sy,
                                    z + 0.5 + sz,
                                    0.0,
                                    -0.5,
                                    0.0
                                 );
                                 if (!entity.getPersistentData().getBoolean("creativespectator")) {
                                    (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getOffhandItem() : ItemStack.EMPTY).shrink(1);
                                 }
                              }
                           }

                           sz++;
                        }

                        sy++;
                     }

                     sx++;
                  }
               }
            }
         }
      }
   }
}
