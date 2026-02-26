package net.arphex.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class SupergravityEffectStartedappliedProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity instanceof Player && entity instanceof Player _player && !_player.level().isClientSide()) {
            _player.displayClientMessage(Component.literal("§cGravity is being manipulated to pull you down!"), true);
         }
      }
   }
}
