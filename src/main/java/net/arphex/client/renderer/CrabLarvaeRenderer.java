package net.arphex.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.arphex.entity.CrabLarvaeEntity;
import net.arphex.entity.layer.CrabLarvaeLayer;
import net.arphex.entity.model.CrabLarvaeModel;
import net.arphex.procedures.CrabLarvaeEntityVisualScaleProcedure;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CrabLarvaeRenderer extends GeoEntityRenderer<CrabLarvaeEntity> {
   public CrabLarvaeRenderer(Context renderManager) {
      super(renderManager, new CrabLarvaeModel());
      this.shadowRadius = 1.2F;
      this.addRenderLayer(new CrabLarvaeLayer(this));
   }

   public RenderType getRenderType(CrabLarvaeEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      CrabLarvaeEntity entity,
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
      float scale = (float)CrabLarvaeEntityVisualScaleProcedure.execute(entity);
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(CrabLarvaeEntity entityLivingBaseIn) {
      return 0.0F;
   }

   public boolean shouldRender(CrabLarvaeEntity entity, Frustum camera, double camX, double camY, double camZ) {
      return true;
   }
}
