package net.arphex.procedures;

import net.arphex.network.ArphexModVariables;
import net.minecraft.world.entity.Entity;

public class ShieldCooldownTextProcedure {
   public static String execute(Entity entity) {
      if (entity == null) {
         return "";
      } else if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
               .orElse(new ArphexModVariables.PlayerVariables()))
            .power_shield_cooldown
         < 1.0) {
         return "⚫⚫⚫⚫⚫⚫⚫⚫⚫⚫";
      } else if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
               .orElse(new ArphexModVariables.PlayerVariables()))
            .power_shield_cooldown
         < 60.0) {
         return "⚫⚫⚫⚫⚫⚫⚫⚫⚫⚪";
      } else if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
               .orElse(new ArphexModVariables.PlayerVariables()))
            .power_shield_cooldown
         < 120.0) {
         return "⚫⚫⚫⚫⚫⚫⚫⚫⚪⚪";
      } else if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
               .orElse(new ArphexModVariables.PlayerVariables()))
            .power_shield_cooldown
         < 180.0) {
         return "⚫⚫⚫⚫⚫⚫⚫⚪⚪⚪";
      } else if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
               .orElse(new ArphexModVariables.PlayerVariables()))
            .power_shield_cooldown
         < 240.0) {
         return "⚫⚫⚫⚫⚫⚫⚪⚪⚪⚪";
      } else if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
               .orElse(new ArphexModVariables.PlayerVariables()))
            .power_shield_cooldown
         < 300.0) {
         return "⚫⚫⚫⚫⚫⚪⚪⚪⚪⚪";
      } else if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
               .orElse(new ArphexModVariables.PlayerVariables()))
            .power_shield_cooldown
         < 360.0) {
         return "⚫⚫⚫⚫⚪⚪⚪⚪⚪⚪";
      } else if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
               .orElse(new ArphexModVariables.PlayerVariables()))
            .power_shield_cooldown
         < 420.0) {
         return "⚫⚫⚫⚪⚪⚪⚪⚪⚪⚪";
      } else if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
               .orElse(new ArphexModVariables.PlayerVariables()))
            .power_shield_cooldown
         < 480.0) {
         return "⚫⚫⚪⚪⚪⚪⚪⚪⚪⚪";
      } else {
         return ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new ArphexModVariables.PlayerVariables()))
                  .power_shield_cooldown
               < 540.0
            ? "⚫⚪⚪⚪⚪⚪⚪⚪⚪⚪"
            : "⚪⚪⚪⚪⚪⚪⚪⚪⚪⚪";
      }
   }
}
