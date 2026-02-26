package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.entity.ArachnoidTrisectorEntity;
import net.arphex.init.ArphexModItems;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class ChronoShotWhileProjectileFlyingTickProcedure {
   public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         Entity attack_target = null;
         double dist = 0.0;
         double source_distance = 0.0;
         if (entity instanceof ArachnoidTrisectorEntity) {
            if (immediatesourceentity.getPersistentData().getBoolean("aim_time")) {
               Entity var10 = entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null;
               if (var10 == null) {
                  if (!immediatesourceentity.level().isClientSide()) {
                     immediatesourceentity.discard();
                  }
               } else if (immediatesourceentity.getPersistentData().getBoolean("limit_homing_time")) {
                  if (entity.getPersistentData().getDouble("limit_homing_x") == 0.0 && entity.getPersistentData().getDouble("limit_homing_z") == 0.0) {
                     immediatesourceentity.getPersistentData().putDouble("limit_homing_x", entity.getDeltaMovement().x());
                     immediatesourceentity.getPersistentData().putDouble("limit_homing_y", entity.getDeltaMovement().y());
                     immediatesourceentity.getPersistentData().putDouble("limit_homing_z", entity.getDeltaMovement().z());
                  } else {
                     immediatesourceentity.setDeltaMovement(
                        new Vec3(
                           entity.getPersistentData().getDouble("limit_homing_x"),
                           entity.getPersistentData().getDouble("limit_homing_y"),
                           entity.getPersistentData().getDouble("limit_homing_z")
                        )
                     );
                  }
               } else {
                  dist = Math.sqrt(
                     (immediatesourceentity.getX() - var10.getX()) * (immediatesourceentity.getX() - var10.getX())
                        + (immediatesourceentity.getY() - var10.getY()) * (immediatesourceentity.getY() - var10.getY())
                        + (immediatesourceentity.getZ() - var10.getZ()) * (immediatesourceentity.getZ() - var10.getZ())
                  );
                  immediatesourceentity.setDeltaMovement(
                     new Vec3(
                        (var10.getX() - immediatesourceentity.getX()) / dist,
                        (var10.getY() - immediatesourceentity.getY()) / dist,
                        (var10.getZ() - immediatesourceentity.getZ()) / dist
                     )
                  );
               }
            }
         } else if (!immediatesourceentity.getPersistentData().getBoolean("chrono_lock")) {
            if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.CHRONO_CANNON.get()
               && (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.CHRONO_CANNON.get()) {
               immediatesourceentity.getPersistentData().putBoolean("chrono_boost", true);
            }

            immediatesourceentity.getPersistentData().putBoolean("chrono_lock", true);
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
         ArphexMod.queueServerWork(120, () -> immediatesourceentity.getPersistentData().putBoolean("limit_homing_time", true));
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
                  "particle arphex:heavy_green_smoke ~ ~ ~ 0 0 0 0 5 force"
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
                  "particle arphex:time_aura_particle ~ ~ ~ 0 0 0 0 2 force"
               );
         }
      }
   }
}
