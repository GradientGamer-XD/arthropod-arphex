package net.arphex.procedures;

import net.arphex.entity.SpiderJumpEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class SpiderJumpOnInitialEntitySpawnProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putDouble("climbradius", 0.7);
         if (Mth.nextInt(RandomSource.create(), 1, 10) == 5 && entity instanceof SpiderJumpEntity animatable) {
            animatable.setTexture("spiderjumpingrare");
         }
      }
   }
}
