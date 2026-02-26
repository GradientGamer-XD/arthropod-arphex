package net.arphex.init;

import net.arphex.ArphexMod;
import net.arphex.network.PowerBindMessage;
import net.arphex.network.SpacePressMessage;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.TickEvent.ClientTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   bus = Bus.MOD,
   value = {Dist.CLIENT}
)
public class ArphexModKeyMappings {
   public static final KeyMapping SPACE_PRESS = new KeyMapping("key.arphex.space_press", 32, "key.categories.movement") {
      private boolean isDownOld = false;

      public void setDown(boolean isDown) {
         super.setDown(isDown);
         if (this.isDownOld != isDown && isDown) {
            ArphexMod.PACKET_HANDLER.sendToServer(new SpacePressMessage(0, 0));
            SpacePressMessage.pressAction(Minecraft.getInstance().player, 0, 0);
            ArphexModKeyMappings.SPACE_PRESS_LASTPRESS = System.currentTimeMillis();
         } else if (this.isDownOld != isDown && !isDown) {
            int dt = (int)(System.currentTimeMillis() - ArphexModKeyMappings.SPACE_PRESS_LASTPRESS);
            ArphexMod.PACKET_HANDLER.sendToServer(new SpacePressMessage(1, dt));
            SpacePressMessage.pressAction(Minecraft.getInstance().player, 1, dt);
         }

         this.isDownOld = isDown;
      }
   };
   public static final KeyMapping POWER_BIND = new KeyMapping("key.arphex.power_bind", 67, "key.categories.misc") {
      private boolean isDownOld = false;

      public void setDown(boolean isDown) {
         super.setDown(isDown);
         if (this.isDownOld != isDown && isDown) {
            ArphexMod.PACKET_HANDLER.sendToServer(new PowerBindMessage(0, 0));
            PowerBindMessage.pressAction(Minecraft.getInstance().player, 0, 0);
         }

         this.isDownOld = isDown;
      }
   };
   private static long SPACE_PRESS_LASTPRESS = 0L;

   @SubscribeEvent
   public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
      event.register(SPACE_PRESS);
      event.register(POWER_BIND);
   }

   @EventBusSubscriber({Dist.CLIENT})
   public static class KeyEventListener {
      @SubscribeEvent
      public static void onClientTick(ClientTickEvent event) {
         if (Minecraft.getInstance().screen == null) {
            ArphexModKeyMappings.SPACE_PRESS.consumeClick();
            ArphexModKeyMappings.POWER_BIND.consumeClick();
         }
      }
   }
}
