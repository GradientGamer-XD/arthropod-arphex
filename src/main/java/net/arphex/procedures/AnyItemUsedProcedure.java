package net.arphex.procedures;

import javax.annotation.Nullable;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent.Start;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class AnyItemUsedProcedure {
   @SubscribeEvent
   public static void onUseItemStart(Start event) {
      if (event != null && event.getEntity() != null) {
         execute(event, event.getEntity(), event.getItem());
      }
   }

   public static void execute(Entity entity, ItemStack itemstack) {
      execute(null, entity, itemstack);
   }

   private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (itemstack.getItem() == Items.CHORUS_FRUIT
            && entity.level().dimension() == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))) {
            if (entity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("This item does not work in The Crawling"), true);
            }

            if (event != null && event.isCancelable()) {
               event.setCanceled(true);
            }
         }
      }
   }
}
