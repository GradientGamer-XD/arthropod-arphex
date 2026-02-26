package net.arphex.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import net.arphex.procedures.BrownTooltipProcedure;
import net.arphex.procedures.GoldTooltipProcedure;
import net.arphex.procedures.GreenTooltipProcedure;
import net.arphex.procedures.GreengoldTooltipProcedure;
import net.arphex.procedures.IridescentTooltipProcedure;
import net.arphex.procedures.PurpleTooltipProcedure;
import net.arphex.world.inventory.SuperBackpackMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class SuperBackpackScreen extends AbstractContainerScreen<SuperBackpackMenu> {
   private static final HashMap<String, Object> guistate = SuperBackpackMenu.guistate;
   private final Level world;
   private final int x;
   private final int y;
   private final int z;
   private final Player entity;
   private static final ResourceLocation texture = new ResourceLocation("arphex:textures/screens/super_backpack.png");

   public SuperBackpackScreen(SuperBackpackMenu container, Inventory inventory, Component text) {
      super(container, inventory, text);
      this.world = container.world;
      this.x = container.x;
      this.y = container.y;
      this.z = container.z;
      this.entity = container.entity;
      this.imageWidth = 400;
      this.imageHeight = 220;
   }

   public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
      this.renderBackground(guiGraphics);
      super.render(guiGraphics, mouseX, mouseY, partialTicks);
      this.renderTooltip(guiGraphics, mouseX, mouseY);
      if (mouseX > this.leftPos + 298 && mouseX < this.leftPos + 322 && mouseY > this.topPos + 127 && mouseY < this.topPos + 151) {
         guiGraphics.renderTooltip(this.font, Component.translatable("gui.arphex.super_backpack.tooltip_mantle_of_vitality"), mouseX, mouseY);
      }

      if (GoldTooltipProcedure.execute(this.entity)
         && mouseX > this.leftPos + 5
         && mouseX < this.leftPos + 29
         && mouseY > this.topPos + 125
         && mouseY < this.topPos + 149) {
         guiGraphics.renderTooltip(this.font, Component.translatable("gui.arphex.super_backpack.tooltip_gold"), mouseX, mouseY);
      }

      if (PurpleTooltipProcedure.execute(this.entity)
         && mouseX > this.leftPos + 29
         && mouseX < this.leftPos + 53
         && mouseY > this.topPos + 125
         && mouseY < this.topPos + 149) {
         guiGraphics.renderTooltip(this.font, Component.translatable("gui.arphex.super_backpack.tooltip_purple"), mouseX, mouseY);
      }

      if (IridescentTooltipProcedure.execute(this.entity)
         && mouseX > this.leftPos + 53
         && mouseX < this.leftPos + 77
         && mouseY > this.topPos + 125
         && mouseY < this.topPos + 149) {
         guiGraphics.renderTooltip(this.font, Component.translatable("gui.arphex.super_backpack.tooltip_iridescent"), mouseX, mouseY);
      }

      if (GreengoldTooltipProcedure.execute(this.entity)
         && mouseX > this.leftPos + 5
         && mouseX < this.leftPos + 29
         && mouseY > this.topPos + 149
         && mouseY < this.topPos + 173) {
         guiGraphics.renderTooltip(this.font, Component.translatable("gui.arphex.super_backpack.tooltip_greengold"), mouseX, mouseY);
      }

      if (GreenTooltipProcedure.execute(this.entity)
         && mouseX > this.leftPos + 29
         && mouseX < this.leftPos + 53
         && mouseY > this.topPos + 149
         && mouseY < this.topPos + 173) {
         guiGraphics.renderTooltip(this.font, Component.translatable("gui.arphex.super_backpack.tooltip_green"), mouseX, mouseY);
      }

      if (BrownTooltipProcedure.execute(this.entity)
         && mouseX > this.leftPos + 53
         && mouseX < this.leftPos + 77
         && mouseY > this.topPos + 149
         && mouseY < this.topPos + 173) {
         guiGraphics.renderTooltip(this.font, Component.translatable("gui.arphex.super_backpack.tooltip_brown"), mouseX, mouseY);
      }

      if (mouseX > this.leftPos + 333 && mouseX < this.leftPos + 357 && mouseY > this.topPos + 125 && mouseY < this.topPos + 149) {
         guiGraphics.renderTooltip(this.font, Component.translatable("gui.arphex.super_backpack.tooltip_bane_of_the_darkness"), mouseX, mouseY);
      }

      if (mouseX > this.leftPos + 366 && mouseX < this.leftPos + 390 && mouseY > this.topPos + 126 && mouseY < this.topPos + 150) {
         guiGraphics.renderTooltip(this.font, Component.translatable("gui.arphex.super_backpack.tooltip_vitality_viewfinder"), mouseX, mouseY);
      }
   }

   protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      RenderSystem.enableBlend();
      RenderSystem.defaultBlendFunc();
      guiGraphics.blit(texture, this.leftPos, this.topPos, 0.0F, 0.0F, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
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
      guiGraphics.drawString(this.font, Component.translatable("gui.arphex.super_backpack.label_prowler_pack"), 13, 8, -10066177, false);
      guiGraphics.drawString(this.font, Component.translatable("gui.arphex.super_backpack.label_sealed_scarabs"), 9, 115, -12829636, false);
      guiGraphics.drawString(this.font, Component.translatable("gui.arphex.super_backpack.label_vitality_boosts"), 305, 115, -12829636, false);
   }

   public void init() {
      super.init();
   }
}
