package net.arphex.client.renderer;

import net.arphex.client.model.ModelSpiderMothEntity;
import net.arphex.entity.SphereAnimEntity;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public class SphereAnimRenderer extends MobRenderer<SphereAnimEntity, ModelSpiderMothEntity<SphereAnimEntity>> {
   public SphereAnimRenderer(Context context) {
      super(context, new ModelSpiderMothEntity(context.bakeLayer(ModelSpiderMothEntity.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(SphereAnimEntity entity) {
      return new ResourceLocation("arphex:textures/entities/invisible.png");
   }
}
