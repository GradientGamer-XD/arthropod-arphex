package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.SpiderMothDwellerEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class VoidRepulsionOnEffectActiveTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 5, 0, false, false));
         }

         if (!world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).isEmpty()) {
            if (world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null)
                        .getPersistentData()
                        .getDouble("xver")
                     - entity.getX()
                  > 0.0
               && world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null)
                        .getPersistentData()
                        .getDouble("zver")
                     - entity.getZ()
                  > 0.0) {
               entity.getPersistentData()
                  .putDouble(
                     "xvelos",
                     (
                           0.0
                              - (
                                 world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
                                       .stream()
                                       .sorted((new Object() {
                                          Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                             return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                          }
                                       }).compareDistOf(x, y, z))
                                       .findFirst()
                                       .orElse(null)
                                       .getPersistentData()
                                       .getDouble("xver")
                                    - entity.getX()
                              )
                        )
                        * ((double)(300.0F / (200.0F + (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F))) / 1.5)
                  );
               entity.getPersistentData()
                  .putDouble(
                     "zvelos",
                     (
                           0.0
                              - (
                                 world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
                                       .stream()
                                       .sorted((new Object() {
                                          Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                             return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                          }
                                       }).compareDistOf(x, y, z))
                                       .findFirst()
                                       .orElse(null)
                                       .getPersistentData()
                                       .getDouble("zver")
                                    - entity.getZ()
                              )
                        )
                        * ((double)(300.0F / (200.0F + (entity instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F))) / 1.5)
                  );
               if (entity.getPersistentData().getDouble("xvelos") > 0.9) {
                  entity.getPersistentData().putDouble("xvelos", 0.9);
               } else if (entity.getPersistentData().getDouble("xvelos") < -0.9) {
                  entity.getPersistentData().putDouble("xvelos", -0.9);
               }

               if (entity.getPersistentData().getDouble("zvelos") > 0.9) {
                  entity.getPersistentData().putDouble("zvelos", 0.9);
               } else if (entity.getPersistentData().getDouble("zvelos") < -0.9) {
                  entity.getPersistentData().putDouble("zvelos", -0.9);
               }

               entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("xvelos"), 0.3, entity.getPersistentData().getDouble("zvelos")));
            } else if (world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null)
                        .getPersistentData()
                        .getDouble("xver")
                     - entity.getX()
                  < 0.0
               && world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null)
                        .getPersistentData()
                        .getDouble("zver")
                     - entity.getZ()
                  < 0.0) {
               entity.getPersistentData()
                  .putDouble(
                     "xvelos",
                     Math.abs(
                           world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
                                 .stream()
                                 .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                       return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                 }).compareDistOf(x, y, z))
                                 .findFirst()
                                 .orElse(null)
                                 .getPersistentData()
                                 .getDouble("xver")
                              - entity.getX()
                        )
                        * ((double)(300.0F / (200.0F + (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMaxHealth() : -1.0F))) / 1.5)
                  );
               entity.getPersistentData()
                  .putDouble(
                     "zvelos",
                     Math.abs(
                           world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
                                 .stream()
                                 .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                       return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                 }).compareDistOf(x, y, z))
                                 .findFirst()
                                 .orElse(null)
                                 .getPersistentData()
                                 .getDouble("zver")
                              - entity.getZ()
                        )
                        * ((double)(300.0F / (200.0F + (entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMaxHealth() : -1.0F))) / 1.5)
                  );
               if (entity.getPersistentData().getDouble("xvelos") > 0.9) {
                  entity.getPersistentData().putDouble("xvelos", 0.9);
               } else if (entity.getPersistentData().getDouble("xvelos") < -0.9) {
                  entity.getPersistentData().putDouble("xvelos", -0.9);
               }

               if (entity.getPersistentData().getDouble("zvelos") > 0.9) {
                  entity.getPersistentData().putDouble("zvelos", 0.9);
               } else if (entity.getPersistentData().getDouble("zvelos") < -0.9) {
                  entity.getPersistentData().putDouble("zvelos", -0.9);
               }

               entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("xvelos"), 0.3, entity.getPersistentData().getDouble("zvelos")));
            } else if (world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null)
                        .getPersistentData()
                        .getDouble("xver")
                     - entity.getX()
                  > 0.0
               && world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null)
                        .getPersistentData()
                        .getDouble("zver")
                     - entity.getZ()
                  < 0.0) {
               entity.getPersistentData()
                  .putDouble(
                     "xvelos",
                     (
                           0.0
                              - (
                                 world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
                                       .stream()
                                       .sorted((new Object() {
                                          Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                             return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                          }
                                       }).compareDistOf(x, y, z))
                                       .findFirst()
                                       .orElse(null)
                                       .getPersistentData()
                                       .getDouble("xver")
                                    - entity.getX()
                              )
                        )
                        * ((double)(300.0F / (200.0F + (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMaxHealth() : -1.0F))) / 1.5)
                  );
               entity.getPersistentData()
                  .putDouble(
                     "zvelos",
                     Math.abs(
                           world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
                                 .stream()
                                 .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                       return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                 }).compareDistOf(x, y, z))
                                 .findFirst()
                                 .orElse(null)
                                 .getPersistentData()
                                 .getDouble("zver")
                              - entity.getZ()
                        )
                        * ((double)(300.0F / (200.0F + (entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMaxHealth() : -1.0F))) / 1.5)
                  );
               if (entity.getPersistentData().getDouble("xvelos") > 0.9) {
                  entity.getPersistentData().putDouble("xvelos", 0.9);
               } else if (entity.getPersistentData().getDouble("xvelos") < -0.8) {
                  entity.getPersistentData().putDouble("xvelos", -0.9);
               }

               if (entity.getPersistentData().getDouble("zvelos") > 0.9) {
                  entity.getPersistentData().putDouble("zvelos", 0.8);
               } else if (entity.getPersistentData().getDouble("zvelos") < -0.9) {
                  entity.getPersistentData().putDouble("zvelos", -0.9);
               }

               entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("xvelos"), 0.3, entity.getPersistentData().getDouble("zvelos")));
            } else {
               entity.getPersistentData()
                  .putDouble(
                     "xvelos",
                     Math.abs(
                           world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
                                 .stream()
                                 .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                       return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                 }).compareDistOf(x, y, z))
                                 .findFirst()
                                 .orElse(null)
                                 .getPersistentData()
                                 .getDouble("xver")
                              - entity.getX()
                        )
                        * ((double)(300.0F / (200.0F + (entity instanceof LivingEntity _livEntxxxxxx ? _livEntxxxxxx.getMaxHealth() : -1.0F))) / 1.5)
                  );
               entity.getPersistentData()
                  .putDouble(
                     "zvelos",
                     (
                           0.0
                              - (
                                 world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
                                       .stream()
                                       .sorted((new Object() {
                                          Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                             return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                          }
                                       }).compareDistOf(x, y, z))
                                       .findFirst()
                                       .orElse(null)
                                       .getPersistentData()
                                       .getDouble("zver")
                                    - entity.getZ()
                              )
                        )
                        * ((double)(300.0F / (200.0F + (entity instanceof LivingEntity _livEntxxxxxxx ? _livEntxxxxxxx.getMaxHealth() : -1.0F))) / 1.5)
                  );
               if (entity.getPersistentData().getDouble("xvelos") > 0.9) {
                  entity.getPersistentData().putDouble("xvelos", 0.9);
               } else if (entity.getPersistentData().getDouble("xvelos") < -0.9) {
                  entity.getPersistentData().putDouble("xvelos", -0.9);
               }

               if (entity.getPersistentData().getDouble("zvelos") > 0.9) {
                  entity.getPersistentData().putDouble("zvelos", 0.9);
               } else if (entity.getPersistentData().getDouble("zvelos") < -0.9) {
                  entity.getPersistentData().putDouble("zvelos", -0.9);
               }

               entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("xvelos"), 0.3, entity.getPersistentData().getDouble("zvelos")));
            }
         }
      }
   }
}
