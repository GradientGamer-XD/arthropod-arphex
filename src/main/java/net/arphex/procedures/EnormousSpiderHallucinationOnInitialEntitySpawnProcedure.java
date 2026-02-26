package net.arphex.procedures;

import net.arphex.entity.EnormousSpiderHallucinationEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class EnormousSpiderHallucinationOnInitialEntitySpawnProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity instanceof EnormousSpiderHallucinationEntity _datEntSetI) {
            _datEntSetI.getEntityData().set(EnormousSpiderHallucinationEntity.DATA_size, Mth.nextInt(RandomSource.create(), 70, 140));
         }

         entity.setYRot(entity.getYRot() + (float)Mth.nextInt(RandomSource.create(), 1, 360));
         entity.setXRot(entity.getXRot());
         entity.setYBodyRot(entity.getYRot());
         entity.setYHeadRot(entity.getYRot());
         entity.yRotO = entity.getYRot();
         entity.xRotO = entity.getXRot();
         if (entity instanceof LivingEntity _entity) {
            _entity.yBodyRotO = _entity.getYRot();
            _entity.yHeadRotO = _entity.getYRot();
         }
      }
   }
}
