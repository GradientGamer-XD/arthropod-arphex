package net.arphex.procedures;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class GiantWebOnInitialEntitySpawnProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
            entity.setShiftKeyDown(true);
         } else if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
            entity.setSprinting(true);
         }
      }
   }
}
