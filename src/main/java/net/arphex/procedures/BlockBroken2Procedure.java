package net.arphex.procedures;

import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;

public class BlockBroken2Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!entity.isShiftKeyDown()) {
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock()
               && world.getBlockState(BlockPos.containing(x, y, z)) == world.getBlockState(BlockPos.containing(x, y - 1.0, z))) {
               BlockPos _pos = BlockPos.containing(x, y - 1.0, z);
               Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y - 1.0, z), null);
               world.destroyBlock(_pos, false);
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 10, 0.5, 0.5, 0.5, 0.2);
            }
         }
      }
   }
}
