package net.arphex.procedures;

import net.arphex.network.ArphexModVariables;
import net.minecraft.world.entity.Entity;

public class CompassVersionsProcedure {
   public static double execute(Entity entity) {
      if (entity == null) {
         return 0.0;
      } else {
         double auxnum = 0.0;
         return Math.floor(
            ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new ArphexModVariables.PlayerVariables()))
               .arphexcompass
         );
      }
   }
}
