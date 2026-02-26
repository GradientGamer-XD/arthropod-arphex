package net.arphex.entity.model;

import net.arphex.entity.CentipedeStalkerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CentipedeStalkerModel extends GeoModel<CentipedeStalkerEntity> {
   public ResourceLocation getAnimationResource(CentipedeStalkerEntity entity) {
      return new ResourceLocation("arphex", "animations/centipedestalker.animation.json");
   }

   public ResourceLocation getModelResource(CentipedeStalkerEntity entity) {
      return new ResourceLocation("arphex", "geo/centipedestalker.geo.json");
   }

   public ResourceLocation getTextureResource(CentipedeStalkerEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(CentipedeStalkerEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("look");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * (float) (Math.PI / 180.0));
         head.setRotY(entityData.netHeadYaw() * (float) (Math.PI / 180.0));
      }
   }
}
