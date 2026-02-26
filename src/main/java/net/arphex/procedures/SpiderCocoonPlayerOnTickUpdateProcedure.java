package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SpiderCocoonPlayerOnTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         entity.setDeltaMovement(new Vec3((double)Math.round(x) + 0.5 - entity.getX(), 0.2, (double)Math.round(z) + 0.5 - entity.getZ()));
         entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
         if (!world.getBlockState(BlockPos.containing(x, y + 1.0, z)).canOcclude() && !world.isClientSide()) {
            world.destroyBlock(BlockPos.containing(x, y, z), false);
         }

         if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).isEmpty()) {
            ArphexMod.queueServerWork(20, () -> {
               if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).isEmpty() && !world.isClientSide()) {
                  world.destroyBlock(BlockPos.containing(x, y, z), false);
               }
            });
         }
      }
   }
}
