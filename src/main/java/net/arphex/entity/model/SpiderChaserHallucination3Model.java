package net.arphex.entity.model;

import net.arphex.entity.SpiderChaserHallucination3Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SpiderChaserHallucination3Model extends GeoModel<SpiderChaserHallucination3Entity> {
   public ResourceLocation getAnimationResource(SpiderChaserHallucination3Entity entity) {
      return new ResourceLocation("arphex", "animations/spider_infestor.animation.json");
   }

   public ResourceLocation getModelResource(SpiderChaserHallucination3Entity entity) {
      return new ResourceLocation("arphex", "geo/spider_infestor.geo.json");
   }

   public ResourceLocation getTextureResource(SpiderChaserHallucination3Entity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
