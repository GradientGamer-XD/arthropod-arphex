package net.arphex.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Comparator;
import java.util.Map.Entry;
import net.arphex.entity.SpiderFunnelEntity;
import net.arphex.init.ArphexModBlocks;
import net.arphex.init.ArphexModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class FunnelWebOnTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (!world.isClientSide()) {
         if ((new Object() {
            public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
            }
         }).getValue(world, BlockPos.containing(x, y, z), "spawned_funnel")) {
            if (world.getEntitiesOfClass(SpiderFunnelEntity.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()
               && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ArphexModBlocks.FUNNEL_WEB.get()) {
               BlockPos _bp = BlockPos.containing(x, y, z);
               BlockState _bs = Blocks.GRASS_BLOCK.defaultBlockState();
               BlockState _bso = world.getBlockState(_bp);
               UnmodifiableIterator _level = _bso.getValues().entrySet().iterator();

               while (_level.hasNext()) {
                  Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)_level.next();
                  Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                  if (_property != null && _bs.getValue(_property) != null) {
                     try {
                        _bs = (BlockState)_bs.setValue(_property, entry.getValue());
                     } catch (Exception var15) {
                     }
                  }
               }

               world.setBlock(_bp, _bs, 3);
            }
         } else {
            if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 14.0, 14.0, 14.0), e -> true).isEmpty()) {
               Vec3 _center = new Vec3(x, y, z);

               for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(7.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiterator instanceof Player
                     && !entityiterator.getPersistentData().getBoolean("creativespectator")
                     && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ArphexModBlocks.FUNNEL_WEB.get()) {
                     if (world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z)) && world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_FUNNEL.get())
                           .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.5, 0.0, 0.0);
                        }
                     }

                     if (!world.isClientSide()) {
                        BlockPos _bp = BlockPos.containing(x, y, z);
                        BlockEntity _blockEntity = world.getBlockEntity(_bp);
                        BlockState _bs = world.getBlockState(_bp);
                        if (_blockEntity != null) {
                           _blockEntity.getPersistentData().putBoolean("spawned_funnel", true);
                        }

                        if (world instanceof Level _level) {
                           _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                        }
                     }
                  }
               }
            }

            if (world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getBlock() != Blocks.GRASS_BLOCK) {
               if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ArphexModBlocks.FUNNEL_WEB.get()) {
                  if (world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z)) && world instanceof ServerLevel _level) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_FUNNEL.get())
                        .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.5, 0.0, 0.0);
                     }
                  }

                  if (!world.isClientSide()) {
                     BlockPos _bpx = BlockPos.containing(x, y, z);
                     BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
                     BlockState _bsx = world.getBlockState(_bpx);
                     if (_blockEntityx != null) {
                        _blockEntityx.getPersistentData().putBoolean("spawned_funnel", true);
                     }

                     if (world instanceof Level _levelx) {
                        _levelx.sendBlockUpdated(_bpx, _bsx, _bsx, 3);
                     }
                  }
               }
            } else if (world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getBlock() != Blocks.GRASS_BLOCK) {
               if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ArphexModBlocks.FUNNEL_WEB.get()) {
                  if (world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z)) && world instanceof ServerLevel _levelx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_FUNNEL.get())
                        .spawn(_levelx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.5, 0.0, 0.0);
                     }
                  }

                  if (!world.isClientSide()) {
                     BlockPos _bpxx = BlockPos.containing(x, y, z);
                     BlockEntity _blockEntityxx = world.getBlockEntity(_bpxx);
                     BlockState _bsxx = world.getBlockState(_bpxx);
                     if (_blockEntityxx != null) {
                        _blockEntityxx.getPersistentData().putBoolean("spawned_funnel", true);
                     }

                     if (world instanceof Level _levelxx) {
                        _levelxx.sendBlockUpdated(_bpxx, _bsxx, _bsxx, 3);
                     }
                  }
               }
            } else if (world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getBlock() != Blocks.GRASS_BLOCK) {
               if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ArphexModBlocks.FUNNEL_WEB.get()) {
                  if (world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z)) && world instanceof ServerLevel _levelxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_FUNNEL.get())
                        .spawn(_levelxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.5, 0.0, 0.0);
                     }
                  }

                  if (!world.isClientSide()) {
                     BlockPos _bpxxx = BlockPos.containing(x, y, z);
                     BlockEntity _blockEntityxxx = world.getBlockEntity(_bpxxx);
                     BlockState _bsxxx = world.getBlockState(_bpxxx);
                     if (_blockEntityxxx != null) {
                        _blockEntityxxx.getPersistentData().putBoolean("spawned_funnel", true);
                     }

                     if (world instanceof Level _levelxxx) {
                        _levelxxx.sendBlockUpdated(_bpxxx, _bsxxx, _bsxxx, 3);
                     }
                  }
               }
            } else if (world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() != Blocks.GRASS_BLOCK
               && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ArphexModBlocks.FUNNEL_WEB.get()) {
               if (world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z)) && world instanceof ServerLevel _levelxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_FUNNEL.get())
                     .spawn(_levelxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.5, 0.0, 0.0);
                  }
               }

               if (!world.isClientSide()) {
                  BlockPos _bpxxxx = BlockPos.containing(x, y, z);
                  BlockEntity _blockEntityxxxx = world.getBlockEntity(_bpxxxx);
                  BlockState _bsxxxx = world.getBlockState(_bpxxxx);
                  if (_blockEntityxxxx != null) {
                     _blockEntityxxxx.getPersistentData().putBoolean("spawned_funnel", true);
                  }

                  if (world instanceof Level _levelxxxx) {
                     _levelxxxx.sendBlockUpdated(_bpxxxx, _bsxxxx, _bsxxxx, 3);
                  }
               }
            }

            if (Mth.nextInt(RandomSource.create(), 1, 160) == 1
               && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ArphexModBlocks.FUNNEL_WEB.get()) {
               if (world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z)) && world instanceof ServerLevel _levelxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_FUNNEL.get())
                     .spawn(_levelxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.5, 0.0);
                  }
               }

               if (!world.isClientSide()) {
                  BlockPos _bpxxxxx = BlockPos.containing(x, y, z);
                  BlockEntity _blockEntityxxxxx = world.getBlockEntity(_bpxxxxx);
                  BlockState _bsxxxxx = world.getBlockState(_bpxxxxx);
                  if (_blockEntityxxxxx != null) {
                     _blockEntityxxxxx.getPersistentData().putBoolean("spawned_funnel", true);
                  }

                  if (world instanceof Level _levelxxxxx) {
                     _levelxxxxx.sendBlockUpdated(_bpxxxxx, _bsxxxxx, _bsxxxxx, 3);
                  }
               }
            }
         }
      }
   }
}
