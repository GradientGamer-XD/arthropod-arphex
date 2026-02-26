package net.arphex.entity.model;

import net.arphex.entity.EnormousSpiderHallucinationEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EnormousSpiderHallucinationModel extends GeoModel<EnormousSpiderHallucinationEntity> {
   public ResourceLocation getAnimationResource(EnormousSpiderHallucinationEntity entity) {
      return new ResourceLocation("arphex", "animations/spiderreaper.animation.json");
   }

   public ResourceLocation getModelResource(EnormousSpiderHallucinationEntity entity) {
      return new ResourceLocation("arphex", "geo/spiderreaper.geo.json");
   }

   public ResourceLocation getTextureResource(EnormousSpiderHallucinationEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
