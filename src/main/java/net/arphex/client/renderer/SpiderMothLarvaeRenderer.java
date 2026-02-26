package net.arphex.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.arphex.entity.SpiderMothLarvaeEntity;
import net.arphex.entity.layer.SpiderMothLarvaeLayer;
import net.arphex.entity.model.SpiderMothLarvaeModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SpiderMothLarvaeRenderer extends GeoEntityRenderer<SpiderMothLarvaeEntity> {
   public SpiderMothLarvaeRenderer(Context renderManager) {
      super(renderManager, new SpiderMothLarvaeModel());
      this.shadowRadius = 0.6F;
      this.addRenderLayer(new SpiderMothLarvaeLayer(this));
   }

   public RenderType getRenderType(SpiderMothLarvaeEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      SpiderMothLarvaeEntity entity,
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

   protected float getDeathMaxRotation(SpiderMothLarvaeEntity entityLivingBaseIn) {
      return 0.0F;
   }
}
