package net.arphex.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;

public class AoEflameProjectileHitsBlockProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() instanceof IPlantable _plant0
            && _plant0.getPlantType(world, BlockPos.containing(x, y, z)) == PlantType.PLAINS
         || world.isEmptyBlock(BlockPos.containing(x, y, z))) {
         world.setBlock(BlockPos.containing(x, y, z), Blocks.FIRE.defaultBlockState(), 3);
      }

      if (world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getBlock() instanceof IPlantable _plant3
            && _plant3.getPlantType(world, BlockPos.containing(x, y + 1.0, z)) == PlantType.PLAINS
         || world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z))) {
         world.setBlock(BlockPos.containing(x, y + 1.0, z), Blocks.FIRE.defaultBlockState(), 3);
      }
   }
}
