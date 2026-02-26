package net.arphex.procedures;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.UnmodifiableIterator;
import com.mojang.blaze3d.platform.GlStateManager.DestFactor;
import com.mojang.blaze3d.platform.GlStateManager.SourceFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexBuffer;
import com.mojang.blaze3d.vertex.VertexBuffer.Usage;
import com.mojang.blaze3d.vertex.VertexFormat.Mode;
import com.mojang.math.Axis;
import java.lang.reflect.Field;
import java.util.Set;
import java.util.function.Predicate;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.DimensionSpecialEffectsManager;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.joml.Matrix4f;

@EventBusSubscriber(
   value = {Dist.CLIENT},
   bus = Bus.MOD
)
public class RenderTest9SkyProcedure {
   private static int ticks = 0;
   private static float partialTick = 0.0F;
   private static PoseStack poseStack = null;
   private static Matrix4f projectionMatrix = null;
   private static Runnable setupFog = null;
   private static VertexBuffer abyssBuffer = null;
   private static VertexBuffer deepSkyBuffer = null;
   private static VertexBuffer skyboxBuffer = null;
   private static VertexBuffer starBuffer = null;
   private static int amount = 0;
   private static int seed = 0;
   private static final Predicate<Object[]> PREDICATE = params -> {
      ticks = (Integer)params[1];
      partialTick = (Float)params[2];
      poseStack = (PoseStack)params[3];
      projectionMatrix = (Matrix4f)params[5];
      setupFog = (Runnable)params[7];
      FogRenderer.levelFogColor();
      setupFog.run();
      Minecraft minecraft = Minecraft.getInstance();
      Entity entity = minecraft.gameRenderer.getMainCamera().getEntity();
      if (entity != null) {
         ClientLevel level = minecraft.level;
         Vec3 pos = entity.getPosition(partialTick);
         execute(null);
         return true;
      } else {
         return false;
      }
   };

   public static void renderAbyss(int color, boolean constant) {
      Minecraft minecraft = Minecraft.getInstance();
      boolean visible = minecraft.player.getEyePosition(partialTick).y() - minecraft.level.getLevelData().getHorizonHeight(minecraft.level) < 0.0;
      if (visible || constant) {
         if (abyssBuffer != null) {
            abyssBuffer.bind();
         } else {
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.setShader(GameRenderer::getPositionShader);
            BufferBuilder bufferBuilder = Tesselator.getInstance().getBuilder();
            bufferBuilder.begin(Mode.TRIANGLE_FAN, DefaultVertexFormat.POSITION);
            bufferBuilder.vertex(0.0, -16.0, 0.0).endVertex();

            for (int i = 0; i <= 8; i++) {
               bufferBuilder.vertex(
                     (double)(-512.0F * Mth.cos((float)i * 45.0F * (float) (Math.PI / 180.0))),
                     -16.0,
                     (double)(512.0F * Mth.sin((float)i * 45.0F * (float) (Math.PI / 180.0)))
                  )
                  .endVertex();
            }

            abyssBuffer = new VertexBuffer(Usage.STATIC);
            abyssBuffer.bind();
            abyssBuffer.upload(bufferBuilder.end());
         }

         poseStack.pushPose();
         poseStack.translate(0.0F, 12.0F, 0.0F);
         RenderSystem.setShaderColor(
            (float)(color >> 16 & 0xFF) / 255.0F, (float)(color >> 8 & 0xFF) / 255.0F, (float)(color & 0xFF) / 255.0F, (float)(color >>> 24) / 255.0F
         );
         abyssBuffer.drawWithShader(poseStack.last().pose(), projectionMatrix, GameRenderer.getPositionShader());
         VertexBuffer.unbind();
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
         poseStack.popPose();
      }
   }

