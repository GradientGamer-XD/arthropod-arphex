package net.arphex.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;

public class PlayerRangeProcedure {
   public static boolean execute(Entity entity) {
      return entity == null
         ? false
         : (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) != null
            && !((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof Player);
   }
}
