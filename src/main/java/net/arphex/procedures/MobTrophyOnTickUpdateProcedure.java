package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;

public class MobTrophyOnTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if ((new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0;
         }
      }).getValue(world, BlockPos.containing(x, y, z), "milestone_number") > 19.0) {
         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(), x + 0.5, y + 0.7, z + 0.5, 5, 0.0, 0.0, 0.0, 0.0);
         }

         ArphexMod.queueServerWork(5, () -> {
            if (world instanceof ServerLevel _levelx) {
               _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_GOLD_SMOKE.get(), x + 0.5, y + 0.7, z + 0.5, 5, 0.0, 0.0, 0.0, 0.0);
            }
         });
      } else if ((new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0;
         }
      }).getValue(world, BlockPos.containing(x, y, z), "milestone_number") > 14.0) {
         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_GREEN_SMOKE.get(), x + 0.5, y + 0.7, z + 0.5, 5, 0.0, 0.0, 0.0, 0.0);
         }
      } else if ((new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0;
         }
      }).getValue(world, BlockPos.containing(x, y, z), "milestone_number") > 9.0) {
         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_PURPLE_SMOKE.get(), x + 0.5, y + 0.7, z + 0.5, 5, 0.0, 0.0, 0.0, 0.0);
         }
      } else if ((new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0;
         }
      }).getValue(world, BlockPos.containing(x, y, z), "milestone_number") > 4.0 && world instanceof ServerLevel _level) {
         _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x + 0.5, y + 0.7, z + 0.5, 5, 0.0, 0.0, 0.0, 0.0);
      }
   }
}
