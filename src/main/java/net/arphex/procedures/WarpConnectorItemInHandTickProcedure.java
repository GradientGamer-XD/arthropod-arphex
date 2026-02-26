package net.arphex.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class WarpConnectorItemInHandTickProcedure {
   public static void execute(Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if ((!(entity instanceof Player _plrCldCheck1) || !_plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem()))
            && itemstack.getOrCreateTag().getDouble("portal_lock_x") != 0.0
            && entity instanceof Player _player
            && !_player.level().isClientSide()) {
            _player.displayClientMessage(Component.literal("Teleporter Location Stored In Connector"), true);
         }
      }
   }
}
