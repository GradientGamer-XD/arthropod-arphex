package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.AntArsonistAlateQueenEntity;
import net.arphex.entity.AntArsonistSoldierEntity;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AntArsonistSoldierOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         label273: {
            entity.setMaxUpStep(1.0F);
            entity.getPersistentData().putBoolean("arphex", true);
            if (entity instanceof AntArsonistSoldierEntity _datEntL2 && (Boolean)_datEntL2.getEntityData().get(AntArsonistSoldierEntity.DATA_larvae)) {
               entity.setDeltaMovement(new Vec3(0.0, entity.getDeltaMovement().y(), 0.0));
               entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 10, false, false));
               }

               entity.setSprinting(true);
               if (entity instanceof AntArsonistSoldierEntity animatable) {
                  animatable.setTexture("antlarvae");
               }

               ArphexMod.queueServerWork(800, () -> {
                  if (entity instanceof AntArsonistSoldierEntity _datEntSetL) {
                     _datEntSetL.getEntityData().set(AntArsonistSoldierEntity.DATA_larvae, false);
                  }
               });
               break label273;
            }

            if (entity instanceof AntArsonistSoldierEntity animatable) {
               animatable.setTexture("antsoldier");
            }

            entity.setSprinting(false);
         }

         label264: {
            if (entity instanceof TamableAnimal _tamEnt && _tamEnt.isTame()) {
               if ((entity instanceof TamableAnimal _tamEntx ? _tamEntx.getOwner() : null) != null) {
                  entity.setCustomName(
                     Component.literal(
                        (entity instanceof TamableAnimal _tamEntxx ? _tamEntxx.getOwner() : null).getDisplayName().getString() + "'s Fire Ant Soldier"
                     )
                  );
               }

               if (entity.isVehicle()
                  && (
                     !(entity instanceof TamableAnimal _tamIsTamedBy)
                        || !(entity.getFirstPassenger() instanceof LivingEntity _livEnt)
                        || !_tamIsTamedBy.isOwnedBy(_livEnt)
                  )) {
                  entity.getFirstPassenger().stopRiding();
               }
               break label264;
            }

            if (!world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
               Entity _level = world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null);
               if (_level instanceof TamableAnimal _tamEnt && _tamEnt.isTame()) {
                  Entity _tamEntx = world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if ((_tamEntx instanceof TamableAnimal _tamEntxx ? _tamEntxx.getOwner() : null) != null && entity instanceof TamableAnimal _toTame) {
                     Entity _tamEntxxx = world.getEntitiesOfClass(
                           AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true
                        )
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     if ((_tamEntxxx instanceof TamableAnimal _tamEntxxxx ? _tamEntxxxx.getOwner() : null) instanceof Player _owner) {
                        _toTame.tame(_owner);
                     }
                  }

                  _tamEntx = world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (_tamEntx instanceof LivingEntity _livEnt34
                     && _livEnt34.hasEffect(MobEffects.DAMAGE_RESISTANCE)
                     && entity instanceof LivingEntity _entity
                     && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, -1, 0));
                  }
               }
            }
         }

         if ((entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null) != null
            && (
               (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) instanceof Creeper
                  || (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getPersistentData().getBoolean("fromqueen")
            )
            && entity instanceof Mob) {
            try {
               ((Mob)entity).setTarget(null);
            } catch (Exception var16) {
               var16.printStackTrace();
            }
         }

         if (!(entity.getPersistentData().getDouble("soldiertime") > 0.0)) {
            if (entity instanceof TamableAnimal _tamEntxxx
               && _tamEntxxx.isTame()
               && (entity instanceof TamableAnimal _tamEnt ? _tamEnt.getOwner() : null) != null) {
               double _setval = 20.0;
               (entity instanceof TamableAnimal _tamEntxxxx ? _tamEntxxxx.getOwner() : null)
                  .getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .ifPresent(capability -> {
                     capability.ownedantsnear = _setval;
                     capability.syncPlayerVariables(entity instanceof TamableAnimal _tamEntxxxx ? _tamEntxxxx.getOwner() : null);
                  });
            }

            entity.getPersistentData().putDouble("soldiertime", 20.0);
         } else {
            entity.getPersistentData().putDouble("soldiertime", entity.getPersistentData().getDouble("soldiertime") - 1.0);
         }

         if (!(entity.getPersistentData().getDouble("workerticks") > 0.0)) {
            if (entity instanceof TamableAnimal _tamEntxxx
               && _tamEntxxx.isTame()
               && (entity instanceof TamableAnimal _tamEnt ? _tamEnt.getOwner() : null) != null) {
               (entity instanceof TamableAnimal _tamEntxxxx ? _tamEntxxxx.getOwner() : null).getPersistentData().putDouble("ownedantsnear", 20.0);
               if (world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).isEmpty()) {
                  if (!world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 180.0, 180.0, 180.0), e -> true).isEmpty()) {
                     Entity var49 = world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 180.0, 180.0, 180.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     if (var49 instanceof TamableAnimal _tamEntxxxxx && _tamEntxxxxx.isTame()) {
                        LivingEntity var69 = entity instanceof TamableAnimal _tamEntxxxxxx ? _tamEntxxxxxx.getOwner() : null;
                        Entity var55 = world.getEntitiesOfClass(
                              AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 180.0, 180.0, 180.0), e -> true
                           )
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null);
                        if (var69 == (var55 instanceof TamableAnimal _tamEntxxxxxxx ? _tamEntxxxxxxx.getOwner() : null) && entity instanceof Mob _entity) {
                           _entity.getNavigation()
                              .moveTo(
                                 world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 180.0, 180.0, 180.0), e -> true)
                                    .stream()
                                    .sorted((new Object() {
                                       Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                          return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                       }
                                    }).compareDistOf(x, y, z))
                                    .findFirst()
                                    .orElse(null)
                                    .getX(),
                                 world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 180.0, 180.0, 180.0), e -> true)
                                    .stream()
                                    .sorted((new Object() {
                                       Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                          return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                       }
                                    }).compareDistOf(x, y, z))
                                    .findFirst()
                                    .orElse(null)
                                    .getY(),
                                 world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 180.0, 180.0, 180.0), e -> true)
                                    .stream()
                                    .sorted((new Object() {
                                       Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                          return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                       }
                                    }).compareDistOf(x, y, z))
                                    .findFirst()
                                    .orElse(null)
                                    .getZ(),
                                 1.0
                              );
                        }
                     }
                  } else if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 120.0, 120.0, 120.0), e -> true).isEmpty()
                     && !entity.level().isClientSide()) {
                     entity.discard();
                  }
               }

               entity.getPersistentData()
                  .putDouble(
                     "this_ant",
                     (double)Math.round(
                        Math.sqrt(
                              (entity.getX() - (entity instanceof TamableAnimal _tamEntxxxxxxxxxxx ? _tamEntxxxxxxxxxxx.getOwner() : null).getX())
                                    * (entity.getX() - (entity instanceof TamableAnimal _tamEntxxxxxxxxxx ? _tamEntxxxxxxxxxx.getOwner() : null).getX())
                                 + (entity.getY() - (entity instanceof TamableAnimal _tamEntxxxxxxxxx ? _tamEntxxxxxxxxx.getOwner() : null).getY())
                                    * (entity.getY() - (entity instanceof TamableAnimal _tamEntxxxxxxxx ? _tamEntxxxxxxxx.getOwner() : null).getY())
                                 + (entity.getZ() - (entity instanceof TamableAnimal _tamEntxxxxxxx ? _tamEntxxxxxxx.getOwner() : null).getZ())
                                    * (entity.getZ() - (entity instanceof TamableAnimal _tamEntxxxxxx ? _tamEntxxxxxx.getOwner() : null).getZ())
                           )
                           / 2.0
                     )
                  );
            }

            entity.getPersistentData().putDouble("workerticks", 80.0);
         } else {
            entity.getPersistentData().putDouble("workerticks", entity.getPersistentData().getDouble("workerticks") - 1.0);
         }

         if ((entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)
               < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 2.0F
            && world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARRED_BLOOD.get(), x, y, z, 5, 0.6, 0.6, 0.6, 0.3);
         }

         if (entity instanceof LivingEntity _livEnt99 && _livEnt99.hasEffect(MobEffects.DAMAGE_RESISTANCE) && world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.WHITECOAL.get(), x, y, z, 2, 0.6, 0.6, 0.6, 0.3);
         }

         if ((!(entity instanceof LivingEntity _livEnt101) || !_livEnt101.hasEffect(MobEffects.REGENERATION))
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0, false, false));
         }
      }
   }
}
