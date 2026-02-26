package net.arphex.procedures;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class TormentorTierSetProcedure {
   public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
      if (entity != null) {
         if (DoubleArgumentType.getDouble(arguments, "tier") > 2.0) {
            if (entity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("§cThis tier is not available yet"), false);
            }
         } else {
            if (!world.isClientSide() && world.getServer() != null) {
               world.getServer()
                  .getPlayerList()
                  .broadcastSystemMessage(
                     Component.literal(
                        "Changed Tormentor tier from "
                           + Math.round(ArphexModVariables.MapVariables.get(world).tormentor_tier)
                           + " to "
                           + Math.round(DoubleArgumentType.getDouble(arguments, "tier"))
                           + " via command"
                     ),
                     false
                  );
            }

            ArphexModVariables.MapVariables.get(world).tormentor_tier = DoubleArgumentType.getDouble(arguments, "tier");
            ArphexModVariables.MapVariables.get(world).syncData(world);
         }
      }
   }
}
