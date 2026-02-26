package net.arphex.entity.model;

import net.arphex.entity.TormentorT5Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TormentorT5Model extends GeoModel<TormentorT5Entity> {
   public ResourceLocation getAnimationResource(TormentorT5Entity entity) {
      return new ResourceLocation("arphex", "animations/tormentor.animation.json");
   }

   public ResourceLocation getModelResource(TormentorT5Entity entity) {
      return new ResourceLocation("arphex", "geo/tormentor.geo.json");
   }

   public ResourceLocation getTextureResource(TormentorT5Entity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
