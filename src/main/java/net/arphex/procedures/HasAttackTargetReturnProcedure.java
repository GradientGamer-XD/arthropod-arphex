package net.arphex.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;

public class HasAttackTargetReturnProcedure {
   public static boolean execute(Entity entity) {
      return entity == null ? false : (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null;
   }
}
