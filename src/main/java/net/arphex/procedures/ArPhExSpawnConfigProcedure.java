package net.arphex.procedures;

import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LightLayer;

public class ArPhExSpawnConfigProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z) {
      return world.getBrightness(LightLayer.BLOCK, BlockPos.containing(x, y, z)) < 1
         && world.isEmptyBlock(BlockPos.containing(x, y, z))
         && Mth.nextInt(RandomSource.create(), 1, (int)((Double)ConfigurationSettingsConfiguration.NON_BOSS_SPAWNRATE.get()).doubleValue()) == 1;
   }
}
