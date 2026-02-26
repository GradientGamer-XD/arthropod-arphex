package net.arphex.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.arphex.entity.TamedTarantulaEntity;
import net.arphex.entity.layer.TamedTarantulaLayer;
import net.arphex.entity.model.TamedTarantulaModel;
import net.arphex.procedures.TamedTarantulaScaleProcedure;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TamedTarantulaRenderer extends GeoEntityRenderer<TamedTarantulaEntity> {
   public TamedTarantulaRenderer(Context renderManager) {
      super(renderManager, new TamedTarantulaModel());
      this.shadowRadius = 1.3F;
      this.addRenderLayer(new TamedTarantulaLayer(this));
   }

   public RenderType getRenderType(TamedTarantulaEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      TamedTarantulaEntity entity,
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
      float scale = (float)TamedTarantulaScaleProcedure.execute(entity);
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(TamedTarantulaEntity entityLivingBaseIn) {
      return 0.0F;
   }
}
