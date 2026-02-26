package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class WarpConnectorRightclickedProcedure {
   public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if ((!(entity instanceof Player _plrCldCheck1) || !_plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem())) && entity.isShiftKeyDown()) {
            ArphexMod.queueServerWork(1, () -> {
               if (entity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("Succesfully Reset Stored Coordinates"), true);
               }

               itemstack.getOrCreateTag().putDouble("portal_lock_x", 0.0);
               itemstack.getOrCreateTag().putDouble("portal_lock_y", 0.0);
               itemstack.getOrCreateTag().putDouble("portal_lock_z", 0.0);
               itemstack.getOrCreateTag().putString("portal_lock_dimension", "0");
            });
         }
      }
   }
}
