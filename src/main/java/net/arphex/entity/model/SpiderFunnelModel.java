package net.arphex.entity.model;

import net.arphex.entity.SpiderFunnelEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SpiderFunnelModel extends GeoModel<SpiderFunnelEntity> {
   public ResourceLocation getAnimationResource(SpiderFunnelEntity entity) {
      return new ResourceLocation("arphex", "animations/spiderfunnel.animation.json");
   }

   public ResourceLocation getModelResource(SpiderFunnelEntity entity) {
      return new ResourceLocation("arphex", "geo/spiderfunnel.geo.json");
   }

   public ResourceLocation getTextureResource(SpiderFunnelEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
