package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.SpiderMothEntity;
import net.arphex.entity.SpiderMothLarvaeEntity;
import net.arphex.entity.TeleportGhostEntity;
import net.arphex.init.ArphexModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class TeleportGhostOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (Mth.nextInt(RandomSource.create(), 1, 400) == 20
            && !world.getEntitiesOfClass(TeleportGhostEntity.class, AABB.ofSize(new Vec3(x, y, z), 1.0, 1.0, 1.0), ex -> true).isEmpty()
            && !entity.level().isClientSide()) {
            entity.discard();
         }

         if ((
               (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) instanceof SpiderMothEntity
                  || (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof SpiderMothLarvaeEntity
            )
            && entity instanceof Mob _entity) {
            _entity.getNavigation().stop();
         }

         if (world instanceof ServerLevel _level) {
            _level.sendParticles(ParticleTypes.SMOKE, x, y, z, 2, 0.5, 0.5, 0.5, 0.05);
         }

         if (entity instanceof Mob _entity) {
            Entity _livEnt = world.getEntitiesOfClass(SpiderMothEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), ex -> true)
               .stream()
               .sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z))
               .findFirst()
               .orElse(null);
            if ((_livEnt instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity _ent) {
               _entity.setTarget(_ent);
            }
         }

         if (entity instanceof TeleportGhostEntity) {
            if (entity instanceof LivingEntity _entityx) {
               _entityx.removeEffect((MobEffect)ArphexModMobEffects.MOTH_CURSE.get());
            }

            if (entity instanceof LivingEntity _entityx) {
               _entityx.removeEffect(MobEffects.WITHER);
            }
         }

         entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
         if (entity instanceof Mob _entityx) {
            _entityx.getNavigation().stop();
         }

         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), ex -> true).isEmpty()) {
            if (world.getEntitiesOfClass(SpiderMothEntity.class, AABB.ofSize(new Vec3(x, y, z), 130.0, 130.0, 130.0), ex -> true).isEmpty()
               && !entity.level().isClientSide()) {
               entity.discard();
            }

            if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), ex -> true).stream().sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z)).findFirst().orElse(null).getPersistentData().getBoolean("creativespectator")) {
               entity.lookAt(
                  Anchor.EYES,
                  new Vec3(
                     world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), ex -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z)).findFirst().orElse(null).getX(),
                     world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), ex -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                     world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), ex -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ()
                  )
               );
               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                           .withSuppressedOutput(),
                        "execute at @e[type=arphex:teleport_ghost,limit=1,sort=nearest] run tp @e[type=arphex:teleport_ghost,limit=1,sort=nearest] ^ ^0.02 ^0.08"
                     );
               }

               if (entity.getY() - 0.5
                     < world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), ex -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z)).findFirst().orElse(null).getY()
                  && world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                           .withSuppressedOutput(),
                        "execute at @e[type=arphex:teleport_ghost,limit=1,sort=nearest] run tp @e[type=arphex:teleport_ghost,limit=1,sort=nearest] ~ ~0.1 ~"
                     );
               }

               if (entity.getY() - 0.5
                     > world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), ex -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z)).findFirst().orElse(null).getY()
                  && world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                           .withSuppressedOutput(),
                        "execute at @e[type=arphex:teleport_ghost,limit=1,sort=nearest] run tp @e[type=arphex:teleport_ghost,limit=1,sort=nearest] ~ ~-0.1 ~"
                     );
               }
            } else {
               if (!world.getEntitiesOfClass(SpiderMothEntity.class, AABB.ofSize(new Vec3(x, y, z), 130.0, 130.0, 130.0), ex -> true).isEmpty()) {
                  if (entity instanceof Mob _entityx) {
                     _entityx.getNavigation().stop();
                  }

                  if (world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "execute at @e[type=arphex:teleport_ghost,limit=1,sort=nearest] run tp @e[type=arphex:teleport_ghost,limit=1,sort=nearest] ^ ^0.02 ^0.08"
                        );
                  }
               }

               if (!world.getEntitiesOfClass(SpiderMothEntity.class, AABB.ofSize(new Vec3(x, y, z), 130.0, 130.0, 130.0), ex -> true).isEmpty()) {
                  Entity var54 = world.getEntitiesOfClass(SpiderMothEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), ex -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (((var54 instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
                     if (entity instanceof Mob _entityx) {
                        _entityx.getNavigation().stop();
                     }

                     if (world instanceof ServerLevel _level) {
                        _level.getServer()
                           .getCommands()
                           .performPrefixedCommand(
                              new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                 )
                                 .withSuppressedOutput(),
                              "execute at @e[type=arphex:teleport_ghost,limit=1,sort=nearest] run tp @e[type=arphex:teleport_ghost,limit=1,sort=nearest] ^ ^0.02 ^0.12"
                           );
                     }

                     Anchor var10001 = Anchor.EYES;
                     var54 = world.getEntitiesOfClass(SpiderMothEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), ex -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     double var91 = (var54 instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getX();
                     var54 = world.getEntitiesOfClass(SpiderMothEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), ex -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     double var94 = (var54 instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getY();
                     var54 = world.getEntitiesOfClass(SpiderMothEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), ex -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     entity.lookAt(var10001, new Vec3(var91, var94, (var54 instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getZ()));
                     double var76 = entity.getY() - 0.5;
                     var54 = world.getEntitiesOfClass(SpiderMothEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), ex -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     if (var76 < (var54 instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null).getY() && world instanceof ServerLevel _level) {
                        _level.getServer()
                           .getCommands()
                           .performPrefixedCommand(
                              new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                 )
                                 .withSuppressedOutput(),
                              "execute at @e[type=arphex:teleport_ghost,limit=1,sort=nearest] run tp @e[type=arphex:teleport_ghost,limit=1,sort=nearest] ~ ~0.1 ~"
                           );
                     }

                     var76 = entity.getY() - 0.5;
                     var54 = world.getEntitiesOfClass(SpiderMothEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), ex -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     if (var76 > (var54 instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null).getY() && world instanceof ServerLevel _level) {
                        _level.getServer()
                           .getCommands()
                           .performPrefixedCommand(
                              new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                 )
                                 .withSuppressedOutput(),
                              "execute at @e[type=arphex:teleport_ghost,limit=1,sort=nearest] run tp @e[type=arphex:teleport_ghost,limit=1,sort=nearest] ~ ~-0.1 ~"
                           );
                     }
                  }
               }
            }
         } else {
            if (!world.getEntitiesOfClass(SpiderMothEntity.class, AABB.ofSize(new Vec3(x, y, z), 130.0, 130.0, 130.0), ex -> true).isEmpty()) {
               if (entity instanceof Mob _entityx) {
                  _entityx.getNavigation().stop();
               }

               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                           .withSuppressedOutput(),
                        "execute at @e[type=arphex:teleport_ghost,limit=1,sort=nearest] run tp @e[type=arphex:teleport_ghost,limit=1,sort=nearest] ^ ^0.02 ^0.08"
                     );
               }
            } else if (!entity.level().isClientSide()) {
               entity.discard();
            }

            if (!world.getEntitiesOfClass(SpiderMothEntity.class, AABB.ofSize(new Vec3(x, y, z), 130.0, 130.0, 130.0), ex -> true).isEmpty()) {
               Entity var62 = world.getEntitiesOfClass(SpiderMothEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), ex -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null);
               if (((var62 instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
                  if (entity instanceof Mob _entityx) {
                     _entityx.getNavigation().stop();
                  }

                  if (world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "execute at @e[type=arphex:teleport_ghost,limit=1,sort=nearest] run tp @e[type=arphex:teleport_ghost,limit=1,sort=nearest] ^ ^0.02 ^0.12"
                        );
                  }

                  Anchor var87 = Anchor.EYES;
                  var62 = world.getEntitiesOfClass(SpiderMothEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), ex -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  double var93 = (var62 instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null).getX();
                  var62 = world.getEntitiesOfClass(SpiderMothEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), ex -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  double var96 = (var62 instanceof Mob _mobEntxxxxxx ? _mobEntxxxxxx.getTarget() : null).getY();
                  var62 = world.getEntitiesOfClass(SpiderMothEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), ex -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  entity.lookAt(var87, new Vec3(var93, var96, (var62 instanceof Mob _mobEntxxxxxxx ? _mobEntxxxxxxx.getTarget() : null).getZ()));
                  double var80 = entity.getY() - 0.5;
                  var62 = world.getEntitiesOfClass(SpiderMothEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), ex -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (var80 < (var62 instanceof Mob _mobEntxxxxxxxx ? _mobEntxxxxxxxx.getTarget() : null).getY() && world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "execute at @e[type=arphex:teleport_ghost,limit=1,sort=nearest] run tp @e[type=arphex:teleport_ghost,limit=1,sort=nearest] ~ ~0.1 ~"
                        );
                  }

                  var80 = entity.getY() - 0.5;
                  var62 = world.getEntitiesOfClass(SpiderMothEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), ex -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (var80 > (var62 instanceof Mob _mobEntxxxxxxxx ? _mobEntxxxxxxxx.getTarget() : null).getY() && world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "execute at @e[type=arphex:teleport_ghost,limit=1,sort=nearest] run tp @e[type=arphex:teleport_ghost,limit=1,sort=nearest] ~ ~-0.1 ~"
                        );
                  }
               }
            }
         }

         if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) instanceof Player
            && (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getPersistentData().getBoolean("creativespectator")
            && entity instanceof Mob) {
            try {
               ((Mob)entity).setTarget(null);
            } catch (Exception var14) {
               var14.printStackTrace();
            }
         }

         if (!(entity.getPersistentData().getDouble("telmessagelim") > 0.0)) {
            entity.getPersistentData().putDouble("telmessagelim", 10.0);
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(7.5), ex -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiterator instanceof Player
                  && !entityiterator.getPersistentData().getBoolean("creativespectator")
                  && (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) < 20
                  && entityiterator instanceof Player) {
                  Player _player = (Player)entityiterator;
                  if (!_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal("§cBeware, it is attempting to teleport towards you with a ghost moth!"), true);
                  }
               }
            }
         } else {
            entity.getPersistentData().putDouble("telmessagelim", entity.getPersistentData().getDouble("telmessagelim") - 1.0);
         }
      }
   }
}
