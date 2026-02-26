package net.arphex.entity.model;

import net.arphex.entity.SpiderObstructerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SpiderObstructerModel extends GeoModel<SpiderObstructerEntity> {
   public ResourceLocation getAnimationResource(SpiderObstructerEntity entity) {
      return new ResourceLocation("arphex", "animations/spiderobstructer.animation.json");
   }

   public ResourceLocation getModelResource(SpiderObstructerEntity entity) {
      return new ResourceLocation("arphex", "geo/spiderobstructer.geo.json");
   }

   public ResourceLocation getTextureResource(SpiderObstructerEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
