package net.arphex.procedures;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;

public class RandomReturnProcedure {
   public static double execute() {
      return (double)Mth.nextInt(RandomSource.create(), 0, 2);
   }
}
