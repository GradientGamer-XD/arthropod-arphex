package net.arphex.procedures;

import net.arphex.entity.SpiderAmbusherEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class SpiderAmbusherOnInitialEntitySpawnProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (!world.isClientSide() && Mth.nextInt(RandomSource.create(), 1, 2) == 2 && entity instanceof SpiderAmbusherEntity animatable) {
            animatable.setTexture("spider_ambusher2");
         }
      }
   }
}
