package net.arphex.entity.model;

import net.arphex.entity.BeetleBulwarkEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BeetleBulwarkModel extends GeoModel<BeetleBulwarkEntity> {
   public ResourceLocation getAnimationResource(BeetleBulwarkEntity entity) {
      return new ResourceLocation("arphex", "animations/rhinobeetle.animation.json");
   }

   public ResourceLocation getModelResource(BeetleBulwarkEntity entity) {
      return new ResourceLocation("arphex", "geo/rhinobeetle.geo.json");
   }

   public ResourceLocation getTextureResource(BeetleBulwarkEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
