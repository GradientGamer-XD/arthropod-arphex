package net.arphex.procedures;

import net.arphex.entity.SmallTormentSphereEntity;
import net.arphex.entity.TormentorSphereEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class TormentorSphereOnInitialEntitySpawnProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (entity instanceof SmallTormentSphereEntity && !world.isClientSide() && entity instanceof SmallTormentSphereEntity _datEntSetI) {
            _datEntSetI.getEntityData().set(SmallTormentSphereEntity.DATA_randomsize, Mth.nextInt(RandomSource.create(), 10, 18));
         }

         entity.getPersistentData().putBoolean("tormentor_summon", true);
         if (entity instanceof TormentorSphereEntity && entity instanceof TormentorSphereEntity _datEntSetL) {
            _datEntSetL.getEntityData().set(TormentorSphereEntity.DATA_donesize, false);
         }
      }
   }
}
