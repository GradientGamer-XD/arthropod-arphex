package net.arphex.block;

import net.arphex.procedures.CrawlingPortalBlockValidPlacementConditionProcedure;
import net.arphex.procedures.CrawlingPortalEntityCollidesInTheBlockProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.PushReaction;

public class CrawlingPortalBlock extends Block {
   public CrawlingPortalBlock() {
      super(
         Properties.of()
            .sound(SoundType.GRAVEL)
            .strength(-1.0F, 3600000.0F)
            .lightLevel(s -> 8)
            .noCollission()
            .randomTicks()
            .pushReaction(PushReaction.IGNORE)
            .hasPostProcess((bs, br, bp) -> true)
            .emissiveRendering((bs, br, bp) -> true)
      );
   }

   public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
      return adjacentBlockState.getBlock() == this ? true : super.skipRendering(state, adjacentBlockState, side);
   }

   public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
      return true;
   }

   public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 0;
   }

   public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
      if (worldIn instanceof LevelAccessor world) {
         int x = pos.getX();
         int y = pos.getY();
         int z = pos.getZ();
         return CrawlingPortalBlockValidPlacementConditionProcedure.execute(world, (double)x, (double)y, (double)z);
      } else {
         return super.canSurvive(blockstate, worldIn, pos);
      }
   }

   public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
      return !state.canSurvive(world, currentPos)
         ? Blocks.AIR.defaultBlockState()
         : super.updateShape(state, facing, facingState, world, currentPos, facingPos);
   }

   public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
      super.entityInside(blockstate, world, pos, entity);
      CrawlingPortalEntityCollidesInTheBlockProcedure.execute(world, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), entity);
   }
}
