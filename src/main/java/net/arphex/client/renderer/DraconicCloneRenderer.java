package net.arphex.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.arphex.entity.DraconicCloneEntity;
import net.arphex.entity.layer.DraconicCloneLayer;
import net.arphex.entity.model.DraconicCloneModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DraconicCloneRenderer extends GeoEntityRenderer<DraconicCloneEntity> {
   public DraconicCloneRenderer(Context renderManager) {
      super(renderManager, new DraconicCloneModel());
      this.shadowRadius = 3.0F;
      this.addRenderLayer(new DraconicCloneLayer(this));
   }

   public RenderType getRenderType(DraconicCloneEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      DraconicCloneEntity entity,
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

   protected float getDeathMaxRotation(DraconicCloneEntity entityLivingBaseIn) {
      return 0.0F;
   }
}
