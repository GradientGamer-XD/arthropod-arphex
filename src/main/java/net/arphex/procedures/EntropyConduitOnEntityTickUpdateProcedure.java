package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.DiabolosDecimatorEntity;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class EntropyConduitOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity nearabolos = null;
         double expand = 0.0;
         double lineZ = 0.0;
         double lineY = 0.0;
         double lineX = 0.0;
         double length = 0.0;
         entity.setNoGravity(true);
         nearabolos = world.getEntitiesOfClass(DiabolosDecimatorEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true)
            .stream()
            .sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z))
            .findFirst()
            .orElse(null);
         if (entity.isInWall()) {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         } else {
            if (world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                           CommandSource.NULL,
                           new Vec3(entity.getX(), entity.getY() + 6.0, entity.getZ()),
                           Vec2.ZERO,
                           _level,
                           4,
                           "",
                           Component.literal(""),
                           _level.getServer(),
                           null
                        )
                        .withSuppressedOutput(),
                     "particle arphex:heavy_red_smoke ~ ~ ~ 0 4 0 0 30 force"
                  );
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles(
                  (SimpleParticleType)ArphexModParticleTypes.HEAVY_GOLD_SMOKE.get(), entity.getX(), entity.getY() + 7.2, entity.getZ(), 5, 0.0, 0.0, 0.0, 0.0
               );
            }
         }

         if (nearabolos == null) {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         } else {
            if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
               == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))) {
               if (nearabolos.getY() < 60.0) {
                  if (!(entity.getY() < 60.0) && !entity.level().isClientSide()) {
                     entity.discard();
                  }
               } else if (nearabolos.getY() < 120.0) {
                  if ((!(entity.getY() > 60.0) || !(entity.getY() < 120.0)) && !entity.level().isClientSide()) {
                     entity.discard();
                  }
               } else if (nearabolos.getY() < 230.0) {
                  if ((!(entity.getY() > 120.0) || !(entity.getY() < 230.0)) && !entity.level().isClientSide()) {
                     entity.discard();
                  }
               } else if (nearabolos.getY() < 256.0) {
                  if ((!(entity.getY() > 230.0) || !(entity.getY() < 256.0)) && !entity.level().isClientSide()) {
                     entity.discard();
                  }
               } else if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            }

            if (entity.getY() < nearabolos.getY() - 16.0) {
               entity.setDeltaMovement(new Vec3(0.0, 0.4, 0.0));
            } else if (entity.getY() > nearabolos.getY() + 16.0) {
               entity.setDeltaMovement(new Vec3(0.0, -0.4, 0.0));
            } else {
               entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
            }

            if (entity.getPersistentData().getDouble("pylon_timer_heal") > 400.0) {
               if (entity.getPersistentData().getDouble("pylon_timer_heal") > 800.0 && !entity.level().isClientSide()) {
                  entity.discard();
               }

               lineX = nearabolos.getX() - entity.getX();
               lineY = nearabolos.getY() + 15.0 - (entity.getY() + 7.0);
               lineZ = nearabolos.getZ() - entity.getZ();
               expand = 0.0;
               length = Math.sqrt(Math.pow(lineX, 2.0) + Math.pow(lineY, 2.0) + Math.pow(lineZ, 2.0));
               if (length != 0.0) {
                  lineX /= length;
                  lineY /= length;
                  lineZ /= length;

                  for (int index0 = 0; index0 < 50; index0++) {
                     if (world instanceof ServerLevel _level) {
                        _level.getServer()
                           .getCommands()
                           .performPrefixedCommand(
                              new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(entity.getX() + lineX * expand, entity.getY() + 7.0 + lineY * expand, entity.getZ() + lineZ * expand),
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

                     expand += length / 50.0;
                  }

                  if (!(entity.getPersistentData().getDouble("heal_time_lim") > 0.0)) {
                     if ((nearabolos instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)
                           < (nearabolos instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F)
                        && nearabolos instanceof LivingEntity _entity) {
                        _entity.setHealth((nearabolos instanceof LivingEntity _livEntxx ? _livEntxx.getHealth() : -1.0F) + 1.0F);
                     }

                     entity.getPersistentData().putDouble("heal_time_lim", 20.0);
                  } else {
                     entity.getPersistentData().putDouble("heal_time_lim", entity.getPersistentData().getDouble("heal_time_lim") - 1.0);
                  }
               }
            }
         }

         entity.getPersistentData().putDouble("pylon_timer_heal", entity.getPersistentData().getDouble("pylon_timer_heal") + 1.0);
      }
   }
}
