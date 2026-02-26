package net.arphex.entity.model;

import net.arphex.entity.TormentorT4Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TormentorT4Model extends GeoModel<TormentorT4Entity> {
   public ResourceLocation getAnimationResource(TormentorT4Entity entity) {
      return new ResourceLocation("arphex", "animations/tormentor.animation.json");
   }

   public ResourceLocation getModelResource(TormentorT4Entity entity) {
      return new ResourceLocation("arphex", "geo/tormentor.geo.json");
   }

   public ResourceLocation getTextureResource(TormentorT4Entity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
