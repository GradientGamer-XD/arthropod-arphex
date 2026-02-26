package net.arphex.procedures;

import net.arphex.init.ArphexModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class StructureFillBlockOnTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (!world.isClientSide()) {
         world.setBlock(BlockPos.containing(x, y, z), Blocks.DEEPSLATE.defaultBlockState(), 3);
         if (y > 30.0 && !world.getBlockState(BlockPos.containing(x, y - 1.0, z)).canOcclude()) {
            world.setBlock(BlockPos.containing(x, y - 1.0, z), ((Block)ArphexModBlocks.STRUCTURE_FILL_BLOCK.get()).defaultBlockState(), 3);
         }
      }
   }
}
