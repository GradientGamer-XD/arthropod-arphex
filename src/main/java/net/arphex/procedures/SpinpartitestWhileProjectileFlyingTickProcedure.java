package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class SpinpartitestWhileProjectileFlyingTickProcedure {
   public static void execute(LevelAccessor world, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         ArphexMod.queueServerWork(400, () -> {
            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }
         });
         if (immediatesourceentity.getPersistentData().getDouble("deltalockx") == 0.0) {
            immediatesourceentity.getPersistentData().putDouble("deltalockx", immediatesourceentity.getDeltaMovement().x());
            immediatesourceentity.getPersistentData().putDouble("deltalocky", immediatesourceentity.getDeltaMovement().y());
            immediatesourceentity.getPersistentData().putDouble("deltalockz", immediatesourceentity.getDeltaMovement().z());
         } else {
            immediatesourceentity.setDeltaMovement(
               new Vec3(
                  immediatesourceentity.getPersistentData().getDouble("deltalockx"),
                  immediatesourceentity.getPersistentData().getDouble("deltalocky"),
                  immediatesourceentity.getPersistentData().getDouble("deltalockz")
               )
            );
         }

         immediatesourceentity.setNoGravity(true);
         immediatesourceentity.lookAt(
            Anchor.EYES,
            new Vec3(
               immediatesourceentity.getPersistentData().getDouble("prevxlook"),
               immediatesourceentity.getPersistentData().getDouble("prevylook"),
               immediatesourceentity.getPersistentData().getDouble("prevzlook")
            )
         );
         immediatesourceentity.getPersistentData().putDouble("prevxlook", immediatesourceentity.getX());
         immediatesourceentity.getPersistentData().putDouble("prevylook", immediatesourceentity.getY());
         immediatesourceentity.getPersistentData().putDouble("prevzlook", immediatesourceentity.getZ());
         if (!(immediatesourceentity.getPersistentData().getDouble("parti_spin") > 0.0)) {
            immediatesourceentity.getPersistentData().putDouble("parti_spin", 16.0);
         } else {
            immediatesourceentity.getPersistentData().putDouble("parti_spin", immediatesourceentity.getPersistentData().getDouble("parti_spin") - 1.0);
         }

         if (immediatesourceentity.getPersistentData().getDouble("parti_spin") == 16.0) {
            if (!immediatesourceentity.level().isClientSide() && immediatesourceentity.getServer() != null) {
               immediatesourceentity.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                        CommandSource.NULL,
                        immediatesourceentity.position(),
                        immediatesourceentity.getRotationVector(),
                        immediatesourceentity.level() instanceof ServerLevel ? (ServerLevel)immediatesourceentity.level() : null,
                        4,
                        immediatesourceentity.getName().getString(),
                        immediatesourceentity.getDisplayName(),
                        immediatesourceentity.level().getServer(),
                        immediatesourceentity
                     ),
                     "execute at @s run particle arphex:white_particles ^1 ^ ^ 0 0 0 0 1 force"
                  );
            }
         } else if (immediatesourceentity.getPersistentData().getDouble("parti_spin") == 15.0) {
            if (!immediatesourceentity.level().isClientSide() && immediatesourceentity.getServer() != null) {
               immediatesourceentity.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                        CommandSource.NULL,
                        immediatesourceentity.position(),
                        immediatesourceentity.getRotationVector(),
                        immediatesourceentity.level() instanceof ServerLevel ? (ServerLevel)immediatesourceentity.level() : null,
                        4,
                        immediatesourceentity.getName().getString(),
                        immediatesourceentity.getDisplayName(),
                        immediatesourceentity.level().getServer(),
                        immediatesourceentity
                     ),
                     "execute at @s run particle arphex:white_particles ^0.92 ^0.38 ^ 0 0 0 0 1 force"
                  );
            }
         } else if (immediatesourceentity.getPersistentData().getDouble("parti_spin") == 14.0) {
            if (!immediatesourceentity.level().isClientSide() && immediatesourceentity.getServer() != null) {
               immediatesourceentity.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                        CommandSource.NULL,
                        immediatesourceentity.position(),
                        immediatesourceentity.getRotationVector(),
                        immediatesourceentity.level() instanceof ServerLevel ? (ServerLevel)immediatesourceentity.level() : null,
                        4,
                        immediatesourceentity.getName().getString(),
                        immediatesourceentity.getDisplayName(),
                        immediatesourceentity.level().getServer(),
                        immediatesourceentity
                     ),
                     "execute at @s run particle arphex:white_particles ^0.71 ^0.71 ^ 0 0 0 0 1 force"
                  );
            }
         } else if (immediatesourceentity.getPersistentData().getDouble("parti_spin") == 13.0) {
            if (!immediatesourceentity.level().isClientSide() && immediatesourceentity.getServer() != null) {
               immediatesourceentity.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                        CommandSource.NULL,
                        immediatesourceentity.position(),
                        immediatesourceentity.getRotationVector(),
                        immediatesourceentity.level() instanceof ServerLevel ? (ServerLevel)immediatesourceentity.level() : null,
                        4,
                        immediatesourceentity.getName().getString(),
                        immediatesourceentity.getDisplayName(),
                        immediatesourceentity.level().getServer(),
                        immediatesourceentity
                     ),
                     "execute at @s run particle arphex:white_particles ^0.38 ^0.92 ^ 0 0 0 0 1 force"
                  );
            }
         } else if (immediatesourceentity.getPersistentData().getDouble("parti_spin") == 12.0) {
            if (!immediatesourceentity.level().isClientSide() && immediatesourceentity.getServer() != null) {
               immediatesourceentity.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                        CommandSource.NULL,
                        immediatesourceentity.position(),
                        immediatesourceentity.getRotationVector(),
                        immediatesourceentity.level() instanceof ServerLevel ? (ServerLevel)immediatesourceentity.level() : null,
                        4,
                        immediatesourceentity.getName().getString(),
                        immediatesourceentity.getDisplayName(),
                        immediatesourceentity.level().getServer(),
                        immediatesourceentity
                     ),
                     "execute at @s run particle arphex:white_particles ^ ^1 ^ 0 0 0 0 1 force"
                  );
            }
         } else if (immediatesourceentity.getPersistentData().getDouble("parti_spin") == 11.0) {
            if (!immediatesourceentity.level().isClientSide() && immediatesourceentity.getServer() != null) {
               immediatesourceentity.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                        CommandSource.NULL,
                        immediatesourceentity.position(),
                        immediatesourceentity.getRotationVector(),
                        immediatesourceentity.level() instanceof ServerLevel ? (ServerLevel)immediatesourceentity.level() : null,
                        4,
                        immediatesourceentity.getName().getString(),
                        immediatesourceentity.getDisplayName(),
                        immediatesourceentity.level().getServer(),
                        immediatesourceentity
                     ),
                     "execute at @s run particle arphex:white_particles ^-0.38 ^0.92 ^ 0 0 0 0 1 force"
                  );
            }
         } else if (immediatesourceentity.getPersistentData().getDouble("parti_spin") == 10.0) {
            if (!immediatesourceentity.level().isClientSide() && immediatesourceentity.getServer() != null) {
               immediatesourceentity.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                        CommandSource.NULL,
                        immediatesourceentity.position(),
                        immediatesourceentity.getRotationVector(),
                        immediatesourceentity.level() instanceof ServerLevel ? (ServerLevel)immediatesourceentity.level() : null,
                        4,
                        immediatesourceentity.getName().getString(),
                        immediatesourceentity.getDisplayName(),
                        immediatesourceentity.level().getServer(),
                        immediatesourceentity
                     ),
                     "execute at @s run particle arphex:white_particles ^-0.71 ^0.71 ^ 0 0 0 0 1 force"
                  );
            }
         } else if (immediatesourceentity.getPersistentData().getDouble("parti_spin") == 9.0) {
            if (!immediatesourceentity.level().isClientSide() && immediatesourceentity.getServer() != null) {
               immediatesourceentity.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                        CommandSource.NULL,
                        immediatesourceentity.position(),
                        immediatesourceentity.getRotationVector(),
                        immediatesourceentity.level() instanceof ServerLevel ? (ServerLevel)immediatesourceentity.level() : null,
                        4,
                        immediatesourceentity.getName().getString(),
                        immediatesourceentity.getDisplayName(),
                        immediatesourceentity.level().getServer(),
                        immediatesourceentity
                     ),
                     "execute at @s run particle arphex:white_particles ^-0.92 ^0.38 ^ 0 0 0 0 1 force"
                  );
            }
         } else if (immediatesourceentity.getPersistentData().getDouble("parti_spin") == 8.0) {
            if (!immediatesourceentity.level().isClientSide() && immediatesourceentity.getServer() != null) {
               immediatesourceentity.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                        CommandSource.NULL,
                        immediatesourceentity.position(),
                        immediatesourceentity.getRotationVector(),
                        immediatesourceentity.level() instanceof ServerLevel ? (ServerLevel)immediatesourceentity.level() : null,
                        4,
                        immediatesourceentity.getName().getString(),
                        immediatesourceentity.getDisplayName(),
                        immediatesourceentity.level().getServer(),
                        immediatesourceentity
                     ),
                     "execute at @s run particle arphex:white_particles ^-1 ^ ^ 0 0 0 0 1 force"
                  );
            }
         } else if (immediatesourceentity.getPersistentData().getDouble("parti_spin") == 7.0) {
            if (!immediatesourceentity.level().isClientSide() && immediatesourceentity.getServer() != null) {
               immediatesourceentity.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                        CommandSource.NULL,
                        immediatesourceentity.position(),
                        immediatesourceentity.getRotationVector(),
                        immediatesourceentity.level() instanceof ServerLevel ? (ServerLevel)immediatesourceentity.level() : null,
                        4,
                        immediatesourceentity.getName().getString(),
                        immediatesourceentity.getDisplayName(),
                        immediatesourceentity.level().getServer(),
                        immediatesourceentity
                     ),
                     "execute at @s run particle arphex:white_particles ^-0.92 ^-0.38 ^ 0 0 0 0 1 force"
                  );
            }
         } else if (immediatesourceentity.getPersistentData().getDouble("parti_spin") == 6.0) {
            if (!immediatesourceentity.level().isClientSide() && immediatesourceentity.getServer() != null) {
               immediatesourceentity.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                        CommandSource.NULL,
                        immediatesourceentity.position(),
                        immediatesourceentity.getRotationVector(),
                        immediatesourceentity.level() instanceof ServerLevel ? (ServerLevel)immediatesourceentity.level() : null,
                        4,
                        immediatesourceentity.getName().getString(),
                        immediatesourceentity.getDisplayName(),
                        immediatesourceentity.level().getServer(),
                        immediatesourceentity
                     ),
                     "execute at @s run particle arphex:white_particles ^-0.71 ^-0.71 ^ 0 0 0 0 1 force"
                  );
            }
         } else if (immediatesourceentity.getPersistentData().getDouble("parti_spin") == 5.0) {
            if (!immediatesourceentity.level().isClientSide() && immediatesourceentity.getServer() != null) {
               immediatesourceentity.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                        CommandSource.NULL,
                        immediatesourceentity.position(),
                        immediatesourceentity.getRotationVector(),
                        immediatesourceentity.level() instanceof ServerLevel ? (ServerLevel)immediatesourceentity.level() : null,
                        4,
                        immediatesourceentity.getName().getString(),
                        immediatesourceentity.getDisplayName(),
                        immediatesourceentity.level().getServer(),
                        immediatesourceentity
                     ),
                     "execute at @s run particle arphex:white_particles ^-0.38 ^-0.92 ^ 0 0 0 0 1 force"
                  );
            }
         } else if (immediatesourceentity.getPersistentData().getDouble("parti_spin") == 4.0) {
            if (!immediatesourceentity.level().isClientSide() && immediatesourceentity.getServer() != null) {
               immediatesourceentity.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                        CommandSource.NULL,
                        immediatesourceentity.position(),
                        immediatesourceentity.getRotationVector(),
                        immediatesourceentity.level() instanceof ServerLevel ? (ServerLevel)immediatesourceentity.level() : null,
                        4,
                        immediatesourceentity.getName().getString(),
                        immediatesourceentity.getDisplayName(),
                        immediatesourceentity.level().getServer(),
                        immediatesourceentity
                     ),
                     "execute at @s run particle arphex:white_particles ^ ^-1 ^ 0 0 0 0 1 force"
                  );
            }
         } else if (immediatesourceentity.getPersistentData().getDouble("parti_spin") == 3.0) {
            if (!immediatesourceentity.level().isClientSide() && immediatesourceentity.getServer() != null) {
               immediatesourceentity.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                        CommandSource.NULL,
                        immediatesourceentity.position(),
                        immediatesourceentity.getRotationVector(),
                        immediatesourceentity.level() instanceof ServerLevel ? (ServerLevel)immediatesourceentity.level() : null,
                        4,
                        immediatesourceentity.getName().getString(),
                        immediatesourceentity.getDisplayName(),
                        immediatesourceentity.level().getServer(),
                        immediatesourceentity
                     ),
                     "execute at @s run particle arphex:white_particles ^0.38 ^-0.92 ^ 0 0 0 0 1 force"
                  );
            }
         } else if (immediatesourceentity.getPersistentData().getDouble("parti_spin") == 2.0) {
            if (!immediatesourceentity.level().isClientSide() && immediatesourceentity.getServer() != null) {
               immediatesourceentity.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                        CommandSource.NULL,
                        immediatesourceentity.position(),
                        immediatesourceentity.getRotationVector(),
                        immediatesourceentity.level() instanceof ServerLevel ? (ServerLevel)immediatesourceentity.level() : null,
                        4,
                        immediatesourceentity.getName().getString(),
                        immediatesourceentity.getDisplayName(),
                        immediatesourceentity.level().getServer(),
                        immediatesourceentity
                     ),
                     "execute at @s run particle arphex:white_particles ^0.71 ^-0.71 ^ 0 0 0 0 1 force"
                  );
            }
         } else if (immediatesourceentity.getPersistentData().getDouble("parti_spin") == 1.0
            && !immediatesourceentity.level().isClientSide()
            && immediatesourceentity.getServer() != null) {
            immediatesourceentity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     immediatesourceentity.position(),
                     immediatesourceentity.getRotationVector(),
                     immediatesourceentity.level() instanceof ServerLevel ? (ServerLevel)immediatesourceentity.level() : null,
                     4,
                     immediatesourceentity.getName().getString(),
                     immediatesourceentity.getDisplayName(),
                     immediatesourceentity.level().getServer(),
                     immediatesourceentity
                  ),
                  "execute at @s run particle arphex:white_particles ^0.92 ^-0.38 ^ 0 0 0 0 1 force"
               );
         }
      }
   }
}
