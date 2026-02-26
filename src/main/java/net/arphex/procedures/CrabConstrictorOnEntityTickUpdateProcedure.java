package net.arphex.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.CrabConstrictorEntity;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class CrabConstrictorOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double homing = 0.0;
         if (!entity.getPersistentData().getBoolean("proximitydone")) {
            entity.getPersistentData().putBoolean("proximitydone", true);
            if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 24.0, 24.0, 24.0), e -> true).isEmpty()) {
               Vec3 _center = new Vec3(x, y, z);

               for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(75.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiterator != entity && entityiterator instanceof CrabConstrictorEntity && !entity.level().isClientSide()) {
                     entity.discard();
                  }
               }
            }
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect((MobEffect)ArphexModMobEffects.CONSTRICTED.get());
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect(MobEffects.LEVITATION);
         }

         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 10, 10, false, false));
         }

         if (entity.isUnderWater()) {
            if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).isEmpty()
               && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).stream().sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z)).findFirst().orElse(null).getPersistentData().getBoolean("creativespectator")) {
               if (entity.getY()
                  < world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getY() - 7.0) {
                  if (entity.getPersistentData().getDouble("looktime") == 5.0) {
                     entity.setYRot(
                        (float)(
                           Math.atan2(
                                    entity.getZ()
                                       - world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
                                          .stream()
                                          .sorted((new Object() {
                                             Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                             }
                                          }).compareDistOf(x, y, z))
                                          .findFirst()
                                          .orElse(null)
                                          .getZ(),
                                    entity.getX()
                                       - world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
                                          .stream()
                                          .sorted((new Object() {
                                             Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                             }
                                          }).compareDistOf(x, y, z))
                                          .findFirst()
                                          .orElse(null)
                                          .getX()
                                 )
                                 * 57.5
                              + 90.0
                        )
                     );
                     entity.setXRot(
                        (float)(
                           Math.atan2(
                                 entity.getY()
                                    - world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
                                       .stream()
                                       .sorted((new Object() {
                                          Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                             return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                          }
                                       }).compareDistOf(x, y, z))
                                       .findFirst()
                                       .orElse(null)
                                       .getY(),
                                 Math.sqrt(
                                    (
                                             entity.getX()
                                                - world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
                                                   .stream()
                                                   .sorted((new Object() {
                                                      Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                         return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                                      }
                                                   }).compareDistOf(x, y, z))
                                                   .findFirst()
                                                   .orElse(null)
                                                   .getX()
                                          )
                                          * (
                                             entity.getX()
                                                - world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
                                                   .stream()
                                                   .sorted((new Object() {
                                                      Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                         return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                                      }
                                                   }).compareDistOf(x, y, z))
                                                   .findFirst()
                                                   .orElse(null)
                                                   .getX()
                                          )
                                       + (
                                             entity.getZ()
                                                - world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
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
                                          * (
                                             entity.getZ()
                                                - world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
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
                                 )
                              )
                              * 57.5
                        )
                     );
                     entity.setYBodyRot(entity.getYRot());
                     entity.setYHeadRot(entity.getYRot());
                     entity.yRotO = entity.getYRot();
                     entity.xRotO = entity.getXRot();
                     if (entity instanceof LivingEntity _entity) {
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }

                     entity.setDeltaMovement(
                        new Vec3(
                           Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                           0.2,
                           Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                        )
                     );
                  }

                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10, 10, false, false));
                  }
               } else if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10, 5, false, false));
               }
            } else if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10, 5, false, false));
            }
         } else if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10, 1, false, false));
         }

         if ((entity instanceof CrabConstrictorEntity _datEntI ? (Integer)_datEntI.getEntityData().get(CrabConstrictorEntity.DATA_grabwait) : 0) > 0
            && entity instanceof CrabConstrictorEntity _datEntSetI) {
            _datEntSetI.getEntityData()
               .set(
                  CrabConstrictorEntity.DATA_grabwait,
                  (entity instanceof CrabConstrictorEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(CrabConstrictorEntity.DATA_grabwait) : 0) - 1
               );
         }

         entity.getPersistentData()
            .putDouble(
               "mirror",
               entity instanceof CrabConstrictorEntity _datEntI
                  ? (double)((Integer)_datEntI.getEntityData().get(CrabConstrictorEntity.DATA_grabbingtime)).intValue()
                  : 0.0
            );
         if (entity.getDisplayName().getString().equals("Crab Constrictor")
            && Mth.nextInt(RandomSource.create(), 1, 400) == 1
            && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 250.0, 250.0, 250.0), e -> true).isEmpty()
            && !entity.level().isClientSide()) {
            entity.discard();
         }

         if (!(entity.getPersistentData().getDouble("looktime") > 0.0)) {
            entity.getPersistentData().putDouble("looktime", 45.0);
         } else {
            entity.getPersistentData().putDouble("looktime", entity.getPersistentData().getDouble("looktime") - 1.0);
         }

         if ((entity instanceof CrabConstrictorEntity _datEntIxx ? (Integer)_datEntIxx.getEntityData().get(CrabConstrictorEntity.DATA_grabbingtime) : 0) <= 400
            && (entity instanceof CrabConstrictorEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(CrabConstrictorEntity.DATA_grabwait) : 0) <= 0
            && (
               world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y + 2.0, z), 15.0, 15.0, 15.0), e -> true).isEmpty()
                  || !(new Object() {
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
                           world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y + 2.0, z), 15.0, 15.0, 15.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y + 2.0, z))
                              .findFirst()
                              .orElse(null)
                        )
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
                        .checkGamemode(
                           world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y + 2.0, z), 15.0, 15.0, 15.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y + 2.0, z))
                              .findFirst()
                              .orElse(null)
                        )
            )
            && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y + 2.0, z), 50.0, 50.0, 50.0), e -> true).isEmpty()
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
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y + 2.0, z), 50.0, 50.0, 50.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y + 2.0, z))
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
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y + 2.0, z), 50.0, 50.0, 50.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y + 2.0, z))
                           .findFirst()
                           .orElse(null)
                     )
            )) {
            if (!world.isClientSide()) {
               if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y + 2.0, z), 50.0, 50.0, 50.0), e -> true).stream().sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y + 2.0, z)).findFirst().orElse(null).getY() > entity.getY() + 12.0) {
                  if (!entity.isShiftKeyDown() && !entity.isSprinting()) {
                     entity.setSprinting(true);
                  } else {
                     entity.setShiftKeyDown(false);
                  }
               } else if (!entity.isShiftKeyDown() && !entity.isSprinting()) {
                  entity.setShiftKeyDown(true);
               } else {
                  entity.setSprinting(false);
               }
            }
         } else {
            if ((entity instanceof CrabConstrictorEntity _datEntIxxxx ? (Integer)_datEntIxxxx.getEntityData().get(CrabConstrictorEntity.DATA_grabbingtime) : 0)
                  > 20
               && (entity instanceof CrabConstrictorEntity _datEntIxxx ? (Integer)_datEntIxxx.getEntityData().get(CrabConstrictorEntity.DATA_grabwait) : 0)
                  <= 0
               && entity instanceof CrabConstrictorEntity _datEntSetI) {
               _datEntSetI.getEntityData().set(CrabConstrictorEntity.DATA_grabwait, 400);
            }

            if (!world.isClientSide()) {
               entity.setSprinting(false);
               entity.setShiftKeyDown(false);
            }
         }

         if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) && (Boolean)ConfigurationSettingsConfiguration.ARPHEX_GRIEFING.get()) {
            if (!(entity.getPersistentData().getDouble("crabbreaktime") < 0.0)) {
               entity.getPersistentData().putDouble("crabbreaktime", 15.0);
               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true).isEmpty()
                  && world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                           .withSuppressedOutput(),
                        "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace glass_pane"
                     );
               }

               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).isEmpty()) {
                  if (world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace #minecraft:leaves"
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
                           "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace cobweb"
                        );
                  }
               }
            } else {
               entity.getPersistentData().putDouble("crabbreaktime", entity.getPersistentData().getDouble("crabbreaktime") - 1.0);
            }
         }

         if (entity.isSprinting()
            && (entity instanceof CrabConstrictorEntity _datEntIxxxx ? (Integer)_datEntIxxxx.getEntityData().get(CrabConstrictorEntity.DATA_grabbingtime) : 0)
               > 50
            && (entity instanceof CrabConstrictorEntity _datEntIxxx ? (Integer)_datEntIxxx.getEntityData().get(CrabConstrictorEntity.DATA_grabbingtime) : 0)
               < 350) {
            if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)
               && (Boolean)ConfigurationSettingsConfiguration.ARPHEX_GRIEFING.get()
               && !(entity.getPersistentData().getDouble("crabbreaktime") < 0.0)
               && world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                           CommandSource.NULL,
                           new Vec3(
                              (double)entity.level()
                                 .clip(
                                    new ClipContext(
                                       entity.getEyePosition(1.0F),
                                       entity.getEyePosition(1.0F)
                                          .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("downgrabdist") * 0.6)),
                                       Block.OUTLINE,
                                       Fluid.NONE,
                                       entity
                                    )
                                 )
                                 .getBlockPos()
                                 .getX(),
                              (double)entity.level()
                                    .clip(
                                       new ClipContext(
                                          entity.getEyePosition(1.0F),
                                          entity.getEyePosition(1.0F)
                                             .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("downgrabdist") * 0.7)),
                                          Block.OUTLINE,
                                          Fluid.NONE,
                                          entity
                                       )
                                    )
                                    .getBlockPos()
                                    .getY()
                                 + entity.getPersistentData().getDouble("downgrabdist") * 0.8,
                              (double)entity.level()
                                 .clip(
                                    new ClipContext(
                                       entity.getEyePosition(1.0F),
                                       entity.getEyePosition(1.0F)
                                          .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("downgrabdist") * 0.6)),
                                       Block.OUTLINE,
                                       Fluid.NONE,
                                       entity
                                    )
                                 )
                                 .getBlockPos()
                                 .getZ()
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
                     "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace kelp_plant"
                  );
            }

            if (!world.getBlockState(
                  BlockPos.containing(
                     (double)entity.level()
                        .clip(
                           new ClipContext(
                              entity.getEyePosition(1.0F),
                              entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("downgrabdist") * 0.6)),
                              Block.OUTLINE,
                              Fluid.NONE,
                              entity
                           )
                        )
                        .getBlockPos()
                        .getX(),
                     (double)entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("downgrabdist") * 0.7)),
                                 Block.OUTLINE,
                                 Fluid.NONE,
                                 entity
                              )
                           )
                           .getBlockPos()
                           .getY()
                        + entity.getPersistentData().getDouble("downgrabdist") * 0.8,
                     (double)entity.level()
                        .clip(
                           new ClipContext(
                              entity.getEyePosition(1.0F),
                              entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("downgrabdist") * 0.6)),
                              Block.OUTLINE,
                              Fluid.NONE,
                              entity
                           )
                        )
                        .getBlockPos()
                        .getZ()
                  )
               )
               .canOcclude()) {
               Vec3 _center = new Vec3(
                  (double)entity.level()
                     .clip(
                        new ClipContext(
                           entity.getEyePosition(1.0F),
                           entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("downgrabdist") * 0.6)),
                           Block.OUTLINE,
                           Fluid.NONE,
                           entity
                        )
                     )
                     .getBlockPos()
                     .getX(),
                  (double)entity.level()
                        .clip(
                           new ClipContext(
                              entity.getEyePosition(1.0F),
                              entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("downgrabdist") * 0.7)),
                              Block.OUTLINE,
                              Fluid.NONE,
                              entity
                           )
                        )
                        .getBlockPos()
                        .getY()
                     + entity.getPersistentData().getDouble("downgrabdist") * 0.8,
                  (double)entity.level()
                     .clip(
                        new ClipContext(
                           entity.getEyePosition(1.0F),
                           entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("downgrabdist") * 0.6)),
                           Block.OUTLINE,
                           Fluid.NONE,
                           entity
                        )
                     )
                     .getBlockPos()
                     .getZ()
               );

               for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3.5), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiteratorx instanceof Boat && !entityiteratorx.level().isClientSide()) {
                     entityiteratorx.discard();
                  }

                  if (entityiteratorx instanceof Player
                     && !entityiteratorx.getPersistentData().getBoolean("creativespectator")
                     && entityiteratorx.isPassenger()) {
                     entityiteratorx.stopRiding();
                  }

                  if (!(entityiteratorx instanceof CrabConstrictorEntity)
                     && entityiteratorx instanceof LivingEntity
                     && !entityiteratorx.getPersistentData().getBoolean("creativespectator")) {
                     if (entityiteratorx instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.CONSTRICTED.get(), 10, 0, false, false));
                     }

                     entityiteratorx.setDeltaMovement(
                        new Vec3(
                           (double)entity.level()
                                 .clip(
                                    new ClipContext(
                                       entity.getEyePosition(1.0F),
                                       entity.getEyePosition(1.0F)
                                          .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("downgrabdist") * 0.6)),
                                       Block.OUTLINE,
                                       Fluid.NONE,
                                       entity
                                    )
                                 )
                                 .getBlockPos()
                                 .getX()
                              - entityiteratorx.getX(),
                           (double)entity.level()
                                 .clip(
                                    new ClipContext(
                                       entity.getEyePosition(1.0F),
                                       entity.getEyePosition(1.0F)
                                          .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("downgrabdist") * 0.7)),
                                       Block.OUTLINE,
                                       Fluid.NONE,
                                       entity
                                    )
                                 )
                                 .getBlockPos()
                                 .getY()
                              + entity.getPersistentData().getDouble("downgrabdist") * 0.8
                              - entityiteratorx.getY(),
                           (double)entity.level()
                                 .clip(
                                    new ClipContext(
                                       entity.getEyePosition(1.0F),
                                       entity.getEyePosition(1.0F)
                                          .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("downgrabdist") * 0.6)),
                                       Block.OUTLINE,
                                       Fluid.NONE,
                                       entity
                                    )
                                 )
                                 .getBlockPos()
                                 .getZ()
                              - entityiteratorx.getZ()
                        )
                     );
                  }
               }
            } else {
               entity.getPersistentData().putDouble("grabwait", 150.0);
            }
         }

         if ((entity instanceof CrabConstrictorEntity _datEntIxxx ? (Integer)_datEntIxxx.getEntityData().get(CrabConstrictorEntity.DATA_grabbingtime) : 0)
            < 150) {
            entity.getPersistentData()
               .putDouble(
                  "downgrabdist",
                  3.3
                     + 0.165
                        * (double)(
                           entity instanceof CrabConstrictorEntity _datEntIxxxx
                              ? (Integer)_datEntIxxxx.getEntityData().get(CrabConstrictorEntity.DATA_grabbingtime)
                              : 0
                        )
                        * 0.66
                        * 0.8
               );
         } else if ((
               entity instanceof CrabConstrictorEntity _datEntIxxx ? (Integer)_datEntIxxx.getEntityData().get(CrabConstrictorEntity.DATA_grabbingtime) : 0
            )
            < 280) {
            entity.getPersistentData().putDouble("downgrabdist", 16.5);
         } else {
            entity.getPersistentData()
               .putDouble(
                  "downgrabdist",
                  3.3
                     + 0.165
                        * (double)(
                           0
                              - (
                                    (
                                          entity instanceof CrabConstrictorEntity _datEntIxxx
                                             ? (Integer)_datEntIxxx.getEntityData().get(CrabConstrictorEntity.DATA_grabbingtime)
                                             : 0
                                       )
                                       - 280
                                 )
                                 * 1
                              + 100
                        )
                        * 0.8
               );
         }

         if (entity.isShiftKeyDown()
            && (entity instanceof CrabConstrictorEntity _datEntIxxxx ? (Integer)_datEntIxxxx.getEntityData().get(CrabConstrictorEntity.DATA_grabbingtime) : 0)
               > 50
            && (entity instanceof CrabConstrictorEntity _datEntIxxx ? (Integer)_datEntIxxx.getEntityData().get(CrabConstrictorEntity.DATA_grabbingtime) : 0)
               < 360) {
            label442:
            if ((
                     entity instanceof CrabConstrictorEntity _datEntIxxxxxx
                        ? (Integer)_datEntIxxxxxx.getEntityData().get(CrabConstrictorEntity.DATA_grabbingtime)
                        : 0
                  )
                  >= 100
               && (
                     entity instanceof CrabConstrictorEntity _datEntIxxxxx
                        ? (Integer)_datEntIxxxxx.getEntityData().get(CrabConstrictorEntity.DATA_grabbingtime)
                        : 0
                  )
                  <= 320) {
               if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)
                  && (Boolean)ConfigurationSettingsConfiguration.ARPHEX_GRIEFING.get()
                  && !(entity.getPersistentData().getDouble("crabbreaktime") < 0.0)
                  && world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL,
                              new Vec3(
                                 (double)entity.level()
                                    .clip(
                                       new ClipContext(
                                          entity.getEyePosition(1.0F),
                                          entity.getEyePosition(1.0F)
                                             .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("downgrabdist"))),
                                          Block.OUTLINE,
                                          Fluid.NONE,
                                          entity
                                       )
                                    )
                                    .getBlockPos()
                                    .getX(),
                                 (double)entity.level()
                                       .clip(
                                          new ClipContext(
                                             entity.getEyePosition(1.0F),
                                             entity.getEyePosition(1.0F)
                                                .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("downgrabdist"))),
                                             Block.OUTLINE,
                                             Fluid.NONE,
                                             entity
                                          )
                                       )
                                       .getBlockPos()
                                       .getY()
                                    - 0.5,
                                 (double)entity.level()
                                    .clip(
                                       new ClipContext(
                                          entity.getEyePosition(1.0F),
                                          entity.getEyePosition(1.0F)
                                             .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("downgrabdist"))),
                                          Block.OUTLINE,
                                          Fluid.NONE,
                                          entity
                                       )
                                    )
                                    .getBlockPos()
                                    .getZ()
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
                        "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace kelp_plant"
                     );
               }

               Vec3 _center = new Vec3(
                  (double)entity.level()
                     .clip(
                        new ClipContext(
                           entity.getEyePosition(1.0F),
                           entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("downgrabdist"))),
                           Block.OUTLINE,
                           Fluid.NONE,
                           entity
                        )
                     )
                     .getBlockPos()
                     .getX(),
                  (double)entity.level()
                        .clip(
                           new ClipContext(
                              entity.getEyePosition(1.0F),
                              entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("downgrabdist"))),
                              Block.OUTLINE,
                              Fluid.NONE,
                              entity
                           )
                        )
                        .getBlockPos()
                        .getY()
                     - 0.5,
                  (double)entity.level()
                     .clip(
                        new ClipContext(
                           entity.getEyePosition(1.0F),
                           entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("downgrabdist"))),
                           Block.OUTLINE,
                           Fluid.NONE,
                           entity
                        )
                     )
                     .getBlockPos()
                     .getZ()
               );
               List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2.5), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList();
               Iterator var72 = _entfound.iterator();

               while (true) {
                  if (!var72.hasNext()) {
                     break label442;
                  }

                  Entity entityiteratorx = (Entity)var72.next();
                  if (entityiteratorx instanceof Player
                     && !entityiteratorx.getPersistentData().getBoolean("creativespectator")
                     && entityiteratorx.isPassenger()) {
                     entityiteratorx.stopRiding();
                  }

                  if (entityiteratorx instanceof Boat && !entityiteratorx.level().isClientSide()) {
                     entityiteratorx.discard();
                  }

                  if (!(entityiteratorx instanceof CrabConstrictorEntity)
                     && entityiteratorx instanceof LivingEntity
                     && !entityiteratorx.getPersistentData().getBoolean("creativespectator")) {
                     if (entityiteratorx instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.CONSTRICTED.get(), 10, 0, false, false));
                     }

                     entityiteratorx.setDeltaMovement(
                        new Vec3(
                           (double)entity.level()
                                 .clip(
                                    new ClipContext(
                                       entity.getEyePosition(1.0F),
                                       entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("downgrabdist"))),
                                       Block.OUTLINE,
                                       Fluid.NONE,
                                       entity
                                    )
                                 )
                                 .getBlockPos()
                                 .getX()
                              - entityiteratorx.getX(),
                           (double)entity.level()
                                 .clip(
                                    new ClipContext(
                                       entity.getEyePosition(1.0F),
                                       entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("downgrabdist"))),
                                       Block.OUTLINE,
                                       Fluid.NONE,
                                       entity
                                    )
                                 )
                                 .getBlockPos()
                                 .getY()
                              - 0.5
                              - entityiteratorx.getY(),
                           (double)entity.level()
                                 .clip(
                                    new ClipContext(
                                       entity.getEyePosition(1.0F),
                                       entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("downgrabdist"))),
                                       Block.OUTLINE,
                                       Fluid.NONE,
                                       entity
                                    )
                                 )
                                 .getBlockPos()
                                 .getZ()
                              - entityiteratorx.getZ()
                        )
                     );
                  }
               }
            } else {
               if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)
                  && (Boolean)ConfigurationSettingsConfiguration.ARPHEX_GRIEFING.get()
                  && !(entity.getPersistentData().getDouble("crabbreaktime") < 0.0)
                  && world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL,
                              new Vec3(
                                 (double)entity.level()
                                    .clip(
                                       new ClipContext(
                                          entity.getEyePosition(1.0F),
                                          entity.getEyePosition(1.0F)
                                             .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("downgrabdist"))),
                                          Block.OUTLINE,
                                          Fluid.NONE,
                                          entity
                                       )
                                    )
                                    .getBlockPos()
                                    .getX(),
                                 (double)entity.level()
                                       .clip(
                                          new ClipContext(
                                             entity.getEyePosition(1.0F),
                                             entity.getEyePosition(1.0F)
                                                .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("downgrabdist"))),
                                             Block.OUTLINE,
                                             Fluid.NONE,
                                             entity
                                          )
                                       )
                                       .getBlockPos()
                                       .getY()
                                    - 0.5,
                                 (double)entity.level()
                                    .clip(
                                       new ClipContext(
                                          entity.getEyePosition(1.0F),
                                          entity.getEyePosition(1.0F)
                                             .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("downgrabdist"))),
                                          Block.OUTLINE,
                                          Fluid.NONE,
                                          entity
                                       )
                                    )
                                    .getBlockPos()
                                    .getZ()
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
                        "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace kelp_plant"
                     );
               }

               if (!world.getBlockState(
                     BlockPos.containing(
                        (double)entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("downgrabdist"))),
                                 Block.OUTLINE,
                                 Fluid.NONE,
                                 entity
                              )
                           )
                           .getBlockPos()
                           .getX(),
                        (double)entity.level()
                              .clip(
                                 new ClipContext(
                                    entity.getEyePosition(1.0F),
                                    entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("downgrabdist"))),
                                    Block.OUTLINE,
                                    Fluid.NONE,
                                    entity
                                 )
                              )
                              .getBlockPos()
                              .getY()
                           - 0.5,
                        (double)entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("downgrabdist"))),
                                 Block.OUTLINE,
                                 Fluid.NONE,
                                 entity
                              )
                           )
                           .getBlockPos()
                           .getZ()
                     )
                  )
                  .canOcclude()) {
                  Vec3 _center = new Vec3(
                     (double)entity.level()
                        .clip(
                           new ClipContext(
                              entity.getEyePosition(1.0F),
                              entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("downgrabdist"))),
                              Block.OUTLINE,
                              Fluid.NONE,
                              entity
                           )
                        )
                        .getBlockPos()
                        .getX(),
                     (double)entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("downgrabdist"))),
                                 Block.OUTLINE,
                                 Fluid.NONE,
                                 entity
                              )
                           )
                           .getBlockPos()
                           .getY()
                        - 0.5,
                     (double)entity.level()
                        .clip(
                           new ClipContext(
                              entity.getEyePosition(1.0F),
                              entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("downgrabdist"))),
                              Block.OUTLINE,
                              Fluid.NONE,
                              entity
                           )
                        )
                        .getBlockPos()
                        .getZ()
                  );

                  for (Entity entityiteratorxx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2.5), e -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                     .toList()) {
                     if (entityiteratorxx instanceof Player
                        && !entityiteratorxx.getPersistentData().getBoolean("creativespectator")
                        && entityiteratorxx.isPassenger()) {
                        entityiteratorxx.stopRiding();
                     }

                     if (entityiteratorxx instanceof Boat && !entityiteratorxx.level().isClientSide()) {
                        entityiteratorxx.discard();
                     }

                     if (!(entityiteratorxx instanceof CrabConstrictorEntity)
                        && entityiteratorxx instanceof LivingEntity
                        && !entityiteratorxx.getPersistentData().getBoolean("creativespectator")) {
                        if (entityiteratorxx instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.CONSTRICTED.get(), 10, 0, false, false));
                        }

                        entityiteratorxx.setDeltaMovement(
                           new Vec3(
                              (double)entity.level()
                                    .clip(
                                       new ClipContext(
                                          entity.getEyePosition(1.0F),
                                          entity.getEyePosition(1.0F)
                                             .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("downgrabdist"))),
                                          Block.OUTLINE,
                                          Fluid.NONE,
                                          entity
                                       )
                                    )
                                    .getBlockPos()
                                    .getX()
                                 - entityiteratorxx.getX(),
                              (double)entity.level()
                                    .clip(
                                       new ClipContext(
                                          entity.getEyePosition(1.0F),
                                          entity.getEyePosition(1.0F)
                                             .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("downgrabdist"))),
                                          Block.OUTLINE,
                                          Fluid.NONE,
                                          entity
                                       )
                                    )
                                    .getBlockPos()
                                    .getY()
                                 + 0.6
                                 - entityiteratorxx.getY(),
                              (double)entity.level()
                                    .clip(
                                       new ClipContext(
                                          entity.getEyePosition(1.0F),
                                          entity.getEyePosition(1.0F)
                                             .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("downgrabdist"))),
                                          Block.OUTLINE,
                                          Fluid.NONE,
                                          entity
                                       )
                                    )
                                    .getBlockPos()
                                    .getZ()
                                 - entityiteratorxx.getZ()
                           )
                        );
                     }
                  }
               } else {
                  entity.getPersistentData().putDouble("grabwait", 150.0);
               }
            }
         }

         if ((entity instanceof CrabConstrictorEntity _datEntIxxxxx ? (Integer)_datEntIxxxxx.getEntityData().get(CrabConstrictorEntity.DATA_grabbingtime) : 0)
               > 400
            && entity instanceof CrabConstrictorEntity _datEntSetI) {
            _datEntSetI.getEntityData().set(CrabConstrictorEntity.DATA_grabwait, 200);
         }

         if (!entity.isShiftKeyDown() && !entity.isSprinting()) {
            if (entity instanceof CrabConstrictorEntity _datEntSetI) {
               _datEntSetI.getEntityData().set(CrabConstrictorEntity.DATA_grabbingtime, 0);
            }
         } else {
            if (entity instanceof CrabConstrictorEntity _datEntSetI) {
               _datEntSetI.getEntityData()
                  .set(
                     CrabConstrictorEntity.DATA_grabbingtime,
                     (
                           entity instanceof CrabConstrictorEntity _datEntIxxxxx
                              ? (Integer)_datEntIxxxxx.getEntityData().get(CrabConstrictorEntity.DATA_grabbingtime)
                              : 0
                        )
                        + 1
                  );
            }

            entity.setDeltaMovement(new Vec3(0.0, entity.getDeltaMovement().y(), 0.0));
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 99, false, false));
            }
         }

         entity.setMaxUpStep(4.0F);
         if (!entity.isShiftKeyDown() && !entity.isSprinting()) {
            entity.getPersistentData().putDouble("timegrabbing", 0.0);
         } else {
            entity.getPersistentData().putDouble("timegrabbing", entity.getPersistentData().getDouble("timegrabbing") + 1.0);
         }

         if (world instanceof ServerLevel _level) {
            _level.sendParticles(
               (SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(),
               x,
               y,
               z,
               (int)((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) / 2.0F),
               2.5,
               4.0,
               2.5,
               0.2
            );
         }

         if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F) / 2.0F
            < (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F)) {
            if (entity instanceof CrabConstrictorEntity animatable) {
               animatable.setTexture("crabconstrictor");
            }
         } else if (entity instanceof CrabConstrictorEntity animatable) {
            animatable.setTexture("crabconstrictor2");
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect((MobEffect)ArphexModMobEffects.NECROSIS.get());
         }
      }
   }
}
