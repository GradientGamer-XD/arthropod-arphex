package net.arphex.procedures;

import net.minecraft.world.entity.Entity;

public class SlingWebPlayerFinishesUsingItemProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putDouble("slingtime", 0.0);
      }
   }
}
