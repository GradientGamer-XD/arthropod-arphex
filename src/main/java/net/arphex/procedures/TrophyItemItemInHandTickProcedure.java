package net.arphex.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class TrophyItemItemInHandTickProcedure {
   public static void execute(Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (entity.getPersistentData().getBoolean("creativespectator")
            && itemstack.getOrCreateTag().getString("trophy_entity").length() <= 1
            && entity instanceof Player _player
            && !_player.level().isClientSide()) {
            _player.displayClientMessage(Component.literal("If in creative mode: Right click mob to lock trophy, or use /arphex give_trophy"), true);
         }
      }
   }
}
