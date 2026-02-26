package net.arphex.init;

import net.arphex.item.SingularityScytheItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import software.bernie.geckolib.animatable.GeoItem;

@EventBusSubscriber
public class ItemAnimationFactory {
   public static void disableUseAnim(String hand) {
      ItemInHandRenderer renderer = Minecraft.getInstance().gameRenderer.itemInHandRenderer;
      if (renderer != null) {
         if (hand.equals("right")) {
            renderer.mainHandHeight = 1.0F;
            renderer.oMainHandHeight = 1.0F;
         }

         if (hand.equals("left")) {
            renderer.offHandHeight = 1.0F;
            renderer.oOffHandHeight = 1.0F;
         }
      }
   }

   @SubscribeEvent
   public static void animatedItems(PlayerTickEvent event) {
      String animation = "";
      ItemStack mainhandItem = event.player.getMainHandItem().copy();
      ItemStack offhandItem = event.player.getOffhandItem().copy();
      if (event.phase == Phase.START && (mainhandItem.getItem() instanceof GeoItem || offhandItem.getItem() instanceof GeoItem)) {
         if (mainhandItem.getItem() instanceof SingularityScytheItem animatable) {
            animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((SingularityScytheItem)event.player.getMainHandItem().getItem()).animationprocedure = animation;
                  disableUseAnim("right");
               }
            }
         }

         if (offhandItem.getItem() instanceof SingularityScytheItem animatablex) {
            animation = offhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((SingularityScytheItem)event.player.getOffhandItem().getItem()).animationprocedure = animation;
                  disableUseAnim("left");
               }
            }
         }
      }
   }
}
