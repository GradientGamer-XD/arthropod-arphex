package net.arphex.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class SpiderMothLarvaeThisEntityKillsAnotherOneProcedure {
   public static void execute(Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         if (entity instanceof Player && !sourceentity.level().isClientSide()) {
            sourceentity.discard();
         }
      }
   }
}
