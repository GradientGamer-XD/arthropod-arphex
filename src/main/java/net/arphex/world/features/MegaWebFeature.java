package net.arphex.world.features;

import net.arphex.procedures.ForcePlacementOnGroundProcedure;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.SimpleRandomSelectorFeature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleRandomFeatureConfiguration;

public class MegaWebFeature extends SimpleRandomSelectorFeature {
   public MegaWebFeature() {
      super(SimpleRandomFeatureConfiguration.CODEC);
   }

   public boolean place(FeaturePlaceContext<SimpleRandomFeatureConfiguration> context) {
      WorldGenLevel world = context.level();
      int x = context.origin().getX();
      int y = context.origin().getY();
      int z = context.origin().getZ();
      return !ForcePlacementOnGroundProcedure.execute(world, (double)x, (double)y, (double)z) ? false : super.place(context);
   }
}
