package net.arphex.entity.model;

import net.arphex.entity.BloodWormEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class BloodWormModel extends GeoModel<BloodWormEntity> {
   public ResourceLocation getAnimationResource(BloodWormEntity entity) {
      return new ResourceLocation("arphex", "animations/bloodworm.animation.json");
   }

   public ResourceLocation getModelResource(BloodWormEntity entity) {
      return new ResourceLocation("arphex", "geo/bloodworm.geo.json");
   }

   public ResourceLocation getTextureResource(BloodWormEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(BloodWormEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("bend");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * (float) (Math.PI / 180.0));
         head.setRotY(entityData.netHeadYaw() * (float) (Math.PI / 180.0));
      }
   }
}
