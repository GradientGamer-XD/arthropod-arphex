package net.arphex.entity.model;

import net.arphex.entity.TormentorScorpioidSummonEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class TormentorScorpioidSummonModel extends GeoModel<TormentorScorpioidSummonEntity> {
   public ResourceLocation getAnimationResource(TormentorScorpioidSummonEntity entity) {
      return new ResourceLocation("arphex", "animations/scorpioidbloodluster.animation.json");
   }

   public ResourceLocation getModelResource(TormentorScorpioidSummonEntity entity) {
      return new ResourceLocation("arphex", "geo/scorpioidbloodluster.geo.json");
   }

   public ResourceLocation getTextureResource(TormentorScorpioidSummonEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(TormentorScorpioidSummonEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * (float) (Math.PI / 180.0));
         head.setRotY(entityData.netHeadYaw() * (float) (Math.PI / 180.0));
      }
   }
}
