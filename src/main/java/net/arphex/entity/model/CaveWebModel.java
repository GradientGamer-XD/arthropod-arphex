package net.arphex.entity.model;

import net.arphex.entity.CaveWebEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CaveWebModel extends GeoModel<CaveWebEntity> {
   public ResourceLocation getAnimationResource(CaveWebEntity entity) {
      return new ResourceLocation("arphex", "animations/caveweb.animation.json");
   }

   public ResourceLocation getModelResource(CaveWebEntity entity) {
      return new ResourceLocation("arphex", "geo/caveweb.geo.json");
   }

   public ResourceLocation getTextureResource(CaveWebEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
