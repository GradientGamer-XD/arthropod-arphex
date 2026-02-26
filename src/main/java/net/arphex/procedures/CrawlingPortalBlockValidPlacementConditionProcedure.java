package net.arphex.procedures;

import net.arphex.init.ArphexModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;

public class CrawlingPortalBlockValidPlacementConditionProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z) {
      return (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
            != ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))
         || !(y > 232.0)
         || !(y < 254.0)
         || (
               world.getBlockState(BlockPos.containing(x, y + 1.0, z)).canOcclude()
                  || world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getBlock() == ArphexModBlocks.CRAWLING_PORTAL.get()
            )
            && (
               world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.END_STONE
                  || world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == ArphexModBlocks.CRAWLING_PORTAL.get()
                  || world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.NETHERRACK
                  || world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.STONE
            );
   }
}
