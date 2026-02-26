package net.arphex.procedures;

import net.arphex.init.ArphexModItems;
import net.arphex.network.ArphexModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class Coord3tpProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new ArphexModVariables.PlayerVariables()))
               .track_warp_cooldown
            > 0.0) {
            if (entity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("Cannot teleport while the item is cooling down"), true);
            }
         } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.WARP_WAYFINDER.get()) {
            entity.teleportTo(
               (entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("target_3_x") + 0.5,
               (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("target_3_y") + 1.0,
               (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("target_3_z") + 0.5
            );
            if (entity instanceof ServerPlayer _serverPlayer) {
               _serverPlayer.connection
                  .teleport(
                     (entity instanceof LivingEntity _livEntxxxxxx ? _livEntxxxxxx.getMainHandItem() : ItemStack.EMPTY)
                           .getOrCreateTag()
                           .getDouble("target_3_x")
                        + 0.5,
                     (entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("target_3_y")
                        + 1.0,
                     (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("target_3_z")
                        + 0.5,
                     entity.getYRot(),
                     entity.getXRot()
                  );
            }

            if (entity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("Successfully teleported to waypoint 3"), true);
            }

            double _setval = 12000.0;
            entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
               capability.track_warp_cooldown = _setval;
               capability.syncPlayerVariables(entity);
            });
            if (entity instanceof Player _player) {
               _player.getCooldowns().addCooldown((Item)ArphexModItems.WARP_WAYFINDER.get(), 20);
            }
         } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.WARP_WAYFINDER.get()) {
            entity.teleportTo(
               (entity instanceof LivingEntity _livEntxxxxxx ? _livEntxxxxxx.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("target_3_x") + 0.5,
               (entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("target_3_y") + 1.0,
               (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("target_3_z") + 0.5
            );
            if (entity instanceof ServerPlayer _serverPlayer) {
               _serverPlayer.connection
                  .teleport(
                     (entity instanceof LivingEntity _livEntxxxxxxxxx ? _livEntxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY)
                           .getOrCreateTag()
                           .getDouble("target_3_x")
                        + 0.5,
                     (entity instanceof LivingEntity _livEntxxxxxxxx ? _livEntxxxxxxxx.getOffhandItem() : ItemStack.EMPTY)
                           .getOrCreateTag()
                           .getDouble("target_3_y")
                        + 1.0,
                     (entity instanceof LivingEntity _livEntxxxxxxx ? _livEntxxxxxxx.getOffhandItem() : ItemStack.EMPTY)
                           .getOrCreateTag()
                           .getDouble("target_3_z")
                        + 0.5,
                     entity.getYRot(),
                     entity.getXRot()
                  );
            }

            if (entity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("Successfully teleported to waypoint 3"), true);
            }

            double _setval = 12000.0;
            entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
               capability.track_warp_cooldown = _setval;
               capability.syncPlayerVariables(entity);
            });
            if (entity instanceof Player _player) {
               _player.getCooldowns().addCooldown((Item)ArphexModItems.WARP_WAYFINDER.get(), 20);
            }
         }
      }
   }
}
