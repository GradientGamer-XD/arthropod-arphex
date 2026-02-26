package net.arphex.procedures;

import net.arphex.network.ArphexModVariables;
import net.minecraft.world.entity.Entity;

public class SpacePressOnKeyReleasedProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         boolean _setval = false;
         entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
            capability.holdingspace = _setval;
            capability.syncPlayerVariables(entity);
         });
      }
   }
}
