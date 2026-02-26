package net.arphex.procedures;

import net.minecraft.world.entity.Entity;

public class NotNamedProcedure {
   public static boolean execute(Entity entity) {
      return entity == null ? false : entity.getDisplayName().getString().equals("Venus Flytrap");
   }
}
