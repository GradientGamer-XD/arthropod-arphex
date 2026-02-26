package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class ScorchTorchWallTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
      if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
         if ((new Object() {
                  public Direction getDirection(BlockState _bs) {
                     if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof DirectionProperty _dp) {
                        return (Direction)_bs.getValue(_dp);
                     } else {
                        if (_bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ep
                           && _ep.getPossibleValues().toArray()[0] instanceof Axis) {
                           return Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                        }

                        return Direction.NORTH;
                     }
                  }
               })
               .getDirection(blockstate)
            == Direction.EAST) {
            if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
               if (world instanceof ServerLevel _level) {
                  _level.sendParticles(ParticleTypes.SMOKE, x + 0.2, y + 0.8, z + 0.5, 1, 0.0, 0.0, 0.0, 0.05);
               }

               ArphexMod.queueServerWork(10, () -> {
                  if (world instanceof ServerLevel _levelx) {
                     _levelx.sendParticles(ParticleTypes.SMOKE, x + 0.2, y + 0.8, z + 0.5, 1, 0.0, 0.0, 0.0, 0.05);
                  }
               });
            }

            if (Mth.nextInt(RandomSource.create(), 1, 5) == 1 && world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.SCORCH_FLAME.get(), x + 0.2, y + 0.8, z + 0.5, 1, 0.0, 0.0, 0.0, 0.05);
            }
         } else if ((new Object() {
                  public Direction getDirection(BlockState _bs) {
                     if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof DirectionProperty _dp) {
                        return (Direction)_bs.getValue(_dp);
                     } else {
                        if (_bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ep
                           && _ep.getPossibleValues().toArray()[0] instanceof Axis) {
                           return Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                        }

                        return Direction.NORTH;
                     }
                  }
               })
               .getDirection(blockstate)
            == Direction.WEST) {
            if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
               if (world instanceof ServerLevel _level) {
                  _level.sendParticles(ParticleTypes.SMOKE, x + 0.8, y + 0.8, z + 0.5, 1, 0.0, 0.0, 0.0, 0.05);
               }

               ArphexMod.queueServerWork(10, () -> {
                  if (world instanceof ServerLevel _levelx) {
                     _levelx.sendParticles(ParticleTypes.SMOKE, x + 0.8, y + 0.8, z + 0.5, 1, 0.0, 0.0, 0.0, 0.05);
                  }
               });
            }

            if (Mth.nextInt(RandomSource.create(), 1, 5) == 1 && world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.SCORCH_FLAME.get(), x + 0.8, y + 0.8, z + 0.5, 1, 0.0, 0.0, 0.0, 0.05);
            }
         } else if ((new Object() {
                  public Direction getDirection(BlockState _bs) {
                     if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof DirectionProperty _dp) {
                        return (Direction)_bs.getValue(_dp);
                     } else {
                        if (_bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ep
                           && _ep.getPossibleValues().toArray()[0] instanceof Axis) {
                           return Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                        }

                        return Direction.NORTH;
                     }
                  }
               })
               .getDirection(blockstate)
            == Direction.NORTH) {
            if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
               if (world instanceof ServerLevel _level) {
                  _level.sendParticles(ParticleTypes.SMOKE, x + 0.5, y + 0.8, z + 0.8, 1, 0.0, 0.0, 0.0, 0.05);
               }

               ArphexMod.queueServerWork(10, () -> {
                  if (world instanceof ServerLevel _levelx) {
                     _levelx.sendParticles(ParticleTypes.SMOKE, x + 0.5, y + 0.8, z + 0.8, 1, 0.0, 0.0, 0.0, 0.05);
                  }
               });
            }

            if (Mth.nextInt(RandomSource.create(), 1, 5) == 1 && world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.SCORCH_FLAME.get(), x + 0.5, y + 0.8, z + 0.8, 1, 0.0, 0.0, 0.0, 0.05);
            }
         } else {
            if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
               if (world instanceof ServerLevel _level) {
                  _level.sendParticles(ParticleTypes.SMOKE, x + 0.5, y + 0.8, z + 0.3, 1, 0.0, 0.0, 0.0, 0.05);
               }

               ArphexMod.queueServerWork(10, () -> {
                  if (world instanceof ServerLevel _levelx) {
                     _levelx.sendParticles(ParticleTypes.SMOKE, x + 0.5, y + 0.8, z + 0.3, 1, 0.0, 0.0, 0.0, 0.05);
                  }
               });
            }

            if (Mth.nextInt(RandomSource.create(), 1, 5) == 1 && world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.SCORCH_FLAME.get(), x + 0.5, y + 0.8, z + 0.3, 1, 0.0, 0.0, 0.0, 0.05);
            }
         }
      }
   }
}
