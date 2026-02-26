package net.arphex.entity.model;

import net.arphex.entity.AntArsonistEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AntArsonistModel extends GeoModel<AntArsonistEntity> {
   public ResourceLocation getAnimationResource(AntArsonistEntity entity) {
      return new ResourceLocation("arphex", "animations/antgiant.animation.json");
   }

   public ResourceLocation getModelResource(AntArsonistEntity entity) {
      return new ResourceLocation("arphex", "geo/antgiant.geo.json");
   }

   public ResourceLocation getTextureResource(AntArsonistEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
