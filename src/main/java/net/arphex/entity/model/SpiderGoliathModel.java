package net.arphex.entity.model;

import net.arphex.entity.SpiderGoliathEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SpiderGoliathModel extends GeoModel<SpiderGoliathEntity> {
   public ResourceLocation getAnimationResource(SpiderGoliathEntity entity) {
      return new ResourceLocation("arphex", "animations/spidertarantula.animation.json");
   }

   public ResourceLocation getModelResource(SpiderGoliathEntity entity) {
      return new ResourceLocation("arphex", "geo/spidertarantula.geo.json");
   }

   public ResourceLocation getTextureResource(SpiderGoliathEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
