package net.arphex.procedures;

import java.util.ArrayList;
import java.util.Comparator;
import net.arphex.entity.MothShadowCloneEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class MothShadowCloneOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double pitch_variance = 0.0;
         double random_once = 0.0;
         double store_dist = 0.0;
         double distance_scaling_factor = 0.0;
         double yaw_variance = 0.0;
         Entity nearest_player = null;
         nearest_player = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true)
            .stream()
            .sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z))
            .findFirst()
            .orElse(null);
         if (nearest_player == null) {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }

            if (world instanceof ServerLevel _level) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE.get())
                  .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
               }
            }
         } else {
            entity.lookAt(Anchor.EYES, new Vec3(nearest_player.getX(), nearest_player.getY(), nearest_player.getZ()));
            if (!world.getEntitiesOfClass(
                     Player.class,
                     AABB.ofSize(
                        new Vec3(x, y, z),
                        ArphexModVariables.MapVariables.get(world).clonesize + 100.0,
                        ArphexModVariables.MapVariables.get(world).clonesize + 100.0,
                        ArphexModVariables.MapVariables.get(world).clonesize + 100.0
                     ),
                     e -> true
                  )
                  .isEmpty()
               && Mth.nextInt(RandomSource.create(), 1, 60) == 10
               && !nearest_player.getPersistentData().getBoolean("creativespectator")) {
               if (Mth.nextInt(RandomSource.create(), 1, 4) == 3) {
                  if (entity instanceof MothShadowCloneEntity && world instanceof ServerLevel _levelx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.RUSH_SCARE.get())
                        .spawn(_levelx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else {
                  if (world instanceof ServerLevel _levelxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE.get())
                        .spawn(_levelxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }

                  if (world instanceof ServerLevel _levelxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE.get())
                        .spawn(_levelxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }

                  if (world instanceof ServerLevel _levelxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE.get())
                        .spawn(_levelxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }

                  if (world instanceof ServerLevel _levelxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE.get())
                        .spawn(_levelxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            }
         }

         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 60.0, 60.0, 60.0), e -> true).isEmpty() && !entity.level().isClientSide()) {
            entity.discard();
         }

         for (Entity entityiterator : new ArrayList(world.players())) {
            if (entityiterator instanceof LivingEntity) {
               LivingEntity _livEnt21 = (LivingEntity)entityiterator;
               if (_livEnt21.hasEffect((MobEffect)ArphexModMobEffects.SPLINTERED_SANITY.get())) {
                  store_dist = Math.sqrt(
                     (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                        + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                        + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                  );
                  if (store_dist < 4.0) {
                     entityiterator.hurt(
                        new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)), 8.0F
                     );
                  } else if (store_dist < 100.0 && entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (_entity.swinging) {
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
                                 LivingEntity _entityx = (LivingEntity)entityiterator;
                                 if (!_entityx.level().isClientSide()) {
                                    _entityx.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 2));
                                 }
                              }
                           } else if (random_once == 2.0) {
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _entityx = (LivingEntity)entityiterator;
                                 if (!_entityx.level().isClientSide()) {
                                    _entityx.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 1200, 2));
                                 }
                              }
                           } else if (random_once == 3.0) {
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _entityx = (LivingEntity)entityiterator;
                                 if (!_entityx.level().isClientSide()) {
                                    _entityx.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 2));
                                 }
                              }
                           } else if (random_once == 4.0) {
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _entityx = (LivingEntity)entityiterator;
                                 if (!_entityx.level().isClientSide()) {
                                    _entityx.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 1200, 2));
                                 }
                              }
                           } else if (entityiterator instanceof LivingEntity) {
                              LivingEntity _entityx = (LivingEntity)entityiterator;
                              if (!_entityx.level().isClientSide()) {
                                 _entityx.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 2));
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
