package net.arphex.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;

public class ChaosControlledEffectExpiresProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity instanceof Mob) {
            try {
               ((Mob)entity).setTarget(null);
            } catch (Exception var2) {
               var2.printStackTrace();
            }
         }
      }
   }
}
