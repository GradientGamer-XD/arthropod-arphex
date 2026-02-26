package net.arphex.procedures;

import java.text.DecimalFormat;
import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.ArachnoidTimeCloneEntity;
import net.arphex.entity.ArachnoidTrisectorEntity;
import net.arphex.entity.AscendantArrowEntity;
import net.arphex.entity.BloodProjectileEntity;
import net.arphex.entity.ChronoShotEntity;
import net.arphex.entity.SpacetimeAnchorEntity;
import net.arphex.entity.WebbedArrowEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("all")
public class ArachnoidTrisectorOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String order_random = "";
         String checked_pos = "";
         Entity attack_target = null;
         Entity nearestplayer250 = null;
         Entity nearestplayer80 = null;
         double particle_number = 0.0;
         double yy = 0.0;
         double expand = 0.0;
         double radius_at_height = 0.0;
         double lineZ = 0.0;
         double lineY = 0.0;
         double lineX = 0.0;
         double angle = 0.0;
         double radius = 0.0;
         double step_size = 0.0;
         double step_count = 0.0;
         double num_iterate = 0.0;
         double lock_steps = 0.0;
         double position_to_check = 0.0;
         double distance = 0.0;
         double randomxside = 0.0;
         double sx = 0.0;
         double sy = 0.0;
         double randomzside = 0.0;
         double sz = 0.0;
         double yhalf = 0.0;
         boolean one = false;
         boolean two = false;
         boolean three = false;
         boolean four = false;
         boolean five = false;
         boolean found = false;
         boolean valid_hitbox_tp_half = false;
         if (entity.isAlive()) {
            if (entity instanceof LivingEntity _entity) {
               _entity.removeEffect(MobEffects.LEVITATION);
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.removeEffect(MobEffects.WEAKNESS);
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.removeEffect((MobEffect)ArphexModMobEffects.NECROSIS.get());
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.removeEffect((MobEffect)ArphexModMobEffects.TIME_FREEZE.get());
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.removeEffect((MobEffect)ArphexModMobEffects.PARALYSIS.get());
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.removeEffect((MobEffect)ArphexModMobEffects.REPULSION.get());
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.removeEffect((MobEffect)ArphexModMobEffects.SUPERGRAVITY.get());
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.removeEffect((MobEffect)ArphexModMobEffects.WEBBED.get());
            }

            if ((!(entity instanceof LivingEntity _livEnt10) || !_livEnt10.hasEffect(MobEffects.REGENERATION))
               && entity instanceof LivingEntity _entity
               && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 0, false, false));
            }

            if ((Boolean)ConfigurationSettingsConfiguration.DWELLER_HEALTH.get()
               && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) > 60.0F
               && entity instanceof LivingEntity _entity) {
               _entity.setHealth(60.0F);
            }

            if (!(Boolean)ConfigurationSettingsConfiguration.DWELLERS_INCLUSION.get()) {
               ArphexModVariables.MapVariables.get(world).last_despawn_reasons = "arachnoid-bosses-disabled";
               ArphexModVariables.MapVariables.get(world).syncData(world);
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            }

            if (entity instanceof ArachnoidTrisectorEntity _datEntL17
               && (Boolean)_datEntL17.getEntityData().get(ArachnoidTrisectorEntity.DATA_primed)
               && entity.getPersistentData().getBoolean("chrono_effects")) {
               if ((entity instanceof ArachnoidTrisectorEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(ArachnoidTrisectorEntity.DATA_float_time) : 0)
                     > 40
                  && (entity instanceof ArachnoidTrisectorEntity _datEntI ? (Integer)_datEntI.getEntityData().get(ArachnoidTrisectorEntity.DATA_float_time) : 0)
                        % 4
                     == 0) {
                  Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());

                  for (Entity entityiterator : world.getEntitiesOfClass(
                        Entity.class, new AABB(_center, _center).inflate((24.0 + entity.getPersistentData().getDouble("float_expand") * 2.0) / 2.0), e -> true
                     )
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                     .toList()) {
                     if (!(entityiterator instanceof ArachnoidTrisectorEntity)
                        && Math.sqrt(
                              (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                                 + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                                 + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                           )
                           < 12.0 + entity.getPersistentData().getDouble("float_expand")) {
                         int var285 = 0;
                         if (entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect((MobEffect)ArphexModMobEffects.TIME_FREEZE.get())) {
                             var285 = _livEnt.getEffect((MobEffect)ArphexModMobEffects.TIME_FREEZE.get()).getAmplifier();
                         }

                         if (var285 < 20 && entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                             int var10005 = 0;
                             if (entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect((MobEffect)ArphexModMobEffects.TIME_FREEZE.get())) {
                                 var10005 = _livEnt.getEffect((MobEffect)ArphexModMobEffects.TIME_FREEZE.get()).getAmplifier();
                             }

                             _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.TIME_FREEZE.get(), 60, var10005 + 1, false, false));
                         }
                     }
                  }
               }

               if ((entity instanceof ArachnoidTrisectorEntity _datEntI ? (Integer)_datEntI.getEntityData().get(ArachnoidTrisectorEntity.DATA_float_time) : 0)
                  > 0) {
                  if ((
                        entity instanceof ArachnoidTrisectorEntity _datEntIx
                           ? (Integer)_datEntIx.getEntityData().get(ArachnoidTrisectorEntity.DATA_float_time)
                           : 0
                     )
                     > 180) {
                     if ((
                           entity instanceof ArachnoidTrisectorEntity _datEntIxx
                              ? (Integer)_datEntIxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_float_time)
                              : 0
                        )
                        > 240) {
                        entity.getPersistentData().putDouble("float_expand", entity.getPersistentData().getDouble("float_expand") - 1.0);
                     } else {
                        entity.getPersistentData().putDouble("float_expand", entity.getPersistentData().getDouble("float_expand") + 1.0);
                     }
                  } else {
                     entity.getPersistentData().putDouble("float_expand", 0.0);
                  }

                  radius = 15.0 + entity.getPersistentData().getDouble("float_expand");
               }

               particle_number = 500.0;
               if ((entity instanceof ArachnoidTrisectorEntity _datEntI ? (Integer)_datEntI.getEntityData().get(ArachnoidTrisectorEntity.DATA_float_time) : 0)
                  > 180) {
                  particle_number = 1000.0;
               }

               step_size = 2.0 * radius / particle_number;
               yy = 0.0 - radius;
               if (!(entity.getPersistentData().getDouble("angle_increment") >= 0.0)) {
                  entity.getPersistentData().putDouble("angle_increment", 0.0);
               } else {
                  entity.getPersistentData().putDouble("angle_increment", entity.getPersistentData().getDouble("angle_increment") + 0.5);
               }

               if (entity.getPersistentData().getDouble("cannon_cycle") > 0.0) {
                  entity.getPersistentData().putDouble("cannon_cycle", entity.getPersistentData().getDouble("cannon_cycle") - 1.0);
               } else {
                  for (int index0 = 0; index0 < (int)particle_number; index0++) {
                     if (yy < 15.0) {
                        yy += step_size;
                        radius_at_height = Math.sqrt(radius * radius - yy * yy);
                        angle = yy * entity.getPersistentData().getDouble("angle_increment");
                        if (world instanceof ServerLevel _level) {
                           _level.getServer()
                              .getCommands()
                              .performPrefixedCommand(
                                 new CommandSourceStack(
                                       CommandSource.NULL,
                                       new Vec3(
                                          entity.getX() + radius_at_height * Math.cos(angle),
                                          entity.getY() + yy + 2.0,
                                          entity.getZ() + radius_at_height * Math.sin(angle)
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
                                 "particle arphex:time_aura_particle ~ ~ ~ 0 0 0 0 1 force"
                              );
                        }

                        if (world instanceof ServerLevel _level) {
                           _level.getServer()
                              .getCommands()
                              .performPrefixedCommand(
                                 new CommandSourceStack(
                                       CommandSource.NULL,
                                       new Vec3(
                                          entity.getX() + radius_at_height * Math.cos(angle),
                                          entity.getY() + yy + 2.0,
                                          entity.getZ() + radius_at_height * Math.sin(angle)
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
                                 "particle arphex:heavy_green_smoke ~ ~ ~ 0 0 0 0 1 force"
                              );
                        }
                     }
                  }

                  entity.getPersistentData().putDouble("cannon_cycle", 4.0);
               }
            }

            Entity var78 = entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null;
            nearestplayer250 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 250.0, 250.0, 250.0), e -> true)
               .stream()
               .sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z))
               .findFirst()
               .orElse(null);
            if (var78 == null) {
               if (nearestplayer250 != null
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
                           .checkGamemode(nearestplayer250)
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
                           .checkGamemode(nearestplayer250)
                  )
                  && entity instanceof Mob _entity
                  && nearestplayer250 instanceof LivingEntity _ent) {
                  _entity.setTarget(_ent);
               }
            } else {
               if (entity instanceof ArachnoidTrisectorEntity _datEntSetI) {
                  _datEntSetI.getEntityData()
                     .set(
                        ArachnoidTrisectorEntity.DATA_store_target_distance,
                        (int)Math.sqrt(
                           (entity.getX() - var78.getX()) * (entity.getX() - var78.getX())
                              + (entity.getY() - var78.getY()) * (entity.getY() - var78.getY())
                              + (entity.getZ() - var78.getZ()) * (entity.getZ() - var78.getZ())
                        )
                     );
               }

               if (Math.round(
                        entity instanceof ArachnoidTrisectorEntity _datEntIxxx
                           ? (float)((Integer)_datEntIxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_current_final)).intValue()
                           : 0.0F
                     )
                     != 4
                  && (
                        entity instanceof ArachnoidTrisectorEntity _datEntIxx
                           ? (Integer)_datEntIxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_store_target_distance)
                           : 0
                     )
                     < 8
                  && (
                        entity instanceof ArachnoidTrisectorEntity _datEntI
                           ? (Integer)_datEntI.getEntityData().get(ArachnoidTrisectorEntity.DATA_store_target_distance)
                           : 0
                     )
                     > 0
                  && (
                     (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
                           != ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))
                        || !(entity.getY() > 245.0)
                  )) {
                  entity.setDeltaMovement(
                     new Vec3(
                        Math.max(
                           -20.0,
                           Math.min(
                              20.0,
                              (entity.getX() - var78.getX())
                                 / (double)(
                                    entity instanceof ArachnoidTrisectorEntity _datEntIxxxxx
                                       ? (Integer)_datEntIxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_store_target_distance)
                                       : 0
                                 )
                                 * 0.3
                           )
                        ),
                        entity.getDeltaMovement().y(),
                        Math.max(
                           -20.0,
                           Math.min(
                              20.0,
                              (entity.getZ() - var78.getZ())
                                 / (double)(
                                    entity instanceof ArachnoidTrisectorEntity _datEntIxxxx
                                       ? (Integer)_datEntIxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_store_target_distance)
                                       : 0
                                 )
                                 * 0.3
                           )
                        )
                     )
                  );
               }
            }

            entity.getPersistentData().putBoolean("disable_rotation", false);
            if (entity instanceof ArachnoidTrisectorEntity _datEntL106 && (Boolean)_datEntL106.getEntityData().get(ArachnoidTrisectorEntity.DATA_primed)) {
               if (Math.round(
                     entity instanceof ArachnoidTrisectorEntity _datEntI
                        ? (float)((Integer)_datEntI.getEntityData().get(ArachnoidTrisectorEntity.DATA_current_final)).intValue()
                        : 0.0F
                  )
                  == 1) {
                  if ((
                        entity instanceof ArachnoidTrisectorEntity _datEntIxx
                           ? (Integer)_datEntIxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_lunge_time)
                           : 0
                     )
                     <= 0) {
                     if (var78 != null) {
                        if ((
                              (
                                       entity instanceof ArachnoidTrisectorEntity _datEntIxxxx
                                          ? (Integer)_datEntIxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_store_target_distance)
                                          : 0
                                    )
                                    > 20
                                 || (
                                       entity instanceof ArachnoidTrisectorEntity _datEntIxxx
                                          ? (Integer)_datEntIxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_time_since_landing_attack)
                                          : 0
                                    )
                                    > 398
                           )
                           && entity instanceof ArachnoidTrisectorEntity) {
                           ((ArachnoidTrisectorEntity)entity).setAnimation("animation.arachnoid_trisector.charging");
                        }

                        if (entity instanceof ArachnoidTrisectorEntity _datEntSetI) {
                           _datEntSetI.getEntityData().set(ArachnoidTrisectorEntity.DATA_lunge_time, 600);
                        }
                     }

                     if (entity.getPersistentData().getBoolean("noai_reset")) {
                        entity.getPersistentData().putBoolean("noai_reset", false);
                     }
                  } else {
                     if ((
                              entity instanceof ArachnoidTrisectorEntity _datEntIxxx
                                 ? (Integer)_datEntIxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_store_target_distance)
                                 : 0
                           )
                           <= 20
                        && (
                              entity instanceof ArachnoidTrisectorEntity _datEntIxx
                                 ? (Integer)_datEntIxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_time_since_landing_attack)
                                 : 0
                           )
                           <= 398) {
                        if (entity.getPersistentData().getBoolean("noai_reset")) {
                           entity.getPersistentData().putBoolean("noai_reset", false);
                        }
                     } else {
                        if ((
                                 entity instanceof ArachnoidTrisectorEntity _datEntIxxxx
                                    ? (Integer)_datEntIxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_lunge_time)
                                    : 0
                              )
                              == 599
                           && var78 != null) {
                           if (entity instanceof ArachnoidTrisectorEntity _datEntSetI) {
                              _datEntSetI.getEntityData()
                                 .set(
                                    ArachnoidTrisectorEntity.DATA_store_target_distance,
                                    (int)Math.sqrt(
                                       (entity.getX() - var78.getX()) * (entity.getX() - var78.getX())
                                          + (entity.getY() - var78.getY()) * (entity.getY() - var78.getY())
                                          + (entity.getZ() - var78.getZ()) * (entity.getZ() - var78.getZ())
                                    )
                                 );
                           }

                           if (0.5
                                 * (double)(
                                    entity instanceof ArachnoidTrisectorEntity _datEntIxxxxx
                                       ? (Integer)_datEntIxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_store_target_distance)
                                       : 0
                                 )
                              != 0.0) {
                              entity.getPersistentData()
                                 .putDouble(
                                    "store_target_x",
                                    (var78.getX() - entity.getX())
                                       / (
                                          0.3
                                             * (double)(
                                                entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxx
                                                   ? (Integer)_datEntIxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_store_target_distance)
                                                   : 0
                                             )
                                       )
                                 );
                              entity.getPersistentData()
                                 .putDouble(
                                    "store_target_y",
                                    (var78.getY() + 0.5 - entity.getY())
                                       / (
                                          0.3
                                             * (double)(
                                                entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxxx
                                                   ? (Integer)_datEntIxxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_store_target_distance)
                                                   : 0
                                             )
                                       )
                                 );
                              entity.getPersistentData()
                                 .putDouble(
                                    "store_target_z",
                                    (var78.getZ() - entity.getZ())
                                       / (
                                          0.3
                                             * (double)(
                                                entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxxxx
                                                   ? (Integer)_datEntIxxxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_store_target_distance)
                                                   : 0
                                             )
                                       )
                                 );
                              entity.getPersistentData().putDouble("store_own_x", entity.getX());
                              entity.getPersistentData().putDouble("store_own_y", entity.getY());
                              entity.getPersistentData().putDouble("store_own_z", entity.getZ());
                              entity.getPersistentData().putBoolean("allow_one_reversal", true);
                              entity.getPersistentData().putBoolean("locked_reverse", false);
                              entity.getPersistentData().putBoolean("reverse_low", false);
                           }
                        }

                        if ((entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)
                              < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 2.0F
                           && (
                                 entity instanceof ArachnoidTrisectorEntity _datEntIxxxx
                                    ? (Integer)_datEntIxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_lunge_time)
                                    : 0
                              )
                              == 390
                           && entity instanceof ArachnoidTrisectorEntity _datEntSetI) {
                           _datEntSetI.getEntityData().set(ArachnoidTrisectorEntity.DATA_lunge_time, 10);
                        }

                        if ((
                              entity instanceof ArachnoidTrisectorEntity _datEntIxxxx
                                 ? (Integer)_datEntIxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_lunge_time)
                                 : 0
                           )
                           > 540) {
                           if ((
                                 entity instanceof ArachnoidTrisectorEntity _datEntIxxxxx
                                    ? (Integer)_datEntIxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_lunge_time)
                                    : 0
                              )
                              < 580) {
                              if (entity.getPersistentData().getDouble("store_target_x") != 0.0
                                 && entity.getPersistentData().getDouble("store_target_z") != 0.0) {
                                 entity.setDeltaMovement(
                                    new Vec3(
                                       Math.max(-20.0, Math.min(20.0, entity.getPersistentData().getDouble("store_target_x"))),
                                       entity.getDeltaMovement().y(),
                                       Math.max(-20.0, Math.min(20.0, entity.getPersistentData().getDouble("store_target_z")))
                                    )
                                 );
                                 if (var78 != null) {
                                    if ((
                                          entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxx
                                             ? (Integer)_datEntIxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_lunge_time)
                                             : 0
                                       )
                                       == 560) {
                                       entity.getPersistentData()
                                          .putDouble(
                                             "store_target_x",
                                             (var78.getX() - entity.getX())
                                                / (
                                                   0.3
                                                      * (double)(
                                                         entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxxx
                                                            ? (Integer)_datEntIxxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_store_target_distance)
                                                            : 0
                                                      )
                                                )
                                          );
                                       entity.getPersistentData()
                                          .putDouble(
                                             "store_target_z",
                                             (var78.getZ() - entity.getZ())
                                                / (
                                                   0.3
                                                      * (double)(
                                                         entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxxxx
                                                            ? (Integer)_datEntIxxxxxxxx.getEntityData()
                                                               .get(ArachnoidTrisectorEntity.DATA_store_target_distance)
                                                            : 0
                                                      )
                                                )
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
                                             "/particle minecraft:sweep_attack ^ ^2 ^6 0.8 0.8 0.8 0 4 force @a"
                                          );
                                    }

                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                                       _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get(), 10, 0, false, false));
                                    }

                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                                       _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 1, false, false));
                                    }

                                    if ((Boolean)ConfigurationSettingsConfiguration.ARPHEX_GRIEFING.get()
                                       && world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)
                                       && (
                                                entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxx
                                                   ? (Integer)_datEntIxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_lunge_time)
                                                   : 0
                                             )
                                             % 7
                                          == 0
                                       && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) > 50.0F) {
                                       if (world instanceof Level _level && !_level.isClientSide()) {
                                          _level.explode(null, entity.getX(), entity.getY() + 2.0, entity.getZ(), 7.0F, ExplosionInteraction.MOB);
                                       }

                                       ArphexMod.queueServerWork(
                                          1, () -> entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), -0.1, entity.getDeltaMovement().z()))
                                       );
                                    }
                                 }
                              }

                              entity.getPersistentData().putBoolean("noai_reset", true);
                           } else if (entity.getPersistentData().getBoolean("noai_reset")) {
                              entity.getPersistentData().putBoolean("noai_reset", false);
                           }

                           if (0.6
                                    * (double)(
                                       entity instanceof ArachnoidTrisectorEntity _datEntIxxxxx
                                          ? (Integer)_datEntIxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_store_target_distance)
                                          : 0
                                    )
                                 != 0.0
                              && entity instanceof LivingEntity _entity
                              && !_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 5, 1, false, false));
                           }
                        } else if (entity.getPersistentData().getBoolean("noai_reset")) {
                           entity.getPersistentData().putBoolean("noai_reset", false);
                        }
                     }

                     if (entity instanceof ArachnoidTrisectorEntity _datEntSetI) {
                        _datEntSetI.getEntityData()
                           .set(
                              ArachnoidTrisectorEntity.DATA_lunge_time,
                              (
                                    entity instanceof ArachnoidTrisectorEntity _datEntIxxxx
                                       ? (Integer)_datEntIxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_lunge_time)
                                       : 0
                                 )
                                 - 1
                           );
                     }
                  }
               } else if (Math.round(
                     entity instanceof ArachnoidTrisectorEntity _datEntIxxxx
                        ? (float)((Integer)_datEntIxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_current_final)).intValue()
                        : 0.0F
                  )
                  == 2) {
                  if (entity instanceof ArachnoidTrisectorEntity _datEntSetI) {
                     _datEntSetI.getEntityData()
                        .set(
                           ArachnoidTrisectorEntity.DATA_float_time,
                           (
                                 entity instanceof ArachnoidTrisectorEntity _datEntIxxxxx
                                    ? (Integer)_datEntIxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_float_time)
                                    : 0
                              )
                              + 1
                        );
                  }

                  if ((
                        entity instanceof ArachnoidTrisectorEntity _datEntIxxxxx
                           ? (Integer)_datEntIxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_flash)
                           : 0
                     )
                     <= 0) {
                     if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get(), 20, 0, false, false));
                     }

                     if ((entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)
                           < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 2.0F
                        && (
                              entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxx
                                 ? (Integer)_datEntIxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_float_time)
                                 : 0
                           )
                           > 40
                        && var78 != null) {
                        if (world instanceof ServerLevel projectileLevel) {
                           Projectile _entityToSpawn = (new Object() {
                                 public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                    AbstractArrow entityToSpawn = new ChronoShotEntity(
                                       (EntityType<? extends ChronoShotEntity>)ArphexModEntities.CHRONO_SHOT.get(), level
                                    );
                                    entityToSpawn.setOwner(shooter);
                                    entityToSpawn.setBaseDamage((double)damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                 }
                              })
                              .getArrow(projectileLevel, entity, 5.0F, 1);
                           _entityToSpawn.setPos(entity.getX(), entity.getY() + 3.4, entity.getZ());
                           _entityToSpawn.shoot(0.0, 0.0, 0.0, 1.0F, 0.0F);
                           projectileLevel.addFreshEntity(_entityToSpawn);
                        }

                        if (world instanceof ServerLevel projectileLevel) {
                           Projectile _entityToSpawn = (new Object() {
                                 public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                    AbstractArrow entityToSpawn = new ChronoShotEntity(
                                       (EntityType<? extends ChronoShotEntity>)ArphexModEntities.CHRONO_SHOT.get(), level
                                    );
                                    entityToSpawn.setOwner(shooter);
                                    entityToSpawn.setBaseDamage((double)damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                 }
                              })
                              .getArrow(projectileLevel, entity, 5.0F, 1);
                           _entityToSpawn.setPos(entity.getX(), entity.getY() + 3.4, entity.getZ());
                           _entityToSpawn.shoot(-0.3, 0.3, 0.0, 1.0F, 0.0F);
                           projectileLevel.addFreshEntity(_entityToSpawn);
                        }

                        if (world instanceof ServerLevel projectileLevel) {
                           Projectile _entityToSpawn = (new Object() {
                                 public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                    AbstractArrow entityToSpawn = new ChronoShotEntity(
                                       (EntityType<? extends ChronoShotEntity>)ArphexModEntities.CHRONO_SHOT.get(), level
                                    );
                                    entityToSpawn.setOwner(shooter);
                                    entityToSpawn.setBaseDamage((double)damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                 }
                              })
                              .getArrow(projectileLevel, entity, 5.0F, 1);
                           _entityToSpawn.setPos(entity.getX(), entity.getY() + 3.4, entity.getZ());
                           _entityToSpawn.shoot(0.3, 0.3, 0.0, 1.0F, 0.0F);
                           projectileLevel.addFreshEntity(_entityToSpawn);
                        }

                        if (world instanceof ServerLevel projectileLevel) {
                           Projectile _entityToSpawn = (new Object() {
                                 public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                    AbstractArrow entityToSpawn = new ChronoShotEntity(
                                       (EntityType<? extends ChronoShotEntity>)ArphexModEntities.CHRONO_SHOT.get(), level
                                    );
                                    entityToSpawn.setOwner(shooter);
                                    entityToSpawn.setBaseDamage((double)damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                 }
                              })
                              .getArrow(projectileLevel, entity, 5.0F, 1);
                           _entityToSpawn.setPos(entity.getX(), entity.getY() + 3.4, entity.getZ());
                           _entityToSpawn.shoot(0.0, 0.3, 0.3, 1.0F, 0.0F);
                           projectileLevel.addFreshEntity(_entityToSpawn);
                        }

                        if (world instanceof ServerLevel projectileLevel) {
                           Projectile _entityToSpawn = (new Object() {
                                 public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                    AbstractArrow entityToSpawn = new ChronoShotEntity(
                                       (EntityType<? extends ChronoShotEntity>)ArphexModEntities.CHRONO_SHOT.get(), level
                                    );
                                    entityToSpawn.setOwner(shooter);
                                    entityToSpawn.setBaseDamage((double)damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                 }
                              })
                              .getArrow(projectileLevel, entity, 5.0F, 1);
                           _entityToSpawn.setPos(entity.getX(), entity.getY() + 3.4, entity.getZ());
                           _entityToSpawn.shoot(0.0, 0.3, -0.3, 1.0F, 0.0F);
                           projectileLevel.addFreshEntity(_entityToSpawn);
                        }
                     }

                     if (entity instanceof ArachnoidTrisectorEntity _datEntSetI) {
                        _datEntSetI.getEntityData().set(ArachnoidTrisectorEntity.DATA_flash, 10);
                     }
                  } else {
                     if (entity instanceof ArachnoidTrisectorEntity _datEntSetI) {
                        _datEntSetI.getEntityData()
                           .set(
                              ArachnoidTrisectorEntity.DATA_flash,
                              (
                                    entity instanceof ArachnoidTrisectorEntity _datEntIxxxxx
                                       ? (Integer)_datEntIxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_flash)
                                       : 0
                                 )
                                 - 1
                           );
                     }

                     if ((
                           entity instanceof ArachnoidTrisectorEntity _datEntIxxxxx
                              ? (Integer)_datEntIxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_flash)
                              : 0
                        )
                        > 6) {
                        if (entity instanceof ArachnoidTrisectorEntity spider) {
                           spider.getPersistentData().putString("glowTexture", "arachnoid_trisector_fullpower");
                        }
                     } else if (entity instanceof ArachnoidTrisectorEntity spider) {
                        spider.getPersistentData().putString("glowTexture", "trisector_glow");
                     }
                  }

                  if (var78 == null) {
                     entity.noPhysics = false;
                     entity.getPersistentData().putBoolean("chrono_effects", false);
                     if (entity instanceof ArachnoidTrisectorEntity animatable) {
                        animatable.setTexture("arachnoid_trisector");
                     }
                  } else {
                     if ((
                           entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxx
                              ? (Integer)_datEntIxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_float_time)
                              : 0
                        )
                        < 40) {
                        entity.setDeltaMovement(new Vec3(0.0, 1.5, 0.0));
                     }

                     if (entity instanceof ArachnoidTrisectorEntity animatable) {
                        animatable.setTexture("arachnoid_trisector_power");
                     }

                     entity.getPersistentData().putBoolean("chrono_effects", true);
                     entity.setOnGround(false);
                     entity.noPhysics = true;
                     if ((
                           entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxx
                              ? (Integer)_datEntIxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_store_target_distance)
                              : 0
                        )
                        > 8) {
                        entity.setDeltaMovement(
                           new Vec3(
                              Math.max(
                                 -20.0,
                                 Math.min(
                                    20.0,
                                    (var78.getX() - entity.getX())
                                       / (double)(
                                          entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxxxxx
                                             ? (Integer)_datEntIxxxxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_store_target_distance)
                                             : 0
                                       )
                                       * 0.3
                                 )
                              ),
                              Math.max(
                                 -20.0,
                                 Math.min(
                                    20.0,
                                    (var78.getY() + 11.0 - entity.getY())
                                       / (double)(
                                          entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxxxx
                                             ? (Integer)_datEntIxxxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_store_target_distance)
                                             : 0
                                       )
                                       * 0.3
                                 )
                              ),
                              Math.max(
                                 -20.0,
                                 Math.min(
                                    20.0,
                                    (var78.getZ() - entity.getZ())
                                       / (double)(
                                          entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxxx
                                             ? (Integer)_datEntIxxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_store_target_distance)
                                             : 0
                                       )
                                       * 0.3
                                 )
                              )
                           )
                        );
                     }
                  }
               } else if (Math.round(
                     entity instanceof ArachnoidTrisectorEntity _datEntIxxxx
                        ? (float)((Integer)_datEntIxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_current_final)).intValue()
                        : 0.0F
                  )
                  == 3) {
                  if (var78 == null) {
                     entity.setShiftKeyDown(false);
                  } else {
                     entity.setShiftKeyDown(true);
                     if ((
                           entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxx
                              ? (Integer)_datEntIxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_flash)
                              : 0
                        )
                        <= 0) {
                        if (entity instanceof ArachnoidTrisectorEntity _datEntSetI) {
                           _datEntSetI.getEntityData().set(ArachnoidTrisectorEntity.DATA_flash, 20);
                        }

                        if ((
                                 entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxxx
                                    ? (Integer)_datEntIxxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_attack_switch_time)
                                    : 0
                              )
                              > 80
                           && entity instanceof ArachnoidTrisectorEntity) {
                           ((ArachnoidTrisectorEntity)entity).setAnimation("animation.arachnoid_trisector.ranged_attack");
                        }

                        if (world instanceof ServerLevel projectileLevel) {
                           Projectile _entityToSpawn = (new Object() {
                                 public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                    AbstractArrow entityToSpawn = new ChronoShotEntity(
                                       (EntityType<? extends ChronoShotEntity>)ArphexModEntities.CHRONO_SHOT.get(), level
                                    );
                                    entityToSpawn.setOwner(shooter);
                                    entityToSpawn.setBaseDamage((double)damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                 }
                              })
                              .getArrow(projectileLevel, entity, 5.0F, 1);
                           _entityToSpawn.setPos(entity.getX(), entity.getY() + 3.4, entity.getZ());
                           _entityToSpawn.shoot(0.0, 0.0, 0.0, 1.0F, 0.0F);
                           projectileLevel.addFreshEntity(_entityToSpawn);
                        }

                        if (world instanceof ServerLevel projectileLevel) {
                           Projectile _entityToSpawn = (new Object() {
                                 public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                    AbstractArrow entityToSpawn = new ChronoShotEntity(
                                       (EntityType<? extends ChronoShotEntity>)ArphexModEntities.CHRONO_SHOT.get(), level
                                    );
                                    entityToSpawn.setOwner(shooter);
                                    entityToSpawn.setBaseDamage((double)damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                 }
                              })
                              .getArrow(projectileLevel, entity, 5.0F, 1);
                           _entityToSpawn.setPos(entity.getX(), entity.getY() + 3.4, entity.getZ());
                           _entityToSpawn.shoot(-0.3, 0.3, 0.0, 1.0F, 0.0F);
                           projectileLevel.addFreshEntity(_entityToSpawn);
                        }

                        if (world instanceof ServerLevel projectileLevel) {
                           Projectile _entityToSpawn = (new Object() {
                                 public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                    AbstractArrow entityToSpawn = new ChronoShotEntity(
                                       (EntityType<? extends ChronoShotEntity>)ArphexModEntities.CHRONO_SHOT.get(), level
                                    );
                                    entityToSpawn.setOwner(shooter);
                                    entityToSpawn.setBaseDamage((double)damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                 }
                              })
                              .getArrow(projectileLevel, entity, 5.0F, 1);
                           _entityToSpawn.setPos(entity.getX(), entity.getY() + 3.4, entity.getZ());
                           _entityToSpawn.shoot(0.3, 0.3, 0.0, 1.0F, 0.0F);
                           projectileLevel.addFreshEntity(_entityToSpawn);
                        }

                        if (world instanceof ServerLevel projectileLevel) {
                           Projectile _entityToSpawn = (new Object() {
                                 public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                    AbstractArrow entityToSpawn = new ChronoShotEntity(
                                       (EntityType<? extends ChronoShotEntity>)ArphexModEntities.CHRONO_SHOT.get(), level
                                    );
                                    entityToSpawn.setOwner(shooter);
                                    entityToSpawn.setBaseDamage((double)damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                 }
                              })
                              .getArrow(projectileLevel, entity, 5.0F, 1);
                           _entityToSpawn.setPos(entity.getX(), entity.getY() + 3.4, entity.getZ());
                           _entityToSpawn.shoot(0.0, 0.3, 0.3, 1.0F, 0.0F);
                           projectileLevel.addFreshEntity(_entityToSpawn);
                        }

                        if (world instanceof ServerLevel projectileLevel) {
                           Projectile _entityToSpawn = (new Object() {
                                 public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                    AbstractArrow entityToSpawn = new ChronoShotEntity(
                                       (EntityType<? extends ChronoShotEntity>)ArphexModEntities.CHRONO_SHOT.get(), level
                                    );
                                    entityToSpawn.setOwner(shooter);
                                    entityToSpawn.setBaseDamage((double)damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                 }
                              })
                              .getArrow(projectileLevel, entity, 5.0F, 1);
                           _entityToSpawn.setPos(entity.getX(), entity.getY() + 3.4, entity.getZ());
                           _entityToSpawn.shoot(0.0, 0.3, -0.3, 1.0F, 0.0F);
                           projectileLevel.addFreshEntity(_entityToSpawn);
                        }
                     } else {
                        if (entity instanceof ArachnoidTrisectorEntity _datEntSetI) {
                           _datEntSetI.getEntityData()
                              .set(
                                 ArachnoidTrisectorEntity.DATA_flash,
                                 (
                                       entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxx
                                          ? (Integer)_datEntIxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_flash)
                                          : 0
                                    )
                                    - 1
                              );
                        }

                        if ((
                              entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxx
                                 ? (Integer)_datEntIxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_flash)
                                 : 0
                           )
                           > 6) {
                           if (entity instanceof ArachnoidTrisectorEntity spider) {
                              spider.getPersistentData().putString("glowTexture", "arachnoid_trisector_fullpower");
                           }
                        } else if (entity instanceof ArachnoidTrisectorEntity spider) {
                           spider.getPersistentData().putString("glowTexture", "trisector_glow");
                        }
                     }
                  }
               } else if (Math.round(
                     entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxxx
                        ? (float)((Integer)_datEntIxxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_current_final)).intValue()
                        : 0.0F
                  )
                  == 4) {
                  entity.setDeltaMovement(new Vec3(0.0, entity.getDeltaMovement().y(), 0.0));
                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 999, false, false));
                  }

                  if ((
                        entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxxxx
                           ? (Integer)_datEntIxxxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_flash)
                           : 0
                     )
                     <= 0) {
                     if (var78 != null
                        && (
                              entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxxxxx
                                 ? (Integer)_datEntIxxxxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_attack_switch_time)
                                 : 0
                           )
                           > 100) {
                        if ((
                              entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxxxxxx
                                 ? (Integer)_datEntIxxxxxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_attack_switch_time)
                                 : 0
                           )
                           > 259) {
                           if (entity instanceof ArachnoidTrisectorEntity) {
                              ((ArachnoidTrisectorEntity)entity).setAnimation("animation.arachnoid_trisector.forcefield");
                           }
                        } else if (entity instanceof ArachnoidTrisectorEntity) {
                           ((ArachnoidTrisectorEntity)entity).setAnimation("animation.arachnoid_trisector.forcefield_loop");
                        }

                        ArphexMod.queueServerWork(
                           60,
                           () -> {
                              Level projectileLevelx = entity.level();
                              if (!projectileLevelx.isClientSide()) {
                                 Projectile _entityToSpawnx = (new Object() {
                                       public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                          AbstractArrow entityToSpawn = new SpacetimeAnchorEntity(
                                             (EntityType<? extends SpacetimeAnchorEntity>)ArphexModEntities.SPACETIME_ANCHOR.get(), level
                                          );
                                          entityToSpawn.setOwner(shooter);
                                          entityToSpawn.setBaseDamage((double)damage);
                                          entityToSpawn.setKnockback(knockback);
                                          entityToSpawn.setSilent(true);
                                          return entityToSpawn;
                                       }
                                    })
                                    .getArrow(projectileLevelx, entity, 5.0F, 1);
                                 _entityToSpawnx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                 _entityToSpawnx.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 1.0F, 0.0F);
                                 projectileLevelx.addFreshEntity(_entityToSpawnx);
                              }

                              ArphexMod.queueServerWork(
                                 5,
                                 () -> {
                                    Level projectileLevelxx = entity.level();
                                    if (!projectileLevelxx.isClientSide()) {
                                       Projectile _entityToSpawnxx = (new Object() {
                                             public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                AbstractArrow entityToSpawn = new SpacetimeAnchorEntity(
                                                   (EntityType<? extends SpacetimeAnchorEntity>)ArphexModEntities.SPACETIME_ANCHOR.get(), level
                                                );
                                                entityToSpawn.setOwner(shooter);
                                                entityToSpawn.setBaseDamage((double)damage);
                                                entityToSpawn.setKnockback(knockback);
                                                entityToSpawn.setSilent(true);
                                                return entityToSpawn;
                                             }
                                          })
                                          .getArrow(projectileLevelxx, entity, 5.0F, 1);
                                       _entityToSpawnxx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                       _entityToSpawnxx.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 1.0F, 0.0F);
                                       projectileLevelxx.addFreshEntity(_entityToSpawnxx);
                                    }

                                    ArphexMod.queueServerWork(
                                       5,
                                       () -> {
                                          Level projectileLevelxxx = entity.level();
                                          if (!projectileLevelxxx.isClientSide()) {
                                             Projectile _entityToSpawnxxx = (new Object() {
                                                   public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                      AbstractArrow entityToSpawn = new SpacetimeAnchorEntity(
                                                         (EntityType<? extends SpacetimeAnchorEntity>)ArphexModEntities.SPACETIME_ANCHOR.get(), level
                                                      );
                                                      entityToSpawn.setOwner(shooter);
                                                      entityToSpawn.setBaseDamage((double)damage);
                                                      entityToSpawn.setKnockback(knockback);
                                                      entityToSpawn.setSilent(true);
                                                      return entityToSpawn;
                                                   }
                                                })
                                                .getArrow(projectileLevelxxx, entity, 5.0F, 1);
                                             _entityToSpawnxxx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                             _entityToSpawnxxx.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 1.0F, 0.0F);
                                             projectileLevelxxx.addFreshEntity(_entityToSpawnxxx);
                                          }

                                          if ((entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)
                                             < (entity instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F) / 2.0F) {
                                             ArphexMod.queueServerWork(
                                                5,
                                                () -> {
                                                   Level projectileLevelxxxx = entity.level();
                                                   if (!projectileLevelxxxx.isClientSide()) {
                                                      Projectile _entityToSpawnxxxx = (new Object() {
                                                            public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                               AbstractArrow entityToSpawn = new SpacetimeAnchorEntity(
                                                                  (EntityType<? extends SpacetimeAnchorEntity>)ArphexModEntities.SPACETIME_ANCHOR.get(), level
                                                               );
                                                               entityToSpawn.setOwner(shooter);
                                                               entityToSpawn.setBaseDamage((double)damage);
                                                               entityToSpawn.setKnockback(knockback);
                                                               entityToSpawn.setSilent(true);
                                                               return entityToSpawn;
                                                            }
                                                         })
                                                         .getArrow(projectileLevelxxxx, entity, 5.0F, 1);
                                                      _entityToSpawnxxxx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                                      _entityToSpawnxxxx.shoot(
                                                         entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 1.0F, 0.0F
                                                      );
                                                      projectileLevelxxxx.addFreshEntity(_entityToSpawnxxxx);
                                                   }

                                                   ArphexMod.queueServerWork(
                                                      5,
                                                      () -> {
                                                         Level projectileLevelxxxxx = entity.level();
                                                         if (!projectileLevelxxxxx.isClientSide()) {
                                                            Projectile _entityToSpawnxxxxx = (new Object() {
                                                                  public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                                     AbstractArrow entityToSpawn = new SpacetimeAnchorEntity(
                                                                        (EntityType<? extends SpacetimeAnchorEntity>)ArphexModEntities.SPACETIME_ANCHOR.get(),
                                                                        level
                                                                     );
                                                                     entityToSpawn.setOwner(shooter);
                                                                     entityToSpawn.setBaseDamage((double)damage);
                                                                     entityToSpawn.setKnockback(knockback);
                                                                     entityToSpawn.setSilent(true);
                                                                     return entityToSpawn;
                                                                  }
                                                               })
                                                               .getArrow(projectileLevelxxxxx, entity, 5.0F, 1);
                                                            _entityToSpawnxxxxx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                                            _entityToSpawnxxxxx.shoot(
                                                               entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 1.0F, 0.0F
                                                            );
                                                            projectileLevelxxxxx.addFreshEntity(_entityToSpawnxxxxx);
                                                         }

                                                         ArphexMod.queueServerWork(
                                                            5,
                                                            () -> {
                                                               Level projectileLevelxxxxxx = entity.level();
                                                               if (!projectileLevelxxxxxx.isClientSide()) {
                                                                  Projectile _entityToSpawnxxxxxx = (new Object() {
                                                                        public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                                           AbstractArrow entityToSpawn = new SpacetimeAnchorEntity(
                                                                              (EntityType<? extends SpacetimeAnchorEntity>)ArphexModEntities.SPACETIME_ANCHOR
                                                                                 .get(),
                                                                              level
                                                                           );
                                                                           entityToSpawn.setOwner(shooter);
                                                                           entityToSpawn.setBaseDamage((double)damage);
                                                                           entityToSpawn.setKnockback(knockback);
                                                                           entityToSpawn.setSilent(true);
                                                                           return entityToSpawn;
                                                                        }
                                                                     })
                                                                     .getArrow(projectileLevelxxxxxx, entity, 5.0F, 1);
                                                                  _entityToSpawnxxxxxx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                                                  _entityToSpawnxxxxxx.shoot(
                                                                     entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 1.0F, 0.0F
                                                                  );
                                                                  projectileLevelxxxxxx.addFreshEntity(_entityToSpawnxxxxxx);
                                                               }
                                                            }
                                                         );
                                                      }
                                                   );
                                                }
                                             );
                                          }
                                       }
                                    );
                                 }
                              );
                           }
                        );
                        if (entity instanceof ArachnoidTrisectorEntity _datEntSetI) {
                           _datEntSetI.getEntityData().set(ArachnoidTrisectorEntity.DATA_flash, 60);
                        }
                     }
                  } else if (entity instanceof ArachnoidTrisectorEntity _datEntSetI) {
                     _datEntSetI.getEntityData()
                        .set(
                           ArachnoidTrisectorEntity.DATA_flash,
                           (
                                 entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxxxxx
                                    ? (Integer)_datEntIxxxxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_flash)
                                    : 0
                              )
                              - 1
                        );
                  }
               } else if (var78 != null) {
                  if ((
                        entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxxx
                           ? (Integer)_datEntIxxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_flash)
                           : 0
                     )
                     <= 0) {
                     if (entity.onGround()
                        && world.getEntitiesOfClass(ArachnoidTimeCloneEntity.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), e -> true).isEmpty()) {
                        if (world instanceof ServerLevel _level) {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.ARACHNOID_TIME_CLONE.get())
                              .spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawn != null) {
                              entityToSpawn.setYRot(entity.getYRot());
                              entityToSpawn.setYBodyRot(entity.getYRot());
                              entityToSpawn.setYHeadRot(entity.getYRot());
                           }
                        }

                        if (entity instanceof ArachnoidTrisectorEntity _datEntSetI) {
                           _datEntSetI.getEntityData().set(ArachnoidTrisectorEntity.DATA_flash, 200);
                        }
                     }
                  } else if (entity instanceof ArachnoidTrisectorEntity _datEntSetI) {
                     _datEntSetI.getEntityData()
                        .set(
                           ArachnoidTrisectorEntity.DATA_flash,
                           (
                                 entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxxxxx
                                    ? (Integer)_datEntIxxxxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_flash)
                                    : 0
                              )
                              - 1
                        );
                  }
               }

               if (Math.round(
                        entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxxxxx
                           ? (float)((Integer)_datEntIxxxxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_current_final)).intValue()
                           : 0.0F
                     )
                     != 1
                  && entity instanceof ArachnoidTrisectorEntity _datEntSetI) {
                  _datEntSetI.getEntityData().set(ArachnoidTrisectorEntity.DATA_lunge_time, 0);
               }
            }

            if ((
                  Math.round(
                           entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxxxxxxx
                              ? (float)((Integer)_datEntIxxxxxxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_current_final)).intValue()
                              : 0.0F
                        )
                        != 4
                     || (
                           entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxxxxx
                              ? (Integer)_datEntIxxxxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_attack_switch_time)
                              : 0
                        )
                        < 50
               )
               && ((ArachnoidTrisectorEntity)entity).animationprocedure.equals("animation.arachnoid_trisector.forcefield_loop")
               && entity instanceof ArachnoidTrisectorEntity) {
               ((ArachnoidTrisectorEntity)entity).setAnimation("empty");
            }

            if (Math.round(
                  entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxxxxx
                     ? (float)((Integer)_datEntIxxxxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_current_final)).intValue()
                     : 0.0F
               )
               != 2) {
               if (entity instanceof ArachnoidTrisectorEntity _datEntSetI) {
                  _datEntSetI.getEntityData().set(ArachnoidTrisectorEntity.DATA_float_time, 0);
               }

               entity.getPersistentData().putBoolean("chrono_effects", false);
               if (entity instanceof ArachnoidTrisectorEntity spider) {
                  spider.getPersistentData().putString("glowTexture", "trisector_glow");
               }

               if (entity instanceof ArachnoidTrisectorEntity animatable) {
                  animatable.setTexture("arachnoid_trisector");
               }

               if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != Blocks.VOID_AIR && !entity.isInWall()) {
                  entity.noPhysics = false;
               } else {
                  entity.setDeltaMovement(new Vec3(0.0, 0.5, 0.0));
                  entity.noPhysics = true;
               }
            }

            if (Math.round(
                  entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxxxxx
                     ? (float)((Integer)_datEntIxxxxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_current_final)).intValue()
                     : 0.0F
               )
               != 3) {
               entity.setShiftKeyDown(false);
            }

            if ((
                     entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxxxxx
                        ? (Integer)_datEntIxxxxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_time_since_landing_attack)
                        : 0
                  )
                  < 400
               && entity instanceof ArachnoidTrisectorEntity _datEntSetI) {
               _datEntSetI.getEntityData()
                  .set(
                     ArachnoidTrisectorEntity.DATA_time_since_landing_attack,
                     (
                           entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxxxxxxx
                              ? (Integer)_datEntIxxxxxxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_time_since_landing_attack)
                              : 0
                        )
                        + 1
                  );
            }

            if ((entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)
                  < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 2.0F
               && (
                     entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxxxxxxx
                        ? (Integer)_datEntIxxxxxxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_lunge_time)
                        : 0
                  )
                  < 300
               && (
                     entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxxxxx
                        ? (Integer)_datEntIxxxxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_lunge_time)
                        : 0
                  )
                  > 3
               && entity instanceof ArachnoidTrisectorEntity _datEntSetI) {
               _datEntSetI.getEntityData().set(ArachnoidTrisectorEntity.DATA_lunge_time, 1);
            }

            if (entity.getPersistentData().getDouble("health_loss_limit") - 10.0
               > (double)(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F)) {
               if ((entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F) > 0.0F && entity instanceof LivingEntity _entity) {
                  _entity.setHealth((float)(entity.getPersistentData().getDouble("health_loss_limit") - 10.0));
               }

               entity.getPersistentData().putDouble("health_loss_limit", entity.getPersistentData().getDouble("health_loss_limit") - 10.0);
            } else {
               entity.getPersistentData().putDouble("health_loss_limit", entity instanceof LivingEntity _livEnt ? (double)_livEnt.getHealth() : -1.0);
            }

            if (!world.isClientSide()) {
               if ((
                     entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxxxxx
                        ? (Integer)_datEntIxxxxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_attack_switch_time)
                        : 0
                  )
                  > 0) {
                  if (entity instanceof ArachnoidTrisectorEntity _datEntSetI) {
                     _datEntSetI.getEntityData()
                        .set(
                           ArachnoidTrisectorEntity.DATA_attack_switch_time,
                           (
                                 entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxxxxxxx
                                    ? (Integer)_datEntIxxxxxxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_attack_switch_time)
                                    : 0
                              )
                              - 1
                        );
                  }
               } else {
                  if (entity instanceof ArachnoidTrisectorEntity _datEntSetI) {
                     _datEntSetI.getEntityData().set(ArachnoidTrisectorEntity.DATA_attack_switch_time, 300);
                  }

                  if ((
                        entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxxxxxxx
                           ? (Integer)_datEntIxxxxxxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_shuffle_number)
                           : 0
                     )
                     <= 1) {
                     if (entity instanceof ArachnoidTrisectorEntity _datEntSetI) {
                        _datEntSetI.getEntityData().set(ArachnoidTrisectorEntity.DATA_shuffle_number, 5);
                     }

                     order_random = "";
                     step_count = entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxxxxxxxx
                        ? (double)((Integer)_datEntIxxxxxxxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_shuffle_number)).intValue()
                        : 0.0;

                     for (int index1 = 0; index1 < 100; index1++) {
                        num_iterate = (double)Math.round((float)Mth.nextInt(RandomSource.create(), 1, (int)step_count));
                        if (!((double)order_random.length() < step_count)) {
                           break;
                        }

                        if (!order_random.contains(new DecimalFormat("##.##").format(Math.round(num_iterate)).strip())) {
                           order_random = order_random + Math.round(num_iterate);
                        }
                     }

                     if (entity instanceof ArachnoidTrisectorEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(ArachnoidTrisectorEntity.DATA_shuffle, order_random);
                     }
                  } else if (entity instanceof ArachnoidTrisectorEntity _datEntSetI) {
                     _datEntSetI.getEntityData()
                        .set(
                           ArachnoidTrisectorEntity.DATA_shuffle_number,
                           (
                                 entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxxxxxxx
                                    ? (Integer)_datEntIxxxxxxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_shuffle_number)
                                    : 0
                              )
                              - 1
                        );
                  }

                  if (entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxxxxxxx) {
                     double var353 = (double)((Integer)_datEntIxxxxxxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_shuffle_number)).intValue();
                  } else {
                     double var354 = 0.0;
                  }

                  if (entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxxxxxxx) {
                     double var355 = (double)((Integer)_datEntIxxxxxxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_shuffle_number)).intValue();
                  } else {
                     double var356 = 0.0;
                  }

                  position_to_check = entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxxxxxxx
                     ? (double)((Integer)_datEntIxxxxxxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_shuffle_number)).intValue()
                     : 0.0;
                  order_random = entity instanceof ArachnoidTrisectorEntity _datEntS
                     ? (String)_datEntS.getEntityData().get(ArachnoidTrisectorEntity.DATA_shuffle)
                     : "";
                  step_count = 5.0;
                  lock_steps = position_to_check;

                  for (int index2 = 0; index2 < (int)lock_steps; index2++) {
                     if (!(--step_count > 0.0)) {
                        checked_pos = order_random;
                        break;
                     }

                     checked_pos = new DecimalFormat("##.##").format(Math.floor((new Object() {
                        double convert(String s) {
                           try {
                              return Double.parseDouble(s.trim());
                           } catch (Exception var3) {
                              return 0.0;
                           }
                        }
                     }).convert(order_random) / Math.pow(10.0, step_count))).strip();
                     order_random = order_random.replace(new DecimalFormat("##.##").format(Math.floor((new Object() {
                        double convert(String s) {
                           try {
                              return Double.parseDouble(s.trim());
                           } catch (Exception var3) {
                              return 0.0;
                           }
                        }
                     }).convert(order_random) / Math.pow(10.0, step_count))).strip(), "");
                  }

                  num_iterate = (new Object() {
                     double convert(String s) {
                        try {
                           return Double.parseDouble(s.trim());
                        } catch (Exception var3) {
                           return 0.0;
                        }
                     }
                  }).convert(checked_pos.strip());
                  if (entity instanceof ArachnoidTrisectorEntity _datEntSetI) {
                     _datEntSetI.getEntityData().set(ArachnoidTrisectorEntity.DATA_current_final, (int)num_iterate);
                  }
               }
            }

            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (!(entityiteratorx instanceof ChronoShotEntity)
                  && !(entityiteratorx instanceof AscendantArrowEntity)
                  && !(entityiteratorx instanceof SpacetimeAnchorEntity)
                  && !(entityiteratorx instanceof ArachnoidTrisectorEntity)
                  && !(entityiteratorx instanceof ItemEntity)
                  && !entityiteratorx.getPersistentData().getBoolean("creativespectator")) {
                  if (!entityiteratorx.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("minecraft:impact_projectiles")))
                     && !(entityiteratorx instanceof WebbedArrowEntity)
                     && !(entityiteratorx instanceof BloodProjectileEntity)) {
                     if ((
                              entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxxxxxxxx
                                 ? (Integer)_datEntIxxxxxxxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_current_final)
                                 : 0
                           )
                           == 2
                        && (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) != null
                        && entityiteratorx instanceof LivingEntity
                        && !(entityiteratorx instanceof ArmorStand)
                        && (
                              entity instanceof ArachnoidTrisectorEntity _datEntIxxxxxxxxxxx
                                 ? (Integer)_datEntIxxxxxxxxxxx.getEntityData().get(ArachnoidTrisectorEntity.DATA_flash)
                                 : 0
                           )
                           == 5) {
                        entityiteratorx.hurt(
                           new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)),
                           (entityiteratorx instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 5.0F
                        );
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt414 = (LivingEntity)entity;
                        if (_livEnt414.hasEffect((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get())) {
                           continue;
                        }
                     }

                     if (entity.getPersistentData().getDouble("slowtime") == 5.0 || !(entityiteratorx instanceof Player)) {
                        if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) == null) {
                           if (Math.abs(entityiteratorx.getDeltaMovement().y()) > 0.003) {
                              entityiteratorx.setDeltaMovement(
                                 new Vec3(
                                    entityiteratorx.getDeltaMovement().x(),
                                    entityiteratorx.getDeltaMovement().y() * 0.5,
                                    entityiteratorx.getDeltaMovement().z()
                                 )
                              );
                           }

                           if (Math.abs(entityiteratorx.getDeltaMovement().x()) > 4.5E-4 || Math.abs(entityiteratorx.getDeltaMovement().z()) > 4.5E-4) {
                              entityiteratorx.setDeltaMovement(
                                 new Vec3(
                                    entityiteratorx.getDeltaMovement().x() * 0.25,
                                    entityiteratorx.getDeltaMovement().y(),
                                    entityiteratorx.getDeltaMovement().z() * 0.25
                                 )
                              );
                              if (world instanceof ServerLevel _levelx) {
                                 _levelx.sendParticles(
                                    (SimpleParticleType)ArphexModParticleTypes.HEAVY_GREEN_SMOKE.get(),
                                    entityiteratorx.getX(),
                                    entityiteratorx.getY(),
                                    entityiteratorx.getZ(),
                                    1,
                                    0.3,
                                    0.3,
                                    0.3,
                                    0.2
                                 );
                              }
                           }
                        } else if (entityiteratorx == (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null)) {
                           if (Math.abs(entityiteratorx.getDeltaMovement().y()) > 0.006) {
                              entityiteratorx.setDeltaMovement(
                                 new Vec3(
                                    entityiteratorx.getDeltaMovement().x(),
                                    entityiteratorx.getDeltaMovement().y() * 0.5,
                                    entityiteratorx.getDeltaMovement().z()
                                 )
                              );
                           }

                           if (Math.abs(entityiteratorx.getDeltaMovement().x()) > 0.001 || Math.abs(entityiteratorx.getDeltaMovement().z()) > 0.001) {
                              entityiteratorx.setDeltaMovement(
                                 new Vec3(
                                    entityiteratorx.getDeltaMovement().x() * 0.25,
                                    entityiteratorx.getDeltaMovement().y(),
                                    entityiteratorx.getDeltaMovement().z() * 0.25
                                 )
                              );
                              if (world instanceof ServerLevel _levelx) {
                                 _levelx.sendParticles(
                                    (SimpleParticleType)ArphexModParticleTypes.HEAVY_GREEN_SMOKE.get(),
                                    entityiteratorx.getX(),
                                    entityiteratorx.getY(),
                                    entityiteratorx.getZ(),
                                    1,
                                    0.3,
                                    0.3,
                                    0.3,
                                    0.2
                                 );
                              }
                           }
                        } else {
                           if (Math.abs(entityiteratorx.getDeltaMovement().y()) > 0.003) {
                              entityiteratorx.setDeltaMovement(
                                 new Vec3(
                                    entityiteratorx.getDeltaMovement().x(),
                                    entityiteratorx.getDeltaMovement().y() * 0.5,
                                    entityiteratorx.getDeltaMovement().z()
                                 )
                              );
                           }

                           if (Math.abs(entityiteratorx.getDeltaMovement().x()) > 4.5E-4 || Math.abs(entityiteratorx.getDeltaMovement().z()) > 4.5E-4) {
                              entityiteratorx.setDeltaMovement(
                                 new Vec3(
                                    entityiteratorx.getDeltaMovement().x() * 0.25,
                                    entityiteratorx.getDeltaMovement().y(),
                                    entityiteratorx.getDeltaMovement().z() * 0.25
                                 )
                              );
                              if (world instanceof ServerLevel _levelx) {
                                 _levelx.sendParticles(
                                    (SimpleParticleType)ArphexModParticleTypes.HEAVY_GREEN_SMOKE.get(),
                                    entityiteratorx.getX(),
                                    entityiteratorx.getY(),
                                    entityiteratorx.getZ(),
                                    1,
                                    0.3,
                                    0.3,
                                    0.3,
                                    0.2
                                 );
                              }
                           }
                        }
                     }
                  } else {
                     entityiteratorx.setDeltaMovement(new Vec3(0.0, -0.1, 0.0));
                  }
               }
            }

            if (var78 != null) {
               if ((
                     var78 instanceof Player
                           && (
                              (new Object() {
                                       public boolean checkGamemode(Entity _ent) {
                                          if (_ent instanceof ServerPlayer _serverPlayer) {
                                             return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
                                          } else {
                                             return _ent.level().isClientSide() && _ent instanceof Player _player
                                                ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                                   && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode()
                                                      == GameType.CREATIVE
                                                : false;
                                          }
                                       }
                                    })
                                    .checkGamemode(var78)
                                 || (new Object() {
                                       public boolean checkGamemode(Entity _ent) {
                                          if (_ent instanceof ServerPlayer _serverPlayer) {
                                             return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
                                          } else {
                                             return _ent.level().isClientSide() && _ent instanceof Player _player
                                                ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                                   && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode()
                                                      == GameType.SPECTATOR
                                                : false;
                                          }
                                       }
                                    })
                                    .checkGamemode(var78)
                           )
                        || !var78.isAlive()
                  )
                  && entity instanceof Mob) {
                  try {
                     ((Mob)entity).setTarget(null);
                  } catch (Exception var75) {
                     var75.printStackTrace();
                  }
               }

               if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) > 325.0F) {
                  if (world instanceof ServerLevel _levelx) {
                     _levelx.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL,
                                 new Vec3(entity.getX(), entity.getY() + 2.0, entity.getZ()),
                                 Vec2.ZERO,
                                 _levelx,
                                 4,
                                 "",
                                 Component.literal(""),
                                 _levelx.getServer(),
                                 null
                              )
                              .withSuppressedOutput(),
                           "/particle arphex:charcoal ~ ~ ~ 2.5 2.5 2.5 0 100 force"
                        );
                  }
               } else if (world instanceof ServerLevel _levelx) {
                  _levelx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL,
                              new Vec3(entity.getX(), entity.getY() + 2.0, entity.getZ()),
                              Vec2.ZERO,
                              _levelx,
                              4,
                              "",
                              Component.literal(""),
                              _levelx.getServer(),
                              null
                           )
                           .withSuppressedOutput(),
                        "/particle arphex:charred_blood ~ ~ ~ 2.5 2.5 2.5 0 100 force"
                     );
               }
            }

            if (nearestplayer250 != null) {
               nearestplayer80 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 80.0, 80.0, 80.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null);
               if ((
                     !(entity instanceof ArachnoidTrisectorEntity _datEntL484)
                        || !(Boolean)_datEntL484.getEntityData().get(ArachnoidTrisectorEntity.DATA_primed)
                  )
                  && nearestplayer80 != null
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
                           .checkGamemode(nearestplayer80)
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
                           .checkGamemode(nearestplayer80)
                  )) {
                  if (entity instanceof ArachnoidTrisectorEntity _datEntSetL) {
                     _datEntSetL.getEntityData().set(ArachnoidTrisectorEntity.DATA_primed, true);
                  }

                  if (world instanceof ServerLevel _levelx) {
                     LightningBolt entityToSpawn = (LightningBolt)EntityType.LIGHTNING_BOLT.create(_levelx);
                     entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
                     entityToSpawn.setVisualOnly(true);
                     _levelx.addFreshEntity(entityToSpawn);
                  }

                  if (world instanceof Level _levelx) {
                     if (!_levelx.isClientSide()) {
                        _levelx.playSound(
                           null,
                           BlockPos.containing(nearestplayer80.getX(), nearestplayer80.getY(), nearestplayer80.getZ()),
                           (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:mothscare")),
                           SoundSource.HOSTILE,
                           0.3F,
                           0.001F
                        );
                     } else {
                        _levelx.playLocalSound(
                           nearestplayer80.getX(),
                           nearestplayer80.getY(),
                           nearestplayer80.getZ(),
                           (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:mothscare")),
                           SoundSource.HOSTILE,
                           0.3F,
                           0.001F,
                           false
                        );
                     }
                  }

                  if (nearestplayer80 instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 60, 1, false, false));
                  }

                  boolean _setval = true;
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 80.0, 80.0, 80.0), e -> true)
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
                           capability.ShowOverlay4 = _setval;
                           capability.syncPlayerVariables(
                              world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 80.0, 80.0, 80.0), e -> true)
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

               if (entity.isInWall()) {
                  entity.teleportTo(x, y + 1.0, z);
                  if (entity instanceof ServerPlayer _serverPlayer) {
                     _serverPlayer.connection.teleport(x, y + 1.0, z, entity.getYRot(), entity.getXRot());
                  }
               }

               if (world instanceof ServerLevel _levelxx) {
                  _levelxx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxx, 4, "", Component.literal(""), _levelxx.getServer(), null
                           )
                           .withSuppressedOutput(),
                        "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 arphex:cobweb_passable replace cobweb"
                     );
               }
            }
         }

         if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
               == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))
            && entity.getY() > 250.0) {
            entity.teleportTo(x, y - 2.0, z);
            if (entity instanceof ServerPlayer _serverPlayer) {
               _serverPlayer.connection.teleport(x, y - 2.0, z, entity.getYRot(), entity.getXRot());
            }
         }
      }
   }
}
