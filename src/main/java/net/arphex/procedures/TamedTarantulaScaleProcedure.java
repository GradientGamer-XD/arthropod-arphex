package net.arphex.procedures;

import net.arphex.entity.TamedTarantulaEntity;
import net.minecraft.world.entity.Entity;

public class TamedTarantulaScaleProcedure {
   public static double execute(Entity entity) {
      if (entity == null) {
         return 0.0;
      } else {
         double tarantulasize = 0.0;
         if ((entity instanceof TamedTarantulaEntity _datEntI ? (Integer)_datEntI.getEntityData().get(TamedTarantulaEntity.DATA_patreon_reskin) : 0) > 3) {
            tarantulasize = 3.3;
         } else if ((entity instanceof TamedTarantulaEntity _datEntI ? (Integer)_datEntI.getEntityData().get(TamedTarantulaEntity.DATA_patreon_reskin) : 0) > 2
            )
          {
            tarantulasize = 5.7;
         } else if ((entity instanceof TamedTarantulaEntity _datEntI ? (Integer)_datEntI.getEntityData().get(TamedTarantulaEntity.DATA_patreon_reskin) : 0) > 1
            )
          {
            tarantulasize = 4.0;
         } else if ((entity instanceof TamedTarantulaEntity _datEntI ? (Integer)_datEntI.getEntityData().get(TamedTarantulaEntity.DATA_patreon_reskin) : 0) > 0
            )
          {
            tarantulasize = 7.5;
         } else if ((entity instanceof TamedTarantulaEntity _datEntS ? (String)_datEntS.getEntityData().get(TamedTarantulaEntity.DATA_variant) : "")
            .equals("tarantula1")) {
            tarantulasize = 6.5;
         } else if ((entity instanceof TamedTarantulaEntity _datEntSxx ? (String)_datEntSxx.getEntityData().get(TamedTarantulaEntity.DATA_variant) : "")
               .equals("tarantula3")
            || (entity instanceof TamedTarantulaEntity _datEntSx ? (String)_datEntSx.getEntityData().get(TamedTarantulaEntity.DATA_variant) : "")
               .equals("tarantula5")
            || (entity instanceof TamedTarantulaEntity _datEntS ? (String)_datEntS.getEntityData().get(TamedTarantulaEntity.DATA_variant) : "")
               .equals("tarantula6")) {
            tarantulasize = 6.0;
         } else if (!(entity instanceof TamedTarantulaEntity _datEntSx ? (String)_datEntSx.getEntityData().get(TamedTarantulaEntity.DATA_variant) : "")
               .equals("tarantula2")
            && !(entity instanceof TamedTarantulaEntity _datEntS ? (String)_datEntS.getEntityData().get(TamedTarantulaEntity.DATA_variant) : "")
               .equals("tarantula7")) {
            tarantulasize = 5.6;
         } else {
            tarantulasize = 5.8;
         }

         return tarantulasize;
      }
   }
}
