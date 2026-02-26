package net.arphex.procedures;

import javax.annotation.Nullable;
import net.arphex.network.ArphexModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class DiesWithoutSourceProcedure {
   @SubscribeEvent
   public static void onPlayerRespawned(PlayerRespawnEvent event) {
      execute(event, event.getEntity());
   }

   public static void execute(Entity entity) {
      execute(null, entity);
   }

   private static void execute(@Nullable Event event, Entity entity) {
      if (entity != null) {
         double _setval = 0.0;
         entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
            capability.shadertime = _setval;
            capability.syncPlayerVariables(entity);
         });
         _setval = 1200.0;
         entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
            capability.tormentor_respite = _setval;
            capability.syncPlayerVariables(entity);
         });
      }
   }
}
