package net.arphex.procedures;

import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.SpiderMothEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SpiderMothDwellerNaturalEntitySpawningConditionProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z) {
      return world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).isEmpty()
         && world.getEntitiesOfClass(SpiderMothEntity.class, AABB.ofSize(new Vec3(x, y, z), 350.0, 350.0, 350.0), e -> true).isEmpty()
         && (
            (Double)ConfigurationSettingsConfiguration.DWELLERS_FREQUENCY.get() == 2.0 && Mth.nextInt(RandomSource.create(), 1, 2) == 2
               || (Double)ConfigurationSettingsConfiguration.DWELLERS_FREQUENCY.get() == 3.0 && Mth.nextInt(RandomSource.create(), 1, 3) == 2
               || (Double)ConfigurationSettingsConfiguration.DWELLERS_FREQUENCY.get() == 3.0 && Mth.nextInt(RandomSource.create(), 1, 4) == 2
               || (Double)ConfigurationSettingsConfiguration.DWELLERS_FREQUENCY.get() <= 1.0
               || (Double)ConfigurationSettingsConfiguration.DWELLERS_FREQUENCY.get() >= 5.0
         )
         && (world.getLevelData().isThundering() || !(Boolean)ConfigurationSettingsConfiguration.DWELLERS_REQUIRE_WEATHER.get())
         && (Boolean)ConfigurationSettingsConfiguration.SPAWN_DWELLERS_NATURALLY.get();
   }
}
