package net.arphex.procedures;

import net.arphex.entity.NemesisProjectileEntity;
import net.minecraft.world.entity.Entity;

public class VenomProjScaleProcedure {
   public static double execute(Entity entity) {
      if (entity == null) {
         return 0.0;
      } else {
         return entity instanceof NemesisProjectileEntity _datEntI
            ? (double)((Integer)_datEntI.getEntityData().get(NemesisProjectileEntity.DATA_scale_switch)).intValue()
            : 0.0;
      }
   }
}
