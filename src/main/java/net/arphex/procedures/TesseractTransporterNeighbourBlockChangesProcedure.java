package net.arphex.procedures;

import net.arphex.init.ArphexModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class TesseractTransporterNeighbourBlockChangesProcedure {
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
   }
}
