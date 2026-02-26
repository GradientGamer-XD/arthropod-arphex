package net.arphex.procedures;

import net.minecraft.world.entity.Entity;

public class ConstrictingUpwardsProcedure {
   public static boolean execute(Entity entity) {
      return entity == null ? false : !entity.isShiftKeyDown() && !entity.isSprinting();
   }
}
