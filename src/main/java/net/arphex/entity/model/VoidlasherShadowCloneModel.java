package net.arphex.entity.model;

import net.arphex.entity.VoidlasherShadowCloneEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class VoidlasherShadowCloneModel extends GeoModel<VoidlasherShadowCloneEntity> {
   public ResourceLocation getAnimationResource(VoidlasherShadowCloneEntity entity) {
      return new ResourceLocation("arphex", "animations/draconicvoidlasher.animation.json");
   }

   public ResourceLocation getModelResource(VoidlasherShadowCloneEntity entity) {
      return new ResourceLocation("arphex", "geo/draconicvoidlasher.geo.json");
   }

   public ResourceLocation getTextureResource(VoidlasherShadowCloneEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
