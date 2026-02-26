package net.arphex.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.arphex.entity.GiantEnemySpiderEntity;
import net.arphex.entity.layer.GiantEnemySpiderLayer;
import net.arphex.entity.model.GiantEnemySpiderModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GiantEnemySpiderRenderer extends GeoEntityRenderer<GiantEnemySpiderEntity> {
   public GiantEnemySpiderRenderer(Context renderManager) {
      super(renderManager, new GiantEnemySpiderModel());
      this.shadowRadius = 1.0F;
      this.addRenderLayer(new GiantEnemySpiderLayer(this));
   }

   public RenderType getRenderType(GiantEnemySpiderEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      GiantEnemySpiderEntity entity,
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
      float scale = 20.0F;
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(GiantEnemySpiderEntity entityLivingBaseIn) {
      return 0.0F;
   }
}
