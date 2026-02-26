package net.arphex.entity.model;

import net.arphex.entity.LongLegsTinyEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class LongLegsTinyModel extends GeoModel<LongLegsTinyEntity> {
   public ResourceLocation getAnimationResource(LongLegsTinyEntity entity) {
      return new ResourceLocation("arphex", "animations/longlegs.animation.json");
   }

   public ResourceLocation getModelResource(LongLegsTinyEntity entity) {
      return new ResourceLocation("arphex", "geo/longlegs.geo.json");
   }

   public ResourceLocation getTextureResource(LongLegsTinyEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
