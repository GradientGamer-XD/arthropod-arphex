package net.arphex.procedures;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class SlowLookTestOnInitialEntitySpawnProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putDouble("random_comparetag", Mth.nextDouble(RandomSource.create(), 1.0, 999999.0));
      }
   }
}
