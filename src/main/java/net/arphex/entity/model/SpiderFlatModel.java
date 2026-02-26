package net.arphex.entity.model;

import net.arphex.entity.SpiderFlatEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SpiderFlatModel extends GeoModel<SpiderFlatEntity> {
   public ResourceLocation getAnimationResource(SpiderFlatEntity entity) {
      String reskin = (String)entity.getEntityData().get(SpiderFlatEntity.DATA_reskin_model);
      return new ResourceLocation("arphex", "animations/" + reskin + ".animation.json");
   }

   public ResourceLocation getModelResource(SpiderFlatEntity entity) {
      String reskin = (String)entity.getEntityData().get(SpiderFlatEntity.DATA_reskin_model);
      return new ResourceLocation("arphex", "geo/" + reskin + ".geo.json");
   }

   public ResourceLocation getTextureResource(SpiderFlatEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
