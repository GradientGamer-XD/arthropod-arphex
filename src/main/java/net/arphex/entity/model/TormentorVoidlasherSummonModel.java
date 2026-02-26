package net.arphex.entity.model;

import net.arphex.entity.TormentorVoidlasherSummonEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TormentorVoidlasherSummonModel extends GeoModel<TormentorVoidlasherSummonEntity> {
   public ResourceLocation getAnimationResource(TormentorVoidlasherSummonEntity entity) {
      return new ResourceLocation("arphex", "animations/draconicvoidlasher.animation.json");
   }

   public ResourceLocation getModelResource(TormentorVoidlasherSummonEntity entity) {
      return new ResourceLocation("arphex", "geo/draconicvoidlasher.geo.json");
   }

   public ResourceLocation getTextureResource(TormentorVoidlasherSummonEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
