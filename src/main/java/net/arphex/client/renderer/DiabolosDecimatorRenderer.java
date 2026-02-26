package net.arphex.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.arphex.entity.DiabolosDecimatorEntity;
import net.arphex.entity.layer.DiabolosDecimatorLayer;
import net.arphex.entity.model.DiabolosDecimatorModel;
import net.arphex.procedures.DiabolosSizeProcedure;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DiabolosDecimatorRenderer extends GeoEntityRenderer<DiabolosDecimatorEntity> {
   public DiabolosDecimatorRenderer(Context renderManager) {
      super(renderManager, new DiabolosDecimatorModel());
      this.shadowRadius = 8.0F;
      this.addRenderLayer(new DiabolosDecimatorLayer(this));
   }

   public RenderType getRenderType(DiabolosDecimatorEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      DiabolosDecimatorEntity entity,
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
      Level world = entity.level();
      double x = entity.getX();
      double y = entity.getY();
      double z = entity.getZ();
      float scale = (float)DiabolosSizeProcedure.execute(entity);
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(DiabolosDecimatorEntity entityLivingBaseIn) {
      return 0.0F;
   }

   public boolean shouldRender(DiabolosDecimatorEntity entity, Frustum camera, double camX, double camY, double camZ) {
      return true;
   }
}
