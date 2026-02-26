package net.arphex.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class VitalityViewfinderEntitySwingsItemProcedure {
   public static void execute(Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (itemstack.getOrCreateTag().getDouble("lensmode") == 1.0) {
            itemstack.getOrCreateTag().putDouble("lensmode", 0.0);
         } else {
            itemstack.getOrCreateTag().putDouble("lensmode", 1.0);
            if (entity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("Lens mode toggle enabled - Now informs on damage/health when you attack mobs"), true);
            }
         }
      }
   }
}
