package net.arphex.entity.model;

import net.arphex.entity.TormentorInitialEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TormentorInitialModel extends GeoModel<TormentorInitialEntity> {
   public ResourceLocation getAnimationResource(TormentorInitialEntity entity) {
      return new ResourceLocation("arphex", "animations/maggot.animation.json");
   }

   public ResourceLocation getModelResource(TormentorInitialEntity entity) {
      return new ResourceLocation("arphex", "geo/maggot.geo.json");
   }

   public ResourceLocation getTextureResource(TormentorInitialEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
