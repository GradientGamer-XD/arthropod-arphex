package net.arphex.entity.model;

import net.arphex.entity.SpiderMatriarchEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SpiderMatriarchModel extends GeoModel<SpiderMatriarchEntity> {
   public ResourceLocation getAnimationResource(SpiderMatriarchEntity entity) {
      return new ResourceLocation("arphex", "animations/spider_wolf.animation.json");
   }

   public ResourceLocation getModelResource(SpiderMatriarchEntity entity) {
      return new ResourceLocation("arphex", "geo/spider_wolf.geo.json");
   }

   public ResourceLocation getTextureResource(SpiderMatriarchEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
