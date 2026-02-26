package net.arphex.entity.model;

import net.arphex.entity.SpiderProwlerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SpiderProwlerModel extends GeoModel<SpiderProwlerEntity> {
   public ResourceLocation getAnimationResource(SpiderProwlerEntity entity) {
      return new ResourceLocation("arphex", "animations/spiderwander.animation.json");
   }

   public ResourceLocation getModelResource(SpiderProwlerEntity entity) {
      return new ResourceLocation("arphex", "geo/spiderwander.geo.json");
   }

   public ResourceLocation getTextureResource(SpiderProwlerEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
