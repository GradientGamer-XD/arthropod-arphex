package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.AntArsonistWorkerEntity;
import net.arphex.init.ArphexModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AntCommanderItemInInventoryTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity.getPersistentData().getDouble("antblocktimer") > 0.0) {
            entity.getPersistentData().putDouble("antblocktimer", entity.getPersistentData().getDouble("antblocktimer") - 1.0);
            if (entity.getPersistentData().getDouble("antblocktimer") == 147.0) {
               if (!world.getEntitiesOfClass(
                     AntArsonistWorkerEntity.class,
                     AABB.ofSize(
                        new Vec3(
                           entity.getPersistentData().getDouble("antbuildx"),
                           entity.getPersistentData().getDouble("antbuildy"),
                           entity.getPersistentData().getDouble("antbuildz")
                        ),
                        15.0,
                        15.0,
                        15.0
                     ),
                     e -> true
                  )
                  .isEmpty()) {
                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + 3.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 0.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + 0.0);
                  if (world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )
                     && !world.isClientSide()) {
                     world.setBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        ),
                        ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                        3
                     );
                  }

                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + 2.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 0.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + -1.0);
                  if (world.isEmptyBlock(
                     BlockPos.containing(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y"),
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     )
                  )) {
                     Entity _ent = world.getEntitiesOfClass(
                           AntArsonistWorkerEntity.class,
                           AABB.ofSize(
                              new Vec3(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              ),
                              15.0,
                              15.0,
                              15.0
                           ),
                           e -> true
                        )
                        .stream()
                        .sorted(
                           (new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              })
                              .compareDistOf(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              )
                        )
                        .findFirst()
                        .orElse(null);
                     _ent.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_ent instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _ent.getYRot(),
                              _ent.getXRot()
                           );
                     }

                     if (!world.isClientSide()) {
                        world.setBlock(
                           BlockPos.containing(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y"),
                              entity.getPersistentData().getDouble("antbuild_aux_z")
                           ),
                           ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                           3
                        );
                     }
                  }
               } else if (!world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                  Entity _entx = world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (_entx instanceof TamableAnimal _tamIsTamedBy
                     && entity instanceof LivingEntity _livEnt
                     && _tamIsTamedBy.isOwnedBy(_livEnt)
                     && world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )) {
                     _entx = world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     _entx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entx.getYRot(),
                              _entx.getXRot()
                           );
                     }
                  }
               }
            }

            if (entity.getPersistentData().getDouble("antblocktimer") == 140.0) {
               if (!world.getEntitiesOfClass(
                     AntArsonistWorkerEntity.class,
                     AABB.ofSize(
                        new Vec3(
                           entity.getPersistentData().getDouble("antbuildx"),
                           entity.getPersistentData().getDouble("antbuildy"),
                           entity.getPersistentData().getDouble("antbuildz")
                        ),
                        15.0,
                        15.0,
                        15.0
                     ),
                     e -> true
                  )
                  .isEmpty()) {
                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + 1.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 0.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + -2.0);
                  if (world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )
                     && !world.isClientSide()) {
                     world.setBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        ),
                        ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                        3
                     );
                  }

                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + 0.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 0.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + -3.0);
                  if (world.isEmptyBlock(
                     BlockPos.containing(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y"),
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     )
                  )) {
                     Entity _entx = world.getEntitiesOfClass(
                           AntArsonistWorkerEntity.class,
                           AABB.ofSize(
                              new Vec3(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              ),
                              15.0,
                              15.0,
                              15.0
                           ),
                           e -> true
                        )
                        .stream()
                        .sorted(
                           (new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              })
                              .compareDistOf(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              )
                        )
                        .findFirst()
                        .orElse(null);
                     _entx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entx.getYRot(),
                              _entx.getXRot()
                           );
                     }

                     if (!world.isClientSide()) {
                        world.setBlock(
                           BlockPos.containing(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y"),
                              entity.getPersistentData().getDouble("antbuild_aux_z")
                           ),
                           ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                           3
                        );
                     }
                  }
               } else if (!world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                  Entity _entxx = world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (_entxx instanceof TamableAnimal _tamIsTamedByx
                     && entity instanceof LivingEntity _livEntx
                     && _tamIsTamedByx.isOwnedBy(_livEntx)
                     && world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )) {
                     _entxx = world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     _entxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxx.getYRot(),
                              _entxx.getXRot()
                           );
                     }
                  }
               }
            }

            if (entity.getPersistentData().getDouble("antblocktimer") == 133.0) {
               if (!world.getEntitiesOfClass(
                     AntArsonistWorkerEntity.class,
                     AABB.ofSize(
                        new Vec3(
                           entity.getPersistentData().getDouble("antbuildx"),
                           entity.getPersistentData().getDouble("antbuildy"),
                           entity.getPersistentData().getDouble("antbuildz")
                        ),
                        15.0,
                        15.0,
                        15.0
                     ),
                     e -> true
                  )
                  .isEmpty()) {
                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + -1.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 0.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + -2.0);
                  if (world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )
                     && !world.isClientSide()) {
                     world.setBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        ),
                        ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                        3
                     );
                  }

                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + -2.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 0.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + -1.0);
                  if (world.isEmptyBlock(
                     BlockPos.containing(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y"),
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     )
                  )) {
                     Entity _entxx = world.getEntitiesOfClass(
                           AntArsonistWorkerEntity.class,
                           AABB.ofSize(
                              new Vec3(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              ),
                              15.0,
                              15.0,
                              15.0
                           ),
                           e -> true
                        )
                        .stream()
                        .sorted(
                           (new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              })
                              .compareDistOf(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              )
                        )
                        .findFirst()
                        .orElse(null);
                     _entxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxx.getYRot(),
                              _entxx.getXRot()
                           );
                     }

                     if (!world.isClientSide()) {
                        world.setBlock(
                           BlockPos.containing(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y"),
                              entity.getPersistentData().getDouble("antbuild_aux_z")
                           ),
                           ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                           3
                        );
                     }
                  }
               } else if (!world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                  Entity _entxxx = world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (_entxxx instanceof TamableAnimal _tamIsTamedByxx
                     && entity instanceof LivingEntity _livEntxx
                     && _tamIsTamedByxx.isOwnedBy(_livEntxx)
                     && world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )) {
                     _entxxx = world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     _entxxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxxx.getYRot(),
                              _entxxx.getXRot()
                           );
                     }
                  }
               }
            }

            if (entity.getPersistentData().getDouble("antblocktimer") == 126.0) {
               if (!world.getEntitiesOfClass(
                     AntArsonistWorkerEntity.class,
                     AABB.ofSize(
                        new Vec3(
                           entity.getPersistentData().getDouble("antbuildx"),
                           entity.getPersistentData().getDouble("antbuildy"),
                           entity.getPersistentData().getDouble("antbuildz")
                        ),
                        15.0,
                        15.0,
                        15.0
                     ),
                     e -> true
                  )
                  .isEmpty()) {
                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + -3.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 0.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + 0.0);
                  if (world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )
                     && !world.isClientSide()) {
                     world.setBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        ),
                        ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                        3
                     );
                  }

                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + -2.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 0.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + 1.0);
                  if (world.isEmptyBlock(
                     BlockPos.containing(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y"),
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     )
                  )) {
                     Entity _entxxx = world.getEntitiesOfClass(
                           AntArsonistWorkerEntity.class,
                           AABB.ofSize(
                              new Vec3(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              ),
                              15.0,
                              15.0,
                              15.0
                           ),
                           e -> true
                        )
                        .stream()
                        .sorted(
                           (new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              })
                              .compareDistOf(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              )
                        )
                        .findFirst()
                        .orElse(null);
                     _entxxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxxx.getYRot(),
                              _entxxx.getXRot()
                           );
                     }

                     if (!world.isClientSide()) {
                        world.setBlock(
                           BlockPos.containing(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y"),
                              entity.getPersistentData().getDouble("antbuild_aux_z")
                           ),
                           ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                           3
                        );
                     }
                  }
               } else if (!world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                  Entity _entxxxx = world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (_entxxxx instanceof TamableAnimal _tamIsTamedByxxx
                     && entity instanceof LivingEntity _livEntxxx
                     && _tamIsTamedByxxx.isOwnedBy(_livEntxxx)
                     && world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )) {
                     _entxxxx = world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     _entxxxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxxxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxxxx.getYRot(),
                              _entxxxx.getXRot()
                           );
                     }
                  }
               }
            }

            if (entity.getPersistentData().getDouble("antblocktimer") == 119.0) {
               if (!world.getEntitiesOfClass(
                     AntArsonistWorkerEntity.class,
                     AABB.ofSize(
                        new Vec3(
                           entity.getPersistentData().getDouble("antbuildx"),
                           entity.getPersistentData().getDouble("antbuildy"),
                           entity.getPersistentData().getDouble("antbuildz")
                        ),
                        15.0,
                        15.0,
                        15.0
                     ),
                     e -> true
                  )
                  .isEmpty()) {
                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + -1.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 0.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + 2.0);
                  if (world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )
                     && !world.isClientSide()) {
                     world.setBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        ),
                        ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                        3
                     );
                  }

                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + 0.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 0.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + 3.0);
                  if (world.isEmptyBlock(
                     BlockPos.containing(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y"),
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     )
                  )) {
                     Entity _entxxxx = world.getEntitiesOfClass(
                           AntArsonistWorkerEntity.class,
                           AABB.ofSize(
                              new Vec3(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              ),
                              15.0,
                              15.0,
                              15.0
                           ),
                           e -> true
                        )
                        .stream()
                        .sorted(
                           (new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              })
                              .compareDistOf(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              )
                        )
                        .findFirst()
                        .orElse(null);
                     _entxxxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxxxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxxxx.getYRot(),
                              _entxxxx.getXRot()
                           );
                     }

                     if (!world.isClientSide()) {
                        world.setBlock(
                           BlockPos.containing(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y"),
                              entity.getPersistentData().getDouble("antbuild_aux_z")
                           ),
                           ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                           3
                        );
                     }
                  }
               } else if (!world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                  Entity _entxxxxx = world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (_entxxxxx instanceof TamableAnimal _tamIsTamedByxxxx
                     && entity instanceof LivingEntity _livEntxxxx
                     && _tamIsTamedByxxxx.isOwnedBy(_livEntxxxx)
                     && world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )) {
                     _entxxxxx = world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     _entxxxxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxxxxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxxxxx.getYRot(),
                              _entxxxxx.getXRot()
                           );
                     }
                  }
               }
            }

            if (entity.getPersistentData().getDouble("antblocktimer") == 112.0) {
               if (!world.getEntitiesOfClass(
                     AntArsonistWorkerEntity.class,
                     AABB.ofSize(
                        new Vec3(
                           entity.getPersistentData().getDouble("antbuildx"),
                           entity.getPersistentData().getDouble("antbuildy"),
                           entity.getPersistentData().getDouble("antbuildz")
                        ),
                        15.0,
                        15.0,
                        15.0
                     ),
                     e -> true
                  )
                  .isEmpty()) {
                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + 1.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 0.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + 2.0);
                  if (world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )
                     && !world.isClientSide()) {
                     world.setBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        ),
                        ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                        3
                     );
                  }

                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + 2.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 0.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + 1.0);
                  if (world.isEmptyBlock(
                     BlockPos.containing(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y"),
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     )
                  )) {
                     Entity _entxxxxx = world.getEntitiesOfClass(
                           AntArsonistWorkerEntity.class,
                           AABB.ofSize(
                              new Vec3(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              ),
                              15.0,
                              15.0,
                              15.0
                           ),
                           e -> true
                        )
                        .stream()
                        .sorted(
                           (new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              })
                              .compareDistOf(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              )
                        )
                        .findFirst()
                        .orElse(null);
                     _entxxxxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxxxxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxxxxx.getYRot(),
                              _entxxxxx.getXRot()
                           );
                     }

                     if (!world.isClientSide()) {
                        world.setBlock(
                           BlockPos.containing(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y"),
                              entity.getPersistentData().getDouble("antbuild_aux_z")
                           ),
                           ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                           3
                        );
                     }
                  }
               } else if (!world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                  Entity _entxxxxxx = world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (_entxxxxxx instanceof TamableAnimal _tamIsTamedByxxxxx
                     && entity instanceof LivingEntity _livEntxxxxx
                     && _tamIsTamedByxxxxx.isOwnedBy(_livEntxxxxx)
                     && world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )) {
                     _entxxxxxx = world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     _entxxxxxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxxxxxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxxxxxx.getYRot(),
                              _entxxxxxx.getXRot()
                           );
                     }
                  }
               }
            }

            if (entity.getPersistentData().getDouble("antblocktimer") == 105.0) {
               if (!world.getEntitiesOfClass(
                     AntArsonistWorkerEntity.class,
                     AABB.ofSize(
                        new Vec3(
                           entity.getPersistentData().getDouble("antbuildx"),
                           entity.getPersistentData().getDouble("antbuildy"),
                           entity.getPersistentData().getDouble("antbuildz")
                        ),
                        15.0,
                        15.0,
                        15.0
                     ),
                     e -> true
                  )
                  .isEmpty()) {
                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + 3.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 0.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + -1.0);
                  if (world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )
                     && !world.isClientSide()) {
                     world.setBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        ),
                        ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                        3
                     );
                  }

                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + 3.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 1.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + 0.0);
                  if (world.isEmptyBlock(
                     BlockPos.containing(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y"),
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     )
                  )) {
                     Entity _entxxxxxx = world.getEntitiesOfClass(
                           AntArsonistWorkerEntity.class,
                           AABB.ofSize(
                              new Vec3(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              ),
                              15.0,
                              15.0,
                              15.0
                           ),
                           e -> true
                        )
                        .stream()
                        .sorted(
                           (new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              })
                              .compareDistOf(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              )
                        )
                        .findFirst()
                        .orElse(null);
                     _entxxxxxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxxxxxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxxxxxx.getYRot(),
                              _entxxxxxx.getXRot()
                           );
                     }

                     if (!world.isClientSide()) {
                        world.setBlock(
                           BlockPos.containing(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y"),
                              entity.getPersistentData().getDouble("antbuild_aux_z")
                           ),
                           ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                           3
                        );
                     }
                  }
               } else if (!world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                  Entity _entxxxxxxx = world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (_entxxxxxxx instanceof TamableAnimal _tamIsTamedByxxxxxx
                     && entity instanceof LivingEntity _livEntxxxxxx
                     && _tamIsTamedByxxxxxx.isOwnedBy(_livEntxxxxxx)
                     && world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )) {
                     _entxxxxxxx = world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     _entxxxxxxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxxxxxxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxxxxxxx.getYRot(),
                              _entxxxxxxx.getXRot()
                           );
                     }
                  }
               }
            }

            if (entity.getPersistentData().getDouble("antblocktimer") == 98.0) {
               if (!world.getEntitiesOfClass(
                     AntArsonistWorkerEntity.class,
                     AABB.ofSize(
                        new Vec3(
                           entity.getPersistentData().getDouble("antbuildx"),
                           entity.getPersistentData().getDouble("antbuildy"),
                           entity.getPersistentData().getDouble("antbuildz")
                        ),
                        15.0,
                        15.0,
                        15.0
                     ),
                     e -> true
                  )
                  .isEmpty()) {
                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + 2.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 1.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + -1.0);
                  if (world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )
                     && !world.isClientSide()) {
                     world.setBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        ),
                        ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                        3
                     );
                  }

                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + 1.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 1.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + -2.0);
                  if (world.isEmptyBlock(
                     BlockPos.containing(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y"),
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     )
                  )) {
                     Entity _entxxxxxxx = world.getEntitiesOfClass(
                           AntArsonistWorkerEntity.class,
                           AABB.ofSize(
                              new Vec3(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              ),
                              15.0,
                              15.0,
                              15.0
                           ),
                           e -> true
                        )
                        .stream()
                        .sorted(
                           (new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              })
                              .compareDistOf(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              )
                        )
                        .findFirst()
                        .orElse(null);
                     _entxxxxxxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxxxxxxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxxxxxxx.getYRot(),
                              _entxxxxxxx.getXRot()
                           );
                     }

                     if (!world.isClientSide()) {
                        world.setBlock(
                           BlockPos.containing(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y"),
                              entity.getPersistentData().getDouble("antbuild_aux_z")
                           ),
                           ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                           3
                        );
                     }
                  }
               } else if (!world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                  Entity _entxxxxxxxx = world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (_entxxxxxxxx instanceof TamableAnimal _tamIsTamedByxxxxxxx
                     && entity instanceof LivingEntity _livEntxxxxxxx
                     && _tamIsTamedByxxxxxxx.isOwnedBy(_livEntxxxxxxx)
                     && world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )) {
                     _entxxxxxxxx = world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     _entxxxxxxxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxxxxxxxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxxxxxxxx.getYRot(),
                              _entxxxxxxxx.getXRot()
                           );
                     }
                  }
               }
            }

            if (entity.getPersistentData().getDouble("antblocktimer") == 91.0) {
               if (!world.getEntitiesOfClass(
                     AntArsonistWorkerEntity.class,
                     AABB.ofSize(
                        new Vec3(
                           entity.getPersistentData().getDouble("antbuildx"),
                           entity.getPersistentData().getDouble("antbuildy"),
                           entity.getPersistentData().getDouble("antbuildz")
                        ),
                        15.0,
                        15.0,
                        15.0
                     ),
                     e -> true
                  )
                  .isEmpty()) {
                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + 0.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 1.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + -3.0);
                  if (world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )
                     && !world.isClientSide()) {
                     world.setBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        ),
                        ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                        3
                     );
                  }

                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + -1.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 0.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + -3.0);
                  if (world.isEmptyBlock(
                     BlockPos.containing(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y"),
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     )
                  )) {
                     Entity _entxxxxxxxx = world.getEntitiesOfClass(
                           AntArsonistWorkerEntity.class,
                           AABB.ofSize(
                              new Vec3(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              ),
                              15.0,
                              15.0,
                              15.0
                           ),
                           e -> true
                        )
                        .stream()
                        .sorted(
                           (new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              })
                              .compareDistOf(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              )
                        )
                        .findFirst()
                        .orElse(null);
                     _entxxxxxxxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxxxxxxxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxxxxxxxx.getYRot(),
                              _entxxxxxxxx.getXRot()
                           );
                     }

                     if (!world.isClientSide()) {
                        world.setBlock(
                           BlockPos.containing(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y"),
                              entity.getPersistentData().getDouble("antbuild_aux_z")
                           ),
                           ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                           3
                        );
                     }
                  }
               } else if (!world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                  Entity _entxxxxxxxxx = world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (_entxxxxxxxxx instanceof TamableAnimal _tamIsTamedByxxxxxxxx
                     && entity instanceof LivingEntity _livEntxxxxxxxx
                     && _tamIsTamedByxxxxxxxx.isOwnedBy(_livEntxxxxxxxx)
                     && world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )) {
                     _entxxxxxxxxx = world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     _entxxxxxxxxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxxxxxxxxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxxxxxxxxx.getYRot(),
                              _entxxxxxxxxx.getXRot()
                           );
                     }
                  }
               }
            }

            if (entity.getPersistentData().getDouble("antblocktimer") == 84.0) {
               if (!world.getEntitiesOfClass(
                     AntArsonistWorkerEntity.class,
                     AABB.ofSize(
                        new Vec3(
                           entity.getPersistentData().getDouble("antbuildx"),
                           entity.getPersistentData().getDouble("antbuildy"),
                           entity.getPersistentData().getDouble("antbuildz")
                        ),
                        15.0,
                        15.0,
                        15.0
                     ),
                     e -> true
                  )
                  .isEmpty()) {
                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + -1.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 1.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + -2.0);
                  if (world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )
                     && !world.isClientSide()) {
                     world.setBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        ),
                        ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                        3
                     );
                  }

                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + -2.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 1.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + -1.0);
                  if (world.isEmptyBlock(
                     BlockPos.containing(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y"),
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     )
                  )) {
                     Entity _entxxxxxxxxx = world.getEntitiesOfClass(
                           AntArsonistWorkerEntity.class,
                           AABB.ofSize(
                              new Vec3(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              ),
                              15.0,
                              15.0,
                              15.0
                           ),
                           e -> true
                        )
                        .stream()
                        .sorted(
                           (new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              })
                              .compareDistOf(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              )
                        )
                        .findFirst()
                        .orElse(null);
                     _entxxxxxxxxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxxxxxxxxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxxxxxxxxx.getYRot(),
                              _entxxxxxxxxx.getXRot()
                           );
                     }

                     if (!world.isClientSide()) {
                        world.setBlock(
                           BlockPos.containing(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y"),
                              entity.getPersistentData().getDouble("antbuild_aux_z")
                           ),
                           ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                           3
                        );
                     }
                  }
               } else if (!world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                  Entity _entxxxxxxxxxx = world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (_entxxxxxxxxxx instanceof TamableAnimal _tamIsTamedByxxxxxxxxx
                     && entity instanceof LivingEntity _livEntxxxxxxxxx
                     && _tamIsTamedByxxxxxxxxx.isOwnedBy(_livEntxxxxxxxxx)
                     && world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )) {
                     _entxxxxxxxxxx = world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     _entxxxxxxxxxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxxxxxxxxxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxxxxxxxxxx.getYRot(),
                              _entxxxxxxxxxx.getXRot()
                           );
                     }
                  }
               }
            }

            if (entity.getPersistentData().getDouble("antblocktimer") == 77.0) {
               if (!world.getEntitiesOfClass(
                     AntArsonistWorkerEntity.class,
                     AABB.ofSize(
                        new Vec3(
                           entity.getPersistentData().getDouble("antbuildx"),
                           entity.getPersistentData().getDouble("antbuildy"),
                           entity.getPersistentData().getDouble("antbuildz")
                        ),
                        15.0,
                        15.0,
                        15.0
                     ),
                     e -> true
                  )
                  .isEmpty()) {
                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + -3.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 1.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + 0.0);
                  if (world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )
                     && !world.isClientSide()) {
                     world.setBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        ),
                        ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                        3
                     );
                  }

                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + -3.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 0.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + 1.0);
                  if (world.isEmptyBlock(
                     BlockPos.containing(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y"),
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     )
                  )) {
                     Entity _entxxxxxxxxxx = world.getEntitiesOfClass(
                           AntArsonistWorkerEntity.class,
                           AABB.ofSize(
                              new Vec3(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              ),
                              15.0,
                              15.0,
                              15.0
                           ),
                           e -> true
                        )
                        .stream()
                        .sorted(
                           (new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              })
                              .compareDistOf(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              )
                        )
                        .findFirst()
                        .orElse(null);
                     _entxxxxxxxxxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxxxxxxxxxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxxxxxxxxxx.getYRot(),
                              _entxxxxxxxxxx.getXRot()
                           );
                     }

                     if (!world.isClientSide()) {
                        world.setBlock(
                           BlockPos.containing(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y"),
                              entity.getPersistentData().getDouble("antbuild_aux_z")
                           ),
                           ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                           3
                        );
                     }
                  }
               } else if (!world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                  Entity _entxxxxxxxxxxx = world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (_entxxxxxxxxxxx instanceof TamableAnimal _tamIsTamedByxxxxxxxxxx
                     && entity instanceof LivingEntity _livEntxxxxxxxxxx
                     && _tamIsTamedByxxxxxxxxxx.isOwnedBy(_livEntxxxxxxxxxx)
                     && world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )) {
                     _entxxxxxxxxxxx = world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     _entxxxxxxxxxxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxxxxxxxxxxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxxxxxxxxxxx.getYRot(),
                              _entxxxxxxxxxxx.getXRot()
                           );
                     }
                  }
               }
            }

            if (entity.getPersistentData().getDouble("antblocktimer") == 70.0) {
               if (!world.getEntitiesOfClass(
                     AntArsonistWorkerEntity.class,
                     AABB.ofSize(
                        new Vec3(
                           entity.getPersistentData().getDouble("antbuildx"),
                           entity.getPersistentData().getDouble("antbuildy"),
                           entity.getPersistentData().getDouble("antbuildz")
                        ),
                        15.0,
                        15.0,
                        15.0
                     ),
                     e -> true
                  )
                  .isEmpty()) {
                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + -2.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 1.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + 1.0);
                  if (world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )
                     && !world.isClientSide()) {
                     world.setBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        ),
                        ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                        3
                     );
                  }

                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + -1.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 1.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + 2.0);
                  if (world.isEmptyBlock(
                     BlockPos.containing(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y"),
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     )
                  )) {
                     Entity _entxxxxxxxxxxx = world.getEntitiesOfClass(
                           AntArsonistWorkerEntity.class,
                           AABB.ofSize(
                              new Vec3(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              ),
                              15.0,
                              15.0,
                              15.0
                           ),
                           e -> true
                        )
                        .stream()
                        .sorted(
                           (new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              })
                              .compareDistOf(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              )
                        )
                        .findFirst()
                        .orElse(null);
                     _entxxxxxxxxxxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxxxxxxxxxxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxxxxxxxxxxx.getYRot(),
                              _entxxxxxxxxxxx.getXRot()
                           );
                     }

                     if (!world.isClientSide()) {
                        world.setBlock(
                           BlockPos.containing(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y"),
                              entity.getPersistentData().getDouble("antbuild_aux_z")
                           ),
                           ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                           3
                        );
                     }
                  }
               } else if (!world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                  Entity _entxxxxxxxxxxxx = world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (_entxxxxxxxxxxxx instanceof TamableAnimal _tamIsTamedByxxxxxxxxxxx
                     && entity instanceof LivingEntity _livEntxxxxxxxxxxx
                     && _tamIsTamedByxxxxxxxxxxx.isOwnedBy(_livEntxxxxxxxxxxx)
                     && world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )) {
                     _entxxxxxxxxxxxx = world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     _entxxxxxxxxxxxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxxxxxxxxxxxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxxxxxxxxxxxx.getYRot(),
                              _entxxxxxxxxxxxx.getXRot()
                           );
                     }
                  }
               }
            }

            if (entity.getPersistentData().getDouble("antblocktimer") == 63.0) {
               if (!world.getEntitiesOfClass(
                     AntArsonistWorkerEntity.class,
                     AABB.ofSize(
                        new Vec3(
                           entity.getPersistentData().getDouble("antbuildx"),
                           entity.getPersistentData().getDouble("antbuildy"),
                           entity.getPersistentData().getDouble("antbuildz")
                        ),
                        15.0,
                        15.0,
                        15.0
                     ),
                     e -> true
                  )
                  .isEmpty()) {
                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + 0.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 1.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + 3.0);
                  if (world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )
                     && !world.isClientSide()) {
                     world.setBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        ),
                        ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                        3
                     );
                  }

                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + 1.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 0.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + 3.0);
                  if (world.isEmptyBlock(
                     BlockPos.containing(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y"),
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     )
                  )) {
                     Entity _entxxxxxxxxxxxx = world.getEntitiesOfClass(
                           AntArsonistWorkerEntity.class,
                           AABB.ofSize(
                              new Vec3(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              ),
                              15.0,
                              15.0,
                              15.0
                           ),
                           e -> true
                        )
                        .stream()
                        .sorted(
                           (new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              })
                              .compareDistOf(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              )
                        )
                        .findFirst()
                        .orElse(null);
                     _entxxxxxxxxxxxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxxxxxxxxxxxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxxxxxxxxxxxx.getYRot(),
                              _entxxxxxxxxxxxx.getXRot()
                           );
                     }

                     if (!world.isClientSide()) {
                        world.setBlock(
                           BlockPos.containing(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y"),
                              entity.getPersistentData().getDouble("antbuild_aux_z")
                           ),
                           ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                           3
                        );
                     }
                  }
               } else if (!world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                  Entity _entxxxxxxxxxxxxx = world.getEntitiesOfClass(
                        AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true
                     )
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (_entxxxxxxxxxxxxx instanceof TamableAnimal _tamIsTamedByxxxxxxxxxxxx
                     && entity instanceof LivingEntity _livEntxxxxxxxxxxxx
                     && _tamIsTamedByxxxxxxxxxxxx.isOwnedBy(_livEntxxxxxxxxxxxx)
                     && world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )) {
                     _entxxxxxxxxxxxxx = world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     _entxxxxxxxxxxxxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxxxxxxxxxxxxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxxxxxxxxxxxxx.getYRot(),
                              _entxxxxxxxxxxxxx.getXRot()
                           );
                     }
                  }
               }
            }

            if (entity.getPersistentData().getDouble("antblocktimer") == 56.0) {
               if (!world.getEntitiesOfClass(
                     AntArsonistWorkerEntity.class,
                     AABB.ofSize(
                        new Vec3(
                           entity.getPersistentData().getDouble("antbuildx"),
                           entity.getPersistentData().getDouble("antbuildy"),
                           entity.getPersistentData().getDouble("antbuildz")
                        ),
                        15.0,
                        15.0,
                        15.0
                     ),
                     e -> true
                  )
                  .isEmpty()) {
                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + 1.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 1.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + 2.0);
                  if (world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )
                     && !world.isClientSide()) {
                     world.setBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        ),
                        ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                        3
                     );
                  }

                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + 2.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 1.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + 1.0);
                  if (world.isEmptyBlock(
                     BlockPos.containing(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y"),
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     )
                  )) {
                     Entity _entxxxxxxxxxxxxx = world.getEntitiesOfClass(
                           AntArsonistWorkerEntity.class,
                           AABB.ofSize(
                              new Vec3(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              ),
                              15.0,
                              15.0,
                              15.0
                           ),
                           e -> true
                        )
                        .stream()
                        .sorted(
                           (new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              })
                              .compareDistOf(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              )
                        )
                        .findFirst()
                        .orElse(null);
                     _entxxxxxxxxxxxxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxxxxxxxxxxxxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxxxxxxxxxxxxx.getYRot(),
                              _entxxxxxxxxxxxxx.getXRot()
                           );
                     }

                     if (!world.isClientSide()) {
                        world.setBlock(
                           BlockPos.containing(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y"),
                              entity.getPersistentData().getDouble("antbuild_aux_z")
                           ),
                           ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                           3
                        );
                     }
                  }
               } else if (!world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                  Entity _entxxxxxxxxxxxxxx = world.getEntitiesOfClass(
                        AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true
                     )
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (_entxxxxxxxxxxxxxx instanceof TamableAnimal _tamIsTamedByxxxxxxxxxxxxx
                     && entity instanceof LivingEntity _livEntxxxxxxxxxxxxx
                     && _tamIsTamedByxxxxxxxxxxxxx.isOwnedBy(_livEntxxxxxxxxxxxxx)
                     && world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )) {
                     _entxxxxxxxxxxxxxx = world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     _entxxxxxxxxxxxxxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxxxxxxxxxxxxxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxxxxxxxxxxxxxx.getYRot(),
                              _entxxxxxxxxxxxxxx.getXRot()
                           );
                     }
                  }
               }
            }

            if (entity.getPersistentData().getDouble("antblocktimer") == 49.0) {
               if (!world.getEntitiesOfClass(
                     AntArsonistWorkerEntity.class,
                     AABB.ofSize(
                        new Vec3(
                           entity.getPersistentData().getDouble("antbuildx"),
                           entity.getPersistentData().getDouble("antbuildy"),
                           entity.getPersistentData().getDouble("antbuildz")
                        ),
                        15.0,
                        15.0,
                        15.0
                     ),
                     e -> true
                  )
                  .isEmpty()) {
                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + 2.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 2.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + 0.0);
                  if (world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )
                     && !world.isClientSide()) {
                     world.setBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        ),
                        ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                        3
                     );
                  }

                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + 1.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 2.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + -1.0);
                  if (world.isEmptyBlock(
                     BlockPos.containing(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y"),
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     )
                  )) {
                     Entity _entxxxxxxxxxxxxxx = world.getEntitiesOfClass(
                           AntArsonistWorkerEntity.class,
                           AABB.ofSize(
                              new Vec3(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              ),
                              15.0,
                              15.0,
                              15.0
                           ),
                           e -> true
                        )
                        .stream()
                        .sorted(
                           (new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              })
                              .compareDistOf(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              )
                        )
                        .findFirst()
                        .orElse(null);
                     _entxxxxxxxxxxxxxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxxxxxxxxxxxxxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxxxxxxxxxxxxxx.getYRot(),
                              _entxxxxxxxxxxxxxx.getXRot()
                           );
                     }

                     if (!world.isClientSide()) {
                        world.setBlock(
                           BlockPos.containing(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y"),
                              entity.getPersistentData().getDouble("antbuild_aux_z")
                           ),
                           ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                           3
                        );
                     }
                  }
               } else if (!world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                  Entity _entxxxxxxxxxxxxxxx = world.getEntitiesOfClass(
                        AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true
                     )
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (_entxxxxxxxxxxxxxxx instanceof TamableAnimal _tamIsTamedByxxxxxxxxxxxxxx
                     && entity instanceof LivingEntity _livEntxxxxxxxxxxxxxx
                     && _tamIsTamedByxxxxxxxxxxxxxx.isOwnedBy(_livEntxxxxxxxxxxxxxx)
                     && world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )) {
                     _entxxxxxxxxxxxxxxx = world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     _entxxxxxxxxxxxxxxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxxxxxxxxxxxxxxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxxxxxxxxxxxxxxx.getYRot(),
                              _entxxxxxxxxxxxxxxx.getXRot()
                           );
                     }
                  }
               }
            }

            if (entity.getPersistentData().getDouble("antblocktimer") == 42.0) {
               if (!world.getEntitiesOfClass(
                     AntArsonistWorkerEntity.class,
                     AABB.ofSize(
                        new Vec3(
                           entity.getPersistentData().getDouble("antbuildx"),
                           entity.getPersistentData().getDouble("antbuildy"),
                           entity.getPersistentData().getDouble("antbuildz")
                        ),
                        15.0,
                        15.0,
                        15.0
                     ),
                     e -> true
                  )
                  .isEmpty()) {
                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + 0.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 2.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + -2.0);
                  if (world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )
                     && !world.isClientSide()) {
                     world.setBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        ),
                        ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                        3
                     );
                  }

                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + -1.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 2.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + -1.0);
                  if (world.isEmptyBlock(
                     BlockPos.containing(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y"),
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     )
                  )) {
                     Entity _entxxxxxxxxxxxxxxx = world.getEntitiesOfClass(
                           AntArsonistWorkerEntity.class,
                           AABB.ofSize(
                              new Vec3(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              ),
                              15.0,
                              15.0,
                              15.0
                           ),
                           e -> true
                        )
                        .stream()
                        .sorted(
                           (new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              })
                              .compareDistOf(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              )
                        )
                        .findFirst()
                        .orElse(null);
                     _entxxxxxxxxxxxxxxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxxxxxxxxxxxxxxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxxxxxxxxxxxxxxx.getYRot(),
                              _entxxxxxxxxxxxxxxx.getXRot()
                           );
                     }

                     if (!world.isClientSide()) {
                        world.setBlock(
                           BlockPos.containing(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y"),
                              entity.getPersistentData().getDouble("antbuild_aux_z")
                           ),
                           ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                           3
                        );
                     }
                  }
               } else if (!world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                  Entity _entxxxxxxxxxxxxxxxx = world.getEntitiesOfClass(
                        AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true
                     )
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (_entxxxxxxxxxxxxxxxx instanceof TamableAnimal _tamIsTamedByxxxxxxxxxxxxxxx
                     && entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxx
                     && _tamIsTamedByxxxxxxxxxxxxxxx.isOwnedBy(_livEntxxxxxxxxxxxxxxx)
                     && world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )) {
                     _entxxxxxxxxxxxxxxxx = world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     _entxxxxxxxxxxxxxxxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxxxxxxxxxxxxxxxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxxxxxxxxxxxxxxxx.getYRot(),
                              _entxxxxxxxxxxxxxxxx.getXRot()
                           );
                     }
                  }
               }
            }

            if (entity.getPersistentData().getDouble("antblocktimer") == 35.0) {
               if (!world.getEntitiesOfClass(
                     AntArsonistWorkerEntity.class,
                     AABB.ofSize(
                        new Vec3(
                           entity.getPersistentData().getDouble("antbuildx"),
                           entity.getPersistentData().getDouble("antbuildy"),
                           entity.getPersistentData().getDouble("antbuildz")
                        ),
                        15.0,
                        15.0,
                        15.0
                     ),
                     e -> true
                  )
                  .isEmpty()) {
                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + -2.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 2.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + 0.0);
                  if (world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )
                     && !world.isClientSide()) {
                     world.setBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        ),
                        ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                        3
                     );
                  }

                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + -1.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 2.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + 1.0);
                  if (world.isEmptyBlock(
                     BlockPos.containing(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y"),
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     )
                  )) {
                     Entity _entxxxxxxxxxxxxxxxx = world.getEntitiesOfClass(
                           AntArsonistWorkerEntity.class,
                           AABB.ofSize(
                              new Vec3(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              ),
                              15.0,
                              15.0,
                              15.0
                           ),
                           e -> true
                        )
                        .stream()
                        .sorted(
                           (new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              })
                              .compareDistOf(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              )
                        )
                        .findFirst()
                        .orElse(null);
                     _entxxxxxxxxxxxxxxxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxxxxxxxxxxxxxxxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxxxxxxxxxxxxxxxx.getYRot(),
                              _entxxxxxxxxxxxxxxxx.getXRot()
                           );
                     }

                     if (!world.isClientSide()) {
                        world.setBlock(
                           BlockPos.containing(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y"),
                              entity.getPersistentData().getDouble("antbuild_aux_z")
                           ),
                           ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                           3
                        );
                     }
                  }
               } else if (!world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                  Entity _entxxxxxxxxxxxxxxxxx = world.getEntitiesOfClass(
                        AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true
                     )
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (_entxxxxxxxxxxxxxxxxx instanceof TamableAnimal _tamIsTamedByxxxxxxxxxxxxxxxx
                     && entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxx
                     && _tamIsTamedByxxxxxxxxxxxxxxxx.isOwnedBy(_livEntxxxxxxxxxxxxxxxx)
                     && world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )) {
                     _entxxxxxxxxxxxxxxxxx = world.getEntitiesOfClass(
                           AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true
                        )
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     _entxxxxxxxxxxxxxxxxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxxxxxxxxxxxxxxxxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxxxxxxxxxxxxxxxxx.getYRot(),
                              _entxxxxxxxxxxxxxxxxx.getXRot()
                           );
                     }
                  }
               }
            }

            if (entity.getPersistentData().getDouble("antblocktimer") == 28.0) {
               if (!world.getEntitiesOfClass(
                     AntArsonistWorkerEntity.class,
                     AABB.ofSize(
                        new Vec3(
                           entity.getPersistentData().getDouble("antbuildx"),
                           entity.getPersistentData().getDouble("antbuildy"),
                           entity.getPersistentData().getDouble("antbuildz")
                        ),
                        15.0,
                        15.0,
                        15.0
                     ),
                     e -> true
                  )
                  .isEmpty()) {
                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + 0.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 2.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + 2.0);
                  if (world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )
                     && !world.isClientSide()) {
                     world.setBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        ),
                        ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                        3
                     );
                  }

                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + 1.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 2.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + 1.0);
                  if (world.isEmptyBlock(
                     BlockPos.containing(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y"),
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     )
                  )) {
                     Entity _entxxxxxxxxxxxxxxxxx = world.getEntitiesOfClass(
                           AntArsonistWorkerEntity.class,
                           AABB.ofSize(
                              new Vec3(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              ),
                              15.0,
                              15.0,
                              15.0
                           ),
                           e -> true
                        )
                        .stream()
                        .sorted(
                           (new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              })
                              .compareDistOf(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              )
                        )
                        .findFirst()
                        .orElse(null);
                     _entxxxxxxxxxxxxxxxxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxxxxxxxxxxxxxxxxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxxxxxxxxxxxxxxxxx.getYRot(),
                              _entxxxxxxxxxxxxxxxxx.getXRot()
                           );
                     }

                     if (!world.isClientSide()) {
                        world.setBlock(
                           BlockPos.containing(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y"),
                              entity.getPersistentData().getDouble("antbuild_aux_z")
                           ),
                           ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                           3
                        );
                     }
                  }
               } else if (!world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                  Entity _entxxxxxxxxxxxxxxxxxx = world.getEntitiesOfClass(
                        AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true
                     )
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (_entxxxxxxxxxxxxxxxxxx instanceof TamableAnimal _tamIsTamedByxxxxxxxxxxxxxxxxx
                     && entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxx
                     && _tamIsTamedByxxxxxxxxxxxxxxxxx.isOwnedBy(_livEntxxxxxxxxxxxxxxxxx)
                     && world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )) {
                     _entxxxxxxxxxxxxxxxxxx = world.getEntitiesOfClass(
                           AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true
                        )
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     _entxxxxxxxxxxxxxxxxxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxxxxxxxxxxxxxxxxxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxxxxxxxxxxxxxxxxxx.getYRot(),
                              _entxxxxxxxxxxxxxxxxxx.getXRot()
                           );
                     }
                  }
               }
            }

            if (entity.getPersistentData().getDouble("antblocktimer") == 21.0) {
               if (!world.getEntitiesOfClass(
                     AntArsonistWorkerEntity.class,
                     AABB.ofSize(
                        new Vec3(
                           entity.getPersistentData().getDouble("antbuildx"),
                           entity.getPersistentData().getDouble("antbuildy"),
                           entity.getPersistentData().getDouble("antbuildz")
                        ),
                        15.0,
                        15.0,
                        15.0
                     ),
                     e -> true
                  )
                  .isEmpty()) {
                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + 1.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 3.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + 0.0);
                  if (world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )
                     && !world.isClientSide()) {
                     world.setBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        ),
                        ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                        3
                     );
                  }

                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + 0.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 3.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + -1.0);
                  if (world.isEmptyBlock(
                     BlockPos.containing(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y"),
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     )
                  )) {
                     Entity _entxxxxxxxxxxxxxxxxxx = world.getEntitiesOfClass(
                           AntArsonistWorkerEntity.class,
                           AABB.ofSize(
                              new Vec3(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              ),
                              15.0,
                              15.0,
                              15.0
                           ),
                           e -> true
                        )
                        .stream()
                        .sorted(
                           (new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              })
                              .compareDistOf(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              )
                        )
                        .findFirst()
                        .orElse(null);
                     _entxxxxxxxxxxxxxxxxxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxxxxxxxxxxxxxxxxxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxxxxxxxxxxxxxxxxxx.getYRot(),
                              _entxxxxxxxxxxxxxxxxxx.getXRot()
                           );
                     }

                     if (!world.isClientSide()) {
                        world.setBlock(
                           BlockPos.containing(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y"),
                              entity.getPersistentData().getDouble("antbuild_aux_z")
                           ),
                           ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                           3
                        );
                     }
                  }
               } else if (!world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                  Entity _entxxxxxxxxxxxxxxxxxxx = world.getEntitiesOfClass(
                        AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true
                     )
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (_entxxxxxxxxxxxxxxxxxxx instanceof TamableAnimal _tamIsTamedByxxxxxxxxxxxxxxxxxx
                     && entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxx
                     && _tamIsTamedByxxxxxxxxxxxxxxxxxx.isOwnedBy(_livEntxxxxxxxxxxxxxxxxxx)
                     && world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )) {
                     _entxxxxxxxxxxxxxxxxxxx = world.getEntitiesOfClass(
                           AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true
                        )
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     _entxxxxxxxxxxxxxxxxxxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxxxxxxxxxxxxxxxxxxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxxxxxxxxxxxxxxxxxxx.getYRot(),
                              _entxxxxxxxxxxxxxxxxxxx.getXRot()
                           );
                     }
                  }
               }
            }

            if (entity.getPersistentData().getDouble("antblocktimer") == 14.0) {
               if (!world.getEntitiesOfClass(
                     AntArsonistWorkerEntity.class,
                     AABB.ofSize(
                        new Vec3(
                           entity.getPersistentData().getDouble("antbuildx"),
                           entity.getPersistentData().getDouble("antbuildy"),
                           entity.getPersistentData().getDouble("antbuildz")
                        ),
                        15.0,
                        15.0,
                        15.0
                     ),
                     e -> true
                  )
                  .isEmpty()) {
                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + -1.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 3.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + 0.0);
                  if (world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )
                     && !world.isClientSide()) {
                     world.setBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y"),
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        ),
                        ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                        3
                     );
                  }

                  entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + 0.0);
                  entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 3.0);
                  entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + 1.0);
                  if (world.isEmptyBlock(
                     BlockPos.containing(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y"),
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     )
                  )) {
                     Entity _entxxxxxxxxxxxxxxxxxxx = world.getEntitiesOfClass(
                           AntArsonistWorkerEntity.class,
                           AABB.ofSize(
                              new Vec3(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              ),
                              15.0,
                              15.0,
                              15.0
                           ),
                           e -> true
                        )
                        .stream()
                        .sorted(
                           (new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              })
                              .compareDistOf(
                                 entity.getPersistentData().getDouble("antbuildx"),
                                 entity.getPersistentData().getDouble("antbuildy"),
                                 entity.getPersistentData().getDouble("antbuildz")
                              )
                        )
                        .findFirst()
                        .orElse(null);
                     _entxxxxxxxxxxxxxxxxxxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxxxxxxxxxxxxxxxxxxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxxxxxxxxxxxxxxxxxxx.getYRot(),
                              _entxxxxxxxxxxxxxxxxxxx.getXRot()
                           );
                     }

                     if (!world.isClientSide()) {
                        world.setBlock(
                           BlockPos.containing(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y"),
                              entity.getPersistentData().getDouble("antbuild_aux_z")
                           ),
                           ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                           3
                        );
                     }
                  }
               } else if (!world.getEntitiesOfClass(AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                  Entity _entxxxxxxxxxxxxxxxxxxxx = world.getEntitiesOfClass(
                        AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true
                     )
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (_entxxxxxxxxxxxxxxxxxxxx instanceof TamableAnimal _tamIsTamedByxxxxxxxxxxxxxxxxxxx
                     && entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxx
                     && _tamIsTamedByxxxxxxxxxxxxxxxxxxx.isOwnedBy(_livEntxxxxxxxxxxxxxxxxxxx)
                     && world.isEmptyBlock(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("antbuild_aux_x"),
                           entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                           entity.getPersistentData().getDouble("antbuild_aux_z")
                        )
                     )) {
                     _entxxxxxxxxxxxxxxxxxxxx = world.getEntitiesOfClass(
                           AntArsonistWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true
                        )
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     _entxxxxxxxxxxxxxxxxxxxx.teleportTo(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     );
                     if (_entxxxxxxxxxxxxxxxxxxxx instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              entity.getPersistentData().getDouble("antbuild_aux_x"),
                              entity.getPersistentData().getDouble("antbuild_aux_y") + 1.0,
                              entity.getPersistentData().getDouble("antbuild_aux_z"),
                              _entxxxxxxxxxxxxxxxxxxxx.getYRot(),
                              _entxxxxxxxxxxxxxxxxxxxx.getXRot()
                           );
                     }
                  }
               }
            }

            if (entity.getPersistentData().getDouble("antblocktimer") == 7.0
               && !world.getEntitiesOfClass(
                     AntArsonistWorkerEntity.class,
                     AABB.ofSize(
                        new Vec3(
                           entity.getPersistentData().getDouble("antbuildx"),
                           entity.getPersistentData().getDouble("antbuildy"),
                           entity.getPersistentData().getDouble("antbuildz")
                        ),
                        15.0,
                        15.0,
                        15.0
                     ),
                     e -> true
                  )
                  .isEmpty()) {
               entity.getPersistentData().putDouble("antbuild_aux_x", entity.getPersistentData().getDouble("antbuildx") + 0.0);
               entity.getPersistentData().putDouble("antbuild_aux_y", entity.getPersistentData().getDouble("antbuildy") + 4.0);
               entity.getPersistentData().putDouble("antbuild_aux_z", entity.getPersistentData().getDouble("antbuildz") + 0.0);
               if (world.isEmptyBlock(
                     BlockPos.containing(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y"),
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     )
                  )
                  && !world.isClientSide()) {
                  world.setBlock(
                     BlockPos.containing(
                        entity.getPersistentData().getDouble("antbuild_aux_x"),
                        entity.getPersistentData().getDouble("antbuild_aux_y"),
                        entity.getPersistentData().getDouble("antbuild_aux_z")
                     ),
                     ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                     3
                  );
               }
            }
         }
      }
   }
}
