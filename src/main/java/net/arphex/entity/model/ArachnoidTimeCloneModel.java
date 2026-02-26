package net.arphex.entity.model;

import net.arphex.entity.ArachnoidTimeCloneEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ArachnoidTimeCloneModel extends GeoModel<ArachnoidTimeCloneEntity> {
   public ResourceLocation getAnimationResource(ArachnoidTimeCloneEntity entity) {
      return new ResourceLocation("arphex", "animations/arachnoid_trisector.animation.json");
   }

   public ResourceLocation getModelResource(ArachnoidTimeCloneEntity entity) {
      return new ResourceLocation("arphex", "geo/arachnoid_trisector.geo.json");
   }

   public ResourceLocation getTextureResource(ArachnoidTimeCloneEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
