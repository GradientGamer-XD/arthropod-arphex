package net.arphex.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.arphex.entity.EntropyConduitEntity;
import net.arphex.entity.layer.EntropyConduitLayer;
import net.arphex.entity.model.EntropyConduitModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class EntropyConduitRenderer extends GeoEntityRenderer<EntropyConduitEntity> {
   public EntropyConduitRenderer(Context renderManager) {
      super(renderManager, new EntropyConduitModel());
      this.shadowRadius = 0.5F;
      this.addRenderLayer(new EntropyConduitLayer(this));
   }

   public RenderType getRenderType(EntropyConduitEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      EntropyConduitEntity entity,
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

   protected float getDeathMaxRotation(EntropyConduitEntity entityLivingBaseIn) {
      return 0.0F;
   }
}
