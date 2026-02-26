package net.arphex.block;

import net.arphex.procedures.SpiderCocoonBlockDestroyedByPlayerProcedure;
import net.arphex.procedures.SpiderCocoonOnTickUpdateProcedure;
import net.arphex.procedures.SpiderCocoonPlayerNeighbourBlockChangesProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SpiderCocoonBlock extends Block {
   public SpiderCocoonBlock() {
      super(Properties.of().sound(SoundType.WOOL).strength(2.0F, 10.0F).noCollission().noOcclusion().randomTicks().isRedstoneConductor((bs, br, bp) -> false));
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

   public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
      super.tick(blockstate, world, pos, random);
      int x = pos.getX();
      int y = pos.getY();
      int z = pos.getZ();
      SpiderCocoonOnTickUpdateProcedure.execute(world, (double)x, (double)y, (double)z);
   }

   public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
      boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
      SpiderCocoonBlockDestroyedByPlayerProcedure.execute(world, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ());
      return retval;
   }

   public void wasExploded(Level world, BlockPos pos, Explosion e) {
      super.wasExploded(world, pos, e);
      SpiderCocoonBlockDestroyedByPlayerProcedure.execute(world, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ());
   }

   public void onProjectileHit(Level world, BlockState blockstate, BlockHitResult hit, Projectile entity) {
      SpiderCocoonPlayerNeighbourBlockChangesProcedure.execute(
         world, (double)hit.getBlockPos().getX(), (double)hit.getBlockPos().getY(), (double)hit.getBlockPos().getZ()
      );
   }
}
