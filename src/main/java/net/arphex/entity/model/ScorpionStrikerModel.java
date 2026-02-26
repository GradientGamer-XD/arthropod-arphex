package net.arphex.entity.model;

import net.arphex.entity.ScorpionStrikerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ScorpionStrikerModel extends GeoModel<ScorpionStrikerEntity> {
   public ResourceLocation getAnimationResource(ScorpionStrikerEntity entity) {
      return new ResourceLocation("arphex", "animations/scorpionstriker.animation.json");
   }

   public ResourceLocation getModelResource(ScorpionStrikerEntity entity) {
      return new ResourceLocation("arphex", "geo/scorpionstriker.geo.json");
   }

   public ResourceLocation getTextureResource(ScorpionStrikerEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
