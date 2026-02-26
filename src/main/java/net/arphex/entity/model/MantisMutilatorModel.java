package net.arphex.entity.model;

import net.arphex.entity.MantisMutilatorEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class MantisMutilatorModel extends GeoModel<MantisMutilatorEntity> {
   public ResourceLocation getAnimationResource(MantisMutilatorEntity entity) {
      return new ResourceLocation("arphex", "animations/mantis.animation.json");
   }

   public ResourceLocation getModelResource(MantisMutilatorEntity entity) {
      return new ResourceLocation("arphex", "geo/mantis.geo.json");
   }

   public ResourceLocation getTextureResource(MantisMutilatorEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(MantisMutilatorEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * (float) (Math.PI / 180.0));
         head.setRotY(entityData.netHeadYaw() * (float) (Math.PI / 180.0));
      }
   }
}
