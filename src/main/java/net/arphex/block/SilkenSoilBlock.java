package net.arphex.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class SilkenSoilBlock extends Block {
   public SilkenSoilBlock() {
      super(Properties.of().sound(SoundType.GRAVEL).strength(5.0F, 10.0F).speedFactor(0.9F).jumpFactor(0.9F));
   }

   public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 15;
   }
}
