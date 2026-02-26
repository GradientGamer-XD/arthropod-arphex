package net.arphex.procedures;

import net.arphex.init.ArphexModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;

public class BaneBlossomOnTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (!world.isClientSide() && Mth.nextInt(RandomSource.create(), 1, 10) == 5 && world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z))) {
         world.setBlock(BlockPos.containing(x, y + 1.0, z), ((Block)ArphexModBlocks.BANE_BLOSSOM.get()).defaultBlockState(), 3);
      }
   }
}
