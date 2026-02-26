package net.arphex.procedures;

import net.arphex.entity.HornetProjectileEntity;
import net.minecraft.world.entity.Entity;

public class HornetProjScaleProcedure {
   public static double execute(Entity entity) {
      if (entity == null) {
         return 0.0;
      } else {
         return entity instanceof HornetProjectileEntity _datEntI
            ? (double)((Integer)_datEntI.getEntityData().get(HornetProjectileEntity.DATA_scale_switch)).intValue()
            : 0.0;
      }
   }
}
