package net.arphex.procedures;

import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexBuffer;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat.Mode;
import com.mojang.math.Axis;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.Font.DisplayMode;
import net.minecraft.client.gui.screens.VideoSettingsScreen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiEvent.Pre;
import net.minecraftforge.client.event.ScreenEvent.Render.Post;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;

@EventBusSubscriber({Dist.CLIENT})
public class RenderTest10GUIProcedure {
   private static Map<EntityType, Entity> data = new HashMap<>();
   private static GuiGraphics guiGraphics = null;
   private static float partialTick = 0.0F;
   private static int currentStage = 0;
   private static int targetStage = 0;

   private static boolean target(int targetStage) {
      if (targetStage == currentStage) {
         RenderTest10GUIProcedure.targetStage = targetStage;
         return true;
      } else if (targetStage == 1 && currentStage != 0) {
         RenderTest10GUIProcedure.targetStage = currentStage;
         return true;
      } else {
         return false;
      }
   }

   private static void release() {
      targetStage = 0;
   }

   public static void renderEntity(
      LevelAccessor levelAccessor, EntityType type, double x, double y, double depth, float yaw, float pitch, float roll, float scale, boolean modelOnly
   ) {
      if (currentStage != 0 && currentStage == targetStage) {
         if (type != null) {
            if (levelAccessor instanceof ClientLevel level && Minecraft.getInstance().gameRenderer.getMainCamera() != null) {
               Entity entity = null;
               if (data.containsKey(type)) {
                  entity = data.get(type);
               } else {
                  entity = type.create(level);
                  data.put(type, entity);
               }

               renderEntity(entity, 0.0F, x, y, depth, yaw, pitch, roll, scale, modelOnly);
            }
         }
      }
   }

   public static void renderEntity(
      LevelAccessor levelAccessor, Entity entity, double x, double y, double depth, float yaw, float pitch, float roll, float scale, boolean modelOnly
   ) {
      if (currentStage != 0 && currentStage == targetStage) {
         Minecraft minecraft = Minecraft.getInstance();
         if (levelAccessor instanceof ClientLevel && minecraft.gameRenderer.getMainCamera() != null) {
            renderEntity(entity, partialTick, x, y, depth, yaw, pitch, roll, scale, modelOnly);
         }
      }
   }

   private static void renderEntity(
      Entity entity, float partialTick, double x, double y, double depth, float yaw, float pitch, float roll, float scale, boolean modelOnly
   ) {
      if (entity != null) {
         float offset = entity.getBbHeight() / 2.0F;
         float yRotO = entity.yRotO;
         float yRot = entity.getYRot();
         float xRotO = entity.xRotO;
         float xRot = entity.getXRot();
         entity.yRotO = 180.0F;
         entity.setYRot(180.0F);
         entity.xRotO = 0.0F;
         entity.setXRot(0.0F);
         PoseStack poseStack = guiGraphics.pose();
         poseStack.pushPose();
         poseStack.translate(x, y, -depth);
         poseStack.mulPose(Axis.YN.rotationDegrees(yaw));
         poseStack.mulPose(Axis.XP.rotationDegrees(pitch));
         poseStack.mulPose(Axis.ZN.rotationDegrees(roll + 180.0F));
         poseStack.mulPoseMatrix(new Matrix4f().scaling(scale, scale, -scale));
         poseStack.translate(0.0F, -offset, 0.0F);
         Lighting.setupForEntityInInventory();
         if (entity instanceof LivingEntity livingEntity) {
            float yBodyRotO = livingEntity.yBodyRotO;
            float yBodyRot = livingEntity.yBodyRot;
            float yHeadRotO = livingEntity.yHeadRotO;
            float yHeadRot = livingEntity.yHeadRot;
            livingEntity.yBodyRotO = 180.0F;
            livingEntity.yBodyRot = 180.0F;
            livingEntity.yHeadRotO = 180.0F;
            livingEntity.yHeadRot = 180.0F;
            renderEntity(livingEntity, partialTick, poseStack, modelOnly);
            livingEntity.yBodyRotO = yBodyRotO;
            livingEntity.yBodyRot = yBodyRot;
            livingEntity.yHeadRotO = yHeadRotO;
            livingEntity.yHeadRot = yHeadRot;
         } else {
            renderEntity(entity, partialTick, poseStack, modelOnly);
         }

         Lighting.setupFor3DItems();
         poseStack.popPose();
         entity.yRotO = yRotO;
         entity.setYRot(yRot);
         entity.xRotO = xRotO;
         entity.setXRot(xRot);
      }
   }

