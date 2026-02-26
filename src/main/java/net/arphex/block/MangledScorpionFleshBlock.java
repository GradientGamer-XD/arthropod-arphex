package net.arphex.block;

import java.util.List;
import net.arphex.procedures.MangledScorpionFleshOnTickUpdateProcedure;
import net.minecraft.core.BlockPos;
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

public class MangledScorpionFleshBlock extends Block {
   public MangledScorpionFleshBlock() {
      super(Properties.of().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.GRAVEL).strength(0.75F, 10.0F).speedFactor(0.9F));
   }

   public void appendHoverText(ItemStack itemstack, BlockGetter level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("Mangled scorpion flesh block used for summoning the Scorpioid Bloodluster [BOSS] (place soul sand on top and set on fire)"));
   }

   public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 15;
   }

   public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
      super.onPlace(blockstate, world, pos, oldState, moving);
      world.scheduleTick(pos, this, 40);
   }

   public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
      super.tick(blockstate, world, pos, random);
      int x = pos.getX();
      int y = pos.getY();
      int z = pos.getZ();
      MangledScorpionFleshOnTickUpdateProcedure.execute(world, (double)x, (double)y, (double)z);
      world.scheduleTick(pos, this, 40);
   }
}
