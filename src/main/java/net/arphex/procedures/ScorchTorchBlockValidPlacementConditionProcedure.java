package net.arphex.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.LiquidBlock;

public class ScorchTorchBlockValidPlacementConditionProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z) {
      return !(world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getBlock() instanceof LiquidBlock)
         && world.getBlockState(BlockPos.containing(x, y - 1.0, z)).canOcclude()
         && (double)world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getDestroySpeed(world, BlockPos.containing(x, y - 1.0, z)) > 0.2;
   }
}
