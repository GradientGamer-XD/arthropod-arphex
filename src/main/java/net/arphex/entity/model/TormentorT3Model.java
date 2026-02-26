package net.arphex.entity.model;

import net.arphex.entity.TormentorT3Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TormentorT3Model extends GeoModel<TormentorT3Entity> {
   public ResourceLocation getAnimationResource(TormentorT3Entity entity) {
      return new ResourceLocation("arphex", "animations/tormentor.animation.json");
   }

   public ResourceLocation getModelResource(TormentorT3Entity entity) {
      return new ResourceLocation("arphex", "geo/tormentor.geo.json");
   }

   public ResourceLocation getTextureResource(TormentorT3Entity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
