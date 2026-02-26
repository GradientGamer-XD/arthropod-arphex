package net.arphex.entity.model;

import net.arphex.entity.SpiderJumpEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class SpiderJumpModel extends GeoModel<SpiderJumpEntity> {
   public ResourceLocation getAnimationResource(SpiderJumpEntity entity) {
      return new ResourceLocation("arphex", "animations/spiderjumping.animation.json");
   }

   public ResourceLocation getModelResource(SpiderJumpEntity entity) {
      return new ResourceLocation("arphex", "geo/spiderjumping.geo.json");
   }

   public ResourceLocation getTextureResource(SpiderJumpEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(SpiderJumpEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("face");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * (float) (Math.PI / 180.0));
         head.setRotY(entityData.netHeadYaw() * (float) (Math.PI / 180.0));
      }
   }
}
