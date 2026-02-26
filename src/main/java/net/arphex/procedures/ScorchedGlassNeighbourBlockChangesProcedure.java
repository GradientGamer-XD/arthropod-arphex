package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.init.ArphexModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class ScorchedGlassNeighbourBlockChangesProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      ArphexMod.queueServerWork(
         1,
         () -> {
            if (world.getBlockState(BlockPos.containing(x + 1.5, y - 1.0, z)).getBlock() == ArphexModBlocks.TESSERACT_TRANSPORTER.get()
               && world instanceof Level _level) {
               _level.updateNeighborsAt(BlockPos.containing(x, y - 1.0, z), _level.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock());
            }

            if (world.getBlockState(BlockPos.containing(x - 0.5, y - 1.0, z)).getBlock() == ArphexModBlocks.TESSERACT_TRANSPORTER.get()
               && world instanceof Level _level) {
               _level.updateNeighborsAt(BlockPos.containing(x, y - 1.0, z), _level.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock());
            }

            if (world.getBlockState(BlockPos.containing(x, y - 1.0, z - 0.5)).getBlock() == ArphexModBlocks.TESSERACT_TRANSPORTER.get()
               && world instanceof Level _level) {
               _level.updateNeighborsAt(BlockPos.containing(x, y - 1.0, z), _level.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock());
            }

            if (world.getBlockState(BlockPos.containing(x, y - 1.0, z + 1.5)).getBlock() == ArphexModBlocks.TESSERACT_TRANSPORTER.get()
               && world instanceof Level _level) {
               _level.updateNeighborsAt(BlockPos.containing(x, y - 1.0, z), _level.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock());
            }

            if (world.getBlockState(BlockPos.containing(x + 1.5, y - 2.0, z)).getBlock() == ArphexModBlocks.TESSERACT_TRANSPORTER.get()
               && world instanceof Level _level) {
               _level.updateNeighborsAt(BlockPos.containing(x, y - 2.0, z), _level.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock());
            }

            if (world.getBlockState(BlockPos.containing(x - 0.5, y - 2.0, z)).getBlock() == ArphexModBlocks.TESSERACT_TRANSPORTER.get()
               && world instanceof Level _level) {
               _level.updateNeighborsAt(BlockPos.containing(x, y - 2.0, z), _level.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock());
            }

            if (world.getBlockState(BlockPos.containing(x, y - 2.0, z - 0.5)).getBlock() == ArphexModBlocks.TESSERACT_TRANSPORTER.get()
               && world instanceof Level _level) {
               _level.updateNeighborsAt(BlockPos.containing(x, y - 2.0, z), _level.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock());
            }

            if (world.getBlockState(BlockPos.containing(x, y - 2.0, z + 1.5)).getBlock() == ArphexModBlocks.TESSERACT_TRANSPORTER.get()
               && world instanceof Level _level) {
               _level.updateNeighborsAt(BlockPos.containing(x, y - 2.0, z), _level.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock());
            }
         }
      );
   }
}
