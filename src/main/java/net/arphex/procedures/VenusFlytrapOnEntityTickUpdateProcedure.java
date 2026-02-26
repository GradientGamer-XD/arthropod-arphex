package net.arphex.procedures;

import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class VenusFlytrapOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         entity.setDeltaMovement(new Vec3(0.0, -0.3, 0.0));
         if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null && !world.isClientSide()) {
            entity.lookAt(
               Anchor.EYES,
               new Vec3(
                  (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getX(),
                  (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getY() - 0.8,
                  (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getZ()
               )
            );
         }

         if (entity.getPersistentData().getBoolean("nocompost") && !entity.level().isClientSide()) {
            entity.discard();
         }

         if (entity.getDisplayName().getString().equals("Venus Flytrap")
            && (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) != null
            && (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof Player
            && entity instanceof Mob) {
            try {
               ((Mob)entity).setTarget(null);
            } catch (Exception var5) {
               var5.printStackTrace();
            }
         }
      }
   }
}
