package net.arphex.procedures;

import net.arphex.network.ArphexModVariables;
import net.minecraft.world.entity.Entity;

public class ReturnLoadingText1Procedure {
   public static String execute(Entity entity) {
      if (entity == null) {
         return "";
      } else {
         return !(
               ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                     .inherent_power_cooldown
                  > 0.0
            )
            ? ""
            : "Power recharging: "
               + Math.round(
                  ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new ArphexModVariables.PlayerVariables()))
                        .inherent_power_cooldown
                     / 20.0
               )
               + "s";
      }
   }
}
