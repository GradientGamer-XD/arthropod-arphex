package net.arphex.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Comparator;
import java.util.Map.Entry;
import net.arphex.ArphexMod;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.SpiderMothEntity;
import net.arphex.entity.TeleportGhostEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
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
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SpiderMothTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity nearestplayer50 = null;
         Entity nearestplayer200 = null;
         if (!entity.isVehicle()) {
            if (entity.getPersistentData().getDouble("spawnlim") > 0.0) {
               entity.getPersistentData().putDouble("spawnlim", entity.getPersistentData().getDouble("spawnlim") - 1.0);
            } else {
               entity.getPersistentData().putDouble("spawnlim", 10.0);
               if (entity.isAlive() && world instanceof ServerLevel _level) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.HITBOX_EXPANDER.get())
                     .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                  }
               }
            }
         }

         if (entity.getPersistentData().getBoolean("despawning") && !entity.level().isClientSide()) {
            entity.discard();
         }

         entity.getPersistentData().putDouble("minimumlifetime", entity.getPersistentData().getDouble("minimumlifetime") + 1.0);
         if (entity.getPersistentData().getDouble("minimumlifetime") > 12000.0
            && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 120.0, 120.0, 120.0), e -> true).isEmpty()) {
            ArphexMod.queueServerWork(20, () -> {
               if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 120.0, 120.0, 120.0), e -> true).isEmpty()) {
                  ArphexMod.queueServerWork(20, () -> {
                     ArphexModVariables.MapVariables.get(world).last_despawn_reasons = "moth-playerfar";
                     ArphexModVariables.MapVariables.get(world).syncData(world);
                     if (!entity.level().isClientSide()) {
                        entity.discard();
                     }
                  });
               }
            });
         }

         if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) > 0.0F)) {
            entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
            if (entity instanceof Mob _entity) {
               _entity.getNavigation().stop();
            }
         } else if ((entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F) < 35.0F) {
            if (entity instanceof LivingEntity _entity) {
               _entity.removeEffect(MobEffects.INVISIBILITY);
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 1));
            }
         }

         if (entity.getPersistentData().getBoolean("growattack") && entity instanceof SpiderMothEntity animatable) {
            animatable.setTexture("redglow");
         }

         if (!(Boolean)ConfigurationSettingsConfiguration.DWELLERS_INCLUSION.get()) {
            ArphexModVariables.MapVariables.get(world).last_despawn_reasons = "moth-bosses-disabled-config";
            ArphexModVariables.MapVariables.get(world).syncData(world);
            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         }

         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), e -> true).isEmpty()
            && entity.getPersistentData().getBoolean("spawnedawayfromplayer")) {
            nearestplayer50 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), e -> true)
               .stream()
               .sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z))
               .findFirst()
               .orElse(null);
            if (nearestplayer50.getPersistentData().getDouble("mothsurvivals") < 2.0
               && entity instanceof LivingEntity _entity
               && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 1, false, false));
            }

            if (nearestplayer50.getPersistentData().getDouble("mothsurvivals") < 3.0
               && entity instanceof LivingEntity _entity
               && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 0, false, false));
            }
         }

         if ((Boolean)ConfigurationSettingsConfiguration.DWELLER_HEALTH.get()
            && (entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F) > 60.0F
            && entity instanceof LivingEntity _entity) {
            _entity.setHealth(60.0F);
         }

         if (entity.getPersistentData().getString("chasemode").equals("no")) {
            entity.getPersistentData().putString("chasesoundonce", "one");
         } else if (entity.getPersistentData().getString("chasesoundonce").equals("one")) {
            if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
               if (world instanceof Level _levelx) {
                  if (!_levelx.isClientSide()) {
                     _levelx.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:mothchase")),
                        SoundSource.HOSTILE,
                        (float)Mth.nextDouble(RandomSource.create(), 0.2, 0.5),
                        (float)Mth.nextDouble(RandomSource.create(), 0.3, 1.7)
                     );
                  } else {
                     _levelx.playLocalSound(
                        x,
                        y,
                        z,
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:mothchase")),
                        SoundSource.HOSTILE,
                        (float)Mth.nextDouble(RandomSource.create(), 0.2, 0.5),
                        (float)Mth.nextDouble(RandomSource.create(), 0.3, 1.7),
                        false
                     );
                  }
               }
            } else if (world instanceof Level _levelxx) {
               if (!_levelxx.isClientSide()) {
                  _levelxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:mothchase2")),
                     SoundSource.HOSTILE,
                     (float)Mth.nextDouble(RandomSource.create(), 0.2, 0.5),
                     (float)Mth.nextDouble(RandomSource.create(), 0.3, 1.7)
                  );
               } else {
                  _levelxx.playLocalSound(
                     x,
                     y,
                     z,
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:mothchase2")),
                     SoundSource.HOSTILE,
                     (float)Mth.nextDouble(RandomSource.create(), 0.2, 0.5),
                     (float)Mth.nextDouble(RandomSource.create(), 0.3, 1.7),
                     false
                  );
               }
            }

            entity.getPersistentData().putString("chasesoundonce", "no");
         }

         if (Mth.nextInt(RandomSource.create(), 1, 1000) > 999
            && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true).isEmpty()
            && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true).isEmpty()) {
            entity.getPersistentData().putString("chasesoundonce", "one");
         }

         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40.0, 40.0, 40.0), e -> true).isEmpty()) {
            if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40.0, 40.0, 40.0), e -> true).stream().sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z)).findFirst().orElse(null).getPersistentData().getBoolean("creativespectator")) {
               if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true).isEmpty()) {
                  if (entity.getPersistentData().getString("dwellerwaiting").equals("spawned")) {
                     ArphexMod.queueServerWork(300, () -> entity.getPersistentData().putString("dwellerwaiting", "waiting"));
                  } else {
                     entity.getPersistentData().putString("dwellerwaiting", "waiting");
                     if (entity.getPersistentData().getString("dwellerwaiting").equals("waiting")) {
                        ArphexMod.queueServerWork(
                           300,
                           () -> {
                              if (entity.getPersistentData().getString("dwellerwaiting").equals("waiting")
                                 && world.getEntitiesOfClass(TeleportGhostEntity.class, AABB.ofSize(new Vec3(x, y, z), 15.0, 15.0, 15.0), e -> true).isEmpty()) {
                                 if (entity instanceof LivingEntity _livEnt63 && _livEnt63.hasEffect(MobEffects.DIG_SPEED)) {
                                    return;
                                 }

                                 if (world instanceof ServerLevel _levelxxx) {
                                    Entity entityToSpawn = ((EntityType)ArphexModEntities.TELEPORT_GHOST.get())
                                       .spawn(_levelxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                                    if (entityToSpawn != null) {
                                       entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                                    }
                                 }

                                 entity.getPersistentData().putString("dwellerwaiting", "spawned");
                              }
                           }
                        );
                     }
                  }
               } else {
                  entity.getPersistentData().putString("dwellerwaiting", "spawned");
               }
            }
         } else {
            entity.getPersistentData().putString("dwellerwaiting", "far");
         }

         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true).isEmpty()) {
            nearestplayer200 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true)
               .stream()
               .sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z))
               .findFirst()
               .orElse(null);
            if (!nearestplayer200.getPersistentData().getBoolean("creativespectator")) {
               nearestplayer200.getPersistentData().putBoolean("spidermothnear", true);
               if (entity instanceof Mob _entity && nearestplayer200 instanceof LivingEntity _ent) {
                  _entity.setTarget(_ent);
               }
            }

            if (!nearestplayer200.getPersistentData().getBoolean("creativespectator")) {
               if (entity instanceof Mob _entity && nearestplayer200 instanceof LivingEntity _ent) {
                  _entity.setTarget(_ent);
               }

               if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true).isEmpty()) {
                  if (entity.getPersistentData().getString("playerlookedatmoth").equals("no")) {
                     if (entity.getPersistentData().getString("chasemode").equals("no")) {
                        if (entity instanceof Mob _entity) {
                           _entity.getNavigation().stop();
                        }

                        if (entity instanceof SpiderMothEntity) {
                           ((SpiderMothEntity)entity).setAnimation("animation.spider_moth_dweller.staring");
                        }

                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 10, true, false));
                        }

                        entity.setDeltaMovement(new Vec3(0.0, -0.1, 0.0));
                        ArphexMod.queueServerWork(1, () -> {
                           if (entity instanceof Mob _entity) {
                              _entity.getNavigation().stop();
                           }

                           entity.setDeltaMovement(new Vec3(0.0, -0.1, 0.0));
                           ArphexMod.queueServerWork(1, () -> {
                              if (entity instanceof Mob _entityx) {
                                 _entityx.getNavigation().stop();
                              }

                              entity.setDeltaMovement(new Vec3(0.0, -0.1, 0.0));
                              ArphexMod.queueServerWork(1, () -> {
                                 if (entity instanceof Mob _entityxx) {
                                    _entityxx.getNavigation().stop();
                                 }

                                 entity.setDeltaMovement(new Vec3(0.0, -0.1, 0.0));
                                 ArphexMod.queueServerWork(1, () -> {
                                    if (entity instanceof Mob _entityxxx) {
                                       _entityxxx.getNavigation().stop();
                                    }

                                    entity.setDeltaMovement(new Vec3(0.0, -0.1, 0.0));
                                 });
                              });
                           });
                        });
                        if (!world.isClientSide()) {
                           entity.lookAt(Anchor.EYES, new Vec3(nearestplayer200.getX(), nearestplayer200.getY(), nearestplayer200.getZ()));
                        }
                     }
                  } else {
                     if (!world.isClientSide()) {
                        entity.lookAt(Anchor.EYES, new Vec3(nearestplayer200.getX(), nearestplayer200.getY(), nearestplayer200.getZ()));
                     }

                     ArphexModVariables.MapVariables.get(world).LookScareLock = "true";
                     ArphexModVariables.MapVariables.get(world).syncData(world);
                     entity.getPersistentData().putString("chasemode", "chasing");
                     if (ArphexModVariables.MapVariables.get(world).LookScareLock.equals("true")) {
                        if (entity.getPersistentData().getString("soundonce").equals("one")) {
                           if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 1, false, false));
                           }

                           if (world instanceof ServerLevel _levelxxx) {
                              _levelxxx.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL,
                                          new Vec3(x, y, z),
                                          Vec2.ZERO,
                                          _levelxxx,
                                          4,
                                          "",
                                          Component.literal(""),
                                          _levelxxx.getServer(),
                                          null
                                       )
                                       .withSuppressedOutput(),
                                    "execute as @a[distance=..100,gamemode=!creative,gamemode=!spectator] at @s anchored eyes run particle minecraft:smoke ~0.1 ~1.3 ~0 0 0 0 0.04 500"
                                 );
                           }

                           if (world instanceof ServerLevel _levelxxx) {
                              _levelxxx.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL,
                                          new Vec3(x, y, z),
                                          Vec2.ZERO,
                                          _levelxxx,
                                          4,
                                          "",
                                          Component.literal(""),
                                          _levelxxx.getServer(),
                                          null
                                       )
                                       .withSuppressedOutput(),
                                    "execute as @a[distance=..100,gamemode=!creative,gamemode=!spectator] at @s run playsound arphex:mothscare hostile @s ~ ~ ~ 0.7 0.5"
                                 );
                           }

                           if (world instanceof ServerLevel _levelxxx) {
                              _levelxxx.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL,
                                          new Vec3(x, y, z),
                                          Vec2.ZERO,
                                          _levelxxx,
                                          4,
                                          "",
                                          Component.literal(""),
                                          _levelxxx.getServer(),
                                          null
                                       )
                                       .withSuppressedOutput(),
                                    "execute as @a[distance=..100,gamemode=!creative,gamemode=!spectator] at @s run playsound arphex:horror_crash hostile @s ~ ~ ~ 0.7 0.5"
                                 );
                           }

                           if (world instanceof ServerLevel _levelxxx) {
                              _levelxxx.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL,
                                          new Vec3(x, y, z),
                                          Vec2.ZERO,
                                          _levelxxx,
                                          4,
                                          "",
                                          Component.literal(""),
                                          _levelxxx.getServer(),
                                          null
                                       )
                                       .withSuppressedOutput(),
                                    "effect give @a[distance=..100,gamemode=!creative,gamemode=!spectator] minecraft:darkness 8 1 true"
                                 );
                           }

                           if (world instanceof ServerLevel _levelxxx) {
                              _levelxxx.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL,
                                          new Vec3(x, y, z),
                                          Vec2.ZERO,
                                          _levelxxx,
                                          4,
                                          "",
                                          Component.literal(""),
                                          _levelxxx.getServer(),
                                          null
                                       )
                                       .withSuppressedOutput(),
                                    "effect give @a[distance=..100,gamemode=!creative,gamemode=!spectator] minecraft:slowness 9 0 true"
                                 );
                           }

                           Vec3 _center = new Vec3(x, y, z);

                           for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(75.0), e -> true)
                              .stream()
                              .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                              .toList()) {
                              if (entityiterator instanceof Player) {
                                 String _setval = "true";
                                 entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.ShowOverlay = _setval;
                                    capability.syncPlayerVariables(entityiterator);
                                 });
                                 ArphexMod.queueServerWork(4, () -> {
                                    String _setvalx = "false";
                                    entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                       capability.ShowOverlay = _setval;
                                       capability.syncPlayerVariables(entityiterator);
                                    });
                                 });
                              }
                           }

                           entity.getPersistentData().putString("soundonce", "stop");
                        }

                        ArphexMod.queueServerWork(4, () -> {
                           ArphexModVariables.MapVariables.get(world).LookScareLock = "false";
                           ArphexModVariables.MapVariables.get(world).syncData(world);
                        });
                     }
                  }
               }
            }

            if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()
               && Mth.nextInt(RandomSource.create(), 1, 1300) == 200) {
               if (Mth.nextInt(RandomSource.create(), 1, 4) == 2) {
                  if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                     if (world instanceof Level _levelxxx) {
                        if (!_levelxxx.isClientSide()) {
                           _levelxxx.playSound(
                              null,
                              BlockPos.containing(nearestplayer200.getX(), nearestplayer200.getY(), nearestplayer200.getZ()),
                              (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:mothscream2")),
                              SoundSource.HOSTILE,
                              (float)Mth.nextDouble(RandomSource.create(), 0.1, 0.4),
                              (float)Mth.nextDouble(RandomSource.create(), 0.2, 1.7)
                           );
                        } else {
                           _levelxxx.playLocalSound(
                              nearestplayer200.getX(),
                              nearestplayer200.getY(),
                              nearestplayer200.getZ(),
                              (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:mothscream2")),
                              SoundSource.HOSTILE,
                              (float)Mth.nextDouble(RandomSource.create(), 0.1, 0.4),
                              (float)Mth.nextDouble(RandomSource.create(), 0.2, 1.7),
                              false
                           );
                        }
                     }
                  } else if (world instanceof Level _levelxxxx) {
                     if (!_levelxxxx.isClientSide()) {
                        _levelxxxx.playSound(
                           null,
                           BlockPos.containing(nearestplayer200.getX(), nearestplayer200.getY(), nearestplayer200.getZ()),
                           (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:spidermothcroak2")),
                           SoundSource.HOSTILE,
                           (float)Mth.nextDouble(RandomSource.create(), 0.1, 0.8),
                           (float)Mth.nextDouble(RandomSource.create(), 0.8, 1.2)
                        );
                     } else {
                        _levelxxxx.playLocalSound(
                           nearestplayer200.getX(),
                           nearestplayer200.getY(),
                           nearestplayer200.getZ(),
                           (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:spidermothcroak2")),
                           SoundSource.HOSTILE,
                           (float)Mth.nextDouble(RandomSource.create(), 0.1, 0.8),
                           (float)Mth.nextDouble(RandomSource.create(), 0.8, 1.2),
                           false
                        );
                     }
                  }
               } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                  if (world instanceof Level _levelxxxxx) {
                     if (!_levelxxxxx.isClientSide()) {
                        _levelxxxxx.playSound(
                           null,
                           BlockPos.containing(nearestplayer200.getX(), nearestplayer200.getY(), nearestplayer200.getZ()),
                           (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:spidermothcroak")),
                           SoundSource.HOSTILE,
                           (float)Mth.nextDouble(RandomSource.create(), 0.1, 0.8),
                           (float)Mth.nextDouble(RandomSource.create(), 0.8, 1.2)
                        );
                     } else {
                        _levelxxxxx.playLocalSound(
                           nearestplayer200.getX(),
                           nearestplayer200.getY(),
                           nearestplayer200.getZ(),
                           (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:spidermothcroak")),
                           SoundSource.HOSTILE,
                           (float)Mth.nextDouble(RandomSource.create(), 0.1, 0.8),
                           (float)Mth.nextDouble(RandomSource.create(), 0.8, 1.2),
                           false
                        );
                     }
                  }
               } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                  if (world instanceof Level _levelxxxxxx) {
                     if (!_levelxxxxxx.isClientSide()) {
                        _levelxxxxxx.playSound(
                           null,
                           BlockPos.containing(nearestplayer200.getX(), nearestplayer200.getY(), nearestplayer200.getZ()),
                           (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:spidermothcroak3")),
                           SoundSource.HOSTILE,
                           (float)Mth.nextDouble(RandomSource.create(), 0.1, 0.4),
                           (float)Mth.nextDouble(RandomSource.create(), 0.2, 1.7)
                        );
                     } else {
                        _levelxxxxxx.playLocalSound(
                           nearestplayer200.getX(),
                           nearestplayer200.getY(),
                           nearestplayer200.getZ(),
                           (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:spidermothcroak3")),
                           SoundSource.HOSTILE,
                           (float)Mth.nextDouble(RandomSource.create(), 0.1, 0.4),
                           (float)Mth.nextDouble(RandomSource.create(), 0.2, 1.7),
                           false
                        );
                     }
                  }
               } else if (world instanceof Level _levelxxxxxxx) {
                  if (!_levelxxxxxxx.isClientSide()) {
                     _levelxxxxxxx.playSound(
                        null,
                        BlockPos.containing(nearestplayer200.getX(), nearestplayer200.getY(), nearestplayer200.getZ()),
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:spidermothcroak4")),
                        SoundSource.HOSTILE,
                        (float)Mth.nextDouble(RandomSource.create(), 0.1, 0.4),
                        (float)Mth.nextDouble(RandomSource.create(), 0.2, 1.7)
                     );
                  } else {
                     _levelxxxxxxx.playLocalSound(
                        nearestplayer200.getX(),
                        nearestplayer200.getY(),
                        nearestplayer200.getZ(),
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:spidermothcroak4")),
                        SoundSource.HOSTILE,
                        (float)Mth.nextDouble(RandomSource.create(), 0.1, 0.4),
                        (float)Mth.nextDouble(RandomSource.create(), 0.2, 1.7),
                        false
                     );
                  }
               }
            }
         } else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 500.0, 500.0, 500.0), e -> true).isEmpty()
            && entity.getPersistentData().getString("playerlookedatmoth").equals("looking")
            && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 500.0, 500.0, 500.0), e -> true).stream().sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z)).findFirst().orElse(null).getPersistentData().getBoolean("creativespectator")) {
            if (entity.getPersistentData().getString("soundonce").equals("one")) {
               if (world instanceof ServerLevel _levelxxxxxxxx) {
                  _levelxxxxxxxx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxxxxxxxx, 4, "", Component.literal(""), _levelxxxxxxxx.getServer(), null
                           )
                           .withSuppressedOutput(),
                        "execute at @p run playsound arphex:mothscare hostile @p ~ ~ ~ 0.7 0.5"
                     );
               }

               if (world instanceof ServerLevel _levelxxxxxxxx) {
                  _levelxxxxxxxx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxxxxxxxx, 4, "", Component.literal(""), _levelxxxxxxxx.getServer(), null
                           )
                           .withSuppressedOutput(),
                        "execute at @p run playsound arphex:horror_crash hostile @p ~ ~ ~ 0.7 0.5"
                     );
               }

               if (world instanceof ServerLevel _levelxxxxxxxx) {
                  _levelxxxxxxxx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxxxxxxxx, 4, "", Component.literal(""), _levelxxxxxxxx.getServer(), null
                           )
                           .withSuppressedOutput(),
                        "execute as @p at @s anchored eyes run particle minecraft:smoke ~0.1 ~1.3 ~0 0 0 0 0.04 500"
                     );
               }

               if (world instanceof ServerLevel _levelxxxxxxxx) {
                  _levelxxxxxxxx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxxxxxxxx, 4, "", Component.literal(""), _levelxxxxxxxx.getServer(), null
                           )
                           .withSuppressedOutput(),
                        "effect give @p darkness 8 1 true"
                     );
               }

               if (world instanceof ServerLevel _levelxxxxxxxx) {
                  _levelxxxxxxxx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxxxxxxxx, 4, "", Component.literal(""), _levelxxxxxxxx.getServer(), null
                           )
                           .withSuppressedOutput(),
                        "effect give @p slowness 9 0 true"
                     );
               }

               entity.getPersistentData().putString("soundonce", "stop");
            }

            ArphexModVariables.MapVariables.get(world).LookScareLock = "true";
            ArphexModVariables.MapVariables.get(world).syncData(world);
            ArphexMod.queueServerWork(4, () -> {
               if (entity.getPersistentData().getString("playerlookedatmoth").equals("no")) {
                  String _setval = "false";
                  entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.ShowOverlay = _setval;
                     capability.syncPlayerVariables(entity);
                  });
               }

               entity.getPersistentData().putString("chasemode", "chasing");
            });
         }

         if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)
            && (
               world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == Blocks.TORCH
                  || world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getBlock() == Blocks.WALL_TORCH
            )) {
            BlockPos _bp = BlockPos.containing(x, y, z);
            BlockState _bs = Blocks.AIR.defaultBlockState();
            BlockState _bso = world.getBlockState(_bp);
            UnmodifiableIterator var153 = _bso.getValues().entrySet().iterator();

            while (var153.hasNext()) {
               Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var153.next();
               Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
               if (_property != null && _bs.getValue(_property) != null) {
                  try {
                     _bs = (BlockState)_bs.setValue(_property, entry.getValue());
                  } catch (Exception var32) {
                  }
               }
            }

            world.setBlock(_bp, _bs, 3);
            _bp = BlockPos.containing(x, y + 1.0, z);
            _bs = Blocks.AIR.defaultBlockState();
            _bso = world.getBlockState(_bp);
            var153 = _bso.getValues().entrySet().iterator();

            while (var153.hasNext()) {
               Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var153.next();
               Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
               if (_property != null && _bs.getValue(_property) != null) {
                  try {
                     _bs = (BlockState)_bs.setValue(_property, entry.getValue());
                  } catch (Exception var31) {
                  }
               }
            }

            world.setBlock(_bp, _bs, 3);
            if (world instanceof ServerLevel _levelxxxxxxxx) {
               ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxx, x, y, z, new ItemStack(Blocks.TORCH));
               entityToSpawn.setPickUpDelay(10);
               _levelxxxxxxxx.addFreshEntity(entityToSpawn);
            }
         }

         label1076:
         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
            if (Mth.nextInt(RandomSource.create(), 1, 300) == 200) {
               if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                  if (world instanceof Level _levelxxxxxxxx) {
                     if (!_levelxxxxxxxx.isClientSide()) {
                        _levelxxxxxxxx.playSound(
                           null,
                           BlockPos.containing(x, y, z),
                           (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:mothscream")),
                           SoundSource.NEUTRAL,
                           (float)Mth.nextDouble(RandomSource.create(), 0.2, 0.6),
                           (float)Mth.nextDouble(RandomSource.create(), 0.3, 1.7)
                        );
                     } else {
                        _levelxxxxxxxx.playLocalSound(
                           x,
                           y,
                           z,
                           (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:mothscream")),
                           SoundSource.NEUTRAL,
                           (float)Mth.nextDouble(RandomSource.create(), 0.2, 0.6),
                           (float)Mth.nextDouble(RandomSource.create(), 0.3, 1.7),
                           false
                        );
                     }
                  }
               } else if (world instanceof Level _levelxxxxxxxxx) {
                  if (!_levelxxxxxxxxx.isClientSide()) {
                     _levelxxxxxxxxx.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:mothscream2")),
                        SoundSource.HOSTILE,
                        (float)Mth.nextDouble(RandomSource.create(), 0.2, 0.6),
                        (float)Mth.nextDouble(RandomSource.create(), 0.3, 1.7)
                     );
                  } else {
                     _levelxxxxxxxxx.playLocalSound(
                        x,
                        y,
                        z,
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:mothscream2")),
                        SoundSource.HOSTILE,
                        (float)Mth.nextDouble(RandomSource.create(), 0.2, 0.6),
                        (float)Mth.nextDouble(RandomSource.create(), 0.3, 1.7),
                        false
                     );
                  }
               }
            }

            if (world instanceof Level _lvl185 && _lvl185.isDay()) {
               if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                  _levelxxxxxxxxxx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL,
                              new Vec3(x, y, z),
                              Vec2.ZERO,
                              _levelxxxxxxxxxx,
                              4,
                              "",
                              Component.literal(""),
                              _levelxxxxxxxxxx.getServer(),
                              null
                           )
                           .withSuppressedOutput(),
                        "effect give @p[gamemode=survival,distance=..2] darkness 1 0"
                     );
               }

               if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                  _levelxxxxxxxxxx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL,
                              new Vec3(x, y, z),
                              Vec2.ZERO,
                              _levelxxxxxxxxxx,
                              4,
                              "",
                              Component.literal(""),
                              _levelxxxxxxxxxx.getServer(),
                              null
                           )
                           .withSuppressedOutput(),
                        "effect give @p[gamemode=adventure,distance=..2] darkness 1 0"
                     );
               }
               break label1076;
            }

            if (world instanceof ServerLevel _levelxxxxxxxxxx) {
               _levelxxxxxxxxxx.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                           CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxxxxxxxxxx, 4, "", Component.literal(""), _levelxxxxxxxxxx.getServer(), null
                        )
                        .withSuppressedOutput(),
                     "effect give @p[gamemode=survival] darkness 5 0"
                  );
            }

            if (world instanceof ServerLevel _levelxxxxxxxxxx) {
               _levelxxxxxxxxxx.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                           CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxxxxxxxxxx, 4, "", Component.literal(""), _levelxxxxxxxxxx.getServer(), null
                        )
                        .withSuppressedOutput(),
                     "effect give @p[gamemode=adventure] darkness 5 0"
                  );
            }
         }

         if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)
            && (Boolean)ConfigurationSettingsConfiguration.ARPHEX_GRIEFING.get()
            && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).isEmpty()) {
            if (!(entity.getPersistentData().getDouble("breaklimit") > 0.0)) {
               entity.getPersistentData().putDouble("breaklimit", 20.0);
               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true).isEmpty()
                  && world instanceof ServerLevel _levelxxxxxxxxxx) {
                  _levelxxxxxxxxxx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL,
                              new Vec3(x, y, z),
                              Vec2.ZERO,
                              _levelxxxxxxxxxx,
                              4,
                              "",
                              Component.literal(""),
                              _levelxxxxxxxxxx.getServer(),
                              null
                           )
                           .withSuppressedOutput(),
                        "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace glass_pane"
                     );
               }

               if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                  _levelxxxxxxxxxx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL,
                              new Vec3(x, y, z),
                              Vec2.ZERO,
                              _levelxxxxxxxxxx,
                              4,
                              "",
                              Component.literal(""),
                              _levelxxxxxxxxxx.getServer(),
                              null
                           )
                           .withSuppressedOutput(),
                        "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace #minecraft:leaves"
                     );
               }

               if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                  _levelxxxxxxxxxx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL,
                              new Vec3(x, y, z),
                              Vec2.ZERO,
                              _levelxxxxxxxxxx,
                              4,
                              "",
                              Component.literal(""),
                              _levelxxxxxxxxxx.getServer(),
                              null
                           )
                           .withSuppressedOutput(),
                        "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace #arphex:breakable_doors"
                     );
               }
            } else {
               entity.getPersistentData().putDouble("breaklimit", entity.getPersistentData().getDouble("breaklimit") - 1.0);
            }
         }

         if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 80.0, 80.0, 80.0), e -> true).isEmpty()) {
            entity.setMaxUpStep(6.0F);
         }

         if (!world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z)) && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 2, false, false));
         }

         label1144: {
            if (entity instanceof LivingEntity _livEnt205 && _livEnt205.hasEffect(MobEffects.DAMAGE_BOOST)) {
               if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                  _levelxxxxxxxxxx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL,
                              new Vec3(x, y, z),
                              Vec2.ZERO,
                              _levelxxxxxxxxxx,
                              4,
                              "",
                              Component.literal(""),
                              _levelxxxxxxxxxx.getServer(),
                              null
                           )
                           .withSuppressedOutput(),
                        "attribute @e[type=arphex:spider_moth,limit=1] minecraft:generic.attack_knockback base set 500"
                     );
               }
               break label1144;
            }

            if (entity instanceof LivingEntity _livEnt207 && _livEnt207.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
               if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                  _levelxxxxxxxxxx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL,
                              new Vec3(x, y, z),
                              Vec2.ZERO,
                              _levelxxxxxxxxxx,
                              4,
                              "",
                              Component.literal(""),
                              _levelxxxxxxxxxx.getServer(),
                              null
                           )
                           .withSuppressedOutput(),
                        "attribute @e[type=arphex:spider_moth,limit=1] minecraft:generic.attack_knockback base set 0.5"
                     );
               }
               break label1144;
            }

            if (world instanceof ServerLevel _levelxxxxxxxxxx) {
               _levelxxxxxxxxxx.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                           CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxxxxxxxxxx, 4, "", Component.literal(""), _levelxxxxxxxxxx.getServer(), null
                        )
                        .withSuppressedOutput(),
                     "attribute @e[type=arphex:spider_moth,limit=1] minecraft:generic.attack_knockback base set 1"
                  );
            }
         }

         if (!(entity instanceof SpiderMothEntity animatablex ? animatablex.getTexture() : "null").equals("redglow")
            && !(entity instanceof SpiderMothEntity animatable ? animatable.getTexture() : "null").equals("fullshadow")) {
            if (world instanceof ServerLevel _levelxxxxxxxxxx) {
               _levelxxxxxxxxxx.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                           CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxxxxxxxxxx, 4, "", Component.literal(""), _levelxxxxxxxxxx.getServer(), null
                        )
                        .withSuppressedOutput(),
                     "execute as @e[type=arphex:spider_moth,limit=1,sort=nearest] run data merge entity @s {Invulnerable:0}"
                  );
            }
         } else if (world instanceof ServerLevel _levelxxxxxxxxxx) {
            _levelxxxxxxxxxx.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                        CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxxxxxxxxxx, 4, "", Component.literal(""), _levelxxxxxxxxxx.getServer(), null
                     )
                     .withSuppressedOutput(),
                  "execute as @e[type=arphex:spider_moth,limit=1,sort=nearest] run data merge entity @s {Invulnerable:1}"
               );
         }

         if ((entity instanceof SpiderMothEntity animatablexx ? animatablexx.getTexture() : "null").equals("fullshadow")) {
            ArphexMod.queueServerWork(20, () -> {
               if (entity instanceof SpiderMothEntity animatablexxx) {
                  animatablexxx.setTexture("horrormothfixed");
               }
            });
         }

         if (entity.getDisplayName().getString().equals("Monstrous Spider Moth")
            && (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
               == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))) {
            if (entity instanceof SpiderMothEntity animatablexx) {
               animatablexx.setTexture("spidermothguardian");
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 1, false, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1200, 0, false, false));
            }

            if ((entity instanceof SpiderMothEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderMothEntity.DATA_moth_limit) : 0) > 0) {
               if (entity instanceof SpiderMothEntity _datEntSetI) {
                  _datEntSetI.getEntityData()
                     .set(
                        SpiderMothEntity.DATA_moth_limit,
                        (entity instanceof SpiderMothEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SpiderMothEntity.DATA_moth_limit) : 0) - 1
                     );
               }
            } else {
               Vec3 _center = new Vec3(x, y, z);

               for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(75.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiteratorx instanceof Player
                     && (
                        (new Object() {
                                 public boolean checkGamemode(Entity _ent) {
                                    if (_ent instanceof ServerPlayer _serverPlayer) {
                                       return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
                                    } else {
                                       return _ent.level().isClientSide() && _ent instanceof Player _player
                                          ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                             && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode()
                                                == GameType.SURVIVAL
                                          : false;
                                    }
                                 }
                              })
                              .checkGamemode(entityiteratorx)
                           || (new Object() {
                                 public boolean checkGamemode(Entity _ent) {
                                    if (_ent instanceof ServerPlayer _serverPlayer) {
                                       return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
                                    } else {
                                       return _ent.level().isClientSide() && _ent instanceof Player _player
                                          ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                             && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode()
                                                == GameType.ADVENTURE
                                          : false;
                                    }
                                 }
                              })
                              .checkGamemode(entityiteratorx)
                     )) {
                     if (entityiteratorx instanceof LivingEntity _livEnt230 && _livEnt230.hasEffect(MobEffects.DIG_SLOWDOWN)) {
                        continue;
                     }

                     if (entityiteratorx instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.FATIGUE_SHOW.get(), 5, 0, false, false));
                     }

                     if (entityiteratorx instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 2000, 2, false, false));
                     }

                     if (world instanceof Level _levelxxxxxxxxxx) {
                        if (!_levelxxxxxxxxxx.isClientSide()) {
                           _levelxxxxxxxxxx.playSound(
                              null,
                              BlockPos.containing(entityiteratorx.getX(), entityiteratorx.getY(), entityiteratorx.getZ()),
                              (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.elder_guardian.curse")),
                              SoundSource.HOSTILE,
                              0.5F,
                              0.5F
                           );
                        } else {
                           _levelxxxxxxxxxx.playLocalSound(
                              entityiteratorx.getX(),
                              entityiteratorx.getY(),
                              entityiteratorx.getZ(),
                              (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.elder_guardian.curse")),
                              SoundSource.HOSTILE,
                              0.5F,
                              0.5F,
                              false
                           );
                        }
                     }

                     if (entity instanceof SpiderMothEntity _datEntSetI) {
                        _datEntSetI.getEntityData().set(SpiderMothEntity.DATA_moth_limit, 1200);
                     }
                  }
               }
            }
         } else if ((entity instanceof SpiderMothEntity animatablexxx ? animatablexxx.getTexture() : "null").equals("redglow")
            || entity.getPersistentData().getBoolean("growattack")
            || (entity instanceof SpiderMothEntity animatablexx ? animatablexx.getTexture() : "null").equals("fullshadow")) {
            ArphexMod.queueServerWork(
               60,
               () -> {
                  if ((entity instanceof SpiderMothEntity animatablex ? animatablex.getTexture() : "null").equals("redglow")
                     && entity instanceof SpiderMothEntity animatablexxxx) {
                     animatablexxxx.setTexture("horrormothfixed");
                  }
               }
            );
         } else if ((entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F) > 175.0F) {
            if (entity instanceof SpiderMothEntity animatablexx) {
               animatablexx.setTexture("horrormothfixed");
            }
         } else {
            if (!(Boolean)ConfigurationSettingsConfiguration.DWELLER_HEALTH.get() && entity instanceof SpiderMothEntity animatablexx) {
               animatablexx.setTexture("horrormothlowhealthfixed");
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20, 0, true, false));
            }

            if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getHealth() : -1.0F) < 30.0F && entity instanceof SpiderMothEntity animatablexx) {
               animatablexx.setTexture("horrormothlowhealthfixed");
            }
         }

         if (entity.getPersistentData().getBoolean("growattack") && world instanceof ServerLevel _levelxxxxxxxxxxx) {
            _levelxxxxxxxxxxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 10, 1.5, 3.0, 1.5, 0.0);
         }

         if ((entity instanceof SpiderMothEntity animatablexx ? animatablexx.getTexture() : "null").equals("horrormothfixed")) {
            if (world instanceof ServerLevel _levelxxxxxxxxxxx) {
               _levelxxxxxxxxxxx.sendParticles(
                  (SimpleParticleType)ArphexModParticleTypes.TINY_SPIDER.get(),
                  x,
                  y + 1.0,
                  z,
                  (int)((entity instanceof LivingEntity _livEntxx ? _livEntxx.getHealth() : -1.0F) / 2.0F),
                  0.8,
                  1.0,
                  0.8,
                  3.0
               );
            }

            if (world instanceof ServerLevel _levelxxxxxxxxxxx) {
               _levelxxxxxxxxxxx.sendParticles(
                  (SimpleParticleType)ArphexModParticleTypes.TINY_MOTH.get(),
                  x,
                  y + 1.0,
                  z,
                  (int)((entity instanceof LivingEntity _livEntxx ? _livEntxx.getHealth() : -1.0F) / 2.0F),
                  0.8,
                  1.0,
                  0.8,
                  3.0
               );
            }
         }

         if ((entity instanceof SpiderMothEntity animatablexx ? animatablexx.getTexture() : "null").equals("horrormothlowhealthfixed")) {
            if (world instanceof ServerLevel _levelxxxxxxxxxxx) {
               _levelxxxxxxxxxxx.sendParticles(
                  (SimpleParticleType)ArphexModParticleTypes.CHARRED_BLOOD.get(),
                  x,
                  y,
                  z,
                  (int)(entity instanceof LivingEntity _livEntxx ? _livEntxx.getHealth() : -1.0F),
                  0.8,
                  1.0,
                  0.8,
                  1.0
               );
            }

            ArphexMod.queueServerWork(5, () -> {
               if ((entity instanceof SpiderMothEntity animatablexxx ? animatablexxx.getTexture() : "null").equals("fullshadow")) {
                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 10, 1, false, false));
                  }

                  if (world instanceof ServerLevel _levelxxxxxxxxxxx) {
                     _levelxxxxxxxxxxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 5, 0.5, 0.5, 0.5, 0.5);
                  }
               }
            });
         }

         label1008: {
            if (entity instanceof SpiderMothEntity _datEntL266 && (Boolean)_datEntL266.getEntityData().get(SpiderMothEntity.DATA_growattack)) {
               entity.getPersistentData().putDouble("enbeetee", entity.getPersistentData().getDouble("enbeetee") + 0.05);
               break label1008;
            }

            entity.getPersistentData().putDouble("enbeetee", 1.65);
         }

         if (entity.isInWall() || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == Blocks.POWDER_SNOW) {
            entity.teleportTo(x, y + 0.9, z);
            if (entity instanceof ServerPlayer _serverPlayer) {
               _serverPlayer.connection.teleport(x, y + 0.9, z, entity.getYRot(), entity.getXRot());
            }

            entity.setDeltaMovement(
               new Vec3(Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)), 0.0, Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)))
            );
            if (world instanceof ServerLevel _levelxxxxxxxxxxx) {
               _levelxxxxxxxxxxx.sendParticles(ParticleTypes.EXPLOSION, x, y, z, 5, 3.0, 3.0, 3.0, 1.0);
            }
         }

         if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == Blocks.COBWEB
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10, 4, false, false));
         }

         if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
            if (entity.onGround()) {
               entity.getPersistentData().putBoolean("disable_rotation", false);
            } else {
               entity.getPersistentData().putBoolean("disable_rotation", true);
            }

            if (!((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getY() > entity.getY() + 2.0)
               && !entity.isInWater()
               && !(world.getFluidState(BlockPos.containing(x - 1.0, y, z)).createLegacyBlock().getBlock() instanceof LiquidBlock)
               && !(world.getFluidState(BlockPos.containing(x + 1.0, y, z)).createLegacyBlock().getBlock() instanceof LiquidBlock)
               && !(world.getFluidState(BlockPos.containing(x, y, z + 1.0)).createLegacyBlock().getBlock() instanceof LiquidBlock)
               && !(world.getFluidState(BlockPos.containing(x, y, z - 1.0)).createLegacyBlock().getBlock() instanceof LiquidBlock)
               && !(world.getFluidState(BlockPos.containing(x, y, z)).createLegacyBlock().getBlock() instanceof LiquidBlock)) {
               entity.getPersistentData().putBoolean("disable_rotation", true);
               entity.setMaxUpStep(2.0F);
            } else {
               if (!world.isClientSide()) {
                  entity.getPersistentData().putBoolean("noai_reset", true);
                  if (!entity.level().isClientSide() && entity.getServer() != null) {
                     entity.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                              CommandSource.NULL,
                              entity.position(),
                              entity.getRotationVector(),
                              entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                              4,
                              entity.getName().getString(),
                              entity.getDisplayName(),
                              entity.level().getServer(),
                              entity
                           ),
                           "data modify entity @s NoAI set value 1b"
                        );
                  }

                  entity.lookAt(
                     Anchor.EYES,
                     new Vec3(
                        (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getX(),
                        (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getY(),
                        (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getZ()
                     )
                  );
                  if (!entity.level().isClientSide() && entity.getServer() != null) {
                     entity.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                              CommandSource.NULL,
                              entity.position(),
                              entity.getRotationVector(),
                              entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                              4,
                              entity.getName().getString(),
                              entity.getDisplayName(),
                              entity.level().getServer(),
                              entity
                           ),
                           "data modify entity @s NoAI set value 0b"
                        );
                  }

                  entity.getPersistentData().putBoolean("noai_reset", false);
               }

               if (entity.getPersistentData().getBoolean("noai_reset") && !entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                           CommandSource.NULL,
                           entity.position(),
                           entity.getRotationVector(),
                           entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                           4,
                           entity.getName().getString(),
                           entity.getDisplayName(),
                           entity.level().getServer(),
                           entity
                        ),
                        "data modify entity @s NoAI set value 0b"
                     );
               }

               entity.setMaxUpStep(3.0F);
               if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) != null) {
                  if (!((entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null) instanceof Player)
                     || !entity.getPersistentData().getString("chasemode").equals("no")) {
                     entity.setDeltaMovement(
                        new Vec3(
                           Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)),
                           1.0,
                           Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0))
                        )
                     );
                  }

                  ArphexMod.queueServerWork(
                     40,
                     () -> {
                        if (Mth.nextInt(RandomSource.create(), 1, 10) == 5
                           && (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null) != null
                           && !entity.getPersistentData().getString("chasemode").equals("no")) {
                           entity.setDeltaMovement(
                              new Vec3(
                                 Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)),
                                 0.1,
                                 Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0))
                              )
                           );
                        }
                     }
                  );
               }
            }

            if ((!(entity instanceof LivingEntity _livEnt333) || !_livEnt333.hasEffect(MobEffects.REGENERATION))
               && entity instanceof LivingEntity _entity
               && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 0, false, false));
            }

            if ((
                  !(entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).isAlive()
                     || (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getPersistentData().getBoolean("creativespectator")
               )
               && entity instanceof Mob) {
               try {
                  ((Mob)entity).setTarget(null);
               } catch (Exception var30) {
                  var30.printStackTrace();
               }
            }
         } else {
            entity.getPersistentData().putBoolean("disable_rotation", true);
            if (!world.getEntitiesOfClass(Pig.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true).isEmpty() && entity instanceof Mob _entity
               )
             {
               Entity var159 = world.getEntitiesOfClass(Pig.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null);
               if (var159 instanceof LivingEntity _ent) {
                  _entity.setTarget(_ent);
               }
            }

            entity.getPersistentData().putBoolean("justattacked", false);
         }

         if (entity.onGround()) {
            if (entity.getPersistentData().getDouble("dramaticfall") > 40.0) {
               if (world instanceof ServerLevel _levelxxxxxxxxxxx) {
                  _levelxxxxxxxxxxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 40, 0.1, 1.0, 0.1, 0.3);
               }

               if (world instanceof Level _levelxxxxxxxxxxx) {
                  if (!_levelxxxxxxxxxxx.isClientSide()) {
                     _levelxxxxxxxxxxx.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.sonic_boom")),
                        SoundSource.NEUTRAL,
                        0.3F,
                        0.5F
                     );
                  } else {
                     _levelxxxxxxxxxxx.playLocalSound(
                        x,
                        y,
                        z,
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.sonic_boom")),
                        SoundSource.NEUTRAL,
                        0.3F,
                        0.5F,
                        false
                     );
                  }
               }
            }

            entity.getPersistentData().putDouble("dramaticfall", 0.0);
         } else {
            entity.getPersistentData().putDouble("dramaticfall", entity.getPersistentData().getDouble("dramaticfall") + 1.0);
         }

         if (entity instanceof SpiderMothEntity _datEntL352
            && (Boolean)_datEntL352.getEntityData().get(SpiderMothEntity.DATA_growattack)
            && entity instanceof SpiderMothEntity animatablexx) {
            animatablexx.setTexture("redglow");
         }

         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), e -> true).isEmpty()
            && !entity.isShiftKeyDown()
            && !entity.isInWater()
            && (entity.getDeltaMovement().x() > 0.0 || entity.getDeltaMovement().y() > 0.0 || entity.getDeltaMovement().z() > 0.0)) {
            if (!(entity.getPersistentData().getDouble("wingsound") > 1.0)) {
               entity.getPersistentData().putDouble("wingsound", (double)Mth.nextInt(RandomSource.create(), 2, 8));
               if ((entity.getDeltaMovement().x() + entity.getDeltaMovement().y() + entity.getDeltaMovement().z()) / 3.0 < 0.6) {
                  if (world instanceof Level _levelxxxxxxxxxxxx) {
                     if (!_levelxxxxxxxxxxxx.isClientSide()) {
                        _levelxxxxxxxxxxxx.playSound(
                           null,
                           BlockPos.containing(x, y, z),
                           (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:flyingmoth1")),
                           SoundSource.HOSTILE,
                           (float)(
                              1.0
                                 + (Math.abs(entity.getDeltaMovement().x()) + Math.abs(entity.getDeltaMovement().y()) + Math.abs(entity.getDeltaMovement().z()))
                                    / 3.0
                           ),
                           (float)(
                              0.8
                                 + (Math.abs(entity.getDeltaMovement().x()) + Math.abs(entity.getDeltaMovement().y()) + Math.abs(entity.getDeltaMovement().z()))
                                    / 3.0
                           )
                        );
                     } else {
                        _levelxxxxxxxxxxxx.playLocalSound(
                           x,
                           y,
                           z,
                           (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:flyingmoth1")),
                           SoundSource.HOSTILE,
                           (float)(
                              1.0
                                 + (Math.abs(entity.getDeltaMovement().x()) + Math.abs(entity.getDeltaMovement().y()) + Math.abs(entity.getDeltaMovement().z()))
                                    / 3.0
                           ),
                           (float)(
                              0.8
                                 + (Math.abs(entity.getDeltaMovement().x()) + Math.abs(entity.getDeltaMovement().y()) + Math.abs(entity.getDeltaMovement().z()))
                                    / 3.0
                           ),
                           false
                        );
                     }
                  }
               } else if (world instanceof Level _levelxxxxxxxxxxxxx) {
                  if (!_levelxxxxxxxxxxxxx.isClientSide()) {
                     _levelxxxxxxxxxxxxx.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:flyingmoth2")),
                        SoundSource.HOSTILE,
                        0.7F,
                        (float)Mth.nextDouble(RandomSource.create(), 1.0, 1.3)
                     );
                  } else {
                     _levelxxxxxxxxxxxxx.playLocalSound(
                        x,
                        y,
                        z,
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:flyingmoth2")),
                        SoundSource.HOSTILE,
                        0.7F,
                        (float)Mth.nextDouble(RandomSource.create(), 1.0, 1.3),
                        false
                     );
                  }
               }
            } else {
               entity.getPersistentData().putDouble("wingsound", entity.getPersistentData().getDouble("wingsound") - 1.0);
            }
         }

         if (entity.onGround()) {
            if (!world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() + 1.0, entity.getZ()))) {
               if (entity instanceof LivingEntity _entityx && !_entityx.level().isClientSide()) {
                  _entityx.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 10, 1, false, false));
               }

               if (entity instanceof LivingEntity _entityx && !_entityx.level().isClientSide()) {
                  _entityx.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 0, false, false));
               }

               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxx) {
                  _levelxxxxxxxxxxxxxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 40, 0.1, 0.2, 0.1, 0.1);
               }

               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxx) {
                  _levelxxxxxxxxxxxxxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 20, 0.1, 0.2, 0.1, 0.1);
               }
            } else if (!world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() + 2.0, entity.getZ()))) {
               if (entity instanceof LivingEntity _entityx && !_entityx.level().isClientSide()) {
                  _entityx.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 10, 1, false, false));
               }

               if (entity instanceof LivingEntity _entityx && !_entityx.level().isClientSide()) {
                  _entityx.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 0, false, false));
               }

               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxx) {
                  _levelxxxxxxxxxxxxxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 40, 0.1, 0.2, 0.1, 0.1);
               }

               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxx) {
                  _levelxxxxxxxxxxxxxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 20, 0.1, 0.2, 0.1, 0.1);
               }
            }
         }

         label948: {
            if (entity instanceof LivingEntity _livEnt394 && _livEnt394.hasEffect((MobEffect)ArphexModMobEffects.FORCE_POWER.get())) {
               if (!world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ()))) {
                  ArphexMod.queueServerWork(
                     40,
                     () -> {
                        if (!world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ()))
                           && entity instanceof LivingEntity _entityx) {
                           _entityx.removeEffect((MobEffect)ArphexModMobEffects.FORCE_POWER.get());
                        }
                     }
                  );
               }

               entity.setNoGravity(true);
               break label948;
            }

            entity.setNoGravity(false);
         }

         label939:
         if ((!(entity instanceof LivingEntity _livEnt407) || !_livEnt407.hasEffect(MobEffects.DIG_SPEED))
            && entity.getPersistentData().getBoolean("spawnedawayfromplayer")) {
            if (entity instanceof LivingEntity _livEnt409 && _livEnt409.hasEffect((MobEffect)ArphexModMobEffects.DESPAWN_IMMUNITY.get())) {
               break label939;
            }

            if ((entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null) != null
               && (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null) instanceof Player
               && !(
                  ((ArphexModVariables.PlayerVariables)(entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null)
                           .getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new ArphexModVariables.PlayerVariables()))
                        .mothsurvivals
                     > 2.0
               )
               && (
                  !((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof Player _playerHasItem)
                     || !_playerHasItem.getInventory().contains(new ItemStack((ItemLike)ArphexModItems.BANE_OF_THE_DARKNESS.get()))
               )
               && (entity instanceof LivingEntity _livEntxx ? _livEntxx.getHealth() : -1.0F) > 290.0F
               && entity instanceof LivingEntity _entityx
               && !_entityx.level().isClientSide()) {
               _entityx.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 3, false, false));
            }

            ArphexMod.queueServerWork(
               2400,
               () -> {
                  if (!entity.getPersistentData().getBoolean("done_switch")
                     && (!(entity instanceof LivingEntity _livEnt420) || !_livEnt420.hasEffect(MobEffects.DIG_SPEED))
                     && entity.getPersistentData().getBoolean("spawnedawayfromplayer")
                     && (!(entity instanceof LivingEntity _livEnt422) || !_livEnt422.hasEffect((MobEffect)ArphexModMobEffects.DESPAWN_IMMUNITY.get()))
                     && !entity.getPersistentData().getBoolean("moth_has_been_attacked")
                     && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), e -> true).isEmpty()) {
                     if (!entity.getPersistentData().getBoolean("done_switch")) {
                        ArphexModVariables.MapVariables.get(world).last_despawn_reasons = "moth-switched-stalking";
                        ArphexModVariables.MapVariables.get(world).syncData(world);
                        if (world instanceof ServerLevel _levelxxxxxxxxxxxxxx) {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.PURE_STALKING.get())
                              .spawn(_levelxxxxxxxxxxxxxx, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawn != null) {
                           }
                        }

                        entity.getPersistentData().putBoolean("done_switch", true);
                     }

                     if (!entity.level().isClientSide()) {
                        entity.discard();
                     }
                  }
               }
            );
         }

         Vec3 motion = entity.getDeltaMovement();
         if (motion.x != 0.0 || motion.y != 0.0 || motion.z != 0.0) {
            boolean inCobweb = false;
            AABB box = entity.getBoundingBox();
            Level lvl = entity.level();
            double minX = box.minX;
            double minY = box.minY;
            double minZ = box.minZ;
            double maxX = box.maxX;
            double maxY = box.maxY;
            double maxZ = box.maxZ;

            for (int bx = (int)Math.floor(minX); bx <= (int)Math.floor(maxX); bx++) {
               for (int by = (int)Math.floor(minY); by <= (int)Math.floor(maxY); by++) {
                  for (int bz = (int)Math.floor(minZ); bz <= (int)Math.floor(maxZ); bz++) {
                     BlockState state = lvl.getBlockState(new BlockPos(bx, by, bz));
                     if (state.getBlock() == Blocks.COBWEB
                        && (double)(bx + 1) > minX
                        && (double)bx < maxX
                        && (double)(by + 1) > minY
                        && (double)by < maxY
                        && (double)(bz + 1) > minZ
                        && (double)bz < maxZ) {
                        inCobweb = true;
                        entity.makeStuckInBlock(state, new Vec3(2.0, 3.0, 2.0));
                        break;
                     }
                  }

                  if (inCobweb) {
                     break;
                  }
               }

               if (inCobweb) {
                  break;
               }
            }
         }
      }
   }
}
