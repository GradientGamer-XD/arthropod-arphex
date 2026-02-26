package net.arphex.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.arphex.entity.ArachnoidTrisectorEntity;
import net.arphex.entity.layer.ArachnoidTrisectorLayer;
import net.arphex.entity.model.ArachnoidTrisectorModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ArachnoidTrisectorRenderer extends GeoEntityRenderer<ArachnoidTrisectorEntity> {
   public ArachnoidTrisectorRenderer(Context renderManager) {
      super(renderManager, new ArachnoidTrisectorModel());
      this.shadowRadius = 8.0F;
      this.addRenderLayer(new ArachnoidTrisectorLayer(this));
   }

   public RenderType getRenderType(ArachnoidTrisectorEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      ArachnoidTrisectorEntity entity,
      BakedGeoModel model,
      MultiBufferSource bufferSource,
      VertexConsumer buffer,
      boolean isReRender,
      float partialTick,
      int packedLight,
      int packedOverlay,
      float red,
      float green,
      float blue,
      float alpha
   ) {
      float scale = 7.0F;
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(ArachnoidTrisectorEntity entityLivingBaseIn) {
      return 0.0F;
   }

   public boolean shouldRender(ArachnoidTrisectorEntity entity, Frustum camera, double camX, double camY, double camZ) {
      return true;
   }
}
