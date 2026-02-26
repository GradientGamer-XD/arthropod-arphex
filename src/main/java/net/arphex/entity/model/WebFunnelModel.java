package net.arphex.entity.model;

import net.arphex.entity.WebFunnelEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class WebFunnelModel extends GeoModel<WebFunnelEntity> {
   public ResourceLocation getAnimationResource(WebFunnelEntity entity) {
      return new ResourceLocation("arphex", "animations/maggot.animation.json");
   }

   public ResourceLocation getModelResource(WebFunnelEntity entity) {
      return new ResourceLocation("arphex", "geo/maggot.geo.json");
   }

   public ResourceLocation getTextureResource(WebFunnelEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
