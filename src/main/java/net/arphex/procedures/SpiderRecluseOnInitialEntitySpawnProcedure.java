package net.arphex.procedures;

import net.arphex.entity.SpiderRecluseEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class SpiderRecluseOnInitialEntitySpawnProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
            if (entity instanceof SpiderRecluseEntity animatable) {
               animatable.setTexture("spider_recluse_3");
            }
         } else if (Mth.nextInt(RandomSource.create(), 1, 12) == 2 && entity instanceof SpiderRecluseEntity animatable) {
            animatable.setTexture("spider_recluse");
         }

         if (entity instanceof SpiderRecluseEntity _datEntSetI) {
            _datEntSetI.getEntityData().set(SpiderRecluseEntity.DATA_size, Mth.nextInt(RandomSource.create(), 17, 33));
         }
      }
   }
}
