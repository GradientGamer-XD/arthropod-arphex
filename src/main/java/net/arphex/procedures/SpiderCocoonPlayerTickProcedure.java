package net.arphex.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SpiderCocoonPlayerTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).isEmpty() && !world.isClientSide()) {
         world.destroyBlock(BlockPos.containing(x, y, z), false);
      }
   }
}
