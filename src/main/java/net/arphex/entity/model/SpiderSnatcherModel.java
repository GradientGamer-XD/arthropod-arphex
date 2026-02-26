package net.arphex.entity.model;

import net.arphex.entity.SpiderSnatcherEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class SpiderSnatcherModel extends GeoModel<SpiderSnatcherEntity> {
   public ResourceLocation getAnimationResource(SpiderSnatcherEntity entity) {
      return new ResourceLocation("arphex", "animations/spiderwidow.animation.json");
   }

   public ResourceLocation getModelResource(SpiderSnatcherEntity entity) {
      return new ResourceLocation("arphex", "geo/spiderwidow.geo.json");
   }

   public ResourceLocation getTextureResource(SpiderSnatcherEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(SpiderSnatcherEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("face");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * (float) (Math.PI / 180.0));
         head.setRotY(entityData.netHeadYaw() * (float) (Math.PI / 180.0));
      }
   }
}
