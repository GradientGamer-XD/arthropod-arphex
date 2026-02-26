package net.arphex.procedures;

import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

public class SpacetimeHelmetTickEventProcedure {
   public static void execute(Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (entity.isShiftKeyDown()) {
            double _setval = 3.0;
            entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
               capability.sphere_near = _setval;
               capability.syncPlayerVariables(entity);
            });
         }

         itemstack.getOrCreateTag().putBoolean("Unbreakable", true);
         if (!entity.level().isClientSide() && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "item modify entity @s armor.head {\"function\":\"minecraft:set_components\",\"components\":{\"minecraft:unbreakable\":{\"show_in_tooltip\":true}}}"
               );
         }
      }
   }
}
