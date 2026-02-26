package net.arphex.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.TamableAnimal;

public class NotTamedConditionProcedure {
   public static boolean execute(Entity entity) {
      return entity == null ? false : (entity instanceof TamableAnimal _tamEnt ? !_tamEnt.isTame() : true);
   }
}
