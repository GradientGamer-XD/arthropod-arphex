package net.arphex.procedures;

import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.WorldGenLevel;

public class ArphexSpawnConfigSurfaceProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z) {
      return world.getBrightness(LightLayer.BLOCK, BlockPos.containing(x, y, z)) < 1
         && Mth.nextInt(RandomSource.create(), 1, (int)((Double)ConfigurationSettingsConfiguration.NON_BOSS_SPAWNRATE.get()).doubleValue()) == 1
         && (
            (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
                  != Level.OVERWORLD
               || world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))
         );
   }
}
