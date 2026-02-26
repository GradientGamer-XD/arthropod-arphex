package net.arphex.entity.model;

import net.arphex.entity.SpiderLurkerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SpiderLurkerModel extends GeoModel<SpiderLurkerEntity> {
   public ResourceLocation getAnimationResource(SpiderLurkerEntity entity) {
      return new ResourceLocation("arphex", "animations/spidersea.animation.json");
   }

   public ResourceLocation getModelResource(SpiderLurkerEntity entity) {
      return new ResourceLocation("arphex", "geo/spidersea.geo.json");
   }

   public ResourceLocation getTextureResource(SpiderLurkerEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
