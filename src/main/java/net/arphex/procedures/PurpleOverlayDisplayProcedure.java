package net.arphex.procedures;

import net.arphex.network.ArphexModVariables;
import net.minecraft.world.entity.Entity;

public class PurpleOverlayDisplayProcedure {
   public static boolean execute(Entity entity) {
      return entity == null
         ? false
         : ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new ArphexModVariables.PlayerVariables()))
               .overlay_purple
            > 0.0;
   }
}
