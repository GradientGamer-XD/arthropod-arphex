package net.arphex.entity.model;

import net.arphex.entity.TormentorMothSummonEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class TormentorMothSummonModel extends GeoModel<TormentorMothSummonEntity> {
   public ResourceLocation getAnimationResource(TormentorMothSummonEntity entity) {
      return new ResourceLocation("arphex", "animations/spidermothdweller.animation.json");
   }

   public ResourceLocation getModelResource(TormentorMothSummonEntity entity) {
      return new ResourceLocation("arphex", "geo/spidermothdweller.geo.json");
   }

   public ResourceLocation getTextureResource(TormentorMothSummonEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(TormentorMothSummonEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("FullBody");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * (float) (Math.PI / 180.0));
         head.setRotY(entityData.netHeadYaw() * (float) (Math.PI / 180.0));
      }
   }
}
