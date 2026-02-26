package net.arphex.procedures;

import net.minecraft.world.entity.Entity;

public class ReturnNoSprintProcedure {
   public static boolean execute(Entity entity) {
      return entity == null ? false : !entity.isSprinting();
   }
}
