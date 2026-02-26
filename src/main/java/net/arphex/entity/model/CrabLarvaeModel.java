package net.arphex.entity.model;

import net.arphex.entity.CrabLarvaeEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CrabLarvaeModel extends GeoModel<CrabLarvaeEntity> {
   public ResourceLocation getAnimationResource(CrabLarvaeEntity entity) {
      return new ResourceLocation("arphex", "animations/crabconstrictor.animation.json");
   }

   public ResourceLocation getModelResource(CrabLarvaeEntity entity) {
      return new ResourceLocation("arphex", "geo/crabconstrictor.geo.json");
   }

   public ResourceLocation getTextureResource(CrabLarvaeEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(CrabLarvaeEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("claws");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * (float) (Math.PI / 180.0));
         head.setRotY(entityData.netHeadYaw() * (float) (Math.PI / 180.0));
      }
   }
}
