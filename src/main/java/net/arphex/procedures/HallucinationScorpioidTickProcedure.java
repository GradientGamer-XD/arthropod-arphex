package net.arphex.procedures;

import java.util.ArrayList;
import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.ScorpioidBloodlusterEntity;
import net.arphex.entity.SpiderChaserHallucinationEntity;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
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
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class HallucinationScorpioidTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double pitch_variance = 0.0;
         double distance_scaling_factor = 0.0;
         double yaw_variance = 0.0;
         double random_once = 0.0;
         double store_dist = 0.0;
         entity.setCustomName(Component.literal(""));
         if (entity.isInWall() && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5, 5, false, false));
         }

         if (world.isEmptyBlock(BlockPos.containing(x, y - 0.1, z)) && world.isEmptyBlock(BlockPos.containing(x, y - 1.1, z))) {
            entity.setSprinting(false);
            entity.setShiftKeyDown(false);
         } else if (!(entity.getDeltaMovement().x() > 0.0) && !(entity.getDeltaMovement().z() > 0.0) && !world.isEmptyBlock(BlockPos.containing(x, y - 0.1, z))
            )
          {
            entity.setShiftKeyDown(true);
            entity.setSprinting(false);
         } else {
            entity.setShiftKeyDown(false);
            entity.setSprinting(true);
         }

         if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
            label225: {
               if (entity instanceof LivingEntity _livEnt16 && _livEnt16.hasEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get())) {
                  break label225;
               }

               if (entity.getY() < (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getY() + 0.5) {
                  if (entity instanceof SpiderChaserHallucinationEntity) {
                     entity.setDeltaMovement(
                        new Vec3(
                           Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.0,
                           0.3,
                           Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.0
                        )
                     );
                  } else {
                     entity.setDeltaMovement(
                        new Vec3(
                           Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                           0.3,
                           Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                        )
                     );
                  }
               } else if (entity instanceof SpiderChaserHallucinationEntity) {
                  entity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.0,
                        -0.2,
                        Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.0
                     )
                  );
               } else {
                  entity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                        -0.2,
                        Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                     )
                  );
               }
            }

            if (entity.getPersistentData().getDouble("tptime") == 5.0 || entity.getPersistentData().getDouble("tptime") == 45.0) {
               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                           .withSuppressedOutput(),
                        "execute at @e[type=arphex:scorpioid_chaser_hallucination,limit=1,sort=nearest] run tp @e[type=arphex:scorpioid_chaser_hallucination,limit=1,sort=nearest] ^ ^0.01 ^6"
                     );
               }

               if (entity.getY() < (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getY() + 0.5) {
                  entity.teleportTo(entity.getX(), entity.getY() + 1.0, entity.getZ());
                  if (entity instanceof ServerPlayer _serverPlayer) {
                     _serverPlayer.connection.teleport(entity.getX(), entity.getY() + 1.0, entity.getZ(), entity.getYRot(), entity.getXRot());
                  }
               } else {
                  entity.teleportTo(entity.getX(), entity.getY() - 1.0, entity.getZ());
                  if (entity instanceof ServerPlayer _serverPlayer) {
                     _serverPlayer.connection.teleport(entity.getX(), entity.getY() - 1.0, entity.getZ(), entity.getYRot(), entity.getXRot());
                  }
               }
            }

            if (entity.getPersistentData().getDouble("tptime") > 0.0) {
               entity.getPersistentData().putDouble("tptime", entity.getPersistentData().getDouble("tptime") - 1.0);
            } else {
               entity.getPersistentData().putDouble("tptime", 80.0);
            }
         }

         if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).isEmpty()) {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARRED_BLOOD.get(), x, y, z, 5, 0.3, 0.3, 0.3, 0.3);
            }
         }

         if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
               != ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))
            && !world.getEntitiesOfClass(ScorpioidBloodlusterEntity.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).isEmpty()) {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARRED_BLOOD.get(), x, y, z, 5, 0.3, 0.3, 0.3, 0.3);
            }
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect(MobEffects.WITHER);
         }

         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 6.0, 6.0, 6.0), e -> true).isEmpty()) {
            ArphexMod.queueServerWork(10, () -> {
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }

               if (world instanceof ServerLevel _levelx) {
                  _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 5, 0.3, 0.7, 0.3, 0.3);
               }
            });
         }

         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 250.0, 250.0, 250.0), e -> true).isEmpty()
            && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 250.0, 250.0, 250.0), e -> true).stream().sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z)).findFirst().orElse(null).getPersistentData().getBoolean("creativespectator")) {
            if (entity.getPersistentData().getDouble("tptime") == 5.0 || entity.getPersistentData().getDouble("tptime") == 45.0) {
               entity.lookAt(
                  Anchor.EYES,
                  new Vec3(
                     world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 250.0, 250.0, 250.0), e -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z)).findFirst().orElse(null).getX(),
                     world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 250.0, 250.0, 250.0), e -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                     world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 250.0, 250.0, 250.0), e -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ()
                  )
               );
            }

            if (entity instanceof Mob _entity) {
               Entity var41 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 250.0, 250.0, 250.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null);
               if (var41 instanceof LivingEntity _ent) {
                  _entity.setTarget(_ent);
               }
            }
         }

         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 1, 0.3, 0.6, 0.3, 0.2);
         }

         for (Entity entityiterator : new ArrayList(world.players())) {
            if (entityiterator instanceof LivingEntity) {
               LivingEntity _livEnt81 = (LivingEntity)entityiterator;
               if (_livEnt81.hasEffect((MobEffect)ArphexModMobEffects.SPLINTERED_SANITY.get())) {
                  store_dist = Math.sqrt(
                     (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                        + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                        + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                  );
                  if (store_dist < 4.0) {
                     if (!(entity.getPersistentData().getDouble("slow_splinter") > 0.0)) {
                        entity.getPersistentData().putDouble("slow_splinter", 10.0);
                        entityiterator.hurt(
                           new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)), 7.0F
                        );
                     } else {
                        entity.getPersistentData().putDouble("slow_splinter", entity.getPersistentData().getDouble("slow_splinter") - 1.0);
                     }
                  } else if (store_dist < 100.0 && entityiterator instanceof LivingEntity) {
                     LivingEntity _entityx = (LivingEntity)entityiterator;
                     if (_entityx.swinging) {
                        pitch_variance = 25.0;
                        yaw_variance = 25.0;
                        distance_scaling_factor = 0.1;
                        if (yaw_variance
                                 / (
                                    Math.sqrt(
                                          (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                                             + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                                             + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                                       )
                                       / 2.0
                                       * distance_scaling_factor
                                 )
                              > Math.min(
                                 Math.abs(
                                    (
                                             Math.toDegrees(Math.atan2(entityiterator.getZ() - entity.getZ(), entityiterator.getX() - entity.getX()))
                                                - (double)entityiterator.getYRot()
                                                + 360.0
                                          )
                                          % 360.0
                                       - 270.0
                                 ),
                                 360.0
                                    - Math.abs(
                                       (
                                                Math.toDegrees(Math.atan2(entityiterator.getZ() - entity.getZ(), entityiterator.getX() - entity.getX()))
                                                   - (double)entityiterator.getYRot()
                                                   + 360.0
                                             )
                                             % 360.0
                                          - 270.0
                                    )
                              )
                           && pitch_variance
                                 / (
                                    Math.sqrt(
                                          (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                                             + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                                             + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                                       )
                                       / 2.0
                                       * distance_scaling_factor
                                 )
                              > (double)Math.round(
                                 Math.abs(
                                    (double)entityiterator.getXRot()
                                       - Math.toDegrees(
                                          Math.atan2(
                                             entityiterator.getY() - entity.getY(),
                                             Math.sqrt(
                                                (entityiterator.getZ() - entity.getZ()) * (entityiterator.getZ() - entity.getZ())
                                                   + (entityiterator.getX() - entity.getX()) * (entityiterator.getX() - entity.getX())
                                             )
                                          )
                                       )
                                 )
                              )) {
                           if (!entity.level().isClientSide()) {
                              entity.discard();
                           }

                           random_once = (double)Mth.nextInt(RandomSource.create(), 1, 5);
                           if (random_once == 1.0) {
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _entityxx = (LivingEntity)entityiterator;
                                 if (!_entityxx.level().isClientSide()) {
                                    _entityxx.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 2));
                                 }
                              }
                           } else if (random_once == 2.0) {
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _entityxx = (LivingEntity)entityiterator;
                                 if (!_entityxx.level().isClientSide()) {
                                    _entityxx.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 1200, 2));
                                 }
                              }
                           } else if (random_once == 3.0) {
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _entityxx = (LivingEntity)entityiterator;
                                 if (!_entityxx.level().isClientSide()) {
                                    _entityxx.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 2));
                                 }
                              }
                           } else if (random_once == 4.0) {
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _entityxx = (LivingEntity)entityiterator;
                                 if (!_entityxx.level().isClientSide()) {
                                    _entityxx.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 1200, 2));
                                 }
                              }
                           } else if (entityiterator instanceof LivingEntity) {
                              LivingEntity _entityxx = (LivingEntity)entityiterator;
                              if (!_entityxx.level().isClientSide()) {
                                 _entityxx.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 2));
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }
}
