package net.arphex.procedures;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class TormentorCaterpillarOnInitialEntitySpawnProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
            entity.getPersistentData().putBoolean("clockwisever", true);
         }
      }
   }
}
