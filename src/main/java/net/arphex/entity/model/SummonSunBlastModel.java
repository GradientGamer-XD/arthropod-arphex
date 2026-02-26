package net.arphex.entity.model;

import net.arphex.entity.SummonSunBlastEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SummonSunBlastModel extends GeoModel<SummonSunBlastEntity> {
   public ResourceLocation getAnimationResource(SummonSunBlastEntity entity) {
      return new ResourceLocation("arphex", "animations/sphere.animation.json");
   }

   public ResourceLocation getModelResource(SummonSunBlastEntity entity) {
      return new ResourceLocation("arphex", "geo/sphere.geo.json");
   }

   public ResourceLocation getTextureResource(SummonSunBlastEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
