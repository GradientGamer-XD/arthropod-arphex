package net.arphex.procedures;

import java.util.ArrayList;
import net.arphex.network.ArphexModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class TORMENTORThisEntityKillsAnotherOneProcedure {
   public static void execute(LevelAccessor world) {
      for (Entity entityiterator : new ArrayList(world.players())) {
         boolean _setval = true;
         entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
            capability.show_tormentor_overlay = _setval;
            capability.syncPlayerVariables(entityiterator);
         });
      }
   }
}
