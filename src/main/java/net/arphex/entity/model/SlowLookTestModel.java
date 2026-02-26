package net.arphex.entity.model;

import net.arphex.entity.SlowLookTestEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SlowLookTestModel extends GeoModel<SlowLookTestEntity> {
   public ResourceLocation getAnimationResource(SlowLookTestEntity entity) {
      return new ResourceLocation("arphex", "animations/maggot.animation.json");
   }

   public ResourceLocation getModelResource(SlowLookTestEntity entity) {
      return new ResourceLocation("arphex", "geo/maggot.geo.json");
   }

   public ResourceLocation getTextureResource(SlowLookTestEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
