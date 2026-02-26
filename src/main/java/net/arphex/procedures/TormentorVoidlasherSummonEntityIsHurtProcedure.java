package net.arphex.procedures;

import net.arphex.network.ArphexModVariables;
import net.minecraft.world.entity.Entity;

public class TormentorVoidlasherSummonEntityIsHurtProcedure {
   public static void execute(Entity sourceentity) {
      if (sourceentity != null) {
         double _setval = 0.0;
         sourceentity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
            capability.tormentor_respite = _setval;
            capability.syncPlayerVariables(sourceentity);
         });
         sourceentity.getPersistentData().putBoolean("tormentor_target", true);
      }
   }
}
