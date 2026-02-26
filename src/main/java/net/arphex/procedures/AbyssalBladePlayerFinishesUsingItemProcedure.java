package net.arphex.procedures;

import net.minecraft.world.entity.Entity;

public class AbyssalBladePlayerFinishesUsingItemProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putDouble("ringspin", 5.0);
      }
   }
}
