package net.arphex.entity.model;

import net.arphex.entity.SpiderLarvaeTinyEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SpiderLarvaeTinyModel extends GeoModel<SpiderLarvaeTinyEntity> {
   public ResourceLocation getAnimationResource(SpiderLarvaeTinyEntity entity) {
      return new ResourceLocation("arphex", "animations/spiderlarvae.animation.json");
   }

   public ResourceLocation getModelResource(SpiderLarvaeTinyEntity entity) {
      return new ResourceLocation("arphex", "geo/spiderlarvae.geo.json");
   }

   public ResourceLocation getTextureResource(SpiderLarvaeTinyEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
