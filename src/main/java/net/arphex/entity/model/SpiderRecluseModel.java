package net.arphex.entity.model;

import net.arphex.entity.SpiderRecluseEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SpiderRecluseModel extends GeoModel<SpiderRecluseEntity> {
   public ResourceLocation getAnimationResource(SpiderRecluseEntity entity) {
      return new ResourceLocation("arphex", "animations/spider_recluse.animation.json");
   }

   public ResourceLocation getModelResource(SpiderRecluseEntity entity) {
      return new ResourceLocation("arphex", "geo/spider_recluse.geo.json");
   }

   public ResourceLocation getTextureResource(SpiderRecluseEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
