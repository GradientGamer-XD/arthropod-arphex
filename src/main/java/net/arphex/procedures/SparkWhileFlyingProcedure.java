package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class SparkWhileFlyingProcedure {
   public static void execute(LevelAccessor world, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         Entity attack_target = null;
         double dist = 0.0;
         double source_distance = 0.0;
         double pitch_variance = 0.0;
         double random_once = 0.0;
         double store_dist = 0.0;
         double distance_scaling_factor = 0.0;
         double yaw_variance = 0.0;
         ArphexMod.queueServerWork(200, () -> {
            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }
         });
         immediatesourceentity.setDeltaMovement(new Vec3(0.0, -0.8 - immediatesourceentity.getPersistentData().getDouble("speedup_lim"), 0.0));
         immediatesourceentity.getPersistentData().putDouble("speedup_lim", immediatesourceentity.getPersistentData().getDouble("speedup_lim") + 0.2);
      }
   }
}
