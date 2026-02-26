package net.arphex.procedures;

import net.arphex.init.ArphexModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class VenusFlytrapOnInitialEntitySpawnProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 48.0, 48.0, 48.0), e -> true).isEmpty()
            && world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() != ArphexModBlocks.CRAWLING_COMPOST.get()) {
            entity.getPersistentData().putBoolean("nocompost", true);
         }
      }
   }
}
