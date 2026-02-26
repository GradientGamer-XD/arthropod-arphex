package net.arphex.procedures;

import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;

public class BlockBroken4Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (entity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem())) {
            if (entity.isShiftKeyDown()) {
               if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getBlock()
                  && world.getBlockState(BlockPos.containing(x, y, z)) == world.getBlockState(BlockPos.containing(x, y + 1.0, z))) {
                  BlockPos _pos = BlockPos.containing(x, y + 1.0, z);
                  Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y + 1.0, z), null);
                  world.destroyBlock(_pos, false);
               }

               if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == world.getBlockState(BlockPos.containing(x, y + 2.0, z)).getBlock()
                  && world.getBlockState(BlockPos.containing(x, y, z)) == world.getBlockState(BlockPos.containing(x, y + 2.0, z))) {
                  BlockPos _pos = BlockPos.containing(x, y + 2.0, z);
                  Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y + 2.0, z), null);
                  world.destroyBlock(_pos, false);
               }

               if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == world.getBlockState(BlockPos.containing(x, y + 3.0, z)).getBlock()
                  && world.getBlockState(BlockPos.containing(x, y, z)) == world.getBlockState(BlockPos.containing(x, y + 3.0, z))) {
                  BlockPos _pos = BlockPos.containing(x, y + 3.0, z);
                  Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y + 3.0, z), null);
                  world.destroyBlock(_pos, false);
               }

               if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == world.getBlockState(BlockPos.containing(x, y + 4.0, z)).getBlock()
                  && world.getBlockState(BlockPos.containing(x, y, z)) == world.getBlockState(BlockPos.containing(x, y + 4.0, z))) {
                  BlockPos _pos = BlockPos.containing(x, y + 4.0, z);
                  Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y + 4.0, z), null);
                  world.destroyBlock(_pos, false);
               }

               if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == world.getBlockState(BlockPos.containing(x, y + 4.0, z)).getBlock()
                  && world.getBlockState(BlockPos.containing(x, y, z)) == world.getBlockState(BlockPos.containing(x, y + 4.0, z))) {
                  BlockPos _pos = BlockPos.containing(x, y + 5.0, z);
                  Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y + 5.0, z), null);
                  world.destroyBlock(_pos, false);
               }
            } else {
               if (entity.getDirection() != Direction.NORTH && entity.getDirection() != Direction.SOUTH) {
                  if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == world.getBlockState(BlockPos.containing(x, y - 1.0, z - 1.0)).getBlock()
                     && world.getBlockState(BlockPos.containing(x, y, z)) == world.getBlockState(BlockPos.containing(x, y - 1.0, z - 1.0))) {
                     BlockPos _pos = BlockPos.containing(x, y - 1.0, z - 1.0);
                     Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y - 1.0, z - 1.0), null);
                     world.destroyBlock(_pos, false);
                  }

                  if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == world.getBlockState(BlockPos.containing(x, y - 1.0, z + 1.0)).getBlock()
                     && world.getBlockState(BlockPos.containing(x, y, z)) == world.getBlockState(BlockPos.containing(x, y - 1.0, z + 1.0))) {
                     BlockPos _pos = BlockPos.containing(x, y - 1.0, z + 1.0);
                     Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y - 1.0, z + 1.0), null);
                     world.destroyBlock(_pos, false);
                  }

                  if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock()
                     && world.getBlockState(BlockPos.containing(x, y, z)) == world.getBlockState(BlockPos.containing(x, y, z + 1.0))) {
                     BlockPos _pos = BlockPos.containing(x, y, z + 1.0);
                     Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z + 1.0), null);
                     world.destroyBlock(_pos, false);
                  }

                  if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getBlock()
                     && world.getBlockState(BlockPos.containing(x, y, z)) == world.getBlockState(BlockPos.containing(x, y, z - 1.0))) {
                     BlockPos _pos = BlockPos.containing(x, y, z - 1.0);
                     Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z - 1.0), null);
                     world.destroyBlock(_pos, false);
                  }
               } else {
                  if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == world.getBlockState(BlockPos.containing(x - 1.0, y - 1.0, z)).getBlock()
                     && world.getBlockState(BlockPos.containing(x, y, z)) == world.getBlockState(BlockPos.containing(x - 1.0, y - 1.0, z))) {
                     BlockPos _pos = BlockPos.containing(x - 1.0, y - 1.0, z);
                     Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x - 1.0, y - 1.0, z), null);
                     world.destroyBlock(_pos, false);
                  }

                  if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == world.getBlockState(BlockPos.containing(x + 1.0, y - 1.0, z)).getBlock()
                     && world.getBlockState(BlockPos.containing(x, y, z)) == world.getBlockState(BlockPos.containing(x + 1.0, y - 1.0, z))) {
                     BlockPos _pos = BlockPos.containing(x + 1.0, y - 1.0, z);
                     Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 1.0, y - 1.0, z), null);
                     world.destroyBlock(_pos, false);
                  }

                  if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getBlock()
                     && world.getBlockState(BlockPos.containing(x, y, z)) == world.getBlockState(BlockPos.containing(x + 1.0, y, z))) {
                     BlockPos _pos = BlockPos.containing(x + 1.0, y, z);
                     Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 1.0, y, z), null);
                     world.destroyBlock(_pos, false);
                  }

                  if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getBlock()
                     && world.getBlockState(BlockPos.containing(x, y, z)) == world.getBlockState(BlockPos.containing(x - 1.0, y, z))) {
                     BlockPos _pos = BlockPos.containing(x - 1.0, y, z);
                     Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x - 1.0, y, z), null);
                     world.destroyBlock(_pos, false);
                  }
               }

               if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock()
                  && world.getBlockState(BlockPos.containing(x, y, z)) == world.getBlockState(BlockPos.containing(x, y - 1.0, z))) {
                  BlockPos _pos = BlockPos.containing(x, y - 1.0, z);
                  Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y - 1.0, z), null);
                  world.destroyBlock(_pos, false);
               }
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARRED_BLOOD.get(), x, y, z, 20, 0.5, 0.5, 0.5, 0.2);
            }
         }
      }
   }
}
