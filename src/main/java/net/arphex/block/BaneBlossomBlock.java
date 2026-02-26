package net.arphex.block;

import java.util.List;
import net.arphex.init.ArphexModBlocks;
import net.arphex.procedures.BaneBlossomMobplayerCollidesWithPlantProcedure;
import net.arphex.procedures.BaneBlossomNeighbourBlockChangesProcedure;
import net.arphex.procedures.BaneBlossomOnTickUpdateProcedure;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SugarCaneBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.OffsetType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterColorHandlersEvent.Item;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.PlantType;

public class BaneBlossomBlock extends SugarCaneBlock {
   public BaneBlossomBlock() {
      super(
         Properties.of()
            .mapColor(MapColor.ICE)
            .randomTicks()
            .sound(SoundType.GRASS)
            .instabreak()
            .hasPostProcess((bs, br, bp) -> true)
            .emissiveRendering((bs, br, bp) -> true)
            .lightLevel(s -> 7)
            .noOcclusion()
            .dynamicShape()
            .offsetType(OffsetType.XZ)
            .pushReaction(PushReaction.DESTROY)
      );
   }

   public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      Vec3 offset = state.getOffset(world, pos);
      return box(5.0, 0.0, 5.0, 11.0, 16.0, 11.0).move(offset.x, offset.y, offset.z);
   }

   public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
      return 100;
   }

   public void appendHoverText(ItemStack itemstack, BlockGetter level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("Bane Blossom plant craftable into a bane of the darkness"));
   }

   public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
      return 60;
   }

   public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
      BlockPos blockpos = pos.below();
      BlockState groundState = worldIn.getBlockState(blockpos);
      return groundState.is(this) || groundState.is((Block)ArphexModBlocks.CRAWLING_COMPOST.get());
   }

   public PlantType getPlantType(BlockGetter world, BlockPos pos) {
      return PlantType.PLAINS;
   }

   public void randomTick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
      if (world.isEmptyBlock(pos.above())) {
         int i = 1;

         while (world.getBlockState(pos.below(i)).is(this)) {
            i++;
         }

         if (i < 3) {
            int j = (Integer)blockstate.getValue(AGE);
            if (ForgeHooks.onCropsGrowPre(world, pos, blockstate, true)) {
               if (j == 15) {
                  world.setBlockAndUpdate(pos.above(), this.defaultBlockState());
                  world.setBlock(pos, (BlockState)blockstate.setValue(AGE, 0), 4);
               } else {
                  world.setBlock(pos, (BlockState)blockstate.setValue(AGE, j + 1), 4);
               }
            }
         }
      }

      BaneBlossomOnTickUpdateProcedure.execute(world, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ());
   }

   public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
      super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
      BaneBlossomNeighbourBlockChangesProcedure.execute(world, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ());
   }

   public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
      super.entityInside(blockstate, world, pos, entity);
      BaneBlossomMobplayerCollidesWithPlantProcedure.execute(world, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), entity);
   }

   @OnlyIn(Dist.CLIENT)
   public static void blockColorLoad(net.minecraftforge.client.event.RegisterColorHandlersEvent.Block event) {
      event.getBlockColors()
         .register(
            (bs, world, pos, index) -> world != null && pos != null ? BiomeColors.getAverageGrassColor(world, pos) : GrassColor.get(0.5, 1.0),
            new Block[]{(Block)ArphexModBlocks.BANE_BLOSSOM.get()}
         );
   }

   @OnlyIn(Dist.CLIENT)
   public static void itemColorLoad(Item event) {
      event.getItemColors().register((stack, index) -> GrassColor.get(0.5, 1.0), new ItemLike[]{(ItemLike)ArphexModBlocks.BANE_BLOSSOM.get()});
   }
}
