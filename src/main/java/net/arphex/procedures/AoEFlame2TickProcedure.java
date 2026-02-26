package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AoEFlame2TickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         ArphexMod.queueServerWork(3, () -> immediatesourceentity.getPersistentData().putBoolean("pastsource", true));
         if (!world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x, y, z), 1.0, 1.0, 1.0), e -> true).isEmpty()
            && immediatesourceentity.getPersistentData().getBoolean("pastsource")) {
            ArphexMod.queueServerWork(3, () -> {
               if (!immediatesourceentity.level().isClientSide()) {
                  immediatesourceentity.discard();
               }
            });
         }

         ArphexMod.queueServerWork(11, () -> {
            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }
         });
         immediatesourceentity.setNoGravity(true);
      }
   }
}
