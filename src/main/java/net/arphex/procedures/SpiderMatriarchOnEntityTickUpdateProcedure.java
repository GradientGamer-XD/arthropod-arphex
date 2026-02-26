package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.SpiderMatriarchEntity;
import net.arphex.init.ArphexModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class SpiderMatriarchOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double scandown = 0.0;
         double expand = 0.0;
         double lineZ = 0.0;
         double lineY = 0.0;
         double lineX = 0.0;
         Entity attack_target = null;
         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect(MobEffects.LEVITATION);
         }

         if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
            attack_target = entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null;
         }

         if ((entity instanceof SpiderMatriarchEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderMatriarchEntity.DATA_lunge_time) : 0) <= 0) {
            if (attack_target != null) {
               if (entity instanceof SpiderMatriarchEntity _datEntSetI) {
                  _datEntSetI.getEntityData()
                     .set(
                        SpiderMatriarchEntity.DATA_store_target_distance,
                        (int)Math.sqrt(
                           (entity.getX() - attack_target.getX()) * (entity.getX() - attack_target.getX())
                              + (entity.getY() - attack_target.getY()) * (entity.getY() - attack_target.getY())
                              + (entity.getZ() - attack_target.getZ()) * (entity.getZ() - attack_target.getZ())
                        )
                     );
               }

               if ((
                     (
                              entity instanceof SpiderMatriarchEntity _datEntIxx
                                 ? (Integer)_datEntIxx.getEntityData().get(SpiderMatriarchEntity.DATA_store_target_distance)
                                 : 0
                           )
                           > 20
                        || (
                              entity instanceof SpiderMatriarchEntity _datEntIx
                                 ? (Integer)_datEntIx.getEntityData().get(SpiderMatriarchEntity.DATA_time_since_landing_attack)
                                 : 0
                           )
                           > 398
                  )
                  && entity instanceof SpiderMatriarchEntity) {
                  ((SpiderMatriarchEntity)entity).setAnimation("animation.spider_wolf.leap");
               }

               if (entity instanceof SpiderMatriarchEntity _datEntSetI) {
                  _datEntSetI.getEntityData().set(SpiderMatriarchEntity.DATA_lunge_time, 600);
               }
            }
         } else {
            if ((
                     entity instanceof SpiderMatriarchEntity _datEntIxx
                        ? (Integer)_datEntIxx.getEntityData().get(SpiderMatriarchEntity.DATA_store_target_distance)
                        : 0
                  )
                  > 20
               || (
                     entity instanceof SpiderMatriarchEntity _datEntIx
                        ? (Integer)_datEntIx.getEntityData().get(SpiderMatriarchEntity.DATA_time_since_landing_attack)
                        : 0
                  )
                  > 398) {
               if ((entity instanceof SpiderMatriarchEntity _datEntIxxx ? (Integer)_datEntIxxx.getEntityData().get(SpiderMatriarchEntity.DATA_lunge_time) : 0)
                  > 562) {
                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 10, false, false));
                  }

                  entity.setDeltaMovement(new Vec3(0.0, entity.getDeltaMovement().y(), 0.0));
               } else {
                  if ((
                           entity instanceof SpiderMatriarchEntity _datEntIxxx
                              ? (Integer)_datEntIxxx.getEntityData().get(SpiderMatriarchEntity.DATA_lunge_time)
                              : 0
                        )
                        == 562
                     && attack_target != null) {
                     if (entity instanceof SpiderMatriarchEntity _datEntSetI) {
                        _datEntSetI.getEntityData()
                           .set(
                              SpiderMatriarchEntity.DATA_store_target_distance,
                              (int)Math.sqrt(
                                 (entity.getX() - attack_target.getX()) * (entity.getX() - attack_target.getX())
                                    + (entity.getY() - attack_target.getY()) * (entity.getY() - attack_target.getY())
                                    + (entity.getZ() - attack_target.getZ()) * (entity.getZ() - attack_target.getZ())
                              )
                           );
                     }

                     if ((Boolean)ConfigurationSettingsConfiguration.ARPHEX_GRIEFING.get()
                        && world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)
                        && world.getBlockState(
                                 BlockPos.containing(
                                    attack_target.getX(),
                                    (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getY() + 1.0,
                                    (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getZ()
                                 )
                              )
                              .getBlock()
                           != ArphexModBlocks.SPIDER_COCOON_PLAYER.get()
                        && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) > 15.0F
                        && world instanceof Level _level
                        && !_level.isClientSide()) {
                        _level.explode(null, entity.getX(), entity.getY() + 1.0, entity.getZ(), 7.0F, ExplosionInteraction.MOB);
                     }

                     if (0.5
                           * (double)(
                              entity instanceof SpiderMatriarchEntity _datEntIxxxx
                                 ? (Integer)_datEntIxxxx.getEntityData().get(SpiderMatriarchEntity.DATA_store_target_distance)
                                 : 0
                           )
                        != 0.0) {
                        entity.getPersistentData()
                           .putDouble(
                              "store_target_x",
                              (attack_target.getX() - entity.getX())
                                 / (
                                    0.3
                                       * (double)(
                                          entity instanceof SpiderMatriarchEntity _datEntIxxxxx
                                             ? (Integer)_datEntIxxxxx.getEntityData().get(SpiderMatriarchEntity.DATA_store_target_distance)
                                             : 0
                                       )
                                 )
                           );
                        entity.getPersistentData()
                           .putDouble(
                              "store_target_y",
                              (attack_target.getY() + 0.5 - entity.getY())
                                 / (
                                    0.3
                                       * (double)(
                                          entity instanceof SpiderMatriarchEntity _datEntIxxxxxx
                                             ? (Integer)_datEntIxxxxxx.getEntityData().get(SpiderMatriarchEntity.DATA_store_target_distance)
                                             : 0
                                       )
                                 )
                           );
                        entity.getPersistentData()
                           .putDouble(
                              "store_target_z",
                              (attack_target.getZ() - entity.getZ())
                                 / (
                                    0.3
                                       * (double)(
                                          entity instanceof SpiderMatriarchEntity _datEntIxxxxxxx
                                             ? (Integer)_datEntIxxxxxxx.getEntityData().get(SpiderMatriarchEntity.DATA_store_target_distance)
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

                  if ((
                        entity instanceof SpiderMatriarchEntity _datEntIxxx
                           ? (Integer)_datEntIxxx.getEntityData().get(SpiderMatriarchEntity.DATA_lunge_time)
                           : 0
                     )
                     > 500) {
                     entity.setDeltaMovement(
                        new Vec3(
                           entity.getPersistentData().getDouble("store_target_x"),
                           entity.getDeltaMovement().y(),
                           entity.getPersistentData().getDouble("store_target_z")
                        )
                     );
                     if (entity.getPersistentData().getBoolean("reverse_low")) {
                        if (world instanceof ServerLevel _level) {
                           _level.getServer()
                              .getCommands()
                              .performPrefixedCommand(
                                 new CommandSourceStack(
                                       CommandSource.NULL,
                                       new Vec3(entity.getX(), entity.getY() - 0.5, entity.getZ()),
                                       Vec2.ZERO,
                                       _level,
                                       4,
                                       "",
                                       Component.literal(""),
                                       _level.getServer(),
                                       null
                                    )
                                    .withSuppressedOutput(),
                                 "particle arphex:rope_web ~ ~ ~ 0.1 0.2 0.1 0 20 force"
                              );
                        }

                        entity.getPersistentData().putDouble("store_target_x", entity.getPersistentData().getDouble("store_target_x") * 0.85);
                        entity.getPersistentData().putDouble("store_target_y", -0.2);
                        entity.getPersistentData().putDouble("store_target_z", entity.getPersistentData().getDouble("store_target_z") * 0.85);
                     }

                     if (0.6
                           * (double)(
                              entity instanceof SpiderMatriarchEntity _datEntIxxxx
                                 ? (Integer)_datEntIxxxx.getEntityData().get(SpiderMatriarchEntity.DATA_store_target_distance)
                                 : 0
                           )
                        != 0.0) {
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 5, 1, false, false));
                        }

                        if (entity.getPersistentData().getBoolean("allow_one_reversal")) {
                           if ((
                                 entity instanceof SpiderMatriarchEntity _datEntIxxxxx
                                    ? (Integer)_datEntIxxxxx.getEntityData().get(SpiderMatriarchEntity.DATA_lunge_time)
                                    : 0
                              )
                              > 530) {
                              entity.setDeltaMovement(
                                 new Vec3(entity.getDeltaMovement().x(), entity.getPersistentData().getDouble("store_target_y"), entity.getDeltaMovement().z())
                              );
                           } else {
                              entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), -0.1, entity.getDeltaMovement().z()));
                           }

                           if ((double)(
                                 entity instanceof SpiderMatriarchEntity _datEntIxxxxx
                                    ? (Integer)_datEntIxxxxx.getEntityData().get(SpiderMatriarchEntity.DATA_store_target_distance)
                                    : 0
                              )
                              < Math.sqrt(
                                 (entity.getX() - entity.getPersistentData().getDouble("store_own_x"))
                                       * (entity.getX() - entity.getPersistentData().getDouble("store_own_x"))
                                    + (entity.getY() - entity.getPersistentData().getDouble("store_own_y"))
                                       * (entity.getY() - entity.getPersistentData().getDouble("store_own_y"))
                                    + (entity.getZ() - entity.getPersistentData().getDouble("store_own_z"))
                                       * (entity.getZ() - entity.getPersistentData().getDouble("store_own_z"))
                              )) {
                              entity.getPersistentData().putBoolean("allow_one_reversal", false);
                              entity.getPersistentData().putDouble("store_target_y", 0.0);
                           }
                        } else if (attack_target != null) {
                           if (!entity.getPersistentData().getBoolean("locked_reverse")) {
                              if (!world.getBlockState(
                                       BlockPos.containing(
                                          attack_target.getX(),
                                          attack_target.getY() + entity.getPersistentData().getDouble("store_target_y"),
                                          attack_target.getZ()
                                       )
                                    )
                                    .canOcclude()
                                 && !world.getBlockState(
                                       BlockPos.containing(
                                          attack_target.getX(),
                                          attack_target.getY() + entity.getPersistentData().getDouble("store_target_y") - 1.0,
                                          attack_target.getZ()
                                       )
                                    )
                                    .canOcclude()) {
                                 entity.getPersistentData().putDouble("store_target_y", entity.getPersistentData().getDouble("store_target_y") - 2.0);
                              } else if (Math.abs(entity.getPersistentData().getDouble("store_target_y")) > 0.0) {
                                 if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ())).canOcclude()) {
                                    entity.getPersistentData().putBoolean("reverse_low", true);
                                 } else if (!entity.getPersistentData().getBoolean("reverse_low")) {
                                    entity.getPersistentData().putDouble("webline_x", attack_target.getX());
                                    entity.getPersistentData()
                                       .putDouble("webline_y", attack_target.getY() + entity.getPersistentData().getDouble("store_target_y"));
                                    entity.getPersistentData().putDouble("webline_z", attack_target.getZ());
                                    if (entity instanceof SpiderMatriarchEntity _datEntSetI) {
                                       _datEntSetI.getEntityData()
                                          .set(
                                             SpiderMatriarchEntity.DATA_store_target_distance,
                                             (int)Math.sqrt(
                                                (entity.getX() - attack_target.getX()) * (entity.getX() - attack_target.getX())
                                                   + (entity.getY() - attack_target.getY()) * (entity.getY() - attack_target.getY())
                                                   + (entity.getZ() - attack_target.getZ()) * (entity.getZ() - attack_target.getZ())
                                             )
                                          );
                                    }

                                    entity.getPersistentData()
                                       .putDouble(
                                          "store_target_x",
                                          (attack_target.getX() - entity.getX())
                                             / (double)(
                                                entity instanceof SpiderMatriarchEntity _datEntIxxxxx
                                                   ? (Integer)_datEntIxxxxx.getEntityData().get(SpiderMatriarchEntity.DATA_store_target_distance)
                                                   : 0
                                             )
                                             * 6.0
                                       );
                                    entity.getPersistentData()
                                       .putDouble(
                                          "store_target_y",
                                          (attack_target.getY() + entity.getPersistentData().getDouble("store_target_y") - entity.getY())
                                             / (double)(
                                                entity instanceof SpiderMatriarchEntity _datEntIxxxxxx
                                                   ? (Integer)_datEntIxxxxxx.getEntityData().get(SpiderMatriarchEntity.DATA_store_target_distance)
                                                   : 0
                                             )
                                             * 6.0
                                       );
                                    entity.getPersistentData()
                                       .putDouble(
                                          "store_target_z",
                                          (attack_target.getZ() - entity.getZ())
                                             / (double)(
                                                entity instanceof SpiderMatriarchEntity _datEntIxxxxxxx
                                                   ? (Integer)_datEntIxxxxxxx.getEntityData().get(SpiderMatriarchEntity.DATA_store_target_distance)
                                                   : 0
                                             )
                                             * 6.0
                                       );
                                    entity.getPersistentData().putBoolean("locked_reverse", true);
                                 }
                              }
                           } else if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ())).canOcclude()) {
                              if (world instanceof ServerLevel _level) {
                                 _level.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                       new CommandSourceStack(
                                             CommandSource.NULL,
                                             new Vec3(entity.getX(), entity.getY() - 0.5, entity.getZ()),
                                             Vec2.ZERO,
                                             _level,
                                             4,
                                             "",
                                             Component.literal(""),
                                             _level.getServer(),
                                             null
                                          )
                                          .withSuppressedOutput(),
                                       "particle arphex:rope_web ~ ~ ~ 0.05 0.2 0.05 0 10 force"
                                    );
                              }

                              entity.setDeltaMovement(new Vec3(0.0, entity.getDeltaMovement().y(), 0.0));
                           } else {
                              lineX = entity.getX() - entity.getPersistentData().getDouble("webline_x");
                              lineY = entity.getY() - entity.getPersistentData().getDouble("webline_y");
                              lineZ = entity.getZ() - entity.getPersistentData().getDouble("webline_z");
                              expand = expand;

                              for (int index0 = 0; index0 < 20; index0++) {
                                 if (world instanceof ServerLevel _level) {
                                    _level.getServer()
                                       .getCommands()
                                       .performPrefixedCommand(
                                          new CommandSourceStack(
                                                CommandSource.NULL,
                                                new Vec3(entity.getX() + lineX * expand, entity.getY() + lineY * expand, entity.getZ() + lineZ * expand),
                                                Vec2.ZERO,
                                                _level,
                                                4,
                                                "",
                                                Component.literal(""),
                                                _level.getServer(),
                                                null
                                             )
                                             .withSuppressedOutput(),
                                          "particle arphex:rope_web ~ ~ ~ 0.05 0.2 0.05 0 10 force"
                                       );
                                 }

                                 expand -= 0.05;
                              }

                              entity.setDeltaMovement(
                                 new Vec3(
                                    entity.getPersistentData().getDouble("store_target_x"),
                                    entity.getPersistentData().getDouble("store_target_y") - 0.1,
                                    entity.getPersistentData().getDouble("store_target_z")
                                 )
                              );
                              ArphexMod.queueServerWork(
                                 1,
                                 () -> {
                                    if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ())).canOcclude()) {
                                       if (world instanceof ServerLevel _levelx) {
                                          _levelx.getServer()
                                             .getCommands()
                                             .performPrefixedCommand(
                                                new CommandSourceStack(
                                                      CommandSource.NULL,
                                                      new Vec3(entity.getX(), entity.getY() - 0.5, entity.getZ()),
                                                      Vec2.ZERO,
                                                      _levelx,
                                                      4,
                                                      "",
                                                      Component.literal(""),
                                                      _levelx.getServer(),
                                                      null
                                                   )
                                                   .withSuppressedOutput(),
                                                "particle arphex:rope_web ~ ~ ~ 0.05 0.2 0.05 0 10 force"
                                             );
                                       }

                                       entity.setDeltaMovement(new Vec3(0.0, entity.getDeltaMovement().y(), 0.0));
                                    }
                                 }
                              );
                           }
                        }
                     }
                  }
               }
            }

            if (entity instanceof SpiderMatriarchEntity _datEntSetI) {
               _datEntSetI.getEntityData()
                  .set(
                     SpiderMatriarchEntity.DATA_lunge_time,
                     (entity instanceof SpiderMatriarchEntity _datEntIxxx ? (Integer)_datEntIxxx.getEntityData().get(SpiderMatriarchEntity.DATA_lunge_time) : 0)
                        - 1
                  );
            }
         }

         if ((entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)
            > (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 2.0F) {
            if ((entity instanceof SpiderMatriarchEntity _datEntIxxx ? (Integer)_datEntIxxx.getEntityData().get(SpiderMatriarchEntity.DATA_eggs_grow) : 0)
               > 998) {
               if (entity instanceof SpiderMatriarchEntity animatable) {
                  animatable.setTexture("wolfspider3egg");
               }
            } else if (entity instanceof SpiderMatriarchEntity animatable) {
               animatable.setTexture("wolfspider3");
            }
         } else if (entity instanceof SpiderMatriarchEntity animatable) {
            animatable.setTexture("wolfspiderlow");
         }

         if ((
                  entity instanceof SpiderMatriarchEntity _datEntIxxxx
                     ? (Integer)_datEntIxxxx.getEntityData().get(SpiderMatriarchEntity.DATA_time_since_landing_attack)
                     : 0
               )
               < 400
            && entity instanceof SpiderMatriarchEntity _datEntSetI) {
            _datEntSetI.getEntityData()
               .set(
                  SpiderMatriarchEntity.DATA_time_since_landing_attack,
                  (
                        entity instanceof SpiderMatriarchEntity _datEntIxxxxx
                           ? (Integer)_datEntIxxxxx.getEntityData().get(SpiderMatriarchEntity.DATA_time_since_landing_attack)
                           : 0
                     )
                     + 1
               );
         }

         if ((entity instanceof SpiderMatriarchEntity _datEntIxxxx ? (Integer)_datEntIxxxx.getEntityData().get(SpiderMatriarchEntity.DATA_eggs_grow) : 0)
               < 1000
            && entity instanceof SpiderMatriarchEntity _datEntSetI) {
            _datEntSetI.getEntityData()
               .set(
                  SpiderMatriarchEntity.DATA_eggs_grow,
                  (entity instanceof SpiderMatriarchEntity _datEntIxxxxx ? (Integer)_datEntIxxxxx.getEntityData().get(SpiderMatriarchEntity.DATA_eggs_grow) : 0)
                     + 1
               );
         }

         label451: {
            if (entity instanceof SpiderMatriarchEntity _datEntL225 && (Boolean)_datEntL225.getEntityData().get(SpiderMatriarchEntity.DATA_done_rot_clay)) {
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
                        "data merge entity @s {NoAI:0}"
                     );
               }
               break label451;
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
                     "data merge entity @s {NoAI:1}"
                  );
            }

            if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == ArphexModBlocks.CRAWLING_CLAY.get()) {
               if (entity instanceof SpiderMatriarchEntity _datEntSetI) {
                  _datEntSetI.getEntityData().set(SpiderMatriarchEntity.DATA_lunge_time, 200);
               }

               if (entity instanceof Mob) {
                  try {
                     ((Mob)entity).setTarget(null);
                  } catch (Exception var28) {
                     var28.printStackTrace();
                  }
               }

               if (!world.isClientSide()) {
                  entity.setYRot(-17.56F);
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

               entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true).isEmpty()
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
                           .checkGamemode(
                              world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
                                 .stream()
                                 .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                       return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                 }).compareDistOf(x, y, z))
                                 .findFirst()
                                 .orElse(null)
                           )
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
                           .checkGamemode(
                              world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
                                 .stream()
                                 .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                       return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                 }).compareDistOf(x, y, z))
                                 .findFirst()
                                 .orElse(null)
                           )
                  )
                  && entity instanceof SpiderMatriarchEntity _datEntSetL) {
                  _datEntSetL.getEntityData().set(SpiderMatriarchEntity.DATA_done_rot_clay, true);
               }
            } else if (entity instanceof SpiderMatriarchEntity _datEntSetL) {
               _datEntSetL.getEntityData().set(SpiderMatriarchEntity.DATA_done_rot_clay, true);
            }
         }

         if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getHealth() : -1.0F)
               < (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMaxHealth() : -1.0F) / 2.0F
            && (entity instanceof SpiderMatriarchEntity _datEntIxxxxx ? (Integer)_datEntIxxxxx.getEntityData().get(SpiderMatriarchEntity.DATA_lunge_time) : 0)
               < 300
            && (entity instanceof SpiderMatriarchEntity _datEntIxxxx ? (Integer)_datEntIxxxx.getEntityData().get(SpiderMatriarchEntity.DATA_lunge_time) : 0)
               > 3
            && entity instanceof SpiderMatriarchEntity _datEntSetI) {
            _datEntSetI.getEntityData().set(SpiderMatriarchEntity.DATA_lunge_time, 1);
         }
      }
   }
}
