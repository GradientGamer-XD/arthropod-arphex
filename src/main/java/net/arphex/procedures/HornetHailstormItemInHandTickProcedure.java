package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.network.ArphexModVariables;
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

public class HornetHailstormItemInHandTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double pitch_variance = 0.0;
         double distance_scaling_factor = 0.0;
         double yaw_variance = 0.0;
         double limit_targets = 0.0;
         double expand = 0.0;
         double distance = 0.0;
         double zfind = 0.0;
         double spheresize = 0.0;
         double pitch_distance_variance = 0.0;
         double yaw_distance_variance = 0.0;
         double xfind = 0.0;
         double yfind = 0.0;
         double y_offset = 0.0;
         itemstack.getOrCreateTag().putBoolean("limit_checks_arphex", true);
         if ((!(entity instanceof Player _plrCldCheck3) || !_plrCldCheck3.getCooldowns().isOnCooldown(itemstack.getItem()))
            && (entity instanceof LivingEntity _entUseTicks4 ? _entUseTicks4.getTicksUsingItem() : 0) > 0) {
            double _setval = 5.0;
            entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
               capability.sphere_near = _setval;
               capability.syncPlayerVariables(entity);
            });
            limit_targets = 5.0;
            entity.getPersistentData().putString("hornetlock_uuids", "");
            pitch_distance_variance = 140.0;
            yaw_distance_variance = 140.0;
            distance_scaling_factor = 1.0;
            y_offset = 1.0;
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
                     entity.getPersistentData()
                        .putString("hornetlock_uuids", entity.getPersistentData().getString("hornetlock_uuids") + entityiterator.getStringUUID());
                     limit_targets--;
                  }
               }
            }
         }
      }
   }
}
