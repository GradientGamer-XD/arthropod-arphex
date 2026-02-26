package net.arphex.entity.model;

import net.arphex.entity.MosquitoMorbidityEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MosquitoMorbidityModel extends GeoModel<MosquitoMorbidityEntity> {
   public ResourceLocation getAnimationResource(MosquitoMorbidityEntity entity) {
      return new ResourceLocation("arphex", "animations/mosquito.animation.json");
   }

   public ResourceLocation getModelResource(MosquitoMorbidityEntity entity) {
      return new ResourceLocation("arphex", "geo/mosquito.geo.json");
   }

   public ResourceLocation getTextureResource(MosquitoMorbidityEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
