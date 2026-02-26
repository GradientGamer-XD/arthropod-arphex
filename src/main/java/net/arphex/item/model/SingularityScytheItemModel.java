package net.arphex.item.model;

import net.arphex.item.SingularityScytheItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SingularityScytheItemModel extends GeoModel<SingularityScytheItem> {
   public ResourceLocation getAnimationResource(SingularityScytheItem animatable) {
      return new ResourceLocation("arphex", "animations/scythe.animation.json");
   }

   public ResourceLocation getModelResource(SingularityScytheItem animatable) {
      return new ResourceLocation("arphex", "geo/scythe.geo.json");
   }

   public ResourceLocation getTextureResource(SingularityScytheItem animatable) {
      return new ResourceLocation("arphex", "textures/item/gold_scythe.png");
   }
}
