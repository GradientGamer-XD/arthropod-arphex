package net.arphex.entity.model;

import net.arphex.entity.DiabolosDecimatorCloneEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DiabolosDecimatorCloneModel extends GeoModel<DiabolosDecimatorCloneEntity> {
   public ResourceLocation getAnimationResource(DiabolosDecimatorCloneEntity entity) {
      return new ResourceLocation("arphex", "animations/diabolos.animation.json");
   }

   public ResourceLocation getModelResource(DiabolosDecimatorCloneEntity entity) {
      return new ResourceLocation("arphex", "geo/diabolos.geo.json");
   }

   public ResourceLocation getTextureResource(DiabolosDecimatorCloneEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
