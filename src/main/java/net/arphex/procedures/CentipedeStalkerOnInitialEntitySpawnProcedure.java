package net.arphex.procedures;

import net.arphex.entity.CentipedeStalkerEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class CentipedeStalkerOnInitialEntitySpawnProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putDouble("climbradius", 1.0);
         if (Mth.nextInt(RandomSource.create(), 1, 50) == 5 && entity instanceof CentipedeStalkerEntity animatable) {
            animatable.setTexture("centistalkerblue");
         }
      }
   }
}
