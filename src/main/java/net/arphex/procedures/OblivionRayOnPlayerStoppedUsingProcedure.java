package net.arphex.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class OblivionRayOnPlayerStoppedUsingProcedure {
   public static void execute(Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if ((!(entity instanceof Player _plrCldCheck1) || !_plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem())) && entity instanceof Player _player
            )
          {
            _player.getCooldowns()
               .addCooldown(
                  itemstack.getItem(), Math.round((float)((entity instanceof LivingEntity _entUseTicks2 ? _entUseTicks2.getTicksUsingItem() : 0) / 2))
               );
         }
      }
   }
}
