package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.TormentBlastEntity;
import net.arphex.entity.TormentRifleEntity;
import net.arphex.network.ArphexModVariables;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TormentorAimProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      boolean limitone = false;
      boolean scansnearestfirst = false;
      double ringspan = 0.0;
      double wrap_yaw = 0.0;
      double ringspin = 0.0;
      double dist = 0.0;
      double multi_blast = 0.0;
      double vary_angle = 0.0;
      double dx = 0.0;
      double dz = 0.0;
      double dy = 0.0;
      double rad = 0.0;
      double speed_boost = 0.0;
      multi_blast = 0.0;
      Vec3 _center = new Vec3(
         ArphexModVariables.MapVariables.get(world).tormentor_x,
         ArphexModVariables.MapVariables.get(world).tormentor_y,
         ArphexModVariables.MapVariables.get(world).tormentor_z
      );

      for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(125.0), e -> true)
         .stream()
         .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
         .toList()) {
         if (entityiterator instanceof TormentBlastEntity) {
            if (multi_blast == 0.0) {
               vary_angle = 0.0;
            } else if (multi_blast == 1.0) {
               vary_angle = 50.0;
            } else if (multi_blast == 2.0) {
               vary_angle = -50.0;
            } else if (multi_blast == 3.0) {
               vary_angle = 100.0;
            } else {
               vary_angle = -100.0;
            }

            if (!entityiterator.getPersistentData().getBoolean("targetdone")) {
               entityiterator.getPersistentData().putBoolean("targetdone", true);
               entityiterator.getPersistentData()
                  .putDouble(
                     "hominglink",
                     Math.sqrt(
                        Math.pow(x - entityiterator.getX(), 2.0) + Math.pow(y + 0.6 - entityiterator.getY(), 2.0) + Math.pow(z - entityiterator.getZ(), 2.0)
                     )
                  );
               dx = x - entityiterator.getX();
               dy = y - entityiterator.getY();
               dz = z - entityiterator.getZ();
               if (vary_angle != 0.0) {
                  rad = Math.abs(Math.toDegrees(Math.atan2(0.0 - dz, dx) - 90.0) % 360.0);
                  if ((!(rad > 70.0) || !(rad < 160.0)) && (!(rad > 250.0) || !(rad < 340.0))) {
                     dx = x + vary_angle - entityiterator.getX();
                  } else {
                     dz = z + vary_angle - entityiterator.getZ();
                  }
               }

               if (entityiterator.getPersistentData().getDouble("hominglink") != 0.0) {
                  if (ArphexModVariables.MapVariables.get(world).tormentor_health < 256.0) {
                     speed_boost = 2.5;
                  } else {
                     speed_boost = 1.9;
                  }

                  entityiterator.setDeltaMovement(
                     new Vec3(
                        dx / entityiterator.getPersistentData().getDouble("hominglink") * speed_boost,
                        dy / entityiterator.getPersistentData().getDouble("hominglink") * speed_boost,
                        dz / entityiterator.getPersistentData().getDouble("hominglink") * speed_boost
                     )
                  );
               }

               multi_blast++;
            }
         }

         if (entityiterator instanceof TormentRifleEntity && !entityiterator.getPersistentData().getBoolean("targetdone")) {
            entityiterator.getPersistentData().putBoolean("targetdone", true);
            entityiterator.getPersistentData()
               .putDouble(
                  "hominglink",
                  Math.sqrt(
                     Math.pow(x - entityiterator.getX(), 2.0) + Math.pow(y + 0.6 - entityiterator.getY(), 2.0) + Math.pow(z - entityiterator.getZ(), 2.0)
                  )
               );
            if (entityiterator.getPersistentData().getDouble("hominglink") != 0.0) {
               entityiterator.setDeltaMovement(
                  new Vec3(
                     (x + (double)Mth.nextInt(RandomSource.create(), -30, 30) - entityiterator.getX())
                        / entityiterator.getPersistentData().getDouble("hominglink")
                        * (2.5 + ArphexModVariables.MapVariables.get(world).tormentor_tier),
                     (y + (double)Mth.nextInt(RandomSource.create(), -30, 30) - entityiterator.getY())
                        / entityiterator.getPersistentData().getDouble("hominglink")
                        * (2.5 + ArphexModVariables.MapVariables.get(world).tormentor_tier),
                     (z + (double)Mth.nextInt(RandomSource.create(), -30, 30) - entityiterator.getZ())
                        / entityiterator.getPersistentData().getDouble("hominglink")
                        * (2.5 + ArphexModVariables.MapVariables.get(world).tormentor_tier)
                  )
               );
            }
         }
      }
   }
}
