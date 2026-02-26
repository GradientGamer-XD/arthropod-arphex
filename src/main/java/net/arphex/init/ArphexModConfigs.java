package net.arphex.init;

import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;

@EventBusSubscriber(
   modid = "arphex",
   bus = Bus.MOD
)
public class ArphexModConfigs {
   @SubscribeEvent
   public static void register(FMLConstructModEvent event) {
      event.enqueueWork(() -> ModLoadingContext.get().registerConfig(Type.COMMON, ConfigurationSettingsConfiguration.SPEC, "ArPhEx Configurations.toml"));
   }
}
