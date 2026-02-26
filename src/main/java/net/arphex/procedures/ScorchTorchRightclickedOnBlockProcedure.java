package net.arphex.procedures;

import net.arphex.init.ArphexModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraftforge.registries.ForgeRegistries;

public class ScorchTorchRightclickedOnBlockProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Direction direction, Entity entity, ItemStack itemstack) {
      if (direction != null && entity != null) {
         if ((double)world.getBlockState(BlockPos.containing(x, y, z)).getDestroySpeed(world, BlockPos.containing(x, y, z)) > 0.2
               && world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()
            || blockstate.getBlock() == ArphexModBlocks.CRAWLING_BARRIER.get()) {
            if (direction == Direction.WEST && world.isEmptyBlock(BlockPos.containing(x - 1.0, y, z))) {
               world.setBlock(BlockPos.containing(x - 1.0, y, z), ((Block)ArphexModBlocks.SCORCH_TORCH_WALL.get()).defaultBlockState(), 3);
               if (world instanceof Level _level) {
                  if (!_level.isClientSide()) {
                     _level.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wood.place")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F
                     );
                  } else {
                     _level.playLocalSound(
                        x,
                        y,
                        z,
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wood.place")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F,
                        false
                     );
                  }
               }

               label145: {
                  Direction _dir = Direction.WEST;
                  BlockPos _pos = BlockPos.containing(x - 1.0, y, z);
                  BlockState _bs = world.getBlockState(_pos);
                  if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
                     world.setBlock(_pos, (BlockState)_bs.setValue(_dp, _dir), 3);
                     break label145;
                  }

                  if (_bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis())) {
                     world.setBlock(_pos, (BlockState)_bs.setValue(_ap, _dir.getAxis()), 3);
                  }
               }

               if (!entity.getPersistentData().getBoolean("creativespectator")) {
                  itemstack.shrink(1);
               }
            }

            if (direction == Direction.EAST && world.isEmptyBlock(BlockPos.containing(x + 1.0, y, z))) {
               world.setBlock(BlockPos.containing(x + 1.0, y, z), ((Block)ArphexModBlocks.SCORCH_TORCH_WALL.get()).defaultBlockState(), 3);
               if (world instanceof Level _levelx) {
                  if (!_levelx.isClientSide()) {
                     _levelx.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wood.place")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F
                     );
                  } else {
                     _levelx.playLocalSound(
                        x,
                        y,
                        z,
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wood.place")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F,
                        false
                     );
                  }
               }

               label133: {
                  Direction _dirx = Direction.EAST;
                  BlockPos _posx = BlockPos.containing(x + 1.0, y, z);
                  BlockState _bsx = world.getBlockState(_posx);
                  if (_bsx.getBlock().getStateDefinition().getProperty("facing") instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dirx)) {
                     world.setBlock(_posx, (BlockState)_bsx.setValue(_dp, _dirx), 3);
                     break label133;
                  }

                  if (_bsx.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dirx.getAxis())
                     )
                   {
                     world.setBlock(_posx, (BlockState)_bsx.setValue(_ap, _dirx.getAxis()), 3);
                  }
               }

               if (!entity.getPersistentData().getBoolean("creativespectator")) {
                  itemstack.shrink(1);
               }
            }

            if (direction == Direction.NORTH && world.isEmptyBlock(BlockPos.containing(x, y, z - 1.0))) {
               world.setBlock(BlockPos.containing(x, y, z - 1.0), ((Block)ArphexModBlocks.SCORCH_TORCH_WALL.get()).defaultBlockState(), 3);
               if (world instanceof Level _levelxx) {
                  if (!_levelxx.isClientSide()) {
                     _levelxx.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wood.place")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F
                     );
                  } else {
                     _levelxx.playLocalSound(
                        x,
                        y,
                        z,
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wood.place")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F,
                        false
                     );
                  }
               }

               label121: {
                  Direction _dirxx = Direction.NORTH;
                  BlockPos _posxx = BlockPos.containing(x, y, z - 1.0);
                  BlockState _bsxx = world.getBlockState(_posxx);
                  if (_bsxx.getBlock().getStateDefinition().getProperty("facing") instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dirxx)) {
                     world.setBlock(_posxx, (BlockState)_bsxx.setValue(_dp, _dirxx), 3);
                     break label121;
                  }

                  if (_bsxx.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap
                     && _ap.getPossibleValues().contains(_dirxx.getAxis())) {
                     world.setBlock(_posxx, (BlockState)_bsxx.setValue(_ap, _dirxx.getAxis()), 3);
                  }
               }

               if (!entity.getPersistentData().getBoolean("creativespectator")) {
                  itemstack.shrink(1);
               }
            }

            if (direction == Direction.SOUTH && world.isEmptyBlock(BlockPos.containing(x, y, z + 1.0))) {
               world.setBlock(BlockPos.containing(x, y, z + 1.0), ((Block)ArphexModBlocks.SCORCH_TORCH_WALL.get()).defaultBlockState(), 3);
               if (world instanceof Level _levelxxx) {
                  if (!_levelxxx.isClientSide()) {
                     _levelxxx.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wood.place")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F
                     );
                  } else {
                     _levelxxx.playLocalSound(
                        x,
                        y,
                        z,
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wood.place")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F,
                        false
                     );
                  }
               }

               label109: {
                  Direction _dirxxx = Direction.SOUTH;
                  BlockPos _posxxx = BlockPos.containing(x, y, z + 1.0);
                  BlockState _bsxxx = world.getBlockState(_posxxx);
                  if (_bsxxx.getBlock().getStateDefinition().getProperty("facing") instanceof DirectionProperty _dp
                     && _dp.getPossibleValues().contains(_dirxxx)) {
                     world.setBlock(_posxxx, (BlockState)_bsxxx.setValue(_dp, _dirxxx), 3);
                     break label109;
                  }

                  if (_bsxxx.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap
                     && _ap.getPossibleValues().contains(_dirxxx.getAxis())) {
                     world.setBlock(_posxxx, (BlockState)_bsxxx.setValue(_ap, _dirxxx.getAxis()), 3);
                  }
               }

               if (!entity.getPersistentData().getBoolean("creativespectator")) {
                  itemstack.shrink(1);
               }
            }

            if (direction == Direction.UP && world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z))) {
               world.setBlock(BlockPos.containing(x, y + 1.0, z), ((Block)ArphexModBlocks.SCORCH_TORCH_GROUND.get()).defaultBlockState(), 3);
               if (world instanceof Level _levelxxxx) {
                  if (!_levelxxxx.isClientSide()) {
                     _levelxxxx.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wood.place")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F
                     );
                  } else {
                     _levelxxxx.playLocalSound(
                        x,
                        y,
                        z,
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wood.place")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F,
                        false
                     );
                  }
               }

               if (!entity.getPersistentData().getBoolean("creativespectator")) {
                  itemstack.shrink(1);
               }
            }
         }
      }
   }
}
