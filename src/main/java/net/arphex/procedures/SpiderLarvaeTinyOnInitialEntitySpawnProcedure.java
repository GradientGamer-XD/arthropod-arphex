package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.GiantWebEntity;
import net.arphex.entity.SpiderLarvaeEntity;
import net.arphex.entity.SpiderLarvaeTinyEntity;
import net.arphex.entity.SpiderSnatcherEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SpiderLarvaeTinyOnInitialEntitySpawnProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putBoolean("spidergrab", false);
         if (world.getEntitiesOfClass(SpiderSnatcherEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()
            && world.getEntitiesOfClass(GiantWebEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
            ArphexMod.queueServerWork(
               1,
               () -> {
                  if (!world.getEntitiesOfClass(SpiderLarvaeEntity.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true).isEmpty()) {
                     if (world.getEntitiesOfClass(SpiderLarvaeEntity.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null)
                        .getPersistentData()
                        .getString("spidershade")
                        .equals("widow")) {
                        if (entity instanceof SpiderLarvaeTinyEntity animatablexxxxxxxxx) {
                           animatablexxxxxxxxx.setTexture("spiderwidow");
                        }
                     } else if (world.getEntitiesOfClass(SpiderLarvaeEntity.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null)
                        .getPersistentData()
                        .getString("spidershade")
                        .equals("2")) {
                        if (entity instanceof SpiderLarvaeTinyEntity animatablexxxxxxxx) {
                           animatablexxxxxxxx.setTexture("spiderlarvae2");
                        }
                     } else if (world.getEntitiesOfClass(SpiderLarvaeEntity.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null)
                        .getPersistentData()
                        .getString("spidershade")
                        .equals("3")) {
                        if (entity instanceof SpiderLarvaeTinyEntity animatablexxxxxxx) {
                           animatablexxxxxxx.setTexture("spiderlarvae3");
                        }
                     } else if (world.getEntitiesOfClass(SpiderLarvaeEntity.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null)
                        .getPersistentData()
                        .getString("spidershade")
                        .equals("4")) {
                        if (entity instanceof SpiderLarvaeTinyEntity animatablexxxxxx) {
                           animatablexxxxxx.setTexture("spiderlarvae4");
                        }
                     } else if (world.getEntitiesOfClass(SpiderLarvaeEntity.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null)
                           .getPersistentData()
                           .getString("spidershade")
                           .equals("5")
                        && entity instanceof SpiderLarvaeTinyEntity animatablexxxxx) {
                        animatablexxxxx.setTexture("spiderlarvae5");
                     }
                  } else {
                     if (Mth.nextInt(RandomSource.create(), 1, 6) == 3 && entity instanceof SpiderLarvaeTinyEntity animatablexxxx) {
                        animatablexxxx.setTexture("spiderlarvae2");
                     }

                     if (Mth.nextInt(RandomSource.create(), 1, 6) == 2 && entity instanceof SpiderLarvaeTinyEntity animatablexxx) {
                        animatablexxx.setTexture("spiderlarvae3");
                     }

                     if (Mth.nextInt(RandomSource.create(), 1, 60) == 1 && entity instanceof SpiderLarvaeTinyEntity animatablexx) {
                        animatablexx.setTexture("spiderlarvae4");
                     }

                     if (Mth.nextInt(RandomSource.create(), 1, 6) == 4 && entity instanceof SpiderLarvaeTinyEntity animatablex) {
                        animatablex.setTexture("spiderlarvae5");
                     }
                  }
               }
            );
         } else {
            if (entity instanceof Mob _entity) {
               Entity var12 = world.getEntitiesOfClass(SpiderSnatcherEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null);
               if ((var12 instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity _ent) {
                  _entity.setTarget(_ent);
               }
            }

            if (entity instanceof SpiderLarvaeTinyEntity animatable) {
               animatable.setTexture("spiderwidow");
            }
         }

         entity.getPersistentData().putDouble("climbradius", 0.7);
      }
   }
}
