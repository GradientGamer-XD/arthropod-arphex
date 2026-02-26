package net.arphex.procedures;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.AscendantArrowEntity;
import net.arphex.entity.BloodProjectileEntity;
import net.arphex.entity.ChronoShotEntity;
import net.arphex.entity.DiabolosDecimatorEntity;
import net.arphex.entity.GenesisShotEntity;
import net.arphex.entity.GravitonShotEntity;
import net.arphex.entity.HomingSparkEntity;
import net.arphex.entity.SlowLookTestEntity;
import net.arphex.entity.SphereAnimEntity;
import net.arphex.entity.WebbedArrowEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
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

public class DiabolosTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String order_random = "";
         String checked_pos = "";
         Entity attack_target = null;
         Entity nearestplayer250 = null;
         Entity nearestplayer80 = null;
         boolean one = false;
         boolean two = false;
         boolean three = false;
         boolean four = false;
         boolean five = false;
         boolean found = false;
         boolean valid_hitbox_tp_half = false;
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
         double scanz = 0.0;
         double pitch_variance = 0.0;
         double random_once = 0.0;
         double store_dist = 0.0;
         double distance_scaling_factor = 0.0;
         double yaw_variance = 0.0;
         double offs = 0.0;
         double pylon_spawn = 0.0;
         double pylon_x = 0.0;
         double pylon_z = 0.0;
         if ((entity instanceof DiabolosDecimatorEntity _datEntI ? (Integer)_datEntI.getEntityData().get(DiabolosDecimatorEntity.DATA_size_num) : 0) <= 1000
            && !world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ())).canOcclude()
            && !world.getBlockState(BlockPos.containing(entity.getX() - 1.0, entity.getY() - 1.0, entity.getZ())).canOcclude()
            && !world.getBlockState(BlockPos.containing(entity.getX() + 1.0, entity.getY() - 1.0, entity.getZ())).canOcclude()
            && !world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ() + 1.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ() - 1.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(entity.getX() - 1.0, entity.getY() - 1.0, entity.getZ() - 1.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(entity.getX() + 1.0, entity.getY() - 1.0, entity.getZ() + 1.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(entity.getX() - 1.0, entity.getY() - 1.0, entity.getZ() + 1.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(entity.getX() + 1.0, entity.getY() - 1.0, entity.getZ() - 1.0)).canOcclude()) {
            if ((entity instanceof DiabolosDecimatorEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(DiabolosDecimatorEntity.DATA_animation_limit) : 0)
               <= 0) {
               entity.setShiftKeyDown(true);
               if (entity instanceof DiabolosDecimatorEntity _datEntSetI) {
                  _datEntSetI.getEntityData().set(DiabolosDecimatorEntity.DATA_animation_limit, 50);
               }
            }
         } else {
            entity.setDeltaMovement(new Vec3(0.0, entity.getDeltaMovement().y(), 0.0));
            if ((
                     entity instanceof DiabolosDecimatorEntity _datEntIxxx
                        ? (Integer)_datEntIxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_animation_limit)
                        : 0
                  )
                  <= 0
               && (
                     entity instanceof DiabolosDecimatorEntity _datEntIxx
                        ? (Integer)_datEntIxx.getEntityData().get(DiabolosDecimatorEntity.DATA_current_final)
                        : 0
                  )
                  <= 5) {
               entity.setShiftKeyDown(false);
               if (entity instanceof DiabolosDecimatorEntity _datEntSetI) {
                  _datEntSetI.getEntityData().set(DiabolosDecimatorEntity.DATA_animation_limit, 50);
               }
            }

            if (entity instanceof Mob _entity) {
               _entity.getNavigation().stop();
            }
         }

         if ((
                  entity instanceof DiabolosDecimatorEntity _datEntIxxxx
                     ? (Integer)_datEntIxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_animation_limit)
                     : 0
               )
               > 0
            && entity instanceof DiabolosDecimatorEntity _datEntSetI) {
            _datEntSetI.getEntityData()
               .set(
                  DiabolosDecimatorEntity.DATA_animation_limit,
                  (
                        entity instanceof DiabolosDecimatorEntity _datEntIxxxxx
                           ? (Integer)_datEntIxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_animation_limit)
                           : 0
                     )
                     - 1
               );
         }

         if ((entity instanceof DiabolosDecimatorEntity _datEntIxxxx ? (Integer)_datEntIxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_size_num) : 0)
            > 2000) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get(), 5, 0, false, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 5, 1, false, false));
            }

            if ((
                     entity instanceof DiabolosDecimatorEntity _datEntIxxxxx
                        ? (Integer)_datEntIxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_size_num)
                        : 0
                  )
                  > 4000
               && entity instanceof LivingEntity _entity
               && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 5, 3, false, false));
            }
         }

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

            if ((Boolean)ConfigurationSettingsConfiguration.DWELLER_HEALTH.get()
               && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) > 60.0F
               && entity instanceof LivingEntity _entity) {
               _entity.setHealth(60.0F);
            }

            if (!(Boolean)ConfigurationSettingsConfiguration.DWELLERS_INCLUSION.get()) {
               ArphexModVariables.MapVariables.get(world).last_despawn_reasons = "diabolos-bosses-disabled";
               ArphexModVariables.MapVariables.get(world).syncData(world);
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            }

            if (entity.getPersistentData().getDouble("disable_flight_temp") > 0.0) {
               entity.getPersistentData().putDouble("disable_flight_temp", entity.getPersistentData().getDouble("disable_flight_temp") - 1.0);
            }

            if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null
               && (
                     entity instanceof DiabolosDecimatorEntity _datEntIxxxx
                        ? (Integer)_datEntIxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_size_num)
                        : 0
                  )
                  <= 1000
               && !(entity.getPersistentData().getDouble("disable_flight_temp") > 0.0)) {
               if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) instanceof Player) {
                  offs = 9.0;
               } else if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).onGround()) {
                  offs = 9.0;
               } else {
                  offs = 0.05;
               }

               if (entity.isShiftKeyDown()) {
                  if (!(entity.getPersistentData().getDouble("side_boost_time") > 0.0)) {
                     entity.getPersistentData().putDouble("side_boost_time", 200.0);
                     if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
                        if (entity.getPersistentData().getBoolean("left_fly_toggle")) {
                           entity.getPersistentData().putBoolean("left_fly_toggle", false);
                        } else {
                           entity.getPersistentData().putBoolean("left_fly_toggle", true);
                        }
                     }
                  } else {
                     if (entity.getPersistentData().getDouble("side_boost_time") > 180.0) {
                        if (entity.getPersistentData().getBoolean("left_fly_toggle")) {
                           entity.setDeltaMovement(
                              new Vec3(
                                 Math.cos((double)(entity.getYRot() - 0.0F) * (Math.PI / 180.0)) / 1.0,
                                 0.0,
                                 Math.sin((double)(entity.getYRot() - 0.0F) * (Math.PI / 180.0)) / 1.0
                              )
                           );
                        } else {
                           entity.setDeltaMovement(
                              new Vec3(
                                 Math.cos((double)(entity.getYRot() - 180.0F) * (Math.PI / 180.0)) / 1.0,
                                 0.0,
                                 Math.sin((double)(entity.getYRot() - 180.0F) * (Math.PI / 180.0)) / 1.0
                              )
                           );
                        }
                     }

                     entity.getPersistentData().putDouble("side_boost_time", entity.getPersistentData().getDouble("side_boost_time") - 1.0);
                  }
               }

               if (entity.getY() < (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getY() + offs) {
                  entity.setDeltaMovement(
                     new Vec3(entity.getDeltaMovement().x(), Math.min(entity.getDeltaMovement().y() + 0.1, 0.6), entity.getDeltaMovement().z())
                  );
               } else {
                  entity.setDeltaMovement(
                     new Vec3(entity.getDeltaMovement().x(), Math.max(entity.getDeltaMovement().y() - 0.1, -0.6), entity.getDeltaMovement().z())
                  );
               }
            }

            if (entity instanceof DiabolosDecimatorEntity _datEntL109
               && (Boolean)_datEntL109.getEntityData().get(DiabolosDecimatorEntity.DATA_primed)
               && entity.getPersistentData().getBoolean("chrono_effects")) {
               if ((
                     entity instanceof DiabolosDecimatorEntity _datEntIxxxx
                        ? (Integer)_datEntIxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_float_time)
                        : 0
                  )
                  > 0) {
                  if ((
                        entity instanceof DiabolosDecimatorEntity _datEntIxxxxx
                           ? (Integer)_datEntIxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_float_time)
                           : 0
                     )
                     > 20) {
                     if ((
                           entity instanceof DiabolosDecimatorEntity _datEntIxxxxxx
                              ? (Integer)_datEntIxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_float_time)
                              : 0
                        )
                        > 150) {
                        entity.getPersistentData().putDouble("float_expand", entity.getPersistentData().getDouble("float_expand") - 1.5);
                     } else {
                        entity.getPersistentData().putDouble("float_expand", entity.getPersistentData().getDouble("float_expand") + 1.5);
                     }
                  } else {
                     entity.getPersistentData().putDouble("float_expand", 0.0);
                  }

                  radius = 15.0 + entity.getPersistentData().getDouble("float_expand");
               }

               particle_number = Math.max(entity.getPersistentData().getDouble("float_expand") * 7.0, 200.0);
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
                        yy += step_size / 20.0;
                        radius_at_height = Math.sqrt(radius * radius - yy * yy);
                        if (radius_at_height < 45.0) {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL,
                                          new Vec3(
                                             entity.getX() + radius_at_height * Math.cos(angle),
                                             entity.getY() + yy + entity.getPersistentData().getDouble("float_expand") + 11.0,
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
                                    "particle arphex:entropy_shield ~ ~ ~ 0 0 0 0 1 force"
                                 );
                           }
                        } else if (Mth.nextInt(RandomSource.create(), 1, 3) == 1 && world instanceof ServerLevel _level) {
                           _level.getServer()
                              .getCommands()
                              .performPrefixedCommand(
                                 new CommandSourceStack(
                                       CommandSource.NULL,
                                       new Vec3(
                                          entity.getX() + radius_at_height * Math.cos(angle),
                                          entity.getY() + yy + entity.getPersistentData().getDouble("float_expand") + 11.0,
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
                                 "particle arphex:entropy_shield ~ ~ ~ 0 0 0 0 1 force"
                              );
                        }

                        if (radius_at_height < 30.0 + entity.getPersistentData().getDouble("float_expand") / 15.0 && world instanceof ServerLevel _level) {
                           _level.getServer()
                              .getCommands()
                              .performPrefixedCommand(
                                 new CommandSourceStack(
                                       CommandSource.NULL,
                                       new Vec3(
                                          entity.getX() + radius_at_height * Math.cos(angle),
                                          entity.getY() + yy + entity.getPersistentData().getDouble("float_expand") + 11.0,
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
                                 "particle arphex:heavy_white_smokes ~ ~ ~ 0 0 0 0 1 force"
                              );
                        }

                        if (radius_at_height < Math.max(35.0, entity.getPersistentData().getDouble("float_expand") / 6.0)
                           && world instanceof ServerLevel _level) {
                           _level.getServer()
                              .getCommands()
                              .performPrefixedCommand(
                                 new CommandSourceStack(
                                       CommandSource.NULL,
                                       new Vec3(
                                          entity.getX() + radius_at_height * Math.cos(angle),
                                          entity.getY() + yy + entity.getPersistentData().getDouble("float_expand") + 11.0,
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
                                 "particle arphex:heavy_red_smoke ~ ~ ~ 0 0 0 0 1 force"
                              );
                        }

                        angle = yy * entity.getPersistentData().getDouble("angle_increment");
                        if (world instanceof ServerLevel _level) {
                           _level.getServer()
                              .getCommands()
                              .performPrefixedCommand(
                                 new CommandSourceStack(
                                       CommandSource.NULL,
                                       new Vec3(
                                          entity.getX() + radius_at_height * Math.cos(angle),
                                          entity.getY() + yy + entity.getPersistentData().getDouble("float_expand") + 11.0,
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
                                 "particle arphex:heavy_blue_smoke ~ ~ ~ 0 0 0 0 1 force"
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
                                          entity.getY() + yy + entity.getPersistentData().getDouble("float_expand") + 11.0,
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
                                 "effect give @e[type=!arphex:diabolos_decimator,distance=..5] arphex:supergravity 20 0 true"
                              );
                        }
                     }
                  }

                  if (entity.getPersistentData().getDouble("float_expand") > 50.0 && world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL,
                                 new Vec3(entity.getX(), entity.getY() - 5.0, entity.getZ()),
                                 Vec2.ZERO,
                                 _level,
                                 4,
                                 "",
                                 Component.literal(""),
                                 _level.getServer(),
                                 null
                              )
                              .withSuppressedOutput(),
                           "particle arphex:white_glow_smoke ~ ~ ~ 0.4 0.4 0.4 0 5 force"
                        );
                  }

                  if (world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL,
                                 new Vec3(entity.getX(), entity.getY() - 5.0, entity.getZ()),
                                 Vec2.ZERO,
                                 _level,
                                 4,
                                 "",
                                 Component.literal(""),
                                 _level.getServer(),
                                 null
                              )
                              .withSuppressedOutput(),
                           "particle arphex:galaxy_core ~ ~ ~ 0 0 0 0 1 force"
                        );
                  }

                  entity.getPersistentData().putDouble("cannon_cycle", 4.0);
                  if ((
                           entity instanceof DiabolosDecimatorEntity _datEntIxxxx
                              ? (Integer)_datEntIxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_float_time)
                              : 0
                        )
                        > 150
                     && (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
                     for (Entity entityiterator : new ArrayList(world.players())) {
                        if (entity.getX() - entityiterator.getX() < 200.0
                           && entity.getY() - entityiterator.getY() < 200.0
                           && entity.getZ() - entityiterator.getZ() < 200.0) {
                           double _setval = 50.0;
                           entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                              capability.laser_emitter_near = _setval;
                              capability.syncPlayerVariables(entityiterator);
                           });
                        }
                     }

                     for (int index1 = 0; index1 < 10; index1++) {
                        if (world instanceof ServerLevel projectileLevel) {
                           Projectile _entityToSpawn = (new Object() {
                                 public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                    AbstractArrow entityToSpawn = new HomingSparkEntity(
                                       (EntityType<? extends HomingSparkEntity>)ArphexModEntities.HOMING_SPARK.get(), level
                                    );
                                    entityToSpawn.setOwner(shooter);
                                    entityToSpawn.setBaseDamage((double)damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                 }
                              })
                              .getArrow(projectileLevel, entity, 5.0F, 1);
                           _entityToSpawn.setPos(
                              (double)Math.round(
                                 (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getX()
                                    + (double)Mth.nextInt(RandomSource.create(), -30, 30)
                              ),
                              (double)Math.round((entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getY() + 100.0),
                              (double)Math.round(
                                 (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getZ() + (double)Mth.nextInt(RandomSource.create(), -30, 30)
                              )
                           );
                           _entityToSpawn.shoot(0.0, -0.1, 0.0, 1.0F, 0.0F);
                           projectileLevel.addFreshEntity(_entityToSpawn);
                        }
                     }

                     if (world instanceof ServerLevel projectileLevel) {
                        Projectile _entityToSpawn = (new Object() {
                              public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                 AbstractArrow entityToSpawn = new HomingSparkEntity(
                                    (EntityType<? extends HomingSparkEntity>)ArphexModEntities.HOMING_SPARK.get(), level
                                 );
                                 entityToSpawn.setOwner(shooter);
                                 entityToSpawn.setBaseDamage((double)damage);
                                 entityToSpawn.setKnockback(knockback);
                                 entityToSpawn.setSilent(true);
                                 return entityToSpawn;
                              }
                           })
                           .getArrow(projectileLevel, entity, 5.0F, 1);
                        _entityToSpawn.setPos(
                           (double)Math.round(
                              (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getX() + (double)Mth.nextInt(RandomSource.create(), -3, 3)
                           ),
                           (double)Math.round((entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getY() + 100.0),
                           (double)Math.round(
                              (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getZ() + (double)Mth.nextInt(RandomSource.create(), -3, 3)
                           )
                        );
                        _entityToSpawn.shoot(0.0, -0.1, 0.0, 1.0F, 0.0F);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                     }
                  }
               }
            }

            Entity var103 = entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null;
            nearestplayer250 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 250.0, 250.0, 250.0), e -> true)
               .stream()
               .sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z))
               .findFirst()
               .orElse(null);
            if (var103 == null) {
               if (nearestplayer250 != null) {
                  if (!(new Object() {
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
                     && !(new Object() {
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
                        .checkGamemode(nearestplayer250)) {
                     if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != Blocks.VOID_AIR) {
                        entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), -0.4, entity.getDeltaMovement().z()));
                     }
                  } else if (entity instanceof Mob _entity && nearestplayer250 instanceof LivingEntity _ent) {
                     _entity.setTarget(_ent);
                  }
               } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != Blocks.VOID_AIR) {
                  entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), -0.4, entity.getDeltaMovement().z()));
               }
            } else {
               if (entity instanceof DiabolosDecimatorEntity _datEntSetI) {
                  _datEntSetI.getEntityData()
                     .set(
                        DiabolosDecimatorEntity.DATA_store_target_distance,
                        (int)Math.sqrt(
                           (entity.getX() - var103.getX()) * (entity.getX() - var103.getX())
                              + (entity.getY() - var103.getY()) * (entity.getY() - var103.getY())
                              + (entity.getZ() - var103.getZ()) * (entity.getZ() - var103.getZ())
                        )
                     );
               }

               if (entity.isShiftKeyDown()) {
                  if ((
                        entity instanceof DiabolosDecimatorEntity _datEntIxxxx
                           ? (Integer)_datEntIxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_store_target_distance)
                           : 0
                     )
                     > 0) {
                     if ((
                           entity instanceof DiabolosDecimatorEntity _datEntIxxxxxx
                              ? (Integer)_datEntIxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_store_target_distance)
                              : 0
                        )
                        < 30) {
                        entity.setDeltaMovement(
                           new Vec3(
                              (entity.getX() - var103.getX())
                                 / (double)(
                                    entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxx
                                       ? (Integer)_datEntIxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_store_target_distance)
                                       : 0
                                 )
                                 * 0.3,
                              entity.getDeltaMovement().y(),
                              (entity.getZ() - var103.getZ())
                                 / (double)(
                                    entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxx
                                       ? (Integer)_datEntIxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_store_target_distance)
                                       : 0
                                 )
                                 * 0.3
                           )
                        );
                     } else if ((
                           entity instanceof DiabolosDecimatorEntity _datEntIxxxxxx
                              ? (Integer)_datEntIxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_store_target_distance)
                              : 0
                        )
                        > 100) {
                        entity.setDeltaMovement(new Vec3(entity.getLookAngle().x, entity.getDeltaMovement().y(), entity.getLookAngle().z));
                     }
                  }
               } else if ((
                        entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxx
                           ? (Integer)_datEntIxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_store_target_distance)
                           : 0
                     )
                     < 8
                  && (
                        entity instanceof DiabolosDecimatorEntity _datEntIxxxxxx
                           ? (Integer)_datEntIxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_store_target_distance)
                           : 0
                     )
                     > 0) {
                  entity.setDeltaMovement(
                     new Vec3(
                        (entity.getX() - var103.getX())
                           / (double)(
                              entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxx
                                 ? (Integer)_datEntIxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_store_target_distance)
                                 : 0
                           )
                           * 0.3,
                        entity.getDeltaMovement().y(),
                        (entity.getZ() - var103.getZ())
                           / (double)(
                              entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxx
                                 ? (Integer)_datEntIxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_store_target_distance)
                                 : 0
                           )
                           * 0.3
                     )
                  );
               }
            }

            if ((
                  entity instanceof DiabolosDecimatorEntity _datEntIxxxxxx
                     ? (Integer)_datEntIxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_size_num)
                     : 0
               )
               > 2000) {
               entity.getPersistentData().putBoolean("disable_rotation", true);
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
                        "data merge entity @s {NoAI:1}"
                     );
               }

               if (!world.isClientSide()) {
                  entity.setYRot((float)entity.getPersistentData().getDouble("yaw_memory_dia"));
                  entity.setXRot(0.0F);
                  entity.setYBodyRot(entity.getYRot());
                  entity.setYHeadRot(entity.getYRot());
                  entity.yRotO = entity.getYRot();
                  entity.xRotO = entity.getXRot();
                  if (entity instanceof LivingEntity _entity) {
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }
               }
            } else {
               entity.getPersistentData().putDouble("yaw_memory_dia", (double)entity.getYRot());
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
                        "data merge entity @s {NoAI:0b}"
                     );
               }

               entity.getPersistentData().putBoolean("disable_rotation", false);
            }

            if (entity instanceof DiabolosDecimatorEntity _datEntL268 && (Boolean)_datEntL268.getEntityData().get(DiabolosDecimatorEntity.DATA_primed)) {
               if (Math.round(
                     entity instanceof DiabolosDecimatorEntity _datEntIxxxxxx
                        ? (float)((Integer)_datEntIxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_current_final)).intValue()
                        : 0.0F
                  )
                  == 1) {
                  if ((
                        entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxx
                           ? (Integer)_datEntIxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_lunge_time)
                           : 0
                     )
                     <= 0) {
                     if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) != null && entity instanceof DiabolosDecimatorEntity _datEntSetI) {
                        _datEntSetI.getEntityData().set(DiabolosDecimatorEntity.DATA_lunge_time, 600);
                     }

                     if (entity.getPersistentData().getBoolean("noai_reset")) {
                        entity.getPersistentData().putBoolean("noai_reset", false);
                     }
                  } else {
                     if ((
                              entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxx
                                 ? (Integer)_datEntIxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_store_target_distance)
                                 : 0
                           )
                           <= 20
                        && (
                              entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxx
                                 ? (Integer)_datEntIxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_time_since_landing_attack)
                                 : 0
                           )
                           <= 398) {
                        if (entity.getPersistentData().getBoolean("noai_reset")) {
                           entity.getPersistentData().putBoolean("noai_reset", false);
                        }
                     } else {
                        if ((
                                 entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxx
                                    ? (Integer)_datEntIxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_lunge_time)
                                    : 0
                              )
                              == 599
                           && (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) != null) {
                           if (entity instanceof DiabolosDecimatorEntity _datEntSetI) {
                              _datEntSetI.getEntityData()
                                 .set(
                                    DiabolosDecimatorEntity.DATA_store_target_distance,
                                    (int)Math.sqrt(
                                       (entity.getX() - (entity instanceof Mob _mobEntxxxxxxx ? _mobEntxxxxxxx.getTarget() : null).getX())
                                             * (entity.getX() - (entity instanceof Mob _mobEntxxxxxx ? _mobEntxxxxxx.getTarget() : null).getX())
                                          + (entity.getY() - (entity instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null).getY())
                                             * (entity.getY() - (entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getY())
                                          + (entity.getZ() - (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getZ())
                                             * (entity.getZ() - (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getZ())
                                    )
                                 );
                           }

                           if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ())).canOcclude()
                              || world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 2.0, entity.getZ())).canOcclude()
                              || world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 3.0, entity.getZ())).canOcclude()
                              || world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 4.0, entity.getZ())).canOcclude()
                              || world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 5.0, entity.getZ())).canOcclude()
                              || world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 6.0, entity.getZ())).canOcclude()
                              || world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 7.0, entity.getZ())).canOcclude()
                              || world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 8.0, entity.getZ())).canOcclude()
                              || world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 9.0, entity.getZ())).canOcclude()) {
                              entity.getPersistentData().putDouble("disable_flight_temp", 150.0);
                           }

                           if ((
                                 entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxx
                                    ? (Integer)_datEntIxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_store_target_distance)
                                    : 0
                              )
                              != 0) {
                              entity.getPersistentData()
                                 .putDouble(
                                    "store_target_x",
                                    ((entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getX() - entity.getX())
                                       / (
                                          0.3
                                             * (double)(
                                                entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxx
                                                   ? (Integer)_datEntIxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_store_target_distance)
                                                   : 0
                                             )
                                       )
                                 );
                              entity.getPersistentData()
                                 .putDouble(
                                    "store_target_y",
                                    ((entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getY() + 0.5 - entity.getY())
                                       / (
                                          0.3
                                             * (double)(
                                                entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxx
                                                   ? (Integer)_datEntIxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_store_target_distance)
                                                   : 0
                                             )
                                       )
                                 );
                              entity.getPersistentData()
                                 .putDouble(
                                    "store_target_z",
                                    ((entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getZ() - entity.getZ())
                                       / (
                                          0.3
                                             * (double)(
                                                entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxx
                                                   ? (Integer)_datEntIxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_store_target_distance)
                                                   : 0
                                             )
                                       )
                                 );
                              entity.getPersistentData().putDouble("store_own_x", entity.getX());
                              entity.getPersistentData().putDouble("store_own_y", entity.getY());
                              entity.getPersistentData().putDouble("store_own_z", entity.getZ());
                           }
                        }

                        if ((entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)
                              < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 2.0F
                           && (
                                 entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxx
                                    ? (Integer)_datEntIxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_lunge_time)
                                    : 0
                              )
                              == 390
                           && entity instanceof DiabolosDecimatorEntity _datEntSetI) {
                           _datEntSetI.getEntityData().set(DiabolosDecimatorEntity.DATA_lunge_time, 10);
                        }

                        if ((
                                 entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxx
                                    ? (Integer)_datEntIxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_lunge_time)
                                    : 0
                              )
                              == 598
                           && (
                                 entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxx
                                    ? (Integer)_datEntIxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_size_num)
                                    : 0
                              )
                              <= 1000) {
                           if (!world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ())).canOcclude()
                              && !world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 2.0, entity.getZ())).canOcclude()
                              && !world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 3.0, entity.getZ())).canOcclude()
                              && !world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 4.0, entity.getZ())).canOcclude()
                              && !world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 5.0, entity.getZ())).canOcclude()
                              && !world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 6.0, entity.getZ())).canOcclude()
                              && !world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 7.0, entity.getZ())).canOcclude()
                              && !world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 8.0, entity.getZ())).canOcclude()
                              && !world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 9.0, entity.getZ())).canOcclude()) {
                              if (entity instanceof DiabolosDecimatorEntity) {
                                 ((DiabolosDecimatorEntity)entity).setAnimation("animation.diabolos.fly_charge");
                              }
                           } else if (entity instanceof DiabolosDecimatorEntity) {
                              ((DiabolosDecimatorEntity)entity).setAnimation("animation.diabolos.charge");
                           }
                        }

                        if ((
                              entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxx
                                 ? (Integer)_datEntIxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_lunge_time)
                                 : 0
                           )
                           > 520) {
                           if ((
                                 entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxx
                                    ? (Integer)_datEntIxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_lunge_time)
                                    : 0
                              )
                              < 570) {
                              if ((
                                       entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxx
                                          ? (Integer)_datEntIxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_size_num)
                                          : 0
                                    )
                                    <= 1000
                                 && entity.getPersistentData().getDouble("store_target_x") != 0.0
                                 && entity.getPersistentData().getDouble("store_target_z") != 0.0) {
                                 if (Math.abs(entity.getPersistentData().getDouble("store_target_x")) < 10.0
                                    && Math.abs(entity.getPersistentData().getDouble("store_target_z")) < 10.0
                                    && (
                                          entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxx
                                             ? (Integer)_datEntIxxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_store_target_distance)
                                             : 0
                                       )
                                       > 5) {
                                    entity.setDeltaMovement(
                                       new Vec3(
                                          entity.getPersistentData().getDouble("store_target_x"),
                                          entity.getDeltaMovement().y(),
                                          entity.getPersistentData().getDouble("store_target_z")
                                       )
                                    );
                                 }

                                 if (var103 != null) {
                                    entity.getPersistentData()
                                       .putDouble(
                                          "store_target_x",
                                          (var103.getX() - entity.getX())
                                             / (
                                                0.3
                                                   * (double)(
                                                      entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxx
                                                         ? (Integer)_datEntIxxxxxxxxxxxxxx.getEntityData()
                                                            .get(DiabolosDecimatorEntity.DATA_store_target_distance)
                                                         : 0
                                                   )
                                             )
                                       );
                                    entity.getPersistentData()
                                       .putDouble(
                                          "store_target_z",
                                          (var103.getZ() - entity.getZ())
                                             / (
                                                0.3
                                                   * (double)(
                                                      entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxxx
                                                         ? (Integer)_datEntIxxxxxxxxxxxxxxx.getEntityData()
                                                            .get(DiabolosDecimatorEntity.DATA_store_target_distance)
                                                         : 0
                                                   )
                                             )
                                       );
                                    if ((
                                             entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxxxxx
                                                ? (Integer)_datEntIxxxxxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_lunge_time)
                                                : 0
                                          )
                                          == 560
                                       && (
                                             entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxxxx
                                                ? (Integer)_datEntIxxxxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_attack_switch_time)
                                                : 0
                                          )
                                          > 50
                                       && entity instanceof DiabolosDecimatorEntity _datEntSetI) {
                                       _datEntSetI.getEntityData().set(DiabolosDecimatorEntity.DATA_attack_switch_time, 50);
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
                                             "/particle arphex:heavy_gold_smoke ^ ^-2 ^-6 0.8 1.8 0.8 0 30 force @a"
                                          );
                                    }

                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                                       _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get(), 10, 0, false, false));
                                    }

                                    if ((Boolean)ConfigurationSettingsConfiguration.ARPHEX_GRIEFING.get()
                                       && world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)
                                       && (
                                                entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxxxx
                                                   ? (Integer)_datEntIxxxxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_lunge_time)
                                                   : 0
                                             )
                                             % 4
                                          == 0
                                       && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) > 50.0F) {
                                       if ((
                                                entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxxxxx
                                                   ? (Integer)_datEntIxxxxxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_store_target_distance)
                                                   : 0
                                             )
                                             > 5
                                          && world instanceof Level _level
                                          && !_level.isClientSide()) {
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
                                       entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxx
                                          ? (Integer)_datEntIxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_store_target_distance)
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

                     if (entity instanceof DiabolosDecimatorEntity _datEntSetI) {
                        _datEntSetI.getEntityData()
                           .set(
                              DiabolosDecimatorEntity.DATA_lunge_time,
                              (
                                    entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxx
                                       ? (Integer)_datEntIxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_lunge_time)
                                       : 0
                                 )
                                 - 1
                           );
                     }
                  }
               } else if (Math.round(
                     entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxx
                        ? (float)((Integer)_datEntIxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_current_final)).intValue()
                        : 0.0F
                  )
                  == 2) {
                  if (entity instanceof DiabolosDecimatorEntity _datEntSetI) {
                     _datEntSetI.getEntityData()
                        .set(
                           DiabolosDecimatorEntity.DATA_float_time,
                           (
                                 entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxx
                                    ? (Integer)_datEntIxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_float_time)
                                    : 0
                              )
                              + 1
                        );
                  }

                  if ((
                        entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxx
                           ? (Integer)_datEntIxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_flash)
                           : 0
                     )
                     <= 0) {
                     if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get(), 20, 0, false, false));
                     }

                     if (entity instanceof DiabolosDecimatorEntity _datEntSetI) {
                        _datEntSetI.getEntityData().set(DiabolosDecimatorEntity.DATA_flash, 500);
                     }
                  } else {
                     if (entity instanceof DiabolosDecimatorEntity _datEntSetI) {
                        _datEntSetI.getEntityData()
                           .set(
                              DiabolosDecimatorEntity.DATA_flash,
                              (
                                    entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxx
                                       ? (Integer)_datEntIxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_flash)
                                       : 0
                                 )
                                 - 1
                           );
                     }

                     if ((
                           entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxx
                              ? (Integer)_datEntIxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_flash)
                              : 0
                        )
                        > 0) {
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get(), 20, 0, false, false));
                        }

                        if (entity instanceof DiabolosDecimatorEntity spider) {
                           spider.getPersistentData().putString("glowTexture", "diabolos_decimator_glow");
                        }
                     } else if (entity instanceof DiabolosDecimatorEntity spider) {
                        spider.getPersistentData().putString("glowTexture", "diabolos_glow");
                     }
                  }

                  if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) == null) {
                     entity.noPhysics = false;
                     entity.getPersistentData().putBoolean("chrono_effects", false);
                  } else {
                     if ((
                           entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxx
                              ? (Integer)_datEntIxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_float_time)
                              : 0
                        )
                        < 40) {
                        entity.setDeltaMovement(new Vec3(0.0, 1.5, 0.0));
                     }

                     entity.getPersistentData().putBoolean("chrono_effects", true);
                     if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get(), 20, 0, false, false));
                     }

                     entity.setOnGround(false);
                     entity.noPhysics = true;
                     if ((
                           entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxx
                              ? (Integer)_datEntIxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_store_target_distance)
                              : 0
                        )
                        > 8) {
                        if ((
                              entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxx
                                 ? (Integer)_datEntIxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_size_num)
                                 : 0
                           )
                           > 1000) {
                           entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                        } else {
                           entity.setDeltaMovement(
                              new Vec3(
                                 ((entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getX() - entity.getX())
                                    / (double)(
                                       entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxxxxx
                                          ? (Integer)_datEntIxxxxxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_store_target_distance)
                                          : 0
                                    )
                                    * 0.3,
                                 ((entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getY() + 11.0 - entity.getY())
                                    / (double)(
                                       entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxxxx
                                          ? (Integer)_datEntIxxxxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_store_target_distance)
                                          : 0
                                    )
                                    * 0.3,
                                 ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getZ() - entity.getZ())
                                    / (double)(
                                       entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxx
                                          ? (Integer)_datEntIxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_store_target_distance)
                                          : 0
                                    )
                                    * 0.3
                              )
                           );
                        }
                     }
                  }
               } else if ((
                     entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxx
                        ? (Integer)_datEntIxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_current_final)
                        : 0
                  )
                  == 3) {
                  if ((
                           entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxx
                              ? (Integer)_datEntIxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_flash)
                              : 0
                        )
                        > 200
                     && entity instanceof DiabolosDecimatorEntity _datEntSetI) {
                     _datEntSetI.getEntityData().set(DiabolosDecimatorEntity.DATA_flash, 5);
                  }

                  if ((
                        entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxx
                           ? (Integer)_datEntIxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_flash)
                           : 0
                     )
                     <= 0) {
                     if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) != null) {
                        for (int index2 = 0; index2 < 2; index2++) {
                           pylon_x = (double)Mth.nextInt(RandomSource.create(), 20, 60);
                           pylon_spawn = (double)Mth.nextInt(RandomSource.create(), 20, 60);
                           pylon_z = (double)Mth.nextInt(RandomSource.create(), 20, 60);
                           if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
                              pylon_x = 0.0 - pylon_x;
                           }

                           if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
                              pylon_z = 0.0 - pylon_z;
                           }

                           if (world.isEmptyBlock(BlockPos.containing(entity.getX() + pylon_x, entity.getY() + pylon_spawn, entity.getZ() + pylon_z))
                              && world.getEntitiesOfClass(
                                    LivingEntity.class,
                                    AABB.ofSize(new Vec3(entity.getX() + pylon_x, entity.getY() + pylon_spawn, entity.getZ() + pylon_z), 20.0, 20.0, 20.0),
                                    e -> true
                                 )
                                 .isEmpty()
                              && world instanceof ServerLevel _level) {
                              Entity entityToSpawn = ((EntityType)ArphexModEntities.ENTROPY_CONDUIT.get())
                                 .spawn(
                                    _level,
                                    BlockPos.containing(entity.getX() + pylon_x, entity.getY() + pylon_spawn, entity.getZ() + pylon_z),
                                    MobSpawnType.MOB_SUMMONED
                                 );
                              if (entityToSpawn != null) {
                                 entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                              }
                           }
                        }
                     }

                     if (entity instanceof DiabolosDecimatorEntity _datEntSetI) {
                        _datEntSetI.getEntityData().set(DiabolosDecimatorEntity.DATA_flash, 200);
                     }
                  } else {
                     if (entity instanceof DiabolosDecimatorEntity _datEntSetI) {
                        _datEntSetI.getEntityData()
                           .set(
                              DiabolosDecimatorEntity.DATA_flash,
                              (
                                    entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxx
                                       ? (Integer)_datEntIxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_flash)
                                       : 0
                                 )
                                 - 1
                           );
                     }

                     if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) != null) {
                        if ((entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null) instanceof Player) {
                           if ((entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)
                                 < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 2.0F
                              && (
                                       entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxx
                                          ? (Integer)_datEntIxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_flash)
                                          : 0
                                    )
                                    % 200
                                 == 0) {
                              if (world instanceof ServerLevel projectileLevel) {
                                 Projectile _entityToSpawn = (new Object() {
                                       public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                          AbstractArrow entityToSpawn = new GravitonShotEntity(
                                             (EntityType<? extends GravitonShotEntity>)ArphexModEntities.GRAVITON_SHOT.get(), level
                                          );
                                          entityToSpawn.setOwner(shooter);
                                          entityToSpawn.setBaseDamage((double)damage);
                                          entityToSpawn.setKnockback(knockback);
                                          entityToSpawn.setSilent(true);
                                          return entityToSpawn;
                                       }
                                    })
                                    .getArrow(projectileLevel, entity, 5.0F, 1);
                                 _entityToSpawn.setPos(entity.getX(), entity.getY() + 7.0, entity.getZ());
                                 _entityToSpawn.shoot(0.8, 0.8, 0.0, 1.5F, 0.0F);
                                 projectileLevel.addFreshEntity(_entityToSpawn);
                              }

                              if (world instanceof ServerLevel projectileLevel) {
                                 Projectile _entityToSpawn = (new Object() {
                                       public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                          AbstractArrow entityToSpawn = new GravitonShotEntity(
                                             (EntityType<? extends GravitonShotEntity>)ArphexModEntities.GRAVITON_SHOT.get(), level
                                          );
                                          entityToSpawn.setOwner(shooter);
                                          entityToSpawn.setBaseDamage((double)damage);
                                          entityToSpawn.setKnockback(knockback);
                                          entityToSpawn.setSilent(true);
                                          return entityToSpawn;
                                       }
                                    })
                                    .getArrow(projectileLevel, entity, 5.0F, 1);
                                 _entityToSpawn.setPos(entity.getX(), entity.getY() + 7.0, entity.getZ());
                                 _entityToSpawn.shoot(0.0, 0.8, 0.8, 1.5F, 0.0F);
                                 projectileLevel.addFreshEntity(_entityToSpawn);
                              }

                              if (world instanceof ServerLevel projectileLevel) {
                                 Projectile _entityToSpawn = (new Object() {
                                       public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                          AbstractArrow entityToSpawn = new GravitonShotEntity(
                                             (EntityType<? extends GravitonShotEntity>)ArphexModEntities.GRAVITON_SHOT.get(), level
                                          );
                                          entityToSpawn.setOwner(shooter);
                                          entityToSpawn.setBaseDamage((double)damage);
                                          entityToSpawn.setKnockback(knockback);
                                          entityToSpawn.setSilent(true);
                                          return entityToSpawn;
                                       }
                                    })
                                    .getArrow(projectileLevel, entity, 5.0F, 1);
                                 _entityToSpawn.setPos(entity.getX(), entity.getY() + 7.0, entity.getZ());
                                 _entityToSpawn.shoot(0.0, 0.8, -0.8, 1.5F, 0.0F);
                                 projectileLevel.addFreshEntity(_entityToSpawn);
                              }

                              if (world instanceof ServerLevel projectileLevel) {
                                 Projectile _entityToSpawn = (new Object() {
                                       public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                          AbstractArrow entityToSpawn = new GravitonShotEntity(
                                             (EntityType<? extends GravitonShotEntity>)ArphexModEntities.GRAVITON_SHOT.get(), level
                                          );
                                          entityToSpawn.setOwner(shooter);
                                          entityToSpawn.setBaseDamage((double)damage);
                                          entityToSpawn.setKnockback(knockback);
                                          entityToSpawn.setSilent(true);
                                          return entityToSpawn;
                                       }
                                    })
                                    .getArrow(projectileLevel, entity, 5.0F, 1);
                                 _entityToSpawn.setPos(entity.getX(), entity.getY() + 7.0, entity.getZ());
                                 _entityToSpawn.shoot(-0.8, 0.8, 0.0, 1.5F, 0.0F);
                                 projectileLevel.addFreshEntity(_entityToSpawn);
                              }
                           }
                        } else if ((entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)
                                 < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 2.0F
                              && (
                                       entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxxxx
                                          ? (Integer)_datEntIxxxxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_flash)
                                          : 0
                                    )
                                    % 30
                                 == 0
                           || (
                                    entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxx
                                       ? (Integer)_datEntIxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_flash)
                                       : 0
                                 )
                                 % 60
                              == 0) {
                           if (world instanceof ServerLevel projectileLevel) {
                              Projectile _entityToSpawn = (new Object() {
                                    public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                       AbstractArrow entityToSpawn = new GravitonShotEntity(
                                          (EntityType<? extends GravitonShotEntity>)ArphexModEntities.GRAVITON_SHOT.get(), level
                                       );
                                       entityToSpawn.setOwner(shooter);
                                       entityToSpawn.setBaseDamage((double)damage);
                                       entityToSpawn.setKnockback(knockback);
                                       entityToSpawn.setSilent(true);
                                       return entityToSpawn;
                                    }
                                 })
                                 .getArrow(projectileLevel, entity, 5.0F, 1);
                              _entityToSpawn.setPos(entity.getX(), entity.getY() + 7.0, entity.getZ());
                              _entityToSpawn.shoot(0.8, 0.8, 0.0, 1.5F, 0.0F);
                              projectileLevel.addFreshEntity(_entityToSpawn);
                           }

                           if (world instanceof ServerLevel projectileLevel) {
                              Projectile _entityToSpawn = (new Object() {
                                    public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                       AbstractArrow entityToSpawn = new GravitonShotEntity(
                                          (EntityType<? extends GravitonShotEntity>)ArphexModEntities.GRAVITON_SHOT.get(), level
                                       );
                                       entityToSpawn.setOwner(shooter);
                                       entityToSpawn.setBaseDamage((double)damage);
                                       entityToSpawn.setKnockback(knockback);
                                       entityToSpawn.setSilent(true);
                                       return entityToSpawn;
                                    }
                                 })
                                 .getArrow(projectileLevel, entity, 5.0F, 1);
                              _entityToSpawn.setPos(entity.getX(), entity.getY() + 7.0, entity.getZ());
                              _entityToSpawn.shoot(0.0, 0.8, 0.8, 1.5F, 0.0F);
                              projectileLevel.addFreshEntity(_entityToSpawn);
                           }

                           if (world instanceof ServerLevel projectileLevel) {
                              Projectile _entityToSpawn = (new Object() {
                                    public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                       AbstractArrow entityToSpawn = new GravitonShotEntity(
                                          (EntityType<? extends GravitonShotEntity>)ArphexModEntities.GRAVITON_SHOT.get(), level
                                       );
                                       entityToSpawn.setOwner(shooter);
                                       entityToSpawn.setBaseDamage((double)damage);
                                       entityToSpawn.setKnockback(knockback);
                                       entityToSpawn.setSilent(true);
                                       return entityToSpawn;
                                    }
                                 })
                                 .getArrow(projectileLevel, entity, 5.0F, 1);
                              _entityToSpawn.setPos(entity.getX(), entity.getY() + 7.0, entity.getZ());
                              _entityToSpawn.shoot(0.0, 0.8, -0.8, 1.5F, 0.0F);
                              projectileLevel.addFreshEntity(_entityToSpawn);
                           }

                           if (world instanceof ServerLevel projectileLevel) {
                              Projectile _entityToSpawn = (new Object() {
                                    public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                       AbstractArrow entityToSpawn = new GravitonShotEntity(
                                          (EntityType<? extends GravitonShotEntity>)ArphexModEntities.GRAVITON_SHOT.get(), level
                                       );
                                       entityToSpawn.setOwner(shooter);
                                       entityToSpawn.setBaseDamage((double)damage);
                                       entityToSpawn.setKnockback(knockback);
                                       entityToSpawn.setSilent(true);
                                       return entityToSpawn;
                                    }
                                 })
                                 .getArrow(projectileLevel, entity, 5.0F, 1);
                              _entityToSpawn.setPos(entity.getX(), entity.getY() + 7.0, entity.getZ());
                              _entityToSpawn.shoot(-0.8, 0.8, 0.0, 1.5F, 0.0F);
                              projectileLevel.addFreshEntity(_entityToSpawn);
                           }
                        }
                     }
                  }
               } else if ((
                     entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxx
                        ? (Integer)_datEntIxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_current_final)
                        : 0
                  )
                  == 4) {
                  entity.setDeltaMovement(new Vec3(0.0, entity.getDeltaMovement().y(), 0.0));
                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 999, false, false));
                  }

                  if ((
                        entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxx
                           ? (Integer)_datEntIxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_flash)
                           : 0
                     )
                     <= 0) {
                     if (var103 != null
                        && (
                              entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxxxxx
                                 ? (Integer)_datEntIxxxxxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_attack_switch_time)
                                 : 0
                           )
                           > 40
                        && (
                              entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxxxx
                                 ? (Integer)_datEntIxxxxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_size_num)
                                 : 0
                           )
                           <= 1000) {
                        ArphexMod.queueServerWork(
                           15,
                           () -> {
                              if (!world.isClientSide() && (entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null) != null) {
                                 entity.lookAt(
                                    Anchor.EYES,
                                    new Vec3(
                                       (entity instanceof Mob _mobEntxxxxxx ? _mobEntxxxxxx.getTarget() : null).getX(),
                                       (entity instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null).getY() + 16.0,
                                       (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getZ()
                                    )
                                 );
                                 if ((entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)
                                    < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 2.0F) {
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
                                             "execute as @s run tp @s ~ ~ ~ ~-16 ~"
                                          );
                                    }

                                    Level projectileLevelx = entity.level();
                                    if (!projectileLevelx.isClientSide()) {
                                       Projectile _entityToSpawnxxxxx = (new Object() {
                                             public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                AbstractArrow entityToSpawn = new GenesisShotEntity(
                                                   (EntityType<? extends GenesisShotEntity>)ArphexModEntities.GENESIS_SHOT.get(), level
                                                );
                                                entityToSpawn.setOwner(shooter);
                                                entityToSpawn.setBaseDamage((double)damage);
                                                entityToSpawn.setKnockback(knockback);
                                                entityToSpawn.setSilent(true);
                                                return entityToSpawn;
                                             }
                                          })
                                          .getArrow(projectileLevelx, entity, 5.0F, 1);
                                       _entityToSpawnxxxxx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                       _entityToSpawnxxxxx.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 6.0F, 0.1F);
                                       projectileLevelx.addFreshEntity(_entityToSpawnxxxxx);
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
                                             "execute as @s run tp @s ~ ~ ~ ~5 ~"
                                          );
                                    }

                                    projectileLevelx = entity.level();
                                    if (!projectileLevelx.isClientSide()) {
                                       Projectile _entityToSpawnxxxx = (new Object() {
                                             public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                AbstractArrow entityToSpawn = new GenesisShotEntity(
                                                   (EntityType<? extends GenesisShotEntity>)ArphexModEntities.GENESIS_SHOT.get(), level
                                                );
                                                entityToSpawn.setOwner(shooter);
                                                entityToSpawn.setBaseDamage((double)damage);
                                                entityToSpawn.setKnockback(knockback);
                                                entityToSpawn.setSilent(true);
                                                return entityToSpawn;
                                             }
                                          })
                                          .getArrow(projectileLevelx, entity, 5.0F, 1);
                                       _entityToSpawnxxxx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                       _entityToSpawnxxxx.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 6.0F, 0.1F);
                                       projectileLevelx.addFreshEntity(_entityToSpawnxxxx);
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
                                             "execute as @s run tp @s ~ ~ ~ ~5 ~"
                                          );
                                    }

                                    projectileLevelx = entity.level();
                                    if (!projectileLevelx.isClientSide()) {
                                       Projectile _entityToSpawnxxx = (new Object() {
                                             public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                AbstractArrow entityToSpawn = new GenesisShotEntity(
                                                   (EntityType<? extends GenesisShotEntity>)ArphexModEntities.GENESIS_SHOT.get(), level
                                                );
                                                entityToSpawn.setOwner(shooter);
                                                entityToSpawn.setBaseDamage((double)damage);
                                                entityToSpawn.setKnockback(knockback);
                                                entityToSpawn.setSilent(true);
                                                return entityToSpawn;
                                             }
                                          })
                                          .getArrow(projectileLevelx, entity, 5.0F, 1);
                                       _entityToSpawnxxx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                       _entityToSpawnxxx.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 6.0F, 0.1F);
                                       projectileLevelx.addFreshEntity(_entityToSpawnxxx);
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
                                             "execute as @s run tp @s ~ ~ ~ ~5 ~"
                                          );
                                    }

                                    projectileLevelx = entity.level();
                                    if (!projectileLevelx.isClientSide()) {
                                       Projectile _entityToSpawnxx = (new Object() {
                                             public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                AbstractArrow entityToSpawn = new GenesisShotEntity(
                                                   (EntityType<? extends GenesisShotEntity>)ArphexModEntities.GENESIS_SHOT.get(), level
                                                );
                                                entityToSpawn.setOwner(shooter);
                                                entityToSpawn.setBaseDamage((double)damage);
                                                entityToSpawn.setKnockback(knockback);
                                                entityToSpawn.setSilent(true);
                                                return entityToSpawn;
                                             }
                                          })
                                          .getArrow(projectileLevelx, entity, 5.0F, 1);
                                       _entityToSpawnxx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                       _entityToSpawnxx.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 6.0F, 0.1F);
                                       projectileLevelx.addFreshEntity(_entityToSpawnxx);
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
                                             "execute as @s run tp @s ~ ~ ~ ~5 ~"
                                          );
                                    }

                                    projectileLevelx = entity.level();
                                    if (!projectileLevelx.isClientSide()) {
                                       Projectile _entityToSpawnx = (new Object() {
                                             public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                AbstractArrow entityToSpawn = new GenesisShotEntity(
                                                   (EntityType<? extends GenesisShotEntity>)ArphexModEntities.GENESIS_SHOT.get(), level
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
                                       _entityToSpawnx.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 6.0F, 0.1F);
                                       projectileLevelx.addFreshEntity(_entityToSpawnx);
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
                                             "execute as @s run tp @s ~ ~ ~ ~16 ~"
                                          );
                                    }
                                 }

                                 ArphexMod.queueServerWork(
                                    15,
                                    () -> {
                                       if (!world.isClientSide() && (entity instanceof Mob _mobEntxxxxxxxx ? _mobEntxxxxxxxx.getTarget() : null) != null) {
                                          entity.lookAt(
                                             Anchor.EYES,
                                             new Vec3(
                                                (entity instanceof Mob _mobEntxxxxxxxxxx ? _mobEntxxxxxxxxxx.getTarget() : null).getX(),
                                                (entity instanceof Mob _mobEntxxxxxxxxx ? _mobEntxxxxxxxxx.getTarget() : null).getY() + -3.5,
                                                (entity instanceof Mob _mobEntxxxxxxx ? _mobEntxxxxxxx.getTarget() : null).getZ()
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
                                                   "execute as @s run tp @s ~ ~ ~ ~-10 ~"
                                                );
                                          }

                                          Level projectileLevelxx = entity.level();
                                          if (!projectileLevelxx.isClientSide()) {
                                             Projectile _entityToSpawnxxxxxxxxxx = (new Object() {
                                                   public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                      AbstractArrow entityToSpawn = new GenesisShotEntity(
                                                         (EntityType<? extends GenesisShotEntity>)ArphexModEntities.GENESIS_SHOT.get(), level
                                                      );
                                                      entityToSpawn.setOwner(shooter);
                                                      entityToSpawn.setBaseDamage((double)damage);
                                                      entityToSpawn.setKnockback(knockback);
                                                      entityToSpawn.setSilent(true);
                                                      return entityToSpawn;
                                                   }
                                                })
                                                .getArrow(projectileLevelxx, entity, 5.0F, 1);
                                             _entityToSpawnxxxxxxxxxx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                             _entityToSpawnxxxxxxxxxx.shoot(
                                                entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 5.0F, 0.1F
                                             );
                                             projectileLevelxx.addFreshEntity(_entityToSpawnxxxxxxxxxx);
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
                                                   "execute as @s run tp @s ~ ~ ~ ~5 ~"
                                                );
                                          }

                                          projectileLevelxx = entity.level();
                                          if (!projectileLevelxx.isClientSide()) {
                                             Projectile _entityToSpawnxxxxxxxxx = (new Object() {
                                                   public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                      AbstractArrow entityToSpawn = new GenesisShotEntity(
                                                         (EntityType<? extends GenesisShotEntity>)ArphexModEntities.GENESIS_SHOT.get(), level
                                                      );
                                                      entityToSpawn.setOwner(shooter);
                                                      entityToSpawn.setBaseDamage((double)damage);
                                                      entityToSpawn.setKnockback(knockback);
                                                      entityToSpawn.setSilent(true);
                                                      return entityToSpawn;
                                                   }
                                                })
                                                .getArrow(projectileLevelxx, entity, 5.0F, 1);
                                             _entityToSpawnxxxxxxxxx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                             _entityToSpawnxxxxxxxxx.shoot(
                                                entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 5.0F, 0.1F
                                             );
                                             projectileLevelxx.addFreshEntity(_entityToSpawnxxxxxxxxx);
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
                                                   "execute as @s run tp @s ~ ~ ~ ~5 ~"
                                                );
                                          }

                                          projectileLevelxx = entity.level();
                                          if (!projectileLevelxx.isClientSide()) {
                                             Projectile _entityToSpawnxxxxxxxx = (new Object() {
                                                   public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                      AbstractArrow entityToSpawn = new GenesisShotEntity(
                                                         (EntityType<? extends GenesisShotEntity>)ArphexModEntities.GENESIS_SHOT.get(), level
                                                      );
                                                      entityToSpawn.setOwner(shooter);
                                                      entityToSpawn.setBaseDamage((double)damage);
                                                      entityToSpawn.setKnockback(knockback);
                                                      entityToSpawn.setSilent(true);
                                                      return entityToSpawn;
                                                   }
                                                })
                                                .getArrow(projectileLevelxx, entity, 5.0F, 1);
                                             _entityToSpawnxxxxxxxx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                             _entityToSpawnxxxxxxxx.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 5.0F, 0.1F);
                                             projectileLevelxx.addFreshEntity(_entityToSpawnxxxxxxxx);
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
                                                   "execute as @s run tp @s ~ ~ ~ ~5 ~"
                                                );
                                          }

                                          projectileLevelxx = entity.level();
                                          if (!projectileLevelxx.isClientSide()) {
                                             Projectile _entityToSpawnxxxxxxx = (new Object() {
                                                   public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                      AbstractArrow entityToSpawn = new GenesisShotEntity(
                                                         (EntityType<? extends GenesisShotEntity>)ArphexModEntities.GENESIS_SHOT.get(), level
                                                      );
                                                      entityToSpawn.setOwner(shooter);
                                                      entityToSpawn.setBaseDamage((double)damage);
                                                      entityToSpawn.setKnockback(knockback);
                                                      entityToSpawn.setSilent(true);
                                                      return entityToSpawn;
                                                   }
                                                })
                                                .getArrow(projectileLevelxx, entity, 5.0F, 1);
                                             _entityToSpawnxxxxxxx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                             _entityToSpawnxxxxxxx.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 5.0F, 0.1F);
                                             projectileLevelxx.addFreshEntity(_entityToSpawnxxxxxxx);
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
                                                   "execute as @s run tp @s ~ ~ ~ ~5 ~"
                                                );
                                          }

                                          projectileLevelxx = entity.level();
                                          if (!projectileLevelxx.isClientSide()) {
                                             Projectile _entityToSpawnxxxxxx = (new Object() {
                                                   public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                      AbstractArrow entityToSpawn = new GenesisShotEntity(
                                                         (EntityType<? extends GenesisShotEntity>)ArphexModEntities.GENESIS_SHOT.get(), level
                                                      );
                                                      entityToSpawn.setOwner(shooter);
                                                      entityToSpawn.setBaseDamage((double)damage);
                                                      entityToSpawn.setKnockback(knockback);
                                                      entityToSpawn.setSilent(true);
                                                      return entityToSpawn;
                                                   }
                                                })
                                                .getArrow(projectileLevelxx, entity, 5.0F, 1);
                                             _entityToSpawnxxxxxx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                             _entityToSpawnxxxxxx.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 5.0F, 0.1F);
                                             projectileLevelxx.addFreshEntity(_entityToSpawnxxxxxx);
                                          }

                                          ArphexMod.queueServerWork(
                                             15,
                                             () -> {
                                                if (!world.isClientSide()
                                                   && (entity instanceof Mob _mobEntxxxxxxxxxxxx ? _mobEntxxxxxxxxxxxx.getTarget() : null) != null) {
                                                   entity.lookAt(
                                                      Anchor.EYES,
                                                      new Vec3(
                                                         (entity instanceof Mob _mobEntxxxxxxxxxxxxxx ? _mobEntxxxxxxxxxxxxxx.getTarget() : null).getX(),
                                                         (entity instanceof Mob _mobEntxxxxxxxxxxxxx ? _mobEntxxxxxxxxxxxxx.getTarget() : null).getY() + 3.0,
                                                         (entity instanceof Mob _mobEntxxxxxxxxxxx ? _mobEntxxxxxxxxxxx.getTarget() : null).getZ()
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
                                                            "execute as @s run tp @s ~ ~ ~ ~-10 ~"
                                                         );
                                                   }

                                                   Level projectileLevelxxx = entity.level();
                                                   if (!projectileLevelxxx.isClientSide()) {
                                                      Projectile _entityToSpawnxxxxxxxxxxxxxxx = (new Object() {
                                                            public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                               AbstractArrow entityToSpawn = new GenesisShotEntity(
                                                                  (EntityType<? extends GenesisShotEntity>)ArphexModEntities.GENESIS_SHOT.get(), level
                                                               );
                                                               entityToSpawn.setOwner(shooter);
                                                               entityToSpawn.setBaseDamage((double)damage);
                                                               entityToSpawn.setKnockback(knockback);
                                                               entityToSpawn.setSilent(true);
                                                               return entityToSpawn;
                                                            }
                                                         })
                                                         .getArrow(projectileLevelxxx, entity, 5.0F, 1);
                                                      _entityToSpawnxxxxxxxxxxxxxxx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                                      _entityToSpawnxxxxxxxxxxxxxxx.shoot(
                                                         entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 5.0F, 0.0F
                                                      );
                                                      projectileLevelxxx.addFreshEntity(_entityToSpawnxxxxxxxxxxxxxxx);
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
                                                            "execute as @s run tp @s ~ ~ ~ ~5 ~"
                                                         );
                                                   }

                                                   projectileLevelxxx = entity.level();
                                                   if (!projectileLevelxxx.isClientSide()) {
                                                      Projectile _entityToSpawnxxxxxxxxxxxxxx = (new Object() {
                                                            public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                               AbstractArrow entityToSpawn = new GenesisShotEntity(
                                                                  (EntityType<? extends GenesisShotEntity>)ArphexModEntities.GENESIS_SHOT.get(), level
                                                               );
                                                               entityToSpawn.setOwner(shooter);
                                                               entityToSpawn.setBaseDamage((double)damage);
                                                               entityToSpawn.setKnockback(knockback);
                                                               entityToSpawn.setSilent(true);
                                                               return entityToSpawn;
                                                            }
                                                         })
                                                         .getArrow(projectileLevelxxx, entity, 5.0F, 1);
                                                      _entityToSpawnxxxxxxxxxxxxxx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                                      _entityToSpawnxxxxxxxxxxxxxx.shoot(
                                                         entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 5.0F, 0.0F
                                                      );
                                                      projectileLevelxxx.addFreshEntity(_entityToSpawnxxxxxxxxxxxxxx);
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
                                                            "execute as @s run tp @s ~ ~ ~ ~5 ~"
                                                         );
                                                   }

                                                   projectileLevelxxx = entity.level();
                                                   if (!projectileLevelxxx.isClientSide()) {
                                                      Projectile _entityToSpawnxxxxxxxxxxxxx = (new Object() {
                                                            public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                               AbstractArrow entityToSpawn = new GenesisShotEntity(
                                                                  (EntityType<? extends GenesisShotEntity>)ArphexModEntities.GENESIS_SHOT.get(), level
                                                               );
                                                               entityToSpawn.setOwner(shooter);
                                                               entityToSpawn.setBaseDamage((double)damage);
                                                               entityToSpawn.setKnockback(knockback);
                                                               entityToSpawn.setSilent(true);
                                                               return entityToSpawn;
                                                            }
                                                         })
                                                         .getArrow(projectileLevelxxx, entity, 5.0F, 1);
                                                      _entityToSpawnxxxxxxxxxxxxx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                                      _entityToSpawnxxxxxxxxxxxxx.shoot(
                                                         entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 5.0F, 0.0F
                                                      );
                                                      projectileLevelxxx.addFreshEntity(_entityToSpawnxxxxxxxxxxxxx);
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
                                                            "execute as @s run tp @s ~ ~ ~ ~5 ~"
                                                         );
                                                   }

                                                   projectileLevelxxx = entity.level();
                                                   if (!projectileLevelxxx.isClientSide()) {
                                                      Projectile _entityToSpawnxxxxxxxxxxxx = (new Object() {
                                                            public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                               AbstractArrow entityToSpawn = new GenesisShotEntity(
                                                                  (EntityType<? extends GenesisShotEntity>)ArphexModEntities.GENESIS_SHOT.get(), level
                                                               );
                                                               entityToSpawn.setOwner(shooter);
                                                               entityToSpawn.setBaseDamage((double)damage);
                                                               entityToSpawn.setKnockback(knockback);
                                                               entityToSpawn.setSilent(true);
                                                               return entityToSpawn;
                                                            }
                                                         })
                                                         .getArrow(projectileLevelxxx, entity, 5.0F, 1);
                                                      _entityToSpawnxxxxxxxxxxxx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                                      _entityToSpawnxxxxxxxxxxxx.shoot(
                                                         entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 5.0F, 0.0F
                                                      );
                                                      projectileLevelxxx.addFreshEntity(_entityToSpawnxxxxxxxxxxxx);
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
                                                            "execute as @s run tp @s ~ ~ ~ ~5 ~"
                                                         );
                                                   }

                                                   projectileLevelxxx = entity.level();
                                                   if (!projectileLevelxxx.isClientSide()) {
                                                      Projectile _entityToSpawnxxxxxxxxxxx = (new Object() {
                                                            public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                               AbstractArrow entityToSpawn = new GenesisShotEntity(
                                                                  (EntityType<? extends GenesisShotEntity>)ArphexModEntities.GENESIS_SHOT.get(), level
                                                               );
                                                               entityToSpawn.setOwner(shooter);
                                                               entityToSpawn.setBaseDamage((double)damage);
                                                               entityToSpawn.setKnockback(knockback);
                                                               entityToSpawn.setSilent(true);
                                                               return entityToSpawn;
                                                            }
                                                         })
                                                         .getArrow(projectileLevelxxx, entity, 5.0F, 1);
                                                      _entityToSpawnxxxxxxxxxxx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                                      _entityToSpawnxxxxxxxxxxx.shoot(
                                                         entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 5.0F, 0.0F
                                                      );
                                                      projectileLevelxxx.addFreshEntity(_entityToSpawnxxxxxxxxxxx);
                                                   }

                                                   ArphexMod.queueServerWork(
                                                      15,
                                                      () -> {
                                                         if (!world.isClientSide()
                                                            && (entity instanceof Mob _mobEntxxxxxxxxxxxxxxxx ? _mobEntxxxxxxxxxxxxxxxx.getTarget() : null)
                                                               != null) {
                                                            entity.lookAt(
                                                               Anchor.EYES,
                                                               new Vec3(
                                                                  (entity instanceof Mob _mobEntxxxxxxxxxxxxxxxxxx
                                                                        ? _mobEntxxxxxxxxxxxxxxxxxx.getTarget()
                                                                        : null)
                                                                     .getX(),
                                                                  (entity instanceof Mob _mobEntxxxxxxxxxxxxxxxxx ? _mobEntxxxxxxxxxxxxxxxxx.getTarget() : null)
                                                                        .getY()
                                                                     + 9.0,
                                                                  (entity instanceof Mob _mobEntxxxxxxxxxxxxxxx ? _mobEntxxxxxxxxxxxxxxx.getTarget() : null)
                                                                     .getZ()
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
                                                                     "execute as @s run tp @s ~ ~ ~ ~-10 ~"
                                                                  );
                                                            }

                                                            Level projectileLevelxxxx = entity.level();
                                                            if (!projectileLevelxxxx.isClientSide()) {
                                                               Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                     public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                                        AbstractArrow entityToSpawn = new GenesisShotEntity(
                                                                           (EntityType<? extends GenesisShotEntity>)ArphexModEntities.GENESIS_SHOT.get(), level
                                                                        );
                                                                        entityToSpawn.setOwner(shooter);
                                                                        entityToSpawn.setBaseDamage((double)damage);
                                                                        entityToSpawn.setKnockback(knockback);
                                                                        entityToSpawn.setSilent(true);
                                                                        return entityToSpawn;
                                                                     }
                                                                  })
                                                                  .getArrow(projectileLevelxxxx, entity, 5.0F, 1);
                                                               _entityToSpawnxxxxxxxxxxxxxxxxxxxx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                                               _entityToSpawnxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                  entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 5.0F, 0.1F
                                                               );
                                                               projectileLevelxxxx.addFreshEntity(_entityToSpawnxxxxxxxxxxxxxxxxxxxx);
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
                                                                     "execute as @s run tp @s ~ ~ ~ ~5 ~"
                                                                  );
                                                            }

                                                            projectileLevelxxxx = entity.level();
                                                            if (!projectileLevelxxxx.isClientSide()) {
                                                               Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                     public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                                        AbstractArrow entityToSpawn = new GenesisShotEntity(
                                                                           (EntityType<? extends GenesisShotEntity>)ArphexModEntities.GENESIS_SHOT.get(), level
                                                                        );
                                                                        entityToSpawn.setOwner(shooter);
                                                                        entityToSpawn.setBaseDamage((double)damage);
                                                                        entityToSpawn.setKnockback(knockback);
                                                                        entityToSpawn.setSilent(true);
                                                                        return entityToSpawn;
                                                                     }
                                                                  })
                                                                  .getArrow(projectileLevelxxxx, entity, 5.0F, 1);
                                                               _entityToSpawnxxxxxxxxxxxxxxxxxxx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                                               _entityToSpawnxxxxxxxxxxxxxxxxxxx.shoot(
                                                                  entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 5.0F, 0.1F
                                                               );
                                                               projectileLevelxxxx.addFreshEntity(_entityToSpawnxxxxxxxxxxxxxxxxxxx);
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
                                                                     "execute as @s run tp @s ~ ~ ~ ~5 ~"
                                                                  );
                                                            }

                                                            projectileLevelxxxx = entity.level();
                                                            if (!projectileLevelxxxx.isClientSide()) {
                                                               Projectile _entityToSpawnxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                     public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                                        AbstractArrow entityToSpawn = new GenesisShotEntity(
                                                                           (EntityType<? extends GenesisShotEntity>)ArphexModEntities.GENESIS_SHOT.get(), level
                                                                        );
                                                                        entityToSpawn.setOwner(shooter);
                                                                        entityToSpawn.setBaseDamage((double)damage);
                                                                        entityToSpawn.setKnockback(knockback);
                                                                        entityToSpawn.setSilent(true);
                                                                        return entityToSpawn;
                                                                     }
                                                                  })
                                                                  .getArrow(projectileLevelxxxx, entity, 5.0F, 1);
                                                               _entityToSpawnxxxxxxxxxxxxxxxxxx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                                               _entityToSpawnxxxxxxxxxxxxxxxxxx.shoot(
                                                                  entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 5.0F, 0.1F
                                                               );
                                                               projectileLevelxxxx.addFreshEntity(_entityToSpawnxxxxxxxxxxxxxxxxxx);
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
                                                                     "execute as @s run tp @s ~ ~ ~ ~5 ~"
                                                                  );
                                                            }

                                                            projectileLevelxxxx = entity.level();
                                                            if (!projectileLevelxxxx.isClientSide()) {
                                                               Projectile _entityToSpawnxxxxxxxxxxxxxxxxx = (new Object() {
                                                                     public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                                        AbstractArrow entityToSpawn = new GenesisShotEntity(
                                                                           (EntityType<? extends GenesisShotEntity>)ArphexModEntities.GENESIS_SHOT.get(), level
                                                                        );
                                                                        entityToSpawn.setOwner(shooter);
                                                                        entityToSpawn.setBaseDamage((double)damage);
                                                                        entityToSpawn.setKnockback(knockback);
                                                                        entityToSpawn.setSilent(true);
                                                                        return entityToSpawn;
                                                                     }
                                                                  })
                                                                  .getArrow(projectileLevelxxxx, entity, 5.0F, 1);
                                                               _entityToSpawnxxxxxxxxxxxxxxxxx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                                               _entityToSpawnxxxxxxxxxxxxxxxxx.shoot(
                                                                  entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 5.0F, 0.1F
                                                               );
                                                               projectileLevelxxxx.addFreshEntity(_entityToSpawnxxxxxxxxxxxxxxxxx);
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
                                                                     "execute as @s run tp @s ~ ~ ~ ~5 ~"
                                                                  );
                                                            }

                                                            projectileLevelxxxx = entity.level();
                                                            if (!projectileLevelxxxx.isClientSide()) {
                                                               Projectile _entityToSpawnxxxxxxxxxxxxxxxx = (new Object() {
                                                                     public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                                        AbstractArrow entityToSpawn = new GenesisShotEntity(
                                                                           (EntityType<? extends GenesisShotEntity>)ArphexModEntities.GENESIS_SHOT.get(), level
                                                                        );
                                                                        entityToSpawn.setOwner(shooter);
                                                                        entityToSpawn.setBaseDamage((double)damage);
                                                                        entityToSpawn.setKnockback(knockback);
                                                                        entityToSpawn.setSilent(true);
                                                                        return entityToSpawn;
                                                                     }
                                                                  })
                                                                  .getArrow(projectileLevelxxxx, entity, 5.0F, 1);
                                                               _entityToSpawnxxxxxxxxxxxxxxxx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                                               _entityToSpawnxxxxxxxxxxxxxxxx.shoot(
                                                                  entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 5.0F, 0.1F
                                                               );
                                                               projectileLevelxxxx.addFreshEntity(_entityToSpawnxxxxxxxxxxxxxxxx);
                                                            }

                                                            if ((entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)
                                                               < (entity instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F) / 2.0F) {
                                                               ArphexMod.queueServerWork(
                                                                  10,
                                                                  () -> {
                                                                     if (!world.isClientSide()
                                                                        && (
                                                                              entity instanceof Mob _mobEntxxxxxxxxxxxxxxxxxxxx
                                                                                 ? _mobEntxxxxxxxxxxxxxxxxxxxx.getTarget()
                                                                                 : null
                                                                           )
                                                                           != null) {
                                                                        entity.lookAt(
                                                                           Anchor.EYES,
                                                                           new Vec3(
                                                                              (entity instanceof Mob _mobEntxxxxxxxxxxxxxxxxxxxxxx
                                                                                    ? _mobEntxxxxxxxxxxxxxxxxxxxxxx.getTarget()
                                                                                    : null)
                                                                                 .getX(),
                                                                              (entity instanceof Mob _mobEntxxxxxxxxxxxxxxxxxxxxx
                                                                                       ? _mobEntxxxxxxxxxxxxxxxxxxxxx.getTarget()
                                                                                       : null)
                                                                                    .getY()
                                                                                 + 15.0,
                                                                              (entity instanceof Mob _mobEntxxxxxxxxxxxxxxxxxxx
                                                                                    ? _mobEntxxxxxxxxxxxxxxxxxxx.getTarget()
                                                                                    : null)
                                                                                 .getZ()
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
                                                                                 "execute as @s run tp @s ~ ~ ~ ~-10 ~"
                                                                              );
                                                                        }

                                                                        Level projectileLevelxxxxx = entity.level();
                                                                        if (!projectileLevelxxxxx.isClientSide()) {
                                                                           Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                 public Projectile getArrow(
                                                                                    Level level, Entity shooter, float damage, int knockback
                                                                                 ) {
                                                                                    AbstractArrow entityToSpawn = new GenesisShotEntity(
                                                                                       (EntityType<? extends GenesisShotEntity>)ArphexModEntities.GENESIS_SHOT
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
                                                                              .getArrow(projectileLevelxxxxx, entity, 5.0F, 1);
                                                                           _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                              entity.getX(), entity.getEyeY() - 0.1, entity.getZ()
                                                                           );
                                                                           _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                              entity.getLookAngle().x,
                                                                              entity.getLookAngle().y,
                                                                              entity.getLookAngle().z,
                                                                              6.0F,
                                                                              0.1F
                                                                           );
                                                                           projectileLevelxxxxx.addFreshEntity(_entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxx);
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
                                                                                 "execute as @s run tp @s ~ ~ ~ ~5 ~"
                                                                              );
                                                                        }

                                                                        projectileLevelxxxxx = entity.level();
                                                                        if (!projectileLevelxxxxx.isClientSide()) {
                                                                           Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                 public Projectile getArrow(
                                                                                    Level level, Entity shooter, float damage, int knockback
                                                                                 ) {
                                                                                    AbstractArrow entityToSpawn = new GenesisShotEntity(
                                                                                       (EntityType<? extends GenesisShotEntity>)ArphexModEntities.GENESIS_SHOT
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
                                                                              .getArrow(projectileLevelxxxxx, entity, 5.0F, 1);
                                                                           _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                              entity.getX(), entity.getEyeY() - 0.1, entity.getZ()
                                                                           );
                                                                           _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                              entity.getLookAngle().x,
                                                                              entity.getLookAngle().y,
                                                                              entity.getLookAngle().z,
                                                                              6.0F,
                                                                              0.1F
                                                                           );
                                                                           projectileLevelxxxxx.addFreshEntity(_entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxx);
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
                                                                                 "execute as @s run tp @s ~ ~ ~ ~5 ~"
                                                                              );
                                                                        }

                                                                        projectileLevelxxxxx = entity.level();
                                                                        if (!projectileLevelxxxxx.isClientSide()) {
                                                                           Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                 public Projectile getArrow(
                                                                                    Level level, Entity shooter, float damage, int knockback
                                                                                 ) {
                                                                                    AbstractArrow entityToSpawn = new GenesisShotEntity(
                                                                                       (EntityType<? extends GenesisShotEntity>)ArphexModEntities.GENESIS_SHOT
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
                                                                              .getArrow(projectileLevelxxxxx, entity, 5.0F, 1);
                                                                           _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                              entity.getX(), entity.getEyeY() - 0.1, entity.getZ()
                                                                           );
                                                                           _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                              entity.getLookAngle().x,
                                                                              entity.getLookAngle().y,
                                                                              entity.getLookAngle().z,
                                                                              6.0F,
                                                                              0.1F
                                                                           );
                                                                           projectileLevelxxxxx.addFreshEntity(_entityToSpawnxxxxxxxxxxxxxxxxxxxxxxx);
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
                                                                                 "execute as @s run tp @s ~ ~ ~ ~5 ~"
                                                                              );
                                                                        }

                                                                        projectileLevelxxxxx = entity.level();
                                                                        if (!projectileLevelxxxxx.isClientSide()) {
                                                                           Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                 public Projectile getArrow(
                                                                                    Level level, Entity shooter, float damage, int knockback
                                                                                 ) {
                                                                                    AbstractArrow entityToSpawn = new GenesisShotEntity(
                                                                                       (EntityType<? extends GenesisShotEntity>)ArphexModEntities.GENESIS_SHOT
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
                                                                              .getArrow(projectileLevelxxxxx, entity, 5.0F, 1);
                                                                           _entityToSpawnxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                              entity.getX(), entity.getEyeY() - 0.1, entity.getZ()
                                                                           );
                                                                           _entityToSpawnxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                              entity.getLookAngle().x,
                                                                              entity.getLookAngle().y,
                                                                              entity.getLookAngle().z,
                                                                              6.0F,
                                                                              0.1F
                                                                           );
                                                                           projectileLevelxxxxx.addFreshEntity(_entityToSpawnxxxxxxxxxxxxxxxxxxxxxx);
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
                                                                                 "execute as @s run tp @s ~ ~ ~ ~5 ~"
                                                                              );
                                                                        }

                                                                        projectileLevelxxxxx = entity.level();
                                                                        if (!projectileLevelxxxxx.isClientSide()) {
                                                                           Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                 public Projectile getArrow(
                                                                                    Level level, Entity shooter, float damage, int knockback
                                                                                 ) {
                                                                                    AbstractArrow entityToSpawn = new GenesisShotEntity(
                                                                                       (EntityType<? extends GenesisShotEntity>)ArphexModEntities.GENESIS_SHOT
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
                                                                              .getArrow(projectileLevelxxxxx, entity, 5.0F, 1);
                                                                           _entityToSpawnxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                              entity.getX(), entity.getEyeY() - 0.1, entity.getZ()
                                                                           );
                                                                           _entityToSpawnxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                              entity.getLookAngle().x,
                                                                              entity.getLookAngle().y,
                                                                              entity.getLookAngle().z,
                                                                              6.0F,
                                                                              0.1F
                                                                           );
                                                                           projectileLevelxxxxx.addFreshEntity(_entityToSpawnxxxxxxxxxxxxxxxxxxxxx);
                                                                        }

                                                                        ArphexMod.queueServerWork(
                                                                           10,
                                                                           () -> {
                                                                              if (!world.isClientSide()
                                                                                 && (
                                                                                       entity instanceof Mob _mobEntxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                          ? _mobEntxxxxxxxxxxxxxxxxxxxxxxxx.getTarget()
                                                                                          : null
                                                                                    )
                                                                                    != null) {
                                                                                 entity.lookAt(
                                                                                    Anchor.EYES,
                                                                                    new Vec3(
                                                                                       (entity instanceof Mob _mobEntxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                             ? _mobEntxxxxxxxxxxxxxxxxxxxxxxxxxx.getTarget()
                                                                                             : null)
                                                                                          .getX(),
                                                                                       (entity instanceof Mob _mobEntxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                ? _mobEntxxxxxxxxxxxxxxxxxxxxxxxxx.getTarget()
                                                                                                : null)
                                                                                             .getY()
                                                                                          + 21.0,
                                                                                       (entity instanceof Mob _mobEntxxxxxxxxxxxxxxxxxxxxxxx
                                                                                             ? _mobEntxxxxxxxxxxxxxxxxxxxxxxx.getTarget()
                                                                                             : null)
                                                                                          .getZ()
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
                                                                                             entity.level() instanceof ServerLevel
                                                                                                ? (ServerLevel)entity.level()
                                                                                                : null,
                                                                                             4,
                                                                                             entity.getName().getString(),
                                                                                             entity.getDisplayName(),
                                                                                             entity.level().getServer(),
                                                                                             entity
                                                                                          ),
                                                                                          "execute as @s run tp @s ~ ~ ~ ~-10 ~"
                                                                                       );
                                                                                 }

                                                                                 Level projectileLevelxxxxxx = entity.level();
                                                                                 if (!projectileLevelxxxxxx.isClientSide()) {
                                                                                    Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                          public Projectile getArrow(
                                                                                             Level level, Entity shooter, float damage, int knockback
                                                                                          ) {
                                                                                             AbstractArrow entityToSpawn = new GenesisShotEntity(
                                                                                                (EntityType<? extends GenesisShotEntity>)ArphexModEntities.GENESIS_SHOT
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
                                                                                    _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                       entity.getX(), entity.getEyeY() - 0.1, entity.getZ()
                                                                                    );
                                                                                    _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                       entity.getLookAngle().x,
                                                                                       entity.getLookAngle().y,
                                                                                       entity.getLookAngle().z,
                                                                                       6.0F,
                                                                                       0.1F
                                                                                    );
                                                                                    projectileLevelxxxxxx.addFreshEntity(
                                                                                       _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
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
                                                                                             entity.level() instanceof ServerLevel
                                                                                                ? (ServerLevel)entity.level()
                                                                                                : null,
                                                                                             4,
                                                                                             entity.getName().getString(),
                                                                                             entity.getDisplayName(),
                                                                                             entity.level().getServer(),
                                                                                             entity
                                                                                          ),
                                                                                          "execute as @s run tp @s ~ ~ ~ ~5 ~"
                                                                                       );
                                                                                 }

                                                                                 projectileLevelxxxxxx = entity.level();
                                                                                 if (!projectileLevelxxxxxx.isClientSide()) {
                                                                                    Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                          public Projectile getArrow(
                                                                                             Level level, Entity shooter, float damage, int knockback
                                                                                          ) {
                                                                                             AbstractArrow entityToSpawn = new GenesisShotEntity(
                                                                                                (EntityType<? extends GenesisShotEntity>)ArphexModEntities.GENESIS_SHOT
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
                                                                                    _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                       entity.getX(), entity.getEyeY() - 0.1, entity.getZ()
                                                                                    );
                                                                                    _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                       entity.getLookAngle().x,
                                                                                       entity.getLookAngle().y,
                                                                                       entity.getLookAngle().z,
                                                                                       6.0F,
                                                                                       0.1F
                                                                                    );
                                                                                    projectileLevelxxxxxx.addFreshEntity(
                                                                                       _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
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
                                                                                             entity.level() instanceof ServerLevel
                                                                                                ? (ServerLevel)entity.level()
                                                                                                : null,
                                                                                             4,
                                                                                             entity.getName().getString(),
                                                                                             entity.getDisplayName(),
                                                                                             entity.level().getServer(),
                                                                                             entity
                                                                                          ),
                                                                                          "execute as @s run tp @s ~ ~ ~ ~5 ~"
                                                                                       );
                                                                                 }

                                                                                 projectileLevelxxxxxx = entity.level();
                                                                                 if (!projectileLevelxxxxxx.isClientSide()) {
                                                                                    Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                          public Projectile getArrow(
                                                                                             Level level, Entity shooter, float damage, int knockback
                                                                                          ) {
                                                                                             AbstractArrow entityToSpawn = new GenesisShotEntity(
                                                                                                (EntityType<? extends GenesisShotEntity>)ArphexModEntities.GENESIS_SHOT
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
                                                                                    _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                       entity.getX(), entity.getEyeY() - 0.1, entity.getZ()
                                                                                    );
                                                                                    _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                       entity.getLookAngle().x,
                                                                                       entity.getLookAngle().y,
                                                                                       entity.getLookAngle().z,
                                                                                       6.0F,
                                                                                       0.1F
                                                                                    );
                                                                                    projectileLevelxxxxxx.addFreshEntity(
                                                                                       _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxxx
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
                                                                                             entity.level() instanceof ServerLevel
                                                                                                ? (ServerLevel)entity.level()
                                                                                                : null,
                                                                                             4,
                                                                                             entity.getName().getString(),
                                                                                             entity.getDisplayName(),
                                                                                             entity.level().getServer(),
                                                                                             entity
                                                                                          ),
                                                                                          "execute as @s run tp @s ~ ~ ~ ~5 ~"
                                                                                       );
                                                                                 }

                                                                                 projectileLevelxxxxxx = entity.level();
                                                                                 if (!projectileLevelxxxxxx.isClientSide()) {
                                                                                    Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                          public Projectile getArrow(
                                                                                             Level level, Entity shooter, float damage, int knockback
                                                                                          ) {
                                                                                             AbstractArrow entityToSpawn = new GenesisShotEntity(
                                                                                                (EntityType<? extends GenesisShotEntity>)ArphexModEntities.GENESIS_SHOT
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
                                                                                    _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                       entity.getX(), entity.getEyeY() - 0.1, entity.getZ()
                                                                                    );
                                                                                    _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                       entity.getLookAngle().x,
                                                                                       entity.getLookAngle().y,
                                                                                       entity.getLookAngle().z,
                                                                                       6.0F,
                                                                                       0.1F
                                                                                    );
                                                                                    projectileLevelxxxxxx.addFreshEntity(
                                                                                       _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxxx
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
                                                                                             entity.level() instanceof ServerLevel
                                                                                                ? (ServerLevel)entity.level()
                                                                                                : null,
                                                                                             4,
                                                                                             entity.getName().getString(),
                                                                                             entity.getDisplayName(),
                                                                                             entity.level().getServer(),
                                                                                             entity
                                                                                          ),
                                                                                          "execute as @s run tp @s ~ ~ ~ ~5 ~"
                                                                                       );
                                                                                 }

                                                                                 projectileLevelxxxxxx = entity.level();
                                                                                 if (!projectileLevelxxxxxx.isClientSide()) {
                                                                                    Projectile _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxx = (new Object() {
                                                                                          public Projectile getArrow(
                                                                                             Level level, Entity shooter, float damage, int knockback
                                                                                          ) {
                                                                                             AbstractArrow entityToSpawn = new GenesisShotEntity(
                                                                                                (EntityType<? extends GenesisShotEntity>)ArphexModEntities.GENESIS_SHOT
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
                                                                                    _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxx.setPos(
                                                                                       entity.getX(), entity.getEyeY() - 0.1, entity.getZ()
                                                                                    );
                                                                                    _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxx.shoot(
                                                                                       entity.getLookAngle().x,
                                                                                       entity.getLookAngle().y,
                                                                                       entity.getLookAngle().z,
                                                                                       6.0F,
                                                                                       0.1F
                                                                                    );
                                                                                    projectileLevelxxxxxx.addFreshEntity(
                                                                                       _entityToSpawnxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                    );
                                                                                 }
                                                                              }
                                                                           }
                                                                        );
                                                                     }
                                                                  }
                                                               );
                                                            }
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
                     }

                     if ((entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)
                        < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 2.0F) {
                        if (entity instanceof DiabolosDecimatorEntity _datEntSetI) {
                           _datEntSetI.getEntityData().set(DiabolosDecimatorEntity.DATA_flash, 50);
                        }
                     } else if (entity instanceof DiabolosDecimatorEntity _datEntSetI) {
                        _datEntSetI.getEntityData().set(DiabolosDecimatorEntity.DATA_flash, 100);
                     }
                  } else if (entity instanceof DiabolosDecimatorEntity _datEntSetI) {
                     _datEntSetI.getEntityData()
                        .set(
                           DiabolosDecimatorEntity.DATA_flash,
                           (
                                 entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxx
                                    ? (Integer)_datEntIxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_flash)
                                    : 0
                              )
                              - 1
                        );
                  }
               } else if ((
                     entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxx
                        ? (Integer)_datEntIxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_current_final)
                        : 0
                  )
                  == 5) {
                  if ((entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null) != null) {
                     if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getHealth() : -1.0F)
                        < (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMaxHealth() : -1.0F) / 2.0F) {
                        if ((
                              entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxx
                                 ? (Integer)_datEntIxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_flash)
                                 : 0
                           )
                           <= 0) {
                           if ((entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getHealth() : -1.0F)
                              < (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMaxHealth() : -1.0F) / 2.0F) {
                              if (world instanceof ServerLevel projectileLevel) {
                                 Projectile _entityToSpawn = (new Object() {
                                       public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                          AbstractArrow entityToSpawn = new GravitonShotEntity(
                                             (EntityType<? extends GravitonShotEntity>)ArphexModEntities.GRAVITON_SHOT.get(), level
                                          );
                                          entityToSpawn.setOwner(shooter);
                                          entityToSpawn.setBaseDamage((double)damage);
                                          entityToSpawn.setKnockback(knockback);
                                          entityToSpawn.setSilent(true);
                                          return entityToSpawn;
                                       }
                                    })
                                    .getArrow(projectileLevel, entity, 5.0F, 1);
                                 _entityToSpawn.setPos(entity.getX(), entity.getY(), entity.getZ());
                                 _entityToSpawn.shoot(0.8, 0.8, 0.0, 1.5F, 0.0F);
                                 projectileLevel.addFreshEntity(_entityToSpawn);
                              }

                              if (world instanceof ServerLevel projectileLevel) {
                                 Projectile _entityToSpawn = (new Object() {
                                       public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                          AbstractArrow entityToSpawn = new GravitonShotEntity(
                                             (EntityType<? extends GravitonShotEntity>)ArphexModEntities.GRAVITON_SHOT.get(), level
                                          );
                                          entityToSpawn.setOwner(shooter);
                                          entityToSpawn.setBaseDamage((double)damage);
                                          entityToSpawn.setKnockback(knockback);
                                          entityToSpawn.setSilent(true);
                                          return entityToSpawn;
                                       }
                                    })
                                    .getArrow(projectileLevel, entity, 5.0F, 1);
                                 _entityToSpawn.setPos(entity.getX(), entity.getY(), entity.getZ());
                                 _entityToSpawn.shoot(0.0, 0.8, 0.8, 1.5F, 0.0F);
                                 projectileLevel.addFreshEntity(_entityToSpawn);
                              }

                              if (world instanceof ServerLevel projectileLevel) {
                                 Projectile _entityToSpawn = (new Object() {
                                       public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                          AbstractArrow entityToSpawn = new GravitonShotEntity(
                                             (EntityType<? extends GravitonShotEntity>)ArphexModEntities.GRAVITON_SHOT.get(), level
                                          );
                                          entityToSpawn.setOwner(shooter);
                                          entityToSpawn.setBaseDamage((double)damage);
                                          entityToSpawn.setKnockback(knockback);
                                          entityToSpawn.setSilent(true);
                                          return entityToSpawn;
                                       }
                                    })
                                    .getArrow(projectileLevel, entity, 5.0F, 1);
                                 _entityToSpawn.setPos(entity.getX(), entity.getY(), entity.getZ());
                                 _entityToSpawn.shoot(0.0, 0.8, -0.8, 1.5F, 0.0F);
                                 projectileLevel.addFreshEntity(_entityToSpawn);
                              }

                              if (world instanceof ServerLevel projectileLevel) {
                                 Projectile _entityToSpawn = (new Object() {
                                       public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                          AbstractArrow entityToSpawn = new GravitonShotEntity(
                                             (EntityType<? extends GravitonShotEntity>)ArphexModEntities.GRAVITON_SHOT.get(), level
                                          );
                                          entityToSpawn.setOwner(shooter);
                                          entityToSpawn.setBaseDamage((double)damage);
                                          entityToSpawn.setKnockback(knockback);
                                          entityToSpawn.setSilent(true);
                                          return entityToSpawn;
                                       }
                                    })
                                    .getArrow(projectileLevel, entity, 5.0F, 1);
                                 _entityToSpawn.setPos(entity.getX(), entity.getY(), entity.getZ());
                                 _entityToSpawn.shoot(-0.8, 0.8, 0.0, 1.5F, 0.0F);
                                 projectileLevel.addFreshEntity(_entityToSpawn);
                              }
                           }

                           if (entity instanceof DiabolosDecimatorEntity _datEntSetI) {
                              _datEntSetI.getEntityData().set(DiabolosDecimatorEntity.DATA_flash, 80);
                           }
                        } else if (entity instanceof DiabolosDecimatorEntity _datEntSetI) {
                           _datEntSetI.getEntityData()
                              .set(
                                 DiabolosDecimatorEntity.DATA_flash,
                                 (
                                       entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxx
                                          ? (Integer)_datEntIxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_flash)
                                          : 0
                                    )
                                    - 1
                              );
                        }
                     }

                     entity.setDeltaMovement(new Vec3(0.0, entity.getDeltaMovement().y(), 0.0));
                     if ((
                           entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxx
                              ? (Integer)_datEntIxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_attack_switch_time)
                              : 0
                        )
                        > 180) {
                        if ((
                              entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxxxx
                                 ? (Integer)_datEntIxxxxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_size_num)
                                 : 0
                           )
                           < 5000) {
                           if (entity instanceof DiabolosDecimatorEntity _datEntSetI) {
                              _datEntSetI.getEntityData()
                                 .set(
                                    DiabolosDecimatorEntity.DATA_size_num,
                                    (
                                          entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxxxxx
                                             ? (Integer)_datEntIxxxxxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_size_num)
                                             : 0
                                       )
                                       + 10
                                 );
                           }

                           entity.getPersistentData().putBoolean("allow_blackhole_summon", true);
                        } else if (entity.getPersistentData().getBoolean("allow_blackhole_summon")) {
                           entity.getPersistentData().putBoolean("allow_blackhole_summon", false);
                           if (world instanceof ServerLevel _levelx) {
                              Entity entityToSpawn = ((EntityType)ArphexModEntities.SPHERE_ANIM.get())
                                 .spawn(_levelx, BlockPos.containing(x, y + 50.0, z), MobSpawnType.MOB_SUMMONED);
                              if (entityToSpawn != null) {
                                 entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                              }
                           }

                           ArphexMod.queueServerWork(
                              2,
                              () -> {
                                 if (!world.getEntitiesOfClass(SphereAnimEntity.class, AABB.ofSize(new Vec3(x, y + 50.0, z), 30.0, 30.0, 30.0), e -> true)
                                    .isEmpty()) {
                                    Entity patt123034$temp = world.getEntitiesOfClass(
                                          SphereAnimEntity.class, AABB.ofSize(new Vec3(x, y + 50.0, z), 30.0, 30.0, 30.0), e -> true
                                       )
                                       .stream()
                                       .sorted((new Object() {
                                          Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                             return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                          }
                                       }).compareDistOf(x, y + 50.0, z))
                                       .findFirst()
                                       .orElse(null);
                                    if (patt123034$temp instanceof SphereAnimEntity _datEntSetL) {
                                       _datEntSetL.getEntityData().set(SphereAnimEntity.DATA_black_hole, true);
                                    }
                                 }
                              }
                           );
                        }
                     } else if (entity instanceof DiabolosDecimatorEntity _datEntSetI) {
                        _datEntSetI.getEntityData()
                           .set(
                              DiabolosDecimatorEntity.DATA_size_num,
                              (
                                    entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxxxx
                                       ? (Integer)_datEntIxxxxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_size_num)
                                       : 0
                                 )
                                 - 10
                           );
                     }
                  }
               } else if (var103 != null) {
                  if ((
                        entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxxxx
                           ? (Integer)_datEntIxxxxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_flash)
                           : 0
                     )
                     <= 0) {
                     if (world.getEntitiesOfClass(
                           SlowLookTestEntity.class, AABB.ofSize(new Vec3(entity.getX(), entity.getY() + 15.0, entity.getZ()), 15.0, 15.0, 15.0), e -> true
                        )
                        .isEmpty()) {
                        if ((
                                 entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxxxxx
                                    ? (Integer)_datEntIxxxxxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_size_num)
                                    : 0
                              )
                              <= 1000
                           && world instanceof ServerLevel _levelxx) {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.SLOW_LOOK_TEST.get())
                              .spawn(_levelxx, BlockPos.containing(entity.getX(), entity.getY() + 15.0, entity.getZ()), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawn != null) {
                              entityToSpawn.setYRot(entity.getYRot());
                              entityToSpawn.setYBodyRot(entity.getYRot());
                              entityToSpawn.setYHeadRot(entity.getYRot());
                              entityToSpawn.setXRot(entity.getXRot());
                           }
                        }

                        if ((entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getHealth() : -1.0F)
                              < (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMaxHealth() : -1.0F) / 2.0F
                           || (
                                 entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxxxxxx
                                    ? (Integer)_datEntIxxxxxxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_size_num)
                                    : 0
                              )
                              > 1000) {
                           if (world instanceof ServerLevel _levelxxx) {
                              Entity entityToSpawn = ((EntityType)ArphexModEntities.DIABOLOS_DECIMATOR_CLONE.get())
                                 .spawn(_levelxxx, BlockPos.containing(var103.getX() + 30.0, var103.getY(), var103.getZ()), MobSpawnType.MOB_SUMMONED);
                              if (entityToSpawn != null) {
                                 entityToSpawn.setYRot(entity.getYRot());
                                 entityToSpawn.setYBodyRot(entity.getYRot());
                                 entityToSpawn.setYHeadRot(entity.getYRot());
                                 entityToSpawn.setXRot(entity.getXRot());
                              }
                           }

                           if (world instanceof ServerLevel _levelxxxx) {
                              Entity entityToSpawn = ((EntityType)ArphexModEntities.DIABOLOS_DECIMATOR_CLONE.get())
                                 .spawn(_levelxxxx, BlockPos.containing(var103.getX() - 30.0, var103.getY(), var103.getZ()), MobSpawnType.MOB_SUMMONED);
                              if (entityToSpawn != null) {
                                 entityToSpawn.setYRot(entity.getYRot());
                                 entityToSpawn.setYBodyRot(entity.getYRot());
                                 entityToSpawn.setYHeadRot(entity.getYRot());
                                 entityToSpawn.setXRot(entity.getXRot());
                              }
                           }
                        }

                        if (entity instanceof DiabolosDecimatorEntity _datEntSetI) {
                           _datEntSetI.getEntityData().set(DiabolosDecimatorEntity.DATA_flash, 400);
                        }
                     }
                  } else if (entity instanceof DiabolosDecimatorEntity _datEntSetI) {
                     _datEntSetI.getEntityData()
                        .set(
                           DiabolosDecimatorEntity.DATA_flash,
                           (
                                 entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxxxxxx
                                    ? (Integer)_datEntIxxxxxxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_flash)
                                    : 0
                              )
                              - 1
                        );
                  }
               }

               if ((
                        entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxxxxxx
                           ? (Integer)_datEntIxxxxxxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_current_final)
                           : 0
                     )
                     != 1
                  && entity instanceof DiabolosDecimatorEntity _datEntSetI) {
                  _datEntSetI.getEntityData().set(DiabolosDecimatorEntity.DATA_lunge_time, 0);
               }
            }

            if ((
                  entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxxxxxx
                     ? (Integer)_datEntIxxxxxxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_current_final)
                     : 0
               )
               != 2) {
               if (entity instanceof DiabolosDecimatorEntity _datEntSetI) {
                  _datEntSetI.getEntityData().set(DiabolosDecimatorEntity.DATA_float_time, 0);
               }

               entity.getPersistentData().putBoolean("chrono_effects", false);
               if (entity instanceof DiabolosDecimatorEntity spider) {
                  spider.getPersistentData().putString("glowTexture", "diabolos_glow");
               }

               if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != Blocks.VOID_AIR && !entity.isInWall()) {
                  entity.noPhysics = false;
               } else {
                  entity.setDeltaMovement(new Vec3(0.0, 0.5, 0.0));
                  entity.noPhysics = true;
               }
            }

            if ((entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getHealth() : -1.0F)
               > (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMaxHealth() : -1.0F) / 2.0F) {
               if (entity instanceof DiabolosDecimatorEntity animatable) {
                  animatable.setTexture("diabolos_decimator");
               }
            } else if (entity instanceof DiabolosDecimatorEntity animatable) {
               animatable.setTexture("diabolos_dark");
            }

            if ((
                  entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxxxxxx
                     ? (Integer)_datEntIxxxxxxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_current_final)
                     : 0
               )
               == 5) {
               entity.setDeltaMovement(new Vec3(0.0, -1.0, 0.0));
            } else if ((
                  entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxxxxxx
                     ? (Integer)_datEntIxxxxxxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_size_num)
                     : 0
               )
               > 1000) {
               if (entity instanceof DiabolosDecimatorEntity _datEntSetI) {
                  _datEntSetI.getEntityData()
                     .set(
                        DiabolosDecimatorEntity.DATA_size_num,
                        (
                              entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxxxxxxx
                                 ? (Integer)_datEntIxxxxxxxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_size_num)
                                 : 0
                           )
                           - 10
                     );
               }
            } else if (entity instanceof DiabolosDecimatorEntity _datEntSetI) {
               _datEntSetI.getEntityData().set(DiabolosDecimatorEntity.DATA_size_num, 1000);
            }

            if ((
                     entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxxxxxxx
                        ? (Integer)_datEntIxxxxxxxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_time_since_landing_attack)
                        : 0
                  )
                  < 400
               && entity instanceof DiabolosDecimatorEntity _datEntSetI) {
               _datEntSetI.getEntityData()
                  .set(
                     DiabolosDecimatorEntity.DATA_time_since_landing_attack,
                     (
                           entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxxxxxxxx
                              ? (Integer)_datEntIxxxxxxxxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_time_since_landing_attack)
                              : 0
                        )
                        + 1
                  );
            }

            if ((entity instanceof LivingEntity _livEntxxxxxxx ? _livEntxxxxxxx.getHealth() : -1.0F)
                  < (entity instanceof LivingEntity _livEntxxxxxx ? _livEntxxxxxx.getMaxHealth() : -1.0F) / 2.0F
               && (
                     entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxxxxxxxx
                        ? (Integer)_datEntIxxxxxxxxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_lunge_time)
                        : 0
                  )
                  < 300
               && (
                     entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxxxxxxx
                        ? (Integer)_datEntIxxxxxxxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_lunge_time)
                        : 0
                  )
                  > 3
               && entity instanceof DiabolosDecimatorEntity _datEntSetI) {
               _datEntSetI.getEntityData().set(DiabolosDecimatorEntity.DATA_lunge_time, 1);
            }

            if (entity.getPersistentData().getDouble("health_loss_limit") - 10.0
               > (double)(entity instanceof LivingEntity _livEntxxxxxx ? _livEntxxxxxx.getHealth() : -1.0F)) {
               if ((entity instanceof LivingEntity _livEntxxxxxxx ? _livEntxxxxxxx.getHealth() : -1.0F) > 0.0F && entity instanceof LivingEntity _entity) {
                  _entity.setHealth((float)(entity.getPersistentData().getDouble("health_loss_limit") - 10.0));
               }

               entity.getPersistentData().putDouble("health_loss_limit", entity.getPersistentData().getDouble("health_loss_limit") - 10.0);
            } else {
               entity.getPersistentData()
                  .putDouble("health_loss_limit", entity instanceof LivingEntity _livEntxxxxxx ? (double)_livEntxxxxxx.getHealth() : -1.0);
            }

            if (!world.isClientSide()) {
               if ((
                     entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxxxxxxx
                        ? (Integer)_datEntIxxxxxxxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_attack_switch_time)
                        : 0
                  )
                  > 0) {
                  if (entity instanceof DiabolosDecimatorEntity _datEntSetI) {
                     _datEntSetI.getEntityData()
                        .set(
                           DiabolosDecimatorEntity.DATA_attack_switch_time,
                           (
                                 entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxxxxxxxx
                                    ? (Integer)_datEntIxxxxxxxxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_attack_switch_time)
                                    : 0
                              )
                              - 1
                        );
                  }
               } else {
                  if (entity instanceof DiabolosDecimatorEntity _datEntSetI) {
                     _datEntSetI.getEntityData().set(DiabolosDecimatorEntity.DATA_attack_switch_time, 600);
                  }

                  if ((
                        entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxxxxxxxx
                           ? (Integer)_datEntIxxxxxxxxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_shuffle_number)
                           : 0
                     )
                     <= 1) {
                     if (entity instanceof DiabolosDecimatorEntity _datEntSetI) {
                        _datEntSetI.getEntityData().set(DiabolosDecimatorEntity.DATA_shuffle_number, 6);
                     }

                     order_random = "";
                     step_count = entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxxxxxxxxx
                        ? (double)((Integer)_datEntIxxxxxxxxxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_shuffle_number)).intValue()
                        : 0.0;

                     for (int index3 = 0; index3 < 100; index3++) {
                        num_iterate = (double)Math.round((float)Mth.nextInt(RandomSource.create(), 1, (int)step_count));
                        if (!((double)order_random.length() < step_count)) {
                           break;
                        }

                        if (!order_random.contains(new DecimalFormat("##.##").format(Math.round(num_iterate)).strip())) {
                           order_random = order_random + Math.round(num_iterate);
                        }
                     }

                     if (entity instanceof DiabolosDecimatorEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(DiabolosDecimatorEntity.DATA_shuffle, order_random);
                     }
                  } else if (entity instanceof DiabolosDecimatorEntity _datEntSetI) {
                     _datEntSetI.getEntityData()
                        .set(
                           DiabolosDecimatorEntity.DATA_shuffle_number,
                           (
                                 entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxxxxxxxx
                                    ? (Integer)_datEntIxxxxxxxxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_shuffle_number)
                                    : 0
                              )
                              - 1
                        );
                  }

                  if (entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxxxxxxxx) {
                     double var518 = (double)((Integer)_datEntIxxxxxxxxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_shuffle_number))
                        .intValue();
                  } else {
                     double var519 = 0.0;
                  }

                  if (entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxxxxxxxx) {
                     double var520 = (double)((Integer)_datEntIxxxxxxxxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_shuffle_number))
                        .intValue();
                  } else {
                     double var521 = 0.0;
                  }

                  position_to_check = entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxxxxxxxx
                     ? (double)((Integer)_datEntIxxxxxxxxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_shuffle_number)).intValue()
                     : 0.0;
                  order_random = entity instanceof DiabolosDecimatorEntity _datEntS
                     ? (String)_datEntS.getEntityData().get(DiabolosDecimatorEntity.DATA_shuffle)
                     : "";
                  step_count = 6.0;
                  lock_steps = position_to_check;

                  for (int index4 = 0; index4 < (int)lock_steps; index4++) {
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
                  if (entity instanceof DiabolosDecimatorEntity _datEntSetI) {
                     _datEntSetI.getEntityData().set(DiabolosDecimatorEntity.DATA_current_final, (int)num_iterate);
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
                  && !(entityiteratorx instanceof GravitonShotEntity)
                  && !(entityiteratorx instanceof GenesisShotEntity)
                  && !(entityiteratorx instanceof DiabolosDecimatorEntity)
                  && !(entityiteratorx instanceof HomingSparkEntity)
                  && !(entityiteratorx instanceof ItemEntity)
                  && !entityiteratorx.getPersistentData().getBoolean("creativespectator")) {
                  if (!entityiteratorx.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("minecraft:impact_projectiles")))
                     && !(entityiteratorx instanceof WebbedArrowEntity)
                     && !(entityiteratorx instanceof BloodProjectileEntity)) {
                     if ((
                              entity instanceof DiabolosDecimatorEntity _datEntIxxxxxxxxxxxxxxxxxxxx
                                 ? (Integer)_datEntIxxxxxxxxxxxxxxxxxxxx.getEntityData().get(DiabolosDecimatorEntity.DATA_current_final)
                                 : 0
                           )
                           == 2
                        && (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null) != null
                        && entityiteratorx instanceof LivingEntity
                        && !(entityiteratorx instanceof ArmorStand)) {
                        if (!(entity.getPersistentData().getDouble("diab_lim_dam") > 0.0)) {
                           entity.getPersistentData().putDouble("diab_lim_dam", 22.0);
                           entityiteratorx.hurt(
                              new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)),
                              Math.max((entityiteratorx instanceof LivingEntity _livEntxxxxxx ? _livEntxxxxxx.getMaxHealth() : -1.0F) / 4.0F, 19.0F)
                           );
                        } else {
                           entity.getPersistentData().putDouble("diab_lim_dam", entity.getPersistentData().getDouble("diab_lim_dam") - 1.0);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt898 = (LivingEntity)entity;
                        if (_livEnt898.hasEffect((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get())) {
                           continue;
                        }
                     }

                     if (entity.getPersistentData().getDouble("slowtime") == 5.0 || !(entityiteratorx instanceof Player)) {
                        if ((entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null) == null) {
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
                              if (world instanceof ServerLevel _levelxxxxx) {
                                 _levelxxxxx.sendParticles(
                                    (SimpleParticleType)ArphexModParticleTypes.HEAVY_GOLD_SMOKE.get(),
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
                        } else if (entityiteratorx == (entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null)) {
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
                              if (world instanceof ServerLevel _levelxxxxx) {
                                 _levelxxxxx.sendParticles(
                                    (SimpleParticleType)ArphexModParticleTypes.HEAVY_GOLD_SMOKE.get(),
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
                              if (world instanceof ServerLevel _levelxxxxx) {
                                 _levelxxxxx.sendParticles(
                                    (SimpleParticleType)ArphexModParticleTypes.HEAVY_GOLD_SMOKE.get(),
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

            if (var103 != null) {
               if ((
                     var103 instanceof Player
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
                                    .checkGamemode(var103)
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
                                    .checkGamemode(var103)
                           )
                        || !var103.isAlive()
                  )
                  && entity instanceof Mob) {
                  try {
                     ((Mob)entity).setTarget(null);
                  } catch (Exception var100) {
                     var100.printStackTrace();
                  }
               }

               if ((entity instanceof LivingEntity _livEntxxxxxx ? _livEntxxxxxx.getHealth() : -1.0F) > 325.0F) {
                  if (world instanceof ServerLevel _levelxxxxx) {
                     _levelxxxxx.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL,
                                 new Vec3(entity.getX(), entity.getY() + 2.0, entity.getZ()),
                                 Vec2.ZERO,
                                 _levelxxxxx,
                                 4,
                                 "",
                                 Component.literal(""),
                                 _levelxxxxx.getServer(),
                                 null
                              )
                              .withSuppressedOutput(),
                           "/particle arphex:charcoal ~ ~ ~ 2.5 2.5 2.5 0 100 force"
                        );
                  }
               } else if (world instanceof ServerLevel _levelxxxxx) {
                  _levelxxxxx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL,
                              new Vec3(entity.getX(), entity.getY() + 2.0, entity.getZ()),
                              Vec2.ZERO,
                              _levelxxxxx,
                              4,
                              "",
                              Component.literal(""),
                              _levelxxxxx.getServer(),
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
               if ((!(entity instanceof DiabolosDecimatorEntity _datEntL968) || !(Boolean)_datEntL968.getEntityData().get(DiabolosDecimatorEntity.DATA_primed))
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
                  if (entity instanceof DiabolosDecimatorEntity _datEntSetL) {
                     _datEntSetL.getEntityData().set(DiabolosDecimatorEntity.DATA_primed, true);
                  }

                  if (world instanceof ServerLevel _levelxxxxx) {
                     LightningBolt entityToSpawn = (LightningBolt)EntityType.LIGHTNING_BOLT.create(_levelxxxxx);
                     entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
                     entityToSpawn.setVisualOnly(true);
                     _levelxxxxx.addFreshEntity(entityToSpawn);
                  }

                  if (world instanceof Level _levelxxxxx) {
                     if (!_levelxxxxx.isClientSide()) {
                        _levelxxxxx.playSound(
                           null,
                           BlockPos.containing(nearestplayer80.getX(), nearestplayer80.getY(), nearestplayer80.getZ()),
                           (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:mothscare")),
                           SoundSource.HOSTILE,
                           0.3F,
                           1.0E-4F
                        );
                     } else {
                        _levelxxxxx.playLocalSound(
                           nearestplayer80.getX(),
                           nearestplayer80.getY(),
                           nearestplayer80.getZ(),
                           (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:mothscare")),
                           SoundSource.HOSTILE,
                           0.3F,
                           1.0E-4F,
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
                           capability.ShowOverlay5 = _setval;
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

               if (world instanceof ServerLevel _levelxxxxxx) {
                  _levelxxxxxx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxxxxxx, 4, "", Component.literal(""), _levelxxxxxx.getServer(), null
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