   private static void renderEntity(Entity entity, float partialTick, PoseStack poseStack, boolean modelOnly) {
      Minecraft minecraft = Minecraft.getInstance();
      if (modelOnly) {
         boolean customNameVisible = entity.isCustomNameVisible();
         entity.setCustomNameVisible(false);
         minecraft.getEntityRenderDispatcher().getRenderer(entity).render(entity, 0.0F, partialTick, poseStack, guiGraphics.bufferSource(), 15728880);
         guiGraphics.flush();
         entity.setCustomNameVisible(customNameVisible);
      } else {
         EntityRenderDispatcher renderer = minecraft.getEntityRenderDispatcher();
         renderer.setRenderShadow(false);
         renderer.render(entity, 0.0, 0.0, 0.0, 0.0F, partialTick, poseStack, guiGraphics.bufferSource(), 15728880);
         guiGraphics.flush();
         renderer.setRenderShadow(true);
      }
   }

   public static void renderItem(
      LevelAccessor levelAccessor, ItemStack itemStack, double x, double y, double depth, float yaw, float pitch, float roll, float scale
   ) {
      if (currentStage != 0 && currentStage == targetStage) {
         if (!itemStack.isEmpty()) {
            Minecraft minecraft = Minecraft.getInstance();
            if (levelAccessor instanceof ClientLevel level && minecraft.gameRenderer.getMainCamera() != null) {
               ItemRenderer renderer = minecraft.getItemRenderer();
               BakedModel bakedModel = renderer.getModel(itemStack, level, null, 0);
               PoseStack poseStack = guiGraphics.pose();
               poseStack.pushPose();
               poseStack.translate(x, y, -depth);
               poseStack.mulPose(Axis.YN.rotationDegrees(yaw));
               poseStack.mulPose(Axis.XP.rotationDegrees(pitch));
               poseStack.mulPose(Axis.ZN.rotationDegrees(roll));
               poseStack.mulPoseMatrix(new Matrix4f().scaling(1.0F, -1.0F, 1.0F));
               poseStack.scale(scale, scale, scale);
               if (!bakedModel.usesBlockLight()) {
                  Lighting.setupForFlatItems();
               }

               renderer.render(itemStack, ItemDisplayContext.GUI, false, poseStack, guiGraphics.bufferSource(), 15728880, OverlayTexture.NO_OVERLAY, bakedModel);
               guiGraphics.flush();
               Lighting.setupFor3DItems();
               poseStack.popPose();
            }
         }
      }
   }

   public static void renderRectangle(float x1, float y1, float x2, float y2, float depth, int color) {
      if (currentStage != 0 && currentStage == targetStage) {
         float x3;
         float x4;
         if (x1 <= x2) {
            x3 = x1;
            x4 = x2;
         } else {
            x3 = x2;
            x4 = x1;
         }

         float y3;
         float y4;
         if (y1 <= y2) {
            y3 = y1;
            y4 = y2;
         } else {
            y3 = y2;
            y4 = y1;
         }

         int red = color >> 16 & 0xFF;
         int green = color >> 8 & 0xFF;
         int blue = color & 0xFF;
         int alpha = color >>> 24;
         Matrix4f matrix4f = guiGraphics.pose().last().pose();
         VertexConsumer vertexConsumer = guiGraphics.bufferSource().getBuffer(RenderType.gui());
         vertexConsumer.vertex(matrix4f, x3, y3, -depth).color(red, green, blue, alpha).endVertex();
         vertexConsumer.vertex(matrix4f, x3, y4, -depth).color(red, green, blue, alpha).endVertex();
         vertexConsumer.vertex(matrix4f, x4, y4, -depth).color(red, green, blue, alpha).endVertex();
         vertexConsumer.vertex(matrix4f, x4, y3, -depth).color(red, green, blue, alpha).endVertex();
      }
   }

