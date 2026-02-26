package net.arphex.procedures;

import net.arphex.network.ArphexModVariables;
import net.minecraft.world.entity.Entity;

public class ImmortalImageReturnProcedure {
   public static boolean execute(Entity entity) {
      return entity == null
         ? false
         : ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new ArphexModVariables.PlayerVariables()))
               .inherent_power_cooldown
            > 10800.0;
   }
}
