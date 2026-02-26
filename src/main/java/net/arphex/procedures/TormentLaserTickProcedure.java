package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.TormentorLaserEntity;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class TormentLaserTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean foundnearest = false;
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
         double laser_move = 0.0;
         ArphexMod.queueServerWork(Mth.nextInt(RandomSource.create(), 600, 1200), () -> {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         });
         entity.getPersistentData().putBoolean("tormentor_summon", true);
         if (ArphexModVariables.MapVariables.get(world).tormentor_health <= 0.0) {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         } else if ((entity instanceof TormentorLaserEntity _datEntI ? (Integer)_datEntI.getEntityData().get(TormentorLaserEntity.DATA_growspawn) : 0) < 50) {
            if (entity instanceof TormentorLaserEntity _datEntSetI) {
               _datEntSetI.getEntityData()
                  .set(
                     TormentorLaserEntity.DATA_growspawn,
                     (entity instanceof TormentorLaserEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(TormentorLaserEntity.DATA_growspawn) : 0) + 1
                  );
            }
         } else {
            distance_level = 3.0;
            entity.teleportTo(
               ArphexModVariables.MapVariables.get(world).tormentor_x
                  + distance_level * Math.cos(0.0) * Math.sin((0.0 - ArphexModVariables.MapVariables.get(world).tormentor_rotation) * (Math.PI / 180.0)),
               ArphexModVariables.MapVariables.get(world).tormentor_y + 45.0,
               ArphexModVariables.MapVariables.get(world).tormentor_z
                  + distance_level * Math.cos(0.0) * Math.cos((0.0 - ArphexModVariables.MapVariables.get(world).tormentor_rotation) * (Math.PI / 180.0))
            );
            if (entity instanceof ServerPlayer _serverPlayer) {
               _serverPlayer.connection
                  .teleport(
                     ArphexModVariables.MapVariables.get(world).tormentor_x
                        + distance_level * Math.cos(0.0) * Math.sin((0.0 - ArphexModVariables.MapVariables.get(world).tormentor_rotation) * (Math.PI / 180.0)),
                     ArphexModVariables.MapVariables.get(world).tormentor_y + 45.0,
                     ArphexModVariables.MapVariables.get(world).tormentor_z
                        + distance_level * Math.cos(0.0) * Math.cos((0.0 - ArphexModVariables.MapVariables.get(world).tormentor_rotation) * (Math.PI / 180.0)),
                     entity.getYRot(),
                     entity.getXRot()
                  );
            }

            if ((entity instanceof TormentorLaserEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(TormentorLaserEntity.DATA_timer) : 0) <= 0) {
               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                           .withSuppressedOutput(),
                        "particle arphex:tormentor_smoke ~ ~ ~ 1 1 1 0.8 160 force"
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

               if (entity instanceof TormentorLaserEntity _datEntSetI) {
                  _datEntSetI.getEntityData().set(TormentorLaserEntity.DATA_timer, 80);
               }
            } else if (entity instanceof TormentorLaserEntity _datEntSetI) {
               _datEntSetI.getEntityData()
                  .set(
                     TormentorLaserEntity.DATA_timer,
                     (entity instanceof TormentorLaserEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(TormentorLaserEntity.DATA_timer) : 0) - 1
                  );
            }

            if ((entity instanceof TormentorLaserEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(TormentorLaserEntity.DATA_timer) : 0) > 50) {
               if (!(entity.getPersistentData().getDouble("looklim") > 0.0)) {
                  if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 1.0) {
                     entity.getPersistentData().putDouble("looklim", 5.0);
                  } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 2.0) {
                     entity.getPersistentData().putDouble("looklim", 4.0);
                  } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier > 2.0) {
                     entity.getPersistentData().putDouble("looklim", 3.0);
                  }
               } else {
                  entity.getPersistentData().putDouble("looklim", entity.getPersistentData().getDouble("looklim") - 1.0);
               }
            } else {
               entity.getPersistentData().putDouble("looklim", 0.0);
            }

            foundnearest = false;
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(250.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiterator instanceof TormentorLaserEntity
                  && entityiterator != entity
                  && Mth.nextInt(RandomSource.create(), 1, 10) == 5
                  && !entityiterator.level().isClientSide()) {
                  entityiterator.discard();
               }

               if (entityiterator.getPersistentData().getBoolean("tormentor_target")
                  && !(
                     ((ArphexModVariables.PlayerVariables)entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                              .orElse(new ArphexModVariables.PlayerVariables()))
                           .tormentor_respite
                        > 0.0
                  )
                  && !foundnearest) {
                  foundnearest = true;
                  if (entity.getPersistentData().getDouble("looklim") > 0.0) {
                     if (entity.getPersistentData().getDouble("looklim") == 3.0
                        && Math.atan2(entityiterator.getX() - entity.getX(), entityiterator.getZ() - entity.getZ()) * 57.5
                              - 0.0
                              + ArphexModVariables.MapVariables.get(world).tormentor_rotation
                           < 90.0
                        && Math.atan2(entityiterator.getX() - entity.getX(), entityiterator.getZ() - entity.getZ()) * 57.5
                              - 0.0
                              + ArphexModVariables.MapVariables.get(world).tormentor_rotation
                           > -90.0
                        && !entity.level().isClientSide()
                        && entity.getServer() != null) {
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
                              "execute as @s at @s anchored eyes positioned "
                                 + entity.getPersistentData().getDouble("laserlockx")
                                 + " "
                                 + entity.getPersistentData().getDouble("laserlocky")
                                 + " "
                                 + entity.getPersistentData().getDouble("laserlockz")
                                 + " rotated as @s positioned ^ ^ ^80 facing entity @s eyes facing ^ ^ ^-1 positioned as @s run tp @s ~ ~ ~ ~ ~"
                           );
                     }
                  } else {
                     entity.getPersistentData().putDouble("laserlockx", entityiterator.getX());
                     entity.getPersistentData().putDouble("laserlocky", entityiterator.getY());
                     entity.getPersistentData().putDouble("laserlockz", entityiterator.getZ());
                  }

                  if (entityiterator instanceof Player) {
                     double _setval = 10.0;
                     entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.laser_emitter_near = _setval;
                        capability.syncPlayerVariables(entityiterator);
                     });
                  }

                  pitch_distance_variance = 280.0;
                  yaw_distance_variance = 120.0;
                  distance_scaling_factor = 1.0;
                  y_offset = 1.0;
                  distance = Math.sqrt(
                     (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                        + (entity.getY() - (entityiterator.getY() + y_offset)) * (entity.getY() - (entityiterator.getY() + y_offset))
                        + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                  );
                  pitch_variance = pitch_distance_variance / (distance / 0.7);
                  yaw_variance = yaw_distance_variance / (distance / 2.0);
                  xfind = (double)entity.level()
                     .clip(
                        new ClipContext(
                           entity.getEyePosition(1.0F),
                           entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(300.0)),
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
                           entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(300.0)),
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
                           entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(300.0)),
                           Block.COLLIDER,
                           Fluid.NONE,
                           entity
                        )
                     )
                     .getBlockPos()
                     .getZ();
                  expand = Math.sqrt(
                     (entity.getX() - xfind) * (entity.getX() - xfind)
                        + (entity.getY() - (yfind + y_offset)) * (entity.getY() - (yfind + y_offset))
                        + (entity.getZ() - zfind) * (entity.getZ() - zfind)
                  );
                  if (world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(xfind, yfind, zfind), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "particle arphex:heavy_red_smoke ~ ~ ~ 3 3 3 0.4 25 force"
                        );
                  }

                  if (entity.getPersistentData().getDouble("looktoggle") == 20.0
                     && !world.isEmptyBlock(BlockPos.containing(xfind, yfind, zfind))
                     && world instanceof Level _level
                     && !_level.isClientSide()) {
                     _level.explode(null, xfind, yfind, zfind, 4.0F, ExplosionInteraction.MOB);
                  }

                  expand = Math.sqrt(
                        (xfind - entity.getX()) * (xfind - entity.getX())
                           + (yfind - (entity.getY() + y_offset)) * (yfind - (entity.getY() + y_offset))
                           + (zfind - entity.getZ()) * (zfind - entity.getZ())
                     )
                     + 2.0;
                  if (!(expand < distance)
                     && Math.round(yaw_variance)
                        >= Math.round(
                           Math.min(
                              Math.abs(
                                 (
                                          Math.toDegrees(Math.atan2(entity.getZ() - entityiterator.getZ(), entity.getX() - entityiterator.getX()))
                                             - (double)entity.getYRot()
                                             + 360.0
                                       )
                                       % 360.0
                                    - 270.0
                              ),
                              360.0
                                 - Math.abs(
                                    (
                                             Math.toDegrees(Math.atan2(entity.getZ() - entityiterator.getZ(), entity.getX() - entityiterator.getX()))
                                                - (double)entity.getYRot()
                                                + 360.0
                                          )
                                          % 360.0
                                       - 270.0
                                 )
                           )
                        )
                     && Math.round(pitch_variance)
                        >= Math.round(
                           Math.abs(
                              (double)entity.getXRot()
                                 - Math.toDegrees(
                                    Math.atan2(
                                       entity.getY() + y_offset - entityiterator.getY(),
                                       Math.sqrt(
                                          (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                                             + (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                                       )
                                    )
                                 )
                           )
                        )) {
                     if (entityiterator instanceof Player) {
                        double _setval = 5.0;
                        entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                           capability.overlay_white = _setval;
                           capability.syncPlayerVariables(entityiterator);
                        });
                     }

                     entityiterator.getPersistentData()
                        .putDouble(
                           "tormentburntime",
                           entityiterator.getPersistentData().getDouble("tormentburntime") + 2.0 * ArphexModVariables.MapVariables.get(world).tormentor_tier
                        );
                  }
               }
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 60, 0, false, false));
            }
         }
      }
   }
}
