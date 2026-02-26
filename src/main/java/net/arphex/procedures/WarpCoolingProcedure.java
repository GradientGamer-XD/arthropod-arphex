package net.arphex.procedures;

import net.arphex.network.ArphexModVariables;
import net.minecraft.world.entity.Entity;

public class WarpCoolingProcedure {
   public static double execute(Entity entity) {
      return entity == null
         ? 0.0
         : ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
               .orElse(new ArphexModVariables.PlayerVariables()))
            .track_warp_cooldown;
   }
}
