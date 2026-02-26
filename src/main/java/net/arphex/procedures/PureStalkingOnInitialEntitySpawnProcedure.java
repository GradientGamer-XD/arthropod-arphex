package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class PureStalkingOnInitialEntitySpawnProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 48.0, 48.0, 48.0), e -> true).isEmpty()) {
            entity.getPersistentData().putBoolean("spawnedaway", false);
         } else {
            entity.getPersistentData().putBoolean("spawnedaway", true);
         }

         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).isEmpty()
            && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 60.0, 60.0, 60.0), e -> true).isEmpty()
            && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z)).findFirst().orElse(null).getPersistentData().getBoolean("creativespectator")) {
            if (world.isEmptyBlock(
               BlockPos.containing(
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getX() + 20.0,
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ()
               )
            )) {
               entity.teleportTo(
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getX() + 20.0,
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ()
               );
               if (entity instanceof ServerPlayer _serverPlayer) {
                  _serverPlayer.connection
                     .teleport(
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getX() + 20.0,
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ(),
                        entity.getYRot(),
                        entity.getXRot()
                     );
               }
            } else if (world.isEmptyBlock(
               BlockPos.containing(
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getX() - 20.0,
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ()
               )
            )) {
               entity.teleportTo(
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getX() - 20.0,
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ()
               );
               if (entity instanceof ServerPlayer _serverPlayer) {
                  _serverPlayer.connection
                     .teleport(
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getX() - 20.0,
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ(),
                        entity.getYRot(),
                        entity.getXRot()
                     );
               }
            } else if (world.isEmptyBlock(
               BlockPos.containing(
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getX(),
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ() + 20.0
               )
            )) {
               entity.teleportTo(
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getX(),
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ() + 20.0
               );
               if (entity instanceof ServerPlayer _serverPlayer) {
                  _serverPlayer.connection
                     .teleport(
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getX(),
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ() + 20.0,
                        entity.getYRot(),
                        entity.getXRot()
                     );
               }
            } else if (world.isEmptyBlock(
               BlockPos.containing(
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getX(),
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ() - 20.0
               )
            )) {
               entity.teleportTo(
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getX(),
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ() - 20.0
               );
               if (entity instanceof ServerPlayer _serverPlayer) {
                  _serverPlayer.connection
                     .teleport(
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getX(),
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ() - 20.0,
                        entity.getYRot(),
                        entity.getXRot()
                     );
               }
            }
         }

         ArphexMod.queueServerWork(
            200,
            () -> {
               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).isEmpty()
                  && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 80.0, 80.0, 80.0), e -> true).isEmpty()
                  && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getPersistentData().getBoolean("creativespectator")) {
                  if (world.isEmptyBlock(
                     BlockPos.containing(
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getX() + 20.0,
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ()
                     )
                  )) {
                     entity.teleportTo(
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getX() + 20.0,
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ()
                     );
                     if (entity instanceof ServerPlayer _serverPlayerxxxx) {
                        _serverPlayerxxxx.connection
                           .teleport(
                              world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true)
                                    .stream()
                                    .sorted((new Object() {
                                       Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                          return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                       }
                                    }).compareDistOf(x, y, z))
                                    .findFirst()
                                    .orElse(null)
                                    .getX()
                                 + 20.0,
                              world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true)
                                 .stream()
                                 .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                       return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                 }).compareDistOf(x, y, z))
                                 .findFirst()
                                 .orElse(null)
                                 .getY(),
                              world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true)
                                 .stream()
                                 .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                       return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                 }).compareDistOf(x, y, z))
                                 .findFirst()
                                 .orElse(null)
                                 .getZ(),
                              entity.getYRot(),
                              entity.getXRot()
                           );
                     }
                  } else if (world.isEmptyBlock(
                     BlockPos.containing(
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getX() - 20.0,
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ()
                     )
                  )) {
                     entity.teleportTo(
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getX() - 20.0,
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ()
                     );
                     if (entity instanceof ServerPlayer _serverPlayerxxx) {
                        _serverPlayerxxx.connection
                           .teleport(
                              world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true)
                                    .stream()
                                    .sorted((new Object() {
                                       Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                          return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                       }
                                    }).compareDistOf(x, y, z))
                                    .findFirst()
                                    .orElse(null)
                                    .getX()
                                 - 20.0,
                              world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true)
                                 .stream()
                                 .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                       return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                 }).compareDistOf(x, y, z))
                                 .findFirst()
                                 .orElse(null)
                                 .getY(),
                              world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true)
                                 .stream()
                                 .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                       return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                 }).compareDistOf(x, y, z))
                                 .findFirst()
                                 .orElse(null)
                                 .getZ(),
                              entity.getYRot(),
                              entity.getXRot()
                           );
                     }
                  } else if (world.isEmptyBlock(
                     BlockPos.containing(
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getX(),
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ() + 20.0
                     )
                  )) {
                     entity.teleportTo(
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getX(),
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ() + 20.0
                     );
                     if (entity instanceof ServerPlayer _serverPlayerxx) {
                        _serverPlayerxx.connection
                           .teleport(
                              world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true)
                                 .stream()
                                 .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                       return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                 }).compareDistOf(x, y, z))
                                 .findFirst()
                                 .orElse(null)
                                 .getX(),
                              world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true)
                                 .stream()
                                 .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                       return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                 }).compareDistOf(x, y, z))
                                 .findFirst()
                                 .orElse(null)
                                 .getY(),
                              world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true)
                                    .stream()
                                    .sorted((new Object() {
                                       Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                          return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                       }
                                    }).compareDistOf(x, y, z))
                                    .findFirst()
                                    .orElse(null)
                                    .getZ()
                                 + 20.0,
                              entity.getYRot(),
                              entity.getXRot()
                           );
                     }
                  } else if (world.isEmptyBlock(
                     BlockPos.containing(
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getX(),
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ() - 20.0
                     )
                  )) {
                     entity.teleportTo(
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getX(),
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ() - 20.0
                     );
                     if (entity instanceof ServerPlayer _serverPlayerx) {
                        _serverPlayerx.connection
                           .teleport(
                              world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true)
                                 .stream()
                                 .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                       return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                 }).compareDistOf(x, y, z))
                                 .findFirst()
                                 .orElse(null)
                                 .getX(),
                              world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true)
                                 .stream()
                                 .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                       return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                 }).compareDistOf(x, y, z))
                                 .findFirst()
                                 .orElse(null)
                                 .getY(),
                              world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true)
                                    .stream()
                                    .sorted((new Object() {
                                       Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                          return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                       }
                                    }).compareDistOf(x, y, z))
                                    .findFirst()
                                    .orElse(null)
                                    .getZ()
                                 - 20.0,
                              entity.getYRot(),
                              entity.getXRot()
                           );
                     }
                  }
               }
            }
         );
         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "execute as @e[type=arphex:pure_stalking,limit=1,sort=nearest] run data merge entity @s {Invulnerable:1}"
               );
         }

         ArphexMod.queueServerWork(
            180,
            () -> {
               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 60.0, 60.0, 60.0), e -> true).isEmpty()
                  && !entity.level().isClientSide()) {
                  entity.discard();
               }
            }
         );
         ArphexMod.queueServerWork(
            500,
            () -> {
               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 90.0, 90.0, 90.0), e -> true).isEmpty()) {
                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }

                  if (Mth.nextInt(RandomSource.create(), 1, 3) == 3) {
                     if (world instanceof ServerLevel _levelxx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.TELEPORT_GHOST.get())
                           .spawn(_levelxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  } else if (world instanceof ServerLevel _levelx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.RUSH_SCARE.get())
                        .spawn(_levelx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               }
            }
         );
         ArphexMod.queueServerWork(600, () -> {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }

            if (world instanceof ServerLevel _levelx) {
               _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARRED_BLOOD.get(), x, y, z, 200, 3.0, 3.0, 3.0, 1.0);
            }
         });
      }
   }
}
