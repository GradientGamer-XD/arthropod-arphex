package net.arphex.entity.model;

import net.arphex.entity.SpiderChaserHallucination2Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SpiderChaserHallucination2Model extends GeoModel<SpiderChaserHallucination2Entity> {
   public ResourceLocation getAnimationResource(SpiderChaserHallucination2Entity entity) {
      return new ResourceLocation("arphex", "animations/spiderfunnel.animation.json");
   }

   public ResourceLocation getModelResource(SpiderChaserHallucination2Entity entity) {
      return new ResourceLocation("arphex", "geo/spiderfunnel.geo.json");
   }

   public ResourceLocation getTextureResource(SpiderChaserHallucination2Entity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
