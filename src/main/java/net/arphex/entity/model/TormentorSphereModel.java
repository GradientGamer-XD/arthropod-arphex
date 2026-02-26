package net.arphex.entity.model;

import net.arphex.entity.TormentorSphereEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TormentorSphereModel extends GeoModel<TormentorSphereEntity> {
   public ResourceLocation getAnimationResource(TormentorSphereEntity entity) {
      return new ResourceLocation("arphex", "animations/sphere.animation.json");
   }

   public ResourceLocation getModelResource(TormentorSphereEntity entity) {
      return new ResourceLocation("arphex", "geo/sphere.geo.json");
   }

   public ResourceLocation getTextureResource(TormentorSphereEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
