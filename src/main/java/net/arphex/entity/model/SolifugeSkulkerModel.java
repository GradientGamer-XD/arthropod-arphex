package net.arphex.entity.model;

import net.arphex.entity.SolifugeSkulkerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class SolifugeSkulkerModel extends GeoModel<SolifugeSkulkerEntity> {
   public ResourceLocation getAnimationResource(SolifugeSkulkerEntity entity) {
      return new ResourceLocation("arphex", "animations/sunspider.animation.json");
   }

   public ResourceLocation getModelResource(SolifugeSkulkerEntity entity) {
      return new ResourceLocation("arphex", "geo/sunspider.geo.json");
   }

   public ResourceLocation getTextureResource(SolifugeSkulkerEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(SolifugeSkulkerEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("front");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * (float) (Math.PI / 180.0));
         head.setRotY(entityData.netHeadYaw() * (float) (Math.PI / 180.0));
      }
   }
}
