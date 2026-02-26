package net.arphex.entity.model;

import net.arphex.entity.SpiderLungerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SpiderLungerModel extends GeoModel<SpiderLungerEntity> {
   public ResourceLocation getAnimationResource(SpiderLungerEntity entity) {
      return new ResourceLocation("arphex", "animations/spider_lunger.animation.json");
   }

   public ResourceLocation getModelResource(SpiderLungerEntity entity) {
      return new ResourceLocation("arphex", "geo/spider_lunger.geo.json");
   }

   public ResourceLocation getTextureResource(SpiderLungerEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
