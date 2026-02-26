package net.arphex.client.screens;

import net.arphex.procedures.TormentorScare2DisplayOverlayIngameProcedure;
import net.arphex.procedures.TormentorScareProceed2Procedure;
import net.arphex.procedures.TormentorScareProceed3Procedure;
import net.arphex.procedures.TormentorScareProceedProcedure;
import net.arphex.procedures.TormentorScareShow2Procedure;
import net.arphex.procedures.TormentorScareShow3Procedure;
import net.arphex.procedures.TormentorScareShowProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiEvent.Pre;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber({Dist.CLIENT})
public class TormentorScareOverlay {
   @SubscribeEvent(
      priority = EventPriority.NORMAL
   )
   public static void eventHandler(Pre event) {
      int w = event.getWindow().getGuiScaledWidth();
      int h = event.getWindow().getGuiScaledHeight();
      Level world = null;
      double x = 0.0;
      double y = 0.0;
      double z = 0.0;
      Player entity = Minecraft.getInstance().player;
      if (entity != null) {
         world = entity.level();
         x = entity.getX();
         y = entity.getY();
         z = entity.getZ();
      }

      if (TormentorScare2DisplayOverlayIngameProcedure.execute(entity)) {
         if (TormentorScareProceedProcedure.execute(world, x, y, z) instanceof LivingEntity livingEntity && TormentorScareShowProcedure.execute(entity)) {
            InventoryScreen.renderEntityInInventoryFollowsAngle(event.getGuiGraphics(), w / 2 + 0, h - 0, 2, 0.0F, 0.0F, livingEntity);
         }

         if (TormentorScareProceed2Procedure.execute(world) instanceof LivingEntity livingEntity && TormentorScareShow2Procedure.execute(entity)) {
            InventoryScreen.renderEntityInInventoryFollowsAngle(event.getGuiGraphics(), w / 2 + 0, h - 0, 2, 0.0F, 0.0F, livingEntity);
         }

         if (TormentorScareProceed3Procedure.execute(world) instanceof LivingEntity livingEntity && TormentorScareShow3Procedure.execute(entity)) {
            InventoryScreen.renderEntityInInventoryFollowsAngle(event.getGuiGraphics(), w / 2 + 0, h - 0, 2, 0.0F, 0.0F, livingEntity);
         }
      }
   }
}
