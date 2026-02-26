package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class VoidseekerProjectileTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         boolean tpup = false;
         double homing = 0.0;
         double source_distance = 0.0;
         immediatesourceentity.setNoGravity(true);
         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "particle arphex:heavy_purple_smoke ~ ~ ~ 0.3 0.3 0.3 0 5 force"
               );
         }

         ArphexMod.queueServerWork(230, () -> {
            if (entity.getPersistentData().getBoolean("sneakfire")) {
               ArphexMod.queueServerWork(40, () -> {
                  if (!immediatesourceentity.level().isClientSide()) {
                     immediatesourceentity.discard();
                  }
               });
            } else if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }
         });
         if (!(entity.getPersistentData().getDouble("distancetravelledvoid") > 0.0)) {
            entity.getPersistentData().putDouble("distancetravelledvoid", 1.0);
         } else {
            entity.getPersistentData().putDouble("distancetravelledvoid", entity.getPersistentData().getDouble("distancetravelledvoid") + 0.8);
         }

         if (entity.getPersistentData().getDouble("voidtrackingx") == 0.0 && !entity.getPersistentData().getBoolean("sneakfire")) {
            ArphexMod.queueServerWork(20, () -> {
               if (entity.getPersistentData().getDouble("voidtrackingx") == 0.0) {
                  immediatesourceentity.setDeltaMovement(new Vec3(0.0, -0.2, 0.0));
               }
            });
         } else {
            homing = Math.sqrt(
               Math.pow(entity.getPersistentData().getDouble("voidtrackingx") - immediatesourceentity.getX(), 2.0)
                  + Math.pow(entity.getPersistentData().getDouble("voidtrackingy") - immediatesourceentity.getY(), 2.0)
                  + Math.pow(entity.getPersistentData().getDouble("voidtrackingz") - immediatesourceentity.getZ(), 2.0)
            );
            if (entity.getPersistentData().getBoolean("sneakfire")) {
               immediatesourceentity.setDeltaMovement(
                  new Vec3(
                     (
                           (double)entity.level()
                                 .clip(
                                    new ClipContext(
                                       entity.getEyePosition(1.0F),
                                       entity.getEyePosition(1.0F)
                                          .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("distancetravelledvoid"))),
                                       Block.OUTLINE,
                                       Fluid.NONE,
                                       entity
                                    )
                                 )
                                 .getBlockPos()
                                 .getX()
                              - immediatesourceentity.getX()
                        )
                        / homing
                        * 2.0,
                     (
                           (double)entity.level()
                                 .clip(
                                    new ClipContext(
                                       entity.getEyePosition(1.0F),
                                       entity.getEyePosition(1.0F)
                                          .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("distancetravelledvoid"))),
                                       Block.OUTLINE,
                                       Fluid.NONE,
                                       entity
                                    )
                                 )
                                 .getBlockPos()
                                 .getY()
                              - immediatesourceentity.getY()
                        )
                        / homing
                        * 2.0,
                     (
                           (double)entity.level()
                                 .clip(
                                    new ClipContext(
                                       entity.getEyePosition(1.0F),
                                       entity.getEyePosition(1.0F)
                                          .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("distancetravelledvoid"))),
                                       Block.OUTLINE,
                                       Fluid.NONE,
                                       entity
                                    )
                                 )
                                 .getBlockPos()
                                 .getZ()
                              - immediatesourceentity.getZ()
                        )
                        / homing
                        * 2.0
                  )
               );
            } else {
               immediatesourceentity.setDeltaMovement(
                  new Vec3(
                     (entity.getPersistentData().getDouble("voidtrackingx") - immediatesourceentity.getX()) / homing * 0.85,
                     (entity.getPersistentData().getDouble("voidtrackingy") + 0.6 - immediatesourceentity.getY()) / homing * 0.85,
                     (entity.getPersistentData().getDouble("voidtrackingz") - immediatesourceentity.getZ()) / homing * 0.85
                  )
               );
            }
         }

         if (immediatesourceentity.getPersistentData().getBoolean("reverse_mirror_attack")) {
            immediatesourceentity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
         }
      }
   }
}
