package net.arphex.procedures;

import net.arphex.network.ArphexModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.LevelAccessor;

public class ResetBossKillsProcedure {
   public static void execute(LevelAccessor world) {
      ArphexModVariables.MapVariables.get(world).bosskills = "";
      ArphexModVariables.MapVariables.get(world).syncData(world);
      ArphexModVariables.MapVariables.get(world).full_tormentor_has_previously_spawned = false;
      ArphexModVariables.MapVariables.get(world).syncData(world);
      if (!world.isClientSide() && world.getServer() != null) {
         world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Successfully reset all globally-registered ArPhEx boss kills"), false);
      }
   }
}
