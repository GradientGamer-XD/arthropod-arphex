package net.arphex.client.renderer;

import net.arphex.entity.AiToRideEntity;
import net.minecraft.client.model.SlimeModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public class AiToRideRenderer extends MobRenderer<AiToRideEntity, SlimeModel<AiToRideEntity>> {
   public AiToRideRenderer(Context context) {
      super(context, new SlimeModel(context.bakeLayer(ModelLayers.SLIME)), 0.5F);
   }

   public ResourceLocation getTextureLocation(AiToRideEntity entity) {
      return new ResourceLocation("arphex:textures/entities/invisible.png");
   }
}
