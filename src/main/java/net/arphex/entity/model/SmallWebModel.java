package net.arphex.entity.model;

import net.arphex.entity.SmallWebEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SmallWebModel extends GeoModel<SmallWebEntity> {
   public ResourceLocation getAnimationResource(SmallWebEntity entity) {
      return new ResourceLocation("arphex", "animations/giantweb.animation.json");
   }

   public ResourceLocation getModelResource(SmallWebEntity entity) {
      return new ResourceLocation("arphex", "geo/giantweb.geo.json");
   }

   public ResourceLocation getTextureResource(SmallWebEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
