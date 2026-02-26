package net.arphex.entity.model;

import net.arphex.entity.MaggotLarvaeEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MaggotLarvaeModel extends GeoModel<MaggotLarvaeEntity> {
   public ResourceLocation getAnimationResource(MaggotLarvaeEntity entity) {
      return new ResourceLocation("arphex", "animations/maggot.animation.json");
   }

   public ResourceLocation getModelResource(MaggotLarvaeEntity entity) {
      return new ResourceLocation("arphex", "geo/maggot.geo.json");
   }

   public ResourceLocation getTextureResource(MaggotLarvaeEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
