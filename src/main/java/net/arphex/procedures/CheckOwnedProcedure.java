package net.arphex.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;

public class CheckOwnedProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         if (entity instanceof TamableAnimal _tamEntxx
            && _tamEntxx.isTame()
            && (
               (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) instanceof TamableAnimal _tamIsTamedBy
                     && (entity instanceof TamableAnimal _tamEntx ? _tamEntx.getOwner() : null) instanceof LivingEntity _livEnt
                     && _tamIsTamedBy.isOwnedBy(_livEnt)
                  || (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == (entity instanceof TamableAnimal _tamEnt ? _tamEnt.getOwner() : null)
            )) {
            return false;
         }

         return true;
      }
   }
}
