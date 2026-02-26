package net.arphex.entity.model;

import net.arphex.entity.SmallTormentSphereEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SmallTormentSphereModel extends GeoModel<SmallTormentSphereEntity> {
   public ResourceLocation getAnimationResource(SmallTormentSphereEntity entity) {
      return new ResourceLocation("arphex", "animations/minisphere.animation.json");
   }

   public ResourceLocation getModelResource(SmallTormentSphereEntity entity) {
      return new ResourceLocation("arphex", "geo/minisphere.geo.json");
   }

   public ResourceLocation getTextureResource(SmallTormentSphereEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
