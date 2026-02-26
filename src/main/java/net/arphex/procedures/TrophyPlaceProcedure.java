package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.init.ArphexModBlocks;
import net.arphex.init.ArphexModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraftforge.registries.ForgeRegistries;

public class TrophyPlaceProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Direction direction, Entity entity, ItemStack itemstack) {
      if (direction != null && entity != null) {
         if (!world.isClientSide()) {
            if (!itemstack.getOrCreateTag().getString("trophy_entity").equals(itemstack.getOrCreateTag().getString("trophy_entity").strip())) {
               itemstack.getOrCreateTag().putString("trophy_entity", itemstack.getOrCreateTag().getString("trophy_entity").strip());
            }

            if (entity.getPersistentData().getBoolean("creativespectator")
               && itemstack.getOrCreateTag().getString("trophy_entity").length() <= 1
               && entity instanceof Player _player
               && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("No mob is bound to the trophy. Right click any mob to bind it"), true);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").equals("spider_lunger")) {
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.23);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").equals("tormentor")) {
               itemstack.getOrCreateTag().putString("trophy_entity", "tormentor_test");
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 80.0);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").equals("spider_reaper")) {
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.13);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").equals("spider_matriarch")) {
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.09);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").equals("crab_constrictor")) {
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.09);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").equals("arachnoid_trisector")) {
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.09);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").equals("roach_riverspawn")) {
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.6);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").equals("scorpioid_bloodluster")) {
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.2);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").equals("arthropleura_abomination")) {
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.28);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").equals("wasp_nemesis")) {
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.15);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").equals("solifuge_skulker")) {
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.25);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").equals("spider_infestor")) {
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.13);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").contains("long_legs")) {
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.7);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").strip().equals("long_legs_fly")) {
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.7);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").strip().equals("millipede_marauder")) {
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.3);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").strip().equals("ant_arsonist_soldier")) {
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.25);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").strip().equals("ant_arsonist_alate_queen")) {
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.3);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").strip().equals("centipede_evictor_larvae")) {
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.3);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").strip().equals("termite_tunneler_worker")) {
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.25);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").strip().equals("termite_tunneler_soldier")) {
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.25);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").strip().equals("termite_tunneler_queen")) {
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.33);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").strip().equals("termite_tunneler_king")) {
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.16);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").strip().equals("termite_tunneler_alate")) {
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.2);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").strip().equals("scorpion_striker")) {
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.3);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").strip().equals("spider_recluse")) {
               itemstack.getOrCreateTag().putString("trophy_entity", "spider_recluse_display");
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.27);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").strip().equals("spider_obstructer")) {
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.3);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").strip().equals("spider_funnel")) {
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.3);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").strip().equals("spider_ambusher")) {
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.2);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").strip().equals("dragonfly_dreadnought")) {
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.2);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").strip().equals("mantis_mutilator")) {
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.17);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").strip().equals("tamed_tarantula")) {
               itemstack.getOrCreateTag().putString("trophy_entity", "spider_goliath");
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").strip().equals("spider_moth")) {
               itemstack.getOrCreateTag().putString("trophy_entity", "pure_stalking");
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.27);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").strip().equals("hitbox_expander")) {
               itemstack.getOrCreateTag().putString("trophy_entity", "pure_stalking");
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.27);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").strip().equals("tormentor_voidlasher_summon")) {
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.03);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").strip().equals("tormentor_scorpioid_summon")) {
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.061);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").strip().equals("tormentor_moth_summon")) {
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.041);
            }

            if (itemstack.getOrCreateTag().getString("trophy_entity").strip().equals("diabolos_decimator")) {
               itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.065);
            }

            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.TROPHY_ITEM.get()) {
               if ((double)world.getBlockState(BlockPos.containing(x, y, z)).getDestroySpeed(world, BlockPos.containing(x, y, z)) > 0.2
                     && world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()
                  || blockstate.getBlock() == ArphexModBlocks.CRAWLING_BARRIER.get()) {
                  if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                        .getOrCreateTag()
                        .getString("trophy_entity")
                        .length()
                     > 1) {
                     if (direction == Direction.UP && world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z))) {
                        world.setBlock(BlockPos.containing(x, y + 1.0, z), ((Block)ArphexModBlocks.MOB_TROPHY.get()).defaultBlockState(), 3);
                        label201:
                        if (entity.getDirection() == Direction.SOUTH) {
                           Direction _dir = Direction.NORTH;
                           BlockPos _pos = BlockPos.containing(x, y + 1.0, z);
                           BlockState _bs = world.getBlockState(_pos);
                           if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof DirectionProperty _dp
                              && _dp.getPossibleValues().contains(_dir)) {
                              world.setBlock(_pos, (BlockState)_bs.setValue(_dp, _dir), 3);
                              break label201;
                           }

                           if (_bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap
                              && _ap.getPossibleValues().contains(_dir.getAxis())) {
                              world.setBlock(_pos, (BlockState)_bs.setValue(_ap, _dir.getAxis()), 3);
                           }
                        } else {
                           label199:
                           if (entity.getDirection() == Direction.NORTH) {
                              Direction _dirx = Direction.SOUTH;
                              BlockPos _posx = BlockPos.containing(x, y + 1.0, z);
                              BlockState _bsx = world.getBlockState(_posx);
                              if (_bsx.getBlock().getStateDefinition().getProperty("facing") instanceof DirectionProperty _dp
                                 && _dp.getPossibleValues().contains(_dirx)) {
                                 world.setBlock(_posx, (BlockState)_bsx.setValue(_dp, _dirx), 3);
                                 break label199;
                              }

                              if (_bsx.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap
                                 && _ap.getPossibleValues().contains(_dirx.getAxis())) {
                                 world.setBlock(_posx, (BlockState)_bsx.setValue(_ap, _dirx.getAxis()), 3);
                              }
                           } else {
                              label197:
                              if (entity.getDirection() == Direction.WEST) {
                                 Direction _dirxx = Direction.EAST;
                                 BlockPos _posxx = BlockPos.containing(x, y + 1.0, z);
                                 BlockState _bsxx = world.getBlockState(_posxx);
                                 if (_bsxx.getBlock().getStateDefinition().getProperty("facing") instanceof DirectionProperty _dp
                                    && _dp.getPossibleValues().contains(_dirxx)) {
                                    world.setBlock(_posxx, (BlockState)_bsxx.setValue(_dp, _dirxx), 3);
                                    break label197;
                                 }

                                 if (_bsxx.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap
                                    && _ap.getPossibleValues().contains(_dirxx.getAxis())) {
                                    world.setBlock(_posxx, (BlockState)_bsxx.setValue(_ap, _dirxx.getAxis()), 3);
                                 }
                              } else {
                                 label287: {
                                    Direction _dirxxx = Direction.WEST;
                                    BlockPos _posxxx = BlockPos.containing(x, y + 1.0, z);
                                    BlockState _bsxxx = world.getBlockState(_posxxx);
                                    if (_bsxxx.getBlock().getStateDefinition().getProperty("facing") instanceof DirectionProperty _dp
                                       && _dp.getPossibleValues().contains(_dirxxx)) {
                                       world.setBlock(_posxxx, (BlockState)_bsxxx.setValue(_dp, _dirxxx), 3);
                                       break label287;
                                    }

                                    if (_bsxxx.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap
                                       && _ap.getPossibleValues().contains(_dirxxx.getAxis())) {
                                       world.setBlock(_posxxx, (BlockState)_bsxxx.setValue(_ap, _dirxxx.getAxis()), 3);
                                    }
                                 }
                              }
                           }
                        }

                        if (world instanceof Level _level) {
                           if (!_level.isClientSide()) {
                              _level.playSound(
                                 null,
                                 BlockPos.containing(x, y, z),
                                 (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")),
                                 SoundSource.NEUTRAL,
                                 0.5F,
                                 0.5F
                              );
                           } else {
                              _level.playLocalSound(
                                 x,
                                 y,
                                 z,
                                 (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")),
                                 SoundSource.NEUTRAL,
                                 0.5F,
                                 0.5F,
                                 false
                              );
                           }
                        }

                        ArphexMod.queueServerWork(
                           1,
                           () -> {
                              if (!world.isClientSide()
                                 && (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                                    == ArphexModItems.TROPHY_ITEM.get()
                                 && world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getBlock() == ArphexModBlocks.MOB_TROPHY.get()) {
                                 if (!world.isClientSide()) {
                                    BlockPos _bp = BlockPos.containing(x, y + 1.0, z);
                                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                                    BlockState _bsxxxx = world.getBlockState(_bp);
                                    if (_blockEntity != null) {
                                       _blockEntity.getPersistentData()
                                          .putString(
                                             "trophy_entity",
                                             (entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY)
                                                .getOrCreateTag()
                                                .getString("trophy_entity")
                                          );
                                    }

                                    if (world instanceof Level _levelx) {
                                       _levelx.sendBlockUpdated(_bp, _bsxxxx, _bsxxxx, 3);
                                    }
                                 }

                                 if (!world.isClientSide()) {
                                    BlockPos _bpx = BlockPos.containing(x, y + 1.0, z);
                                    BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
                                    BlockState _bsxxxxx = world.getBlockState(_bpx);
                                    if (_blockEntityx != null) {
                                       _blockEntityx.getPersistentData()
                                          .putString(
                                             "saved_name",
                                             (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                                                .getDisplayName()
                                                .getString()
                                          );
                                    }

                                    if (world instanceof Level _levelx) {
                                       _levelx.sendBlockUpdated(_bpx, _bsxxxxx, _bsxxxxx, 3);
                                    }
                                 }

                                 if (!world.isClientSide()) {
                                    BlockPos _bpxx = BlockPos.containing(x, y + 1.0, z);
                                    BlockEntity _blockEntityxx = world.getBlockEntity(_bpxx);
                                    BlockState _bsxxxxxx = world.getBlockState(_bpxx);
                                    if (_blockEntityxx != null) {
                                       _blockEntityxx.getPersistentData()
                                          .putDouble(
                                             "trophy_entity_size",
                                             (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                                                .getOrCreateTag()
                                                .getDouble("trophy_entity_size")
                                          );
                                    }

                                    if (world instanceof Level _levelx) {
                                       _levelx.sendBlockUpdated(_bpxx, _bsxxxxxx, _bsxxxxxx, 3);
                                    }
                                 }

                                 if (!world.isClientSide()) {
                                    BlockPos _bpxxx = BlockPos.containing(x, y + 1.0, z);
                                    BlockEntity _blockEntityxxx = world.getBlockEntity(_bpxxx);
                                    BlockState _bsxxxxxxx = world.getBlockState(_bpxxx);
                                    if (_blockEntityxxx != null) {
                                       _blockEntityxxx.getPersistentData()
                                          .putDouble(
                                             "milestone_number",
                                             (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                                                .getOrCreateTag()
                                                .getDouble("milestone_number")
                                          );
                                    }

                                    if (world instanceof Level _levelx) {
                                       _levelx.sendBlockUpdated(_bpxxx, _bsxxxxxxx, _bsxxxxxxx, 3);
                                    }
                                 }

                                 if (!entity.getPersistentData().getBoolean("creativespectator")) {
                                    itemstack.shrink(1);
                                 }
                              }
                           }
                        );
                     }
                  } else if (entity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal("No mob is bound to the trophy"), true);
                  }
               }
            } else if (entity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("Trophies can only be placed from main hand"), true);
            }
         }
      }
   }
}
