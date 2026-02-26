package net.arphex.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.arphex.client.model.ModelSpiderMothEntity;
import net.arphex.entity.TeleportGhostEntity;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public class TeleportGhostRenderer extends MobRenderer<TeleportGhostEntity, ModelSpiderMothEntity<TeleportGhostEntity>> {
   public TeleportGhostRenderer(Context context) {
      super(context, new ModelSpiderMothEntity(context.bakeLayer(ModelSpiderMothEntity.LAYER_LOCATION)), 0.5F);
   }

   protected void scale(TeleportGhostEntity entity, PoseStack poseStack, float f) {
      poseStack.scale(0.6F, 0.6F, 0.6F);
   }

   public ResourceLocation getTextureLocation(TeleportGhostEntity entity) {
      return new ResourceLocation("arphex:textures/entities/horrormothlowhealthfixed.png");
   }

   protected boolean isBodyVisible(TeleportGhostEntity entity) {
      return false;
   }

   protected boolean isShaking(TeleportGhostEntity entity) {
      return true;
   }
}
