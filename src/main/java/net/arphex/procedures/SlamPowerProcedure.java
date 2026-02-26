package net.arphex.procedures;

import net.arphex.network.ArphexModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class SlamPowerProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
               .orElse(new ArphexModVariables.PlayerVariables()))
            .slam_power_unlocked) {
            if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new ArphexModVariables.PlayerVariables()))
                  .power_slam_cooldown
               > 0.0) {
               if (entity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("§cCannot use ability, it is still cooling down"), true);
               }
            } else {
               double _setval = 600.0;
               entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                  capability.power_slam_cooldown = _setval;
                  capability.syncPlayerVariables(entity);
               });
            }

            if (entity instanceof Player _player) {
               _player.closeContainer();
            }
         } else if (entity instanceof Player _player && !_player.level().isClientSide()) {
            _player.displayClientMessage(Component.literal("§cCannot use ability - unlocks from seismic pulse item"), true);
         }
      }
   }
}
