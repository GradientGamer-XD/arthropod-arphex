package net.arphex.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.arphex.entity.CrabConstrictorEntity;
import net.arphex.entity.layer.CrabConstrictorLayer;
import net.arphex.entity.model.CrabConstrictorModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CrabConstrictorRenderer extends GeoEntityRenderer<CrabConstrictorEntity> {
   public CrabConstrictorRenderer(Context renderManager) {
      super(renderManager, new CrabConstrictorModel());
      this.shadowRadius = 4.0F;
      this.addRenderLayer(new CrabConstrictorLayer(this));
   }

   public RenderType getRenderType(CrabConstrictorEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      CrabConstrictorEntity entity,
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
      float scale = 12.5F;
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(CrabConstrictorEntity entityLivingBaseIn) {
      return 0.0F;
   }

   public boolean shouldRender(CrabConstrictorEntity entity, Frustum camera, double camX, double camY, double camZ) {
      return true;
   }
}
