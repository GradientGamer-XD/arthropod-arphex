package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.WarpStaffDirectionEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModItems;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class WarpStaffToolInHandTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double xtarget = 0.0;
         double ytarget = 0.0;
         double ztarget = 0.0;
         double distance_level = 0.0;
         double expand = 0.0;
         double lineZ = 0.0;
         double lineY = 0.0;
         double lineX = 0.0;
         if ((!(entity instanceof Player _plrCldCheck1) || !_plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem()))
            && (
               (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.WARP_STAFF.get()
                  || (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.WARP_STAFF.get()
            )) {
            if (!world.getEntitiesOfClass(WarpStaffDirectionEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
               if (world.getEntitiesOfClass(WarpStaffDirectionEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null)
                  .getPersistentData()
                  .getString("uuidlock")
                  .equals(entity.getStringUUID())) {
                  if (entity.isShiftKeyDown()) {
                     xtarget = (double)Math.round(
                           (float)world.getEntitiesOfClass(WarpStaffDirectionEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y, z))
                              .findFirst()
                              .orElse(null)
                              .level()
                              .clip(
                                 new ClipContext(
                                    world.getEntitiesOfClass(WarpStaffDirectionEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                                       .stream()
                                       .sorted((new Object() {
                                          Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                             return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                          }
                                       }).compareDistOf(x, y, z))
                                       .findFirst()
                                       .orElse(null)
                                       .getEyePosition(1.0F),
                                    world.getEntitiesOfClass(WarpStaffDirectionEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                                       .stream()
                                       .sorted((new Object() {
                                          Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                             return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                          }
                                       }).compareDistOf(x, y, z))
                                       .findFirst()
                                       .orElse(null)
                                       .getEyePosition(1.0F)
                                       .add(
                                          world.getEntitiesOfClass(WarpStaffDirectionEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                                             .stream()
                                             .sorted((new Object() {
                                                Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                   return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                                }
                                             }).compareDistOf(x, y, z))
                                             .findFirst()
                                             .orElse(null)
                                             .getViewVector(1.0F)
                                             .scale(30.0)
                                       ),
                                    Block.COLLIDER,
                                    Fluid.NONE,
                                    world.getEntitiesOfClass(WarpStaffDirectionEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                                       .stream()
                                       .sorted((new Object() {
                                          Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                             return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                          }
                                       }).compareDistOf(x, y, z))
                                       .findFirst()
                                       .orElse(null)
                                 )
                              )
                              .getBlockPos()
                              .getX()
                        )
                        + 0.5;
                     ytarget = (double)Math.round(
                        (float)world.getEntitiesOfClass(WarpStaffDirectionEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null)
                           .level()
                           .clip(
                              new ClipContext(
                                 world.getEntitiesOfClass(WarpStaffDirectionEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                                    .stream()
                                    .sorted((new Object() {
                                       Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                          return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                       }
                                    }).compareDistOf(x, y, z))
                                    .findFirst()
                                    .orElse(null)
                                    .getEyePosition(1.0F),
                                 world.getEntitiesOfClass(WarpStaffDirectionEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                                    .stream()
                                    .sorted((new Object() {
                                       Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                          return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                       }
                                    }).compareDistOf(x, y, z))
                                    .findFirst()
                                    .orElse(null)
                                    .getEyePosition(1.0F)
                                    .add(
                                       world.getEntitiesOfClass(WarpStaffDirectionEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                                          .stream()
                                          .sorted((new Object() {
                                             Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                             }
                                          }).compareDistOf(x, y, z))
                                          .findFirst()
                                          .orElse(null)
                                          .getViewVector(1.0F)
                                          .scale(30.0)
                                    ),
                                 Block.COLLIDER,
                                 Fluid.NONE,
                                 world.getEntitiesOfClass(WarpStaffDirectionEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                                    .stream()
                                    .sorted((new Object() {
                                       Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                          return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                       }
                                    }).compareDistOf(x, y, z))
                                    .findFirst()
                                    .orElse(null)
                              )
                           )
                           .getBlockPos()
                           .getY()
                     );
                     ztarget = (double)Math.round(
                           (float)world.getEntitiesOfClass(WarpStaffDirectionEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y, z))
                              .findFirst()
                              .orElse(null)
                              .level()
                              .clip(
                                 new ClipContext(
                                    world.getEntitiesOfClass(WarpStaffDirectionEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                                       .stream()
                                       .sorted((new Object() {
                                          Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                             return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                          }
                                       }).compareDistOf(x, y, z))
                                       .findFirst()
                                       .orElse(null)
                                       .getEyePosition(1.0F),
                                    world.getEntitiesOfClass(WarpStaffDirectionEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                                       .stream()
                                       .sorted((new Object() {
                                          Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                             return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                          }
                                       }).compareDistOf(x, y, z))
                                       .findFirst()
                                       .orElse(null)
                                       .getEyePosition(1.0F)
                                       .add(
                                          world.getEntitiesOfClass(WarpStaffDirectionEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                                             .stream()
                                             .sorted((new Object() {
                                                Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                   return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                                }
                                             }).compareDistOf(x, y, z))
                                             .findFirst()
                                             .orElse(null)
                                             .getViewVector(1.0F)
                                             .scale(30.0)
                                       ),
                                    Block.COLLIDER,
                                    Fluid.NONE,
                                    world.getEntitiesOfClass(WarpStaffDirectionEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                                       .stream()
                                       .sorted((new Object() {
                                          Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                             return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                          }
                                       }).compareDistOf(x, y, z))
                                       .findFirst()
                                       .orElse(null)
                                 )
                              )
                              .getBlockPos()
                              .getZ()
                        )
                        + 0.5;
                     if (ytarget < entity.getY()) {
                        if ((
                              !world.isEmptyBlock(BlockPos.containing(xtarget, ytarget, ztarget))
                                 || !world.isEmptyBlock(BlockPos.containing(xtarget, ytarget + 1.0, ztarget))
                           )
                           && world.isEmptyBlock(BlockPos.containing(xtarget, ytarget + 2.0, ztarget))
                           && world.isEmptyBlock(BlockPos.containing(xtarget, ytarget + 1.0, ztarget))) {
                           ytarget++;
                        }
                     } else if (ytarget > entity.getY()
                        && (
                           !world.isEmptyBlock(BlockPos.containing(xtarget, ytarget, ztarget))
                              || !world.isEmptyBlock(BlockPos.containing(xtarget, ytarget + 1.0, ztarget))
                        )
                        && world.isEmptyBlock(BlockPos.containing(xtarget, ytarget, ztarget))
                        && world.isEmptyBlock(BlockPos.containing(xtarget, ytarget - 1.0, ztarget))) {
                        ytarget--;
                     }

                     if (Math.abs(entity.getX() - xtarget) > Math.abs(entity.getZ() - ztarget)) {
                        if (xtarget < entity.getX()) {
                           if ((
                                 !world.isEmptyBlock(BlockPos.containing(xtarget, ytarget, ztarget))
                                    || !world.isEmptyBlock(BlockPos.containing(xtarget, ytarget + 1.0, ztarget))
                              )
                              && world.isEmptyBlock(BlockPos.containing(xtarget + 1.0, ytarget, ztarget))
                              && world.isEmptyBlock(BlockPos.containing(xtarget + 1.0, ytarget + 1.0, ztarget))) {
                              xtarget++;
                           }
                        } else if (xtarget > entity.getX()
                           && (
                              !world.isEmptyBlock(BlockPos.containing(xtarget, ytarget, ztarget))
                                 || !world.isEmptyBlock(BlockPos.containing(xtarget, ytarget + 1.0, ztarget))
                           )
                           && world.isEmptyBlock(BlockPos.containing(xtarget - 1.0, ytarget, ztarget))
                           && world.isEmptyBlock(BlockPos.containing(xtarget - 1.0, ytarget + 1.0, ztarget))) {
                           xtarget--;
                        }

                        if (ztarget < entity.getZ()) {
                           if ((
                                 !world.isEmptyBlock(BlockPos.containing(xtarget, ytarget, ztarget))
                                    || !world.isEmptyBlock(BlockPos.containing(xtarget, ytarget + 1.0, ztarget))
                              )
                              && world.isEmptyBlock(BlockPos.containing(xtarget, ytarget, ztarget + 1.0))
                              && world.isEmptyBlock(BlockPos.containing(xtarget, ytarget + 1.0, ztarget + 1.0))) {
                              ztarget++;
                           }
                        } else if (ztarget > entity.getZ()
                           && (
                              !world.isEmptyBlock(BlockPos.containing(xtarget, ytarget, ztarget))
                                 || !world.isEmptyBlock(BlockPos.containing(xtarget, ytarget + 1.0, ztarget))
                           )
                           && world.isEmptyBlock(BlockPos.containing(xtarget, ytarget, ztarget - 1.0))
                           && world.isEmptyBlock(BlockPos.containing(xtarget, ytarget + 1.0, ztarget - 1.0))) {
                           ztarget--;
                        }
                     } else {
                        if (ztarget < entity.getZ()) {
                           if ((
                                 !world.isEmptyBlock(BlockPos.containing(xtarget, ytarget, ztarget))
                                    || !world.isEmptyBlock(BlockPos.containing(xtarget, ytarget + 1.0, ztarget))
                              )
                              && world.isEmptyBlock(BlockPos.containing(xtarget, ytarget, ztarget + 1.0))
                              && world.isEmptyBlock(BlockPos.containing(xtarget, ytarget + 1.0, ztarget + 1.0))) {
                              ztarget++;
                           }
                        } else if (ztarget > entity.getZ()
                           && (
                              !world.isEmptyBlock(BlockPos.containing(xtarget, ytarget, ztarget))
                                 || !world.isEmptyBlock(BlockPos.containing(xtarget, ytarget + 1.0, ztarget))
                           )
                           && world.isEmptyBlock(BlockPos.containing(xtarget, ytarget, ztarget - 1.0))
                           && world.isEmptyBlock(BlockPos.containing(xtarget, ytarget + 1.0, ztarget - 1.0))) {
                           ztarget--;
                        }

                        if (xtarget < entity.getX()) {
                           if ((
                                 !world.isEmptyBlock(BlockPos.containing(xtarget, ytarget, ztarget))
                                    || !world.isEmptyBlock(BlockPos.containing(xtarget, ytarget + 1.0, ztarget))
                              )
                              && world.isEmptyBlock(BlockPos.containing(xtarget + 1.0, ytarget, ztarget))
                              && world.isEmptyBlock(BlockPos.containing(xtarget + 1.0, ytarget + 1.0, ztarget))) {
                              xtarget++;
                           }
                        } else if (xtarget > entity.getX()
                           && (
                              !world.isEmptyBlock(BlockPos.containing(xtarget, ytarget, ztarget))
                                 || !world.isEmptyBlock(BlockPos.containing(xtarget, ytarget + 1.0, ztarget))
                           )
                           && world.isEmptyBlock(BlockPos.containing(xtarget - 1.0, ytarget, ztarget))
                           && world.isEmptyBlock(BlockPos.containing(xtarget - 1.0, ytarget + 1.0, ztarget))) {
                           xtarget--;
                        }
                     }

                     if (world.isEmptyBlock(BlockPos.containing(xtarget, ytarget, ztarget))
                        && world.isEmptyBlock(BlockPos.containing(xtarget, ytarget + 1.0, ztarget))) {
                        if (world instanceof ServerLevel _level) {
                           _level.getServer()
                              .getCommands()
                              .performPrefixedCommand(
                                 new CommandSourceStack(
                                       CommandSource.NULL,
                                       new Vec3(xtarget, ytarget - 1.0, ztarget),
                                       Vec2.ZERO,
                                       _level,
                                       4,
                                       "",
                                       Component.literal(""),
                                       _level.getServer(),
                                       null
                                    )
                                    .withSuppressedOutput(),
                                 "particle arphex:heavy_white_smokes ~ ~ ~ 0.1 0.2 0.1 0 30 force"
                              );
                        }

                        lineX = entity.getX() - xtarget;
                        lineY = entity.getY() - ytarget;
                        lineZ = entity.getZ() - ztarget;
                        expand = expand;

                        for (int index0 = 0; index0 < 10; index0++) {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL,
                                          new Vec3(entity.getX() + lineX * expand, entity.getY() + lineY * expand, entity.getZ() + lineZ * expand),
                                          Vec2.ZERO,
                                          _level,
                                          4,
                                          "",
                                          Component.literal(""),
                                          _level.getServer(),
                                          null
                                       )
                                       .withSuppressedOutput(),
                                    "particle arphex:heavy_purple_smoke ~ ~ ~ 0 0 0 0 1 force"
                                 );
                           }

                           expand -= 0.1;
                        }

                        if (world instanceof ServerLevel _level) {
                           _level.getServer()
                              .getCommands()
                              .performPrefixedCommand(
                                 new CommandSourceStack(
                                       CommandSource.NULL,
                                       new Vec3(xtarget, ytarget - 1.0, ztarget),
                                       Vec2.ZERO,
                                       _level,
                                       4,
                                       "",
                                       Component.literal(""),
                                       _level.getServer(),
                                       null
                                    )
                                    .withSuppressedOutput(),
                                 "/fill ~-1 ~ ~-1 ~1 ~ ~1 arphex:warp_manifold[type=top] replace #arphex:airs"
                              );
                        }

                        entity.teleportTo(xtarget, ytarget, ztarget);
                        if (entity instanceof ServerPlayer _serverPlayer) {
                           _serverPlayer.connection.teleport(xtarget, ytarget, ztarget, entity.getYRot(), entity.getXRot());
                        }

                        if (entity instanceof Player _player) {
                           _player.getCooldowns().addCooldown(itemstack.getItem(), 20);
                        }
                     }
                  }
               } else if (world instanceof ServerLevel _level) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.WARP_STAFF_DIRECTION.get())
                     .spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                  }
               }
            } else if (world instanceof ServerLevel _levelx) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.WARP_STAFF_DIRECTION.get())
                  .spawn(_levelx, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
               }
            }
         }

         entity.fallDistance = 0.0F;
      }
   }
}
