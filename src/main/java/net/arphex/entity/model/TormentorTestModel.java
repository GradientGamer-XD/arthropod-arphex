package net.arphex.entity.model;

import net.arphex.entity.TormentorTestEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TormentorTestModel extends GeoModel<TormentorTestEntity> {
   public ResourceLocation getAnimationResource(TormentorTestEntity entity) {
      return new ResourceLocation("arphex", "animations/tormentor.animation.json");
   }

   public ResourceLocation getModelResource(TormentorTestEntity entity) {
      return new ResourceLocation("arphex", "geo/tormentor.geo.json");
   }

   public ResourceLocation getTextureResource(TormentorTestEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
