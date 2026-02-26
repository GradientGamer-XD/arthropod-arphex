package net.arphex.procedures;

import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class FlyFestererTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity.getPersistentData().getDouble("immunelimitfly") > 0.0) {
            entity.getPersistentData().putDouble("immunelimitfly", entity.getPersistentData().getDouble("immunelimitfly") - 1.0);
         }

         if (world.isEmptyBlock(BlockPos.containing(x, y - 0.1, z))) {
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
         }

         if (!(entity.getPersistentData().getDouble("flywalk") > 1000.0)) {
            entity.getPersistentData().putDouble("flywalk", entity.getPersistentData().getDouble("flywalk") + (double)Mth.nextInt(RandomSource.create(), 0, 2));
         } else {
            entity.getPersistentData().putDouble("flywalk", 0.0);
         }

         if (entity.getPersistentData().getDouble("flywalk") < 150.0) {
            entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), -0.4, entity.getDeltaMovement().z()));
         } else {
            if (!(entity.getPersistentData().getDouble("flyboost") > 0.0)) {
               if (!world.isClientSide()) {
                  entity.lookAt(
                     Anchor.EYES,
                     new Vec3(
                        entity.getX() + Mth.nextDouble(RandomSource.create(), -1.0, 1.0), y, entity.getZ() + Mth.nextDouble(RandomSource.create(), -1.0, 1.0)
                     )
                  );
               }

               entity.getPersistentData().putDouble("flyboost", (double)Mth.nextInt(RandomSource.create(), 20, 80));
            } else {
               entity.getPersistentData().putDouble("flyboost", entity.getPersistentData().getDouble("flyboost") - 1.0);
            }

            if (!(entity.getPersistentData().getDouble("yboost") > 0.0)) {
               if (world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() - 0.1, entity.getZ()))) {
                  entity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                        Mth.nextDouble(RandomSource.create(), -0.5, 0.3),
                        Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                     )
                  );
               } else {
                  entity.setDeltaMovement(new Vec3(0.0, Mth.nextDouble(RandomSource.create(), -0.5, 0.3), 0.0));
               }

               entity.getPersistentData().putDouble("yboost", (double)Mth.nextInt(RandomSource.create(), 15, 20));
            } else {
               entity.getPersistentData().putDouble("yboost", entity.getPersistentData().getDouble("flyboost") - 1.0);
            }
         }

         if (entity.isInWater()) {
            entity.setDeltaMovement(
               new Vec3(
                  Mth.nextDouble(RandomSource.create(), -1.0, 1.0),
                  Mth.nextDouble(RandomSource.create(), 0.3, 0.8),
                  Mth.nextDouble(RandomSource.create(), -1.0, 1.0)
               )
            );
         }

         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 2, 0.2, 0.2, 0.2, 0.1);
         }
      }
   }
}
