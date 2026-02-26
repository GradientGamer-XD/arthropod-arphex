package net.arphex.entity.model;

import net.arphex.entity.TormentorCaterpillarEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TormentorCaterpillarModel extends GeoModel<TormentorCaterpillarEntity> {
   public ResourceLocation getAnimationResource(TormentorCaterpillarEntity entity) {
      return new ResourceLocation("arphex", "animations/maggot.animation.json");
   }

   public ResourceLocation getModelResource(TormentorCaterpillarEntity entity) {
      return new ResourceLocation("arphex", "geo/maggot.geo.json");
   }

   public ResourceLocation getTextureResource(TormentorCaterpillarEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
