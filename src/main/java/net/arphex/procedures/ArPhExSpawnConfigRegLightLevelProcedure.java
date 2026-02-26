package net.arphex.procedures;

import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;

public class ArPhExSpawnConfigRegLightLevelProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z) {
      return world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) < 1
         && Mth.nextInt(RandomSource.create(), 1, (int)((Double)ConfigurationSettingsConfiguration.NON_BOSS_SPAWNRATE.get()).doubleValue()) == 1
         && world.isEmptyBlock(BlockPos.containing(x, y, z));
   }
}
