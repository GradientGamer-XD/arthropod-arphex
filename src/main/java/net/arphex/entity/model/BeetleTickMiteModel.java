package net.arphex.entity.model;

import net.arphex.entity.BeetleTickMiteEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BeetleTickMiteModel extends GeoModel<BeetleTickMiteEntity> {
   public ResourceLocation getAnimationResource(BeetleTickMiteEntity entity) {
      return new ResourceLocation("arphex", "animations/beetletickmite.animation.json");
   }

   public ResourceLocation getModelResource(BeetleTickMiteEntity entity) {
      return new ResourceLocation("arphex", "geo/beetletickmite.geo.json");
   }

   public ResourceLocation getTextureResource(BeetleTickMiteEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
