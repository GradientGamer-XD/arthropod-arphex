package net.arphex.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class DecadentDustBlock extends Block {
   public DecadentDustBlock() {
      super(Properties.of().instrument(NoteBlockInstrument.SNARE).sound(SoundType.SAND).strength(2.0F, 5.0F).lightLevel(s -> 10));
   }

   public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 15;
   }
}
