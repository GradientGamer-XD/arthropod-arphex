package net.arphex.procedures;

import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.ArachnoidTrisectorEntity;
import net.arphex.entity.DiabolosDecimatorEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;

public class GenesisShotProjectileHitsBlockProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         if ((Boolean)ConfigurationSettingsConfiguration.ARPHEX_ITEM_GRIEFING.get()
            && (
               (Boolean)ConfigurationSettingsConfiguration.ARPHEX_GRIEFING.get()
                  || !(entity instanceof ArachnoidTrisectorEntity) && !(entity instanceof DiabolosDecimatorEntity)
            )
            && !immediatesourceentity.getPersistentData().getBoolean("done_explode")) {
            if (world instanceof Level _level && !_level.isClientSide()) {
               _level.explode(null, x + 0.5, y - 0.5, z + 0.5, 1.0F, ExplosionInteraction.BLOCK);
            }

            immediatesourceentity.getPersistentData().putBoolean("done_explode", true);
         }
      }
   }
}
