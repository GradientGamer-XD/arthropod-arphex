package net.arphex.entity.model;

import net.arphex.entity.DwellerSleepSpawnerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DwellerSleepSpawnerModel extends GeoModel<DwellerSleepSpawnerEntity> {
   public ResourceLocation getAnimationResource(DwellerSleepSpawnerEntity entity) {
      return new ResourceLocation("arphex", "animations/spidermothdweller.animation.json");
   }

   public ResourceLocation getModelResource(DwellerSleepSpawnerEntity entity) {
      return new ResourceLocation("arphex", "geo/spidermothdweller.geo.json");
   }

   public ResourceLocation getTextureResource(DwellerSleepSpawnerEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
