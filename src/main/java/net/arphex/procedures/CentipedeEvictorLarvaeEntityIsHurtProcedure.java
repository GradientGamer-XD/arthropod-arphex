package net.arphex.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class CentipedeEvictorLarvaeEntityIsHurtProcedure {
   public static void execute(Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         if (entity.getPersistentData().getBoolean("stronger") && !entity.getPersistentData().getBoolean("warned") && sourceentity instanceof Player) {
            entity.getPersistentData().putBoolean("warned", true);
            if (entity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(
                  Component.literal("You feel an ominous shiver upon attacking this centipede. Killing it may bring about a worse nightmare."), true
               );
            }
         }
      }
   }
}
