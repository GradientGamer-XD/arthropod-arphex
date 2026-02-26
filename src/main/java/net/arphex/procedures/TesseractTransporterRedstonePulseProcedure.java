package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.init.ArphexModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TesseractTransporterRedstonePulseProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
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
         if ((new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0;
            }
         }).getValue(world, BlockPos.containing(x, y, z), "portal_lock_x") == 0.0) {
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiterator instanceof Player && entityiterator instanceof Player) {
                  Player _player = (Player)entityiterator;
                  if (!_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal("No teleporter destination configured (use Warp Connector)"), true);
                  }
               }
            }
         } else if (!world.isClientSide()) {
            BlockPos _bpxx = BlockPos.containing(x, y, z);
            BlockEntity _blockEntityxx = world.getBlockEntity(_bpxx);
            BlockState _bsxx = world.getBlockState(_bpxx);
            if (_blockEntityxx != null) {
               _blockEntityxx.getPersistentData().putDouble("teleportation_time", 16.0);
            }

            if (world instanceof Level _level) {
               _level.sendBlockUpdated(_bpxx, _bsxx, _bsxx, 3);
            }
         }
      } else {
         Vec3 _center = new Vec3(x, y, z);

         for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2.0), e -> true)
            .stream()
            .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
            .toList()) {
            if (entityiteratorx instanceof Player && entityiteratorx instanceof Player) {
               Player _player = (Player)entityiteratorx;
               if (!_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("Teleporter structure not complete"), true);
               }
            }
         }
      }
   }
}
