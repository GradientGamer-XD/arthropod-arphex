package net.arphex.procedures;

import java.util.ArrayList;
import java.util.Comparator;
import net.arphex.entity.DiabolosDecimatorCloneEntity;
import net.arphex.entity.DiabolosDecimatorEntity;
import net.arphex.entity.SlowLookTestEntity;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class SlowLookTestOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double pitch_variance = 0.0;
         double distance_scaling_factor = 0.0;
         double yaw_variance = 0.0;
         double distance_level = 0.0;
         double turnspeed = 0.0;
         double expand = 0.0;
         double distance = 0.0;
         double zfind = 0.0;
         double spheresize = 0.0;
         double pitch_distance_variance = 0.0;
         double yaw_distance_variance = 0.0;
         double xfind = 0.0;
         double yfind = 0.0;
         double y_offset = 0.0;
         Entity diaboloslock = null;
         Entity initial_lock = null;
         Entity nearest_clone = null;
         boolean foundnearest = false;
         boolean clonenearer = false;
         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                        CommandSource.NULL,
                        new Vec3(entity.getX(), entity.getY() + 0.5, entity.getZ()),
                        Vec2.ZERO,
                        _level,
                        4,
                        "",
                        Component.literal(""),
                        _level.getServer(),
                        null
                     )
                     .withSuppressedOutput(),
                  "particle arphex:heavy_red_smoke ~ ~ ~ 0 0 0 0 1 force"
               );
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

         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get(), 5, 0, false, false));
         }

         initial_lock = world.getEntitiesOfClass(
               DiabolosDecimatorEntity.class, AABB.ofSize(new Vec3(entity.getX(), entity.getY() - 15.0, entity.getZ()), 250.0, 250.0, 250.0), e -> true
            )
            .stream()
            .sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(entity.getX(), entity.getY() - 15.0, entity.getZ()))
            .findFirst()
            .orElse(null);
         nearest_clone = world.getEntitiesOfClass(
               DiabolosDecimatorCloneEntity.class, AABB.ofSize(new Vec3(entity.getX(), entity.getY() - 15.0, entity.getZ()), 100.0, 100.0, 100.0), e -> true
            )
            .stream()
            .sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(entity.getX(), entity.getY() - 15.0, entity.getZ()))
            .findFirst()
            .orElse(null);
         Vec3 _center = new Vec3(x, y, z);

         for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2.5), e -> true)
            .stream()
            .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
            .toList()) {
            if (entityiterator instanceof SlowLookTestEntity
               && entityiterator != entity
               && entity.getPersistentData().getDouble("random_comparetag") > entityiterator.getPersistentData().getDouble("random_comparetag")
               && !entity.level().isClientSide()) {
               entity.discard();
            }
         }

         if (initial_lock == null) {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         } else if (nearest_clone == null) {
            if ((
                  (
                           initial_lock instanceof DiabolosDecimatorEntity _datEntIx
                              ? (Integer)_datEntIx.getEntityData().get(DiabolosDecimatorEntity.DATA_size_num)
                              : 0
                        )
                        > 1000
                     || (
                           initial_lock instanceof DiabolosDecimatorEntity _datEntI
                              ? (Integer)_datEntI.getEntityData().get(DiabolosDecimatorEntity.DATA_current_final)
                              : 0
                        )
                        == 1
               )
               && !entity.level().isClientSide()) {
               entity.discard();
            }
         } else {
            clonenearer = Math.sqrt(
                  (entity.getX() - initial_lock.getX()) * (entity.getX() - initial_lock.getX())
                     + (entity.getY() - initial_lock.getY()) * (entity.getY() - initial_lock.getY())
                     + (entity.getZ() - initial_lock.getZ()) * (entity.getZ() - initial_lock.getZ())
               )
               > Math.sqrt(
                  (entity.getX() - nearest_clone.getX()) * (entity.getX() - nearest_clone.getX())
                     + (entity.getY() - nearest_clone.getY()) * (entity.getY() - nearest_clone.getY())
                     + (entity.getZ() - nearest_clone.getZ()) * (entity.getZ() - nearest_clone.getZ())
               );
            if (!clonenearer
               && (
                  (
                           initial_lock instanceof DiabolosDecimatorEntity _datEntIx
                              ? (Integer)_datEntIx.getEntityData().get(DiabolosDecimatorEntity.DATA_size_num)
                              : 0
                        )
                        > 1000
                     || (
                           initial_lock instanceof DiabolosDecimatorEntity _datEntI
                              ? (Integer)_datEntI.getEntityData().get(DiabolosDecimatorEntity.DATA_current_final)
                              : 0
                        )
                        == 1
               )
               && !entity.level().isClientSide()) {
               entity.discard();
            }
         }

         if (entity instanceof SlowLookTestEntity _datEntSetI) {
            _datEntSetI.getEntityData()
               .set(
                  SlowLookTestEntity.DATA_lifespan,
                  (entity instanceof SlowLookTestEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SlowLookTestEntity.DATA_lifespan) : 0) + 1
               );
         }

         if ((
               (entity instanceof SlowLookTestEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SlowLookTestEntity.DATA_lifespan) : 0) > 260
                  || (entity instanceof SlowLookTestEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SlowLookTestEntity.DATA_lifespan) : 0) < 100
            )
            && entity instanceof SlowLookTestEntity _datEntSetI) {
            _datEntSetI.getEntityData().set(SlowLookTestEntity.DATA_laser_switch_time, 75);
         }

         if ((entity instanceof SlowLookTestEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SlowLookTestEntity.DATA_lifespan) : 0) > 300
            && !entity.level().isClientSide()) {
            entity.discard();
         }

         if (initial_lock != null) {
            if (nearest_clone == null) {
               entity.teleportTo(initial_lock.getX(), initial_lock.getY() + 15.0, initial_lock.getZ());
               if (entity instanceof ServerPlayer _serverPlayer) {
                  _serverPlayer.connection.teleport(initial_lock.getX(), initial_lock.getY() + 15.0, initial_lock.getZ(), entity.getYRot(), entity.getXRot());
               }
            } else if (clonenearer) {
               entity.teleportTo(nearest_clone.getX(), nearest_clone.getY() + 15.0, nearest_clone.getZ());
               if (entity instanceof ServerPlayer _serverPlayer) {
                  _serverPlayer.connection
                     .teleport(nearest_clone.getX(), nearest_clone.getY() + 15.0, nearest_clone.getZ(), entity.getYRot(), entity.getXRot());
               }
            } else {
               entity.teleportTo(initial_lock.getX(), initial_lock.getY() + 15.0, initial_lock.getZ());
               if (entity instanceof ServerPlayer _serverPlayer) {
                  _serverPlayer.connection.teleport(initial_lock.getX(), initial_lock.getY() + 15.0, initial_lock.getZ(), entity.getYRot(), entity.getXRot());
               }
            }

            if ((initial_lock instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null) {
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else {
               diaboloslock = initial_lock instanceof Mob _mobEntx ? _mobEntx.getTarget() : null;
               if (diaboloslock != null) {
                  if ((entity instanceof SlowLookTestEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SlowLookTestEntity.DATA_laser_switch_time) : 0)
                     <= 0) {
                     if (entity instanceof SlowLookTestEntity _datEntSetI) {
                        _datEntSetI.getEntityData().set(SlowLookTestEntity.DATA_laser_switch_time, 80);
                     }
                  } else if (entity instanceof SlowLookTestEntity _datEntSetI) {
                     _datEntSetI.getEntityData()
                        .set(
                           SlowLookTestEntity.DATA_laser_switch_time,
                           (
                                 entity instanceof SlowLookTestEntity _datEntIx
                                    ? (Integer)_datEntIx.getEntityData().get(SlowLookTestEntity.DATA_laser_switch_time)
                                    : 0
                              )
                              - 1
                        );
                  }

                  if ((entity instanceof SlowLookTestEntity _datEntIxx ? (Integer)_datEntIxx.getEntityData().get(SlowLookTestEntity.DATA_laser_switch_time) : 0)
                        > 40
                     && (entity instanceof SlowLookTestEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SlowLookTestEntity.DATA_lifespan) : 0) < 260
                     && !world.isClientSide()) {
                     entity.lookAt(Anchor.EYES, new Vec3(diaboloslock.getX(), diaboloslock.getY(), diaboloslock.getZ()));
                  }

                  if (!(entity.getPersistentData().getDouble("wait_spark_lim") > 0.0)) {
                     entity.getPersistentData().putDouble("wait_spark_lim", 10.0);
                  } else {
                     entity.getPersistentData().putDouble("wait_spark_lim", entity.getPersistentData().getDouble("wait_spark_lim") - 1.0);
                  }
               }
            }

            for (Entity entityiteratorx : new ArrayList(world.players())) {
               if (Math.abs(entity.getX() - entityiteratorx.getX()) < 300.0
                  && Math.abs(entity.getY() - entityiteratorx.getY()) < 300.0
                  && Math.abs(entity.getZ() - entityiteratorx.getZ()) < 300.0) {
                  double _setval = 5.0;
                  entityiteratorx.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.laser_emitter_near = _setval;
                     capability.syncPlayerVariables(entityiterator);
                  });
               }
            }

            if (diaboloslock != null
               && (entity instanceof SlowLookTestEntity _datEntIxx ? (Integer)_datEntIxx.getEntityData().get(SlowLookTestEntity.DATA_lifespan) : 0) > 100
               && (entity instanceof SlowLookTestEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SlowLookTestEntity.DATA_lifespan) : 0) < 260) {
               xfind = (double)entity.level()
                  .clip(
                     new ClipContext(
                        entity.getEyePosition(1.0F),
                        entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(200.0)),
                        Block.COLLIDER,
                        Fluid.NONE,
                        entity
                     )
                  )
                  .getBlockPos()
                  .getX();
               yfind = (double)entity.level()
                  .clip(
                     new ClipContext(
                        entity.getEyePosition(1.0F),
                        entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(200.0)),
                        Block.COLLIDER,
                        Fluid.NONE,
                        entity
                     )
                  )
                  .getBlockPos()
                  .getY();
               zfind = (double)entity.level()
                  .clip(
                     new ClipContext(
                        entity.getEyePosition(1.0F),
                        entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(200.0)),
                        Block.COLLIDER,
                        Fluid.NONE,
                        entity
                     )
                  )
                  .getBlockPos()
                  .getZ();
               spheresize = Math.sqrt(
                     (xfind - entity.getX()) * (xfind - entity.getX())
                        + (yfind - (entity.getY() + y_offset)) * (yfind - (entity.getY() + y_offset))
                        + (zfind - entity.getZ()) * (zfind - entity.getZ())
                  )
                  + 2.0;
               xfind = Math.sin(Math.toRadians((double)entity.getYRot()));
               yfind = Math.sin(Math.toRadians((double)entity.getXRot()));
               zfind = Math.cos(Math.toRadians((double)entity.getYRot()));
               distance = Math.sqrt(
                  (entity.getX() - diaboloslock.getX()) * (entity.getX() - diaboloslock.getX())
                     + (entity.getY() - (diaboloslock.getY() + y_offset)) * (entity.getY() - (diaboloslock.getY() + y_offset))
                     + (entity.getZ() - diaboloslock.getZ()) * (entity.getZ() - diaboloslock.getZ())
               );

               for (int index0 = 0; index0 < (int)Math.min(Math.round(spheresize / 4.0), 80L); index0++) {
                  expand -= 4.0;
                  if ((
                           entity instanceof SlowLookTestEntity _datEntIxxxx
                              ? (Integer)_datEntIxxxx.getEntityData().get(SlowLookTestEntity.DATA_laser_switch_time)
                              : 0
                        )
                        == 10
                     || (
                           entity instanceof SlowLookTestEntity _datEntIxxx
                              ? (Integer)_datEntIxxx.getEntityData().get(SlowLookTestEntity.DATA_laser_switch_time)
                              : 0
                        )
                        == 20) {
                     Vec3 _centerx = new Vec3(entity.getX() + xfind * expand, entity.getY() - yfind * (0.0 - expand), entity.getZ() - zfind * expand);

                     for (Entity entityiteratorxx : world.getEntitiesOfClass(Entity.class, new AABB(_centerx, _centerx).inflate(4.5), e -> true)
                        .stream()
                        .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                        .toList()) {
                        if (entityiteratorxx != initial_lock
                           && !(entityiteratorxx instanceof DiabolosDecimatorCloneEntity)
                           && entityiteratorxx instanceof LivingEntity
                           && !(entityiteratorxx instanceof ArmorStand)) {
                           entityiteratorxx.hurt(
                              new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC), initial_lock),
                              Math.max((entityiteratorxx instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 4.0F, 19.0F)
                           );
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL,
                                          new Vec3(entityiteratorxx.getX(), entityiteratorxx.getY(), entityiteratorxx.getZ()),
                                          Vec2.ZERO,
                                          _level,
                                          4,
                                          "",
                                          Component.literal(""),
                                          _level.getServer(),
                                          null
                                       )
                                       .withSuppressedOutput(),
                                    "particle arphex:white_glow_smoke ~ ~ ~ 0 0 0 0 1 true"
                                 );
                           }

                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL,
                                          new Vec3(entityiteratorxx.getX(), entityiteratorxx.getY(), entityiteratorxx.getZ()),
                                          Vec2.ZERO,
                                          _level,
                                          4,
                                          "",
                                          Component.literal(""),
                                          _level.getServer(),
                                          null
                                       )
                                       .withSuppressedOutput(),
                                    "particle arphex:heavy_smoke ~ ~ ~ 0.4 0.4 0.4 0 20 true"
                                 );
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
