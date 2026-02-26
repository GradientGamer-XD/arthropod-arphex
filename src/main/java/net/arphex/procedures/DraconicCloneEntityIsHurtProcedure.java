package net.arphex.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class DraconicCloneEntityIsHurtProcedure {
   public static void execute(Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         if ((sourceentity instanceof Player || sourceentity instanceof LivingEntity) && !entity.level().isClientSide()) {
            entity.discard();
         }
      }
   }
}
