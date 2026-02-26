package net.arphex.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.arphex.entity.SpiderMatriarchEntity;
import net.arphex.entity.layer.SpiderMatriarchLayer;
import net.arphex.entity.model.SpiderMatriarchModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SpiderMatriarchRenderer extends GeoEntityRenderer<SpiderMatriarchEntity> {
   public SpiderMatriarchRenderer(Context renderManager) {
      super(renderManager, new SpiderMatriarchModel());
      this.shadowRadius = 2.0F;
      this.addRenderLayer(new SpiderMatriarchLayer(this));
   }

   public RenderType getRenderType(SpiderMatriarchEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      SpiderMatriarchEntity entity,
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
      float scale = 15.0F;
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(SpiderMatriarchEntity entityLivingBaseIn) {
      return 0.0F;
   }

   public boolean shouldRender(SpiderMatriarchEntity entity, Frustum camera, double camX, double camY, double camZ) {
      return true;
   }
}
