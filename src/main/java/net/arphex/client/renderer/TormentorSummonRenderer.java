package net.arphex.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.arphex.entity.TormentorSummonEntity;
import net.arphex.entity.model.TormentorSummonModel;
import net.arphex.procedures.TormentorSummonScaleProcedure;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TormentorSummonRenderer extends GeoEntityRenderer<TormentorSummonEntity> {
   public TormentorSummonRenderer(Context renderManager) {
      super(renderManager, new TormentorSummonModel());
      this.shadowRadius = 0.0F;
   }

   public RenderType getRenderType(TormentorSummonEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      TormentorSummonEntity entity,
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
      float scale = (float)TormentorSummonScaleProcedure.execute(entity);
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(TormentorSummonEntity entityLivingBaseIn) {
      return 0.0F;
   }

   public boolean shouldRender(TormentorSummonEntity entity, Frustum frustum, double x, double y, double z) {
      return true;
   }

   public int getPackedOverlay(TormentorSummonEntity entity, float u) {
      return entity.hurtTime > 0 && entity.deathTime == 0 ? OverlayTexture.pack((float)OverlayTexture.u(u), true) : OverlayTexture.NO_OVERLAY;
   }
}
