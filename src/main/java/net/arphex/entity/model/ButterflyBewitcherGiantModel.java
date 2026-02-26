package net.arphex.entity.model;

import net.arphex.entity.ButterflyBewitcherGiantEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ButterflyBewitcherGiantModel extends GeoModel<ButterflyBewitcherGiantEntity> {
   public ResourceLocation getAnimationResource(ButterflyBewitcherGiantEntity entity) {
      return new ResourceLocation("arphex", "animations/butterfly.animation.json");
   }

   public ResourceLocation getModelResource(ButterflyBewitcherGiantEntity entity) {
      return new ResourceLocation("arphex", "geo/butterfly.geo.json");
   }

   public ResourceLocation getTextureResource(ButterflyBewitcherGiantEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
