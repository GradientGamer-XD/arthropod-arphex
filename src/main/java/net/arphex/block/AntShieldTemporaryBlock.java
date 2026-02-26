package net.arphex.block;

import net.arphex.procedures.AntShieldTemporaryOnTickUpdateProcedure;
import net.arphex.procedures.TempTickProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.phys.BlockHitResult;

public class AntShieldTemporaryBlock extends Block {
   public AntShieldTemporaryBlock() {
      super(Properties.of().sound(SoundType.GRAVEL).strength(1.0F, 10.0F).randomTicks());
   }

   public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 15;
   }

   public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
      super.tick(blockstate, world, pos, random);
      int x = pos.getX();
      int y = pos.getY();
      int z = pos.getZ();
      TempTickProcedure.execute(world, (double)x, (double)y, (double)z);
   }

   public void attack(BlockState blockstate, Level world, BlockPos pos, Player entity) {
      super.attack(blockstate, world, pos, entity);
      AntShieldTemporaryOnTickUpdateProcedure.execute(world, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ());
   }

   public void onProjectileHit(Level world, BlockState blockstate, BlockHitResult hit, Projectile entity) {
      AntShieldTemporaryOnTickUpdateProcedure.execute(
         world, (double)hit.getBlockPos().getX(), (double)hit.getBlockPos().getY(), (double)hit.getBlockPos().getZ()
      );
   }
}
