package net.arphex.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import net.arphex.ArphexMod;
import net.arphex.network.InherentPowersButtonMessage;
import net.arphex.procedures.ReturnLoadingText1Procedure;
import net.arphex.procedures.ShieldCooldownTextProcedure;
import net.arphex.procedures.SlamCooldownTextProcedure;
import net.arphex.world.inventory.InherentPowersMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class InherentPowersScreen extends AbstractContainerScreen<InherentPowersMenu> {
   private static final HashMap<String, Object> guistate = InherentPowersMenu.guistate;
   private final Level world;
   private final int x;
   private final int y;
   private final int z;
   private final Player entity;
   Button button_immortal_image;
   Button button_coming_soon;
   Button button_coming_soon1;
   Button button_coming_soon2;
   Button button_coming_soon3;
   Button button_coming_soon4;

   public InherentPowersScreen(InherentPowersMenu container, Inventory inventory, Component text) {
      super(container, inventory, text);
      this.world = container.world;
      this.x = container.x;
      this.y = container.y;
      this.z = container.z;
      this.entity = container.entity;
      this.imageWidth = 176;
      this.imageHeight = 190;
   }

   public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
      this.renderBackground(guiGraphics);
      super.render(guiGraphics, mouseX, mouseY, partialTicks);
      this.renderTooltip(guiGraphics, mouseX, mouseY);
      if (mouseX > this.leftPos + 86 && mouseX < this.leftPos + 110 && mouseY > this.topPos + 153 && mouseY < this.topPos + 177) {
         guiGraphics.renderTooltip(this.font, Component.translatable("gui.arphex.inherent_powers.tooltip_immortal_image_power_gives_you_a"), mouseX, mouseY);
      }

      if (mouseX > this.leftPos + 70 && mouseX < this.leftPos + 94 && mouseY > this.topPos + 116 && mouseY < this.topPos + 140) {
         guiGraphics.renderTooltip(this.font, Component.translatable("gui.arphex.inherent_powers.tooltip_immortal_image_power_gives_you_a1"), mouseX, mouseY);
      }

      if (mouseX > this.leftPos + 68 && mouseX < this.leftPos + 92 && mouseY > this.topPos + 21 && mouseY < this.topPos + 45) {
         guiGraphics.renderTooltip(this.font, Component.translatable("gui.arphex.inherent_powers.tooltip_seismic_pulse_power_briefly_give"), mouseX, mouseY);
      }
   }

   protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      RenderSystem.enableBlend();
      RenderSystem.defaultBlendFunc();
      RenderSystem.disableBlend();
   }

   public boolean keyPressed(int key, int b, int c) {
      if (key == 256) {
         this.minecraft.player.closeContainer();
         return true;
      } else {
         return super.keyPressed(key, b, c);
      }
   }

   public void containerTick() {
      super.containerTick();
   }

   protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
      guiGraphics.drawString(this.font, Component.translatable("gui.arphex.inherent_powers.label_powers"), 69, 7, -1, false);
      guiGraphics.drawString(this.font, SlamCooldownTextProcedure.execute(this.entity), 96, 28, -52429, false);
      guiGraphics.drawString(this.font, Component.translatable("gui.arphex.inherent_powers.label_empty1"), 96, 52, -10053121, false);
      guiGraphics.drawString(this.font, Component.translatable("gui.arphex.inherent_powers.label_empty2"), 96, 76, -3394561, false);
      guiGraphics.drawString(this.font, Component.translatable("gui.arphex.inherent_powers.label_empty3"), 96, 99, -16724890, false);
      guiGraphics.drawString(this.font, ShieldCooldownTextProcedure.execute(this.entity), 96, 123, -3362816, false);
      guiGraphics.drawString(this.font, ReturnLoadingText1Procedure.execute(this.entity), 114, 161, -34439, false);
   }

   public void init() {
      super.init();
      this.button_immortal_image = Button.builder(Component.translatable("gui.arphex.inherent_powers.button_immortal_image"), e -> {
         ArphexMod.PACKET_HANDLER.sendToServer(new InherentPowersButtonMessage(0, this.x, this.y, this.z));
         InherentPowersButtonMessage.handleButtonAction(this.entity, 0, this.x, this.y, this.z);
      }).bounds(this.leftPos + 13, this.topPos + 156, 98, 20).build();
      guistate.put("button:button_immortal_image", this.button_immortal_image);
      this.addRenderableWidget(this.button_immortal_image);
      this.button_coming_soon = Button.builder(Component.translatable("gui.arphex.inherent_powers.button_coming_soon"), e -> {
         ArphexMod.PACKET_HANDLER.sendToServer(new InherentPowersButtonMessage(1, this.x, this.y, this.z));
         InherentPowersButtonMessage.handleButtonAction(this.entity, 1, this.x, this.y, this.z);
      }).bounds(this.leftPos + 11, this.topPos + 23, 82, 20).build();
      guistate.put("button:button_coming_soon", this.button_coming_soon);
      this.addRenderableWidget(this.button_coming_soon);
      this.button_coming_soon1 = Button.builder(Component.translatable("gui.arphex.inherent_powers.button_coming_soon1"), e -> {
      }).bounds(this.leftPos + 11, this.topPos + 47, 82, 20).build();
      guistate.put("button:button_coming_soon1", this.button_coming_soon1);
      this.addRenderableWidget(this.button_coming_soon1);
      this.button_coming_soon2 = Button.builder(Component.translatable("gui.arphex.inherent_powers.button_coming_soon2"), e -> {
      }).bounds(this.leftPos + 11, this.topPos + 71, 82, 20).build();
      guistate.put("button:button_coming_soon2", this.button_coming_soon2);
      this.addRenderableWidget(this.button_coming_soon2);
      this.button_coming_soon3 = Button.builder(Component.translatable("gui.arphex.inherent_powers.button_coming_soon3"), e -> {
      }).bounds(this.leftPos + 11, this.topPos + 95, 82, 20).build();
      guistate.put("button:button_coming_soon3", this.button_coming_soon3);
      this.addRenderableWidget(this.button_coming_soon3);
      this.button_coming_soon4 = Button.builder(Component.translatable("gui.arphex.inherent_powers.button_coming_soon4"), e -> {
         ArphexMod.PACKET_HANDLER.sendToServer(new InherentPowersButtonMessage(5, this.x, this.y, this.z));
         InherentPowersButtonMessage.handleButtonAction(this.entity, 5, this.x, this.y, this.z);
      }).bounds(this.leftPos + 11, this.topPos + 119, 82, 20).build();
      guistate.put("button:button_coming_soon4", this.button_coming_soon4);
      this.addRenderableWidget(this.button_coming_soon4);
   }
}
