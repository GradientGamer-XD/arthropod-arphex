package net.arphex.entity.model;

import net.arphex.entity.SpiderSinkerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SpiderSinkerModel extends GeoModel<SpiderSinkerEntity> {
   public ResourceLocation getAnimationResource(SpiderSinkerEntity entity) {
      return new ResourceLocation("arphex", "animations/spider_wolf.animation.json");
   }

   public ResourceLocation getModelResource(SpiderSinkerEntity entity) {
      return new ResourceLocation("arphex", "geo/spider_wolf.geo.json");
   }

   public ResourceLocation getTextureResource(SpiderSinkerEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
