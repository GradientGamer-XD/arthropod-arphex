package net.arphex.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.arphex.entity.SmallTormentSphereEntity;
import net.arphex.entity.layer.SmallTormentSphereLayer;
import net.arphex.entity.model.SmallTormentSphereModel;
import net.arphex.procedures.SmallTormentSphereEntityVisualScaleProcedure;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SmallTormentSphereRenderer extends GeoEntityRenderer<SmallTormentSphereEntity> {
   public SmallTormentSphereRenderer(Context renderManager) {
      super(renderManager, new SmallTormentSphereModel());
      this.shadowRadius = 0.0F;
      this.addRenderLayer(new SmallTormentSphereLayer(this));
   }

   public RenderType getRenderType(SmallTormentSphereEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      SmallTormentSphereEntity entity,
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
      float scale = (float)SmallTormentSphereEntityVisualScaleProcedure.execute(entity);
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }
}
