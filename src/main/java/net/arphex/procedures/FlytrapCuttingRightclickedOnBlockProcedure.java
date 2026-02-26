package net.arphex.procedures;

import net.arphex.init.ArphexModBlocks;
import net.arphex.init.ArphexModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class FlytrapCuttingRightclickedOnBlockProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
      if (world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z))
         && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ArphexModBlocks.CRAWLING_COMPOST.get()) {
         if (world instanceof ServerLevel _level) {
            Entity entityToSpawn = ((EntityType)ArphexModEntities.FLYTRAP.get()).spawn(_level, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
            }
         }

         itemstack.shrink(1);
      }
   }
}
