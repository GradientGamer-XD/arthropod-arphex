package net.arphex.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;

public class InvisibleDetectorBlockNeighbourBlockChangesProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (!world.isClientSide() && world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getBlock() instanceof LiquidBlock) {
         world.setBlock(BlockPos.containing(x, y + 1.0, z), Blocks.AIR.defaultBlockState(), 3);
      }
   }
}
