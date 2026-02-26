package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.SpiderGoliathEntity;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SpiderGoliathOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putBoolean("arphexclimber", true);
         if ((entity instanceof SpiderGoliathEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderGoliathEntity.DATA_attackingtime) : 0) <= 0
            && entity instanceof SpiderGoliathEntity _datEntSetI) {
            _datEntSetI.getEntityData()
               .set(
                  SpiderGoliathEntity.DATA_attackingtime,
                  (entity instanceof SpiderGoliathEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SpiderGoliathEntity.DATA_attackingtime) : 0) - 1
               );
         }

         if (world.isEmptyBlock(BlockPos.containing(x, y - 0.9, z)) && world.isEmptyBlock(BlockPos.containing(x, y - 1.9, z)) && !entity.onGround()) {
            if (world.isClientSide()) {
               if (world.isEmptyBlock(BlockPos.containing(x, y + 2.0, z))) {
                  if (entity instanceof SpiderGoliathEntity) {
                     ((SpiderGoliathEntity)entity).setAnimation("animation.spidertarantula.grabwalk");
                  }
               } else if (entity instanceof SpiderGoliathEntity) {
                  ((SpiderGoliathEntity)entity).setAnimation("empty");
               }
            }

            entity.setShiftKeyDown(true);
            entity.setSprinting(false);
         } else {
            if (world.isClientSide() && entity instanceof SpiderGoliathEntity) {
               ((SpiderGoliathEntity)entity).setAnimation("empty");
            }

            entity.setShiftKeyDown(false);
            if ((entity instanceof SpiderGoliathEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderGoliathEntity.DATA_attackingtime) : 0) <= 0
               && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40.0, 40.0, 40.0), e -> true).isEmpty()
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
                           world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40.0, 40.0, 40.0), e -> true).stream().sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z)).findFirst().orElse(null)
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
                           world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40.0, 40.0, 40.0), e -> true).stream().sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z)).findFirst().orElse(null)
                        )
               )) {
               if (Mth.nextInt(RandomSource.create(), 1, 400) == 5 && entity instanceof SpiderGoliathEntity _datEntSetI) {
                  _datEntSetI.getEntityData().set(SpiderGoliathEntity.DATA_attackingtime, 5000);
               }

               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 20, false, false));
               }
            }

            if ((entity instanceof SpiderGoliathEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderGoliathEntity.DATA_attackingtime) : 0) <= 0
               && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40.0, 40.0, 40.0), e -> true).isEmpty()
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
                           world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40.0, 40.0, 40.0), e -> true).stream().sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z)).findFirst().orElse(null)
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
                           world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40.0, 40.0, 40.0), e -> true).stream().sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z)).findFirst().orElse(null)
                        )
               )
               && entity.getDeltaMovement().x() == 0.0
               && entity.getDeltaMovement().z() == 0.0) {
               entity.setSprinting(true);
            } else {
               entity.setSprinting(false);
            }
         }

         if ((entity instanceof SpiderGoliathEntity animatable ? animatable.getTexture() : "null").equals("tarantula1")) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 0, false, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 0, false, false));
            }

            if (entity.getPersistentData().getDouble("urticate") > 0.0) {
               entity.getPersistentData().putDouble("urticate", entity.getPersistentData().getDouble("urticate") - 1.0);
            } else {
               entity.getPersistentData().putDouble("urticate", 200.0);
            }

            if ((
                  entity.getPersistentData().getDouble("urticate") > 195.0
                     || entity.getPersistentData().getDouble("urticate") > 180.0 && entity.getPersistentData().getDouble("urticate") < 186.0
               )
               && (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
               if (world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 160, 1.5, 1.5, 1.5, 0.8);
               }

               Vec3 _center = new Vec3(x, y, z);

               for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.5), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (!(entityiterator instanceof SpiderGoliathEntity) && !entityiterator.getPersistentData().getBoolean("creativespectator")) {
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 5));
                        }
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 50, 5));
                        }
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50, 1));
                        }
                     }
                  }
               }
            }
         }

         if ((!(entity instanceof LivingEntity _livEnt54) || !_livEnt54.hasEffect(MobEffects.REGENERATION))
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 0, false, false));
         }

         if ((entity instanceof SpiderGoliathEntity animatable ? animatable.getTexture() : "null").equals("tarantula4")
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 60, 1, false, false));
         }

         if ((entity instanceof SpiderGoliathEntity animatable ? animatable.getTexture() : "null").equals("tarantula3")
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 0, false, false));
         }

         if ((entity instanceof SpiderGoliathEntity animatable ? animatable.getTexture() : "null").equals("tarantula2")
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 60, 0, false, false));
         }

         if ((entity instanceof SpiderGoliathEntity animatable ? animatable.getTexture() : "null").equals("tarantula5")
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 0, false, false));
         }

         if (!entity.getPersistentData().getBoolean("despawned_rider")) {
            entity.getPersistentData().putBoolean("despawned_rider", true);
            if (entity.isVehicle()
               && entity.getFirstPassenger() != null
               && entity.getFirstPassenger() instanceof Skeleton
               && !entity.getFirstPassenger().level().isClientSide()) {
               entity.getFirstPassenger().discard();
            }
         }
      }
   }
}
