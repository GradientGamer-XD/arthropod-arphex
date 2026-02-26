package net.arphex.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.arphex.entity.TormentorVoidlasherSummonEntity;
import net.arphex.entity.layer.TormentorVoidlasherSummonLayer;
import net.arphex.entity.model.TormentorVoidlasherSummonModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TormentorVoidlasherSummonRenderer extends GeoEntityRenderer<TormentorVoidlasherSummonEntity> {
   public TormentorVoidlasherSummonRenderer(Context renderManager) {
      super(renderManager, new TormentorVoidlasherSummonModel());
      this.shadowRadius = 3.0F;
      this.addRenderLayer(new TormentorVoidlasherSummonLayer(this));
   }

   public RenderType getRenderType(TormentorVoidlasherSummonEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      TormentorVoidlasherSummonEntity entity,
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
      float scale = 50.0F;
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(TormentorVoidlasherSummonEntity entityLivingBaseIn) {
      return 0.0F;
   }

   public boolean shouldRender(TormentorVoidlasherSummonEntity entity, Frustum camera, double camX, double camY, double camZ) {
      return true;
   }
}
