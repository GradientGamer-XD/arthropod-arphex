package net.arphex.entity.model;

import net.arphex.entity.LongLegsEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class LongLegsModel extends GeoModel<LongLegsEntity> {
   public ResourceLocation getAnimationResource(LongLegsEntity entity) {
      return new ResourceLocation("arphex", "animations/longlegs.animation.json");
   }

   public ResourceLocation getModelResource(LongLegsEntity entity) {
      return new ResourceLocation("arphex", "geo/longlegs.geo.json");
   }

   public ResourceLocation getTextureResource(LongLegsEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
