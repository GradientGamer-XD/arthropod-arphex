package net.arphex.procedures;

import net.arphex.init.ArphexModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;

public class BaneBlossomNeighbourBlockChangesProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == ArphexModBlocks.BANE_BLOSSOM.get()
         && world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock() == ArphexModBlocks.BANE_BLOSSOM.get()
         && world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getBlock() == ArphexModBlocks.BANE_BLOSSOM.get()
         && world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getBlock() == ArphexModBlocks.BANE_BLOSSOM.get()
         && !world.isClientSide()) {
         world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
      }
   }
}
