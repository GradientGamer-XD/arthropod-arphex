package net.arphex.procedures;

import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;

public class ScorpioidNaturalSpawnProcedure {
   public static boolean execute(LevelAccessor world) {
      return (
            (Double)ConfigurationSettingsConfiguration.DWELLERS_FREQUENCY.get() == 2.0 && Mth.nextInt(RandomSource.create(), 1, 2) == 2
               || (Double)ConfigurationSettingsConfiguration.DWELLERS_FREQUENCY.get() == 3.0 && Mth.nextInt(RandomSource.create(), 1, 3) == 2
               || (Double)ConfigurationSettingsConfiguration.DWELLERS_FREQUENCY.get() == 3.0 && Mth.nextInt(RandomSource.create(), 1, 4) == 2
               || (Double)ConfigurationSettingsConfiguration.DWELLERS_FREQUENCY.get() <= 1.0
               || (Double)ConfigurationSettingsConfiguration.DWELLERS_FREQUENCY.get() >= 5.0
         )
         && (
            (world.getLevelData().isThundering() || world.getLevelData().isRaining())
                  && (Boolean)ConfigurationSettingsConfiguration.DWELLERS_REQUIRE_WEATHER.get()
               || !(Boolean)ConfigurationSettingsConfiguration.DWELLERS_REQUIRE_WEATHER.get()
         )
         && (Boolean)ConfigurationSettingsConfiguration.SPAWN_DWELLERS_NATURALLY.get();
   }
}
