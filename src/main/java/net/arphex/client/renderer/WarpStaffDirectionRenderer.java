package net.arphex.client.renderer;

import net.arphex.entity.WarpStaffDirectionEntity;
import net.minecraft.client.model.SlimeModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public class WarpStaffDirectionRenderer extends MobRenderer<WarpStaffDirectionEntity, SlimeModel<WarpStaffDirectionEntity>> {
   public WarpStaffDirectionRenderer(Context context) {
      super(context, new SlimeModel(context.bakeLayer(ModelLayers.SLIME)), 0.0F);
   }

   public ResourceLocation getTextureLocation(WarpStaffDirectionEntity entity) {
      return new ResourceLocation("arphex:textures/entities/invisible.png");
   }
}
