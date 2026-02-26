package net.arphex.entity.model;

import net.arphex.entity.SpiderBroodEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SpiderBroodModel extends GeoModel<SpiderBroodEntity> {
   public ResourceLocation getAnimationResource(SpiderBroodEntity entity) {
      return new ResourceLocation("arphex", "animations/spiderbrood.animation.json");
   }

   public ResourceLocation getModelResource(SpiderBroodEntity entity) {
      return new ResourceLocation("arphex", "geo/spiderbrood.geo.json");
   }

   public ResourceLocation getTextureResource(SpiderBroodEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
