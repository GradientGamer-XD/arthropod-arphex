package net.arphex.entity.model;

import net.arphex.entity.EntropyConduitEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EntropyConduitModel extends GeoModel<EntropyConduitEntity> {
   public ResourceLocation getAnimationResource(EntropyConduitEntity entity) {
      return new ResourceLocation("arphex", "animations/entropy_conduit.animation.json");
   }

   public ResourceLocation getModelResource(EntropyConduitEntity entity) {
      return new ResourceLocation("arphex", "geo/entropy_conduit.geo.json");
   }

   public ResourceLocation getTextureResource(EntropyConduitEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
