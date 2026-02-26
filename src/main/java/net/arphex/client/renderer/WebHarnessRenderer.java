package net.arphex.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.arphex.entity.WebHarnessEntity;
import net.minecraft.client.model.CodModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public class WebHarnessRenderer extends MobRenderer<WebHarnessEntity, CodModel<WebHarnessEntity>> {
   public WebHarnessRenderer(Context context) {
      super(context, new CodModel(context.bakeLayer(ModelLayers.COD)), 0.0F);
   }

   protected void scale(WebHarnessEntity entity, PoseStack poseStack, float f) {
      poseStack.scale(0.5F, 0.5F, 0.5F);
   }

   public ResourceLocation getTextureLocation(WebHarnessEntity entity) {
      return new ResourceLocation("arphex:textures/entities/invisible.png");
   }
}
