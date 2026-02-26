package net.arphex.procedures;

import net.arphex.init.ArphexModItems;
import net.arphex.network.ArphexModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;

public class ReturnTorment2Procedure {
   public static boolean execute(Entity entity) {
      return entity == null
         ? false
         : ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new ArphexModVariables.PlayerVariables()))
                  .torment_intensity
               > 119.0
            && (!(entity instanceof Player _plrCldCheck0) || !_plrCldCheck0.getCooldowns().isOnCooldown((Item)ArphexModItems.PLACEHOLDER_PACK.get()));
   }
}
