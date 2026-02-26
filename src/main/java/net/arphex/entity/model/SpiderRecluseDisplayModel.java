package net.arphex.entity.model;

import net.arphex.entity.SpiderRecluseDisplayEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SpiderRecluseDisplayModel extends GeoModel<SpiderRecluseDisplayEntity> {
   public ResourceLocation getAnimationResource(SpiderRecluseDisplayEntity entity) {
      return new ResourceLocation("arphex", "animations/spider_recluse.animation.json");
   }

   public ResourceLocation getModelResource(SpiderRecluseDisplayEntity entity) {
      return new ResourceLocation("arphex", "geo/spider_recluse.geo.json");
   }

   public ResourceLocation getTextureResource(SpiderRecluseDisplayEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
