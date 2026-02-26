package net.arphex.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.arphex.entity.DwellerSleepSpawnerEntity;
import net.arphex.entity.layer.DwellerSleepSpawnerLayer;
import net.arphex.entity.model.DwellerSleepSpawnerModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DwellerSleepSpawnerRenderer extends GeoEntityRenderer<DwellerSleepSpawnerEntity> {
   public DwellerSleepSpawnerRenderer(Context renderManager) {
      super(renderManager, new DwellerSleepSpawnerModel());
      this.shadowRadius = 2.0F;
      this.addRenderLayer(new DwellerSleepSpawnerLayer(this));
   }

   public RenderType getRenderType(DwellerSleepSpawnerEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      DwellerSleepSpawnerEntity entity,
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
      float scale = 1.7F;
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }
}
