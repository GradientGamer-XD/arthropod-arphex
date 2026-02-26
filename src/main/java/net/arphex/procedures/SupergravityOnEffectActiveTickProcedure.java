package net.arphex.procedures;

import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class SupergravityOnEffectActiveTickProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if ((double)world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ()))
                  .getDestroySpeed(world, BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ()))
               < 0.3
            && world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ()))
                  .getDestroySpeed(world, BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ()))
               > -1.0F
            && !entity.getPersistentData().getBoolean("creativespectator")) {
            if (entity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("§cGravity is being manipulated to pull you down!"), true);
            }

            entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), Math.min(entity.getDeltaMovement().y() - 0.15, 0.0), entity.getDeltaMovement().z()));
            if (world instanceof ServerLevel _level) {
               _level.sendParticles(
                  (SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), entity.getX(), entity.getY() - 4.0, entity.getZ(), 50, 0.1, 1.5, 0.1, 0.0
               );
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles(
                  (SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), entity.getX(), entity.getY() - 4.0, entity.getZ(), 5, 0.1, 1.5, 0.1, 0.0
               );
            }
         }
      }
   }
}
