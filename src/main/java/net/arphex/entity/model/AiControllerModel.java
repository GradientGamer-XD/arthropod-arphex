package net.arphex.entity.model;

import net.arphex.entity.AiControllerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AiControllerModel extends GeoModel<AiControllerEntity> {
   public ResourceLocation getAnimationResource(AiControllerEntity entity) {
      return new ResourceLocation("arphex", "animations/minisphere.animation.json");
   }

   public ResourceLocation getModelResource(AiControllerEntity entity) {
      return new ResourceLocation("arphex", "geo/minisphere.geo.json");
   }

   public ResourceLocation getTextureResource(AiControllerEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
