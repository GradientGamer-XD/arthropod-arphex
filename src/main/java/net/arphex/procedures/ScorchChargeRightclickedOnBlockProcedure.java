package net.arphex.procedures;

import net.arphex.init.ArphexModBlocks;
import net.arphex.init.ArphexModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;

public class ScorchChargeRightclickedOnBlockProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z))
            && (
               (double)world.getBlockState(BlockPos.containing(x, y, z)).getDestroySpeed(world, BlockPos.containing(x, y, z)) >= 0.2
                  || world.getBlockState(BlockPos.containing(x, y, z)).getDestroySpeed(world, BlockPos.containing(x, y, z)) < 0.0F
                  || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ArphexModBlocks.CRAWLING_BARRIER.get()
            )
            && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != ArphexModBlocks.MANGLED_SPIDER_FLESH.get()
            && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != ArphexModBlocks.MANGLED_SCORPION_FLESH.get()
            && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != ArphexModBlocks.MANGLED_FLY_FLESH.get()) {
            if (!entity.getPersistentData().getBoolean("creativespectator") && entity instanceof Player _player) {
               ItemStack _stktoremove = new ItemStack((ItemLike)ArphexModItems.SCORCH_CHARGE.get());
               _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
            }

            world.setBlock(BlockPos.containing(x, y + 1.0, z), ((Block)ArphexModBlocks.SCORCH.get()).defaultBlockState(), 3);
         }
      }
   }
}
