package net.arphex.procedures;

import net.arphex.entity.SpiderMatriarchLarvaeEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class SpiderMatriarchSpawnProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity instanceof SpiderMatriarchLarvaeEntity _datEntSetI) {
            _datEntSetI.getEntityData().set(SpiderMatriarchLarvaeEntity.DATA_variant, Mth.nextInt(RandomSource.create(), 1, 2));
         }
      }
   }
}
