package net.arphex.world.features;

import net.arphex.procedures.ReturnNeverProcedure;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.BlockBlobFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;

public class CrawlingLayerFireFeature extends BlockBlobFeature {
   public CrawlingLayerFireFeature() {
      super(BlockStateConfiguration.CODEC);
   }

   public boolean place(FeaturePlaceContext<BlockStateConfiguration> context) {
      WorldGenLevel world = context.level();
      int x = context.origin().getX();
      int y = context.origin().getY();
      int z = context.origin().getZ();
      return !ReturnNeverProcedure.execute() ? false : super.place(context);
   }
}
