package net.arphex.client.renderer;

import net.arphex.entity.HitboxExpanderEntity;
import net.minecraft.client.model.SlimeModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public class HitboxExpanderRenderer extends MobRenderer<HitboxExpanderEntity, SlimeModel<HitboxExpanderEntity>> {
   public HitboxExpanderRenderer(Context context) {
      super(context, new SlimeModel(context.bakeLayer(ModelLayers.SLIME)), 0.5F);
   }

   public ResourceLocation getTextureLocation(HitboxExpanderEntity entity) {
      return new ResourceLocation("arphex:textures/entities/invisible.png");
   }
}
