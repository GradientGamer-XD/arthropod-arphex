package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ChronoCannonHeldProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         Entity winning_entity;
         winning_entity = null;
         double pitch_rise = 0.0;
         double final_lambda = 0.0;
         double distance = 0.0;
         double spheresize = 0.0;
         double pitch_distance_variance = 0.0;
         double pitch_variance = 0.0;
         double yaw_distance_variance = 0.0;
         double yfind = 0.0;
         double y_offset = 0.0;
         double yaw_variance = 0.0;
         double expand = 0.0;
         double zfind = 0.0;
         double distance_scaling_factor = 0.0;
         double limit_targets = 0.0;
         double xfind = 0.0;
         double store_yaw = 0.0;
         double yaw_prev = 0.0;
         double sx = 0.0;
         double sy = 0.0;
         double amp_limit = 0.0;
         double sz = 0.0;
         label135:
         if ((entity instanceof LivingEntity _entUseTicks0 ? _entUseTicks0.getTicksUsingItem() : 0) > 0) {
            if (entity instanceof Player _plrCldCheck2 && _plrCldCheck2.getCooldowns().isOnCooldown(itemstack.getItem())) {
               if ((entity instanceof LivingEntity _entUseItem3 ? _entUseItem3.getUseItem() : ItemStack.EMPTY).getItem() == ArphexModItems.CHRONO_CANNON.get()
                  && entity instanceof LivingEntity _entity) {
                  _entity.stopUsingItem();
               }
               break label135;
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5, 0, false, false));
            }

            if (entity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("§aRelease to fire, or switch to another hotbar slot to cancel"), true);
            }
         }

         if ((!(entity instanceof Player _plrCldCheck9) || !_plrCldCheck9.getCooldowns().isOnCooldown(itemstack.getItem()))
            && (entity instanceof LivingEntity _entUseTicks10 ? _entUseTicks10.getTicksUsingItem() : 0) > 0) {
            double _setval = 5.0;
            entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
               capability.sphere_near = _setval;
               capability.syncPlayerVariables(entity);
            });
            limit_targets = 5.0;
            entity.getPersistentData().putString("hornetlock_uuids", "");
            pitch_distance_variance = 270.0;
            yaw_distance_variance = 150.0;
            distance_scaling_factor = 1.0;
            y_offset = 1.0;
            store_yaw = 200.0;
            yaw_prev = 200.0;
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(125.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (limit_targets > 0.0 && entityiterator instanceof LivingEntity && !(entityiterator instanceof ArmorStand) && entityiterator != entity) {
                  if (entityiterator instanceof TamableAnimal) {
                     TamableAnimal _tamIsTamedBy = (TamableAnimal)entityiterator;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_tamIsTamedBy.isOwnedBy(_livEnt)) {
                           continue;
                        }
                     }
                  }

                  if (!entity.getPersistentData().getBoolean("creativespectator")) {
                     spheresize = 1.0;
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
                              entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                              Block.OUTLINE,
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
                              entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                              Block.OUTLINE,
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
                              entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                              Block.OUTLINE,
                              Fluid.NONE,
                              entity
                           )
                        )
                        .getBlockPos()
                        .getZ();
                     expand = Math.sqrt(
                           (xfind - entity.getX()) * (xfind - entity.getX())
                              + (yfind - (entity.getY() + y_offset)) * (yfind - (entity.getY() + y_offset))
                              + (zfind - entity.getZ()) * (zfind - entity.getZ())
                        )
                        + 2.0;
                     store_yaw = (double)Math.round(
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
                     );
                     if (!(expand < distance)
                        && (double)Math.round(yaw_variance) >= store_yaw
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
                        if (yaw_prev > store_yaw) {
                           winning_entity = entityiterator;
                        }

                        yaw_prev = store_yaw;
                     }
                  }
               }
            }
         }

         if (!(entity.getPersistentData().getDouble("cannon_cycle") > 0.0)) {
            if (winning_entity != null) {
               int var87;
               label104: {
                  if (winning_entity instanceof LivingEntity _livEnt && _livEnt.hasEffect((MobEffect)ArphexModMobEffects.TIME_FREEZE.get())) {
                     var87 = _livEnt.getEffect((MobEffect)ArphexModMobEffects.TIME_FREEZE.get()).getAmplifier();
                     break label104;
                  }

                  var87 = 0;
               }

               if (var87 < 20 && !winning_entity.level().isClientSide() && winning_entity.getServer() != null) {
                  CommandSourceStack var10001;
                  int var10002;
                  label98: {
                     var88 = winning_entity.getServer().getCommands();
                     var10001 = new CommandSourceStack(
                        CommandSource.NULL,
                        winning_entity.position(),
                        winning_entity.getRotationVector(),
                        winning_entity.level() instanceof ServerLevel ? (ServerLevel)winning_entity.level() : null,
                        4,
                        winning_entity.getName().getString(),
                        winning_entity.getDisplayName(),
                        winning_entity.level().getServer(),
                        winning_entity
                     );
                     if (winning_entity instanceof LivingEntity _livEnt && _livEnt.hasEffect((MobEffect)ArphexModMobEffects.TIME_FREEZE.get())) {
                        var10002 = _livEnt.getEffect((MobEffect)ArphexModMobEffects.TIME_FREEZE.get()).getAmplifier();
                        break label98;
                     }

                     var10002 = 0;
                  }

                  var88.performPrefixedCommand(var10001, "effect give @s arphex:time_freeze 2 " + Math.round((float)(var10002 + 1)));
               }
            }

            entity.getPersistentData().putDouble("cannon_cycle", 4.0);
         } else {
            entity.getPersistentData().putDouble("cannon_cycle", entity.getPersistentData().getDouble("cannon_cycle") - 1.0);
         }
      }
   }
}
