package net.arphex.procedures;

import net.arphex.network.ArphexModVariables;
import net.minecraft.world.level.LevelAccessor;

public class MothShadowCloneEntityVisualScaleProcedure {
   public static double execute(LevelAccessor world) {
      double clonesize = 0.0;
      String once = "";
      return ArphexModVariables.MapVariables.get(world).clonesize;
   }
}
