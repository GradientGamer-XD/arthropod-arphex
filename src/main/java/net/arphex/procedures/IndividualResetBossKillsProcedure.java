package net.arphex.procedures;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class IndividualResetBossKillsProcedure {
   public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
      if (entity != null) {
         try {
            for (Entity entityiterator : EntityArgument.getEntities(arguments, "name")) {
               boolean _setval = false;
               entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                  capability.killedscorpioid = _setval;
                  capability.syncPlayerVariables(entity);
               });
               _setval = false;
               entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                  capability.killedvoidlasher = _setval;
                  capability.syncPlayerVariables(entity);
               });
               double _setvalx = 0.0;
               entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                  capability.mothsurvivals = _setval;
                  capability.syncPlayerVariables(entity);
               });
               if (!world.isClientSide() && world.getServer() != null) {
                  world.getServer()
                     .getPlayerList()
                     .broadcastSystemMessage(
                        Component.literal("Successfully reset registered non-Tormentor boss kills and moth wards for " + entity.getDisplayName().getString()),
                        false
                     );
               }
            }
         } catch (CommandSyntaxException var7) {
            var7.printStackTrace();
         }
      }
   }
}
