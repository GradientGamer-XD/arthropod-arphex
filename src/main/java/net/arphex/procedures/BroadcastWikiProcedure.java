package net.arphex.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;

public class BroadcastWikiProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
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
                  "tellraw @a [\"\",{\"text\":\"Arthropod Phobia Expansions (ArPhEx) wiki link: \"},{\"text\":\"https://arphex.miraheze.org\",\"color\":\"red\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://arphex.miraheze.org\"},\"hoverEvent\":{\"action\":\"show_text\",\"contents\":\"Click to open link\"}}]"
               );
         }
      }
   }
}
