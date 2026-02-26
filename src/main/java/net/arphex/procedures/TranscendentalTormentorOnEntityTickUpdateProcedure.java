package net.arphex.procedures;

import java.text.DecimalFormat;
import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.SmallTormentSphereEntity;
import net.arphex.entity.TORMENTOREntity;
import net.arphex.entity.TormentBlastEntity;
import net.arphex.entity.TormentRifleEntity;
import net.arphex.entity.TormentorLaserEntity;
import net.arphex.entity.TormentorSphereEntity;
import net.arphex.entity.TormentorTendrilEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
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
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class TranscendentalTormentorOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean scansnearestfirst = false;
         boolean everyother = false;
         boolean nearest = false;
         boolean entity_found = false;
         boolean disabled = false;
         boolean targetone = false;
         boolean limitone = false;
         String checked_pos = "";
         String order_random = "";
         double ringspin = 0.0;
         double ringspan = 0.0;
         double Radius = 0.0;
         double loop = 0.0;
         double particleSpeed = 0.0;
         double particleAmount = 0.0;
         double homing = 0.0;
         double raytrace_distance = 0.0;
         double newpositionz = 0.0;
         double newpositiony = 0.0;
         double newpositionx = 0.0;
         double expand = 0.0;
         double lineZ = 0.0;
         double lineY = 0.0;
         double lineX = 0.0;
         double dist = 0.0;
         double wrap_yaw = 0.0;
         double position_to_check = 0.0;
         double step_count = 0.0;
         double num_iterate = 0.0;
         double lock_steps = 0.0;
         if (entity.getPersistentData().getDouble("able_to_harm_self") > 0.0) {
            entity.getPersistentData().putDouble("able_to_harm_self", entity.getPersistentData().getDouble("able_to_harm_self") - 1.0);
         }

         if (!(ArphexModVariables.MapVariables.get(world).tormentor_tier > 0.0)) {
            ArphexModVariables.MapVariables.get(world).tormentor_tier = 1.0;
            ArphexModVariables.MapVariables.get(world).syncData(world);
         }

         if (ArphexModVariables.MapVariables.get(world).tormentor_variable_damage_limit > 0.0) {
            ArphexModVariables.MapVariables.get(world).tormentor_variable_damage_limit--;
            ArphexModVariables.MapVariables.get(world).syncData(world);
         }

         if (ArphexModVariables.MapVariables.get(world).tormentor_hitbox_split > 0.0) {
            ArphexModVariables.MapVariables.get(world).tormentor_hitbox_split--;
            ArphexModVariables.MapVariables.get(world).syncData(world);
         }

         label1084: {
            entity.getPersistentData().putBoolean("arphex", true);
            if (entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get())) {
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
                        "data merge entity @s {Invulnerable:1b}"
                     );
               }
               break label1084;
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
                     "data merge entity @s {Invulnerable:0}"
                  );
            }
         }

         ArphexModVariables.MapVariables.get(world).tormentor_animode = entity instanceof TORMENTOREntity _datEntS
            ? (String)_datEntS.getEntityData().get(TORMENTOREntity.DATA_tormentcycle)
            : "";
         ArphexModVariables.MapVariables.get(world).syncData(world);
         if (entity.getPersistentData().getDouble("smallspherecooldown") > 0.0) {
            entity.getPersistentData().putDouble("smallspherecooldown", entity.getPersistentData().getDouble("smallspherecooldown") - 1.0);
         }

         if ((
               entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(MobEffects.REGENERATION)
                  || entity instanceof LivingEntity _livEnt12 && _livEnt12.hasEffect(MobEffects.HEAL)
            )
            && Mth.nextInt(RandomSource.create(), 1, 60) == 5) {
            ArphexModVariables.MapVariables var229;
            int var10002;
            label1067: {
               var229 = ArphexModVariables.MapVariables.get(world);
               if (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.REGENERATION)) {
                  var10002 = _livEnt.getEffect(MobEffects.REGENERATION).getAmplifier();
                  break label1067;
               }

               var10002 = 0;
            }

            label1062: {
               var229.tormentor_health = ArphexModVariables.MapVariables.get(world).tormentor_health + (double)var10002;
               ArphexModVariables.MapVariables.get(world).syncData(world);
               var229 = ArphexModVariables.MapVariables.get(world);
               if (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.HEAL)) {
                  var10002 = _livEnt.getEffect(MobEffects.HEAL).getAmplifier();
                  break label1062;
               }

               var10002 = 0;
            }

            var229.tormentor_health = ArphexModVariables.MapVariables.get(world).tormentor_health + (double)var10002;
            ArphexModVariables.MapVariables.get(world).syncData(world);
         }

         if (entity instanceof LivingEntity _livEnt16 && _livEnt16.hasEffect((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get())) {
            ArphexModVariables.MapVariables.get(world).limhit_tormentor = false;
            ArphexModVariables.MapVariables.get(world).syncData(world);
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.setHealth((float)ArphexModVariables.MapVariables.get(world).tormentor_health);
         }

         entity.noPhysics = true;
         if (entity instanceof TORMENTOREntity _datEntSetI) {
            _datEntSetI.getEntityData().set(TORMENTOREntity.DATA_time_since_attacked, 0);
         }

         if (!entity.getPersistentData().getString("current_dimension").equals(ArphexModVariables.MapVariables.get(world).tormentor_target_dimension)
            && entity.getPersistentData().getString("current_dimension").length() >= 3
            && !entity.level().isClientSide()) {
            entity.discard();
         }

         if (Math.abs(ArphexModVariables.MapVariables.get(world).tormentor_rotation - (double)entity.getYRot()) > 5.0) {
            entity.setYRot((float)ArphexModVariables.MapVariables.get(world).tormentor_rotation);
            entity.setXRot(entity.getXRot());
            entity.setYBodyRot(entity.getYRot());
            entity.setYHeadRot(entity.getYRot());
            entity.yRotO = entity.getYRot();
            entity.xRotO = entity.getXRot();
            if (entity instanceof LivingEntity _entity) {
               _entity.yBodyRotO = _entity.getYRot();
               _entity.yHeadRotO = _entity.getYRot();
            }
         }

         entity.getPersistentData()
            .putDouble(
               "tormentor_distance_to_target",
               Math.sqrt(
                  Math.pow(entity.getX() - ArphexModVariables.MapVariables.get(world).tormentor_target_x, 2.0)
                     + Math.pow(entity.getY() - ArphexModVariables.MapVariables.get(world).tormentor_target_y, 2.0)
                     + Math.pow(entity.getZ() - ArphexModVariables.MapVariables.get(world).tormentor_target_z, 2.0)
               )
            );
         if ((entity instanceof TORMENTOREntity _datEntSx ? (String)_datEntSx.getEntityData().get(TORMENTOREntity.DATA_tormentcycle) : "").equals("splay")
            && (Boolean)ConfigurationSettingsConfiguration.TORMENTOR_PARTICLES.get()) {
            if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                           .withSuppressedOutput(),
                        "particle arphex:death_smoke ~ ~ ~ 40 ~ 40 0 15 force"
                     );
               }
            } else if (world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                        .withSuppressedOutput(),
                     "particle arphex:huge_fire ~ ~ ~ 40 ~ 40 0 15 force"
                  );
            }
         }

         if (entity.isAlive()) {
            if ((entity instanceof TORMENTOREntity _datEntI ? (Integer)_datEntI.getEntityData().get(TORMENTOREntity.DATA_tormenttimer) : 0) <= 0) {
               if ((Boolean)ConfigurationSettingsConfiguration.TORMENTOR_PARTICLES.get()) {
                  for (int index0 = 0; index0 < 30; index0++) {
                     if (ringspan <= 0.0) {
                        ringspan = 30.0;
                     } else {
                        ringspan--;
                     }

                     for (int index1 = 0; index1 < 36; index1++) {
                        if (ringspin <= 0.0) {
                           ringspin = 360.0;
                        } else {
                           ringspin -= 10.0;
                        }

                        if (ringspan < 2.0) {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "execute as @e[type=arphex:tormentor,sort=nearest,limit=1] at @s rotated "
                                       + (ringspin + 5.0)
                                       + " 0 as @e[type=arphex:tormentor,sort=nearest,limit=1] run particle arphex:death_smoke ^ ^"
                                       + (ringspan * ringspan - (double)Mth.nextInt(RandomSource.create(), -10, 15))
                                       + " ^"
                                       + ringspan * 30.0
                                       + " 0 -0.2 0 1 0 force"
                                 );
                           }
                        } else {
                           if (Mth.nextInt(RandomSource.create(), (int)ringspan, 30) == 28 && world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "execute as @e[type=arphex:tormentor,sort=nearest,limit=1] at @s rotated "
                                       + (ringspin + 5.0)
                                       + " 0 as @e[type=arphex:tormentor,sort=nearest,limit=1] run particle arphex:huge_fire ^ ^"
                                       + (ringspan * ringspan - 10.0)
                                       + " ^"
                                       + ringspan * 30.0
                                       + " 3 -0.2 3 1 2 force"
                                 );
                           }

                           if (!(Boolean)ConfigurationSettingsConfiguration.SPECIAL_TORMENTOR_RENDERING.get() && world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "execute as @e[type=arphex:tormentor,sort=nearest,limit=1] at @s rotated "
                                       + ringspin
                                       + " 0 as @e[type=arphex:tormentor,sort=nearest,limit=1] run particle arphex:tormentor_smoke ^ ^"
                                       + ringspan * ringspan
                                       + " ^"
                                       + ringspan * 30.0
                                       + " 0 -0.2 0 1 0 force"
                                 );
                           }
                        }
                     }
                  }

                  if (world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "particle arphex:solid_smoke ~ ~2 ~ 2 2 2 3 15 force"
                        );
                  }

                  ArphexMod.queueServerWork(
                     8,
                     () -> {
                        if (world instanceof ServerLevel _levelx) {
                           _levelx.getServer()
                              .getCommands()
                              .performPrefixedCommand(
                                 new CommandSourceStack(
                                       CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelx, 4, "", Component.literal(""), _levelx.getServer(), null
                                    )
                                    .withSuppressedOutput(),
                                 "particle arphex:solid_smoke ~ ~2 ~ 2 2 2 3 15 force"
                              );
                        }
                     }
                  );
               }

               scansnearestfirst = false;
               limitone = false;
               Vec3 _center = new Vec3(x, y, z);

               for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(600.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiterator instanceof LivingEntity) {
                     if (!entityiterator.getPersistentData().getBoolean("creativespectator")
                        && !entityiterator.getPersistentData().getBoolean("tormentor_summon")
                        && !(entityiterator instanceof TormentorTendrilEntity)
                        && !(entityiterator instanceof SmallTormentSphereEntity)
                        && !(entityiterator instanceof TormentorLaserEntity)) {
                        dist = (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                           + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ());
                        if (225.0 > dist
                           && entity.getY() + 90.0 > entityiterator.getY()
                           && entity.getY() - 20.0 < entityiterator.getY()
                           && entityiterator != entity
                           && !(
                              ((ArphexModVariables.PlayerVariables)entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                       .orElse(new ArphexModVariables.PlayerVariables()))
                                    .tormentor_respite
                                 > 500.0
                           )) {
                           if (10000.0 * ArphexModVariables.MapVariables.get(world).tormentor_tier
                              > (double)(entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F)
                                 * (0.33 + ArphexModVariables.MapVariables.get(world).tormentor_tier * 0.2)) {
                              entityiterator.hurt(
                                 new DamageSource(
                                    world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity
                                 ),
                                 (float)(10000.0 * ArphexModVariables.MapVariables.get(world).tormentor_tier)
                              );
                           } else {
                              entityiterator.hurt(
                                 new DamageSource(
                                    world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity
                                 ),
                                 (float)(
                                    (double)(entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F)
                                       * (0.33 + ArphexModVariables.MapVariables.get(world).tormentor_tier * 0.2)
                                 )
                              );
                           }
                        }

                        if (625.0 > dist
                           && entity.getY() + 110.0 > entityiterator.getY()
                           && entity.getY() - 30.0 < entityiterator.getY()
                           && entityiterator instanceof Player
                           && !entityiterator.getPersistentData().getBoolean("creativespectator")) {
                           double _setval = 200.0;
                           entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                              capability.shadertime = _setval;
                              capability.syncPlayerVariables(entityiterator);
                           });
                           if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 60, 1, false, false));
                           }

                           if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.MOTH_CURSE.get(), 200, 0, false, false));
                           }

                           _setval = 1200.0;
                           entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                              capability.recently_attacked_tormentor = _setval;
                              capability.syncPlayerVariables(entityiterator);
                           });
                        }
                     }

                     if (((ArphexModVariables.PlayerVariables)entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                 .orElse(new ArphexModVariables.PlayerVariables()))
                              .tormentor_respite
                           > 0.0
                        && !entityiterator.getPersistentData().getBoolean("creativespectator")
                        && Mth.nextInt(RandomSource.create(), 1, 6000) == 5) {
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.TORMENT.get(), 200, 1, false, false));
                        }

                        if (world instanceof ServerLevel _level) {
                           _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.DEATH_SMOKE.get(), x, y, z, 5, 0.0, 0.0, 0.0, 0.8);
                        }
                     }

                     if (entityiterator.getPersistentData().getBoolean("tormentor_target")
                        && !entityiterator.getPersistentData().getBoolean("tormentor_summon")
                        && entity != entityiterator
                        && !(
                           ((ArphexModVariables.PlayerVariables)entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                    .orElse(new ArphexModVariables.PlayerVariables()))
                                 .tormentor_respite
                              > 0.0
                        )) {
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.THUNDER_SENSE.get(), 100, 0, false, false));
                        }

                        if (!scansnearestfirst) {
                           scansnearestfirst = true;
                           if (entity.getPersistentData().getDouble("blastratetormentor") > 0.0) {
                              entity.getPersistentData().putDouble("blastratetormentor", entity.getPersistentData().getDouble("blastratetormentor") - 1.0);
                              if (ArphexModVariables.MapVariables.get(world).tormentor_tier > 1.0) {
                                 if (!(entity.getPersistentData().getDouble("slow_new_attacks") > 0.0)) {
                                    if (world instanceof ServerLevel _level) {
                                       Entity entityToSpawn = ((EntityType)ArphexModEntities.TORMENTOR_SHIELD.get())
                                          .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                                       if (entityToSpawn != null) {
                                          entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                                       }
                                    }

                                    entity.getPersistentData().putDouble("slow_new_attacks", 90.0);
                                 } else {
                                    entity.getPersistentData().putDouble("slow_new_attacks", entity.getPersistentData().getDouble("slow_new_attacks") - 1.0);
                                 }
                              }
                           } else if ((entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F) < 1000.0F
                              && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) % 2.0F == 0.0F) {
                              entity.getPersistentData().putDouble("blastratetormentor", 5.0);
                              if ((entity instanceof TORMENTOREntity _datEntSxx
                                    ? (String)_datEntSxx.getEntityData().get(TORMENTOREntity.DATA_tormentcycle)
                                    : "")
                                 .equals("splay")) {
                                 if (!(ArphexModVariables.MapVariables.get(world).tormentor_hitbox_split > 0.0)) {
                                    if (world instanceof ServerLevel _levelx) {
                                       Entity entityToSpawn = ((EntityType)ArphexModEntities.TORMENTOR_HITBOX.get())
                                          .spawn(_levelx, BlockPos.containing(x - 50.0, y, z), MobSpawnType.MOB_SUMMONED);
                                       if (entityToSpawn != null) {
                                          entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                                       }
                                    }

                                    if (world instanceof ServerLevel _levelxx) {
                                       Entity entityToSpawn = ((EntityType)ArphexModEntities.TORMENTOR_HITBOX.get())
                                          .spawn(_levelxx, BlockPos.containing(x + 50.0, y, z), MobSpawnType.MOB_SUMMONED);
                                       if (entityToSpawn != null) {
                                          entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                                       }
                                    }
                                 }

                                 if (world instanceof ServerLevel _levelxxx) {
                                    _levelxxx.getServer()
                                       .getCommands()
                                       .performPrefixedCommand(
                                          new CommandSourceStack(
                                                CommandSource.NULL,
                                                new Vec3(
                                                   x + (double)Mth.nextInt(RandomSource.create(), -200, 100),
                                                   y + (double)Mth.nextInt(RandomSource.create(), -200, 100),
                                                   z + (double)Mth.nextInt(RandomSource.create(), -200, 100)
                                                ),
                                                Vec2.ZERO,
                                                _levelxxx,
                                                4,
                                                "",
                                                Component.literal(""),
                                                _levelxxx.getServer(),
                                                null
                                             )
                                             .withSuppressedOutput(),
                                          "summon arphex:tormentor_caterpillar ~ ~ ~"
                                       );
                                 }

                                 if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getHealth() : -1.0F) < 800.0F
                                    && world instanceof ServerLevel _levelxxx) {
                                    _levelxxx.getServer()
                                       .getCommands()
                                       .performPrefixedCommand(
                                          new CommandSourceStack(
                                                CommandSource.NULL,
                                                new Vec3(
                                                   x + (double)Mth.nextInt(RandomSource.create(), -200, 100),
                                                   y + (double)Mth.nextInt(RandomSource.create(), -200, 100),
                                                   z + (double)Mth.nextInt(RandomSource.create(), -200, 100)
                                                ),
                                                Vec2.ZERO,
                                                _levelxxx,
                                                4,
                                                "",
                                                Component.literal(""),
                                                _levelxxx.getServer(),
                                                null
                                             )
                                             .withSuppressedOutput(),
                                          "summon arphex:tormentor_caterpillar ~ ~ ~"
                                       );
                                 }

                                 if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getHealth() : -1.0F) < 400.0F
                                    && world instanceof ServerLevel _levelxxx) {
                                    _levelxxx.getServer()
                                       .getCommands()
                                       .performPrefixedCommand(
                                          new CommandSourceStack(
                                                CommandSource.NULL,
                                                new Vec3(
                                                   x + (double)Mth.nextInt(RandomSource.create(), -200, 100),
                                                   y + (double)Mth.nextInt(RandomSource.create(), -200, 100),
                                                   z + (double)Mth.nextInt(RandomSource.create(), -200, 100)
                                                ),
                                                Vec2.ZERO,
                                                _levelxxx,
                                                4,
                                                "",
                                                Component.literal(""),
                                                _levelxxx.getServer(),
                                                null
                                             )
                                             .withSuppressedOutput(),
                                          "summon arphex:tormentor_caterpillar ~ ~ ~"
                                       );
                                 }
                              } else if ((entity instanceof TORMENTOREntity _datEntSxx
                                    ? (String)_datEntSxx.getEntityData().get(TORMENTOREntity.DATA_tormentcycle)
                                    : "")
                                 .equals("fold")) {
                                 if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getHealth() : -1.0F) < 900.0F
                                    && !limitone
                                    && !(entity.getPersistentData().getDouble("smallspherecooldown") > 0.0)) {
                                    if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getHealth() : -1.0F) < 400.0F) {
                                       for (int index2 = 0; index2 < 10; index2++) {
                                          if (world instanceof ServerLevel _levelxxx) {
                                             _levelxxx.getServer()
                                                .getCommands()
                                                .performPrefixedCommand(
                                                   new CommandSourceStack(
                                                         CommandSource.NULL,
                                                         new Vec3(
                                                            x + (double)Mth.nextInt(RandomSource.create(), -3, 3),
                                                            y + (double)Mth.nextInt(RandomSource.create(), -3, 3),
                                                            z + (double)Mth.nextInt(RandomSource.create(), -3, 3)
                                                         ),
                                                         Vec2.ZERO,
                                                         _levelxxx,
                                                         4,
                                                         "",
                                                         Component.literal(""),
                                                         _levelxxx.getServer(),
                                                         null
                                                      )
                                                      .withSuppressedOutput(),
                                                   "summon arphex:small_torment_sphere ~ ~ ~"
                                                );
                                          }
                                       }
                                    }

                                    for (int index3 = 0; index3 < 20; index3++) {
                                       if (world instanceof ServerLevel _levelxxx) {
                                          _levelxxx.getServer()
                                             .getCommands()
                                             .performPrefixedCommand(
                                                new CommandSourceStack(
                                                      CommandSource.NULL,
                                                      new Vec3(
                                                         x + (double)Mth.nextInt(RandomSource.create(), -3, 3),
                                                         y + (double)Mth.nextInt(RandomSource.create(), -3, 3),
                                                         z + (double)Mth.nextInt(RandomSource.create(), -3, 3)
                                                      ),
                                                      Vec2.ZERO,
                                                      _levelxxx,
                                                      4,
                                                      "",
                                                      Component.literal(""),
                                                      _levelxxx.getServer(),
                                                      null
                                                   )
                                                   .withSuppressedOutput(),
                                                "summon arphex:small_torment_sphere ~ ~ ~"
                                             );
                                       }
                                    }

                                    entity.getPersistentData().putDouble("smallspherecooldown", 1200.0);
                                    entityiterator.getPersistentData().putBoolean("smalltormentspheretarget", true);
                                    limitone = true;
                                 }

                                 if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
                                    if (world instanceof ServerLevel _levelxxx) {
                                       _levelxxx.getServer()
                                          .getCommands()
                                          .performPrefixedCommand(
                                             new CommandSourceStack(
                                                   CommandSource.NULL,
                                                   new Vec3(
                                                      entityiterator.getX() + (double)Mth.nextInt(RandomSource.create(), 50, 50),
                                                      entityiterator.getY() + (double)Mth.nextInt(RandomSource.create(), -50, 50),
                                                      entityiterator.getZ() + (double)Mth.nextInt(RandomSource.create(), -50, 50)
                                                   ),
                                                   Vec2.ZERO,
                                                   _levelxxx,
                                                   4,
                                                   "",
                                                   Component.literal(""),
                                                   _levelxxx.getServer(),
                                                   null
                                                )
                                                .withSuppressedOutput(),
                                             "summon arphex:tormentor_larvae ~ ~ ~"
                                          );
                                    }

                                    if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getHealth() : -1.0F) < 500.0F
                                       && world instanceof ServerLevel _levelxxx) {
                                       _levelxxx.getServer()
                                          .getCommands()
                                          .performPrefixedCommand(
                                             new CommandSourceStack(
                                                   CommandSource.NULL,
                                                   new Vec3(
                                                      entityiterator.getX() + (double)Mth.nextInt(RandomSource.create(), -50, 50),
                                                      entityiterator.getY() + (double)Mth.nextInt(RandomSource.create(), -50, 50),
                                                      entityiterator.getZ() + (double)Mth.nextInt(RandomSource.create(), -50, 50)
                                                   ),
                                                   Vec2.ZERO,
                                                   _levelxxx,
                                                   4,
                                                   "",
                                                   Component.literal(""),
                                                   _levelxxx.getServer(),
                                                   null
                                                )
                                                .withSuppressedOutput(),
                                             "summon arphex:tormentor_larvae ~ ~ ~"
                                          );
                                    }
                                 }
                              } else if (Math.atan2(entityiterator.getX() - entity.getX(), entityiterator.getZ() - entity.getZ()) * 57.5
                                       - 0.0
                                       + ArphexModVariables.MapVariables.get(world).tormentor_rotation
                                    < 90.0
                                 && Math.atan2(entityiterator.getX() - entity.getX(), entityiterator.getZ() - entity.getZ()) * 57.5
                                       - 0.0
                                       + ArphexModVariables.MapVariables.get(world).tormentor_rotation
                                    > -90.0
                                 && (
                                       entity instanceof TORMENTOREntity _datEntIx
                                          ? (Integer)_datEntIx.getEntityData().get(TORMENTOREntity.DATA_time_since_attacked)
                                          : 0
                                    )
                                    < 12000) {
                                 if (entity.getY() > entityiterator.getY()) {
                                    if (world instanceof ServerLevel projectileLevel) {
                                       Projectile _entityToSpawn = (new Object() {
                                             public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                AbstractArrow entityToSpawn = new TormentBlastEntity(
                                                   (EntityType<? extends TormentBlastEntity>)ArphexModEntities.TORMENT_BLAST.get(), level
                                                );
                                                entityToSpawn.setOwner(shooter);
                                                entityToSpawn.setBaseDamage((double)damage);
                                                entityToSpawn.setKnockback(knockback);
                                                entityToSpawn.setSilent(true);
                                                return entityToSpawn;
                                             }
                                          })
                                          .getArrow(projectileLevel, entity, 0.0F, 0);
                                       _entityToSpawn.setPos(entity.getX(), entity.getY() - 5.0, entity.getZ());
                                       _entityToSpawn.shoot(1.0, 1.0, 1.0, 2.0F, 0.0F);
                                       projectileLevel.addFreshEntity(_entityToSpawn);
                                    }

                                    if (ArphexModVariables.MapVariables.get(world).tormentor_tier > 1.0) {
                                       if (world instanceof ServerLevel projectileLevel) {
                                          Projectile _entityToSpawn = (new Object() {
                                                public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                   AbstractArrow entityToSpawn = new TormentBlastEntity(
                                                      (EntityType<? extends TormentBlastEntity>)ArphexModEntities.TORMENT_BLAST.get(), level
                                                   );
                                                   entityToSpawn.setOwner(shooter);
                                                   entityToSpawn.setBaseDamage((double)damage);
                                                   entityToSpawn.setKnockback(knockback);
                                                   entityToSpawn.setSilent(true);
                                                   return entityToSpawn;
                                                }
                                             })
                                             .getArrow(projectileLevel, entity, 0.0F, 0);
                                          _entityToSpawn.setPos(entity.getX(), entity.getY() - 5.0, entity.getZ());
                                          _entityToSpawn.shoot(1.0, 1.0, 1.0, 2.0F, 0.0F);
                                          projectileLevel.addFreshEntity(_entityToSpawn);
                                       }

                                       if (world instanceof ServerLevel projectileLevel) {
                                          Projectile _entityToSpawn = (new Object() {
                                                public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                   AbstractArrow entityToSpawn = new TormentBlastEntity(
                                                      (EntityType<? extends TormentBlastEntity>)ArphexModEntities.TORMENT_BLAST.get(), level
                                                   );
                                                   entityToSpawn.setOwner(shooter);
                                                   entityToSpawn.setBaseDamage((double)damage);
                                                   entityToSpawn.setKnockback(knockback);
                                                   entityToSpawn.setSilent(true);
                                                   return entityToSpawn;
                                                }
                                             })
                                             .getArrow(projectileLevel, entity, 0.0F, 0);
                                          _entityToSpawn.setPos(entity.getX(), entity.getY() - 5.0, entity.getZ());
                                          _entityToSpawn.shoot(1.0, 1.0, 1.0, 2.0F, 0.0F);
                                          projectileLevel.addFreshEntity(_entityToSpawn);
                                       }

                                       if (ArphexModVariables.MapVariables.get(world).tormentor_tier > 2.0) {
                                          if (world instanceof ServerLevel projectileLevel) {
                                             Projectile _entityToSpawn = (new Object() {
                                                   public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                      AbstractArrow entityToSpawn = new TormentBlastEntity(
                                                         (EntityType<? extends TormentBlastEntity>)ArphexModEntities.TORMENT_BLAST.get(), level
                                                      );
                                                      entityToSpawn.setOwner(shooter);
                                                      entityToSpawn.setBaseDamage((double)damage);
                                                      entityToSpawn.setKnockback(knockback);
                                                      entityToSpawn.setSilent(true);
                                                      return entityToSpawn;
                                                   }
                                                })
                                                .getArrow(projectileLevel, entity, 0.0F, 0);
                                             _entityToSpawn.setPos(
                                                entity.getX(), entity.getY() + Math.min(50.0, entityiterator.getY() - entity.getY()), entity.getZ()
                                             );
                                             _entityToSpawn.shoot(1.0, 1.0, 1.0, 2.0F, 0.0F);
                                             projectileLevel.addFreshEntity(_entityToSpawn);
                                          }

                                          if (world instanceof ServerLevel projectileLevel) {
                                             Projectile _entityToSpawn = (new Object() {
                                                   public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                      AbstractArrow entityToSpawn = new TormentBlastEntity(
                                                         (EntityType<? extends TormentBlastEntity>)ArphexModEntities.TORMENT_BLAST.get(), level
                                                      );
                                                      entityToSpawn.setOwner(shooter);
                                                      entityToSpawn.setBaseDamage((double)damage);
                                                      entityToSpawn.setKnockback(knockback);
                                                      entityToSpawn.setSilent(true);
                                                      return entityToSpawn;
                                                   }
                                                })
                                                .getArrow(projectileLevel, entity, 0.0F, 0);
                                             _entityToSpawn.setPos(
                                                entity.getX(), entity.getY() + Math.min(50.0, entityiterator.getY() - entity.getY()), entity.getZ()
                                             );
                                             _entityToSpawn.shoot(1.0, 1.0, 1.0, 2.0F, 0.0F);
                                             projectileLevel.addFreshEntity(_entityToSpawn);
                                          }
                                       }
                                    }
                                 } else {
                                    if (world instanceof ServerLevel projectileLevel) {
                                       Projectile _entityToSpawn = (new Object() {
                                             public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                AbstractArrow entityToSpawn = new TormentBlastEntity(
                                                   (EntityType<? extends TormentBlastEntity>)ArphexModEntities.TORMENT_BLAST.get(), level
                                                );
                                                entityToSpawn.setOwner(shooter);
                                                entityToSpawn.setBaseDamage((double)damage);
                                                entityToSpawn.setKnockback(knockback);
                                                entityToSpawn.setSilent(true);
                                                return entityToSpawn;
                                             }
                                          })
                                          .getArrow(projectileLevel, entity, 0.0F, 0);
                                       _entityToSpawn.setPos(
                                          entity.getX(), entity.getY() + Math.min(50.0, entityiterator.getY() - entity.getY()), entity.getZ()
                                       );
                                       _entityToSpawn.shoot(1.0, 1.0, 1.0, 2.0F, 0.0F);
                                       projectileLevel.addFreshEntity(_entityToSpawn);
                                    }

                                    if (ArphexModVariables.MapVariables.get(world).tormentor_tier > 1.0) {
                                       if (world instanceof ServerLevel projectileLevel) {
                                          Projectile _entityToSpawn = (new Object() {
                                                public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                   AbstractArrow entityToSpawn = new TormentBlastEntity(
                                                      (EntityType<? extends TormentBlastEntity>)ArphexModEntities.TORMENT_BLAST.get(), level
                                                   );
                                                   entityToSpawn.setOwner(shooter);
                                                   entityToSpawn.setBaseDamage((double)damage);
                                                   entityToSpawn.setKnockback(knockback);
                                                   entityToSpawn.setSilent(true);
                                                   return entityToSpawn;
                                                }
                                             })
                                             .getArrow(projectileLevel, entity, 0.0F, 0);
                                          _entityToSpawn.setPos(
                                             entity.getX(), entity.getY() + Math.min(50.0, entityiterator.getY() - entity.getY()), entity.getZ()
                                          );
                                          _entityToSpawn.shoot(1.0, 1.0, 1.0, 2.0F, 0.0F);
                                          projectileLevel.addFreshEntity(_entityToSpawn);
                                       }

                                       if (world instanceof ServerLevel projectileLevel) {
                                          Projectile _entityToSpawn = (new Object() {
                                                public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                   AbstractArrow entityToSpawn = new TormentBlastEntity(
                                                      (EntityType<? extends TormentBlastEntity>)ArphexModEntities.TORMENT_BLAST.get(), level
                                                   );
                                                   entityToSpawn.setOwner(shooter);
                                                   entityToSpawn.setBaseDamage((double)damage);
                                                   entityToSpawn.setKnockback(knockback);
                                                   entityToSpawn.setSilent(true);
                                                   return entityToSpawn;
                                                }
                                             })
                                             .getArrow(projectileLevel, entity, 0.0F, 0);
                                          _entityToSpawn.setPos(
                                             entity.getX(), entity.getY() + Math.min(50.0, entityiterator.getY() - entity.getY()), entity.getZ()
                                          );
                                          _entityToSpawn.shoot(1.0, 1.0, 1.0, 2.0F, 0.0F);
                                          projectileLevel.addFreshEntity(_entityToSpawn);
                                       }

                                       if (ArphexModVariables.MapVariables.get(world).tormentor_tier > 2.0) {
                                          if (world instanceof ServerLevel projectileLevel) {
                                             Projectile _entityToSpawn = (new Object() {
                                                   public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                      AbstractArrow entityToSpawn = new TormentBlastEntity(
                                                         (EntityType<? extends TormentBlastEntity>)ArphexModEntities.TORMENT_BLAST.get(), level
                                                      );
                                                      entityToSpawn.setOwner(shooter);
                                                      entityToSpawn.setBaseDamage((double)damage);
                                                      entityToSpawn.setKnockback(knockback);
                                                      entityToSpawn.setSilent(true);
                                                      return entityToSpawn;
                                                   }
                                                })
                                                .getArrow(projectileLevel, entity, 0.0F, 0);
                                             _entityToSpawn.setPos(
                                                entity.getX(), entity.getY() + Math.min(50.0, entityiterator.getY() - entity.getY()), entity.getZ()
                                             );
                                             _entityToSpawn.shoot(1.0, 1.0, 1.0, 2.0F, 0.0F);
                                             projectileLevel.addFreshEntity(_entityToSpawn);
                                          }

                                          if (world instanceof ServerLevel projectileLevel) {
                                             Projectile _entityToSpawn = (new Object() {
                                                   public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                      AbstractArrow entityToSpawn = new TormentBlastEntity(
                                                         (EntityType<? extends TormentBlastEntity>)ArphexModEntities.TORMENT_BLAST.get(), level
                                                      );
                                                      entityToSpawn.setOwner(shooter);
                                                      entityToSpawn.setBaseDamage((double)damage);
                                                      entityToSpawn.setKnockback(knockback);
                                                      entityToSpawn.setSilent(true);
                                                      return entityToSpawn;
                                                   }
                                                })
                                                .getArrow(projectileLevel, entity, 0.0F, 0);
                                             _entityToSpawn.setPos(
                                                entity.getX(), entity.getY() + Math.min(50.0, entityiterator.getY() - entity.getY()), entity.getZ()
                                             );
                                             _entityToSpawn.shoot(1.0, 1.0, 1.0, 2.0F, 0.0F);
                                             projectileLevel.addFreshEntity(_entityToSpawn);
                                          }
                                       }
                                    }
                                 }

                                 ArphexMod.queueServerWork(
                                    2, () -> TormentorAimProcedure.execute(world, entityiterator.getX(), entityiterator.getY(), entityiterator.getZ())
                                 );
                              }
                           } else if ((
                                    entity instanceof TORMENTOREntity _datEntIx
                                       ? (Integer)_datEntIx.getEntityData().get(TORMENTOREntity.DATA_time_since_attacked)
                                       : 0
                                 )
                                 < 12000
                              && Math.atan2(entityiterator.getX() - entity.getX(), entityiterator.getZ() - entity.getZ()) * 57.5
                                    - 0.0
                                    + ArphexModVariables.MapVariables.get(world).tormentor_rotation
                                 < 90.0
                              && Math.atan2(entityiterator.getX() - entity.getX(), entityiterator.getZ() - entity.getZ()) * 57.5
                                    - 0.0
                                    + ArphexModVariables.MapVariables.get(world).tormentor_rotation
                                 > -90.0) {
                              if ((entity instanceof TORMENTOREntity _datEntSxx
                                    ? (String)_datEntSxx.getEntityData().get(TORMENTOREntity.DATA_tormentcycle)
                                    : "")
                                 .equals("fold")) {
                                 entity.getPersistentData().putDouble("blastratetormentor", 10.0 - ArphexModVariables.MapVariables.get(world).tormentor_tier);
                                 if (world instanceof ServerLevel projectileLevel) {
                                    Projectile _entityToSpawn = (new Object() {
                                          public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                             AbstractArrow entityToSpawn = new TormentBlastEntity(
                                                (EntityType<? extends TormentBlastEntity>)ArphexModEntities.TORMENT_BLAST.get(), level
                                             );
                                             entityToSpawn.setOwner(shooter);
                                             entityToSpawn.setBaseDamage((double)damage);
                                             entityToSpawn.setKnockback(knockback);
                                             entityToSpawn.setSilent(true);
                                             return entityToSpawn;
                                          }
                                       })
                                       .getArrow(projectileLevel, entity, 0.0F, 0);
                                    _entityToSpawn.setPos(entity.getX(), entity.getY() - 5.0, entity.getZ());
                                    _entityToSpawn.shoot(1.0, 1.0, 1.0, 2.0F, 0.0F);
                                    projectileLevel.addFreshEntity(_entityToSpawn);
                                 }

                                 if (ArphexModVariables.MapVariables.get(world).tormentor_tier > 1.0) {
                                    if (!(entity.getPersistentData().getDouble("limit_time_distort") > 0.0)) {
                                       if (world instanceof ServerLevel _levelxxx) {
                                          Entity entityToSpawn = ((EntityType)ArphexModEntities.TIME_DISTORTION_WAVE.get())
                                             .spawn(
                                                _levelxxx,
                                                BlockPos.containing(
                                                   entityiterator.getX() + (double)Mth.nextInt(RandomSource.create(), -5, 5),
                                                   entityiterator.getY() + (double)Mth.nextInt(RandomSource.create(), -5, 5),
                                                   entityiterator.getZ() + (double)Mth.nextInt(RandomSource.create(), -5, 5)
                                                ),
                                                MobSpawnType.MOB_SUMMONED
                                             );
                                          if (entityToSpawn != null) {
                                          }
                                       }

                                       entity.getPersistentData().putDouble("limit_time_distort", 5.0);
                                    } else {
                                       entity.getPersistentData()
                                          .putDouble("limit_time_distort", entity.getPersistentData().getDouble("limit_time_distort") - 1.0);
                                    }

                                    if (world instanceof ServerLevel projectileLevel) {
                                       Projectile _entityToSpawn = (new Object() {
                                             public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                AbstractArrow entityToSpawn = new TormentBlastEntity(
                                                   (EntityType<? extends TormentBlastEntity>)ArphexModEntities.TORMENT_BLAST.get(), level
                                                );
                                                entityToSpawn.setOwner(shooter);
                                                entityToSpawn.setBaseDamage((double)damage);
                                                entityToSpawn.setKnockback(knockback);
                                                entityToSpawn.setSilent(true);
                                                return entityToSpawn;
                                             }
                                          })
                                          .getArrow(projectileLevel, entity, 0.0F, 0);
                                       _entityToSpawn.setPos(entity.getX(), entity.getY() - 5.0, entity.getZ());
                                       _entityToSpawn.shoot(1.0, 1.0, 1.0, 2.0F, 0.0F);
                                       projectileLevel.addFreshEntity(_entityToSpawn);
                                    }

                                    if (world instanceof ServerLevel projectileLevel) {
                                       Projectile _entityToSpawn = (new Object() {
                                             public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                AbstractArrow entityToSpawn = new TormentBlastEntity(
                                                   (EntityType<? extends TormentBlastEntity>)ArphexModEntities.TORMENT_BLAST.get(), level
                                                );
                                                entityToSpawn.setOwner(shooter);
                                                entityToSpawn.setBaseDamage((double)damage);
                                                entityToSpawn.setKnockback(knockback);
                                                entityToSpawn.setSilent(true);
                                                return entityToSpawn;
                                             }
                                          })
                                          .getArrow(projectileLevel, entity, 0.0F, 0);
                                       _entityToSpawn.setPos(entity.getX(), entity.getY() - 5.0, entity.getZ());
                                       _entityToSpawn.shoot(1.0, 1.0, 1.0, 2.0F, 0.0F);
                                       projectileLevel.addFreshEntity(_entityToSpawn);
                                    }

                                    if (ArphexModVariables.MapVariables.get(world).tormentor_tier > 2.0) {
                                       if (world instanceof ServerLevel projectileLevel) {
                                          Projectile _entityToSpawn = (new Object() {
                                                public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                   AbstractArrow entityToSpawn = new TormentBlastEntity(
                                                      (EntityType<? extends TormentBlastEntity>)ArphexModEntities.TORMENT_BLAST.get(), level
                                                   );
                                                   entityToSpawn.setOwner(shooter);
                                                   entityToSpawn.setBaseDamage((double)damage);
                                                   entityToSpawn.setKnockback(knockback);
                                                   entityToSpawn.setSilent(true);
                                                   return entityToSpawn;
                                                }
                                             })
                                             .getArrow(projectileLevel, entity, 0.0F, 0);
                                          _entityToSpawn.setPos(entity.getX(), entity.getY() - 5.0, entity.getZ());
                                          _entityToSpawn.shoot(1.0, 1.0, 1.0, 2.0F, 0.0F);
                                          projectileLevel.addFreshEntity(_entityToSpawn);
                                       }

                                       if (world instanceof ServerLevel projectileLevel) {
                                          Projectile _entityToSpawn = (new Object() {
                                                public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                   AbstractArrow entityToSpawn = new TormentBlastEntity(
                                                      (EntityType<? extends TormentBlastEntity>)ArphexModEntities.TORMENT_BLAST.get(), level
                                                   );
                                                   entityToSpawn.setOwner(shooter);
                                                   entityToSpawn.setBaseDamage((double)damage);
                                                   entityToSpawn.setKnockback(knockback);
                                                   entityToSpawn.setSilent(true);
                                                   return entityToSpawn;
                                                }
                                             })
                                             .getArrow(projectileLevel, entity, 0.0F, 0);
                                          _entityToSpawn.setPos(entity.getX(), entity.getY() - 5.0, entity.getZ());
                                          _entityToSpawn.shoot(1.0, 1.0, 1.0, 2.0F, 0.0F);
                                          projectileLevel.addFreshEntity(_entityToSpawn);
                                       }
                                    }
                                 }

                                 ArphexMod.queueServerWork(
                                    2, () -> TormentorAimProcedure.execute(world, entityiterator.getX(), entityiterator.getY(), entityiterator.getZ())
                                 );
                              } else if ((entity instanceof TORMENTOREntity _datEntSxx
                                    ? (String)_datEntSxx.getEntityData().get(TORMENTOREntity.DATA_tormentcycle)
                                    : "")
                                 .equals("splay")) {
                                 entity.getPersistentData().putDouble("blastratetormentor", 0.0);
                                 if (ArphexModVariables.MapVariables.get(world).tormentor_tier > 1.0) {
                                    if (world instanceof ServerLevel projectileLevel) {
                                       Projectile _entityToSpawn = (new Object() {
                                             public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                AbstractArrow entityToSpawn = new TormentRifleEntity(
                                                   (EntityType<? extends TormentRifleEntity>)ArphexModEntities.TORMENT_RIFLE.get(), level
                                                );
                                                entityToSpawn.setOwner(shooter);
                                                entityToSpawn.setBaseDamage((double)damage);
                                                entityToSpawn.setKnockback(knockback);
                                                entityToSpawn.setSilent(true);
                                                return entityToSpawn;
                                             }
                                          })
                                          .getArrow(projectileLevel, entity, 0.0F, 0);
                                       _entityToSpawn.setPos(entity.getX(), entity.getY() - 5.0, entity.getZ());
                                       _entityToSpawn.shoot(1.0, 1.0, 1.0, 2.0F, 0.0F);
                                       projectileLevel.addFreshEntity(_entityToSpawn);
                                    }

                                    if (ArphexModVariables.MapVariables.get(world).tormentor_tier > 2.0 && world instanceof ServerLevel projectileLevel) {
                                       Projectile _entityToSpawn = (new Object() {
                                             public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                AbstractArrow entityToSpawn = new TormentRifleEntity(
                                                   (EntityType<? extends TormentRifleEntity>)ArphexModEntities.TORMENT_RIFLE.get(), level
                                                );
                                                entityToSpawn.setOwner(shooter);
                                                entityToSpawn.setBaseDamage((double)damage);
                                                entityToSpawn.setKnockback(knockback);
                                                entityToSpawn.setSilent(true);
                                                return entityToSpawn;
                                             }
                                          })
                                          .getArrow(projectileLevel, entity, 0.0F, 0);
                                       _entityToSpawn.setPos(entity.getX(), entity.getY() - 5.0, entity.getZ());
                                       _entityToSpawn.shoot(1.0, 1.0, 1.0, 2.0F, 0.0F);
                                       projectileLevel.addFreshEntity(_entityToSpawn);
                                    }
                                 }

                                 ArphexMod.queueServerWork(
                                    2, () -> TormentorAimProcedure.execute(world, entityiterator.getX(), entityiterator.getY(), entityiterator.getZ())
                                 );
                              } else {
                                 entity.getPersistentData().putDouble("blastratetormentor", 0.0);
                                 if (entity.getY() > entityiterator.getY()) {
                                    if (world instanceof ServerLevel projectileLevel) {
                                       Projectile _entityToSpawn = (new Object() {
                                             public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                AbstractArrow entityToSpawn = new TormentRifleEntity(
                                                   (EntityType<? extends TormentRifleEntity>)ArphexModEntities.TORMENT_RIFLE.get(), level
                                                );
                                                entityToSpawn.setOwner(shooter);
                                                entityToSpawn.setBaseDamage((double)damage);
                                                entityToSpawn.setKnockback(knockback);
                                                entityToSpawn.setSilent(true);
                                                return entityToSpawn;
                                             }
                                          })
                                          .getArrow(projectileLevel, entity, 0.0F, 0);
                                       _entityToSpawn.setPos(entity.getX(), entity.getY() - 5.0, entity.getZ());
                                       _entityToSpawn.shoot(1.0, 1.0, 1.0, 2.0F, 0.0F);
                                       projectileLevel.addFreshEntity(_entityToSpawn);
                                    }

                                    if (ArphexModVariables.MapVariables.get(world).tormentor_tier > 1.0) {
                                       if (world instanceof ServerLevel projectileLevel) {
                                          Projectile _entityToSpawn = (new Object() {
                                                public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                   AbstractArrow entityToSpawn = new TormentRifleEntity(
                                                      (EntityType<? extends TormentRifleEntity>)ArphexModEntities.TORMENT_RIFLE.get(), level
                                                   );
                                                   entityToSpawn.setOwner(shooter);
                                                   entityToSpawn.setBaseDamage((double)damage);
                                                   entityToSpawn.setKnockback(knockback);
                                                   entityToSpawn.setSilent(true);
                                                   return entityToSpawn;
                                                }
                                             })
                                             .getArrow(projectileLevel, entity, 0.0F, 0);
                                          _entityToSpawn.setPos(entity.getX(), entity.getY() - 5.0, entity.getZ());
                                          _entityToSpawn.shoot(1.0, 1.0, 1.0, 2.0F, 0.0F);
                                          projectileLevel.addFreshEntity(_entityToSpawn);
                                       }

                                       if (ArphexModVariables.MapVariables.get(world).tormentor_tier > 2.0 && world instanceof ServerLevel projectileLevel) {
                                          Projectile _entityToSpawn = (new Object() {
                                                public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                   AbstractArrow entityToSpawn = new TormentRifleEntity(
                                                      (EntityType<? extends TormentRifleEntity>)ArphexModEntities.TORMENT_RIFLE.get(), level
                                                   );
                                                   entityToSpawn.setOwner(shooter);
                                                   entityToSpawn.setBaseDamage((double)damage);
                                                   entityToSpawn.setKnockback(knockback);
                                                   entityToSpawn.setSilent(true);
                                                   return entityToSpawn;
                                                }
                                             })
                                             .getArrow(projectileLevel, entity, 0.0F, 0);
                                          _entityToSpawn.setPos(entity.getX(), entity.getY() - 5.0, entity.getZ());
                                          _entityToSpawn.shoot(1.0, 1.0, 1.0, 2.0F, 0.0F);
                                          projectileLevel.addFreshEntity(_entityToSpawn);
                                       }
                                    }
                                 } else {
                                    if (world instanceof ServerLevel projectileLevel) {
                                       Projectile _entityToSpawn = (new Object() {
                                             public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                AbstractArrow entityToSpawn = new TormentRifleEntity(
                                                   (EntityType<? extends TormentRifleEntity>)ArphexModEntities.TORMENT_RIFLE.get(), level
                                                );
                                                entityToSpawn.setOwner(shooter);
                                                entityToSpawn.setBaseDamage((double)damage);
                                                entityToSpawn.setKnockback(knockback);
                                                entityToSpawn.setSilent(true);
                                                return entityToSpawn;
                                             }
                                          })
                                          .getArrow(projectileLevel, entity, 0.0F, 0);
                                       _entityToSpawn.setPos(entity.getX(), entity.getY() + (double)Mth.nextInt(RandomSource.create(), 35, 45), entity.getZ());
                                       _entityToSpawn.shoot(1.0, 1.0, 1.0, 2.0F, 0.0F);
                                       projectileLevel.addFreshEntity(_entityToSpawn);
                                    }

                                    if (ArphexModVariables.MapVariables.get(world).tormentor_tier > 1.0) {
                                       if (world instanceof ServerLevel projectileLevel) {
                                          Projectile _entityToSpawn = (new Object() {
                                                public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                   AbstractArrow entityToSpawn = new TormentRifleEntity(
                                                      (EntityType<? extends TormentRifleEntity>)ArphexModEntities.TORMENT_RIFLE.get(), level
                                                   );
                                                   entityToSpawn.setOwner(shooter);
                                                   entityToSpawn.setBaseDamage((double)damage);
                                                   entityToSpawn.setKnockback(knockback);
                                                   entityToSpawn.setSilent(true);
                                                   return entityToSpawn;
                                                }
                                             })
                                             .getArrow(projectileLevel, entity, 0.0F, 0);
                                          _entityToSpawn.setPos(
                                             entity.getX(), entity.getY() + (double)Mth.nextInt(RandomSource.create(), 35, 45), entity.getZ()
                                          );
                                          _entityToSpawn.shoot(1.0, 1.0, 1.0, 2.0F, 0.0F);
                                          projectileLevel.addFreshEntity(_entityToSpawn);
                                       }

                                       if (ArphexModVariables.MapVariables.get(world).tormentor_tier > 2.0 && world instanceof ServerLevel projectileLevel) {
                                          Projectile _entityToSpawn = (new Object() {
                                                public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                   AbstractArrow entityToSpawn = new TormentRifleEntity(
                                                      (EntityType<? extends TormentRifleEntity>)ArphexModEntities.TORMENT_RIFLE.get(), level
                                                   );
                                                   entityToSpawn.setOwner(shooter);
                                                   entityToSpawn.setBaseDamage((double)damage);
                                                   entityToSpawn.setKnockback(knockback);
                                                   entityToSpawn.setSilent(true);
                                                   return entityToSpawn;
                                                }
                                             })
                                             .getArrow(projectileLevel, entity, 0.0F, 0);
                                          _entityToSpawn.setPos(
                                             entity.getX(), entity.getY() + (double)Mth.nextInt(RandomSource.create(), 35, 45), entity.getZ()
                                          );
                                          _entityToSpawn.shoot(1.0, 1.0, 1.0, 2.0F, 0.0F);
                                          projectileLevel.addFreshEntity(_entityToSpawn);
                                       }
                                    }
                                 }

                                 ArphexMod.queueServerWork(
                                    2, () -> TormentorAimProcedure.execute(world, entityiterator.getX(), entityiterator.getY(), entityiterator.getZ())
                                 );
                              }
                           }

                           entity.getPersistentData()
                              .putString(
                                 "current_dimension",
                                 (entity.level().dimension() + "").replace("ResourceKey[minecraft:dimension / ", "").replace("]", "").strip()
                              );
                           wrap_yaw = (
                                    Math.toDegrees(Math.atan2(0.0 - (entityiterator.getX() - entity.getX()), entityiterator.getZ() - entity.getZ()))
                                       - ArphexModVariables.MapVariables.get(world).tormentor_rotation
                                       + 540.0
                                 )
                                 % 360.0
                              - 180.0;
                           if (Math.abs(wrap_yaw) > 1.0) {
                              if (wrap_yaw > 0.0) {
                                 ArphexMod.queueServerWork(7, () -> {
                                    ArphexModVariables.MapVariables.get(world).tormentor_rotation += 0.25;
                                    ArphexModVariables.MapVariables.get(world).syncData(world);
                                 });
                                 ArphexModVariables.MapVariables.get(world).tormentor_rotation += 0.25;
                                 ArphexModVariables.MapVariables.get(world).syncData(world);
                              } else {
                                 ArphexMod.queueServerWork(7, () -> {
                                    ArphexModVariables.MapVariables.get(world).tormentor_rotation -= 0.25;
                                    ArphexModVariables.MapVariables.get(world).syncData(world);
                                 });
                                 ArphexModVariables.MapVariables.get(world).tormentor_rotation -= 0.25;
                                 ArphexModVariables.MapVariables.get(world).syncData(world);
                              }
                           }

                           if (ArphexModVariables.MapVariables.get(world).tormentor_rotation > 180.0) {
                              ArphexModVariables.MapVariables.get(world).tormentor_rotation -= 360.0;
                              ArphexModVariables.MapVariables.get(world).syncData(world);
                           }

                           if (ArphexModVariables.MapVariables.get(world).tormentor_rotation < -180.0) {
                              ArphexModVariables.MapVariables.get(world).tormentor_rotation += 360.0;
                              ArphexModVariables.MapVariables.get(world).syncData(world);
                           }
                        }

                        if (entityiterator instanceof Player
                           && entityiterator.getPersistentData().getBoolean("tormentor_target")
                           && !entityiterator.getPersistentData().getBoolean("creativespectator")) {
                           if (ArphexModVariables.MapVariables.get(world).tormentor_target_follow.equals("empty")
                              || ArphexModVariables.MapVariables.get(world).tormentor_target_follow.equals("")) {
                              ArphexModVariables.MapVariables.get(world).tormentor_target_follow = entityiterator.getStringUUID();
                              ArphexModVariables.MapVariables.get(world).syncData(world);
                           } else if (entityiterator.getStringUUID().equals(ArphexModVariables.MapVariables.get(world).tormentor_target_follow)
                              && entity.getPersistentData().getBoolean("creativespectator")) {
                              ArphexModVariables.MapVariables.get(world).tormentor_target_follow = "empty";
                              ArphexModVariables.MapVariables.get(world).syncData(world);
                           }
                        }
                     } else if (entityiterator instanceof Player && !entityiterator.getPersistentData().getBoolean("creativespectator")) {
                        if (!ArphexModVariables.MapVariables.get(world).tormentor_target_follow.equals("empty")
                           && !ArphexModVariables.MapVariables.get(world).tormentor_target_follow.equals("")) {
                           if (entityiterator.getStringUUID().equals(ArphexModVariables.MapVariables.get(world).tormentor_target_follow)
                              && entity.getPersistentData().getBoolean("creativespectator")) {
                              ArphexModVariables.MapVariables.get(world).tormentor_target_follow = "empty";
                              ArphexModVariables.MapVariables.get(world).syncData(world);
                           }
                        } else {
                           ArphexModVariables.MapVariables.get(world).tormentor_target_follow = entityiterator.getStringUUID();
                           ArphexModVariables.MapVariables.get(world).syncData(world);
                        }
                     }

                     if (entityiterator instanceof TORMENTOREntity && entityiterator != entity) {
                        if (entity.getPersistentData().getDouble("tormentor_distance_to_target")
                           > entityiterator.getPersistentData().getDouble("tormentor_distance_to_target")) {
                           if (!entity.level().isClientSide()) {
                              entity.discard();
                           }
                        } else if (!entityiterator.level().isClientSide()) {
                           entityiterator.discard();
                        }
                     }
                  }
               }

               if ((entity instanceof TORMENTOREntity _datEntSxx ? (String)_datEntSxx.getEntityData().get(TORMENTOREntity.DATA_tormentcycle) : "")
                     .equals("splay")
                  && entity instanceof LivingEntity _livEnt360
                  && _livEnt360.hasEffect((MobEffect)ArphexModMobEffects.THUNDER_SENSE.get())) {
                  Vec3 _centerx = new Vec3(
                     entity.getPersistentData().getDouble("xver"),
                     entity.getY() + entity.getPersistentData().getDouble("yvertarget"),
                     entity.getPersistentData().getDouble("zver")
                  );

                  for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_centerx, _centerx).inflate(125.0), e -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                     .toList()) {
                     if (entityiteratorx.getPersistentData().getBoolean("tormentor_target")
                        && !(
                           ((ArphexModVariables.PlayerVariables)entityiteratorx.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                    .orElse(new ArphexModVariables.PlayerVariables()))
                                 .tormentor_respite
                              > 0.0
                        )) {
                        if (Math.sqrt(
                              (entity.getX() - entity.getPersistentData().getDouble("xver")) * (entity.getX() - entity.getPersistentData().getDouble("xver"))
                                 + (entity.getY() - (entity.getY() + entity.getPersistentData().getDouble("yvertarget")))
                                    * (entity.getY() - (entity.getY() + entity.getPersistentData().getDouble("yvertarget")))
                                 + (entity.getZ() - entity.getPersistentData().getDouble("zver"))
                                    * (entity.getZ() - entity.getPersistentData().getDouble("zver"))
                           )
                           > Math.sqrt(
                              (entity.getX() - entityiteratorx.getX()) * (entity.getX() - entityiteratorx.getX())
                                 + (entity.getY() - entityiteratorx.getY()) * (entity.getY() - entityiteratorx.getY())
                                 + (entity.getZ() - entityiteratorx.getZ()) * (entity.getZ() - entityiteratorx.getZ())
                           )) {
                           entity.getPersistentData().putDouble("yvtar", entity.getPersistentData().getDouble("yvtar") - 15.0);
                        } else {
                           entity.getPersistentData().putDouble("yvtar", entity.getPersistentData().getDouble("yvtar") + 15.0);
                        }

                        if (entityiteratorx.getY() > entity.getY() + entity.getPersistentData().getDouble("yvertarget")) {
                           entity.getPersistentData().putDouble("yvertarget", entity.getPersistentData().getDouble("yvertarget") + 30.0);
                        } else {
                           entity.getPersistentData().putDouble("yvertarget", entity.getPersistentData().getDouble("yvertarget") - 30.0);
                        }
                     }
                  }
               }

               if (entity instanceof TORMENTOREntity _datEntSetI) {
                  _datEntSetI.getEntityData().set(TORMENTOREntity.DATA_tormenttimer, 15);
               }
            } else if (entity instanceof TORMENTOREntity _datEntSetI) {
               _datEntSetI.getEntityData()
                  .set(
                     TORMENTOREntity.DATA_tormenttimer,
                     (entity instanceof TORMENTOREntity _datEntI ? (Integer)_datEntI.getEntityData().get(TORMENTOREntity.DATA_tormenttimer) : 0) - 1
                  );
            }
         }

         if (Mth.nextInt(RandomSource.create(), 1, 300) == 5 && world instanceof ServerLevel _levelxxxx) {
            LightningBolt entityToSpawn = (LightningBolt)EntityType.LIGHTNING_BOLT.create(_levelxxxx);
            entityToSpawn.moveTo(
               Vec3.atBottomCenterOf(
                  BlockPos.containing(
                     x + (double)Mth.nextInt(RandomSource.create(), -100, 100),
                     y + (double)Mth.nextInt(RandomSource.create(), -100, 40),
                     z + (double)Mth.nextInt(RandomSource.create(), -100, 100)
                  )
               )
            );
            _levelxxxx.addFreshEntity(entityToSpawn);
         }

         ArphexModVariables.MapVariables.get(world).tormentor_entity_loaded = 200.0;
         ArphexModVariables.MapVariables.get(world).syncData(world);
         if (world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()
            || (double)world.getHeight(Types.MOTION_BLOCKING_NO_LEAVES, (int)entity.getX(), (int)entity.getZ()) > entity.getY() - 190.0) {
            entity.setDeltaMovement(new Vec3(0.0, 0.3, 0.0));
         } else if ((double)world.getHeight(Types.MOTION_BLOCKING_NO_LEAVES, (int)entity.getX(), (int)entity.getZ()) < entity.getY() - 200.0) {
            entity.setDeltaMovement(new Vec3(0.0, -0.3, 0.0));
         }

         if (ArphexModVariables.MapVariables.get(world).tormentor_health > 0.0) {
            TORMENTOREntity tormentor = (TORMENTOREntity)entity;
            tormentor.deathTime = 0;
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect(MobEffects.GLOWING);
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect((MobEffect)ArphexModMobEffects.NECROSIS.get());
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect((MobEffect)ArphexModMobEffects.REPULSION.get());
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect((MobEffect)ArphexModMobEffects.VOIDLASHER_CHAOS_CONTROL.get());
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect((MobEffect)ArphexModMobEffects.WEBBED.get());
         }

         if (!(Boolean)ConfigurationSettingsConfiguration.DWELLERS_INCLUSION.get() && !entity.level().isClientSide()) {
            entity.discard();
         }

         if (!entity.getPersistentData().getBoolean("spawnedbyplayer") && !ArphexModVariables.MapVariables.get(world).tormentor_target_follow.equals("empty")) {
            if (entity.getX() + entity.getZ() <= ArphexModVariables.MapVariables.get(world).tormentor_distance_as_uuid + 1.0) {
               ArphexModVariables.MapVariables.get(world).tormentor_distance_as_uuid = entity.getX() + entity.getZ();
               ArphexModVariables.MapVariables.get(world).syncData(world);
            } else if (Math.abs(ArphexModVariables.MapVariables.get(world).tormentor_distance_as_uuid - (entity.getX() + entity.getZ())) > 20.0
               && ArphexModVariables.MapVariables.get(world).tormentor_distance_as_uuid != 9.99999999E8) {
               if (!entity.getPersistentData().getBoolean("check2sequence")) {
                  entity.getPersistentData().putBoolean("check2sequence", true);
               } else if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            }

            if (!ArphexModVariables.MapVariables.get(world)
               .tormentor_target_dimension
               .equals((entity.level().dimension() + "").replace("ResourceKey[minecraft:dimension / ", "").replace("]", "").strip())) {
               ArphexMod.queueServerWork(
                  5,
                  () -> {
                     if (!ArphexModVariables.MapVariables.get(world)
                           .tormentor_target_dimension
                           .equals((entity.level().dimension() + "").replace("ResourceKey[minecraft:dimension / ", "").replace("]", "").strip())
                        && !entity.level().isClientSide()) {
                        entity.discard();
                     }
                  }
               );
            }
         }

         if (entity.getPersistentData().getBoolean("check2sequence")) {
            ArphexMod.queueServerWork(2, () -> entity.getPersistentData().putBoolean("check2sequence", false));
         }

         if (world.getBlockState(BlockPos.containing(x, entity.getY(), z)).getBlock() == Blocks.VOID_AIR) {
            if (entity.getY() < 0.0) {
               entity.teleportTo(entity.getX(), entity.getY() + 100.0, entity.getZ());
               if (entity instanceof ServerPlayer _serverPlayer) {
                  _serverPlayer.connection.teleport(entity.getX(), entity.getY() + 100.0, entity.getZ(), entity.getYRot(), entity.getXRot());
               }
            } else if (entity.getY() > 100.0) {
               if (!(entity.getPersistentData().getDouble("scandown") < 400.0)) {
                  entity.getPersistentData().putDouble("scandown", 0.0);
               } else {
                  for (int index4 = 0; index4 < 5; index4++) {
                     entity.getPersistentData().putDouble("scandown", entity.getPersistentData().getDouble("scandown") + 1.0);
                     if (ArphexModVariables.MapVariables.get(world).tormentor_target_y < entity.getY() - entity.getPersistentData().getDouble("scandown")
                        && world.getBlockState(
                              BlockPos.containing(entity.getX(), entity.getY() - entity.getPersistentData().getDouble("scandown"), entity.getZ())
                           )
                           .canOcclude()) {
                        entity.getPersistentData().putDouble("scandown", 400.0);
                        if (!world.getBlockState(
                                 BlockPos.containing(entity.getX(), entity.getY() - entity.getPersistentData().getDouble("scandown") + 1.0, entity.getZ())
                              )
                              .canOcclude()
                           && !(
                              world.getBlockState(
                                       BlockPos.containing(entity.getX(), entity.getY() - entity.getPersistentData().getDouble("scandown"), entity.getZ())
                                    )
                                    .getDestroySpeed(
                                       world,
                                       BlockPos.containing(entity.getX(), entity.getY() - entity.getPersistentData().getDouble("scandown"), entity.getZ())
                                    )
                                 > 0.0F
                           )) {
                           entity.teleportTo(entity.getX(), entity.getY() - 100.0, entity.getZ());
                           if (entity instanceof ServerPlayer _serverPlayer) {
                              _serverPlayer.connection.teleport(entity.getX(), entity.getY() - 100.0, entity.getZ(), entity.getYRot(), entity.getXRot());
                           }
                        }
                     }
                  }
               }
            }
         }

         ArphexModVariables.MapVariables.get(world).tormentor_x = entity.getX();
         ArphexModVariables.MapVariables.get(world).syncData(world);
         ArphexModVariables.MapVariables.get(world).tormentor_y = entity.getY();
         ArphexModVariables.MapVariables.get(world).syncData(world);
         ArphexModVariables.MapVariables.get(world).tormentor_z = entity.getZ();
         ArphexModVariables.MapVariables.get(world).syncData(world);
         if (ArphexModVariables.MapVariables.get(world).reload_render) {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }

            ArphexModVariables.MapVariables.get(world).reload_render = false;
            ArphexModVariables.MapVariables.get(world).syncData(world);
         }

         if (entity.getPersistentData().getDouble("justspawnedminion") > 0.0) {
            entity.getPersistentData().putDouble("justspawnedminion", entity.getPersistentData().getDouble("justspawnedminion") - 1.0);
         }

         if (entity.getPersistentData().getDouble("justspawnedtendril") > 0.0) {
            entity.getPersistentData().putDouble("justspawnedtendril", entity.getPersistentData().getDouble("justspawnedtendril") - 1.0);
         }

         if (entity instanceof TORMENTOREntity _datEntSetI) {
            _datEntSetI.getEntityData()
               .set(
                  TORMENTOREntity.DATA_time_since_attacked,
                  (entity instanceof TORMENTOREntity _datEntI ? (Integer)_datEntI.getEntityData().get(TORMENTOREntity.DATA_time_since_attacked) : 0) + 1
               );
         }

         if ((entity instanceof TORMENTOREntity _datEntI ? (Integer)_datEntI.getEntityData().get(TORMENTOREntity.DATA_time_since_attacked) : 0) > 12000) {
            if (entity instanceof TORMENTOREntity _datEntSetS) {
               _datEntSetS.getEntityData().set(TORMENTOREntity.DATA_tormentcycle, "default");
            }
         } else if ((entity instanceof TORMENTOREntity _datEntIxx ? (Integer)_datEntIxx.getEntityData().get(TORMENTOREntity.DATA_tormentswitch) : 0) <= 0) {
            if (entity instanceof TORMENTOREntity _datEntSetI) {
               _datEntSetI.getEntityData().set(TORMENTOREntity.DATA_tormentswitch, Mth.nextInt(RandomSource.create(), 1200, 2400));
            }

            if (ArphexModVariables.MapVariables.get(world).tormentor_shuffle_num > 1.0) {
               ArphexModVariables.MapVariables.get(world).tormentor_shuffle_num--;
               ArphexModVariables.MapVariables.get(world).syncData(world);
            } else {
               ArphexModVariables.MapVariables.get(world).tormentor_shuffle_num = 3.0;
               ArphexModVariables.MapVariables.get(world).syncData(world);
               order_random = "";
               step_count = ArphexModVariables.MapVariables.get(world).tormentor_shuffle_num;

               for (int index5 = 0; index5 < 100; index5++) {
                  num_iterate = (double)Math.round((float)Mth.nextInt(RandomSource.create(), 1, (int)step_count));
                  if (!((double)order_random.length() < step_count)) {
                     break;
                  }

                  if (!order_random.contains(new DecimalFormat("##.##").format(Math.round(num_iterate)).strip())) {
                     order_random = order_random + Math.round(num_iterate);
                  }
               }

               ArphexModVariables.MapVariables.get(world).tormentor_shuffle = order_random;
               ArphexModVariables.MapVariables.get(world).syncData(world);
            }

            num_iterate = ArphexModVariables.MapVariables.get(world).tormentor_shuffle_num;
            lock_steps = ArphexModVariables.MapVariables.get(world).tormentor_shuffle_num;
            position_to_check = ArphexModVariables.MapVariables.get(world).tormentor_shuffle_num;
            order_random = ArphexModVariables.MapVariables.get(world).tormentor_shuffle;
            step_count = 3.0;
            lock_steps = position_to_check;

            for (int index6 = 0; index6 < (int)lock_steps; index6++) {
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
            ArphexModVariables.MapVariables.get(world).tormentor_final_shuffle = num_iterate;
            ArphexModVariables.MapVariables.get(world).syncData(world);
            if (ArphexModVariables.MapVariables.get(world).tormentor_final_shuffle == 1.0) {
               if (entity instanceof TORMENTOREntity _datEntSetS) {
                  _datEntSetS.getEntityData().set(TORMENTOREntity.DATA_tormentcycle, "default");
               }
            } else if (ArphexModVariables.MapVariables.get(world).tormentor_final_shuffle == 2.0) {
               if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getHealth() : -1.0F) < 512.0F
                  && entity instanceof LivingEntity _livEnt504
                  && _livEnt504.hasEffect((MobEffect)ArphexModMobEffects.THUNDER_SENSE.get())
                  && world.getEntitiesOfClass(TormentorSphereEntity.class, AABB.ofSize(new Vec3(x, y, z), 400.0, 400.0, 400.0), e -> true).isEmpty()) {
                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get(), 200, 0, false, false));
                  }

                  if (world instanceof ServerLevel _levelxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.TORMENTOR_SPHERE.get())
                        .spawn(_levelxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               }

               if (entity instanceof TORMENTOREntity _datEntSetS) {
                  _datEntSetS.getEntityData().set(TORMENTOREntity.DATA_tormentcycle, "splay");
               }
            } else {
               if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getHealth() : -1.0F) < 200.0F
                  && world.getEntitiesOfClass(TormentorLaserEntity.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), e -> true).isEmpty()
                  && world instanceof ServerLevel _levelxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.TORMENTOR_LASER.get())
                     .spawn(_levelxxxxx, BlockPos.containing(x, y + 20.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               if (entity instanceof TORMENTOREntity _datEntSetS) {
                  _datEntSetS.getEntityData().set(TORMENTOREntity.DATA_tormentcycle, "fold");
               }
            }
         } else if (entity instanceof TORMENTOREntity _datEntSetI) {
            _datEntSetI.getEntityData()
               .set(
                  TORMENTOREntity.DATA_tormentswitch,
                  (entity instanceof TORMENTOREntity _datEntIxx ? (Integer)_datEntIxx.getEntityData().get(TORMENTOREntity.DATA_tormentswitch) : 0) - 1
               );
         }

         if ((entity instanceof TORMENTOREntity _datEntSxx ? (String)_datEntSxx.getEntityData().get(TORMENTOREntity.DATA_tormentcycle) : "").equals("splay")
            && entity instanceof LivingEntity _livEnt516
            && _livEnt516.hasEffect((MobEffect)ArphexModMobEffects.THUNDER_SENSE.get())
            && entity.isAlive()) {
            entity.getPersistentData().putDouble("particlecount", 160.0);
            if (entity.getPersistentData().getBoolean("upspiral")) {
               if (entity.getPersistentData().getDouble("yvertarget") < 250.0) {
                  entity.getPersistentData().putDouble("yvertarget", entity.getPersistentData().getDouble("yvertarget") + 0.9);
               } else {
                  entity.getPersistentData().putBoolean("upspiral", false);
               }
            } else if (entity.getPersistentData().getDouble("yvertarget") > -250.0) {
               entity.getPersistentData().putDouble("yvertarget", entity.getPersistentData().getDouble("yvertarget") - 0.9);
            } else {
               entity.getPersistentData().putBoolean("upspiral", true);
            }

            if (entity.getPersistentData().getBoolean("outspiral")) {
               if (entity.getPersistentData().getDouble("yvtar") < 200.0) {
                  entity.getPersistentData().putDouble("yvtar", entity.getPersistentData().getDouble("yvtar") + 0.3);
               } else {
                  entity.getPersistentData().putBoolean("outspiral", false);
               }
            } else if (entity.getPersistentData().getDouble("yvtar") > -230.0) {
               entity.getPersistentData().putDouble("yvtar", entity.getPersistentData().getDouble("yvtar") - 0.3);
            } else {
               entity.getPersistentData().putBoolean("outspiral", true);
            }

            entity.getPersistentData().putDouble("radius", 250.0 + entity.getPersistentData().getDouble("yvtar"));
            if (entity.getPersistentData().getDouble("loop") < entity.getPersistentData().getDouble("particlecount")) {
               entity.getPersistentData()
                  .putDouble(
                     "xver",
                     entity.getX()
                        + 0.5
                        + Math.cos((Math.PI * 2) / entity.getPersistentData().getDouble("particlecount") * entity.getPersistentData().getDouble("loop"))
                           * entity.getPersistentData().getDouble("radius")
                  );
               entity.getPersistentData()
                  .putDouble(
                     "zver",
                     entity.getZ()
                        + 0.5
                        + Math.sin((Math.PI * 2) / entity.getPersistentData().getDouble("particlecount") * entity.getPersistentData().getDouble("loop"))
                           * entity.getPersistentData().getDouble("radius")
                  );
               if (world instanceof ServerLevel _levelxxxxxx) {
                  _levelxxxxxx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL,
                              new Vec3(
                                 entity.getPersistentData().getDouble("xver"),
                                 entity.getY() + entity.getPersistentData().getDouble("yvertarget"),
                                 entity.getPersistentData().getDouble("zver")
                              ),
                              Vec2.ZERO,
                              _levelxxxxxx,
                              4,
                              "",
                              Component.literal(""),
                              _levelxxxxxx.getServer(),
                              null
                           )
                           .withSuppressedOutput(),
                        "particle arphex:torment_spiralling ~ ~ ~ 0 0 0 0 1 force"
                     );
               }

               if (world instanceof ServerLevel _levelxxxxxx) {
                  _levelxxxxxx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL,
                              new Vec3(
                                 entity.getPersistentData().getDouble("xver"),
                                 entity.getY() + entity.getPersistentData().getDouble("yvertarget"),
                                 entity.getPersistentData().getDouble("zver")
                              ),
                              Vec2.ZERO,
                              _levelxxxxxx,
                              4,
                              "",
                              Component.literal(""),
                              _levelxxxxxx.getServer(),
                              null
                           )
                           .withSuppressedOutput(),
                        "effect give @e[distance=..30] arphex:torment_spiral 1 1 true"
                     );
               }

               entity.getPersistentData().putDouble("loop", entity.getPersistentData().getDouble("loop") + 1.0);
            } else {
               entity.getPersistentData().putDouble("loop", 0.0);
            }
         }

         if (entity.getPersistentData().getBoolean("tormentor_target")) {
            entity.getPersistentData().putBoolean("tormentor_target", false);
         }

         if (!ArphexModVariables.MapVariables.get(world).tormentor_target_dimension.contains(":")) {
            ArphexModVariables.MapVariables.get(world).tormentor_target_dimension = (entity.level().dimension() + "")
               .replace("ResourceKey[minecraft:dimension / ", "")
               .replace("]", "")
               .strip();
            ArphexModVariables.MapVariables.get(world).syncData(world);
         }

         if ("1.20.1".startsWith("1.19.4") && world instanceof ServerLevel _levelxxxxxx) {
            _levelxxxxxx.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                        CommandSource.NULL,
                        new Vec3(entity.getX(), entity.getY(), entity.getZ()),
                        Vec2.ZERO,
                        _levelxxxxxx,
                        4,
                        "",
                        Component.literal(""),
                        _levelxxxxxx.getServer(),
                        null
                     )
                     .withSuppressedOutput(),
                  "particle arphex:small_white_glow_smoke ~ ~ ~ 0 0 0 0.1 2 force"
               );
         }

         if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 1.0) {
            entity.setCustomName(Component.literal("§cTORMENTOR"));
         } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 2.0) {
            entity.setCustomName(Component.literal("§cTORMENTOR §b(TIER 2)"));
         } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 3.0) {
            entity.setCustomName(Component.literal("§cTORMENTOR §d(TIER 3)"));
         } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 4.0) {
            entity.setCustomName(Component.literal("§cTORMENTOR §6(TIER 4)"));
         } else {
            entity.setCustomName(Component.literal("§cTORMENTOR §4(TIER 5)"));
         }

         if (ArphexModVariables.MapVariables.get(world).tormentor_hitbox_split > 0.0) {
            entity.setInvisible(true);
         } else {
            entity.setInvisible(false);
         }

         entity.teleportTo(
            ArphexModVariables.MapVariables.get(world).tormentor_x,
            ArphexModVariables.MapVariables.get(world).tormentor_y,
            ArphexModVariables.MapVariables.get(world).tormentor_z
         );
         if (entity instanceof ServerPlayer _serverPlayer) {
            _serverPlayer.connection
               .teleport(
                  ArphexModVariables.MapVariables.get(world).tormentor_x,
                  ArphexModVariables.MapVariables.get(world).tormentor_y,
                  ArphexModVariables.MapVariables.get(world).tormentor_z,
                  entity.getYRot(),
                  entity.getXRot()
               );
         }

         entity.setDeltaMovement(new Vec3(0.0, entity.getDeltaMovement().y(), 0.0));
      }
   }
}
