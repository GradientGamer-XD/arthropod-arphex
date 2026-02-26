package net.arphex.procedures;

import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class LongFlyTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (world.isEmptyBlock(BlockPos.containing(x, y - 0.1, z))) {
            if (entity.getPersistentData().getDouble("chaostime") == 5.0 && !entity.isSwimming()) {
               entity.setDeltaMovement(
                  new Vec3(
                     entity.getDeltaMovement().x() + Mth.nextDouble(RandomSource.create(), -0.5, 0.5),
                     entity.getDeltaMovement().y() + Mth.nextDouble(RandomSource.create(), -0.2, 0.2),
                     entity.getDeltaMovement().z() + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)
                  )
               );
            }

            entity.setShiftKeyDown(false);
            if (world.isEmptyBlock(BlockPos.containing(x + 0.5, y, z))
               && world.isEmptyBlock(BlockPos.containing(x - 0.5, y, z))
               && world.isEmptyBlock(BlockPos.containing(x, y, z + 0.5))
               && world.isEmptyBlock(BlockPos.containing(x, y, z - 0.5))) {
               entity.setSprinting(false);
            } else if (!(entity.getDeltaMovement().x() < 0.1) && !(entity.getDeltaMovement().z() < 0.1)) {
               entity.setSprinting(true);
            } else {
               entity.setSprinting(false);
            }
         } else {
            entity.setShiftKeyDown(true);
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 10, false, false));
            }
         }

         if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null) {
            if (!(entity.getPersistentData().getDouble("flywalk") > 1000.0)) {
               entity.getPersistentData()
                  .putDouble("flywalk", entity.getPersistentData().getDouble("flywalk") + (double)Mth.nextInt(RandomSource.create(), 0, 2));
            } else {
               entity.getPersistentData().putDouble("flywalk", 0.0);
            }
         } else {
            entity.setSprinting(false);
            entity.getPersistentData().putDouble("flywalk", 1000.0);
            if (!(entity.getPersistentData().getDouble("flyboost") > 0.0)) {
               entity.getPersistentData().putDouble("flyboost", (double)Mth.nextInt(RandomSource.create(), 5, 40));
               if (entity.getY() < (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getY() + 0.5) {
                  entity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                        0.3,
                        Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                     )
                  );
               } else {
                  entity.lookAt(
                     Anchor.EYES,
                     new Vec3(
                        (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getX(),
                        (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getY(),
                        (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getZ()
                     )
                  );
                  entity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                        -0.2,
                        Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                     )
                  );
               }
            } else {
               entity.getPersistentData().putDouble("flyboost", entity.getPersistentData().getDouble("flyboost") - 1.0);
            }
         }

         if (!(entity.getPersistentData().getDouble("chaostime") > 0.0)) {
            entity.getPersistentData().putDouble("chaostime", (double)Mth.nextInt(RandomSource.create(), 5, 40));
         } else {
            entity.getPersistentData().putDouble("chaostime", entity.getPersistentData().getDouble("flyboost") - 1.0);
         }

         if (entity.getPersistentData().getDouble("flywalk") < 150.0) {
            entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x() / 8.0, -0.4, entity.getDeltaMovement().z() / 8.0));
         }

         if (entity.isInWater()) {
            entity.setDeltaMovement(
               new Vec3(entity.getDeltaMovement().x() / 8.0, Mth.nextDouble(RandomSource.create(), 0.3, 0.8), entity.getDeltaMovement().z() / 8.0)
            );
         }
      }
   }
}
