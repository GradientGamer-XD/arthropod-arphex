package net.arphex.procedures;

import net.minecraft.world.entity.Entity;

public class OnGroundReturnProcedure {
   public static boolean execute(Entity entity) {
      return entity == null ? false : entity.onGround();
   }
}
