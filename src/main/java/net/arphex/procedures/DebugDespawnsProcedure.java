package net.arphex.procedures;

import net.arphex.network.ArphexModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class DebugDespawnsProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (entity instanceof Player _player && !_player.level().isClientSide()) {
            _player.displayClientMessage(
               Component.literal("Last recorded boss despawn reason: " + ArphexModVariables.MapVariables.get(world).last_despawn_reasons), false
            );
         }
      }
   }
}
