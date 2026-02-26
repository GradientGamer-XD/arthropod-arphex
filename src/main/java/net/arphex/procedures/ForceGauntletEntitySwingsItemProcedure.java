package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;

public class ForceGauntletEntitySwingsItemProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (!(new Object() {
                  public boolean checkGamemode(Entity _ent) {
                     if (_ent instanceof ServerPlayer _serverPlayer) {
                        return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
                     } else {
                        return _ent.level().isClientSide() && _ent instanceof Player _player
                           ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                              && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR
                           : false;
                     }
                  }
               })
               .checkGamemode(entity)
            && entity instanceof Player player
            && player.containerMenu == player.inventoryMenu) {
            ArphexMod.queueServerWork(1, () -> {
               if (!entity.getPersistentData().getBoolean("usinggauntlet")) {
                  entity.getPersistentData().putBoolean("firegauntlet", true);
               }
            });
         }
      }
   }
}
