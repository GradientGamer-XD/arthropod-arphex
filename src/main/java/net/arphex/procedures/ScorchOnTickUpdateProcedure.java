package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.init.ArphexModBlocks;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;

public class ScorchOnTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      double xrans = 0.0;
      double yrans = 0.0;
      double zrans = 0.0;
      if (Mth.nextInt(RandomSource.create(), 1, 10) == 2) {
         if (world instanceof Level _level) {
            if (!_level.isClientSide()) {
               _level.playSound(
                  null,
                  BlockPos.containing(x + 0.5, y, z + 0.5),
                  (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.ambient")),
                  SoundSource.NEUTRAL,
                  0.4F,
                  0.5F
               );
            } else {
               _level.playLocalSound(
                  x + 0.5,
                  y,
                  z + 0.5,
                  (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.ambient")),
                  SoundSource.NEUTRAL,
                  0.4F,
                  0.5F,
                  false
               );
            }
         }

         if (world instanceof ServerLevel _levelx) {
            _levelx.sendParticles(ParticleTypes.SMOKE, x + 0.5, y, z + 0.5, 15, 0.5, 0.5, 0.5, 0.2);
         }

         if (world instanceof ServerLevel _levelx) {
            _levelx.sendParticles(ParticleTypes.LARGE_SMOKE, x + 0.5, y, z + 0.5, 7, 0.1, 0.1, 0.1, 0.07);
         }

         if (world instanceof ServerLevel _levelx) {
            _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.SCORCH_FLAME.get(), x + 0.5, y, z + 0.5, 5, 0.3, 0.3, 0.3, 0.02);
         }

         ArphexMod.queueServerWork(10, () -> {
            if (world instanceof ServerLevel _levelx) {
               _levelx.sendParticles(ParticleTypes.LARGE_SMOKE, x + 0.5, y, z + 0.5, 7, 0.1, 0.1, 0.1, 0.07);
            }
         });
         if (Mth.nextInt(RandomSource.create(), 1, 4) == 2
            && world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() != ArphexModBlocks.CRAWLING_BARRIER.get()
            && world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() != Blocks.CRYING_OBSIDIAN
            && world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() != ArphexModBlocks.SCORCHED_SAND.get()
            && world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() != Blocks.OBSIDIAN
            && world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() != ArphexModBlocks.SCORCH_PILLAR.get()) {
            world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
         }

         xrans = (double)Mth.nextInt(RandomSource.create(), -1, 1);
         yrans = (double)Mth.nextInt(RandomSource.create(), -1, 1);
         zrans = (double)Mth.nextInt(RandomSource.create(), -1, 1);
         if ((xrans != 0.0 || yrans != 0.0 || zrans != 0.0)
            && world.isEmptyBlock(BlockPos.containing(x + xrans, y + yrans, z + zrans))
            && (double)world.getBlockState(BlockPos.containing(x + xrans, y + yrans - 1.0, z + zrans))
                  .getDestroySpeed(world, BlockPos.containing(x + xrans, y + yrans - 1.0, z + zrans))
               >= 0.2
            && (xrans != 0.0 || yrans != 0.0 || zrans != 0.0)) {
            world.setBlock(BlockPos.containing(x + xrans, y + yrans, z + zrans), Blocks.FIRE.defaultBlockState(), 3);
         }
      }
   }
}
