package net.arphex.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;

public class WideForceGroundPlacementProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z) {
      return world.isEmptyBlock(BlockPos.containing(x, y, z))
         && !world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z))
         && !world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z - 5.0))
         && world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z + 5.0))
         && !world.isEmptyBlock(BlockPos.containing(x - 5.0, y - 1.0, z))
         && !world.isEmptyBlock(BlockPos.containing(x + 5.0, y - 1.0, z));
   }
}
