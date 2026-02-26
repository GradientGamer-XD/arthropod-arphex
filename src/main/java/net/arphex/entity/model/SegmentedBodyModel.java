package net.arphex.entity.model;

import net.arphex.entity.SegmentedBodyEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class SegmentedBodyModel extends GeoModel<SegmentedBodyEntity> {
   public ResourceLocation getAnimationResource(SegmentedBodyEntity entity) {
      return new ResourceLocation("arphex", "animations/arthropleura.animation.json");
   }

   public ResourceLocation getModelResource(SegmentedBodyEntity entity) {
      return new ResourceLocation("arphex", "geo/arthropleura.geo.json");
   }

   public ResourceLocation getTextureResource(SegmentedBodyEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(SegmentedBodyEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("arthropleura");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * (float) (Math.PI / 180.0));
         head.setRotY(entityData.netHeadYaw() * (float) (Math.PI / 180.0));
      }
   }
}
