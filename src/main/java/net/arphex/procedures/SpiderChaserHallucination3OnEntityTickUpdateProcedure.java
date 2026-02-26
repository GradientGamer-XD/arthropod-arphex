package net.arphex.procedures;

import java.util.ArrayList;
import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SpiderChaserHallucination3OnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity store_nearest = null;
         double distance_compare = 0.0;
         double pitch_variance = 0.0;
         double random_once = 0.0;
         double store_dist = 0.0;
         double distance_scaling_factor = 0.0;
         double yaw_variance = 0.0;
         ArphexMod.queueServerWork(1200, () -> {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         });
         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 1, 0.2, 0.2, 0.2, 0.1);
         }

         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 7.0, 7.0, 7.0), e -> true).isEmpty()) {
            Entity entityiterator = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 7.0, 7.0, 7.0), e -> true)
               .stream()
               .sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z))
               .findFirst()
               .orElse(null);
            if (entityiterator instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect((MobEffect)ArphexModMobEffects.SPLINTERED_SANITY.get())) {
               world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 7.0, 7.0, 7.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null)
                  .hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)), 5.0F);
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            }

            ArphexMod.queueServerWork(10, () -> {
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            });
         }

         if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null && !(entity.getPersistentData().getDouble("find_nearest_player") > 0.0)) {
            distance_compare = 1000.0;

            for (Entity entityiterator : new ArrayList(world.players())) {
               if (!entityiterator.getPersistentData().getBoolean("creativespectator")
                  && Math.sqrt(
                        (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                           + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                           + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                     )
                     < distance_compare) {
                  distance_compare = Math.sqrt(
                     (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                        + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                        + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                  );
                  store_nearest = entityiterator;
               }
            }

            if (distance_compare < 1000.0) {
               if (entity instanceof Mob _entity && store_nearest instanceof LivingEntity _ent) {
                  _entity.setTarget(_ent);
               }

               if (entity instanceof Mob _entity) {
                  _entity.getNavigation().moveTo(store_nearest.getX(), store_nearest.getY(), store_nearest.getZ(), 1.2);
               }

               entity.getPersistentData().putDouble("find_nearest_player", 250.0);
            }
         }

         if (entity.getPersistentData().getDouble("find_nearest_player") > 0.0) {
            entity.getPersistentData().putDouble("find_nearest_player", entity.getPersistentData().getDouble("find_nearest_player") - 1.0);
         }

         for (Entity entityiteratorx : new ArrayList(world.players())) {
            if (entityiteratorx instanceof LivingEntity) {
               LivingEntity _livEnt50 = (LivingEntity)entityiteratorx;
               if (_livEnt50.hasEffect((MobEffect)ArphexModMobEffects.SPLINTERED_SANITY.get())) {
                  store_dist = Math.sqrt(
                     (entity.getX() - entityiteratorx.getX()) * (entity.getX() - entityiteratorx.getX())
                        + (entity.getY() - entityiteratorx.getY()) * (entity.getY() - entityiteratorx.getY())
                        + (entity.getZ() - entityiteratorx.getZ()) * (entity.getZ() - entityiteratorx.getZ())
                  );
                  if (store_dist < 4.0) {
                     entityiteratorx.hurt(
                        new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)), 6.0F
                     );
                  } else if (store_dist < 100.0 && entityiteratorx instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiteratorx;
                     if (_entity.swinging) {
                        pitch_variance = 25.0;
                        yaw_variance = 25.0;
                        distance_scaling_factor = 0.1;
                        if (yaw_variance
                                 / (
                                    Math.sqrt(
                                          (entity.getX() - entityiteratorx.getX()) * (entity.getX() - entityiteratorx.getX())
                                             + (entity.getY() - entityiteratorx.getY()) * (entity.getY() - entityiteratorx.getY())
                                             + (entity.getZ() - entityiteratorx.getZ()) * (entity.getZ() - entityiteratorx.getZ())
                                       )
                                       / 2.0
                                       * distance_scaling_factor
                                 )
                              > Math.min(
                                 Math.abs(
                                    (
                                             Math.toDegrees(Math.atan2(entityiteratorx.getZ() - entity.getZ(), entityiteratorx.getX() - entity.getX()))
                                                - (double)entityiteratorx.getYRot()
                                                + 360.0
                                          )
                                          % 360.0
                                       - 270.0
                                 ),
                                 360.0
                                    - Math.abs(
                                       (
                                                Math.toDegrees(Math.atan2(entityiteratorx.getZ() - entity.getZ(), entityiteratorx.getX() - entity.getX()))
                                                   - (double)entityiteratorx.getYRot()
                                                   + 360.0
                                             )
                                             % 360.0
                                          - 270.0
                                    )
                              )
                           && pitch_variance
                                 / (
                                    Math.sqrt(
                                          (entity.getX() - entityiteratorx.getX()) * (entity.getX() - entityiteratorx.getX())
                                             + (entity.getY() - entityiteratorx.getY()) * (entity.getY() - entityiteratorx.getY())
                                             + (entity.getZ() - entityiteratorx.getZ()) * (entity.getZ() - entityiteratorx.getZ())
                                       )
                                       / 2.0
                                       * distance_scaling_factor
                                 )
                              > (double)Math.round(
                                 Math.abs(
                                    (double)entityiteratorx.getXRot()
                                       - Math.toDegrees(
                                          Math.atan2(
                                             entityiteratorx.getY() - entity.getY(),
                                             Math.sqrt(
                                                (entityiteratorx.getZ() - entity.getZ()) * (entityiteratorx.getZ() - entity.getZ())
                                                   + (entityiteratorx.getX() - entity.getX()) * (entityiteratorx.getX() - entity.getX())
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
                              if (entityiteratorx instanceof LivingEntity) {
                                 LivingEntity _entityx = (LivingEntity)entityiteratorx;
                                 if (!_entityx.level().isClientSide()) {
                                    _entityx.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 2));
                                 }
                              }
                           } else if (random_once == 2.0) {
                              if (entityiteratorx instanceof LivingEntity) {
                                 LivingEntity _entityx = (LivingEntity)entityiteratorx;
                                 if (!_entityx.level().isClientSide()) {
                                    _entityx.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 1200, 2));
                                 }
                              }
                           } else if (random_once == 3.0) {
                              if (entityiteratorx instanceof LivingEntity) {
                                 LivingEntity _entityx = (LivingEntity)entityiteratorx;
                                 if (!_entityx.level().isClientSide()) {
                                    _entityx.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 2));
                                 }
                              }
                           } else if (random_once == 4.0) {
                              if (entityiteratorx instanceof LivingEntity) {
                                 LivingEntity _entityx = (LivingEntity)entityiteratorx;
                                 if (!_entityx.level().isClientSide()) {
                                    _entityx.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 1200, 2));
                                 }
                              }
                           } else if (entityiteratorx instanceof LivingEntity) {
                              LivingEntity _entityx = (LivingEntity)entityiteratorx;
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
