package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class EnormousSpiderHallucinationOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double pitch_variance = 0.0;
         double random_once = 0.0;
         double store_dist = 0.0;
         double distance_scaling_factor = 0.0;
         double yaw_variance = 0.0;
         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "execute at @e[type=arphex:enormous_spider_hallucination,limit=1,sort=nearest] run tp @e[type=arphex:enormous_spider_hallucination,limit=1,sort=nearest] ^ ^0.02 ^0.2"
               );
         }

         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "/data merge entity @e[type=arphex:enormous_spider_hallucination,sort=nearest,limit=1] {Invulnerable:1b}"
               );
         }

         entity.setDeltaMovement(
            new Vec3(
               Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.0,
               entity.getDeltaMovement().y(),
               Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.0
            )
         );
         if (world.isEmptyBlock(BlockPos.containing(x, y, z))) {
            entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), -0.4, entity.getDeltaMovement().z()));
         } else {
            entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), 0.4, entity.getDeltaMovement().z()));
         }

         if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).isEmpty()) {
            entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), -0.8, entity.getDeltaMovement().z()));
            ArphexMod.queueServerWork(80, () -> {
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            });
         }

         ArphexMod.queueServerWork(600, () -> entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), -0.8, entity.getDeltaMovement().z())));
         ArphexMod.queueServerWork(680, () -> {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         });
         entity.setCustomName(Component.literal(""));
      }
   }
}
