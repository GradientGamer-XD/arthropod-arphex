package net.arphex.client.screens;

import net.arphex.procedures.ScorpioidScareDisplayProcedure;
import net.arphex.procedures.ScorpioidScareProceedProcedure;
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
public class ScorpioidScareOverlay {
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

      if (ScorpioidScareDisplayProcedure.execute(entity)
         && ScorpioidScareProceedProcedure.execute(world, x, y, z) instanceof LivingEntity livingEntity
         && ScorpioidScareDisplayProcedure.execute(entity)) {
         InventoryScreen.renderEntityInInventoryFollowsAngle(event.getGuiGraphics(), w / 2 + 0, h - 1, 100, 0.0F, 0.0F, livingEntity);
      }
   }
}
