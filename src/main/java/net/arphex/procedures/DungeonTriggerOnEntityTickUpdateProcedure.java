package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class DungeonTriggerOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         world.scheduleTick(BlockPos.containing(x, y - 1.0, z), world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock(), 0);
         ArphexMod.queueServerWork(2000, () -> {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         });
      }
   }
}
