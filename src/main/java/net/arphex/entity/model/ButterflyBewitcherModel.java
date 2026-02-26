package net.arphex.entity.model;

import net.arphex.entity.ButterflyBewitcherEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ButterflyBewitcherModel extends GeoModel<ButterflyBewitcherEntity> {
   public ResourceLocation getAnimationResource(ButterflyBewitcherEntity entity) {
      return new ResourceLocation("arphex", "animations/butterfly.animation.json");
   }

   public ResourceLocation getModelResource(ButterflyBewitcherEntity entity) {
      return new ResourceLocation("arphex", "geo/butterfly.geo.json");
   }

   public ResourceLocation getTextureResource(ButterflyBewitcherEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
