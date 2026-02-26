package net.arphex.entity.model;

import net.arphex.entity.SpiderLarvaeEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SpiderLarvaeModel extends GeoModel<SpiderLarvaeEntity> {
   public ResourceLocation getAnimationResource(SpiderLarvaeEntity entity) {
      return new ResourceLocation("arphex", "animations/spiderlarvae.animation.json");
   }

   public ResourceLocation getModelResource(SpiderLarvaeEntity entity) {
      return new ResourceLocation("arphex", "geo/spiderlarvae.geo.json");
   }

   public ResourceLocation getTextureResource(SpiderLarvaeEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
