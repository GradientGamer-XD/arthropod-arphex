package net.arphex.entity.model;

import net.arphex.entity.SpiderAmbusherEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SpiderAmbusherModel extends GeoModel<SpiderAmbusherEntity> {
   public ResourceLocation getAnimationResource(SpiderAmbusherEntity entity) {
      return new ResourceLocation("arphex", "animations/spider_ambusher.animation.json");
   }

   public ResourceLocation getModelResource(SpiderAmbusherEntity entity) {
      return new ResourceLocation("arphex", "geo/spider_ambusher.geo.json");
   }

   public ResourceLocation getTextureResource(SpiderAmbusherEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
