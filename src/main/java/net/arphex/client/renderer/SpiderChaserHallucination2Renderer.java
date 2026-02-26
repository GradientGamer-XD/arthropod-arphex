package net.arphex.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.arphex.entity.SpiderChaserHallucination2Entity;
import net.arphex.entity.model.SpiderChaserHallucination2Model;
import net.arphex.procedures.ChaserScale2Procedure;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SpiderChaserHallucination2Renderer extends GeoEntityRenderer<SpiderChaserHallucination2Entity> {
   public SpiderChaserHallucination2Renderer(Context renderManager) {
      super(renderManager, new SpiderChaserHallucination2Model());
      this.shadowRadius = 0.5F;
   }

   public RenderType getRenderType(SpiderChaserHallucination2Entity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      SpiderChaserHallucination2Entity entity,
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
      float scale = (float)ChaserScale2Procedure.execute(entity);
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(SpiderChaserHallucination2Entity entityLivingBaseIn) {
      return 0.0F;
   }
}
