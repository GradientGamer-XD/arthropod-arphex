package net.arphex.entity.model;

import net.arphex.entity.TormentorLowDisplayEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TormentorLowDisplayModel extends GeoModel<TormentorLowDisplayEntity> {
   public ResourceLocation getAnimationResource(TormentorLowDisplayEntity entity) {
      return new ResourceLocation("arphex", "animations/tormentor.animation.json");
   }

   public ResourceLocation getModelResource(TormentorLowDisplayEntity entity) {
      return new ResourceLocation("arphex", "geo/tormentor.geo.json");
   }

   public ResourceLocation getTextureResource(TormentorLowDisplayEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
