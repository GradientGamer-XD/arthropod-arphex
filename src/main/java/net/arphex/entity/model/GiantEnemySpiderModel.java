package net.arphex.entity.model;

import net.arphex.entity.GiantEnemySpiderEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GiantEnemySpiderModel extends GeoModel<GiantEnemySpiderEntity> {
   public ResourceLocation getAnimationResource(GiantEnemySpiderEntity entity) {
      return new ResourceLocation("arphex", "animations/giantenemyspider.animation.json");
   }

   public ResourceLocation getModelResource(GiantEnemySpiderEntity entity) {
      return new ResourceLocation("arphex", "geo/giantenemyspider.geo.json");
   }

   public ResourceLocation getTextureResource(GiantEnemySpiderEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
