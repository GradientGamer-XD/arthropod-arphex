package net.arphex.procedures;

import net.arphex.init.ArphexModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class Coord2deleteProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.WARP_WAYFINDER.get()) {
            (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("target_2_x", 0.0);
            (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("target_2_y", 0.0);
            (entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("target_2_z", 0.0);
            (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY)
               .getOrCreateTag()
               .putString("target_2_dimension", "0");
            if (entity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("Successfully deleted waypoint 2"), true);
            }
         } else if ((entity instanceof LivingEntity _livEntx ? _livEntx.getOffhandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.WARP_WAYFINDER.get()) {
            (entity instanceof LivingEntity _livEntxx ? _livEntxx.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("target_2_x", 0.0);
            (entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("target_2_y", 0.0);
            (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("target_2_z", 0.0);
            (entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getOffhandItem() : ItemStack.EMPTY)
               .getOrCreateTag()
               .putString("target_2_dimension", "0");
            if (entity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("Successfully deleted waypoint 2"), true);
            }
         }
      }
   }
}
