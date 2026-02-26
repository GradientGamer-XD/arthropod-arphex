package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class MiniatureCoreWhileProjectileFlyingTickProcedure {
   public static void execute(LevelAccessor world, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         immediatesourceentity.setNoGravity(true);
         ArphexMod.queueServerWork(100, () -> {
            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }
         });
      }
   }
}
