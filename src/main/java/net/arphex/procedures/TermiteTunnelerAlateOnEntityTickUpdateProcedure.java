package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class TermiteTunnelerAlateOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putBoolean("arphex", true);
         if (!(entity.getPersistentData().getDouble("termitetick") > 0.0)) {
            entity.getPersistentData().putDouble("termitetick", (double)Mth.nextInt(RandomSource.create(), 200, 600));
            if (entity.getPersistentData().getBoolean("flymode")) {
               entity.getPersistentData().putBoolean("flymode", false);
            } else {
               entity.getPersistentData().putBoolean("flymode", true);
            }
         } else {
            entity.getPersistentData().putDouble("termitetick", entity.getPersistentData().getDouble("termitetick") - 1.0);
         }

         if (entity.getPersistentData().getBoolean("flymode")) {
            entity.setNoGravity(true);
            if (!(entity.getPersistentData().getDouble("termiteboost") > 0.0)) {
               entity.getPersistentData().putDouble("termiteboost", 20.0);
               if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null) {
                  if (Mth.nextInt(RandomSource.create(), 1, 5) == 2) {
                     entity.lookAt(
                        Anchor.EYES,
                        new Vec3(
                           entity.getX() + (double)Mth.nextInt(RandomSource.create(), -1, 1),
                           entity.getY(),
                           entity.getZ() + (double)Mth.nextInt(RandomSource.create(), -1, 1)
                        )
                     );
                  }

                  entity.setDeltaMovement(
                     new Vec3(
                        Mth.nextDouble(RandomSource.create(), -0.6, 0.6),
                        Mth.nextDouble(RandomSource.create(), -0.6, 0.9),
                        Mth.nextDouble(RandomSource.create(), -0.6, 0.6)
                     )
                  );
                  ArphexMod.queueServerWork(
                     10,
                     () -> entity.setDeltaMovement(
                           new Vec3(
                              Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                              entity.getDeltaMovement().y(),
                              Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                           )
                        )
                  );
               } else {
                  entity.lookAt(
                     Anchor.EYES,
                     new Vec3(
                        (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getX(),
                        (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getY(),
                        (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getZ()
                     )
                  );
                  entity.setDeltaMovement(
                     new Vec3(
                        ((entity instanceof Mob _mobEntxxxxxxxx ? _mobEntxxxxxxxx.getTarget() : null).getX() - entity.getX())
                           / Math.sqrt(
                              Math.pow((entity instanceof Mob _mobEntxxxxxxx ? _mobEntxxxxxxx.getTarget() : null).getX() - entity.getX(), 2.0)
                                 + Math.pow((entity instanceof Mob _mobEntxxxxxx ? _mobEntxxxxxx.getTarget() : null).getZ() - entity.getZ(), 2.0)
                           )
                           / 2.0,
                        entity.getDeltaMovement().y(),
                        ((entity instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null).getZ() - entity.getZ())
                           / Math.sqrt(
                              Math.pow((entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getX() - entity.getX(), 2.0)
                                 + Math.pow((entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getZ() - entity.getZ(), 2.0)
                           )
                           / 2.0
                     )
                  );
                  ArphexMod.queueServerWork(
                     17,
                     () -> entity.setDeltaMovement(
                           new Vec3(
                              Mth.nextDouble(RandomSource.create(), -0.2, 0.2),
                              Mth.nextDouble(RandomSource.create(), -0.8, 1.0),
                              Mth.nextDouble(RandomSource.create(), -0.2, 0.2)
                           )
                        )
                  );
                  if (entity.getY() < (entity instanceof Mob _mobEntxxxxxxxxx ? _mobEntxxxxxxxxx.getTarget() : null).getY()) {
                     entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), 0.4, entity.getDeltaMovement().z()));
                  } else {
                     entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), -0.4, entity.getDeltaMovement().z()));
                  }
               }
            } else {
               entity.getPersistentData().putDouble("termiteboost", entity.getPersistentData().getDouble("termiteboost") - 1.0);
            }
         } else {
            entity.setNoGravity(false);
         }
      }
   }
}
