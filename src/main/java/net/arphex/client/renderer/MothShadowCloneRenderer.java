package net.arphex.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.arphex.entity.MothShadowCloneEntity;
import net.arphex.entity.model.MothShadowCloneModel;
import net.arphex.procedures.MothShadowCloneEntityVisualScaleProcedure;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MothShadowCloneRenderer extends GeoEntityRenderer<MothShadowCloneEntity> {
   public MothShadowCloneRenderer(Context renderManager) {
      super(renderManager, new MothShadowCloneModel());
      this.shadowRadius = 2.0F;
   }

   public RenderType getRenderType(MothShadowCloneEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      MothShadowCloneEntity entity,
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
      float scale = (float)MothShadowCloneEntityVisualScaleProcedure.execute(world);
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(MothShadowCloneEntity entityLivingBaseIn) {
      return 0.0F;
   }

   public boolean shouldRender(MothShadowCloneEntity entity, Frustum camera, double camX, double camY, double camZ) {
      return true;
   }
}
