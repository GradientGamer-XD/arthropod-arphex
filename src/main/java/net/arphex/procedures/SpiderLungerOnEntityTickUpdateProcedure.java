package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.SpiderLungerEntity;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SpiderLungerOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity target = null;
         double yaw_compare = 0.0;
         if (entity.isVehicle()) {
            if ((entity instanceof SpiderLungerEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SpiderLungerEntity.DATA_attack_trigger_time) : 0) > 75
               && (entity instanceof SpiderLungerEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderLungerEntity.DATA_attack_trigger_time) : 0) < 90
               )
             {
               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3, 3, false, false));
               }
            } else if ((
                  entity instanceof SpiderLungerEntity _datEntIxx ? (Integer)_datEntIxx.getEntityData().get(SpiderLungerEntity.DATA_attack_trigger_time) : 0
               )
               > 90) {
               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 4, false, false));
               }
            } else if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 0, false, false));
            }

            label280:
            if (entity.getFirstPassenger() != null) {
               if (!(entity instanceof TamableAnimal _tamIsTamedBy)
                  || !(entity.getFirstPassenger() instanceof LivingEntity _livEnt)
                  || !_tamIsTamedBy.isOwnedBy(_livEnt)) {
                  entity.getFirstPassenger().stopRiding();
                  break label280;
               }

               if (entity.getFirstPassenger() instanceof Player
                  && (
                        entity instanceof SpiderLungerEntity _datEntIxxx
                           ? (Integer)_datEntIxxx.getEntityData().get(SpiderLungerEntity.DATA_attack_trigger_time)
                           : 0
                     )
                     <= 0
                  && ((ArphexModVariables.PlayerVariables)entity.getFirstPassenger()
                        .getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                     .holdingspace) {
                  if (entity instanceof SpiderLungerEntity) {
                     ((SpiderLungerEntity)entity).setAnimation("animation.spider_lunger.fast");
                  }

                  if (entity instanceof SpiderLungerEntity _datEntSetI) {
                     _datEntSetI.getEntityData().set(SpiderLungerEntity.DATA_attack_trigger_time, 100);
                  }

                  if (entity instanceof LivingEntity _entity) {
                     _entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
                  }

                  entity.setDeltaMovement(new Vec3(entity.getLookAngle().x / 2.0, entity.getDeltaMovement().y(), entity.getLookAngle().z / 2.0));
               }
            }
         }

         label302: {
            if (entity instanceof TamableAnimal _tamEnt && _tamEnt.isTame()) {
               if ((!(entity instanceof SpiderLungerEntity _datEntL25) || !(Boolean)_datEntL25.getEntityData().get(SpiderLungerEntity.DATA_follow))
                  && world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 10, 0.4, 0.4, 0.4, 0.2);
               }

               if ((!(entity instanceof LivingEntity _livEnt27) || !_livEnt27.hasEffect(MobEffects.REGENERATION))
                  && entity instanceof LivingEntity _entity
                  && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 80, 0, false, false));
               }

               if ((
                        entity instanceof SpiderLungerEntity _datEntIxxx
                           ? (Integer)_datEntIxxx.getEntityData().get(SpiderLungerEntity.DATA_attack_trigger_time)
                           : 0
                     )
                     > 0
                  && entity instanceof SpiderLungerEntity _datEntSetI) {
                  _datEntSetI.getEntityData()
                     .set(
                        SpiderLungerEntity.DATA_attack_trigger_time,
                        (
                              entity instanceof SpiderLungerEntity _datEntIxxxx
                                 ? (Integer)_datEntIxxxx.getEntityData().get(SpiderLungerEntity.DATA_attack_trigger_time)
                                 : 0
                           )
                           - 1
                     );
               }
               break label302;
            }

            if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true).isEmpty()
               && !entity.level().isClientSide()) {
               entity.discard();
            }

            if ((entity instanceof SpiderLungerEntity _datEntIxxx ? (Integer)_datEntIxxx.getEntityData().get(SpiderLungerEntity.DATA_attack_trigger_time) : 0)
                  > 0
               && entity instanceof SpiderLungerEntity _datEntSetI) {
               _datEntSetI.getEntityData()
                  .set(
                     SpiderLungerEntity.DATA_attack_trigger_time,
                     (
                           entity instanceof SpiderLungerEntity _datEntIxxxx
                              ? (Integer)_datEntIxxxx.getEntityData().get(SpiderLungerEntity.DATA_attack_trigger_time)
                              : 0
                        )
                        - 1
                  );
            }

            if ((entity instanceof SpiderLungerEntity _datEntIxxx ? (Integer)_datEntIxxx.getEntityData().get(SpiderLungerEntity.DATA_lunge_time) : 0) <= 0) {
               if (entity instanceof SpiderLungerEntity _datEntSetI) {
                  _datEntSetI.getEntityData().set(SpiderLungerEntity.DATA_lunge_time, 1200);
               }
            } else if (entity instanceof SpiderLungerEntity _datEntSetI) {
               _datEntSetI.getEntityData()
                  .set(
                     SpiderLungerEntity.DATA_lunge_time,
                     (entity instanceof SpiderLungerEntity _datEntIxxxx ? (Integer)_datEntIxxxx.getEntityData().get(SpiderLungerEntity.DATA_lunge_time) : 0)
                        - 1
                  );
            }

            if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
               target = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).stream().sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z)).findFirst().orElse(null);
               if ((
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
                           .checkGamemode(target)
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
                           .checkGamemode(target)
                  )
                  && (
                        entity instanceof SpiderLungerEntity _datEntIxxxx
                           ? (Integer)_datEntIxxxx.getEntityData().get(SpiderLungerEntity.DATA_attack_trigger_time)
                           : 0
                     )
                     <= 0) {
                  if (entity instanceof SpiderLungerEntity) {
                     ((SpiderLungerEntity)entity).setAnimation("animation.spider_lunger.fast");
                  }

                  if (!world.isClientSide()) {
                     entity.lookAt(Anchor.EYES, new Vec3(target.getX(), target.getY(), target.getZ()));
                  }

                  if (entity instanceof LivingEntity _entity) {
                     _entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
                  }

                  entity.setDeltaMovement(new Vec3(entity.getLookAngle().x / 2.0, entity.getDeltaMovement().y(), entity.getLookAngle().z / 2.0));
                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 1, false, false));
                  }

                  if (entity instanceof SpiderLungerEntity _datEntSetI) {
                     _datEntSetI.getEntityData().set(SpiderLungerEntity.DATA_attack_trigger_time, 1200);
                  }

                  if (entity instanceof SpiderLungerEntity _datEntSetI) {
                     _datEntSetI.getEntityData().set(SpiderLungerEntity.DATA_lunge_time, 0);
                  }
               }
            }

            if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
               Entity var17 = entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null;
               if (entity.getDeltaMovement().x() == 0.0 && entity.getDeltaMovement().z() == 0.0 && !world.isClientSide()) {
                  entity.lookAt(Anchor.EYES, new Vec3(var17.getX(), var17.getY(), var17.getZ()));
               }

               if ((entity instanceof SpiderLungerEntity _datEntIxxxx ? (Integer)_datEntIxxxx.getEntityData().get(SpiderLungerEntity.DATA_lunge_time) : 0)
                  > 1160) {
                  if (entity instanceof SpiderLungerEntity _datEntSetI) {
                     _datEntSetI.getEntityData().set(SpiderLungerEntity.DATA_lunge_time, 0);
                  }
               } else if ((
                     entity instanceof SpiderLungerEntity _datEntIxxxxx
                        ? (Integer)_datEntIxxxxx.getEntityData().get(SpiderLungerEntity.DATA_attack_trigger_time)
                        : 0
                  )
                  <= 0) {
                  yaw_compare = (double)Math.abs(((entity.getYRot() - var17.getYRot() + 180.0F) % 360.0F + 360.0F) % 360.0F - 180.0F);
                  if (yaw_compare > 90.0) {
                     entity.setDeltaMovement(new Vec3(0.0, entity.getDeltaMovement().y(), 0.0));
                     if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 100, false, false));
                     }
                  } else if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 0, false, false));
                  }

                  if (!world.isClientSide()) {
                     entity.lookAt(Anchor.EYES, new Vec3(var17.getX(), var17.getY(), var17.getZ()));
                  }
               }
            }

            if (!entity.isSwimming()) {
               if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null) {
                  entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), -0.3, entity.getDeltaMovement().z()));
               } else if (entity.getY() > (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getY()) {
                  entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), -0.3, entity.getDeltaMovement().z()));
               }
            }
         }

         entity.setMaxUpStep(1.5F);
      }
   }
}
