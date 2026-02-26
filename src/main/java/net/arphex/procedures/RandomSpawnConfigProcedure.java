package net.arphex.procedures;

import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;

public class RandomSpawnConfigProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z) {
      return world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) < 1
         && (
            (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
                  == Level.OVERWORLD
               || (Boolean)ConfigurationSettingsConfiguration.ANY_DIMENSION.get()
         )
         && (Double)ConfigurationSettingsConfiguration.RANDOM_SYSTEM_SPAWNS.get() >= 1.0
         && Mth.nextInt(RandomSource.create(), 1, (int)((Double)ConfigurationSettingsConfiguration.RANDOM_SYSTEM_SPAWNS.get()).doubleValue()) == 1;
   }
}
