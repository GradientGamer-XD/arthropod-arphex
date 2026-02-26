package net.arphex.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.arphex.entity.SolifugeSkulkerEntity;
import net.arphex.entity.layer.SolifugeSkulkerLayer;
import net.arphex.entity.model.SolifugeSkulkerModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SolifugeSkulkerRenderer extends GeoEntityRenderer<SolifugeSkulkerEntity> {
   public SolifugeSkulkerRenderer(Context renderManager) {
      super(renderManager, new SolifugeSkulkerModel());
      this.shadowRadius = 0.5F;
      this.addRenderLayer(new SolifugeSkulkerLayer(this));
   }

   public RenderType getRenderType(SolifugeSkulkerEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      SolifugeSkulkerEntity entity,
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
      float scale = 5.0F;
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(SolifugeSkulkerEntity entityLivingBaseIn) {
      return 0.0F;
   }
}
