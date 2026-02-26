package net.arphex.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ArphexModSounds {
   public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, "arphex");
   public static final RegistryObject<SoundEvent> MOTHSCARE = REGISTRY.register(
      "mothscare", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("arphex", "mothscare"))
   );
   public static final RegistryObject<SoundEvent> MOTHCHASE = REGISTRY.register(
      "mothchase", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("arphex", "mothchase"))
   );
   public static final RegistryObject<SoundEvent> MOTHCHASE2 = REGISTRY.register(
      "mothchase2", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("arphex", "mothchase2"))
   );
   public static final RegistryObject<SoundEvent> SPIDERMOTHAMBIENT = REGISTRY.register(
      "spidermothambient", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("arphex", "spidermothambient"))
   );
   public static final RegistryObject<SoundEvent> HEARTBEATS = REGISTRY.register(
      "heartbeats", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("arphex", "heartbeats"))
   );
   public static final RegistryObject<SoundEvent> TELEPORTERMOTH = REGISTRY.register(
      "teleportermoth", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("arphex", "teleportermoth"))
   );
   public static final RegistryObject<SoundEvent> MOTHSCREAM = REGISTRY.register(
      "mothscream", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("arphex", "mothscream"))
   );
   public static final RegistryObject<SoundEvent> MOTHSCREAM2 = REGISTRY.register(
      "mothscream2", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("arphex", "mothscream2"))
   );
   public static final RegistryObject<SoundEvent> HORRORCRASH = REGISTRY.register(
      "horrorcrash", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("arphex", "horrorcrash"))
   );
   public static final RegistryObject<SoundEvent> CREEPY_ARTHROPOD_TINY = REGISTRY.register(
      "creepy_arthropod_tiny", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("arphex", "creepy_arthropod_tiny"))
   );
   public static final RegistryObject<SoundEvent> CREEPY_ARTHROPOD = REGISTRY.register(
      "creepy_arthropod", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("arphex", "creepy_arthropod"))
   );
   public static final RegistryObject<SoundEvent> CREEPY_ARTHROPOD_LARGE = REGISTRY.register(
      "creepy_arthropod_large", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("arphex", "creepy_arthropod_large"))
   );
   public static final RegistryObject<SoundEvent> RHINOBEETLEFLY = REGISTRY.register(
      "rhinobeetlefly", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("arphex", "rhinobeetlefly"))
   );
   public static final RegistryObject<SoundEvent> FLYINGMOTH1 = REGISTRY.register(
      "flyingmoth1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("arphex", "flyingmoth1"))
   );
   public static final RegistryObject<SoundEvent> FLYINGMOTH2 = REGISTRY.register(
      "flyingmoth2", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("arphex", "flyingmoth2"))
   );
   public static final RegistryObject<SoundEvent> SPIDERMOTHCROAK = REGISTRY.register(
      "spidermothcroak", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("arphex", "spidermothcroak"))
   );
   public static final RegistryObject<SoundEvent> HORNETBUZZLONG = REGISTRY.register(
      "hornetbuzzlong", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("arphex", "hornetbuzzlong"))
   );
   public static final RegistryObject<SoundEvent> HORNETBUZZSHORT = REGISTRY.register(
      "hornetbuzzshort", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("arphex", "hornetbuzzshort"))
   );
   public static final RegistryObject<SoundEvent> SPIDERMOTHCROAK2 = REGISTRY.register(
      "spidermothcroak2", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("arphex", "spidermothcroak2"))
   );
   public static final RegistryObject<SoundEvent> SPIDERMOTHCROAK3 = REGISTRY.register(
      "spidermothcroak3", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("arphex", "spidermothcroak3"))
   );
   public static final RegistryObject<SoundEvent> SPIDERMOTHCROAK4 = REGISTRY.register(
      "spidermothcroak4", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("arphex", "spidermothcroak4"))
   );
   public static final RegistryObject<SoundEvent> SILENCE = REGISTRY.register(
      "silence", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("arphex", "silence"))
   );
   public static final RegistryObject<SoundEvent> GENESIS_SHOT = REGISTRY.register(
      "genesis_shot", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("arphex", "genesis_shot"))
   );
}
