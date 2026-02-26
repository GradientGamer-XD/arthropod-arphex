package net.arphex.procedures;

import net.arphex.entity.SpiderChaserHallucinationEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class SpiderChaserHallucinationOnInitialEntitySpawnProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity instanceof SpiderChaserHallucinationEntity _datEntSetI) {
            _datEntSetI.getEntityData().set(SpiderChaserHallucinationEntity.DATA_random_size, Mth.nextInt(RandomSource.create(), 15, 100));
         }

         entity.noPhysics = true;
      }
   }
}
