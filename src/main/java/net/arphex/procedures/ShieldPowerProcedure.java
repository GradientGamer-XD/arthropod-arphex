package net.arphex.procedures;

import net.arphex.network.ArphexModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class ShieldPowerProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
               .orElse(new ArphexModVariables.PlayerVariables()))
            .shield_power_unlocked) {
            if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new ArphexModVariables.PlayerVariables()))
                  .power_shield_cooldown
               > 0.0) {
               if (entity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("§cCannot use ability, it is still cooling down"), true);
               }
            } else {
               double _setval = 600.0;
               entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                  capability.power_shield_cooldown = _setval;
                  capability.syncPlayerVariables(entity);
               });
               entity.getPersistentData().putDouble("x_lock_shield", entity.getLookAngle().x);
               entity.getPersistentData().putDouble("y_lock_shield", entity.getLookAngle().y);
               entity.getPersistentData().putDouble("z_lock_shield", entity.getLookAngle().z);
               entity.getPersistentData().putDouble("xpos_lock_shield", entity.getX());
               entity.getPersistentData().putDouble("ypos_lock_shield", entity.getY());
               entity.getPersistentData().putDouble("zpos_lock_shield", entity.getZ());
            }

            if (entity instanceof Player _player) {
               _player.closeContainer();
            }
         } else if (entity instanceof Player _player && !_player.level().isClientSide()) {
            _player.displayClientMessage(Component.literal("§cCannot use ability - unlocks from celestial mirror item"), true);
         }
      }
   }
}
