package net.arphex.entity.model;

import net.arphex.entity.AntArsonistDroneEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class AntArsonistDroneModel extends GeoModel<AntArsonistDroneEntity> {
   public ResourceLocation getAnimationResource(AntArsonistDroneEntity entity) {
      return new ResourceLocation("arphex", "animations/antalate.animation.json");
   }

   public ResourceLocation getModelResource(AntArsonistDroneEntity entity) {
      return new ResourceLocation("arphex", "geo/antalate.geo.json");
   }

   public ResourceLocation getTextureResource(AntArsonistDroneEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(AntArsonistDroneEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * (float) (Math.PI / 180.0));
         head.setRotY(entityData.netHeadYaw() * (float) (Math.PI / 180.0));
      }
   }
}
