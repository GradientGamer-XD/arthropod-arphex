package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.entity.CentipedeEvictorEntity;
import net.arphex.entity.CentipedeEvictorLarvaeEntity;
import net.arphex.entity.TinyCentipedeBreacherEntity;
import net.arphex.network.ArphexModVariables;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class CentipedeEvictorLarvaeOnInitialEntitySpawnProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity instanceof CentipedeEvictorLarvaeEntity) {
            if (Mth.nextInt(RandomSource.create(), 1, 5) == 5
               && world.getEntitiesOfClass(CentipedeEvictorEntity.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).isEmpty()) {
               if (entity instanceof CentipedeEvictorLarvaeEntity animatable) {
                  animatable.setTexture("centipedeevictorboss");
               }

               if (entity instanceof CentipedeEvictorLarvaeEntity _datEntSetL) {
                  _datEntSetL.getEntityData().set(CentipedeEvictorLarvaeEntity.DATA_stronger, true);
               }
            }

            if (ArphexModVariables.MapVariables.get(world).gem_mob_challenge) {
               ArphexMod.queueServerWork(2, () -> {
                  if (Mth.nextInt(RandomSource.create(), 1, 650) == 4) {
                     if (entity instanceof CentipedeEvictorLarvaeEntity _datEntSetLx) {
                        _datEntSetLx.getEntityData().set(CentipedeEvictorLarvaeEntity.DATA_shinier, true);
                     }

                     if (entity instanceof CentipedeEvictorLarvaeEntity animatable) {
                        animatable.setTexture("sapphire_mob");
                     }
                  }
               });
            }
         }

         if (entity instanceof TinyCentipedeBreacherEntity) {
            ArphexMod.queueServerWork(1200, () -> {
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            });
         }

         entity.getPersistentData().putDouble("climbradius", 1.1);
      }
   }
}
