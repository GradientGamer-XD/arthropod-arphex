package net.arphex.entity.model;

import net.arphex.entity.ArachnoidTrisectorEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ArachnoidTrisectorModel extends GeoModel<ArachnoidTrisectorEntity> {
   public ResourceLocation getAnimationResource(ArachnoidTrisectorEntity entity) {
      return new ResourceLocation("arphex", "animations/arachnoid_trisector.animation.json");
   }

   public ResourceLocation getModelResource(ArachnoidTrisectorEntity entity) {
      return new ResourceLocation("arphex", "geo/arachnoid_trisector.geo.json");
   }

   public ResourceLocation getTextureResource(ArachnoidTrisectorEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
