package net.arphex.entity.model;

import net.arphex.entity.DraconicFlyStalkEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class DraconicFlyStalkModel extends GeoModel<DraconicFlyStalkEntity> {
   public ResourceLocation getAnimationResource(DraconicFlyStalkEntity entity) {
      return new ResourceLocation("arphex", "animations/draconicvoidlasher.animation.json");
   }

   public ResourceLocation getModelResource(DraconicFlyStalkEntity entity) {
      return new ResourceLocation("arphex", "geo/draconicvoidlasher.geo.json");
   }

   public ResourceLocation getTextureResource(DraconicFlyStalkEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(DraconicFlyStalkEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * (float) (Math.PI / 180.0));
         head.setRotY(entityData.netHeadYaw() * (float) (Math.PI / 180.0));
      }
   }
}
