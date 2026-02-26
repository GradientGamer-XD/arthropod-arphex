package net.arphex.entity.model;

import net.arphex.entity.StickBugEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class StickBugModel extends GeoModel<StickBugEntity> {
   public ResourceLocation getAnimationResource(StickBugEntity entity) {
      return new ResourceLocation("arphex", "animations/stickbug.animation.json");
   }

   public ResourceLocation getModelResource(StickBugEntity entity) {
      return new ResourceLocation("arphex", "geo/stickbug.geo.json");
   }

   public ResourceLocation getTextureResource(StickBugEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
