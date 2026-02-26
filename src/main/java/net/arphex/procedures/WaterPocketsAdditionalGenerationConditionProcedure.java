package net.arphex.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;

public class WaterPocketsAdditionalGenerationConditionProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z) {
      return world.isEmptyBlock(BlockPos.containing(x, y, z))
         && world.getBlockState(BlockPos.containing(x, y - 1.0, z)).canOcclude()
         && (
            world.getBlockState(BlockPos.containing(x + 1.0, y, z)).canOcclude()
               || world.getBlockState(BlockPos.containing(x - 1.0, y, z)).canOcclude()
               || world.getBlockState(BlockPos.containing(x, y, z - 1.0)).canOcclude()
               || world.getBlockState(BlockPos.containing(x, y, z + 1.0)).canOcclude()
         );
   }
}
