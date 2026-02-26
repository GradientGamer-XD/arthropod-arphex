package net.arphex.procedures;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class WaspNemesisOnInitialEntitySpawnProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putDouble("eagletickslow", (double)Mth.nextInt(RandomSource.create(), 600, 1200));
      }
   }
}
