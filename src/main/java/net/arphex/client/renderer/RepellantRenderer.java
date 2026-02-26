package net.arphex.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.arphex.entity.RepellantEntity;
import net.minecraft.client.model.SlimeModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public class RepellantRenderer extends MobRenderer<RepellantEntity, SlimeModel<RepellantEntity>> {
   public RepellantRenderer(Context context) {
      super(context, new SlimeModel(context.bakeLayer(ModelLayers.SLIME)), 0.0F);
   }

   protected void scale(RepellantEntity entity, PoseStack poseStack, float f) {
      poseStack.scale(0.1F, 0.1F, 0.1F);
   }

   public ResourceLocation getTextureLocation(RepellantEntity entity) {
      return new ResourceLocation("arphex:textures/entities/scorpioidglow.png");
   }
}
