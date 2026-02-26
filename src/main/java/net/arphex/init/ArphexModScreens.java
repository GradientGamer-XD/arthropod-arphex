package net.arphex.init;

import net.arphex.client.gui.BackpackScreen;
import net.arphex.client.gui.InherentPowersScreen;
import net.arphex.client.gui.SuperBackpackScreen;
import net.arphex.client.gui.WayfinderScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(
   bus = Bus.MOD,
   value = {Dist.CLIENT}
)
public class ArphexModScreens {
   @SubscribeEvent
   public static void clientLoad(FMLClientSetupEvent event) {
      event.enqueueWork(() -> {
         MenuScreens.register((MenuType)ArphexModMenus.BACKPACK.get(), BackpackScreen::new);
         MenuScreens.register((MenuType)ArphexModMenus.SUPER_BACKPACK.get(), SuperBackpackScreen::new);
         MenuScreens.register((MenuType)ArphexModMenus.WAYFINDER.get(), WayfinderScreen::new);
         MenuScreens.register((MenuType)ArphexModMenus.INHERENT_POWERS.get(), InherentPowersScreen::new);
      });
   }
}
