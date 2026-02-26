package net.arphex.entity.model;

import net.arphex.entity.DiabolosDecimatorEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DiabolosDecimatorModel extends GeoModel<DiabolosDecimatorEntity> {
   public ResourceLocation getAnimationResource(DiabolosDecimatorEntity entity) {
      return new ResourceLocation("arphex", "animations/diabolos.animation.json");
   }

   public ResourceLocation getModelResource(DiabolosDecimatorEntity entity) {
      return new ResourceLocation("arphex", "geo/diabolos.geo.json");
   }

   public ResourceLocation getTextureResource(DiabolosDecimatorEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
