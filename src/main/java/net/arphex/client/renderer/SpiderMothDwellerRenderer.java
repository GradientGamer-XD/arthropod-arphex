package net.arphex.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.arphex.entity.SpiderMothDwellerEntity;
import net.arphex.entity.layer.SpiderMothDwellerLayer;
import net.arphex.entity.model.SpiderMothDwellerModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SpiderMothDwellerRenderer extends GeoEntityRenderer<SpiderMothDwellerEntity> {
   public SpiderMothDwellerRenderer(Context renderManager) {
      super(renderManager, new SpiderMothDwellerModel());
      this.shadowRadius = 3.0F;
      this.addRenderLayer(new SpiderMothDwellerLayer(this));
   }

   public RenderType getRenderType(SpiderMothDwellerEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      SpiderMothDwellerEntity entity,
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
      float scale = 7.5F;
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(SpiderMothDwellerEntity entityLivingBaseIn) {
      return 0.0F;
   }

   public boolean shouldRender(SpiderMothDwellerEntity entity, Frustum camera, double camX, double camY, double camZ) {
      return true;
   }
}
