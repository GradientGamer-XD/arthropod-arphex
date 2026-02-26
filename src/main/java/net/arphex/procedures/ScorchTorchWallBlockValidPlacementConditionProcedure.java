package net.arphex.procedures;

import net.arphex.init.ArphexModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;

public class ScorchTorchWallBlockValidPlacementConditionProcedure {
   public static boolean execute(final LevelAccessor world, double x, double y, double z) {
      return (
            (new Object() {
                           public Direction getDirection(BlockPos pos) {
                              BlockState _bs = world.getBlockState(pos);
                              Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                              if (property != null) {
                                 Comparable var5 = _bs.getValue(property);
                                 if (var5 instanceof Direction) {
                                    return (Direction)var5;
                                 }
                              }

                              if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                                 return Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                              } else {
                                 return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                    ? Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                    : Direction.NORTH;
                              }
                           }
                        })
                        .getDirection(BlockPos.containing(x, y, z))
                     == Direction.EAST
                  && (
                     world.getBlockState(BlockPos.containing(x - 1.0, y, z)).canOcclude()
                           && (double)world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getDestroySpeed(world, BlockPos.containing(x - 1.0, y, z)) > 0.2
                        || world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getBlock() == ArphexModBlocks.CRAWLING_BARRIER.get()
                  )
               || (new Object() {
                           public Direction getDirection(BlockPos pos) {
                              BlockState _bs = world.getBlockState(pos);
                              Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                              if (property != null) {
                                 Comparable var5 = _bs.getValue(property);
                                 if (var5 instanceof Direction) {
                                    return (Direction)var5;
                                 }
                              }

                              if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                                 return Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                              } else {
                                 return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                    ? Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                    : Direction.NORTH;
                              }
                           }
                        })
                        .getDirection(BlockPos.containing(x, y, z))
                     == Direction.WEST
                  && (
                     world.getBlockState(BlockPos.containing(x + 1.0, y, z)).canOcclude()
                           && (double)world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getDestroySpeed(world, BlockPos.containing(x + 1.0, y, z)) > 0.2
                        || world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getBlock() == ArphexModBlocks.CRAWLING_BARRIER.get()
                  )
               || (new Object() {
                           public Direction getDirection(BlockPos pos) {
                              BlockState _bs = world.getBlockState(pos);
                              Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                              if (property != null) {
                                 Comparable var5 = _bs.getValue(property);
                                 if (var5 instanceof Direction) {
                                    return (Direction)var5;
                                 }
                              }

                              if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                                 return Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                              } else {
                                 return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                    ? Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                    : Direction.NORTH;
                              }
                           }
                        })
                        .getDirection(BlockPos.containing(x, y, z))
                     == Direction.SOUTH
                  && (
                     world.getBlockState(BlockPos.containing(x, y, z - 1.0)).canOcclude()
                           && (double)world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getDestroySpeed(world, BlockPos.containing(x, y, z - 1.0)) > 0.2
                        || world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getBlock() == ArphexModBlocks.CRAWLING_BARRIER.get()
                  )
               || (new Object() {
                           public Direction getDirection(BlockPos pos) {
                              BlockState _bs = world.getBlockState(pos);
                              Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                              if (property != null) {
                                 Comparable var5 = _bs.getValue(property);
                                 if (var5 instanceof Direction) {
                                    return (Direction)var5;
                                 }
                              }

                              if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                                 return Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                              } else {
                                 return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                    ? Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                    : Direction.NORTH;
                              }
                           }
                        })
                        .getDirection(BlockPos.containing(x, y, z))
                     == Direction.NORTH
                  && (
                     world.getBlockState(BlockPos.containing(x, y, z + 1.0)).canOcclude()
                           && (double)world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getDestroySpeed(world, BlockPos.containing(x, y, z + 1.0)) > 0.2
                        || world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() == ArphexModBlocks.CRAWLING_BARRIER.get()
                  )
         )
         && !(world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getBlock() instanceof LiquidBlock);
   }
}
