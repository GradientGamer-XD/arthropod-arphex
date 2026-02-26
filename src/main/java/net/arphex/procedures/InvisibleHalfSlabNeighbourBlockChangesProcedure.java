package net.arphex.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;

public class InvisibleHalfSlabNeighbourBlockChangesProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (!world.isClientSide()) {
         world.setBlock(BlockPos.containing(x, y + 0.6, z), Blocks.AIR.defaultBlockState(), 3);
      }
   }
}
