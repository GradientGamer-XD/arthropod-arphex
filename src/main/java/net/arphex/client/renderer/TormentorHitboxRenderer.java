package net.arphex.client.renderer;

import net.arphex.entity.TormentorHitboxEntity;
import net.minecraft.client.model.SlimeModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public class TormentorHitboxRenderer extends MobRenderer<TormentorHitboxEntity, SlimeModel<TormentorHitboxEntity>> {
   public TormentorHitboxRenderer(Context context) {
      super(context, new SlimeModel(context.bakeLayer(ModelLayers.SLIME)), 0.0F);
   }

   public ResourceLocation getTextureLocation(TormentorHitboxEntity entity) {
      return new ResourceLocation("arphex:textures/entities/invisible.png");
   }
}
