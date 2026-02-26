package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class TormentorPrimaryTargetOnEffectActiveTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double randomnearx = 0.0;
         double randomneary = 0.0;
         double randomnearz = 0.0;
         double summonsdone = 0.0;
         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 5, 0.4, 0.4, 0.4, 0.2);
         }

         if (entity.getPersistentData().getBoolean("tormentor_target") && entity instanceof Player _player) {
            _player.getCooldowns().addCooldown((Item)ArphexModItems.PLACEHOLDER_PACK.get(), 3);
         }

         if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))
            && (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem()
               != ArphexModItems.IMMORTAL_HELMET.get()
            && !(
               ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                     .torment_intensity
                  > 120.0
            )) {
            double _setval = ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new ArphexModVariables.PlayerVariables()))
                  .torment_intensity
               + 2.0;
            entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
               capability.torment_intensity = _setval;
               capability.syncPlayerVariables(entity);
            });
         }

         if (!entity.getPersistentData().getBoolean("tormentor_target")
            && (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem()
               != ArphexModItems.IMMORTAL_HELMET.get()
            && (
               ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new ArphexModVariables.PlayerVariables()))
                        .torment_intensity
                     > 119.0
                  || entity.level().dimension() != Level.OVERWORLD
                     && entity.level().dimension() != Level.NETHER
                     && world.isEmptyBlock(BlockPos.containing(x, y + 2.0, z))
                     && world.isEmptyBlock(BlockPos.containing(x, y + 3.0, z))
                     && world.isEmptyBlock(BlockPos.containing(x, y + 4.0, z))
                     && world.isEmptyBlock(BlockPos.containing(x, y + 5.0, z))
            )
            && !(
               ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                     .tormentor_respite
                  > 5.0
            )) {
            if (!(
               ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                     .torment_cycle
                  > 0.0
            )) {
               if (entity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("§c§lIt can torment you when you're out in the open wearing armour..."), true);
               }

               entity.getPersistentData().putDouble("limitsummons", 0.0);
               double _setval = (double)Mth.nextInt(RandomSource.create(), 1000, 2000);
               entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                  capability.torment_cycle = _setval;
                  capability.syncPlayerVariables(entity);
               });
               if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
                  String _setvalx = "spider_rain";
                  entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.torment_mode = _setval;
                     capability.syncPlayerVariables(entity);
                  });
                  if (world instanceof ServerLevel _level) {
                     _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 50, 5.0, 5.0, 5.0, 0.1);
                  }
               } else if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
                  String _setvalx = "locust_rain";
                  entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.torment_mode = _setval;
                     capability.syncPlayerVariables(entity);
                  });
                  if (world instanceof ServerLevel _level) {
                     _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(), x, y, z, 50, 5.0, 5.0, 5.0, 0.1);
                  }
               } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
                  String _setvalx = "effects";
                  entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.torment_mode = _setval;
                     capability.syncPlayerVariables(entity);
                  });
                  if (world instanceof ServerLevel _level) {
                     _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.DEATH_SMOKE.get(), x, y, z, 10, 5.0, 5.0, 5.0, 0.1);
                  }
               } else {
                  String _setvalx = "enemies";
                  entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.torment_mode = _setval;
                     capability.syncPlayerVariables(entity);
                  });
                  if (world instanceof ServerLevel _level) {
                     _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_PURPLE_SMOKE.get(), x, y, z, 10, 5.0, 5.0, 5.0, 0.1);
                  }
               }
            } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) > 0) {
               double _setval = ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                     .torment_cycle
                  - 1.0;
               entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                  capability.torment_cycle = _setval;
                  capability.syncPlayerVariables(entity);
               });
               if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                     .torment_mode
                     .equals("effects")
                  && ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new ArphexModVariables.PlayerVariables()))
                        .torment_cycle
                     < (double)Mth.nextInt(RandomSource.create(), 1, 1000)) {
                  if (Mth.nextInt(RandomSource.create(), 1, 8) == 1) {
                     boolean _setvalx = true;
                     entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.show_tormentor_overlay = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                  } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
                     _setval = 400.0;
                     entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.shadertime = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                     if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                           _level.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:mothscream")),
                              SoundSource.HOSTILE,
                              0.4F,
                              0.4F
                           );
                        } else {
                           _level.playLocalSound(
                              x,
                              y,
                              z,
                              (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:mothscream")),
                              SoundSource.HOSTILE,
                              0.4F,
                              0.4F,
                              false
                           );
                        }
                     }

                     if ((
                           entity instanceof ServerPlayer _plr34
                                 && _plr34.level() instanceof ServerLevel
                                 && _plr34.getAdvancements()
                                    .getOrStartProgress(_plr34.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:scorpioid_killed")))
                                    .isDone()
                              || ArphexModVariables.MapVariables.get(world).tormentor_last_player_spawned
                        )
                        && (entity instanceof LivingEntity _livEntx ? _livEntx.getArmorValue() : 0) > 1
                        && Mth.nextInt(RandomSource.create(), 1, 20) == 1
                        && world instanceof ServerLevel _levelx) {
                        LightningBolt entityToSpawn = (LightningBolt)EntityType.LIGHTNING_BOLT.create(_levelx);
                        entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
                        _levelx.addFreshEntity(entityToSpawn);
                     }
                  } else {
                     if (world instanceof Level _levelx) {
                        if (!_levelx.isClientSide()) {
                           _levelx.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:mothscream2")),
                              SoundSource.HOSTILE,
                              0.4F,
                              0.4F
                           );
                        } else {
                           _levelx.playLocalSound(
                              x,
                              y,
                              z,
                              (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:mothscream2")),
                              SoundSource.HOSTILE,
                              0.4F,
                              0.4F,
                              false
                           );
                        }
                     }

                     if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 60, 1, false, false));
                     }

                     if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 60, 1, false, false));
                     }

                     if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.POISON, 200, 1, false, false));
                     }
                  }
               }

               if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new ArphexModVariables.PlayerVariables()))
                  .torment_mode
                  .equals("enemies")) {
                  _setval = 400.0;
                  entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.shader2 = _setval;
                     capability.syncPlayerVariables(entity);
                  });
                  if ((
                        entity instanceof ServerPlayer _plr42
                              && _plr42.level() instanceof ServerLevel
                              && _plr42.getAdvancements()
                                 .getOrStartProgress(_plr42.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:voidlasher_killed")))
                                 .isDone()
                           || ArphexModVariables.MapVariables.get(world).tormentor_last_player_spawned
                     )
                     && (entity instanceof LivingEntity _livEntx ? _livEntx.getArmorValue() : 0) > 1
                     && Mth.nextInt(RandomSource.create(), 1, 60) == 1) {
                     Vec3 _center = new Vec3(x, y, z);

                     for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50.0), e -> true)
                        .stream()
                        .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                        .toList()) {
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livEnt45 = (LivingEntity)entityiterator;
                           if (_livEnt45.getMobType() == MobType.ARTHROPOD) {
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityiterator;
                                 if (!_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 4));
                                 }
                              }

                              if (Mth.nextInt(RandomSource.create(), 1, 6) == 1 && entityiterator instanceof Mob) {
                                 Mob _entity = (Mob)entityiterator;
                                 if (entity instanceof LivingEntity _ent) {
                                    _entity.setTarget(_ent);
                                 }
                              }
                           }
                        }
                     }

                     for (int index0 = 0; index0 < 100; index0++) {
                        randomnearx = (double)Mth.nextInt(RandomSource.create(), -40, 40);
                        randomneary = (double)Mth.nextInt(RandomSource.create(), -40, 40);
                        randomnearz = (double)Mth.nextInt(RandomSource.create(), -40, 40);
                        if (world.isEmptyBlock(BlockPos.containing(x + randomnearx, y + randomneary, z + randomnearz))
                           && !world.isEmptyBlock(BlockPos.containing(x + randomnearx, y + randomneary - 1.0, z + randomnearz))) {
                           entity.getPersistentData().putDouble("limitsummons", entity.getPersistentData().getDouble("limitsummons") + 1.0);
                           if (!(entity.getPersistentData().getDouble("limitsummons") > 15.0)) {
                              if (Mth.nextInt(RandomSource.create(), 1, 70) == 1) {
                                 if (world instanceof ServerLevel) {
                                    ServerLevel _levelxx = (ServerLevel)world;
                                    Entity entityToSpawn = ((EntityType)ArphexModEntities.DRAGONFLY_DREADNOUGHT.get())
                                       .spawn(_levelxx, BlockPos.containing(x + randomnearx, y + randomneary, z + randomnearz), MobSpawnType.MOB_SUMMONED);
                                    if (entityToSpawn != null) {
                                       entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                    }
                                 }
                              } else if (Mth.nextInt(RandomSource.create(), 1, 1) == 1) {
                                 if (Mth.nextInt(RandomSource.create(), 1, 100) == 1) {
                                    if (world instanceof ServerLevel) {
                                       ServerLevel _levelxx = (ServerLevel)world;
                                       Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_PROWLER.get())
                                          .spawn(_levelxx, BlockPos.containing(x + randomnearx, y + randomneary, z + randomnearz), MobSpawnType.MOB_SUMMONED);
                                       if (entityToSpawn != null) {
                                          entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                       }
                                    }

                                    if (world instanceof ServerLevel _levelxx) {
                                       _levelxx.getServer()
                                          .getCommands()
                                          .performPrefixedCommand(
                                             new CommandSourceStack(
                                                   CommandSource.NULL,
                                                   new Vec3(x, y, z),
                                                   Vec2.ZERO,
                                                   _levelxx,
                                                   4,
                                                   "",
                                                   Component.literal(""),
                                                   _levelxx.getServer(),
                                                   null
                                                )
                                                .withSuppressedOutput(),
                                             "summon zoniex:tormented_steve"
                                          );
                                    }
                                 } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
                                    if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
                                       if (world instanceof ServerLevel) {
                                          ServerLevel _levelxx = (ServerLevel)world;
                                          Entity entityToSpawn = ((EntityType)ArphexModEntities.RANDOM_TERMITE.get())
                                             .spawn(_levelxx, BlockPos.containing(x + randomnearx, y + randomneary, z + randomnearz), MobSpawnType.MOB_SUMMONED);
                                          if (entityToSpawn != null) {
                                             entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                          }
                                       }
                                    } else if (world instanceof ServerLevel) {
                                       ServerLevel _levelxx = (ServerLevel)world;
                                       Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPION_STRIKER.get())
                                          .spawn(_levelxx, BlockPos.containing(x + randomnearx, y + randomneary, z + randomnearz), MobSpawnType.MOB_SUMMONED);
                                       if (entityToSpawn != null) {
                                          entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                       }
                                    }
                                 } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
                                    if (world instanceof ServerLevel) {
                                       ServerLevel _levelxx = (ServerLevel)world;
                                       Entity entityToSpawn = ((EntityType)ArphexModEntities.CENTIPEDE_STALKER.get())
                                          .spawn(_levelxx, BlockPos.containing(x + randomnearx, y + randomneary, z + randomnearz), MobSpawnType.MOB_SUMMONED);
                                       if (entityToSpawn != null) {
                                          entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                       }
                                    }

                                    if (world instanceof ServerLevel) {
                                       ServerLevel _levelxx = (ServerLevel)world;
                                       Entity entityToSpawn = ((EntityType)ArphexModEntities.CENTIPEDE_EVICTOR_LARVAE.get())
                                          .spawn(_levelxx, BlockPos.containing(x + randomnearx, y + randomneary, z + randomnearz), MobSpawnType.MOB_SUMMONED);
                                       if (entityToSpawn != null) {
                                          entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                       }
                                    }
                                 } else if (world instanceof ServerLevel) {
                                    ServerLevel _levelxx = (ServerLevel)world;
                                    Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_FUNNEL.get())
                                       .spawn(_levelxx, BlockPos.containing(x + randomnearx, y + randomneary, z + randomnearz), MobSpawnType.MOB_SUMMONED);
                                    if (entityToSpawn != null) {
                                       entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                    }
                                 }
                              } else {
                                 for (int index1 = 0; index1 < Mth.nextInt(RandomSource.create(), 1, 2); index1++) {
                                    if (world instanceof ServerLevel _levelxx) {
                                       Entity entityToSpawn = ((EntityType)ArphexModEntities.HORNET_HARBINGER_GIANT.get())
                                          .spawn(_levelxx, BlockPos.containing(x + randomnearx, y + randomneary, z + randomnearz), MobSpawnType.MOB_SUMMONED);
                                       if (entityToSpawn != null) {
                                          entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                       }
                                    }

                                    if (world instanceof ServerLevel _levelxxx) {
                                       Entity entityToSpawn = ((EntityType)ArphexModEntities.MOSQUITO_MORBIDITY.get())
                                          .spawn(_levelxxx, BlockPos.containing(x + randomnearx, y + randomneary, z + randomnearz), MobSpawnType.MOB_SUMMONED);
                                       if (entityToSpawn != null) {
                                          entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                       }
                                    }

                                    if (world instanceof ServerLevel _levelxxxx) {
                                       Entity entityToSpawn = ((EntityType)ArphexModEntities.LONG_LEGS_FLY.get())
                                          .spawn(_levelxxxx, BlockPos.containing(x + randomnearx, y + randomneary, z + randomnearz), MobSpawnType.MOB_SUMMONED);
                                       if (entityToSpawn != null) {
                                          entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }

               if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                     .torment_mode
                     .equals("spider_rain")
                  && (
                     entity instanceof ServerPlayer _plr76
                           && _plr76.level() instanceof ServerLevel
                           && _plr76.getAdvancements()
                              .getOrStartProgress(_plr76.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:moth_kill")))
                              .isDone()
                        || ArphexModVariables.MapVariables.get(world).tormentor_last_player_spawned
                  )
                  && (entity instanceof LivingEntity _livEntx ? _livEntx.getArmorValue() : 0) > 1
                  && ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new ArphexModVariables.PlayerVariables()))
                        .torment_cycle
                     < (double)Mth.nextInt(RandomSource.create(), 1, 1000)) {
                  randomnearx = (double)Mth.nextInt(RandomSource.create(), -40, 40);
                  randomneary = (double)Mth.nextInt(RandomSource.create(), 30, 60);
                  randomnearz = (double)Mth.nextInt(RandomSource.create(), -40, 40);
                  if (world.isEmptyBlock(BlockPos.containing(x + randomnearx, y + randomneary, z + randomnearz))) {
                     if (!(++summonsdone > 12.0) && !(entity.getPersistentData().getDouble("limitsummons") > 100.0)) {
                        if (Mth.nextInt(RandomSource.create(), 1, 10) == 1) {
                           if (world instanceof ServerLevel _levelxxxxx) {
                              Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_BROOD.get())
                                 .spawn(_levelxxxxx, BlockPos.containing(x + randomnearx, y + randomneary, z + randomnearz), MobSpawnType.MOB_SUMMONED);
                              if (entityToSpawn != null) {
                                 entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                              }
                           }

                           entity.getPersistentData().putDouble("limitsummons", entity.getPersistentData().getDouble("limitsummons") + 1.0);
                        } else if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
                           if (world instanceof ServerLevel _levelxxxxxx) {
                              Entity entityToSpawn = ((EntityType)ArphexModEntities.LONG_LEGS.get())
                                 .spawn(_levelxxxxxx, BlockPos.containing(x + randomnearx, y + randomneary, z + randomnearz), MobSpawnType.MOB_SUMMONED);
                              if (entityToSpawn != null) {
                                 entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                              }
                           }

                           entity.getPersistentData().putDouble("limitsummons", entity.getPersistentData().getDouble("limitsummons") + 1.0);
                        } else {
                           if (world instanceof ServerLevel _levelxxxxxxx) {
                              Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE.get())
                                 .spawn(_levelxxxxxxx, BlockPos.containing(x + randomnearx, y + randomneary, z + randomnearz), MobSpawnType.MOB_SUMMONED);
                              if (entityToSpawn != null) {
                                 entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                              }
                           }

                           entity.getPersistentData().putDouble("limitsummons", entity.getPersistentData().getDouble("limitsummons") + 1.0);
                        }
                     }
                  }
               }

               if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                     .torment_mode
                     .equals("locust_rain")
                  && ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new ArphexModVariables.PlayerVariables()))
                        .torment_cycle
                     > (double)Mth.nextInt(RandomSource.create(), 1, 1000)) {
                  randomnearx = (double)Mth.nextInt(RandomSource.create(), -40, 40);
                  randomneary = (double)Mth.nextInt(RandomSource.create(), 30, 60);
                  randomnearz = (double)Mth.nextInt(RandomSource.create(), -40, 40);
                  if (world.isEmptyBlock(BlockPos.containing(x + randomnearx, y + randomneary, z + randomnearz))) {
                     if (!(++summonsdone > 12.0)) {
                        entity.getPersistentData().putDouble("limitsummons", entity.getPersistentData().getDouble("limitsummons") + 1.0);
                        if (!(entity.getPersistentData().getDouble("limitsummons") > 100.0) && world instanceof ServerLevel _levelxxxxxxxx) {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.LOCUST_LANDSCOURGE.get())
                              .spawn(_levelxxxxxxxx, BlockPos.containing(x + randomnearx, y + randomneary, z + randomnearz), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }
}
