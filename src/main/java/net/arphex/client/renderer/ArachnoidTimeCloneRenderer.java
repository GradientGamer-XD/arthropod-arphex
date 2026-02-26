package net.arphex.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.arphex.entity.ArachnoidTimeCloneEntity;
import net.arphex.entity.layer.ArachnoidTimeCloneLayer;
import net.arphex.entity.model.ArachnoidTimeCloneModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ArachnoidTimeCloneRenderer extends GeoEntityRenderer<ArachnoidTimeCloneEntity> {
   public ArachnoidTimeCloneRenderer(Context renderManager) {
      super(renderManager, new ArachnoidTimeCloneModel());
      this.shadowRadius = 8.0F;
      this.addRenderLayer(new ArachnoidTimeCloneLayer(this));
   }

   public RenderType getRenderType(ArachnoidTimeCloneEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      ArachnoidTimeCloneEntity entity,
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

   protected float getDeathMaxRotation(ArachnoidTimeCloneEntity entityLivingBaseIn) {
      return 0.0F;
   }
}
