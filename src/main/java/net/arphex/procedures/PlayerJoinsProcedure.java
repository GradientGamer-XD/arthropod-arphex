package net.arphex.procedures;

import javax.annotation.Nullable;
import net.arphex.network.ArphexModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class PlayerJoinsProcedure {
   @SubscribeEvent
   public static void onPlayerLoggedIn(PlayerLoggedInEvent event) {
      execute(event, event.getEntity().level(), event.getEntity());
   }

   public static void execute(LevelAccessor world, Entity entity) {
      execute(null, world, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (!((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
               .orElse(new ArphexModVariables.PlayerVariables()))
            .patreon_done) {
            if (ArphexModVariables.MapVariables.get(world).t3_patrons_list.contains("," + entity.getName().getString().toLowerCase() + ",")) {
               if (entity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(
                     Component.literal("§6TIER 3 Patreon perks found! Thanks for your incredible support, " + entity.getName().getString()), false
                  );
               }

               boolean _setval = true;
               entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                  capability.patreon_done = _setval;
                  capability.syncPlayerVariables(entity);
               });
            } else if (ArphexModVariables.MapVariables.get(world).t2_patrons_list.contains("," + entity.getName().getString().toLowerCase() + ",")) {
               if (entity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(
                     Component.literal("§dTIER 2 Patreon perks found! Thanks for your incredible support, " + entity.getName().getString()), false
                  );
               }

               boolean _setval = true;
               entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                  capability.patreon_done = _setval;
                  capability.syncPlayerVariables(entity);
               });
            } else if (ArphexModVariables.MapVariables.get(world).t1_patrons_list.contains("," + entity.getName().getString().toLowerCase() + ",")) {
               if (entity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(
                     Component.literal("§bTIER 1 Patreon perks found! Thanks for your incredible support, " + entity.getName().getString()), false
                  );
               }

               boolean _setval = true;
               entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                  capability.patreon_done = _setval;
                  capability.syncPlayerVariables(entity);
               });
            }
         }
      }
   }
}
