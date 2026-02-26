package net.arphex.procedures;

import net.arphex.entity.SpiderFunnelEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class SpiderFunnelOnInitialEntitySpawnProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putDouble("climbradius", 1.1);
         if (Mth.nextInt(RandomSource.create(), 1, 2) == 2 && entity instanceof SpiderFunnelEntity animatable) {
            animatable.setTexture("spiderfunnel2");
         }
      }
   }
}
