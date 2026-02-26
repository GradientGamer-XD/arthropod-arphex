package net.arphex.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.arphex.entity.WebHarnessDownEntity;
import net.minecraft.client.model.CodModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public class WebHarnessDownRenderer extends MobRenderer<WebHarnessDownEntity, CodModel<WebHarnessDownEntity>> {
   public WebHarnessDownRenderer(Context context) {
      super(context, new CodModel(context.bakeLayer(ModelLayers.COD)), 0.0F);
   }

   protected void scale(WebHarnessDownEntity entity, PoseStack poseStack, float f) {
      poseStack.scale(0.5F, 0.5F, 0.5F);
   }

   public ResourceLocation getTextureLocation(WebHarnessDownEntity entity) {
      return new ResourceLocation("arphex:textures/entities/invisible.png");
   }
}
