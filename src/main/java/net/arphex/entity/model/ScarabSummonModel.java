package net.arphex.entity.model;

import net.arphex.entity.ScarabSummonEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ScarabSummonModel extends GeoModel<ScarabSummonEntity> {
   public ResourceLocation getAnimationResource(ScarabSummonEntity entity) {
      return new ResourceLocation("arphex", "animations/rhinobeetle.animation.json");
   }

   public ResourceLocation getModelResource(ScarabSummonEntity entity) {
      return new ResourceLocation("arphex", "geo/rhinobeetle.geo.json");
   }

   public ResourceLocation getTextureResource(ScarabSummonEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
