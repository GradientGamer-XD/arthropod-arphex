package net.arphex.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;

public class OwnerProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         if (entity instanceof TamableAnimal _tamEntx
            && _tamEntx.isTame()
            && (entity instanceof TamableAnimal _tamEnt ? _tamEnt.getOwner() : null) == (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null)) {
            return false;
         }

         return true;
      }
   }
}
