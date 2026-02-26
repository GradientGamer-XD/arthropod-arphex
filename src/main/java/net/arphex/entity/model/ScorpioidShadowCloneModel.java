package net.arphex.entity.model;

import net.arphex.entity.ScorpioidShadowCloneEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ScorpioidShadowCloneModel extends GeoModel<ScorpioidShadowCloneEntity> {
   public ResourceLocation getAnimationResource(ScorpioidShadowCloneEntity entity) {
      return new ResourceLocation("arphex", "animations/scorpioidbloodluster.animation.json");
   }

   public ResourceLocation getModelResource(ScorpioidShadowCloneEntity entity) {
      return new ResourceLocation("arphex", "geo/scorpioidbloodluster.geo.json");
   }

   public ResourceLocation getTextureResource(ScorpioidShadowCloneEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
