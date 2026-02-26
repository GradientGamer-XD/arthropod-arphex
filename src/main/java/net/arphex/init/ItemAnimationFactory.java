package net.arphex.init;

import net.arphex.item.SingularityScytheItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import software.bernie.geckolib.animatable.GeoItem;

@EventBusSubscriber
public class ItemAnimationFactory {

    @SubscribeEvent
    public static void animatedItems(PlayerTickEvent event) {
        String animation = "";
        ItemStack mainhandItem = event.player.getMainHandItem().copy();
        ItemStack offhandItem = event.player.getOffhandItem().copy();

        if (event.phase == Phase.START && (mainhandItem.getItem() instanceof GeoItem || offhandItem.getItem() instanceof GeoItem)) {
            if (mainhandItem.getItem() instanceof SingularityScytheItem) {
                animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
                if (!animation.isEmpty()) {
                    event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
                    if (event.player.level().isClientSide()) {
                        ((SingularityScytheItem)event.player.getMainHandItem().getItem()).animationprocedure = animation;
                        ClientOnlyAnimationFix.disableUseAnim("right");
                    }
                }
            }

            if (offhandItem.getItem() instanceof SingularityScytheItem) {
                animation = offhandItem.getOrCreateTag().getString("geckoAnim");
                if (!animation.isEmpty()) {
                    event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
                    if (event.player.level().isClientSide()) {
                        ((SingularityScytheItem)event.player.getOffhandItem().getItem()).animationprocedure = animation;
                        ClientOnlyAnimationFix.disableUseAnim("left");
                    }
                }
            }
        }
    }

    // We put this in a Dist.CLIENT EventBusSubscriber so the Dedicated Server completely ignores it.
    // This prevents NoClassDefFoundError crashes on servers.
    @EventBusSubscriber(value = Dist.CLIENT)
    public static class ClientOnlyAnimationFix {
        public static void disableUseAnim(String hand) {
            // Safely grab the renderer using the 1.20.1 getter
            ItemInHandRenderer renderer = Minecraft.getInstance().getItemInHandRenderer();
            if (renderer != null) {
                try {
                    if (hand.equals("right")) {
                        // Use Forge's ObfuscationReflectionHelper to bypass private fields
                        ObfuscationReflectionHelper.setPrivateValue(ItemInHandRenderer.class, renderer, 1.0F, "f_109302_"); // mainHandHeight
                        ObfuscationReflectionHelper.setPrivateValue(ItemInHandRenderer.class, renderer, 1.0F, "f_109303_"); // oMainHandHeight
                    }
                    if (hand.equals("left")) {
                        ObfuscationReflectionHelper.setPrivateValue(ItemInHandRenderer.class, renderer, 1.0F, "f_109304_"); // offHandHeight
                        ObfuscationReflectionHelper.setPrivateValue(ItemInHandRenderer.class, renderer, 1.0F, "f_109305_"); // oOffHandHeight
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}