   public static void renderDeepSky(int color) {
      if (deepSkyBuffer == null) {
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
         RenderSystem.setShader(GameRenderer::getPositionShader);
         BufferBuilder bufferBuilder = Tesselator.getInstance().getBuilder();
         bufferBuilder.begin(Mode.TRIANGLE_FAN, DefaultVertexFormat.POSITION);
         bufferBuilder.vertex(0.0, 16.0, 0.0).endVertex();

         for (int i = 0; i <= 8; i++) {
            bufferBuilder.vertex(
                  (double)(512.0F * Mth.cos(45.0F * (float)i * (float) (Math.PI / 180.0))),
                  16.0,
                  (double)(512.0F * Mth.sin(45.0F * (float)i * (float) (Math.PI / 180.0)))
               )
               .endVertex();
         }

         deepSkyBuffer = new VertexBuffer(Usage.STATIC);
         deepSkyBuffer.bind();
         deepSkyBuffer.upload(bufferBuilder.end());
      } else {
         deepSkyBuffer.bind();
      }

      RenderSystem.setShaderColor(
         (float)(color >> 16 & 0xFF) / 255.0F, (float)(color >> 8 & 0xFF) / 255.0F, (float)(color & 0xFF) / 255.0F, (float)(color >>> 24) / 255.0F
      );
      deepSkyBuffer.drawWithShader(poseStack.last().pose(), projectionMatrix, GameRenderer.getPositionShader());
      VertexBuffer.unbind();
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void renderEndSky(float yaw, float pitch, float roll, int color, boolean constant) {
      Minecraft minecraft = Minecraft.getInstance();
      Vec3 pos = minecraft.gameRenderer.getMainCamera().getPosition();
      boolean invisible = minecraft.level.effects().isFoggyAt(Mth.floor(pos.x()), Mth.floor(pos.y())) || minecraft.gui.getBossOverlay().shouldCreateWorldFog();
      if (!invisible || constant) {
         poseStack.pushPose();
         poseStack.mulPose(Axis.YN.rotationDegrees(yaw));
         poseStack.mulPose(Axis.XP.rotationDegrees(pitch));
         poseStack.mulPose(Axis.ZN.rotationDegrees(roll));
         Matrix4f matrix4f = poseStack.last().pose();
         RenderSystem.setShaderColor(
            (float)(color >> 16 & 0xFF) / 255.0F, (float)(color >> 8 & 0xFF) / 255.0F, (float)(color & 0xFF) / 255.0F, (float)(color >>> 24) / 255.0F
         );
         RenderSystem.setShader(GameRenderer::getPositionTexShader);
         BufferBuilder bufferBuilder = Tesselator.getInstance().getBuilder();
         bufferBuilder.begin(Mode.QUADS, DefaultVertexFormat.POSITION_TEX);

         for (int i = 0; i < 6; i++) {
            switch (i) {
               case 0:
                  bufferBuilder.vertex(matrix4f, -100.0F, -100.0F, -100.0F).uv(0.0F, 0.0F).endVertex();
                  bufferBuilder.vertex(matrix4f, -100.0F, -100.0F, 100.0F).uv(0.0F, 16.0F).endVertex();
                  bufferBuilder.vertex(matrix4f, 100.0F, -100.0F, 100.0F).uv(16.0F, 16.0F).endVertex();
                  bufferBuilder.vertex(matrix4f, 100.0F, -100.0F, -100.0F).uv(16.0F, 0.0F).endVertex();
                  break;
               case 1:
                  bufferBuilder.vertex(matrix4f, -100.0F, -100.0F, 100.0F).uv(0.0F, 0.0F).endVertex();
                  bufferBuilder.vertex(matrix4f, -100.0F, 100.0F, 100.0F).uv(0.0F, 16.0F).endVertex();
                  bufferBuilder.vertex(matrix4f, 100.0F, 100.0F, 100.0F).uv(16.0F, 16.0F).endVertex();
                  bufferBuilder.vertex(matrix4f, 100.0F, -100.0F, 100.0F).uv(16.0F, 0.0F).endVertex();
                  break;
               case 2:
                  bufferBuilder.vertex(matrix4f, -100.0F, 100.0F, -100.0F).uv(0.0F, 0.0F).endVertex();
                  bufferBuilder.vertex(matrix4f, -100.0F, -100.0F, -100.0F).uv(0.0F, 16.0F).endVertex();
                  bufferBuilder.vertex(matrix4f, 100.0F, -100.0F, -100.0F).uv(16.0F, 16.0F).endVertex();
                  bufferBuilder.vertex(matrix4f, 100.0F, 100.0F, -100.0F).uv(16.0F, 0.0F).endVertex();
                  break;
               case 3:
                  bufferBuilder.vertex(matrix4f, -100.0F, 100.0F, 100.0F).uv(0.0F, 0.0F).endVertex();
                  bufferBuilder.vertex(matrix4f, -100.0F, 100.0F, -100.0F).uv(0.0F, 16.0F).endVertex();
                  bufferBuilder.vertex(matrix4f, 100.0F, 100.0F, -100.0F).uv(16.0F, 16.0F).endVertex();
                  bufferBuilder.vertex(matrix4f, 100.0F, 100.0F, 100.0F).uv(16.0F, 0.0F).endVertex();
                  break;
               case 4:
                  bufferBuilder.vertex(matrix4f, -100.0F, 100.0F, -100.0F).uv(0.0F, 0.0F).endVertex();
                  bufferBuilder.vertex(matrix4f, -100.0F, 100.0F, 100.0F).uv(0.0F, 16.0F).endVertex();
                  bufferBuilder.vertex(matrix4f, -100.0F, -100.0F, 100.0F).uv(16.0F, 16.0F).endVertex();
                  bufferBuilder.vertex(matrix4f, -100.0F, -100.0F, -100.0F).uv(16.0F, 0.0F).endVertex();
                  break;
               case 5:
                  bufferBuilder.vertex(matrix4f, 100.0F, -100.0F, -100.0F).uv(0.0F, 0.0F).endVertex();
                  bufferBuilder.vertex(matrix4f, 100.0F, -100.0F, 100.0F).uv(0.0F, 16.0F).endVertex();
                  bufferBuilder.vertex(matrix4f, 100.0F, 100.0F, 100.0F).uv(16.0F, 16.0F).endVertex();
                  bufferBuilder.vertex(matrix4f, 100.0F, 100.0F, -100.0F).uv(16.0F, 0.0F).endVertex();
            }
         }

         BufferUploader.drawWithShader(bufferBuilder.end());
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
         poseStack.popPose();
      }
   }

   public static void renderMoon(float size, int color, boolean phase, boolean constant) {
      ClientLevel level = Minecraft.getInstance().level;
      float r = size / 2.0F;
      float u0 = 0.0F;
      float v0 = 0.0F;
      float u1 = 1.0F;
      float v1 = 1.0F;
      if (phase) {
         int i0 = level.getMoonPhase();
         int i1 = i0 & 3;
         int i2 = i0 >> 2 & 1;
         u0 = (float)i1 / 4.0F;
         v0 = (float)i2 / 2.0F;
         u1 = (float)(i1 + 1) / 4.0F;
         v1 = (float)(i2 + 1) / 2.0F;
      }

      float alpha = (float)(color >>> 24) / 255.0F;
      if (!constant) {
         alpha *= 1.0F - level.getRainLevel(partialTick);
      }

      poseStack.pushPose();
      poseStack.mulPose(Axis.ZP.rotationDegrees(level.getTimeOfDay(partialTick) * 360.0F));
      Matrix4f matrix4f = poseStack.last().pose();
      RenderSystem.setShaderColor((float)(color >> 16 & 0xFF) / 255.0F, (float)(color >> 8 & 0xFF) / 255.0F, (float)(color & 0xFF) / 255.0F, alpha);
      RenderSystem.setShader(GameRenderer::getPositionTexShader);
      BufferBuilder bufferBuilder = Tesselator.getInstance().getBuilder();
      bufferBuilder.begin(Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
      bufferBuilder.vertex(matrix4f, -r, -100.0F, -r).uv(u1, v1).endVertex();
      bufferBuilder.vertex(matrix4f, -r, -100.0F, r).uv(u0, v1).endVertex();
      bufferBuilder.vertex(matrix4f, r, -100.0F, r).uv(u0, v0).endVertex();
      bufferBuilder.vertex(matrix4f, r, -100.0F, -r).uv(u1, v0).endVertex();
      BufferUploader.drawWithShader(bufferBuilder.end());
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      poseStack.popPose();
   }

   public static void renderSky(boolean deepSky, boolean sunlights, boolean sun, boolean moon, boolean stars, boolean abyss) {
      Minecraft minecraft = Minecraft.getInstance();
      ClientLevel level = minecraft.level;
      if (deepSky) {
         Vec3 color = level.getSkyColor(minecraft.gameRenderer.getMainCamera().getPosition(), partialTick);
         RenderSystem.defaultBlendFunc();
         renderDeepSky(0xFF000000 | (int)(color.x() * 255.0) << 16 | (int)(color.y() * 255.0) << 8 | (int)(color.z() * 255.0));
      }

      if (sunlights) {
         float[] color = level.effects().getSunriseColor(level.getTimeOfDay(partialTick), partialTick);
         if (color != null) {
            RenderSystem.defaultBlendFunc();
            renderSunlights((int)(color[3] * 255.0F) << 24 | (int)(color[0] * 255.0F) << 16 | (int)(color[1] * 255.0F) << 8 | (int)(color[2] * 255.0F));
         }
      }

      if (sun) {
         RenderSystem.setShaderTexture(0, new ResourceLocation("minecraft:textures/environment/sun.png"));
         RenderSystem.blendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE, SourceFactor.ONE, DestFactor.ZERO);
         renderSun(60.0F, -1, false);
      }

      if (moon) {
         RenderSystem.setShaderTexture(0, new ResourceLocation("minecraft:textures/environment/moon_phases.png"));
         RenderSystem.blendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE, SourceFactor.ONE, DestFactor.ZERO);
         renderMoon(40.0F, -1, true, false);
      }

      if (stars) {
         int color = (int)(level.getStarBrightness(partialTick) * 255.0F);
         RenderSystem.blendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE, SourceFactor.ONE, DestFactor.ZERO);
         renderStars(1500, 10842, 90.0F, level.getTimeOfDay(partialTick) * 360.0F, 0.0F, color << 24 | color << 16 | color << 8 | color, false);
      }

