package net.arphex.entity.model;

import net.arphex.entity.SpiderChaserHallucinationEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SpiderChaserHallucinationModel extends GeoModel<SpiderChaserHallucinationEntity> {
   public ResourceLocation getAnimationResource(SpiderChaserHallucinationEntity entity) {
      return new ResourceLocation("arphex", "animations/giantenemyspider.animation.json");
   }

   public ResourceLocation getModelResource(SpiderChaserHallucinationEntity entity) {
      return new ResourceLocation("arphex", "geo/giantenemyspider.geo.json");
   }

   public ResourceLocation getTextureResource(SpiderChaserHallucinationEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
