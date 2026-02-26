package net.arphex.block;

import net.arphex.procedures.ReaperWebEntityCollidesInTheBlockProcedure;
import net.arphex.procedures.ReaperWebOnTickUpdateProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ReaperWebBlock extends Block {
   public ReaperWebBlock() {
      super(
         Properties.of()
            .sound(SoundType.SNOW)
            .strength(2.0F, 10.0F)
            .noCollission()
            .friction(0.7F)
            .noOcclusion()
            .randomTicks()
            .isRedstoneConductor((bs, br, bp) -> false)
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

   public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      return Shapes.empty();
   }

   public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      return box(0.0, 0.0, 0.0, 16.0, 8.0, 16.0);
   }

   public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
      super.tick(blockstate, world, pos, random);
      int x = pos.getX();
      int y = pos.getY();
      int z = pos.getZ();
      ReaperWebOnTickUpdateProcedure.execute(world, (double)x, (double)y, (double)z);
   }

   public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
      super.entityInside(blockstate, world, pos, entity);
      ReaperWebEntityCollidesInTheBlockProcedure.execute((double)pos.getY(), entity);
   }
}