      if (abyss) {
         RenderSystem.defaultBlendFunc();
         renderAbyss(-16777216, false);
      }
   }

   public static void renderSkybox(float yaw, float pitch, float roll, int color, boolean constant) {
      Minecraft minecraft = Minecraft.getInstance();
      Vec3 pos = minecraft.gameRenderer.getMainCamera().getPosition();
      boolean invisible = minecraft.level.effects().isFoggyAt(Mth.floor(pos.x()), Mth.floor(pos.y())) || minecraft.gui.getBossOverlay().shouldCreateWorldFog();
      if (!invisible || constant) {
         if (skyboxBuffer != null) {
            skyboxBuffer.bind();
         } else {
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            BufferBuilder bufferBuilder = Tesselator.getInstance().getBuilder();
            bufferBuilder.begin(Mode.QUADS, DefaultVertexFormat.POSITION_TEX);

            for (int i = 0; i < 6; i++) {
               switch (i) {
                  case 0:
                     bufferBuilder.vertex(-0.5, -0.5, -0.5).uv(0.0F, 0.0F).endVertex();
                     bufferBuilder.vertex(-0.5, -0.5, 0.5).uv(0.0F, 0.5F).endVertex();
                     bufferBuilder.vertex(0.5, -0.5, 0.5).uv(0.33333334F, 0.5F).endVertex();
                     bufferBuilder.vertex(0.5, -0.5, -0.5).uv(0.33333334F, 0.0F).endVertex();
                     break;
                  case 1:
                     bufferBuilder.vertex(-0.5, 0.5, 0.5).uv(0.33333334F, 0.0F).endVertex();
                     bufferBuilder.vertex(-0.5, 0.5, -0.5).uv(0.33333334F, 0.5F).endVertex();
                     bufferBuilder.vertex(0.5, 0.5, -0.5).uv(0.6666667F, 0.5F).endVertex();
                     bufferBuilder.vertex(0.5, 0.5, 0.5).uv(0.6666667F, 0.0F).endVertex();
                     break;
                  case 2:
                     bufferBuilder.vertex(0.5, 0.5, 0.5).uv(0.6666667F, 0.0F).endVertex();
                     bufferBuilder.vertex(0.5, -0.5, 0.5).uv(0.6666667F, 0.5F).endVertex();
                     bufferBuilder.vertex(-0.5, -0.5, 0.5).uv(1.0F, 0.5F).endVertex();
                     bufferBuilder.vertex(-0.5, 0.5, 0.5).uv(1.0F, 0.0F).endVertex();
                     break;
                  case 3:
                     bufferBuilder.vertex(-0.5, 0.5, 0.5).uv(0.0F, 0.5F).endVertex();
                     bufferBuilder.vertex(-0.5, -0.5, 0.5).uv(0.0F, 1.0F).endVertex();
                     bufferBuilder.vertex(-0.5, -0.5, -0.5).uv(0.33333334F, 1.0F).endVertex();
                     bufferBuilder.vertex(-0.5, 0.5, -0.5).uv(0.33333334F, 0.5F).endVertex();
                     break;
                  case 4:
                     bufferBuilder.vertex(-0.5, 0.5, -0.5).uv(0.33333334F, 0.5F).endVertex();
                     bufferBuilder.vertex(-0.5, -0.5, -0.5).uv(0.33333334F, 1.0F).endVertex();
                     bufferBuilder.vertex(0.5, -0.5, -0.5).uv(0.6666667F, 1.0F).endVertex();
                     bufferBuilder.vertex(0.5, 0.5, -0.5).uv(0.6666667F, 0.5F).endVertex();
                     break;
                  case 5:
                     bufferBuilder.vertex(0.5, 0.5, -0.5).uv(0.6666667F, 0.5F).endVertex();
                     bufferBuilder.vertex(0.5, -0.5, -0.5).uv(0.6666667F, 1.0F).endVertex();
                     bufferBuilder.vertex(0.5, -0.5, 0.5).uv(1.0F, 1.0F).endVertex();
                     bufferBuilder.vertex(0.5, 0.5, 0.5).uv(1.0F, 0.5F).endVertex();
               }
            }

            skyboxBuffer = new VertexBuffer(Usage.STATIC);
            skyboxBuffer.bind();
            skyboxBuffer.upload(bufferBuilder.end());
         }

         float size = (float)(minecraft.options.getEffectiveRenderDistance() << 6);
         poseStack.pushPose();
         poseStack.mulPose(Axis.YN.rotationDegrees(yaw));
         poseStack.mulPose(Axis.XP.rotationDegrees(pitch));
         poseStack.mulPose(Axis.ZN.rotationDegrees(roll));
         poseStack.scale(size, size, size);
         RenderSystem.setShaderColor(
            (float)(color >> 16 & 0xFF) / 255.0F, (float)(color >> 8 & 0xFF) / 255.0F, (float)(color & 0xFF) / 255.0F, (float)(color >>> 24) / 255.0F
         );
         skyboxBuffer.drawWithShader(poseStack.last().pose(), projectionMatrix, GameRenderer.getPositionTexShader());
         VertexBuffer.unbind();
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
         poseStack.popPose();
      }
   }

   public static void renderStars(int amount, int seed, float yaw, float pitch, float roll, int color, boolean constant) {
      if (starBuffer != null && amount == RenderTest9SkyProcedure.amount && seed == RenderTest9SkyProcedure.seed) {
         starBuffer.bind();
      } else {
         RenderTest9SkyProcedure.amount = amount;
         RenderTest9SkyProcedure.seed = seed;
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
         RenderSystem.setShader(GameRenderer::getPositionShader);
         BufferBuilder bufferBuilder = Tesselator.getInstance().getBuilder();
         bufferBuilder.begin(Mode.QUADS, DefaultVertexFormat.POSITION);
         RandomSource randomsource = RandomSource.create((long)seed);

         for (int i = 0; i < amount; i++) {
            float f0 = randomsource.nextFloat() * 2.0F - 1.0F;
            float f1 = randomsource.nextFloat() * 2.0F - 1.0F;
            float f2 = randomsource.nextFloat() * 2.0F - 1.0F;
            float f3 = 0.15F + 0.1F * randomsource.nextFloat();
            float f4 = f0 * f0 + f1 * f1 + f2 * f2;
            if (f4 < 1.0F && f4 > 0.01F) {
               f4 = 1.0F / Mth.sqrt(f4);
               f0 *= f4;
               f1 *= f4;
               f2 *= f4;
               float f5 = f0 * 100.0F;
               float f6 = f1 * 100.0F;
               float f7 = f2 * 100.0F;
               float f8 = (float)Math.atan2((double)f0, (double)f2);
               float f9 = Mth.sin(f8);
               float f10 = Mth.cos(f8);
               float f11 = (float)Math.atan2((double)Mth.sqrt(f0 * f0 + f2 * f2), (double)f1);
               float f12 = Mth.sin(f11);
               float f13 = Mth.cos(f11);
               float f14 = (float)randomsource.nextDouble() * (float) Math.PI * 2.0F;
               float f15 = Mth.sin(f14);
               float f16 = Mth.cos(f14);

               for (int j = 0; j < 4; j++) {
                  float f17 = (float)((j & 2) - 1) * f3;
                  float f18 = (float)((j + 1 & 2) - 1) * f3;
                  float f20 = f17 * f16 - f18 * f15;
                  float f21 = f18 * f16 + f17 * f15;
                  float f22 = -f20 * f13;
                  float f23 = f22 * f9 - f21 * f10;
                  float f24 = f20 * f12;
                  float f25 = f21 * f9 + f22 * f10;
                  bufferBuilder.vertex((double)(f5 + f23), (double)(f6 + f24), (double)(f7 + f25)).endVertex();
               }
            }
         }

         if (starBuffer != null) {
            starBuffer.close();
         }

         starBuffer = new VertexBuffer(Usage.STATIC);
         starBuffer.bind();
         starBuffer.upload(bufferBuilder.end());
      }

      float alpha = (float)(color >>> 24) / 255.0F;
      if (!constant) {
         alpha *= 1.0F - Minecraft.getInstance().level.getRainLevel(partialTick);
      }

      poseStack.pushPose();
      poseStack.mulPose(Axis.YN.rotationDegrees(yaw));
      poseStack.mulPose(Axis.XP.rotationDegrees(pitch));
      poseStack.mulPose(Axis.ZN.rotationDegrees(roll));
      FogRenderer.setupNoFog();
      RenderSystem.setShaderColor((float)(color >> 16 & 0xFF) / 255.0F, (float)(color >> 8 & 0xFF) / 255.0F, (float)(color & 0xFF) / 255.0F, alpha);
      starBuffer.drawWithShader(poseStack.last().pose(), projectionMatrix, GameRenderer.getPositionShader());
      VertexBuffer.unbind();
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      setupFog.run();
      poseStack.popPose();
   }

   public static void renderSun(float size, int color, boolean constant) {
      ClientLevel level = Minecraft.getInstance().level;
      float r = size / 2.0F;
      float alpha = (float)(color >>> 24) / 255.0F;
      if (!constant) {
         alpha *= 1.0F - level.getRainLevel(partialTick);
      }

      poseStack.pushPose();
      poseStack.mulPose(Axis.ZP.rotationDegrees(level.getTimeOfDay(partialTick) * 360.0F));
      Matrix4f matrix4f = poseStack.last().pose();
      RenderSystem.setShaderColor((float)(color >> 16 & 0xFF) / 255.0F, (float)(color >> 8 & 0xFF) / 255.0F, (float)(color & 0xFF) / 255.0F, alpha);
      RenderSystem.setShader(GameRenderer::getPositionTexShader);
      BufferBuilder bufferBuilder = Tesselator.getInstance().getBuilder();
      bufferBuilder.begin(Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
      bufferBuilder.vertex(matrix4f, r, 100.0F, -r).uv(0.0F, 0.0F).endVertex();
      bufferBuilder.vertex(matrix4f, r, 100.0F, r).uv(1.0F, 0.0F).endVertex();
      bufferBuilder.vertex(matrix4f, -r, 100.0F, r).uv(1.0F, 1.0F).endVertex();
      bufferBuilder.vertex(matrix4f, -r, 100.0F, -r).uv(0.0F, 1.0F).endVertex();
      BufferUploader.drawWithShader(bufferBuilder.end());
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      poseStack.popPose();
   }

   public static void renderSunlights(int color) {
      ClientLevel level = Minecraft.getInstance().level;
      float[] rawColor = level.effects().getSunriseColor(level.getTimeOfDay(partialTick), partialTick);
      if (rawColor != null) {
         int red = color >> 16 & 0xFF;
         int green = color >> 8 & 0xFF;
         int blue = color & 0xFF;
         int alpha = (int)((float)(color >>> 24) * rawColor[3]);
         Matrix4f matrix4f = poseStack.last().pose();
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
         RenderSystem.setShader(GameRenderer::getPositionColorShader);
         BufferBuilder bufferBuilder = Tesselator.getInstance().getBuilder();
         bufferBuilder.begin(Mode.TRIANGLE_FAN, DefaultVertexFormat.POSITION_COLOR);
         boolean flag = Mth.sin(level.getSunAngle(partialTick)) < 0.0F;
         if (flag) {
            bufferBuilder.vertex(matrix4f, 100.0F, 0.0F, 0.0F).color(red, green, blue, alpha).endVertex();
         } else {
            bufferBuilder.vertex(matrix4f, -100.0F, 0.0F, 0.0F).color(red, green, blue, alpha).endVertex();
         }

         for (int i = 0; i <= 16; i++) {
            float deg = (float)i * (float) (Math.PI * 2) / 16.0F;
            float sin = Mth.sin(deg);
            float cos = Mth.cos(deg);
            if (flag) {
               bufferBuilder.vertex(matrix4f, cos * 120.0F, cos * 40.0F * rawColor[3], -sin * 120.0F).color(red, green, blue, 0).endVertex();
            } else {
               bufferBuilder.vertex(matrix4f, -cos * 120.0F, cos * 40.0F * rawColor[3], sin * 120.0F).color(red, green, blue, 0).endVertex();
            }
         }

         BufferUploader.drawWithShader(bufferBuilder.end());
      }
   }

   public static void renderTexture(float size, float yaw, float pitch, float roll, int color, boolean constant) {
      float r = size / 2.0F;
      float alpha = (float)(color >>> 24) / 255.0F;
      if (!constant) {
         alpha *= 1.0F - Minecraft.getInstance().level.getRainLevel(partialTick);
      }

      poseStack.pushPose();
      poseStack.mulPose(Axis.YN.rotationDegrees(yaw));
      poseStack.mulPose(Axis.XP.rotationDegrees(pitch));
      poseStack.mulPose(Axis.ZN.rotationDegrees(roll));
      Matrix4f matrix4f = poseStack.last().pose();
      RenderSystem.setShaderColor((float)(color >> 16 & 0xFF) / 255.0F, (float)(color >> 8 & 0xFF) / 255.0F, (float)(color & 0xFF) / 255.0F, alpha);
      RenderSystem.setShader(GameRenderer::getPositionTexShader);
      BufferBuilder bufferBuilder = Tesselator.getInstance().getBuilder();
      bufferBuilder.begin(Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
      bufferBuilder.vertex(matrix4f, r, r, 100.0F).uv(0.0F, 0.0F).endVertex();
      bufferBuilder.vertex(matrix4f, r, -r, 100.0F).uv(0.0F, 1.0F).endVertex();
      bufferBuilder.vertex(matrix4f, -r, -r, 100.0F).uv(1.0F, 1.0F).endVertex();
      bufferBuilder.vertex(matrix4f, -r, r, 100.0F).uv(1.0F, 0.0F).endVertex();
      BufferUploader.drawWithShader(bufferBuilder.end());
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      poseStack.popPose();
   }

   @SubscribeEvent
   public static void skySetup(FMLClientSetupEvent event) {
      try {
         Field field = DimensionSpecialEffectsManager.class.getDeclaredField("EFFECTS");
         field.setAccessible(true);
         UnmodifiableIterator var2 = ((ImmutableMap)field.get(null)).values().iterator();

         while (var2.hasNext()) {
            DimensionSpecialEffects dimensionSpecialEffects = (DimensionSpecialEffects)var2.next();
            Class<?> effects = dimensionSpecialEffects.getClass();
            ((Set)effects.getField("CUSTOM_SKY").get(null)).add(PREDICATE);
         }
      } catch (Exception var5) {
      }
   }

   public static void execute() {
      execute(null);
   }

   private static void execute(@Nullable Event event) {
      boolean entity_found = false;
      boolean disabled = false;
      double i = 0.0;
      double j = 0.0;
      double k = 0.0;
      double l = 0.0;
      double spheresize = 0.0;
      double col_r = 0.0;
      double col_g = 0.0;
      double col_b = 0.0;
      double negx = 0.0;
      double posx = 0.0;
      double negz = 0.0;
      double posz = 0.0;
      double stretch1 = 0.0;
      double stretch2 = 0.0;
      double pitch_variance = 0.0;
      double distance_scaling_factor = 0.0;
      double yaw_variance = 0.0;
      double convert_yaw = 0.0;
      double ringspan = 0.0;
      double raytrace_distance = 0.0;
      double newpositionz = 0.0;
      double newpositiony = 0.0;
      double ringspin = 0.0;
      double newpositionx = 0.0;
      double pitch_distance_variance = 0.0;
      double distance = 0.0;
      double yaw_distance_variance = 0.0;
      double expand = 0.0;
      double y_offset = 0.0;
      double xfind = 0.0;
      double yfind = 0.0;
      double zfind = 0.0;
      double opacity = 0.0;
      double expandsearch = 0.0;
      double distance_level = 0.0;
      double save_alpha = 0.0;
   }
}
