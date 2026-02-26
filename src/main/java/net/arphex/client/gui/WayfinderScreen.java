package net.arphex.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import net.arphex.ArphexMod;
import net.arphex.network.WayfinderButtonMessage;
import net.arphex.procedures.Marker1tipProcedure;
import net.arphex.procedures.Marker2tipProcedure;
import net.arphex.procedures.Marker3tipProcedure;
import net.arphex.procedures.ReturnCoords1Procedure;
import net.arphex.procedures.ReturnCoords2Procedure;
import net.arphex.procedures.ReturnCoords3Procedure;
import net.arphex.procedures.Tel1dimensionmatchProcedure;
import net.arphex.procedures.Tel2dimensionmatchProcedure;
import net.arphex.procedures.Tel3dimensionmatchProcedure;
import net.arphex.procedures.Way1delinvertProcedure;
import net.arphex.procedures.Way1delshowProcedure;
import net.arphex.procedures.Way1delshowdimensionProcedure;
import net.arphex.procedures.Way2delinvertProcedure;
import net.arphex.procedures.Way2delshowProcedure;
import net.arphex.procedures.Way2delshowdimensionProcedure;
import net.arphex.procedures.Way2diorderProcedure;
import net.arphex.procedures.Way3delinvertProcedure;
import net.arphex.procedures.Way3delshowProcedure;
import net.arphex.procedures.Way3delshowdimensionProcedure;
import net.arphex.procedures.Way3diorderProcedure;
import net.arphex.world.inventory.WayfinderMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class WayfinderScreen extends AbstractContainerScreen<WayfinderMenu> {
   private static final HashMap<String, Object> guistate = WayfinderMenu.guistate;
   private final Level world;
   private final int x;
   private final int y;
   private final int z;
   private final Player entity;
   Button button_teleport;
   Button button_delete;
   Button button_teleport1;
   Button button_delete1;
   Button button_teleport2;
   Button button_delete2;
   private static final ResourceLocation texture = new ResourceLocation("arphex:textures/screens/wayfinder.png");

   public WayfinderScreen(WayfinderMenu container, Inventory inventory, Component text) {
      super(container, inventory, text);
      this.world = container.world;
      this.x = container.x;
      this.y = container.y;
      this.z = container.z;
      this.entity = container.entity;
      this.imageWidth = 220;
      this.imageHeight = 210;
   }

   public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
      this.renderBackground(guiGraphics);
      super.render(guiGraphics, mouseX, mouseY, partialTicks);
      this.renderTooltip(guiGraphics, mouseX, mouseY);
      if (Marker1tipProcedure.execute(this.entity)
         && mouseX > this.leftPos + 8
         && mouseX < this.leftPos + 32
         && mouseY > this.topPos + 6
         && mouseY < this.topPos + 30) {
         guiGraphics.renderTooltip(this.font, Component.translatable("gui.arphex.wayfinder.tooltip_insert_any_item_to_represent_you"), mouseX, mouseY);
      }

      if (Marker2tipProcedure.execute(this.entity)
         && mouseX > this.leftPos + 8
         && mouseX < this.leftPos + 32
         && mouseY > this.topPos + 42
         && mouseY < this.topPos + 66) {
         guiGraphics.renderTooltip(this.font, Component.translatable("gui.arphex.wayfinder.tooltip_insert_any_item_to_represent_way"), mouseX, mouseY);
      }

      if (Marker3tipProcedure.execute(this.entity)
         && mouseX > this.leftPos + 8
         && mouseX < this.leftPos + 32
         && mouseY > this.topPos + 79
         && mouseY < this.topPos + 103) {
         guiGraphics.renderTooltip(this.font, Component.translatable("gui.arphex.wayfinder.tooltip_insert_any_item_to_represent_way1"), mouseX, mouseY);
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
      if (Way1delshowProcedure.execute(this.entity)) {
         guiGraphics.drawString(this.font, ReturnCoords1Procedure.execute(this.entity), 7, 30, -12829636, false);
      }

      if (Way2delshowProcedure.execute(this.entity)) {
         guiGraphics.drawString(this.font, ReturnCoords2Procedure.execute(this.entity), 7, 66, -12829636, false);
      }

      if (Way3delshowProcedure.execute(this.entity)) {
         guiGraphics.drawString(this.font, ReturnCoords3Procedure.execute(this.entity), 7, 103, -12829636, false);
      }

      if (Way1delinvertProcedure.execute(this.entity)) {
         guiGraphics.drawString(this.font, Component.translatable("gui.arphex.wayfinder.label_no_waypoint_set_crouchright_cl"), 41, 7, -9498351, false);
      }

      if (Way1delinvertProcedure.execute(this.entity)) {
         guiGraphics.drawString(this.font, Component.translatable("gui.arphex.wayfinder.label_crouchright_click_target_to_set"), 41, 19, -12829636, false);
      }

      if (Way2delinvertProcedure.execute(this.entity)) {
         guiGraphics.drawString(this.font, Component.translatable("gui.arphex.wayfinder.label_no_waypoint_set"), 41, 43, -12731312, false);
      }

      if (Way2diorderProcedure.execute(this.entity)) {
         guiGraphics.drawString(this.font, Component.translatable("gui.arphex.wayfinder.label_crouchright_click_target_to_set1"), 41, 56, -12829636, false);
      }

      if (Way3delinvertProcedure.execute(this.entity)) {
         guiGraphics.drawString(this.font, Component.translatable("gui.arphex.wayfinder.label_no_waypoint_set1"), 41, 80, -12696416, false);
      }

      if (Way3diorderProcedure.execute(this.entity)) {
         guiGraphics.drawString(this.font, Component.translatable("gui.arphex.wayfinder.label_crouchright_click_target_to_set2"), 41, 92, -12829636, false);
      }

      if (Tel1dimensionmatchProcedure.execute(this.world, this.entity)) {
         guiGraphics.drawString(this.font, Component.translatable("gui.arphex.wayfinder.label_different_dimension"), 38, 13, -52429, false);
      }

      if (Tel2dimensionmatchProcedure.execute(this.world, this.entity)) {
         guiGraphics.drawString(this.font, Component.translatable("gui.arphex.wayfinder.label_other_dimension"), 38, 50, -52429, false);
      }

      if (Tel3dimensionmatchProcedure.execute(this.world, this.entity)) {
         guiGraphics.drawString(this.font, Component.translatable("gui.arphex.wayfinder.label_other_dimension1"), 39, 87, -52429, false);
      }
   }

   public void init() {
      super.init();
      this.button_teleport = Button.builder(Component.translatable("gui.arphex.wayfinder.button_teleport"), e -> {
         if (Way1delshowdimensionProcedure.execute(this.world, this.entity)) {
            ArphexMod.PACKET_HANDLER.sendToServer(new WayfinderButtonMessage(0, this.x, this.y, this.z));
            WayfinderButtonMessage.handleButtonAction(this.entity, 0, this.x, this.y, this.z);
         }
      }).bounds(this.leftPos + 41, this.topPos + 9, 67, 20).build(builder -> new Button(builder) {
            public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
               if (Way1delshowdimensionProcedure.execute(WayfinderScreen.this.world, WayfinderScreen.this.entity)) {
                  super.render(guiGraphics, gx, gy, ticks);
               }
            }
         });
      guistate.put("button:button_teleport", this.button_teleport);
      this.addRenderableWidget(this.button_teleport);
      this.button_delete = Button.builder(Component.translatable("gui.arphex.wayfinder.button_delete"), e -> {
         if (Way1delshowProcedure.execute(this.entity)) {
            ArphexMod.PACKET_HANDLER.sendToServer(new WayfinderButtonMessage(1, this.x, this.y, this.z));
            WayfinderButtonMessage.handleButtonAction(this.entity, 1, this.x, this.y, this.z);
         }
      }).bounds(this.leftPos + 126, this.topPos + 9, 56, 20).build(builder -> new Button(builder) {
            public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
               if (Way1delshowProcedure.execute(WayfinderScreen.this.entity)) {
                  super.render(guiGraphics, gx, gy, ticks);
               }
            }
         });
      guistate.put("button:button_delete", this.button_delete);
      this.addRenderableWidget(this.button_delete);
      this.button_teleport1 = Button.builder(Component.translatable("gui.arphex.wayfinder.button_teleport1"), e -> {
         if (Way2delshowdimensionProcedure.execute(this.world, this.entity)) {
            ArphexMod.PACKET_HANDLER.sendToServer(new WayfinderButtonMessage(2, this.x, this.y, this.z));
            WayfinderButtonMessage.handleButtonAction(this.entity, 2, this.x, this.y, this.z);
         }
      }).bounds(this.leftPos + 41, this.topPos + 45, 67, 20).build(builder -> new Button(builder) {
            public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
               if (Way2delshowdimensionProcedure.execute(WayfinderScreen.this.world, WayfinderScreen.this.entity)) {
                  super.render(guiGraphics, gx, gy, ticks);
               }
            }
         });
      guistate.put("button:button_teleport1", this.button_teleport1);
      this.addRenderableWidget(this.button_teleport1);
      this.button_delete1 = Button.builder(Component.translatable("gui.arphex.wayfinder.button_delete1"), e -> {
         if (Way2delshowProcedure.execute(this.entity)) {
            ArphexMod.PACKET_HANDLER.sendToServer(new WayfinderButtonMessage(3, this.x, this.y, this.z));
            WayfinderButtonMessage.handleButtonAction(this.entity, 3, this.x, this.y, this.z);
         }
      }).bounds(this.leftPos + 126, this.topPos + 45, 56, 20).build(builder -> new Button(builder) {
            public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
               if (Way2delshowProcedure.execute(WayfinderScreen.this.entity)) {
                  super.render(guiGraphics, gx, gy, ticks);
               }
            }
         });
      guistate.put("button:button_delete1", this.button_delete1);
      this.addRenderableWidget(this.button_delete1);
      this.button_teleport2 = Button.builder(Component.translatable("gui.arphex.wayfinder.button_teleport2"), e -> {
         if (Way3delshowdimensionProcedure.execute(this.world, this.entity)) {
            ArphexMod.PACKET_HANDLER.sendToServer(new WayfinderButtonMessage(4, this.x, this.y, this.z));
            WayfinderButtonMessage.handleButtonAction(this.entity, 4, this.x, this.y, this.z);
         }
      }).bounds(this.leftPos + 41, this.topPos + 82, 67, 20).build(builder -> new Button(builder) {
            public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
               if (Way3delshowdimensionProcedure.execute(WayfinderScreen.this.world, WayfinderScreen.this.entity)) {
                  super.render(guiGraphics, gx, gy, ticks);
               }
            }
         });
      guistate.put("button:button_teleport2", this.button_teleport2);
      this.addRenderableWidget(this.button_teleport2);
      this.button_delete2 = Button.builder(Component.translatable("gui.arphex.wayfinder.button_delete2"), e -> {
         if (Way3delshowProcedure.execute(this.entity)) {
            ArphexMod.PACKET_HANDLER.sendToServer(new WayfinderButtonMessage(5, this.x, this.y, this.z));
            WayfinderButtonMessage.handleButtonAction(this.entity, 5, this.x, this.y, this.z);
         }
      }).bounds(this.leftPos + 125, this.topPos + 82, 56, 20).build(builder -> new Button(builder) {
            public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
               if (Way3delshowProcedure.execute(WayfinderScreen.this.entity)) {
                  super.render(guiGraphics, gx, gy, ticks);
               }
            }
         });
      guistate.put("button:button_delete2", this.button_delete2);
      this.addRenderableWidget(this.button_delete2);
   }
}
