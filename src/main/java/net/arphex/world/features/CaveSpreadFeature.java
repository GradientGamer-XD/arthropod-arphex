package net.arphex.world.features;

import net.arphex.procedures.ForcePlacementOnGroundProcedure;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.ReplaceBlobsFeature;
import net.minecraft.world.level.levelgen.feature.configurations.ReplaceSphereConfiguration;

public class CaveSpreadFeature extends ReplaceBlobsFeature {
   public CaveSpreadFeature() {
      super(ReplaceSphereConfiguration.CODEC);
   }

   public boolean place(FeaturePlaceContext<ReplaceSphereConfiguration> context) {
      WorldGenLevel world = context.level();
      int x = context.origin().getX();
      int y = context.origin().getY();
      int z = context.origin().getZ();
      return !ForcePlacementOnGroundProcedure.execute(world, (double)x, (double)y, (double)z) ? false : super.place(context);
   }
}
