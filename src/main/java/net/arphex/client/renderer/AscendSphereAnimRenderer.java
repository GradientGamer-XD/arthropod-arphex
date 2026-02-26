package net.arphex.client.renderer;

import net.arphex.client.model.ModelSpiderMothEntity;
import net.arphex.entity.AscendSphereAnimEntity;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public class AscendSphereAnimRenderer extends MobRenderer<AscendSphereAnimEntity, ModelSpiderMothEntity<AscendSphereAnimEntity>> {
   public AscendSphereAnimRenderer(Context context) {
      super(context, new ModelSpiderMothEntity(context.bakeLayer(ModelSpiderMothEntity.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(AscendSphereAnimEntity entity) {
      return new ResourceLocation("arphex:textures/entities/invisible.png");
   }
}
