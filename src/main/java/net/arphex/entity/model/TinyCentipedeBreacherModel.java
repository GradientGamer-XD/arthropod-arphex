package net.arphex.entity.model;

import net.arphex.entity.TinyCentipedeBreacherEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TinyCentipedeBreacherModel extends GeoModel<TinyCentipedeBreacherEntity> {
   public ResourceLocation getAnimationResource(TinyCentipedeBreacherEntity entity) {
      return new ResourceLocation("arphex", "animations/centipedeevictor.animation.json");
   }

   public ResourceLocation getModelResource(TinyCentipedeBreacherEntity entity) {
      return new ResourceLocation("arphex", "geo/centipedeevictor.geo.json");
   }

   public ResourceLocation getTextureResource(TinyCentipedeBreacherEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }
}
