package net.arphex.entity.model;

import net.arphex.entity.PureStalkingEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PureStalkingModel extends GeoModel<PureStalkingEntity> {
   public ResourceLocation getAnimationResource(PureStalkingEntity entity) {
      return new ResourceLocation("arphex", "animations/spidermothdweller.animation.json");
   }

   public ResourceLocation getModelResource(PureStalkingEntity entity) {
      return new ResourceLocation("arphex", "geo/spidermothdweller.geo.json");
   }

   public ResourceLocation getTextureResource(PureStalkingEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
