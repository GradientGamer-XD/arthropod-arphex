package net.arphex.entity.model;

import net.arphex.entity.DraconicCloneEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class DraconicCloneModel extends GeoModel<DraconicCloneEntity> {
   public ResourceLocation getAnimationResource(DraconicCloneEntity entity) {
      return new ResourceLocation("arphex", "animations/draconicvoidlasher.animation.json");
   }

   public ResourceLocation getModelResource(DraconicCloneEntity entity) {
      return new ResourceLocation("arphex", "geo/draconicvoidlasher.geo.json");
   }

   public ResourceLocation getTextureResource(DraconicCloneEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(DraconicCloneEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * (float) (Math.PI / 180.0));
         head.setRotY(entityData.netHeadYaw() * (float) (Math.PI / 180.0));
      }
   }
}
