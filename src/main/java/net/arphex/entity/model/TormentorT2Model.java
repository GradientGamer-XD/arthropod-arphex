package net.arphex.entity.model;

import net.arphex.entity.TormentorT2Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TormentorT2Model extends GeoModel<TormentorT2Entity> {
   public ResourceLocation getAnimationResource(TormentorT2Entity entity) {
      return new ResourceLocation("arphex", "animations/tormentor_t2.animation.json");
   }

   public ResourceLocation getModelResource(TormentorT2Entity entity) {
      return new ResourceLocation("arphex", "geo/tormentor_t2.geo.json");
   }

   public ResourceLocation getTextureResource(TormentorT2Entity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