   public static void renderShape(
      VertexBuffer vertexBuffer, double x, double y, double depth, float yaw, float pitch, float roll, float xScale, float yScale, float zScale, int color
   ) {
      if (currentStage != 0 && currentStage == targetStage) {
         if (vertexBuffer != null) {
            PoseStack poseStack = guiGraphics.pose();
            poseStack.pushPose();
            poseStack.translate(x, y, -depth);
            poseStack.mulPose(Axis.YN.rotationDegrees(yaw));
            poseStack.mulPose(Axis.XP.rotationDegrees(pitch));
            poseStack.mulPose(Axis.ZN.rotationDegrees(roll));
            poseStack.scale(xScale, yScale, zScale);
            PoseStack modelViewStack = RenderSystem.getModelViewStack();
            modelViewStack.pushPose();
            modelViewStack.mulPoseMatrix(poseStack.last().pose());
            RenderSystem.setShaderColor(
               (float)(color >> 16 & 0xFF) / 255.0F, (float)(color >> 8 & 0xFF) / 255.0F, (float)(color & 0xFF) / 255.0F, (float)(color >>> 24) / 255.0F
            );
            vertexBuffer.bind();
            vertexBuffer.drawWithShader(
               modelViewStack.last().pose(),
               RenderSystem.getProjectionMatrix(),
               vertexBuffer.getFormat().hasUV(0) ? GameRenderer.getPositionTexColorShader() : GameRenderer.getPositionColorShader()
            );
            VertexBuffer.unbind();
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            modelViewStack.popPose();
            poseStack.popPose();
         }
      }
   }

   public static void renderTexts(String texts, float x, float y, float depth, float angle, float scale, int color, int alignment) {
      if (currentStage != 0 && currentStage == targetStage) {
         Font font = Minecraft.getInstance().font;
         float offsetX = 0.0F;
         float offsetY = 0.0F;
         switch (alignment) {
            case 0:
               offsetX = (float)(font.width(texts) - 1) * 0.5F;
               offsetY = (float)(9 - 1) * 0.5F;
               break;
            case 1:
               offsetY = (float)(9 - 1) * 0.5F;
               break;
            case 2:
               offsetX = (float)(font.width(texts) - 1) * -0.5F;
               offsetY = (float)(9 - 1) * 0.5F;
               break;
            case 3:
               offsetX = (float)(font.width(texts) - 1) * 0.5F;
            case 4:
            default:
               break;
            case 5:
               offsetX = (float)(font.width(texts) - 1) * -0.5F;
               break;
            case 6:
               offsetX = (float)(font.width(texts) - 1) * 0.5F;
               offsetY = (float)(9 - 1) * -0.5F;
               break;
            case 7:
               offsetY = (float)(9 - 1) * -0.5F;
               break;
            case 8:
               offsetX = (float)(font.width(texts) - 1) * -0.5F;
               offsetY = (float)(9 - 1) * -0.5F;
         }

         PoseStack poseStack = guiGraphics.pose();
         poseStack.pushPose();
         poseStack.translate(x + offsetX * scale, y + offsetY * scale, -depth);
         poseStack.mulPose(Axis.ZN.rotationDegrees(angle));
         poseStack.scale(scale, scale, 1.0F);
         poseStack.translate((float)(font.width(texts) - 1) * -0.5F, (float)(9 - 1) * -0.5F, 0.0F);
         Matrix4f matrix4f = poseStack.last().pose();
         font.drawInBatch(texts, 0.0F, 0.0F, color, false, matrix4f, guiGraphics.bufferSource(), DisplayMode.NORMAL, 0, 15728880);
         poseStack.popPose();
      }
   }

