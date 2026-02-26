package net.arphex.entity.model;

import net.arphex.entity.SilverfishSpectreEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SilverfishSpectreModel extends GeoModel<SilverfishSpectreEntity> {
   public ResourceLocation getAnimationResource(SilverfishSpectreEntity entity) {
      return new ResourceLocation("arphex", "animations/silverfishspectre.animation.json");
   }

   public ResourceLocation getModelResource(SilverfishSpectreEntity entity) {
      return new ResourceLocation("arphex", "geo/silverfishspectre.geo.json");
   }

   public ResourceLocation getTextureResource(SilverfishSpectreEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
