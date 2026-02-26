package net.arphex.procedures;

import net.arphex.init.ArphexModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;

public class ObstructMoveProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z) {
      return world.getBlockState(BlockPos.containing(x, y + 1.55, z)).getBlock() != ArphexModBlocks.TRAPDOOR_GRASS.get();
   }
}