   public static void renderTexture(float x, float y, float depth, float angle, float scale, int color, int alignment) {
      if (currentStage != 0 && currentStage == targetStage) {
         float offsetX = 0.0F;
         float offsetY = 0.0F;
         switch (alignment) {
            case 0:
               offsetX = 0.5F;
               offsetY = 0.5F;
               break;
            case 1:
               offsetY = 0.5F;
               break;
            case 2:
               offsetX = -0.5F;
               offsetY = 0.5F;
               break;
            case 3:
               offsetX = 0.5F;
            case 4:
            default:
               break;
            case 5:
               offsetX = -0.5F;
               break;
            case 6:
               offsetX = 0.5F;
               offsetY = -0.5F;
               break;
            case 7:
               offsetY = -0.5F;
               break;
            case 8:
               offsetX = -0.5F;
               offsetY = -0.5F;
         }

         RenderSystem.bindTexture(RenderSystem.getShaderTexture(0));
         int width = GL11.glGetTexLevelParameteri(3553, 0, 4096);
         int height = GL11.glGetTexLevelParameteri(3553, 0, 4097);
         int red = color >> 16 & 0xFF;
         int green = color >> 8 & 0xFF;
         int blue = color & 0xFF;
         int alpha = color >>> 24;
         PoseStack poseStack = guiGraphics.pose();
         poseStack.pushPose();
         poseStack.translate(x, y, -depth);
         poseStack.mulPose(Axis.ZN.rotationDegrees(angle));
         poseStack.scale((float)width * scale, (float)height * scale, 1.0F);
         poseStack.translate(offsetX, offsetY, 0.0F);
         Matrix4f matrix4f = poseStack.last().pose();
         RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
         BufferBuilder bufferBuilder = Tesselator.getInstance().getBuilder();
         bufferBuilder.begin(Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
         bufferBuilder.vertex(matrix4f, -0.5F, -0.5F, 0.0F).uv(0.0F, 0.0F).color(red, green, blue, alpha).endVertex();
         bufferBuilder.vertex(matrix4f, -0.5F, 0.5F, 0.0F).uv(0.0F, 1.0F).color(red, green, blue, alpha).endVertex();
         bufferBuilder.vertex(matrix4f, 0.5F, 0.5F, 0.0F).uv(1.0F, 1.0F).color(red, green, blue, alpha).endVertex();
         bufferBuilder.vertex(matrix4f, 0.5F, -0.5F, 0.0F).uv(1.0F, 0.0F).color(red, green, blue, alpha).endVertex();
         BufferUploader.drawWithShader(bufferBuilder.end());
         poseStack.popPose();
      }
   }

   @SubscribeEvent(
      priority = EventPriority.LOWEST
   )
   public static void renderGUI(Pre event) {
      currentStage = 2;
      guiGraphics = event.getGuiGraphics();
      partialTick = event.getPartialTick();
      renderOverlays(event);
      currentStage = 0;
   }

   @SubscribeEvent(
      priority = EventPriority.LOWEST
   )
   public static void renderScreen(Post event) {
      currentStage = 3;
      guiGraphics = event.getGuiGraphics();
      partialTick = event.getPartialTick();
      renderOverlays(event);
      currentStage = 0;
   }

   private static void renderOverlays(Event event) {
      Minecraft minecraft = Minecraft.getInstance();
      double scale = minecraft.getWindow().getGuiScale();
      if (scale > 0.0) {
         RenderSystem.depthMask(true);
         RenderSystem.enableDepthTest();
         RenderSystem.disableCull();
         RenderSystem.enableBlend();
         RenderSystem.defaultBlendFunc();
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
         execute(event);
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
         RenderSystem.defaultBlendFunc();
         RenderSystem.disableBlend();
         RenderSystem.enableCull();
         RenderSystem.enableDepthTest();
         RenderSystem.depthMask(true);
      }
   }

   public static void execute() {
      execute(null);
   }

   private static void execute(@Nullable Event event) {
      boolean crawling_only = false;
      crawling_only = false;
      if (Minecraft.getInstance().player != null) {
         Entity entity = Minecraft.getInstance().player;
         double x = entity.getX();
         double y = entity.getY();
         double z = entity.getZ();
         LevelAccessor world = entity.level();
         ResourceKey<Level> dimension = entity.level().dimension();
         if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
            == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))) {
            crawling_only = true;
         }
      }

      if (target(3)) {
         if (Minecraft.getInstance().screen instanceof VideoSettingsScreen && crawling_only) {
            renderTexts(
               "CRAWLING DIMENSION MAX RECOMMENDED RENDER DISTANCE IS 8",
               (float)(Minecraft.getInstance().getWindow().getGuiScaledWidth() / 2),
               10.0F,
               0.0F,
               0.0F,
               1.0F,
               -65536,
               4
            );
         }

         release();
      }
   }
}
