package net.arphex.world.features;

import net.arphex.procedures.WaterPocketsAdditionalGenerationConditionProcedure;
import net.arphex.world.features.configurations.StructureFeatureConfiguration;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class WaterPocketsFeature extends StructureFeature {
   public WaterPocketsFeature() {
      super(StructureFeatureConfiguration.CODEC);
   }

   @Override
   public boolean place(FeaturePlaceContext<StructureFeatureConfiguration> context) {
      WorldGenLevel world = context.level();
      int x = context.origin().getX();
      int y = context.origin().getY();
      int z = context.origin().getZ();
      return !WaterPocketsAdditionalGenerationConditionProcedure.execute(world, (double)x, (double)y, (double)z) ? false : super.place(context);
   }
}
