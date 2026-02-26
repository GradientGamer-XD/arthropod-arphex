package net.arphex.procedures;

import net.arphex.entity.SpiderObstructerEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class SpiderObstructerOnInitialEntitySpawnProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity instanceof SpiderObstructerEntity _datEntSetL) {
            _datEntSetL.getEntityData().set(SpiderObstructerEntity.DATA_plugmode, false);
         }

         entity.getPersistentData().putDouble("trigger_range_arphex", (double)Mth.nextInt(RandomSource.create(), 7, 16));
      }
   }
}
