package net.arphex.entity.model;

import net.arphex.entity.TORMENTOREntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TORMENTORModel extends GeoModel<TORMENTOREntity> {
   public ResourceLocation getAnimationResource(TORMENTOREntity entity) {
      return new ResourceLocation("arphex", "animations/maggot.animation.json");
   }

   public ResourceLocation getModelResource(TORMENTOREntity entity) {
      return new ResourceLocation("arphex", "geo/maggot.geo.json");
   }

   public ResourceLocation getTextureResource(TORMENTOREntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
