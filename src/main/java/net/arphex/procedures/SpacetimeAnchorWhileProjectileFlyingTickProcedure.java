package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class SpacetimeAnchorWhileProjectileFlyingTickProcedure {
   public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         Entity attack_target = null;
         double dist = 0.0;
         double source_distance = 0.0;
         if (!immediatesourceentity.getPersistentData().getBoolean("aim_time")) {
            immediatesourceentity.getPersistentData().putBoolean("aim_time", true);
            immediatesourceentity.teleportTo(immediatesourceentity.getX(), immediatesourceentity.getY() + 3.0, immediatesourceentity.getZ());
            if (immediatesourceentity instanceof ServerPlayer _serverPlayer) {
               _serverPlayer.connection
                  .teleport(
                     immediatesourceentity.getX(),
                     immediatesourceentity.getY() + 3.0,
                     immediatesourceentity.getZ(),
                     immediatesourceentity.getYRot(),
                     immediatesourceentity.getXRot()
                  );
            }

            Entity var10 = entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null;
            if (var10 == null) {
               if (!immediatesourceentity.level().isClientSide()) {
                  immediatesourceentity.discard();
               }
            } else {
               dist = Math.sqrt(
                  (immediatesourceentity.getX() - var10.getX()) * (immediatesourceentity.getX() - var10.getX())
                     + (immediatesourceentity.getY() - (var10.getY() + 1.5)) * (immediatesourceentity.getY() - (var10.getY() + 1.5))
                     + (immediatesourceentity.getZ() - var10.getZ()) * (immediatesourceentity.getZ() - var10.getZ())
               );
            }

            if (dist != 0.0) {
               immediatesourceentity.setDeltaMovement(
                  new Vec3(
                     (var10.getX() - immediatesourceentity.getX()) / dist * 1.5,
                     (var10.getY() - immediatesourceentity.getY()) / dist * 1.5,
                     (var10.getZ() - immediatesourceentity.getZ()) / dist * 1.5
                  )
               );
            }

            immediatesourceentity.getPersistentData().putDouble("deltax_lock", immediatesourceentity.getDeltaMovement().x());
            immediatesourceentity.getPersistentData().putDouble("deltay_lock", immediatesourceentity.getDeltaMovement().y());
            immediatesourceentity.getPersistentData().putDouble("deltaz_lock", immediatesourceentity.getDeltaMovement().z());
         } else {
            immediatesourceentity.getPersistentData().putDouble("deltax_lock", immediatesourceentity.getPersistentData().getDouble("deltax_lock") * 1.05);
            immediatesourceentity.getPersistentData().putDouble("deltay_lock", immediatesourceentity.getPersistentData().getDouble("deltay_lock") * 1.05);
            immediatesourceentity.getPersistentData().putDouble("deltaz_lock", immediatesourceentity.getPersistentData().getDouble("deltaz_lock") * 1.05);
            immediatesourceentity.setDeltaMovement(
               new Vec3(
                  immediatesourceentity.getPersistentData().getDouble("deltax_lock"),
                  immediatesourceentity.getPersistentData().getDouble("deltay_lock"),
                  immediatesourceentity.getPersistentData().getDouble("deltaz_lock")
               )
            );
         }

         ArphexMod.queueServerWork(200, () -> {
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
                  "particle arphex:heavy_smoke ~ ~ ~ 0 0 0 0 2 force"
               );
         }

         if (immediatesourceentity.getPersistentData().getBoolean("reverse_mirror_attack")
            && !entity.getStringUUID().equals(immediatesourceentity.getPersistentData().getString("uuid_compare_source"))) {
            source_distance = Math.sqrt(
               (immediatesourceentity.getX() - entity.getX()) * (immediatesourceentity.getX() - entity.getX())
                  + (immediatesourceentity.getY() - entity.getY()) * (immediatesourceentity.getY() - entity.getY())
                  + (immediatesourceentity.getZ() - entity.getZ()) * (immediatesourceentity.getZ() - entity.getZ())
            );
            if (source_distance != 0.0) {
               immediatesourceentity.getPersistentData().putDouble("deltax_lock", (entity.getX() - immediatesourceentity.getX()) / source_distance * 2.0);
               immediatesourceentity.getPersistentData().putDouble("deltay_lock", (entity.getY() - immediatesourceentity.getY()) / source_distance * 2.0);
               immediatesourceentity.getPersistentData().putDouble("deltaz_lock", (entity.getZ() - immediatesourceentity.getZ()) / source_distance * 2.0);
            }
         }
      }
   }
}
