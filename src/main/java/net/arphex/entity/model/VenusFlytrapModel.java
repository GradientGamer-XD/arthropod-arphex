package net.arphex.entity.model;

import net.arphex.entity.VenusFlytrapEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class VenusFlytrapModel extends GeoModel<VenusFlytrapEntity> {
   public ResourceLocation getAnimationResource(VenusFlytrapEntity entity) {
      return new ResourceLocation("arphex", "animations/venusflytrap.animation.json");
   }

   public ResourceLocation getModelResource(VenusFlytrapEntity entity) {
      return new ResourceLocation("arphex", "geo/venusflytrap.geo.json");
   }

   public ResourceLocation getTextureResource(VenusFlytrapEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(VenusFlytrapEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("plant2");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * (float) (Math.PI / 180.0));
         head.setRotY(entityData.netHeadYaw() * (float) (Math.PI / 180.0));
      }
   }
}
