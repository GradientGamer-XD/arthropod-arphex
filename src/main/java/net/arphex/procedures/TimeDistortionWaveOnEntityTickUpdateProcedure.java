package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.TORMENTOREntity;
import net.arphex.entity.TormentBlastEntity;
import net.arphex.entity.TormentRifleEntity;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class TimeDistortionWaveOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double radius = 0.0;
         double step_size = 0.0;
         double yy = 0.0;
         double radius_at_height = 0.0;
         double angle = 0.0;
         double xoff = 0.0;
         double zoff = 0.0;
         double particle_number = 0.0;
         double expand = 0.0;
         double lineZ = 0.0;
         double lineY = 0.0;
         double lineX = 0.0;
         radius = 10.0 * ArphexModVariables.MapVariables.get(world).tormentor_tier;
         particle_number = 300.0;
         step_size = 2.0 * radius / particle_number;
         yy = 0.0 - radius;
         if (!(entity.getPersistentData().getDouble("angle_increment") >= 0.0)) {
            entity.getPersistentData().putDouble("angle_increment", 0.0);
         } else {
            entity.getPersistentData().putDouble("angle_increment", entity.getPersistentData().getDouble("angle_increment") + 1.0);
         }

         entity.teleportTo(
            entity.getPersistentData().getDouble("fix_x"), entity.getPersistentData().getDouble("fix_y"), entity.getPersistentData().getDouble("fix_z")
         );
         if (entity instanceof ServerPlayer _serverPlayer) {
            _serverPlayer.connection
               .teleport(
                  entity.getPersistentData().getDouble("fix_x"),
                  entity.getPersistentData().getDouble("fix_y"),
                  entity.getPersistentData().getDouble("fix_z"),
                  entity.getYRot(),
                  entity.getXRot()
               );
         }

         entity.getPersistentData().putDouble("despawn_timer", entity.getPersistentData().getDouble("despawn_timer") + 1.0);
         if (entity.getPersistentData().getDouble("despawn_timer") > 200.0 && !entity.level().isClientSide()) {
            entity.discard();
         }

         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get(), 100, 0, false, false));
         }

         if (!(entity.getPersistentData().getDouble("cannon_cycle") > 0.0)) {
            for (int index0 = 0; index0 < (int)particle_number; index0++) {
               if (yy < 15.0) {
                  yy += step_size;
                  radius_at_height = Math.sqrt(radius * radius - yy * yy);
                  angle = yy * entity.getPersistentData().getDouble("angle_increment");
                  if (world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL,
                                 new Vec3(
                                    entity.getX() + radius_at_height * Math.cos(angle), entity.getY() + yy, entity.getZ() + radius_at_height * Math.sin(angle)
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
                           "particle arphex:small_time ~ ~ ~ 0 0 0 0 1 force"
                        );
                  }
               }
            }

            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2.0 * radius / 2.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               ArphexMod.queueServerWork(
                  10,
                  () -> {
                     if (entity != entityiterator
                        && !entityiterator.getPersistentData().getBoolean("creativespectator")
                        && !(entityiterator instanceof TORMENTOREntity)
                        && !entityiterator.getPersistentData().getBoolean("tormentor_summon")) {
                        int var10000;
                        label50: {
                           if (entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect((MobEffect)ArphexModMobEffects.TIME_FREEZE.get())) {
                              var10000 = _livEnt.getEffect((MobEffect)ArphexModMobEffects.TIME_FREEZE.get()).getAmplifier();
                              break label50;
                           }

                           var10000 = 0;
                        }

                        if (var10000 < 20 && !entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                           CommandSourceStack var10001;
                           int var10002;
                           label41: {
                              var6 = entityiterator.getServer().getCommands();
                              var10001 = new CommandSourceStack(
                                 CommandSource.NULL,
                                 entityiterator.position(),
                                 entityiterator.getRotationVector(),
                                 entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null,
                                 4,
                                 entityiterator.getName().getString(),
                                 entityiterator.getDisplayName(),
                                 entityiterator.level().getServer(),
                                 entityiterator
                              );
                              if (entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect((MobEffect)ArphexModMobEffects.TIME_FREEZE.get())) {
                                 var10002 = _livEnt.getEffect((MobEffect)ArphexModMobEffects.TIME_FREEZE.get()).getAmplifier();
                                 break label41;
                              }

                              var10002 = 0;
                           }

                           var6.performPrefixedCommand(var10001, "effect give @s arphex:time_freeze 2 " + Math.round((float)(var10002 + 2)));
                        }
                     }

                     if ((entityiterator instanceof Projectile _projEnt ? _projEnt.getDeltaMovement().length() : 0.0) > 0.0
                        && !(entityiterator instanceof TormentBlastEntity)
                        && !(entityiterator instanceof TormentRifleEntity)) {
                        entityiterator.setDeltaMovement(new Vec3(0.0, -0.2, 0.0));
                     }
                  }
               );
            }

            lineX = entity.getX() - ArphexModVariables.MapVariables.get(world).tormentor_x;
            lineY = entity.getY() - ArphexModVariables.MapVariables.get(world).tormentor_y;
            lineZ = entity.getZ() - ArphexModVariables.MapVariables.get(world).tormentor_z;
            expand = expand;

            for (int index1 = 0; index1 < 20; index1++) {
               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL,
                              new Vec3(entity.getX() + lineX * expand, entity.getY() + lineY * expand, entity.getZ() + lineZ * expand),
                              Vec2.ZERO,
                              _level,
                              4,
                              "",
                              Component.literal(""),
                              _level.getServer(),
                              null
                           )
                           .withSuppressedOutput(),
                        "particle arphex:small_time ~ ~ ~ 0 0 0 0 1 force"
                     );
               }

               expand -= 0.05;
            }

            entity.getPersistentData().putDouble("cannon_cycle", 4.0);
         } else {
            entity.getPersistentData().putDouble("cannon_cycle", entity.getPersistentData().getDouble("cannon_cycle") - 1.0);
         }

         entity.setYRot(entity.getYRot() + 5.0F);
         entity.setXRot(0.0F);
         entity.setYBodyRot(entity.getYRot());
         entity.setYHeadRot(entity.getYRot());
         entity.yRotO = entity.getYRot();
         entity.xRotO = entity.getXRot();
         if (entity instanceof LivingEntity _entity) {
            _entity.yBodyRotO = _entity.getYRot();
            _entity.yHeadRotO = _entity.getYRot();
         }
      }
   }
}
