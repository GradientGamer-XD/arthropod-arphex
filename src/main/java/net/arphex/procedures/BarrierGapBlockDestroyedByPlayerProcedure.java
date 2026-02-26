package net.arphex.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;

public class BarrierGapBlockDestroyedByPlayerProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (!world.isClientSide()) {
         world.setBlock(BlockPos.containing(x, y, z), Blocks.BARRIER.defaultBlockState(), 3);
      }
   }
}
