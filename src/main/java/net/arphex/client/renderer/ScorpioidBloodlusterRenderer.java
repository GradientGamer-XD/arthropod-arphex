package net.arphex.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.arphex.entity.ScorpioidBloodlusterEntity;
import net.arphex.entity.layer.ScorpioidBloodlusterLayer;
import net.arphex.entity.model.ScorpioidBloodlusterModel;
import net.arphex.procedures.ScorpioidBloodlusterEntityVisualScaleProcedure;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ScorpioidBloodlusterRenderer extends GeoEntityRenderer<ScorpioidBloodlusterEntity> {
   public ScorpioidBloodlusterRenderer(Context renderManager) {
      super(renderManager, new ScorpioidBloodlusterModel());
      this.shadowRadius = 2.0F;
      this.addRenderLayer(new ScorpioidBloodlusterLayer(this));
   }

   public RenderType getRenderType(ScorpioidBloodlusterEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      ScorpioidBloodlusterEntity entity,
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
      float scale = (float)ScorpioidBloodlusterEntityVisualScaleProcedure.execute(entity);
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(ScorpioidBloodlusterEntity entityLivingBaseIn) {
      return 0.0F;
   }
}
