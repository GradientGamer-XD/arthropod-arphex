package net.arphex.procedures;

import net.arphex.entity.MantisMutilatorEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class MantisMutilatorOnInitialEntitySpawnProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (Mth.nextInt(RandomSource.create(), 1, 6) == 1) {
            if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
               if (entity instanceof MantisMutilatorEntity _datEntSetS) {
                  _datEntSetS.getEntityData().set(MantisMutilatorEntity.DATA_variant, "orchid");
               }
            } else if (entity instanceof MantisMutilatorEntity _datEntSetS) {
               _datEntSetS.getEntityData().set(MantisMutilatorEntity.DATA_variant, "stick");
            }
         }
      }
   }
}
