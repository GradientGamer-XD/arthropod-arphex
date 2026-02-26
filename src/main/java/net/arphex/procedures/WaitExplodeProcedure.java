package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;

public class WaitExplodeProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      ArphexMod.queueServerWork(Mth.nextInt(RandomSource.create(), 1, 15), () -> {
         if (world instanceof Level _level && !_level.isClientSide()) {
            _level.explode(null, x, y, z, 6.0F, ExplosionInteraction.TNT);
         }
      });
   }
}
