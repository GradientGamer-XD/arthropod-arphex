package net.arphex.entity.model;

import net.arphex.entity.TormentorFlashAnimEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TormentorFlashAnimModel extends GeoModel<TormentorFlashAnimEntity> {
   public ResourceLocation getAnimationResource(TormentorFlashAnimEntity entity) {
      return new ResourceLocation("arphex", "animations/tormentor_flash_anim.animation.json");
   }

   public ResourceLocation getModelResource(TormentorFlashAnimEntity entity) {
      return new ResourceLocation("arphex", "geo/tormentor_flash_anim.geo.json");
   }

   public ResourceLocation getTextureResource(TormentorFlashAnimEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
