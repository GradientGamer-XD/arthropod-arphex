package net.arphex.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.arphex.entity.BlockTestEntity;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;

public class BlockTestRenderer extends HumanoidMobRenderer<BlockTestEntity, HumanoidModel<BlockTestEntity>> {
   public BlockTestRenderer(Context context) {
      super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.0F);
      this.addLayer(
         new HumanoidArmorLayer(
            this,
            new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
            new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)),
            context.getModelManager()
         )
      );
   }

   protected void scale(BlockTestEntity entity, PoseStack poseStack, float f) {
      poseStack.scale(1.6F, 1.6F, 1.6F);
   }

   public ResourceLocation getTextureLocation(BlockTestEntity entity) {
      return new ResourceLocation("arphex:textures/entities/invisible.png");
   }
}
