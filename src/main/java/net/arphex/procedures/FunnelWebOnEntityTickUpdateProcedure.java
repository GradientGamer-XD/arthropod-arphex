package net.arphex.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Map.Entry;
import net.arphex.init.ArphexModBlocks;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

public class FunnelWebOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == ArphexModBlocks.CRAWLING_COMPOST.get()
            || world.getBlockState(BlockPos.containing(x + 1.0, y - 1.0, z)).getBlock() == Blocks.GRASS_BLOCK
               && world.getBlockState(BlockPos.containing(x - 1.0, y - 1.0, z)).getBlock() == Blocks.GRASS_BLOCK
               && world.getBlockState(BlockPos.containing(x, y - 1.0, z - 1.0)).getBlock() == Blocks.GRASS_BLOCK
               && world.getBlockState(BlockPos.containing(x, y - 1.0, z + 1.0)).getBlock() == Blocks.GRASS_BLOCK
               && world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.GRASS_BLOCK) {
            BlockPos _bp = BlockPos.containing(x, y - 1.0, z);
            BlockState _bs = ((Block)ArphexModBlocks.FUNNEL_WEB.get()).defaultBlockState();
            BlockState _bso = world.getBlockState(_bp);
            UnmodifiableIterator var11 = _bso.getValues().entrySet().iterator();

            while (var11.hasNext()) {
               Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var11.next();
               Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
               if (_property != null && _bs.getValue(_property) != null) {
                  try {
                     _bs = (BlockState)_bs.setValue(_property, entry.getValue());
                  } catch (Exception var15) {
                  }
               }
            }

            world.setBlock(_bp, _bs, 3);
            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.TINY_SPIDER.get(), x, y, z, 20, 0.03, 0.03, 0.03, 0.1);
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.THIN_WEB.get(), x, y, z, 35, 0.01, 0.01, 0.01, 0.01);
            }
         } else if (!entity.level().isClientSide()) {
            entity.discard();
         }
      }
   }
}
