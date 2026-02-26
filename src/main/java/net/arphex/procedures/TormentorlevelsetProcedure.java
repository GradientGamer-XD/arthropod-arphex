package net.arphex.procedures;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class TormentorlevelsetProcedure {
   public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
      try {
         for (Entity entityiterator : EntityArgument.getEntities(arguments, "player_name")) {
            double _setval = DoubleArgumentType.getDouble(arguments, "level");
            entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
               capability.killedtormentor = _setval;
               capability.syncPlayerVariables(entityiterator);
            });
            if (!world.isClientSide() && world.getServer() != null) {
               world.getServer()
                  .getPlayerList()
                  .broadcastSystemMessage(
                     Component.literal(
                        entityiterator.getDisplayName().getString() + "'s Tormentor kills set to " + DoubleArgumentType.getDouble(arguments, "level")
                     ),
                     false
                  );
            }
         }
      } catch (CommandSyntaxException var6) {
         var6.printStackTrace();
      }
   }
}
