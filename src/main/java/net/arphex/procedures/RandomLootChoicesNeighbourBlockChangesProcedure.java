package net.arphex.procedures;

import net.arphex.init.ArphexModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class RandomLootChoicesNeighbourBlockChangesProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getBlock() == Blocks.POLISHED_DEEPSLATE) {
         if (Mth.nextInt(RandomSource.create(), 1, 9) < 9) {
            world.setBlock(BlockPos.containing(x, y, z), Blocks.IRON_BLOCK.defaultBlockState(), 3);
         } else if (Mth.nextInt(RandomSource.create(), 1, 5) == 3) {
            world.setBlock(BlockPos.containing(x, y, z), ((Block)ArphexModBlocks.EXQUISITE_ORE.get()).defaultBlockState(), 3);
         } else {
            world.setBlock(BlockPos.containing(x, y, z), Blocks.DIAMOND_BLOCK.defaultBlockState(), 3);
         }
      } else if (world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getBlock() == Blocks.POLISHED_BLACKSTONE) {
         if (Mth.nextInt(RandomSource.create(), 1, 9) < 9) {
            world.setBlock(BlockPos.containing(x, y, z), Blocks.REDSTONE_BLOCK.defaultBlockState(), 3);
         } else if (Mth.nextInt(RandomSource.create(), 1, 5) == 3) {
            world.setBlock(BlockPos.containing(x, y, z), Blocks.GOLD_BLOCK.defaultBlockState(), 3);
         } else {
            world.setBlock(BlockPos.containing(x, y, z), ((Block)ArphexModBlocks.TERMITE_MOUND.get()).defaultBlockState(), 3);
         }
      } else if (Mth.nextInt(RandomSource.create(), 1, 9) < 9) {
         world.setBlock(BlockPos.containing(x, y, z), Blocks.REDSTONE_BLOCK.defaultBlockState(), 3);
      } else if (Mth.nextInt(RandomSource.create(), 1, 5) == 3) {
         world.setBlock(BlockPos.containing(x, y, z), Blocks.GOLD_BLOCK.defaultBlockState(), 3);
      } else {
         world.setBlock(BlockPos.containing(x, y, z), ((Block)ArphexModBlocks.TERMITE_MOUND.get()).defaultBlockState(), 3);
      }
   }
}
