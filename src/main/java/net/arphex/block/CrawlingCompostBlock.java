package net.arphex.block;

import net.arphex.procedures.CrawlingCompostBlockDestroyedByPlayerProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.common.IPlantable;

public class CrawlingCompostBlock extends Block implements BonemealableBlock {
   public CrawlingCompostBlock() {
      super(Properties.of().sound(SoundType.GRAVEL).strength(1.5F, 10.0F).lightLevel(s -> 1));
   }

   public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 15;
   }

   public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction direction, IPlantable plantable) {
      return true;
   }

   public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
      boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
      CrawlingCompostBlockDestroyedByPlayerProcedure.execute(world, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ());
      return retval;
   }

   public boolean isValidBonemealTarget(LevelReader worldIn, BlockPos pos, BlockState blockstate, boolean clientSide) {
      return true;
   }

   public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState blockstate) {
      return true;
   }

   public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState blockstate) {
   }
}
