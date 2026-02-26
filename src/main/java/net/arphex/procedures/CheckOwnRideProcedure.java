package net.arphex.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;

public class CheckOwnRideProcedure {
   public static boolean execute(Entity entity) {
      return entity == null
         ? false
         : !entity.isVehicle()
            && (
               !((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) instanceof TamableAnimal _tamIsTamedBy)
                  || !((entity instanceof TamableAnimal _tamEntx ? _tamEntx.getOwner() : null) instanceof LivingEntity _livEnt)
                  || !_tamIsTamedBy.isOwnedBy(_livEnt)
            )
            && (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != (entity instanceof TamableAnimal _tamEnt ? _tamEnt.getOwner() : null);
   }
}
