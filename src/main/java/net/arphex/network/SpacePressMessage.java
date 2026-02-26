package net.arphex.network;

import java.util.function.Supplier;
import net.arphex.ArphexMod;
import net.arphex.procedures.SpaceBarPressOnKeyPressedProcedure;
import net.arphex.procedures.SpacePressOnKeyReleasedProcedure;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent.Context;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class SpacePressMessage {
   int type;
   int pressedms;

   public SpacePressMessage(int type, int pressedms) {
      this.type = type;
      this.pressedms = pressedms;
   }

   public SpacePressMessage(FriendlyByteBuf buffer) {
      this.type = buffer.readInt();
      this.pressedms = buffer.readInt();
   }

   public static void buffer(SpacePressMessage message, FriendlyByteBuf buffer) {
      buffer.writeInt(message.type);
      buffer.writeInt(message.pressedms);
   }

   public static void handler(SpacePressMessage message, Supplier<Context> contextSupplier) {
      Context context = contextSupplier.get();
      context.enqueueWork(() -> pressAction(context.getSender(), message.type, message.pressedms));
      context.setPacketHandled(true);
   }

   public static void pressAction(Player entity, int type, int pressedms) {
      Level world = entity.level();
      double x = entity.getX();
      double y = entity.getY();
      double z = entity.getZ();
      if (world.hasChunkAt(entity.blockPosition())) {
         if (type == 0) {
            SpaceBarPressOnKeyPressedProcedure.execute(entity);
         }

         if (type == 1) {
            SpacePressOnKeyReleasedProcedure.execute(entity);
         }
      }
   }

   @SubscribeEvent
   public static void registerMessage(FMLCommonSetupEvent event) {
      ArphexMod.addNetworkMessage(SpacePressMessage.class, SpacePressMessage::buffer, SpacePressMessage::new, SpacePressMessage::handler);
   }
}
