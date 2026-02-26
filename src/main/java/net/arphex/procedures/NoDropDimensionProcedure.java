package net.arphex.procedures;

import javax.annotation.Nullable;
import net.arphex.init.ArphexModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.items.ItemHandlerHelper;

@EventBusSubscriber
public class NoDropDimensionProcedure {
   @SubscribeEvent
   public static void onGemDropped(ItemTossEvent event) {
      execute(event, event.getPlayer(), event.getEntity().getItem());
   }

   public static void execute(Entity entity, ItemStack itemstack) {
      execute(null, entity, itemstack);
   }

   private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (entity instanceof Player
            && entity.isAlive()
            && itemstack.getItem() == ArphexModItems.CRAWLING_CONTAINER.get()
            && entity instanceof Player _plrCldCheck5
            && _plrCldCheck5.getCooldowns().isOnCooldown(itemstack.getItem())
            && !entity.getPersistentData().getBoolean("creativespectator")) {
            if (entity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("Cannot drop item while it is cooling down for safety"), true);
            }

            if (event != null && event.isCancelable()) {
               event.setCanceled(true);
            }

            if (entity instanceof Player _player) {
               ItemStack _setstack = new ItemStack((ItemLike)ArphexModItems.CRAWLING_CONTAINER.get()).copy();
               _setstack.setCount(1);
               ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
            }
         }
      }
   }
}
