package net.arphex.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class TemporalTransmitterRightclickedProcedure {
   public static void execute(Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (entity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem())) {
            return;
         }

         if (itemstack.getOrCreateTag().getDouble("flatmodetemp") == 0.0) {
            itemstack.getOrCreateTag().putDouble("flatmodetemp", 1.0);
         } else {
            itemstack.getOrCreateTag().putDouble("flatmodetemp", 0.0);
         }

         if (entity instanceof Player _player) {
            _player.getCooldowns().addCooldown(itemstack.getItem(), 30);
         }
      }
   }
}
