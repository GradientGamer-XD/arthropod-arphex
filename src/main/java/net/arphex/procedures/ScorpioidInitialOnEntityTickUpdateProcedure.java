package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class ScorpioidInitialOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!(Boolean)ConfigurationSettingsConfiguration.DWELLERS_INCLUSION.get() && !entity.level().isClientSide()) {
            entity.discard();
         }

         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 250.0, 250.0, 250.0), e -> true).isEmpty()) {
            world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 250.0, 250.0, 250.0), e -> true).stream().sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z)).findFirst().orElse(null).getPersistentData().putBoolean("scorpnear", true);
            if (entity.getY()
                  < world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 250.0, 250.0, 250.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getY()
               && entity instanceof LivingEntity _entity
               && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 10, 0, false, false));
            }

            if (entity instanceof LivingEntity _livEnt9
               && _livEnt9.hasEffect((MobEffect)ArphexModMobEffects.NECROSIS.get())
               && !entity.getPersistentData().getBoolean("triggered")
               && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 250.0, 250.0, 250.0), e -> true).stream().sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z)).findFirst().orElse(null).getPersistentData().getBoolean("creativespectator")) {
               entity.getPersistentData().putBoolean("triggered", true);
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }

               if (world instanceof ServerLevel _level) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPIOID_BLOODLUSTER.get())
                     .spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               if (world instanceof Level _levelx) {
                  if (!_levelx.isClientSide()) {
                     _levelx.playSound(
                        null,
                        BlockPos.containing(
                           world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 250.0, 250.0, 250.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y, z))
                              .findFirst()
                              .orElse(null)
                              .getX(),
                           world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 250.0, 250.0, 250.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y, z))
                              .findFirst()
                              .orElse(null)
                              .getY(),
                           world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 250.0, 250.0, 250.0), e -> true)
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
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:mothscare")),
                        SoundSource.HOSTILE,
                        0.7F,
                        0.9F
                     );
                  } else {
                     _levelx.playLocalSound(
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 250.0, 250.0, 250.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getX(),
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 250.0, 250.0, 250.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 250.0, 250.0, 250.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ(),
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:mothscare")),
                        SoundSource.HOSTILE,
                        0.7F,
                        0.9F,
                        false
                     );
                  }
               }

               ArphexMod.queueServerWork(
                  4,
                  () -> {
                     if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 250.0, 250.0, 250.0), e -> true).isEmpty()) {
                        Entity patt7102$temp = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 250.0, 250.0, 250.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null);
                        if (patt7102$temp instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 60, 1, false, false));
                        }

                        String _setval = "false";
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 250.0, 250.0, 250.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null)
                           .getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .ifPresent(
                              capability -> {
                                 capability.ShowOverlay2 = _setval;
                                 capability.syncPlayerVariables(
                                    world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 250.0, 250.0, 250.0), e -> true)
                                       .stream()
                                       .sorted((new Object() {
                                          Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                             return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                          }
                                       }).compareDistOf(x, y, z))
                                       .findFirst()
                                       .orElse(null)
                                 );
                              }
                           );
                     }
                  }
               );
               String _setval = "true";
               world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 250.0, 250.0, 250.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null)
                  .getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .ifPresent(
                     capability -> {
                        capability.ShowOverlay2 = _setval;
                        capability.syncPlayerVariables(
                           world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 250.0, 250.0, 250.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y, z))
                              .findFirst()
                              .orElse(null)
                        );
                     }
                  );
            }

            if (!world.getEntitiesOfClass(
                  Player.class,
                  AABB.ofSize(
                     new Vec3(x, y, z),
                     entity.getPersistentData().getDouble("stalkdistance") * 2.0 + 10.0,
                     entity.getPersistentData().getDouble("stalkdistance") * 2.0 + 10.0,
                     entity.getPersistentData().getDouble("stalkdistance") * 2.0 + 10.0
                  ),
                  e -> true
               )
               .isEmpty()) {
               entity.lookAt(
                  Anchor.EYES,
                  new Vec3(
                     world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 260.0, 260.0, 260.0), e -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z)).findFirst().orElse(null).getX(),
                     world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 260.0, 260.0, 260.0), e -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                     world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 260.0, 260.0, 260.0), e -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ()
                  )
               );
               if (!world.getEntitiesOfClass(
                        Player.class,
                        AABB.ofSize(
                           new Vec3(x, y, z),
                           entity.getPersistentData().getDouble("stalkdistance") / 1.5 - 6.0,
                           entity.getPersistentData().getDouble("stalkdistance") / 1.5 - 6.0,
                           entity.getPersistentData().getDouble("stalkdistance") / 1.5 - 6.0
                        ),
                        e -> true
                     )
                     .isEmpty()
                  && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 260.0, 260.0, 260.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getPersistentData().getBoolean("creativespectator")) {
                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }

                  if (world instanceof ServerLevel _levelxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPIOID_BLOODLUSTER.get())
                        .spawn(_levelxx, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               }
            } else {
               if (entity.getPersistentData().getDouble("tptime") == 5.0 || entity.getPersistentData().getDouble("tptime") == 45.0) {
                  entity.lookAt(
                     Anchor.EYES,
                     new Vec3(
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 260.0, 260.0, 260.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getX(),
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 260.0, 260.0, 260.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 260.0, 260.0, 260.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ()
                     )
                  );
                  if (Mth.nextInt(RandomSource.create(), 0, 30) == 5) {
                     if (world instanceof ServerLevel _levelxxx) {
                        _levelxxx.getServer()
                           .getCommands()
                           .performPrefixedCommand(
                              new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxxx, 4, "", Component.literal(""), _levelxxx.getServer(), null
                                 )
                                 .withSuppressedOutput(),
                              "execute at @e[type=arphex:scorpioid_initial,limit=1,sort=nearest] run tp @e[type=arphex:scorpioid_initial,limit=1,sort=nearest] ^ ^0.01 ^10"
                           );
                     }
                  } else if (world instanceof ServerLevel _levelxxx) {
                     _levelxxx.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxxx, 4, "", Component.literal(""), _levelxxx.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "execute at @e[type=arphex:scorpioid_initial,limit=1,sort=nearest] run tp @e[type=arphex:scorpioid_initial,limit=1,sort=nearest] ^ ^0.01 ^0.3"
                        );
                  }
               }

               entity.setDeltaMovement(
                  new Vec3(
                     Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 5.0,
                     entity.getDeltaMovement().y(),
                     Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 5.0
                  )
               );
               if (Math.abs(
                     entity.getZ()
                        - world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 260.0, 260.0, 260.0), e -> true)
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
                  > Math.abs(
                     entity.getX()
                        - world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 260.0, 260.0, 260.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null)
                           .getX()
                  )) {
                  if (entity.getZ()
                     > world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 260.0, 260.0, 260.0), e -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ()) {
                     if (entity.getPersistentData().getDouble("slownav") == 5.0 && entity instanceof Mob _entity) {
                        _entity.getNavigation()
                           .moveTo(
                              world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 260.0, 260.0, 260.0), e -> true)
                                 .stream()
                                 .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                       return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                 }).compareDistOf(x, y, z))
                                 .findFirst()
                                 .orElse(null)
                                 .getX(),
                              world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 260.0, 260.0, 260.0), e -> true)
                                 .stream()
                                 .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                       return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                 }).compareDistOf(x, y, z))
                                 .findFirst()
                                 .orElse(null)
                                 .getY(),
                              world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 260.0, 260.0, 260.0), e -> true)
                                    .stream()
                                    .sorted((new Object() {
                                       Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                          return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                       }
                                    }).compareDistOf(x, y, z))
                                    .findFirst()
                                    .orElse(null)
                                    .getZ()
                                 + entity.getPersistentData().getDouble("stalkdistance")
                                 - 5.0,
                              1.0
                           );
                     }
                  } else if (entity.getPersistentData().getDouble("slownav") == 5.0 && entity instanceof Mob _entity) {
                     _entity.getNavigation()
                        .moveTo(
                           world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 260.0, 260.0, 260.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y, z))
                              .findFirst()
                              .orElse(null)
                              .getX(),
                           world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 260.0, 260.0, 260.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y, z))
                              .findFirst()
                              .orElse(null)
                              .getY(),
                           world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 260.0, 260.0, 260.0), e -> true)
                                 .stream()
                                 .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                       return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                 }).compareDistOf(x, y, z))
                                 .findFirst()
                                 .orElse(null)
                                 .getZ()
                              - (entity.getPersistentData().getDouble("stalkdistance") - 5.0),
                           1.0
                        );
                  }
               } else if (entity.getX()
                  > world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 260.0, 260.0, 260.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getX()) {
                  if (entity.getPersistentData().getDouble("slownav") == 5.0 && entity instanceof Mob _entity) {
                     _entity.getNavigation()
                        .moveTo(
                           world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 260.0, 260.0, 260.0), e -> true)
                                 .stream()
                                 .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                       return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                 }).compareDistOf(x, y, z))
                                 .findFirst()
                                 .orElse(null)
                                 .getX()
                              + entity.getPersistentData().getDouble("stalkdistance")
                              - 5.0,
                           world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 260.0, 260.0, 260.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y, z))
                              .findFirst()
                              .orElse(null)
                              .getY(),
                           world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 260.0, 260.0, 260.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y, z))
                              .findFirst()
                              .orElse(null)
                              .getZ(),
                           1.0
                        );
                  }
               } else if (entity.getPersistentData().getDouble("slownav") == 5.0 && entity instanceof Mob _entity) {
                  _entity.getNavigation()
                     .moveTo(
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 260.0, 260.0, 260.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getX() - (entity.getPersistentData().getDouble("stalkdistance") - 5.0),
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 260.0, 260.0, 260.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 260.0, 260.0, 260.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ(),
                        1.0
                     );
               }
            }
         }

         if (!(entity.getPersistentData().getDouble("slownav") > 0.0)) {
            entity.getPersistentData().putDouble("slownav", 40.0);
         } else {
            entity.getPersistentData().putDouble("slownav", entity.getPersistentData().getDouble("slownav") - 1.0);
         }

         if (entity.isInWall() && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5, 5, false, false));
         }

         if (entity.getPersistentData().getDouble("tptime") > 0.0) {
            entity.getPersistentData().putDouble("tptime", entity.getPersistentData().getDouble("tptime") - 1.0);
         } else {
            entity.getPersistentData().putDouble("tptime", 20.0);
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect(MobEffects.WITHER);
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect((MobEffect)ArphexModMobEffects.NECROSIS.get());
         }

         ArphexMod.queueServerWork(
            12000,
            () -> {
               if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), e -> true).isEmpty()
                  && !entity.level().isClientSide()) {
                  entity.discard();
               }
            }
         );
         if (entity.getDeltaMovement().y() > 0.05) {
            entity.setShiftKeyDown(false);
            entity.setSprinting(true);
         } else if (entity.getDeltaMovement().y() < -0.05) {
            entity.setShiftKeyDown(true);
            entity.setSprinting(false);
         } else {
            entity.setShiftKeyDown(false);
            entity.setSprinting(false);
         }

         if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)) {
            if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true).isEmpty()) {
               if (world instanceof ServerLevel _levelxxx) {
                  _levelxxx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxxx, 4, "", Component.literal(""), _levelxxx.getServer(), null
                           )
                           .withSuppressedOutput(),
                        "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace glass_pane"
                     );
               }

               if (world instanceof ServerLevel _levelxxx) {
                  _levelxxx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxxx, 4, "", Component.literal(""), _levelxxx.getServer(), null
                           )
                           .withSuppressedOutput(),
                        "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace acacia_door"
                     );
               }

               if (world instanceof ServerLevel _levelxxx) {
                  _levelxxx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxxx, 4, "", Component.literal(""), _levelxxx.getServer(), null
                           )
                           .withSuppressedOutput(),
                        "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace bamboo_door"
                     );
               }

               if (world instanceof ServerLevel _levelxxx) {
                  _levelxxx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxxx, 4, "", Component.literal(""), _levelxxx.getServer(), null
                           )
                           .withSuppressedOutput(),
                        "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace birch_door"
                     );
               }

               if (world instanceof ServerLevel _levelxxx) {
                  _levelxxx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxxx, 4, "", Component.literal(""), _levelxxx.getServer(), null
                           )
                           .withSuppressedOutput(),
                        "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace cherry_door"
                     );
               }

               if (world instanceof ServerLevel _levelxxx) {
                  _levelxxx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxxx, 4, "", Component.literal(""), _levelxxx.getServer(), null
                           )
                           .withSuppressedOutput(),
                        "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace crimson_door"
                     );
               }

               if (world instanceof ServerLevel _levelxxx) {
                  _levelxxx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxxx, 4, "", Component.literal(""), _levelxxx.getServer(), null
                           )
                           .withSuppressedOutput(),
                        "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace dark_oak_door"
                     );
               }

               if (world instanceof ServerLevel _levelxxx) {
                  _levelxxx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxxx, 4, "", Component.literal(""), _levelxxx.getServer(), null
                           )
                           .withSuppressedOutput(),
                        "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace jungle_door"
                     );
               }

               if (world instanceof ServerLevel _levelxxx) {
                  _levelxxx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxxx, 4, "", Component.literal(""), _levelxxx.getServer(), null
                           )
                           .withSuppressedOutput(),
                        "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace mangrove_door"
                     );
               }

               if (world instanceof ServerLevel _levelxxx) {
                  _levelxxx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxxx, 4, "", Component.literal(""), _levelxxx.getServer(), null
                           )
                           .withSuppressedOutput(),
                        "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace oak_door"
                     );
               }

               if (world instanceof ServerLevel _levelxxx) {
                  _levelxxx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxxx, 4, "", Component.literal(""), _levelxxx.getServer(), null
                           )
                           .withSuppressedOutput(),
                        "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace spruce_door"
                     );
               }

               if (world instanceof ServerLevel _levelxxx) {
                  _levelxxx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxxx, 4, "", Component.literal(""), _levelxxx.getServer(), null
                           )
                           .withSuppressedOutput(),
                        "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace warped_door"
                     );
               }
            }

            if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).isEmpty()) {
               if (world instanceof ServerLevel _levelxxx) {
                  _levelxxx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxxx, 4, "", Component.literal(""), _levelxxx.getServer(), null
                           )
                           .withSuppressedOutput(),
                        "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace minecraft:nether_wart_block"
                     );
               }

               if (world instanceof ServerLevel _levelxxx) {
                  _levelxxx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxxx, 4, "", Component.literal(""), _levelxxx.getServer(), null
                           )
                           .withSuppressedOutput(),
                        "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace minecraft:warped_wart_block"
                     );
               }

               if (world instanceof ServerLevel _levelxxx) {
                  _levelxxx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxxx, 4, "", Component.literal(""), _levelxxx.getServer(), null
                           )
                           .withSuppressedOutput(),
                        "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace cobweb"
                     );
               }
            }
         }
      }
   }
}
