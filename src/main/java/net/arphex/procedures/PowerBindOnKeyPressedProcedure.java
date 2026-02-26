package net.arphex.procedures;

import net.arphex.network.ArphexModVariables;
import net.minecraft.world.entity.Entity;

public class PowerBindOnKeyPressedProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         boolean _setval = true;
         entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
            capability.power_press = _setval;
            capability.syncPlayerVariables(entity);
         });
      }
   }
}
