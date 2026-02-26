package net.arphex.procedures;

import net.minecraft.world.entity.Entity;

public class AbyssalBladeLivingEntityIsHitWithItemProcedure {
   public static void execute(Entity sourceentity) {
      if (sourceentity != null) {
         sourceentity.getPersistentData().putDouble("openhit", 10.0);
      }
   }
}
