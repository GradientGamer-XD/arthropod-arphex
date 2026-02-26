package net.arphex.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.arphex.entity.DiabolosDecimatorCloneEntity;
import net.arphex.entity.layer.DiabolosDecimatorCloneLayer;
import net.arphex.entity.model.DiabolosDecimatorCloneModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DiabolosDecimatorCloneRenderer extends GeoEntityRenderer<DiabolosDecimatorCloneEntity> {
   public DiabolosDecimatorCloneRenderer(Context renderManager) {
      super(renderManager, new DiabolosDecimatorCloneModel());
      this.shadowRadius = 8.0F;
      this.addRenderLayer(new DiabolosDecimatorCloneLayer(this));
   }

   public RenderType getRenderType(DiabolosDecimatorCloneEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      DiabolosDecimatorCloneEntity entity,
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
      float scale = 10.0F;
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(DiabolosDecimatorCloneEntity entityLivingBaseIn) {
      return 0.0F;
   }
}
