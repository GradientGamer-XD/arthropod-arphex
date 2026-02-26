package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.TORMENTOREntity;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class TormentorTendrilOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double expand = 0.0;
         double lineZ = 0.0;
         double lineY = 0.0;
         double lineX = 0.0;
         boolean targetone = false;
         if (!world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 550.0, 550.0, 550.0), e -> true).isEmpty()) {
            targetone = false;
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(275.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (!(entityiterator instanceof TORMENTOREntity) && entityiterator.getPersistentData().getBoolean("tormentor_target") && !targetone) {
                  targetone = true;
                  if (!world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 500.0, 500.0, 500.0), e -> true).isEmpty()
                     && !(
                        8.0
                           < Math.sqrt(
                              Math.pow(entity.getX() - entityiterator.getX(), 2.0)
                                 + Math.pow(entity.getY() - entityiterator.getY(), 2.0)
                                 + Math.pow(entity.getZ() - entityiterator.getZ(), 2.0)
                           )
                     )) {
                     entity.lookAt(
                        Anchor.EYES,
                        new Vec3(
                           world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 550.0, 550.0, 550.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y, z))
                              .findFirst()
                              .orElse(null)
                              .getX(),
                           world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 550.0, 550.0, 550.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y, z))
                              .findFirst()
                              .orElse(null)
                              .getY(),
                           world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 550.0, 550.0, 550.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y, z))
                              .findFirst()
                              .orElse(null)
                              .getZ()
                        )
                     );
                  } else {
                     entity.lookAt(Anchor.EYES, new Vec3(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()));
                  }

                  if (entity.getY() > entityiterator.getY()) {
                     entity.setDeltaMovement(
                        new Vec3(
                           Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                           -0.4,
                           Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                        )
                     );
                  } else {
                     entity.setDeltaMovement(
                        new Vec3(
                           Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                           0.4,
                           Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                        )
                     );
                  }
               }
            }

            lineX = entity.getX()
               - world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 550.0, 550.0, 550.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null)
                  .getX();
            lineY = entity.getY()
               + 0.0
               - (
                  world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 550.0, 550.0, 550.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null)
                        .getY()
                     + 55.0
               );
            lineZ = entity.getZ()
               - world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 550.0, 550.0, 550.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null)
                  .getZ();
            expand = 0.0;
            if ((
                  !(
                        Math.atan2(
                                    entity.getX()
                                       - world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 550.0, 550.0, 550.0), e -> true)
                                          .stream()
                                          .sorted((new Object() {
                                             Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                             }
                                          }).compareDistOf(x, y, z))
                                          .findFirst()
                                          .orElse(null)
                                          .getX(),
                                    entity.getZ()
                                       - world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 550.0, 550.0, 550.0), e -> true)
                                          .stream()
                                          .sorted((new Object() {
                                             Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                             }
                                          }).compareDistOf(x, y, z))
                                          .findFirst()
                                          .orElse(null)
                                          .getZ()
                                 )
                                 * 57.5
                              - 0.0
                              + (double)world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 550.0, 550.0, 550.0), e -> true)
                                 .stream()
                                 .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                       return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                 }).compareDistOf(x, y, z))
                                 .findFirst()
                                 .orElse(null)
                                 .getYRot()
                           < 90.0
                     )
                     || !(
                        Math.atan2(
                                    entity.getX()
                                       - world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 550.0, 550.0, 550.0), e -> true)
                                          .stream()
                                          .sorted((new Object() {
                                             Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                             }
                                          }).compareDistOf(x, y, z))
                                          .findFirst()
                                          .orElse(null)
                                          .getX(),
                                    entity.getZ()
                                       - world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 550.0, 550.0, 550.0), e -> true)
                                          .stream()
                                          .sorted((new Object() {
                                             Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                             }
                                          }).compareDistOf(x, y, z))
                                          .findFirst()
                                          .orElse(null)
                                          .getZ()
                                 )
                                 * 57.5
                              - 0.0
                              + (double)world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 550.0, 550.0, 550.0), e -> true)
                                 .stream()
                                 .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                       return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                 }).compareDistOf(x, y, z))
                                 .findFirst()
                                 .orElse(null)
                                 .getYRot()
                           > -90.0
                     )
               )
               && !entity.level().isClientSide()) {
               entity.discard();
            }

            _center = new Vec3(x, y, z);

            for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4.5), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (!(entityiteratorx instanceof TORMENTOREntity)
                  && entityiteratorx != entity
                  && entityiteratorx.getPersistentData().getBoolean("tormentor_target")
                  && !entityiteratorx.getPersistentData().getBoolean("creativespectator")
                  && !(
                     ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                              .orElse(new ArphexModVariables.PlayerVariables()))
                           .tormentor_respite
                        > 0.0
                  )) {
                  entityiteratorx.setDeltaMovement(
                     new Vec3(entity.getX() - entityiteratorx.getX(), entity.getY() - entityiteratorx.getY(), entity.getZ() - entityiteratorx.getZ())
                  );
               }

               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL,
                              new Vec3(
                                 world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 550.0, 550.0, 550.0), e -> true)
                                    .stream()
                                    .sorted((new Object() {
                                       Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                          return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                       }
                                    }).compareDistOf(x, y, z))
                                    .findFirst()
                                    .orElse(null)
                                    .getX(),
                                 world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 550.0, 550.0, 550.0), e -> true)
                                       .stream()
                                       .sorted((new Object() {
                                          Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                             return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                          }
                                       }).compareDistOf(x, y, z))
                                       .findFirst()
                                       .orElse(null)
                                       .getY()
                                    + 55.0,
                                 world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 550.0, 550.0, 550.0), e -> true)
                                    .stream()
                                    .sorted((new Object() {
                                       Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                          return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                       }
                                    }).compareDistOf(x, y, z))
                                    .findFirst()
                                    .orElse(null)
                                    .getZ()
                              ),
                              Vec2.ZERO,
                              _level,
                              4,
                              "",
                              Component.literal(""),
                              _level.getServer(),
                              null
                           )
                           .withSuppressedOutput(),
                        "particle arphex:tormentor_smoke ~ ~ ~ 0 0 0 0 1 force"
                     );
               }

               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL,
                              new Vec3(entity.getX(), entity.getY(), entity.getZ()),
                              Vec2.ZERO,
                              _level,
                              4,
                              "",
                              Component.literal(""),
                              _level.getServer(),
                              null
                           )
                           .withSuppressedOutput(),
                        "particle arphex:heavy_red_smoke ~ ~ ~ 0 0.1 0.1 0.1 5 force"
                     );
               }

               for (int index0 = 0; index0 < 100; index0++) {
                  if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                     if (world instanceof ServerLevel _level) {
                        _level.getServer()
                           .getCommands()
                           .performPrefixedCommand(
                              new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(
                                       entity.getX() + lineX * expand,
                                       entity.getY() + lineY * expand + 10.0 * Math.sin((Math.PI * 2) * expand),
                                       entity.getZ() + lineZ * expand
                                    ),
                                    Vec2.ZERO,
                                    _level,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _level.getServer(),
                                    null
                                 )
                                 .withSuppressedOutput(),
                              "particle arphex:solid_smoke ~ ~ ~ 0 0 0 0 1 force"
                           );
                     }

                     if (world instanceof ServerLevel _level) {
                        _level.getServer()
                           .getCommands()
                           .performPrefixedCommand(
                              new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(
                                       entity.getX() + lineX * expand,
                                       entity.getY() + lineY * expand + 10.0 * Math.sin((Math.PI * 2) * expand),
                                       entity.getZ() + lineZ * expand
                                    ),
                                    Vec2.ZERO,
                                    _level,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _level.getServer(),
                                    null
                                 )
                                 .withSuppressedOutput(),
                              "effect give @e[type=player,distance=..3] arphex:torment 2 0"
                           );
                     }
                  }

                  expand -= 0.01;
               }
            }
         } else if (!entity.level().isClientSide()) {
            entity.discard();
         }
      }
   }
}
