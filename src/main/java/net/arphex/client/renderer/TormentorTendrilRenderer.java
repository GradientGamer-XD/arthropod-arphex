package net.arphex.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.arphex.entity.TormentorTendrilEntity;
import net.minecraft.client.model.SlimeModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public class TormentorTendrilRenderer extends MobRenderer<TormentorTendrilEntity, SlimeModel<TormentorTendrilEntity>> {
   public TormentorTendrilRenderer(Context context) {
      super(context, new SlimeModel(context.bakeLayer(ModelLayers.SLIME)), 0.5F);
   }

   protected void scale(TormentorTendrilEntity entity, PoseStack poseStack, float f) {
      poseStack.scale(3.3F, 3.3F, 3.3F);
   }

   public ResourceLocation getTextureLocation(TormentorTendrilEntity entity) {
      return new ResourceLocation("arphex:textures/entities/black.png");
   }
}
