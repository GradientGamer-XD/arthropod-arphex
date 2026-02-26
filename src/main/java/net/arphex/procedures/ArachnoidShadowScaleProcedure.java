package net.arphex.procedures;

import net.arphex.network.ArphexModVariables;
import net.minecraft.world.level.LevelAccessor;

public class ArachnoidShadowScaleProcedure {
   public static double execute(LevelAccessor world) {
      double clonesize = 0.0;
      String once = "";
      return Math.max(ArphexModVariables.MapVariables.get(world).clonesize, 7.5);
   }
}
