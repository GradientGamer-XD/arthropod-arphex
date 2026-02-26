package net.arphex.entity.model;

import net.arphex.entity.ArthropleuraAbominationEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ArthropleuraAbominationModel extends GeoModel<ArthropleuraAbominationEntity> {
   public ResourceLocation getAnimationResource(ArthropleuraAbominationEntity entity) {
      return new ResourceLocation("arphex", "animations/arthropleura_head.animation.json");
   }

   public ResourceLocation getModelResource(ArthropleuraAbominationEntity entity) {
      return new ResourceLocation("arphex", "geo/arthropleura_head.geo.json");
   }

   public ResourceLocation getTextureResource(ArthropleuraAbominationEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
