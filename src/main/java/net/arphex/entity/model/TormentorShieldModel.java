package net.arphex.entity.model;

import net.arphex.entity.TormentorShieldEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class TormentorShieldModel extends GeoModel<TormentorShieldEntity> {
   public ResourceLocation getAnimationResource(TormentorShieldEntity entity) {
      return new ResourceLocation("arphex", "animations/tormentor_shield.animation.json");
   }

   public ResourceLocation getModelResource(TormentorShieldEntity entity) {
      return new ResourceLocation("arphex", "geo/tormentor_shield.geo.json");
   }

   public ResourceLocation getTextureResource(TormentorShieldEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(TormentorShieldEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("overall");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * (float) (Math.PI / 180.0));
         head.setRotY(entityData.netHeadYaw() * (float) (Math.PI / 180.0));
      }
   }
}
