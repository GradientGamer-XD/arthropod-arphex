package net.arphex.client.renderer;

import net.arphex.entity.AnyDimensionSpawnerEntity;
import net.minecraft.client.model.SlimeModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public class AnyDimensionSpawnerRenderer extends MobRenderer<AnyDimensionSpawnerEntity, SlimeModel<AnyDimensionSpawnerEntity>> {
   public AnyDimensionSpawnerRenderer(Context context) {
      super(context, new SlimeModel(context.bakeLayer(ModelLayers.SLIME)), 0.0F);
   }

   public ResourceLocation getTextureLocation(AnyDimensionSpawnerEntity entity) {
      return new ResourceLocation("arphex:textures/entities/invisible.png");
   }
}
