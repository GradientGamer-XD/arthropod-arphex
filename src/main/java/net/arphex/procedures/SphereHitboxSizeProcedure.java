package net.arphex.procedures;

import net.arphex.entity.TormentorSphereEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class SphereHitboxSizeProcedure {
   public static double execute(Entity entity) {
      return entity == null
         ? 0.0
         : Mth.nextDouble(
            RandomSource.create(),
            (double)(
               (entity instanceof TormentorSphereEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(TormentorSphereEntity.DATA_growsize) : 0) / 150
            ),
            (double)((entity instanceof TormentorSphereEntity _datEntI ? (Integer)_datEntI.getEntityData().get(TormentorSphereEntity.DATA_growsize) : 0) / 150)
         );
   }
}
