package net.arphex.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Map.Entry;
import net.arphex.ArphexMod;
import net.arphex.entity.SpiderObstructerEntity;
import net.arphex.init.ArphexModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TrapdoorDirtOnTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (!world.isClientSide()) {
         if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ArphexModBlocks.TRAPDOOR_GRASS.get()
            && world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() != ArphexModBlocks.TRAPDOOR_DIRT.get()) {
            ArphexMod.queueServerWork(2, () -> {
               if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() != ArphexModBlocks.TRAPDOOR_DIRT.get()) {
                  BlockPos _bpx = BlockPos.containing(x, y, z);
                  BlockState _bsx = Blocks.GRASS_BLOCK.defaultBlockState();
                  BlockState _bsox = world.getBlockState(_bpx);
                  UnmodifiableIterator var10x = _bsox.getValues().entrySet().iterator();

                  while (var10x.hasNext()) {
                     Entry<Property<?>, Comparable<?>> entryx = (Entry<Property<?>, Comparable<?>>)var10x.next();
                     Property _propertyx = _bsx.getBlock().getStateDefinition().getProperty(entryx.getKey().getName());
                     if (_propertyx != null && _bsx.getValue(_propertyx) != null) {
                        try {
                           _bsx = (BlockState)_bsx.setValue(_propertyx, entryx.getValue());
                        } catch (Exception var14x) {
                        }
                     }
                  }

                  world.setBlock(_bpx, _bsx, 3);
               }
            });
         }

         if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ArphexModBlocks.TRAPDOOR_DIRT.get()
            && (
               world.isEmptyBlock(BlockPos.containing(x + 1.0, y, z))
                  || world.isEmptyBlock(BlockPos.containing(x - 1.0, y, z))
                  || world.isEmptyBlock(BlockPos.containing(x, y, z + 1.0))
                  || world.isEmptyBlock(BlockPos.containing(x, y, z - 1.0))
            )
            && world.getEntitiesOfClass(SpiderObstructerEntity.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true).isEmpty()
            && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true).isEmpty()) {
            BlockPos _bp = BlockPos.containing(x, y, z);
            BlockState _bs = Blocks.DIRT.defaultBlockState();
            BlockState _bso = world.getBlockState(_bp);
            UnmodifiableIterator var10 = _bso.getValues().entrySet().iterator();

            while (var10.hasNext()) {
               Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var10.next();
               Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
               if (_property != null && _bs.getValue(_property) != null) {
                  try {
                     _bs = (BlockState)_bs.setValue(_property, entry.getValue());
                  } catch (Exception var16) {
                  }
               }
            }

            world.setBlock(_bp, _bs, 3);
         }

         if (Mth.nextInt(RandomSource.create(), 1, 2) == 1
            && world.getEntitiesOfClass(SpiderObstructerEntity.class, AABB.ofSize(new Vec3(x, y, z), 25.0, 25.0, 25.0), e -> true).isEmpty()
            && world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x, y, z), 17.0, 17.0, 17.0), e -> true).isEmpty()
            && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 6.0, 6.0, 6.0), e -> true).isEmpty()) {
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ArphexModBlocks.TRAPDOOR_GRASS.get()) {
               BlockPos _bp = BlockPos.containing(x, y, z);
               BlockState _bs = Blocks.GRASS_BLOCK.defaultBlockState();
               BlockState _bso = world.getBlockState(_bp);
               UnmodifiableIterator var23 = _bso.getValues().entrySet().iterator();

               while (var23.hasNext()) {
                  Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var23.next();
                  Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                  if (_property != null && _bs.getValue(_property) != null) {
                     try {
                        _bs = (BlockState)_bs.setValue(_property, entry.getValue());
                     } catch (Exception var15) {
                     }
                  }
               }

               world.setBlock(_bp, _bs, 3);
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ArphexModBlocks.TRAPDOOR_DIRT.get()) {
               BlockPos _bp = BlockPos.containing(x, y, z);
               BlockState _bs = Blocks.DIRT.defaultBlockState();
               BlockState _bso = world.getBlockState(_bp);
               UnmodifiableIterator var24 = _bso.getValues().entrySet().iterator();

               while (var24.hasNext()) {
                  Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var24.next();
                  Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                  if (_property != null && _bs.getValue(_property) != null) {
                     try {
                        _bs = (BlockState)_bs.setValue(_property, entry.getValue());
                     } catch (Exception var14) {
                     }
                  }
               }

               world.setBlock(_bp, _bs, 3);
            }
         }
      }
   }
}
