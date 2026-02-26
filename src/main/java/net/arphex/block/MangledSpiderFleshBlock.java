package net.arphex.block;

import java.util.List;
import net.arphex.procedures.MangledSpiderFleshUpdateTickProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.MapColor;

public class MangledSpiderFleshBlock extends Block {
   public MangledSpiderFleshBlock() {
      super(Properties.of().mapColor(MapColor.TERRACOTTA_RED).sound(SoundType.SCULK).strength(0.5F, 10.0F).friction(0.8F).speedFactor(0.9F));
   }

   public void appendHoverText(ItemStack itemstack, BlockGetter level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("Used for summoning the Spider Moth [BOSS] (place soul sand on top and set on fire)"));
      list.add(Component.literal("§7Drops from Spider Goliath "));
   }

   public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 15;
   }

   public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
      return 1;
   }

   public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
      super.onPlace(blockstate, world, pos, oldState, moving);
      world.scheduleTick(pos, this, 10);
   }

   public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
      super.tick(blockstate, world, pos, random);
      int x = pos.getX();
      int y = pos.getY();
      int z = pos.getZ();
      MangledSpiderFleshUpdateTickProcedure.execute(world, (double)x, (double)y, (double)z);
      world.scheduleTick(pos, this, 10);
   }
}
