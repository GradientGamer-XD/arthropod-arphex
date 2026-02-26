package net.arphex.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.arphex.entity.ArachnoidShadowCloneEntity;
import net.arphex.entity.layer.ArachnoidShadowCloneLayer;
import net.arphex.entity.model.ArachnoidShadowCloneModel;
import net.arphex.procedures.ArachnoidShadowScaleProcedure;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ArachnoidShadowCloneRenderer extends GeoEntityRenderer<ArachnoidShadowCloneEntity> {
   public ArachnoidShadowCloneRenderer(Context renderManager) {
      super(renderManager, new ArachnoidShadowCloneModel());
      this.shadowRadius = 2.0F;
      this.addRenderLayer(new ArachnoidShadowCloneLayer(this));
   }

   public RenderType getRenderType(ArachnoidShadowCloneEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      ArachnoidShadowCloneEntity entity,
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
      float scale = (float)ArachnoidShadowScaleProcedure.execute(world);
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(ArachnoidShadowCloneEntity entityLivingBaseIn) {
      return 0.0F;
   }
}
