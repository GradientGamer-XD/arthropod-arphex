package net.arphex.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class ReturnUseTimeProcedure {
   public static double execute(Entity entity) {
      if (entity == null) {
         return 0.0;
      } else {
         return entity instanceof LivingEntity _entUseTicks0 ? (double)_entUseTicks0.getTicksUsingItem() : 0.0;
      }
   }
}
