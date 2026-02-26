package net.arphex.procedures;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class CrabLarvaeEntityIsHurtProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
            entity.setShiftKeyDown(true);
         }
      }
   }
}
