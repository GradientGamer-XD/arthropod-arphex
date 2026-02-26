package net.arphex.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.arphex.entity.SpiderRecluseDisplayEntity;
import net.arphex.entity.layer.SpiderRecluseDisplayLayer;
import net.arphex.entity.model.SpiderRecluseDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SpiderRecluseDisplayRenderer extends GeoEntityRenderer<SpiderRecluseDisplayEntity> {
   public SpiderRecluseDisplayRenderer(Context renderManager) {
      super(renderManager, new SpiderRecluseDisplayModel());
      this.shadowRadius = 0.0F;
      this.addRenderLayer(new SpiderRecluseDisplayLayer(this));
   }

   public RenderType getRenderType(SpiderRecluseDisplayEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      SpiderRecluseDisplayEntity entity,
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
      float scale = 3.3F;
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(SpiderRecluseDisplayEntity entityLivingBaseIn) {
      return 0.0F;
   }
}
