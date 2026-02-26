package net.arphex.entity.model;

import net.arphex.entity.CentipedeEvictorEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CentipedeEvictorModel extends GeoModel<CentipedeEvictorEntity> {
   public ResourceLocation getAnimationResource(CentipedeEvictorEntity entity) {
      return new ResourceLocation("arphex", "animations/centipedeevictor.animation.json");
   }

   public ResourceLocation getModelResource(CentipedeEvictorEntity entity) {
      return new ResourceLocation("arphex", "geo/centipedeevictor.geo.json");
   }

   public ResourceLocation getTextureResource(CentipedeEvictorEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(CentipedeEvictorEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("fronthead");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * (float) (Math.PI / 180.0));
         head.setRotY(entityData.netHeadYaw() * (float) (Math.PI / 180.0));
      }
   }
}
