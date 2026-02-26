package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class GravitonTickProcedure {
   public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         Entity attack_target = null;
         double dist = 0.0;
         double source_distance = 0.0;
         if (immediatesourceentity.getPersistentData().getBoolean("aim_time")) {
            Entity var10 = entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null;
            if (var10 == null) {
               if (!immediatesourceentity.level().isClientSide()) {
                  immediatesourceentity.discard();
               }
            } else if (!immediatesourceentity.getPersistentData().getBoolean("limit_homing_time")) {
               dist = Math.sqrt(
                  (immediatesourceentity.getX() - var10.getX()) * (immediatesourceentity.getX() - var10.getX())
                     + (immediatesourceentity.getY() - var10.getY()) * (immediatesourceentity.getY() - var10.getY())
                     + (immediatesourceentity.getZ() - var10.getZ()) * (immediatesourceentity.getZ() - var10.getZ())
               );
               if ((entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)
                  < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 2.0F) {
                  immediatesourceentity.setDeltaMovement(
                     new Vec3(
                        (var10.getX() - immediatesourceentity.getX()) / dist * 0.9,
                        (var10.getY() - immediatesourceentity.getY()) / dist * 0.9,
                        (var10.getZ() - immediatesourceentity.getZ()) / dist * 0.9
                     )
                  );
               } else {
                  immediatesourceentity.setDeltaMovement(
                     new Vec3(
                        (var10.getX() - immediatesourceentity.getX()) / dist,
                        (var10.getY() - immediatesourceentity.getY()) / dist,
                        (var10.getZ() - immediatesourceentity.getZ()) / dist
                     )
                  );
               }
            }
         }

         if (immediatesourceentity.getPersistentData().getBoolean("reverse_mirror_attack")
            && !entity.getStringUUID().equals(immediatesourceentity.getPersistentData().getString("uuid_compare_source"))) {
            immediatesourceentity.getPersistentData().putBoolean("limit_homing_time", true);
            source_distance = Math.sqrt(
               (immediatesourceentity.getX() - entity.getX()) * (immediatesourceentity.getX() - entity.getX())
                  + (immediatesourceentity.getY() - entity.getY()) * (immediatesourceentity.getY() - entity.getY())
                  + (immediatesourceentity.getZ() - entity.getZ()) * (immediatesourceentity.getZ() - entity.getZ())
            );
            if (source_distance != 0.0) {
               immediatesourceentity.getPersistentData().putDouble("limit_homing_x", (entity.getX() - immediatesourceentity.getX()) / source_distance * 2.0);
               immediatesourceentity.getPersistentData().putDouble("limit_homing_y", (entity.getY() - immediatesourceentity.getY()) / source_distance * 2.0);
               immediatesourceentity.getPersistentData().putDouble("limit_homing_z", (entity.getZ() - immediatesourceentity.getZ()) / source_distance * 2.0);
               immediatesourceentity.setDeltaMovement(
                  new Vec3(
                     entity.getPersistentData().getDouble("limit_homing_x"),
                     entity.getPersistentData().getDouble("limit_homing_y"),
                     entity.getPersistentData().getDouble("limit_homing_z")
                  )
               );
            }
         }

         ArphexMod.queueServerWork(20, () -> immediatesourceentity.getPersistentData().putBoolean("aim_time", true));
         ArphexMod.queueServerWork(300, () -> {
            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }
         });
         immediatesourceentity.setNoGravity(true);
         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                        CommandSource.NULL,
                        new Vec3(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ()),
                        Vec2.ZERO,
                        _level,
                        4,
                        "",
                        Component.literal(""),
                        _level.getServer(),
                        null
                     )
                     .withSuppressedOutput(),
                  "particle arphex:heavy_smoke ~ ~ ~ 0 0 0 0 5 force"
               );
         }

         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                        CommandSource.NULL,
                        new Vec3(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ()),
                        Vec2.ZERO,
                        _level,
                        4,
                        "",
                        Component.literal(""),
                        _level.getServer(),
                        null
                     )
                     .withSuppressedOutput(),
                  "particle arphex:entropy_shield ~ ~ ~ 0 0 0 0 2 force"
               );
         }
      }
   }
}
