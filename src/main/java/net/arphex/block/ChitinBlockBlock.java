package net.arphex.block;

import java.util.List;
import net.arphex.procedures.CrawlingCompostBlockDestroyedByPlayerProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.common.IPlantable;

public class ChitinBlockBlock extends Block implements BonemealableBlock {
   public ChitinBlockBlock() {
      super(Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(30.0F, 10.0F).requiresCorrectToolForDrops());
   }

   public void appendHoverText(ItemStack itemstack, BlockGetter level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("A tough block of hardened exoskeleton material from arthropods."));
      list.add(Component.literal("§7Used in summoning the Arachnoid Trisector [BOSS] with scorched sand on top + scorch charge"));
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
