package net.arphex.procedures;

import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.network.ArphexModVariables;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;

public class TormentorSpawnConditionProcedure {
   public static boolean execute(LevelAccessor world) {
      return (Boolean)ConfigurationSettingsConfiguration.TORMENTOR_INITIAL_SPAWNING.get()
         && (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
            == Level.OVERWORLD
         && !ArphexModVariables.MapVariables.get(world).full_tormentor_has_previously_spawned
         && ArphexModVariables.MapVariables.get(world).bosskills.contains("moth")
         && ArphexModVariables.MapVariables.get(world).bosskills.contains("scorpioid")
         && ArphexModVariables.MapVariables.get(world).bosskills.contains("voidlasher")
         && (
            (Double)ConfigurationSettingsConfiguration.DWELLERS_FREQUENCY.get() == 2.0 && Mth.nextInt(RandomSource.create(), 1, 2) == 2
               || (Double)ConfigurationSettingsConfiguration.DWELLERS_FREQUENCY.get() == 3.0 && Mth.nextInt(RandomSource.create(), 1, 3) == 2
               || (Double)ConfigurationSettingsConfiguration.DWELLERS_FREQUENCY.get() == 3.0 && Mth.nextInt(RandomSource.create(), 1, 4) == 2
               || (Double)ConfigurationSettingsConfiguration.DWELLERS_FREQUENCY.get() <= 1.0
               || (Double)ConfigurationSettingsConfiguration.DWELLERS_FREQUENCY.get() >= 5.0
         )
         && (Boolean)ConfigurationSettingsConfiguration.SPAWN_DWELLERS_NATURALLY.get();
   }
}
