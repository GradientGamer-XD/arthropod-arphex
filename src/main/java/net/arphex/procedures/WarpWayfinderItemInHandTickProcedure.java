package net.arphex.procedures;

import net.arphex.network.ArphexModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class WarpWayfinderItemInHandTickProcedure {
   public static void execute(Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new ArphexModVariables.PlayerVariables()))
                  .track_warp_cooldown
               > 0.0
            && entity instanceof Player _player
            && !_player.level().isClientSide()) {
            _player.displayClientMessage(
               Component.literal(
                  "§dRemaining warp cooldown seconds: "
                     + Math.round(
                        ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                 .orElse(new ArphexModVariables.PlayerVariables()))
                              .track_warp_cooldown
                           / 20.0
                     )
               ),
               true
            );
         }

         if (entity.getPersistentData().getBoolean("creativespectator")) {
            double _setval = 0.0;
            entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
               capability.track_warp_cooldown = _setval;
               capability.syncPlayerVariables(entity);
            });
         }

         itemstack.getOrCreateTag().putBoolean("warp_wayfinder_check", true);
      }
   }
}
