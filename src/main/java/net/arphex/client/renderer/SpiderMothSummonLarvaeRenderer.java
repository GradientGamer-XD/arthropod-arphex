package net.arphex.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.arphex.entity.SpiderMothSummonLarvaeEntity;
import net.arphex.entity.layer.SpiderMothSummonLarvaeLayer;
import net.arphex.entity.model.SpiderMothSummonLarvaeModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SpiderMothSummonLarvaeRenderer extends GeoEntityRenderer<SpiderMothSummonLarvaeEntity> {
   public SpiderMothSummonLarvaeRenderer(Context renderManager) {
      super(renderManager, new SpiderMothSummonLarvaeModel());
      this.shadowRadius = 0.6F;
      this.addRenderLayer(new SpiderMothSummonLarvaeLayer(this));
   }

   public RenderType getRenderType(SpiderMothSummonLarvaeEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      SpiderMothSummonLarvaeEntity entity,
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
      float scale = 0.45F;
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(SpiderMothSummonLarvaeEntity entityLivingBaseIn) {
      return 0.0F;
   }
}
