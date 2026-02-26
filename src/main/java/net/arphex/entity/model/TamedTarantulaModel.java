package net.arphex.entity.model;

import net.arphex.entity.TamedTarantulaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TamedTarantulaModel extends GeoModel<TamedTarantulaEntity> {
   public ResourceLocation getAnimationResource(TamedTarantulaEntity entity) {
      String reskin = (String)entity.getEntityData().get(TamedTarantulaEntity.DATA_reskin_model);
      return new ResourceLocation("arphex", "animations/" + reskin + ".animation.json");
   }

   public ResourceLocation getModelResource(TamedTarantulaEntity entity) {
      String reskin = (String)entity.getEntityData().get(TamedTarantulaEntity.DATA_reskin_model);
      return new ResourceLocation("arphex", "geo/" + reskin + ".geo.json");
   }

   public ResourceLocation getTextureResource(TamedTarantulaEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
