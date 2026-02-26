package net.arphex.procedures;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;

public class HedonicGemPropertyValueProviderProcedure {
   public static double execute() {
      return Mth.nextInt(RandomSource.create(), 1, 3) == 2 ? 2.0 : 0.0;
   }
}
