package net.arphex.entity.model;

import net.arphex.entity.ScorpioidInitialEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ScorpioidInitialModel extends GeoModel<ScorpioidInitialEntity> {
   public ResourceLocation getAnimationResource(ScorpioidInitialEntity entity) {
      return new ResourceLocation("arphex", "animations/scorpioidbloodluster.animation.json");
   }

   public ResourceLocation getModelResource(ScorpioidInitialEntity entity) {
      return new ResourceLocation("arphex", "geo/scorpioidbloodluster.geo.json");
   }

   public ResourceLocation getTextureResource(ScorpioidInitialEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
