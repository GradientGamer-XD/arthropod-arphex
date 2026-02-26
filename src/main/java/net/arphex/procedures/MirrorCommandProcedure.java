package net.arphex.procedures;

import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class MirrorCommandProcedure {
   public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
      if (entity != null) {
         boolean foundplayers = false;
         foundplayers = false;

         try {
            for (Entity entityiterator : EntityArgument.getEntities(arguments, "players")) {
               foundplayers = true;
               if (BoolArgumentType.getBool(arguments, "enabled")) {
                  boolean _setval = true;
                  entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.shield_power_unlocked = _setval;
                     capability.syncPlayerVariables(entityiterator);
                  });
               } else {
                  boolean _setval = false;
                  entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.shield_power_unlocked = _setval;
                     capability.syncPlayerVariables(entityiterator);
                  });
               }
            }
         } catch (CommandSyntaxException var6) {
            var6.printStackTrace();
         }

         if (foundplayers) {
            if (BoolArgumentType.getBool(arguments, "enabled")) {
               if (entity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("§aMirror power enabled for selected players"), false);
               }
            } else if (entity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("§cMirror power disabled for selected players"), false);
            }
         }
      }
   }
}
