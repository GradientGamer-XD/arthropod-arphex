package net.arphex.network;

import java.util.HashMap;
import java.util.function.Supplier;
import net.arphex.ArphexMod;
import net.arphex.procedures.Coord1deleteProcedure;
import net.arphex.procedures.Coord1tpProcedure;
import net.arphex.procedures.Coord2deleteProcedure;
import net.arphex.procedures.Coord2tpProcedure;
import net.arphex.procedures.Coord3deleteProcedure;
import net.arphex.procedures.Coord3tpProcedure;
import net.arphex.world.inventory.WayfinderMenu;
import net.minecraft.core.BlockPos;
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
public class WayfinderButtonMessage {
   private final int buttonID;
   private final int x;
   private final int y;
   private final int z;

   public WayfinderButtonMessage(FriendlyByteBuf buffer) {
      this.buttonID = buffer.readInt();
      this.x = buffer.readInt();
      this.y = buffer.readInt();
      this.z = buffer.readInt();
   }

   public WayfinderButtonMessage(int buttonID, int x, int y, int z) {
      this.buttonID = buttonID;
      this.x = x;
      this.y = y;
      this.z = z;
   }

   public static void buffer(WayfinderButtonMessage message, FriendlyByteBuf buffer) {
      buffer.writeInt(message.buttonID);
      buffer.writeInt(message.x);
      buffer.writeInt(message.y);
      buffer.writeInt(message.z);
   }

   public static void handler(WayfinderButtonMessage message, Supplier<Context> contextSupplier) {
      Context context = contextSupplier.get();
      context.enqueueWork(() -> {
         Player entity = context.getSender();
         int buttonID = message.buttonID;
         int x = message.x;
         int y = message.y;
         int z = message.z;
         handleButtonAction(entity, buttonID, x, y, z);
      });
      context.setPacketHandled(true);
   }

   public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
      Level world = entity.level();
      HashMap guistate = WayfinderMenu.guistate;
      if (world.hasChunkAt(new BlockPos(x, y, z))) {
         if (buttonID == 0) {
            Coord1tpProcedure.execute(entity);
         }

         if (buttonID == 1) {
            Coord1deleteProcedure.execute(entity);
         }

         if (buttonID == 2) {
            Coord2tpProcedure.execute(entity);
         }

         if (buttonID == 3) {
            Coord2deleteProcedure.execute(entity);
         }

         if (buttonID == 4) {
            Coord3tpProcedure.execute(entity);
         }

         if (buttonID == 5) {
            Coord3deleteProcedure.execute(entity);
         }
      }
   }

   @SubscribeEvent
   public static void registerMessage(FMLCommonSetupEvent event) {
      ArphexMod.addNetworkMessage(WayfinderButtonMessage.class, WayfinderButtonMessage::buffer, WayfinderButtonMessage::new, WayfinderButtonMessage::handler);
   }
}
