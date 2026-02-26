package net.arphex.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;

public class FlatterDesertAdditionalGenerationConditionProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z) {
      return !world.isEmptyBlock(BlockPos.containing(x + 1.0, y, z))
         || world.isEmptyBlock(BlockPos.containing(x - 1.0, y, z))
         || !world.isEmptyBlock(BlockPos.containing(x, y, z + 1.0))
         || !world.isEmptyBlock(BlockPos.containing(x, y, z - 1.0));
   }
}
