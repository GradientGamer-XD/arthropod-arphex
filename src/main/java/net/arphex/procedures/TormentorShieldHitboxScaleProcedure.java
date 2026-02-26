package net.arphex.procedures;

import net.arphex.entity.TormentorShieldEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class TormentorShieldHitboxScaleProcedure {
   public static double execute(Entity entity) {
      return entity == null
         ? 0.0
         : Mth.nextDouble(
               RandomSource.create(),
               entity instanceof TormentorShieldEntity _datEntIx
                  ? (double)((Integer)_datEntIx.getEntityData().get(TormentorShieldEntity.DATA_growsize)).intValue()
                  : 0.0,
               entity instanceof TormentorShieldEntity _datEntI
                  ? (double)((Integer)_datEntI.getEntityData().get(TormentorShieldEntity.DATA_growsize)).intValue()
                  : 0.0
            )
            / 3.0;
   }
}
