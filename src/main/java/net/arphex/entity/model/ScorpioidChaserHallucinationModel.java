package net.arphex.entity.model;

import net.arphex.entity.ScorpioidChaserHallucinationEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ScorpioidChaserHallucinationModel extends GeoModel<ScorpioidChaserHallucinationEntity> {
   public ResourceLocation getAnimationResource(ScorpioidChaserHallucinationEntity entity) {
      return new ResourceLocation("arphex", "animations/scorpioidbloodluster.animation.json");
   }

   public ResourceLocation getModelResource(ScorpioidChaserHallucinationEntity entity) {
      return new ResourceLocation("arphex", "geo/scorpioidbloodluster.geo.json");
   }

   public ResourceLocation getTextureResource(ScorpioidChaserHallucinationEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
