package net.arphex.entity.model;

import net.arphex.entity.TormentorLowDisplayAnimEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TormentorLowDisplayAnimModel extends GeoModel<TormentorLowDisplayAnimEntity> {
   public ResourceLocation getAnimationResource(TormentorLowDisplayAnimEntity entity) {
      return new ResourceLocation("arphex", "animations/tormentor_forceanim.animation.json");
   }

   public ResourceLocation getModelResource(TormentorLowDisplayAnimEntity entity) {
      return new ResourceLocation("arphex", "geo/tormentor_forceanim.geo.json");
   }

   public ResourceLocation getTextureResource(TormentorLowDisplayAnimEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
