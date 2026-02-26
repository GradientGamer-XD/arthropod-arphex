package net.arphex.procedures;

import net.arphex.entity.MothMoontrackerEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class MothLarvaeOnInitialEntitySpawnProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putDouble("flyboost", 1.0);
         if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
            if (Mth.nextInt(RandomSource.create(), 1, 4) == 2) {
               if (entity instanceof MothMoontrackerEntity animatable) {
                  animatable.setTexture("mothlarvae");
               }
            } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
               if (entity instanceof MothMoontrackerEntity animatable) {
                  animatable.setTexture("mothlarvae3");
               }
            } else if (Mth.nextInt(RandomSource.create(), 1, 5) == 2) {
               if (entity instanceof MothMoontrackerEntity animatable) {
                  animatable.setTexture("mothlarvae5");
               }
            } else if (entity instanceof MothMoontrackerEntity animatable) {
               animatable.setTexture("mothlarvae4");
            }
         }
      }
   }
}
