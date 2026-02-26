package net.arphex.entity.model;

import net.arphex.entity.RoachRiverspawnEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RoachRiverspawnModel extends GeoModel<RoachRiverspawnEntity> {
   public ResourceLocation getAnimationResource(RoachRiverspawnEntity entity) {
      return new ResourceLocation("arphex", "animations/waterroach.animation.json");
   }

   public ResourceLocation getModelResource(RoachRiverspawnEntity entity) {
      return new ResourceLocation("arphex", "geo/waterroach.geo.json");
   }

   public ResourceLocation getTextureResource(RoachRiverspawnEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
