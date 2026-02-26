package net.arphex.entity.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.arphex.entity.TamedTarantulaEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class TamedTarantulaLayer extends GeoRenderLayer<TamedTarantulaEntity> {
   private static ResourceLocation getLayer(TamedTarantulaEntity animatable) {
      String glow = animatable.getPersistentData().getString("glowTexture");
      if (glow == null || glow.isEmpty()) {
         glow = "spiderlarvaeglow";
      }

      return new ResourceLocation("arphex", "textures/entities/" + glow + ".png");
   }

   public TamedTarantulaLayer(GeoRenderer<TamedTarantulaEntity> entityRenderer) {
      super(entityRenderer);
   }

   public void render(
      PoseStack poseStack,
      TamedTarantulaEntity animatable,
      BakedGeoModel bakedModel,
      RenderType renderType,
      MultiBufferSource bufferSource,
      VertexConsumer buffer,
      float partialTick,
      int packedLight,
      int packedOverlay
   ) {
      RenderType glowRenderType = RenderType.eyes(getLayer(animatable));
      this.getRenderer()
         .reRender(
            this.getDefaultBakedModel(animatable),
            poseStack,
            bufferSource,
            animatable,
            glowRenderType,
            bufferSource.getBuffer(glowRenderType),
            partialTick,
            packedLight,
            OverlayTexture.NO_OVERLAY,
            1.0F,
            1.0F,
            1.0F,
            1.0F
         );
   }
}
