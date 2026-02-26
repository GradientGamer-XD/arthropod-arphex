package net.arphex.entity.model;

import net.arphex.entity.InvisibleStalkerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class InvisibleStalkerModel extends GeoModel<InvisibleStalkerEntity> {
   public ResourceLocation getAnimationResource(InvisibleStalkerEntity entity) {
      return new ResourceLocation("arphex", "animations/spidermothdweller.animation.json");
   }

   public ResourceLocation getModelResource(InvisibleStalkerEntity entity) {
      return new ResourceLocation("arphex", "geo/spidermothdweller.geo.json");
   }

   public ResourceLocation getTextureResource(InvisibleStalkerEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
