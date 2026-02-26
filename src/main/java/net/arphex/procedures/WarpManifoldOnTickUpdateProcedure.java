package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class WarpManifoldOnTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world instanceof ServerLevel _level) {
         _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_PURPLE_SMOKE.get(), x + 0.5, y + 0.65, z + 0.5, 20, 0.5, 0.1, 0.5, 0.0);
      }

      ArphexMod.queueServerWork(5, () -> {
         if (world instanceof ServerLevel _levelx) {
            _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_PURPLE_SMOKE.get(), x + 0.5, y + 0.65, z + 0.5, 20, 0.5, 0.1, 0.5, 0.0);
         }
      });
      if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
         world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
      }
   }
}
