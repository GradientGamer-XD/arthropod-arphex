package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.AntArsonistAlateQueenEntity;
import net.arphex.entity.AntArsonistDroneEntity;
import net.arphex.entity.AntArsonistWorkerEntity;
import net.arphex.entity.AoEflame2Entity;
import net.arphex.init.ArphexModBlocks;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
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
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AntArsonistWorkerOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         label488: {
            entity.getPersistentData().putBoolean("arphex", true);
            if (entity instanceof AntArsonistWorkerEntity _datEntL1 && (Boolean)_datEntL1.getEntityData().get(AntArsonistWorkerEntity.DATA_larvae)) {
               entity.setDeltaMovement(new Vec3(0.0, entity.getDeltaMovement().y(), 0.0));
               entity.setSprinting(true);
               entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 10, false, false));
               }

               if (entity instanceof AntArsonistWorkerEntity animatable) {
                  animatable.setTexture("antlarvae");
               }

               entity.setShiftKeyDown(false);
               ArphexMod.queueServerWork(800, () -> {
                  if (entity instanceof AntArsonistWorkerEntity _datEntSetL) {
                     _datEntSetL.getEntityData().set(AntArsonistWorkerEntity.DATA_larvae, false);
                  }
               });
               break label488;
            }

            entity.setSprinting(false);
            if (!entity.onGround() && world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ()))) {
               entity.setShiftKeyDown(true);
            } else {
               entity.setShiftKeyDown(false);
            }

            if (entity instanceof AntArsonistWorkerEntity animatable) {
               animatable.setTexture("antfire");
            }
         }

         label457: {
            if (entity instanceof TamableAnimal _tamEnt && _tamEnt.isTame()) {
               if (entity instanceof AntArsonistWorkerEntity _datEntL21 && (Boolean)_datEntL21.getEntityData().get(AntArsonistWorkerEntity.DATA_following)) {
                  break label457;
               }

               if (entity instanceof LivingEntity _livEnt22 && _livEnt22.hasEffect((MobEffect)ArphexModMobEffects.VOID_COOLDOWN.get())) {
                  if (!(entity.getPersistentData().getDouble("destroymode") > 0.0)) {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.GOLDEN_OPAL.get(), x, y, z, 5, 0.3, 0.3, 0.3, 0.3);
                     }

                     entity.getPersistentData().putDouble("destroymode", 20.0);
                     if (entity.getPersistentData().getDouble("navgx") != 0.0) {
                        if (entity instanceof Mob _entity) {
                           _entity.getNavigation()
                              .moveTo(
                                 entity.getPersistentData().getDouble("navgx"),
                                 entity.getPersistentData().getDouble("navgy"),
                                 entity.getPersistentData().getDouble("navgz"),
                                 1.3
                              );
                        }

                        if (entity.getY() < entity.getPersistentData().getDouble("navgy")) {
                           if (!world.isClientSide()) {
                              world.setBlock(
                                 BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()),
                                 ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                                 3
                              );
                           }
                        } else if (entity.getY() > entity.getPersistentData().getDouble("navgy") + 1.0) {
                           if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ())).getBlock()
                              == ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()) {
                              world.setBlock(BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ()), Blocks.AIR.defaultBlockState(), 3);
                           }
                        } else {
                           if (entity.getX() > entity.getPersistentData().getDouble("navgx")) {
                              if (world.getBlockState(BlockPos.containing(entity.getX() - 1.0, entity.getY() - 1.0, entity.getZ())).getBlock() == Blocks.AIR
                                 && !world.isClientSide()) {
                                 world.setBlock(
                                    BlockPos.containing(entity.getX() - 1.0, entity.getY() - 1.0, entity.getZ()),
                                    ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                                    3
                                 );
                              }
                           } else if (entity.getX() < entity.getPersistentData().getDouble("navgx")
                              && world.getBlockState(BlockPos.containing(entity.getX() + 1.0, entity.getY() - 1.0, entity.getZ())).getBlock() == Blocks.AIR
                              && !world.isClientSide()) {
                              world.setBlock(
                                 BlockPos.containing(entity.getX() + 1.0, entity.getY() - 1.0, entity.getZ()),
                                 ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                                 3
                              );
                           }

                           if (entity.getZ() > entity.getPersistentData().getDouble("navgz")) {
                              if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ() - 1.0)).getBlock() == Blocks.AIR
                                 && !world.isClientSide()) {
                                 world.setBlock(
                                    BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ() - 1.0),
                                    ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                                    3
                                 );
                              }
                           } else if (entity.getZ() < entity.getPersistentData().getDouble("navgz")
                              && world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ() + 1.0)).getBlock() == Blocks.AIR
                              && !world.isClientSide()) {
                              world.setBlock(
                                 BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ() + 1.0),
                                 ((Block)ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()).defaultBlockState(),
                                 3
                              );
                           }
                        }
                     }
                  } else {
                     entity.getPersistentData().putDouble("destroymode", entity.getPersistentData().getDouble("destroymode") - 1.0);
                  }
                  break label457;
               }

               entity.getPersistentData().putDouble("navgx", 0.0);
               entity.getPersistentData().putDouble("navgy", 0.0);
               entity.getPersistentData().putDouble("navgz", 0.0);
               break label457;
            }

            if (!world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
               Entity _serverPlayer = world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null);
               if (_serverPlayer instanceof TamableAnimal _tamEnt && _tamEnt.isTame() && entity instanceof TamableAnimal _toTame) {
                  Entity _tamEntx = world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if ((_tamEntx instanceof TamableAnimal _tamEntxx ? _tamEntxx.getOwner() : null) instanceof Player _owner) {
                     _toTame.tame(_owner);
                  }
               }
            }
         }

         if ((entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)
               < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 2.0F
            && world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARRED_BLOOD.get(), x, y, z, 5, 0.3, 0.3, 0.3, 0.3);
         }

         if (entity instanceof LivingEntity _livEnt111 && _livEnt111.hasEffect(MobEffects.DAMAGE_RESISTANCE) && world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.WHITECOAL.get(), x, y, z, 2, 0.3, 0.3, 0.3, 0.3);
         }

         label474: {
            if (entity instanceof TamableAnimal _tamEntx && _tamEntx.isTame()) {
               if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) != null
                  && (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof TamableAnimal _tamIsTamedBy
                  && (entity instanceof TamableAnimal _tamEntxx ? _tamEntxx.getOwner() : null) instanceof LivingEntity _livEnt
                  && _tamIsTamedBy.isOwnedBy(_livEnt)
                  && entity instanceof Mob) {
                  try {
                     ((Mob)entity).setTarget(null);
                  } catch (Exception var16) {
                     var16.printStackTrace();
                  }
               }

               entity.getPersistentData().putBoolean("arphexclimber", false);
               if ((entity instanceof TamableAnimal _tamEntxx ? _tamEntxx.getOwner() : null) != null) {
                  if (entity instanceof AntArsonistWorkerEntity _datEntL123 && (Boolean)_datEntL123.getEntityData().get(AntArsonistWorkerEntity.DATA_following)
                     )
                   {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 5, 0.3, 0.3, 0.3, 0.3);
                     }

                     entity.setCustomName(
                        Component.literal(
                           (entity instanceof TamableAnimal _tamEntxxx ? _tamEntxxx.getOwner() : null).getDisplayName().getString()
                              + "'s Fire Ant Worker (following)"
                        )
                     );
                     break label474;
                  }

                  entity.setCustomName(
                     Component.literal(
                        (entity instanceof TamableAnimal _tamEntxxx ? _tamEntxxx.getOwner() : null).getDisplayName().getString() + "'s Fire Ant Worker"
                     )
                  );
               }
               break label474;
            }

            if (Mth.nextInt(RandomSource.create(), 1, 1200) == 5) {
               if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true).isEmpty()
                  && !entity.level().isClientSide()) {
                  entity.discard();
               }

               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(
                     new MobEffectInstance(
                        (MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get(), Mth.nextInt(RandomSource.create(), 400, 800), 0, false, false
                     )
                  );
               }
            }

            entity.getPersistentData().putDouble("climbradius", 0.95);
            entity.getPersistentData().putBoolean("arphexclimber", true);
         }

         if (!(entity.getPersistentData().getDouble("workerticks") > 0.0)) {
            if (entity instanceof TamableAnimal _tamEntx && _tamEntx.isTame()) {
               if ((entity instanceof TamableAnimal _tamEntxx ? _tamEntxx.getOwner() : null) != null) {
                  (entity instanceof TamableAnimal _tamEntxxx ? _tamEntxxx.getOwner() : null).getPersistentData().putDouble("ownedantsnear", 20.0);
               }

               if (world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).isEmpty()) {
                  if (!world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 180.0, 180.0, 180.0), e -> true).isEmpty()) {
                     Entity var46 = world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 180.0, 180.0, 180.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     if (var46 instanceof TamableAnimal _tamEntxx && _tamEntxx.isTame()) {
                        LivingEntity var85 = entity instanceof TamableAnimal _tamEntxxx ? _tamEntxxx.getOwner() : null;
                        Entity var66 = world.getEntitiesOfClass(
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
                        if (var85 == (var66 instanceof TamableAnimal _tamEntxxxx ? _tamEntxxxx.getOwner() : null) && entity instanceof Mob _entity) {
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
               } else if ((
                     !(entity instanceof AntArsonistWorkerEntity _datEntL161)
                        || !(Boolean)_datEntL161.getEntityData().get(AntArsonistWorkerEntity.DATA_following)
                  )
                  && !world.getEntitiesOfClass(AoEflame2Entity.class, AABB.ofSize(new Vec3(x, y, z), 120.0, 120.0, 120.0), e -> true).isEmpty()
                  && entity instanceof Mob _entity) {
                  _entity.getNavigation()
                     .moveTo(
                        world.getEntitiesOfClass(AntArsonistDroneEntity.class, AABB.ofSize(new Vec3(x, y, z), 180.0, 180.0, 180.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y, z))
                              .findFirst()
                              .orElse(null)
                              .getX()
                           + (double)Mth.nextInt(RandomSource.create(), -20, 20),
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

               if ((entity instanceof TamableAnimal _tamEntxxx ? _tamEntxxx.getOwner() : null) != null) {
                  entity.getPersistentData()
                     .putDouble(
                        "this_ant",
                        (double)Math.round(
                           Math.sqrt(
                                 (entity.getX() - (entity instanceof TamableAnimal _tamEntxxxxxxxxx ? _tamEntxxxxxxxxx.getOwner() : null).getX())
                                       * (entity.getX() - (entity instanceof TamableAnimal _tamEntxxxxxxxx ? _tamEntxxxxxxxx.getOwner() : null).getX())
                                    + (entity.getY() - (entity instanceof TamableAnimal _tamEntxxxxxxx ? _tamEntxxxxxxx.getOwner() : null).getY())
                                       * (entity.getY() - (entity instanceof TamableAnimal _tamEntxxxxxx ? _tamEntxxxxxx.getOwner() : null).getY())
                                    + (entity.getZ() - (entity instanceof TamableAnimal _tamEntxxxxx ? _tamEntxxxxx.getOwner() : null).getZ())
                                       * (entity.getZ() - (entity instanceof TamableAnimal _tamEntxxxx ? _tamEntxxxx.getOwner() : null).getZ())
                              )
                              / 2.0
                        )
                     );
               }
            }

            if ((entity instanceof TamableAnimal _tamEntx ? _tamEntx.getOwner() : null) != null
               && (
                  !(entity instanceof AntArsonistWorkerEntity _datEntL194) || !(Boolean)_datEntL194.getEntityData().get(AntArsonistWorkerEntity.DATA_following)
               )
               && !world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true).isEmpty()) {
               Entity var63 = world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null);
               if (var63 instanceof TamableAnimal _tamEntxxx && _tamEntxxx.isTame()) {
                  Entity var76 = world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (var76 instanceof TamableAnimal _tamIsTamedBy
                     && (entity instanceof TamableAnimal _tamEntxxxx ? _tamEntxxxx.getOwner() : null) instanceof LivingEntity _livEnt
                     && _tamIsTamedBy.isOwnedBy(_livEnt)
                     && world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 0.8, entity.getZ())).getBlock() == Blocks.FARMLAND
                     && world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() + 0.2, entity.getZ()))) {
                     if (world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null)
                        .getPersistentData()
                        .getString("plantversion")
                        .equals("seeds")) {
                        world.setBlock(BlockPos.containing(entity.getX(), entity.getY() + 0.2, entity.getZ()), Blocks.WHEAT.defaultBlockState(), 3);
                     } else if (world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null)
                        .getPersistentData()
                        .getString("plantversion")
                        .equals("oak")) {
                        world.setBlock(BlockPos.containing(entity.getX(), entity.getY() + 0.2, entity.getZ()), Blocks.OAK_SAPLING.defaultBlockState(), 3);
                     } else if (world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null)
                        .getPersistentData()
                        .getString("plantversion")
                        .equals("darkoak")) {
                        world.setBlock(BlockPos.containing(entity.getX(), entity.getY() + 0.2, entity.getZ()), Blocks.DARK_OAK_SAPLING.defaultBlockState(), 3);
                     } else if (world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null)
                        .getPersistentData()
                        .getString("plantversion")
                        .equals("spruce")) {
                        world.setBlock(BlockPos.containing(entity.getX(), entity.getY() + 0.2, entity.getZ()), Blocks.SPRUCE_SAPLING.defaultBlockState(), 3);
                     } else if (world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null)
                        .getPersistentData()
                        .getString("plantversion")
                        .equals("birch")) {
                        world.setBlock(BlockPos.containing(entity.getX(), entity.getY() + 0.2, entity.getZ()), Blocks.BIRCH_SAPLING.defaultBlockState(), 3);
                     } else if (world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null)
                        .getPersistentData()
                        .getString("plantversion")
                        .equals("jungle")) {
                        world.setBlock(BlockPos.containing(entity.getX(), entity.getY() + 0.2, entity.getZ()), Blocks.JUNGLE_SAPLING.defaultBlockState(), 3);
                     } else if (world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null)
                        .getPersistentData()
                        .getString("plantversion")
                        .equals("acacia")) {
                        world.setBlock(BlockPos.containing(entity.getX(), entity.getY() + 0.2, entity.getZ()), Blocks.ACACIA_SAPLING.defaultBlockState(), 3);
                     } else if (world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null)
                        .getPersistentData()
                        .getString("plantversion")
                        .equals("cherry")) {
                        world.setBlock(BlockPos.containing(entity.getX(), entity.getY() + 0.2, entity.getZ()), Blocks.CHERRY_SAPLING.defaultBlockState(), 3);
                     } else if (world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null)
                        .getPersistentData()
                        .getString("plantversion")
                        .equals("pumpkin")) {
                        world.setBlock(BlockPos.containing(entity.getX(), entity.getY() + 0.2, entity.getZ()), Blocks.PUMPKIN_STEM.defaultBlockState(), 3);
                     } else if (world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null)
                        .getPersistentData()
                        .getString("plantversion")
                        .equals("melon")) {
                        world.setBlock(BlockPos.containing(entity.getX(), entity.getY() + 0.2, entity.getZ()), Blocks.MELON_STEM.defaultBlockState(), 3);
                     } else if (world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null)
                        .getPersistentData()
                        .getString("plantversion")
                        .equals("carrot")) {
                        world.setBlock(BlockPos.containing(entity.getX(), entity.getY() + 0.2, entity.getZ()), Blocks.CARROTS.defaultBlockState(), 3);
                     } else if (world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null)
                        .getPersistentData()
                        .getString("plantversion")
                        .equals("potato")) {
                        world.setBlock(BlockPos.containing(entity.getX(), entity.getY() + 0.2, entity.getZ()), Blocks.POTATOES.defaultBlockState(), 3);
                     }
                  }
               }
            }

            entity.getPersistentData().putDouble("workerticks", 80.0);
         } else {
            entity.getPersistentData().putDouble("workerticks", entity.getPersistentData().getDouble("workerticks") - 1.0);
         }

         if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).getBlock() == ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()) {
            if (world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() + 1.0, entity.getZ()))) {
               entity.teleportTo(entity.getX(), entity.getY() + 1.0, entity.getZ());
               if (entity instanceof ServerPlayer _serverPlayer) {
                  _serverPlayer.connection.teleport(entity.getX(), entity.getY() + 1.0, entity.getZ(), entity.getYRot(), entity.getXRot());
               }
            } else {
               world.setBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), Blocks.AIR.defaultBlockState(), 3);
            }
         } else if (entity instanceof LivingEntity _livEnt302 && _livEnt302.hasEffect((MobEffect)ArphexModMobEffects.VOID_COOLDOWN.get())) {
            if (world.getBlockState(BlockPos.containing(entity.getX() + 0.6, entity.getY(), entity.getZ())).getBlock()
               == ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()) {
               if (world.isEmptyBlock(BlockPos.containing(entity.getX() + 0.6, entity.getY() + 1.0, entity.getZ()))) {
                  entity.teleportTo(entity.getX() + 0.6, entity.getY() + 1.0, entity.getZ());
                  if (entity instanceof ServerPlayer _serverPlayer) {
                     _serverPlayer.connection.teleport(entity.getX() + 0.6, entity.getY() + 1.0, entity.getZ(), entity.getYRot(), entity.getXRot());
                  }
               } else {
                  world.setBlock(BlockPos.containing(entity.getX() + 0.6, entity.getY(), entity.getZ()), Blocks.AIR.defaultBlockState(), 3);
               }
            } else if (world.getBlockState(BlockPos.containing(entity.getX() - 0.6, entity.getY(), entity.getZ())).getBlock()
               == ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()) {
               if (world.isEmptyBlock(BlockPos.containing(entity.getX() - 0.6, entity.getY() + 1.0, entity.getZ()))) {
                  entity.teleportTo(entity.getX() - 0.6, entity.getY() + 1.0, entity.getZ());
                  if (entity instanceof ServerPlayer _serverPlayer) {
                     _serverPlayer.connection.teleport(entity.getX() - 0.6, entity.getY() + 1.0, entity.getZ(), entity.getYRot(), entity.getXRot());
                  }
               } else {
                  world.setBlock(BlockPos.containing(entity.getX() - 0.6, entity.getY(), entity.getZ()), Blocks.AIR.defaultBlockState(), 3);
               }
            } else if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() - 0.6)).getBlock()
               == ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()) {
               if (world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() + 1.0, entity.getZ() - 0.6))) {
                  entity.teleportTo(entity.getX(), entity.getY() + 1.0, entity.getZ() - 0.6);
                  if (entity instanceof ServerPlayer _serverPlayer) {
                     _serverPlayer.connection.teleport(entity.getX(), entity.getY() + 1.0, entity.getZ() - 0.6, entity.getYRot(), entity.getXRot());
                  }
               } else {
                  world.setBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() - 0.6), Blocks.AIR.defaultBlockState(), 3);
               }
            } else if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() + 0.6)).getBlock()
               == ArphexModBlocks.ANT_SHIELD_TEMPORARY.get()) {
               if (world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() + 1.0, entity.getZ() + 0.6))) {
                  entity.teleportTo(entity.getX(), entity.getY() + 1.0, entity.getZ() + 0.6);
                  if (entity instanceof ServerPlayer _serverPlayer) {
                     _serverPlayer.connection.teleport(entity.getX(), entity.getY() + 1.0, entity.getZ() + 0.6, entity.getYRot(), entity.getXRot());
                  }
               } else {
                  world.setBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() + 0.6), Blocks.AIR.defaultBlockState(), 3);
               }
            }
         }

         if (entity.isInWall() && world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() + 1.0, entity.getZ()))) {
            entity.teleportTo(entity.getX(), entity.getY() + 1.0, entity.getZ());
            if (entity instanceof ServerPlayer _serverPlayer) {
               _serverPlayer.connection.teleport(entity.getX(), entity.getY() + 1.0, entity.getZ(), entity.getYRot(), entity.getXRot());
            }
         }
      }
   }
}
