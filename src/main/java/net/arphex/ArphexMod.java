package net.arphex;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import net.arphex.init.ArphexModBlockEntities;
import net.arphex.init.ArphexModBlocks;
import net.arphex.init.ArphexModEnchantments;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModFeatures;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMenus;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.init.ArphexModPotions;
import net.arphex.init.ArphexModSounds;
import net.arphex.init.ArphexModTabs;
import net.arphex.world.features.StructureFeature;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.TickEvent.ServerTickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.util.thread.SidedThreadGroups;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.NetworkEvent.Context;
import net.minecraftforge.network.simple.SimpleChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("arphex")
public class ArphexMod {
   public static final Logger LOGGER = LogManager.getLogger(ArphexMod.class);
   public static final String MODID = "arphex";
   private static final String PROTOCOL_VERSION = "1";
   public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(
      new ResourceLocation("arphex", "arphex"), () -> "1", "1"::equals, "1"::equals
   );
   private static int messageID = 0;
   private static final Collection<SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

   public ArphexMod() {
      MinecraftForge.EVENT_BUS.register(this);
      IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
      ArphexModSounds.REGISTRY.register(bus);
      ArphexModBlocks.REGISTRY.register(bus);
      ArphexModBlockEntities.REGISTRY.register(bus);
      ArphexModItems.REGISTRY.register(bus);
      ArphexModEntities.REGISTRY.register(bus);
      ArphexModEnchantments.REGISTRY.register(bus);
      ArphexModTabs.REGISTRY.register(bus);
      ArphexModFeatures.REGISTRY.register(bus);
      StructureFeature.REGISTRY.register(bus);
      ArphexModMobEffects.REGISTRY.register(bus);
      ArphexModPotions.REGISTRY.register(bus);
      ArphexModParticleTypes.REGISTRY.register(bus);
      ArphexModMenus.REGISTRY.register(bus);
   }

   public static <T> void addNetworkMessage(
      Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<Context>> messageConsumer
   ) {
      PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
      messageID++;
   }

   public static void queueServerWork(int tick, Runnable action) {
      if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER) {
         workQueue.add(new SimpleEntry<>(action, tick));
      }
   }

   @SubscribeEvent
   public void tick(ServerTickEvent event) {
      if (event.phase == Phase.END) {
         List<SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
         workQueue.forEach(work -> {
            work.setValue(work.getValue() - 1);
            if (work.getValue() == 0) {
               actions.add((SimpleEntry<Runnable, Integer>)work);
            }
         });
         actions.forEach(e -> e.getKey().run());
         workQueue.removeAll(actions);
      }
   }
}
