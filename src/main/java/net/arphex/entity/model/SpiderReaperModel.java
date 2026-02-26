package net.arphex.entity.model;

import net.arphex.entity.SpiderReaperEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SpiderReaperModel extends GeoModel<SpiderReaperEntity> {
   public ResourceLocation getAnimationResource(SpiderReaperEntity entity) {
      return new ResourceLocation("arphex", "animations/spiderreaper.animation.json");
   }

   public ResourceLocation getModelResource(SpiderReaperEntity entity) {
      return new ResourceLocation("arphex", "geo/spiderreaper.geo.json");
   }

   public ResourceLocation getTextureResource(SpiderReaperEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
