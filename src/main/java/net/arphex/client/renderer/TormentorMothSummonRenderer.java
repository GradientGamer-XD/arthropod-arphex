package net.arphex.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.arphex.entity.TormentorMothSummonEntity;
import net.arphex.entity.layer.TormentorMothSummonLayer;
import net.arphex.entity.model.TormentorMothSummonModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TormentorMothSummonRenderer extends GeoEntityRenderer<TormentorMothSummonEntity> {
   public TormentorMothSummonRenderer(Context renderManager) {
      super(renderManager, new TormentorMothSummonModel());
      this.shadowRadius = 3.0F;
      this.addRenderLayer(new TormentorMothSummonLayer(this));
   }

   public RenderType getRenderType(TormentorMothSummonEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      TormentorMothSummonEntity entity,
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
      float scale = 13.0F;
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(TormentorMothSummonEntity entityLivingBaseIn) {
      return 0.0F;
   }

   public boolean shouldRender(TormentorMothSummonEntity entity, Frustum camera, double camX, double camY, double camZ) {
      return true;
   }
}
