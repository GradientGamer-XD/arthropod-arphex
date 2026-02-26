package net.arphex.entity.model;

import net.arphex.entity.SpiderMatriarchLarvaeEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SpiderMatriarchLarvaeModel extends GeoModel<SpiderMatriarchLarvaeEntity> {
   public ResourceLocation getAnimationResource(SpiderMatriarchLarvaeEntity entity) {
      return new ResourceLocation("arphex", "animations/spider_wolf.animation.json");
   }

   public ResourceLocation getModelResource(SpiderMatriarchLarvaeEntity entity) {
      return new ResourceLocation("arphex", "geo/spider_wolf.geo.json");
   }

   public ResourceLocation getTextureResource(SpiderMatriarchLarvaeEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
