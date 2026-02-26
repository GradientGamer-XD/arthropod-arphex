package net.arphex.entity.model;

import net.arphex.entity.SpiderInfestorEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SpiderInfestorModel extends GeoModel<SpiderInfestorEntity> {
   public ResourceLocation getAnimationResource(SpiderInfestorEntity entity) {
      return new ResourceLocation("arphex", "animations/spider_infestor.animation.json");
   }

   public ResourceLocation getModelResource(SpiderInfestorEntity entity) {
      return new ResourceLocation("arphex", "geo/spider_infestor.geo.json");
   }

   public ResourceLocation getTextureResource(SpiderInfestorEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
