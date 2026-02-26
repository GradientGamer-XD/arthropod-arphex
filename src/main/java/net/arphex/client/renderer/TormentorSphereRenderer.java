package net.arphex.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.arphex.entity.TormentorSphereEntity;
import net.arphex.entity.layer.TormentorSphereLayer;
import net.arphex.entity.model.TormentorSphereModel;
import net.arphex.procedures.TormentorSphereEntityVisualScaleProcedure;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TormentorSphereRenderer extends GeoEntityRenderer<TormentorSphereEntity> {
   public TormentorSphereRenderer(Context renderManager) {
      super(renderManager, new TormentorSphereModel());
      this.shadowRadius = 0.0F;
      this.addRenderLayer(new TormentorSphereLayer(this));
   }

   public RenderType getRenderType(TormentorSphereEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      TormentorSphereEntity entity,
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
      float scale = (float)TormentorSphereEntityVisualScaleProcedure.execute(entity);
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public boolean shouldRender(TormentorSphereEntity entity, Frustum camera, double camX, double camY, double camZ) {
      return true;
   }
}
