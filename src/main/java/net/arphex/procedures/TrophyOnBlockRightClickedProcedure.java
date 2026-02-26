package net.arphex.procedures;

import net.arphex.init.ArphexModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class TrophyOnBlockRightClickedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!world.isClientSide()) {
            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.FLY_APPENDAGE.get()) {
               if (!world.isClientSide()) {
                  BlockPos _bp = BlockPos.containing(x, y, z);
                  BlockEntity _blockEntity = world.getBlockEntity(_bp);
                  BlockState _bs = world.getBlockState(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData()
                        .putString(
                           "trophy_entity",
                           (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("trophy_entity")
                        );
                  }

                  if (world instanceof Level _level) {
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }

               if (!world.isClientSide()) {
                  BlockPos _bpx = BlockPos.containing(x, y, z);
                  BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
                  BlockState _bsx = world.getBlockState(_bpx);
                  if (_blockEntityx != null) {
                     _blockEntityx.getPersistentData()
                        .putDouble(
                           "trophy_entity_size",
                           (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                              .getOrCreateTag()
                              .getDouble("trophy_entity_size")
                        );
                  }

                  if (world instanceof Level _level) {
                     _level.sendBlockUpdated(_bpx, _bsx, _bsx, 3);
                  }
               }
            } else if (!world.isClientSide()) {
               BlockPos _bpxx = BlockPos.containing(x, y, z);
               BlockEntity _blockEntityxx = world.getBlockEntity(_bpxx);
               BlockState _bsxx = world.getBlockState(_bpxx);
               if (_blockEntityxx != null) {
                  _blockEntityxx.getPersistentData().putDouble("trophy_entity_size", (double)Mth.nextInt(RandomSource.create(), 1, 100));
               }

               if (world instanceof Level _level) {
                  _level.sendBlockUpdated(_bpxx, _bsxx, _bsxx, 3);
               }
            }
         }
      }
   }
}
