package net.arphex.procedures;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.registries.ForgeRegistries;

public class DespawnCommandProcedure {
   public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
      if (entity != null) {
         double report_despawns = 0.0;
         report_despawns = 0.0;

         try {
            for (Entity entityiterator : EntityArgument.getEntities(arguments, "arphex_entities_to_despawn")) {
               if (ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString().startsWith("arphex:")) {
                  report_despawns++;
                  if (!entityiterator.level().isClientSide()) {
                     entityiterator.discard();
                  }
               }
            }
         } catch (CommandSyntaxException var6) {
            var6.printStackTrace();
         }

         if (report_despawns > 1.0) {
            if (entity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("Despawned " + Math.round(report_despawns) + " ArPhEx entities successfully"), false);
            }
         } else if (report_despawns > 0.0) {
            if (entity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("Despawned " + Math.round(report_despawns) + " ArPhEx entity successfully"), false);
            }
         } else if (entity instanceof Player _player && !_player.level().isClientSide()) {
            _player.displayClientMessage(Component.literal("§cNo ArPhEx entities found to despawn"), false);
         }
      }
   }
}
