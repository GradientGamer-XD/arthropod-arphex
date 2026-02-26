package net.arphex.entity.model;

import net.arphex.entity.GiantWebEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GiantWebModel extends GeoModel<GiantWebEntity> {
   public ResourceLocation getAnimationResource(GiantWebEntity entity) {
      return new ResourceLocation("arphex", "animations/giantweb.animation.json");
   }

   public ResourceLocation getModelResource(GiantWebEntity entity) {
      return new ResourceLocation("arphex", "geo/giantweb.geo.json");
   }

   public ResourceLocation getTextureResource(GiantWebEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
