package net.arphex.procedures;

import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.init.ArphexModBlocks;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;

public class CrawlingSpawnRequirementsProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z) {
      return world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() != ArphexModBlocks.CRAWLING_BARRIER.get()
         && (
            y > 230.0 && ArphexModVariables.MapVariables.get(world).playeronlayer1 > 0.0
               || y > 120.0 && y < 230.0 && ArphexModVariables.MapVariables.get(world).playeronlayer2 > 0.0
               || y < 120.0 && y > 60.0 && ArphexModVariables.MapVariables.get(world).playeronlayer3 > 0.0
               || y < 60.0 && ArphexModVariables.MapVariables.get(world).playeronlayer4 > 0.0
         )
         && y < 256.0
         && (Double)ConfigurationSettingsConfiguration.RANDOM_SYSTEM_SPAWNS.get() >= 1.0
         && Mth.nextInt(RandomSource.create(), 1, (int)((Double)ConfigurationSettingsConfiguration.RANDOM_SYSTEM_SPAWNS.get()).doubleValue()) == 1;
   }
}
