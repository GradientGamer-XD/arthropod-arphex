package net.arphex.entity.model;

import net.arphex.entity.TormentorSummonEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class TormentorSummonModel extends GeoModel<TormentorSummonEntity> {
   public ResourceLocation getAnimationResource(TormentorSummonEntity entity) {
      String reskin = (String)entity.getEntityData().get(TormentorSummonEntity.DATA_reskin_model);
      return new ResourceLocation("arphex", "animations/" + reskin + ".animation.json");
   }

   public ResourceLocation getModelResource(TormentorSummonEntity entity) {
      String reskin = (String)entity.getEntityData().get(TormentorSummonEntity.DATA_reskin_model);
      return new ResourceLocation("arphex", "geo/" + reskin + ".geo.json");
   }

   public ResourceLocation getTextureResource(TormentorSummonEntity entity) {
      return new ResourceLocation("arphex", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(TormentorSummonEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * (float) (Math.PI / 180.0));
         head.setRotY(entityData.netHeadYaw() * (float) (Math.PI / 180.0));
      }
   }
}
