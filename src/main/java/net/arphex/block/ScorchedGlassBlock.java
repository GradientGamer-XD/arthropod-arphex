package net.arphex.block;

import java.util.List;
import net.arphex.procedures.ScorchTorchNeighbourBlockChangesProcedure;
import net.arphex.procedures.ScorchedGlassNeighbourBlockChangesProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ScorchedGlassBlock extends Block {
   public ScorchedGlassBlock() {
      super(
         Properties.of()
            .sound(SoundType.GLASS)
            .strength(50.0F, 200.0F)
            .lightLevel(s -> 2)
            .requiresCorrectToolForDrops()
            .noOcclusion()
            .isRedstoneConductor((bs, br, bp) -> false)
      );
   }

   public void appendHoverText(ItemStack itemstack, BlockGetter level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("Immensely charred and hardened/blast resistant glass"));
   }

   public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
      return adjacentBlockState.getBlock() == this ? true : super.skipRendering(state, adjacentBlockState, side);
   }

   public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 3;
   }

   public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      return Shapes.empty();
   }

   public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player) {
      return player.getInventory().getSelected().getItem() instanceof PickaxeItem tieredItem
         ? tieredItem.getTier().getLevel() >= 4
         : super.canHarvestBlock(state, world, pos, player);
   }

   public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
      super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
      ScorchedGlassNeighbourBlockChangesProcedure.execute(world, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ());
   }

   public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
      boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
      ScorchTorchNeighbourBlockChangesProcedure.execute();
      return retval;
   }

   public void setPlacedBy(Level world, BlockPos pos, BlockState blockstate, LivingEntity entity, ItemStack itemstack) {
      super.setPlacedBy(world, pos, blockstate, entity, itemstack);
      ScorchedGlassNeighbourBlockChangesProcedure.execute(world, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ());
   }
}
