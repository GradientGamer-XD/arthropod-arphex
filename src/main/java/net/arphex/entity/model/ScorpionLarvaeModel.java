package net.arphex.entity.model;

import net.arphex.entity.ScorpionLarvaeEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ScorpionLarvaeModel extends GeoModel<ScorpionLarvaeEntity> {
   public ResourceLocation getAnimationResource(ScorpionLarvaeEntity entity) {
      return new ResourceLocation("arphex", "animations/scorpionstriker.animation.json");
   }

   public ResourceLocation getModelResource(ScorpionLarvaeEntity entity) {
      return new ResourceLocation("arphex", "geo/scorpionstriker.geo.json");
   }

   public ResourceLocation getTextureResource(ScorpionLarvaeEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
