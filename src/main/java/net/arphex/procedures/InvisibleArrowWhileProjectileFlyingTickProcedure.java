package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class InvisibleArrowWhileProjectileFlyingTickProcedure {
   public static void execute(LevelAccessor world, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         immediatesourceentity.setNoGravity(true);
         ArphexMod.queueServerWork(200, () -> {
            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }
         });
      }
   }
}
