package net.arphex.procedures;

import net.arphex.network.ArphexModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

public class TormentorSummonerInventoryProcedure {
   public static void execute(Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (!itemstack.getOrCreateTag().getBoolean("initialfull")) {
            itemstack.getOrCreateTag().putBoolean("initialfull", true);
            double _setval = 1024.0;
            entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
               capability.tmshealth = _setval;
               capability.syncPlayerVariables(entity);
            });
         }

         if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new ArphexModVariables.PlayerVariables()))
               .tmshealth
            < 1024.0) {
            double _setval = ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new ArphexModVariables.PlayerVariables()))
                  .tmshealth
               + 0.05;
            entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
               capability.tmshealth = _setval;
               capability.syncPlayerVariables(entity);
            });
         }
      }
   }
}
