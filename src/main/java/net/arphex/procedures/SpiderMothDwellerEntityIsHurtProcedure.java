package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.SpiderMothEntity;
import net.arphex.entity.TeleportGhostEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class SpiderMothDwellerEntityIsHurtProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (ArphexModVariables.MapVariables.get(world).attackcycle == 5.0
            && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true).isEmpty()
            && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true).stream().sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z)).findFirst().orElse(null).getPersistentData().getBoolean("creativespectator")) {
            entity.setDeltaMovement(
               new Vec3(
                  Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 3.0,
                  1.3,
                  Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 3.0
               )
            );
            ArphexMod.queueServerWork(
               10,
               () -> entity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)), 0.1, Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0))
                     )
                  )
            );
         }

         if (ArphexModVariables.MapVariables.get(world).attackcycle == 2.0) {
            entity.setDeltaMovement(
               new Vec3(
                  Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 3.0,
                  1.3,
                  Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 3.0
               )
            );
            ArphexMod.queueServerWork(
               10,
               () -> entity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)), 0.1, Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0))
                     )
                  )
            );
         }

         if (ArphexModVariables.MapVariables.get(world).attackcycle < (double)Mth.nextInt(RandomSource.create(), 6, 8)) {
            ArphexModVariables.MapVariables.get(world).attackcycle++;
            ArphexModVariables.MapVariables.get(world).syncData(world);
         } else {
            if ((!(entity instanceof LivingEntity _livEnt18) || !_livEnt18.hasEffect(MobEffects.DIG_SPEED))
               && world.getEntitiesOfClass(TeleportGhostEntity.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true).isEmpty()
               && world instanceof ServerLevel _level) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.TELEPORT_GHOST.get())
                  .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(0.0, 1.0, 0.0);
               }
            }

            ArphexModVariables.MapVariables.get(world).attackcycle = 1.0;
            ArphexModVariables.MapVariables.get(world).syncData(world);
            if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
               ArphexModVariables.MapVariables.get(world).slightrandom = "first";
               ArphexModVariables.MapVariables.get(world).syncData(world);
            } else {
               ArphexModVariables.MapVariables.get(world).slightrandom = "second";
               ArphexModVariables.MapVariables.get(world).syncData(world);
            }
         }

         label149:
         if (!new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.IN_WALL)).isIndirect()
            && !new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.LIGHTNING_BOLT)).isIndirect()
            && (
               ArphexModVariables.MapVariables.get(world).attackcycle == 6.0 && ArphexModVariables.MapVariables.get(world).slightrandom.equals("first")
                  || ArphexModVariables.MapVariables.get(world).attackcycle == 4.0 && ArphexModVariables.MapVariables.get(world).slightrandom.equals("second")
            )
            && !entity.getPersistentData().getBoolean("growattack")) {
            if (entity instanceof LivingEntity _livEnt27 && _livEnt27.hasEffect((MobEffect)ArphexModMobEffects.FORCE_POWER.get())) {
               break label149;
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(
                  new MobEffectInstance(
                     MobEffects.LEVITATION, Mth.nextInt(RandomSource.create(), 20, 50), Mth.nextInt(RandomSource.create(), 6, 8), false, false
                  )
               );
            }

            if (Mth.nextInt(RandomSource.create(), 1, 2) == 2 && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
               if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                  entity.getPersistentData().putString("flyvers", "float");
               } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                  entity.getPersistentData().putString("flyvers", "anticlockwise");
               } else {
                  entity.getPersistentData().putString("flyvers", "clockwise");
               }

               entity.getPersistentData().putDouble("flytime", (double)Mth.nextInt(RandomSource.create(), 200, 600));
               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(
                     new MobEffectInstance(
                        (MobEffect)ArphexModMobEffects.FORCE_POWER.get(), (int)entity.getPersistentData().getDouble("flytime"), 0, false, false
                     )
                  );
               }

               ArphexMod.queueServerWork(
                  (int)(entity.getPersistentData().getDouble("flytime") / 4.0),
                  () -> {
                     if (entity instanceof LivingEntity _livEnt43 && _livEnt43.hasEffect((MobEffect)ArphexModMobEffects.FORCE_POWER.get())) {
                        if (Mth.nextInt(RandomSource.create(), 1, 3) != 2) {
                           entity.setDeltaMovement(
                              new Vec3(
                                 Math.cos((double)(entity.getYRot() + 0.0F) * (Math.PI / 180.0)) / 1.0,
                                 0.3,
                                 Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.0
                              )
                           );
                        } else {
                           entity.setDeltaMovement(
                              new Vec3(
                                 Math.cos((double)(entity.getYRot() + 180.0F) * (Math.PI / 180.0)) / 1.0,
                                 0.3,
                                 Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.0
                              )
                           );
                        }
                     }
                  }
               );
               ArphexMod.queueServerWork(
                  (int)(entity.getPersistentData().getDouble("flytime") / 2.0),
                  () -> {
                     if (entity instanceof LivingEntity _livEnt53 && _livEnt53.hasEffect((MobEffect)ArphexModMobEffects.FORCE_POWER.get())) {
                        if (Mth.nextInt(RandomSource.create(), 1, 2) == 2 && (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
                           entity.lookAt(
                              Anchor.EYES,
                              new Vec3(
                                 (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getX(),
                                 (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getY(),
                                 (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getZ()
                              )
                           );
                        }

                        if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                           entity.setDeltaMovement(
                              new Vec3(
                                 Math.cos((double)(entity.getYRot() + 0.0F) * (Math.PI / 180.0)) / 1.0,
                                 0.3,
                                 Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.0
                              )
                           );
                        } else {
                           entity.setDeltaMovement(
                              new Vec3(
                                 Math.cos((double)(entity.getYRot() + 180.0F) * (Math.PI / 180.0)) / 1.0,
                                 0.3,
                                 Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.0
                              )
                           );
                        }
                     }
                  }
               );
               ArphexMod.queueServerWork(
                  (int)(entity.getPersistentData().getDouble("flytime") - 100.0),
                  () -> {
                     if (entity instanceof LivingEntity _livEnt73 && _livEnt73.hasEffect((MobEffect)ArphexModMobEffects.FORCE_POWER.get())) {
                        ArphexMod.queueServerWork(
                           5,
                           () -> {
                              if (entity instanceof LivingEntity _livEnt74 && _livEnt74.hasEffect((MobEffect)ArphexModMobEffects.FORCE_POWER.get())) {
                                 entity.setDeltaMovement(
                                    new Vec3(
                                       Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.0,
                                       -0.3,
                                       Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.0
                                    )
                                 );
                                 ArphexMod.queueServerWork(
                                    5,
                                    () -> {
                                       if (entity instanceof LivingEntity _livEnt78 && _livEnt78.hasEffect((MobEffect)ArphexModMobEffects.FORCE_POWER.get())) {
                                          if (Mth.nextInt(RandomSource.create(), 1, 2) == 2
                                             && (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
                                             entity.lookAt(
                                                Anchor.EYES,
                                                new Vec3(
                                                   (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getX(),
                                                   (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getY(),
                                                   (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getZ()
                                                )
                                             );
                                          }

                                          entity.setDeltaMovement(
                                             new Vec3(
                                                Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.0,
                                                0.3,
                                                Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.0
                                             )
                                          );
                                          ArphexMod.queueServerWork(
                                             5,
                                             () -> {
                                                if (entity instanceof LivingEntity _livEnt92
                                                   && _livEnt92.hasEffect((MobEffect)ArphexModMobEffects.FORCE_POWER.get())) {
                                                   if (Mth.nextInt(RandomSource.create(), 1, 2) == 2
                                                      && (entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null) != null) {
                                                      entity.lookAt(
                                                         Anchor.EYES,
                                                         new Vec3(
                                                            (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getX(),
                                                            (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getY(),
                                                            (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getZ()
                                                         )
                                                      );
                                                   }

                                                   entity.setDeltaMovement(
                                                      new Vec3(
                                                         Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.0,
                                                         -0.3,
                                                         Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.0
                                                      )
                                                   );
                                                }
                                             }
                                          );
                                       }
                                    }
                                 );
                              }
                           }
                        );
                     }
                  }
               );
               ArphexMod.queueServerWork(
                  (int)(entity.getPersistentData().getDouble("flytime") - 20.0),
                  () -> {
                     if (entity instanceof LivingEntity _livEnt111 && _livEnt111.hasEffect((MobEffect)ArphexModMobEffects.FORCE_POWER.get())) {
                        if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
                           entity.lookAt(
                              Anchor.EYES,
                              new Vec3(
                                 (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getX(),
                                 (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getY(),
                                 (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getZ()
                              )
                           );
                        }

                        entity.setDeltaMovement(
                           new Vec3(
                              Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) * 2.0,
                              -1.5,
                              Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) * 2.0
                           )
                        );
                     }
                  }
               );
            } else {
               if (Mth.nextInt(RandomSource.create(), 1, 10) == 2
                  && entity instanceof LivingEntity _livEnt126
                  && _livEnt126.hasEffect((MobEffect)ArphexModMobEffects.FORCE_POWER.get())
                  && entity instanceof LivingEntity _entity) {
                  _entity.removeEffect((MobEffect)ArphexModMobEffects.FORCE_POWER.get());
               }

               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 120, 6, false, false));
               }

               if (world instanceof ServerLevel _levelx) {
                  _levelx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL,
                              new Vec3(entity.getX(), entity.getY(), entity.getZ()),
                              Vec2.ZERO,
                              _levelx,
                              4,
                              "",
                              Component.literal(""),
                              _levelx.getServer(),
                              null
                           )
                           .withSuppressedOutput(),
                        "effect give @e[type=!arphex:spider_moth,distance=..2] levitation 1 12 true"
                     );
               }

               if (world instanceof ServerLevel _levelx) {
                  _levelx.sendParticles(
                     (SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), entity.getX(), entity.getY(), entity.getZ(), 40, 1.0, 1.0, 1.0, 0.2
                  );
               }

               ArphexMod.queueServerWork(
                  75,
                  () -> {
                     if (world instanceof ServerLevel _levelxxx) {
                        _levelxxx.getServer()
                           .getCommands()
                           .performPrefixedCommand(
                              new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(entity.getX(), entity.getY(), entity.getZ()),
                                    Vec2.ZERO,
                                    _levelxxx,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _levelxxx.getServer(),
                                    null
                                 )
                                 .withSuppressedOutput(),
                              "effect give @e[type=!arphex:spider_moth,distance=..6] wither 5 3"
                           );
                     }

                     if (world instanceof ServerLevel _levelxx) {
                        _levelxx.sendParticles(
                           (SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), entity.getX(), entity.getY(), entity.getZ(), 30, 3.0, 0.3, 3.0, 0.5
                        );
                     }

                     if (world instanceof ServerLevel _levelx) {
                        _levelx.sendParticles(ParticleTypes.EXPLOSION, entity.getX(), entity.getY(), entity.getZ(), 20, 3.0, 0.3, 3.0, 0.5);
                     }

                     if (entity instanceof LivingEntity _entityx && !_entityx.level().isClientSide()) {
                        _entityx.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, false, false));
                     }
                  }
               );
               if (ArphexModVariables.MapVariables.get(world).attackcycle == 8.0 && ArphexModVariables.MapVariables.get(world).slightrandom.equals("first")
                  || ArphexModVariables.MapVariables.get(world).attackcycle == 4.0) {
                  if (world instanceof ServerLevel _levelx) {
                     _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(), x, y, z, 30, 3.0, 3.0, 3.0, 0.3);
                  }

                  if (Mth.nextInt(RandomSource.create(), 1, 7) == 7) {
                     if (world instanceof ServerLevel _levelx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_MOTH_LARVAE.get())
                           .spawn(_levelx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  } else if ((!(entity instanceof LivingEntity _livEnt154) || !_livEnt154.hasEffect(MobEffects.DIG_SPEED))
                     && world instanceof ServerLevel _levelxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.TELEPORT_GHOST.get())
                        .spawn(_levelxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }

                  ArphexMod.queueServerWork(
                     20,
                     () -> {
                        if (world instanceof ServerLevel _levelxxx) {
                           _levelxxx.getServer()
                              .getCommands()
                              .performPrefixedCommand(
                                 new CommandSourceStack(
                                       CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxxx, 4, "", Component.literal(""), _levelxxx.getServer(), null
                                    )
                                    .withSuppressedOutput(),
                                 "execute as @e[type=arphex:spider_moth,limit=1,sort=nearest] run data merge entity @s {Invulnerable:1}"
                              );
                        }

                        if (entity instanceof SpiderMothEntity _datEntSetL) {
                           _datEntSetL.getEntityData().set(SpiderMothEntity.DATA_growattack, true);
                        }

                        if (entity instanceof SpiderMothEntity animatable) {
                           animatable.setTexture("redglow");
                        }

                        if (entity instanceof LivingEntity _entityx && !_entityx.level().isClientSide()) {
                           _entityx.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 2, false, false));
                        }
                     }
                  );
                  ArphexMod.queueServerWork(40, () -> {
                     if (world instanceof ServerLevel _levelxxx) {
                        _levelxxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 30, 1.0, 1.0, 1.0, 0.0);
                     }

                     if (entity instanceof LivingEntity _entityxx && !_entityxx.level().isClientSide()) {
                        _entityxx.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20, 5, false, false));
                     }

                     if (entity instanceof LivingEntity _entityx && !_entityx.level().isClientSide()) {
                        _entityx.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 5, false, false));
                     }
                  });
                  ArphexMod.queueServerWork(60, () -> {
                     if (entity instanceof LivingEntity _entityx && !_entityx.level().isClientSide()) {
                        _entityx.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 6, false, false));
                     }

                     if (world instanceof ServerLevel _levelxxx) {
                        _levelxxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARRED_BLOOD.get(), x, y, z, 50, 1.0, 0.8, 1.0, 0.2);
                     }

                     if (world instanceof ServerLevel _levelxxx) {
                        _levelxxx.sendParticles(ParticleTypes.SWEEP_ATTACK, x, y, z, 50, 1.5, 0.5, 1.5, 0.5);
                     }
                  });
                  ArphexMod.queueServerWork(75, () -> {
                     if (entity instanceof SpiderMothEntity _datEntSetL) {
                        _datEntSetL.getEntityData().set(SpiderMothEntity.DATA_growattack, false);
                     }
                  });
               }
            }
         }

         ArphexMod.queueServerWork(1, () -> {
            if (entity instanceof SpiderMothEntity animatable) {
               animatable.setTexture("fullshadow");
            }
         });
         ArphexMod.queueServerWork(
            18,
            () -> {
               if ((!(entity instanceof SpiderMothEntity _datEntL173) || !(Boolean)_datEntL173.getEntityData().get(SpiderMothEntity.DATA_growattack))
                  && entity instanceof SpiderMothEntity animatable) {
                  animatable.setTexture("horrormothfixed");
               }
            }
         );
         if (Mth.nextInt(RandomSource.create(), 1, 2) == 2 && entity instanceof LivingEntity _entity) {
            _entity.removeEffect((MobEffect)ArphexModMobEffects.FORCE_POWER.get());
         }

         entity.getPersistentData().putBoolean("moth_has_been_attacked", true);
      }
   }
}
