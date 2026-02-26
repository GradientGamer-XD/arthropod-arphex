package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class CrawlingPortalEntityCollidesInTheBlockProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean followedpresent = false;
         String dimension = "";
         if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.END_STONE) {
            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_PURPLE_SMOKE.get(), x, y, z, 5, 0.4, 0.4, 0.4, 0.2);
            }
         } else if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.NETHERRACK) {
            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(), x, y, z, 5, 0.4, 0.4, 0.4, 0.2);
            }
         } else if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.STONE && world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_WHITE_SMOKES.get(), x, y, z, 5, 0.4, 0.4, 0.4, 0.2);
         }

         if (entity instanceof Player) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 5, 0, false, false));
            }

            double _setval = ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new ArphexModVariables.PlayerVariables()))
                  .time_in_portal
               + 1.0;
            entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
               capability.time_in_portal = _setval;
               capability.syncPlayerVariables(entity);
            });
         }

         if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new ArphexModVariables.PlayerVariables()))
                  .time_in_portal
               > 80.0
            || !(entity instanceof Player)) {
            if (entity.level().dimension() == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))) {
               if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.NETHERRACK) {
                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get(), 60, 1, false, false));
                  }

                  dimension = "the_nether";
               } else if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.END_STONE) {
                  dimension = "the_end";
               } else {
                  dimension = "overworld";
               }

               if ((Boolean)ConfigurationSettingsConfiguration.END_ACCESS_CRAWLING.get() || !dimension.equals("the_end")) {
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
                           "tp " + Mth.nextInt(RandomSource.create(), -100, 100) + " 230 " + Mth.nextInt(RandomSource.create(), -100, 100)
                        );
                  }

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
                           "execute in minecraft:" + dimension + " run tp ~ ~ ~"
                        );
                  }

                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 200, 0, false, false));
                  }
               } else if (entity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("End exit gateways have been disabled in config!"), true);
               }
            } else if (entity instanceof ItemEntity) {
               if ((entity instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == ArphexModItems.BANE_OF_THE_DARKNESS.get()
                  && ArphexModVariables.MapVariables.get(world).tormentor_health > 0.0) {
                  followedpresent = false;
                  Vec3 _center = new Vec3(x, y, z);

                  for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30.0), e -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                     .toList()) {
                     if (entityiterator instanceof Player
                        && ArphexModVariables.MapVariables.get(world).tormentor_target_follow.equals(entityiterator.getStringUUID())) {
                        followedpresent = true;
                     }
                  }

                  if (followedpresent) {
                     ArphexModVariables.MapVariables.get(world).tormentor_health = 0.0;
                     ArphexModVariables.MapVariables.get(world).syncData(world);
                     if (!entity.level().isClientSide()) {
                        entity.discard();
                     }

                     if (world instanceof ServerLevel _level) {
                        _level.getServer()
                           .getCommands()
                           .performPrefixedCommand(
                              new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                 )
                                 .withSuppressedOutput(),
                              "execute at @e[type=arphex:tormentor,limit=1] run particle arphex:white_glow_smoke ~ ~ ~ 20 20 20 0 1000 force"
                           );
                     }

                     if (world instanceof ServerLevel _level) {
                        _level.getServer()
                           .getCommands()
                           .performPrefixedCommand(
                              new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                 )
                                 .withSuppressedOutput(),
                              "effect give @e[type=arphex:tormentor] glowing"
                           );
                     }

                     if (world instanceof ServerLevel _level) {
                        _level.getServer()
                           .getCommands()
                           .performPrefixedCommand(
                              new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                 )
                                 .withSuppressedOutput(),
                              "kill @e[type=arphex:tormentor]"
                           );
                     }

                     if (world instanceof ServerLevel _level) {
                        _level.getServer()
                           .getCommands()
                           .performPrefixedCommand(
                              new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                 )
                                 .withSuppressedOutput(),
                              "tellraw @a {\"text\":\"THE TORMENTOR HAS BEEN BANISHED, BUT NOT DESTROYED\",\"bold\":true,\"color\":\"red\"}"
                           );
                     }

                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HUGE_FIRE.get(), x, y, z, 30, 1.0, 1.0, 1.0, 0.5);
                     }

                     ArphexMod.queueServerWork(
                        20,
                        () -> {
                           if (world instanceof ServerLevel _level) {
                              _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HUGE_FIRE.get(), x, y, z, 30, 1.0, 1.0, 1.0, 0.5);
                           }

                           ArphexMod.queueServerWork(
                              20,
                              () -> {
                                 if (world instanceof ServerLevel _levelx) {
                                    _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.HUGE_FIRE.get(), x, y, z, 30, 1.0, 1.0, 1.0, 0.5);
                                 }

                                 ArphexMod.queueServerWork(
                                    20,
                                    () -> {
                                       if (world instanceof ServerLevel _levelxx) {
                                          _levelxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.HUGE_FIRE.get(), x, y, z, 30, 1.0, 1.0, 1.0, 0.5);
                                       }

                                       ArphexMod.queueServerWork(
                                          20,
                                          () -> {
                                             if (world instanceof ServerLevel _levelxxx) {
                                                _levelxxx.sendParticles(
                                                   (SimpleParticleType)ArphexModParticleTypes.HUGE_FIRE.get(), x, y, z, 30, 1.0, 1.0, 1.0, 0.5
                                                );
                                             }

                                             ArphexMod.queueServerWork(
                                                20,
                                                () -> {
                                                   if (world instanceof ServerLevel _levelxxxx) {
                                                      _levelxxxx.sendParticles(
                                                         (SimpleParticleType)ArphexModParticleTypes.HUGE_FIRE.get(), x, y, z, 30, 1.0, 1.0, 1.0, 0.5
                                                      );
                                                   }

                                                   ArphexMod.queueServerWork(
                                                      20,
                                                      () -> {
                                                         if (world instanceof ServerLevel _levelxxxxx) {
                                                            _levelxxxxx.sendParticles(
                                                               (SimpleParticleType)ArphexModParticleTypes.HUGE_FIRE.get(), x, y, z, 30, 1.0, 1.0, 1.0, 0.5
                                                            );
                                                         }

                                                         ArphexMod.queueServerWork(
                                                            20,
                                                            () -> {
                                                               if (world instanceof ServerLevel _levelxxxxxx) {
                                                                  _levelxxxxxx.sendParticles(
                                                                     (SimpleParticleType)ArphexModParticleTypes.HUGE_FIRE.get(),
                                                                     x,
                                                                     y,
                                                                     z,
                                                                     30,
                                                                     1.0,
                                                                     1.0,
                                                                     1.0,
                                                                     0.5
                                                                  );
                                                               }

                                                               ArphexMod.queueServerWork(
                                                                  20,
                                                                  () -> {
                                                                     if (world instanceof ServerLevel _levelxxxxxxx) {
                                                                        _levelxxxxxxx.sendParticles(
                                                                           (SimpleParticleType)ArphexModParticleTypes.HUGE_FIRE.get(),
                                                                           x,
                                                                           y,
                                                                           z,
                                                                           30,
                                                                           1.0,
                                                                           1.0,
                                                                           1.0,
                                                                           0.5
                                                                        );
                                                                     }

                                                                     ArphexMod.queueServerWork(
                                                                        20,
                                                                        () -> {
                                                                           if (world instanceof ServerLevel _levelxxxxxxxx) {
                                                                              _levelxxxxxxxx.sendParticles(
                                                                                 (SimpleParticleType)ArphexModParticleTypes.HUGE_FIRE.get(),
                                                                                 x,
                                                                                 y,
                                                                                 z,
                                                                                 30,
                                                                                 1.0,
                                                                                 1.0,
                                                                                 1.0,
                                                                                 0.5
                                                                              );
                                                                           }

                                                                           ArphexMod.queueServerWork(
                                                                              20,
                                                                              () -> {
                                                                                 if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                                                                                    _levelxxxxxxxxxx.sendParticles(
                                                                                       (SimpleParticleType)ArphexModParticleTypes.TORMENTOR_SMOKE.get(),
                                                                                       x,
                                                                                       y,
                                                                                       z,
                                                                                       30,
                                                                                       1.0,
                                                                                       1.0,
                                                                                       1.0,
                                                                                       0.5
                                                                                    );
                                                                                 }

                                                                                 if (world instanceof ServerLevel _levelxxxxxxxxx) {
                                                                                    LightningBolt entityToSpawn = (LightningBolt)EntityType.LIGHTNING_BOLT
                                                                                       .create(_levelxxxxxxxxx);
                                                                                    entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
                                                                                    entityToSpawn.setVisualOnly(true);
                                                                                    _levelxxxxxxxxx.addFreshEntity(entityToSpawn);
                                                                                 }
                                                                              }
                                                                           );
                                                                        }
                                                                     );
                                                                  }
                                                               );
                                                            }
                                                         );
                                                      }
                                                   );
                                                }
                                             );
                                          }
                                       );
                                    }
                                 );
                              }
                           );
                        }
                     );
                  } else {
                     _center = new Vec3(x, y, z);

                     for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30.0), e -> true)
                        .stream()
                        .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                        .toList()) {
                        if (entityiteratorx instanceof Player && entityiteratorx instanceof Player) {
                           Player _player = (Player)entityiteratorx;
                           if (!_player.level().isClientSide()) {
                              _player.displayClientMessage(
                                 Component.literal(
                                    "Tormentor banishment unsuccessful. The primary targeted player must be present. Killing a player removes their primary target."
                                 ),
                                 true
                              );
                           }
                        }
                     }
                  }
               } else {
                  if ((entity instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == ArphexModItems.BANE_OF_THE_DARKNESS.get()) {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.SOLID_SMOKE.get(), x, y, z, 5, 0.3, 0.3, 0.3, 0.3);
                     }

                     Vec3 _center = new Vec3(x, y, z);

                     for (Entity entityiteratorxx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30.0), e -> true)
                        .stream()
                        .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                        .toList()) {
                        if (entityiteratorxx instanceof Player && entityiteratorxx instanceof Player) {
                           Player _player = (Player)entityiteratorxx;
                           if (!_player.level().isClientSide()) {
                              _player.displayClientMessage(Component.literal("The Tormentor is not awake, you cannot banish it currently."), true);
                           }
                        }
                     }
                  }

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
                           "execute in arphex:the_crawling run tp 0 231 0"
                        );
                  }

                  ArphexMod.queueServerWork(
                     20,
                     () -> {
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
                                 "execute in arphex:the_crawling run tp 0 231 0"
                              );
                        }
                     }
                  );
               }
            } else {
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
                        "execute in arphex:the_crawling run tp 0 231 0"
                     );
               }

               ArphexMod.queueServerWork(
                  20,
                  () -> {
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
                              "execute in arphex:the_crawling run tp 0 231 0"
                           );
                     }
                  }
               );
               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 4, false, true));
               }
            }
         }
      }
   }
}
