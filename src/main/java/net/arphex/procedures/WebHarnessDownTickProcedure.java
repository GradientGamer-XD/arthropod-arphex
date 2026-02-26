package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class WebHarnessDownTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double lineX = 0.0;
         double lineY = 0.0;
         double lineZ = 0.0;
         double expand = 0.0;
         if (entity.getPersistentData().getBoolean("hovers") && entity.getY() < entity.getPersistentData().getDouble("hoverpos")) {
            entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), 0.2, entity.getDeltaMovement().z()));
         }

         if (world instanceof ServerLevel _level) {
            _level.sendParticles(
               (SimpleParticleType)ArphexModParticleTypes.THIN_WEB.get(),
               entity.getPersistentData().getDouble("targetX"),
               entity.getPersistentData().getDouble("targetY"),
               entity.getPersistentData().getDouble("targetZ"),
               10,
               0.1,
               0.1,
               0.1,
               0.1
            );
         }

         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.THIN_WEB.get(), x, y + 3.0, z, 10, 0.1, 0.2, 0.1, 0.1);
         }

         entity.lookAt(
            Anchor.EYES,
            new Vec3(
               entity.getPersistentData().getDouble("targetX"),
               entity.getPersistentData().getDouble("targetY"),
               entity.getPersistentData().getDouble("targetZ")
            )
         );
         if (!(entity.getX() > entity.getPersistentData().getDouble("targetX") - 5.0)
            || !(entity.getX() < entity.getPersistentData().getDouble("targetX") + 5.0)
            || !(entity.getY() > entity.getPersistentData().getDouble("targetY") - 20.0)
            || !(entity.getY() < entity.getPersistentData().getDouble("targetY") + 20.0)
            || !(entity.getZ() > entity.getPersistentData().getDouble("targetZ") - 5.0)
            || !(entity.getZ() < entity.getPersistentData().getDouble("targetZ") + 5.0)) {
            if (entity.getX() > entity.getPersistentData().getDouble("targetX") - 8.0
               && entity.getX() < entity.getPersistentData().getDouble("targetX") + 8.0
               && entity.getY() > entity.getPersistentData().getDouble("targetY") - 30.0
               && entity.getY() < entity.getPersistentData().getDouble("targetY") + 30.0
               && entity.getZ() > entity.getPersistentData().getDouble("targetZ") - 8.0
               && entity.getZ() < entity.getPersistentData().getDouble("targetZ") + 8.0) {
               if (entity.getY() < entity.getPersistentData().getDouble("targetY") - 10.0) {
                  entity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 8.0,
                        0.4,
                        Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 8.0
                     )
                  );
               } else {
                  entity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 8.0,
                        0.05,
                        Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 8.0
                     )
                  );
               }
            } else if (!entity.level().isClientSide()) {
               entity.discard();
            }
         }

         if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).isEmpty() && !entity.level().isClientSide()
            )
          {
            entity.discard();
         }

         if (!world.getBlockState(
                  BlockPos.containing(
                     entity.getPersistentData().getDouble("targetX"),
                     entity.getPersistentData().getDouble("targetY") - 1.0,
                     entity.getPersistentData().getDouble("targetZ")
                  )
               )
               .canOcclude()
            && !world.getBlockState(
                  BlockPos.containing(
                     entity.getPersistentData().getDouble("targetX") + 1.0,
                     entity.getPersistentData().getDouble("targetY"),
                     entity.getPersistentData().getDouble("targetZ")
                  )
               )
               .canOcclude()
            && !world.getBlockState(
                  BlockPos.containing(
                     entity.getPersistentData().getDouble("targetX") - 1.0,
                     entity.getPersistentData().getDouble("targetY") - 1.0,
                     entity.getPersistentData().getDouble("targetZ")
                  )
               )
               .canOcclude()
            && !world.getBlockState(
                  BlockPos.containing(
                     entity.getPersistentData().getDouble("targetX"),
                     entity.getPersistentData().getDouble("targetY") + 1.0,
                     entity.getPersistentData().getDouble("targetZ")
                  )
               )
               .canOcclude()
            && !world.getBlockState(
                  BlockPos.containing(
                     entity.getPersistentData().getDouble("targetX"),
                     entity.getPersistentData().getDouble("targetY") - 2.0,
                     entity.getPersistentData().getDouble("targetZ")
                  )
               )
               .canOcclude()
            && !world.getBlockState(
                  BlockPos.containing(
                     entity.getPersistentData().getDouble("targetX"),
                     entity.getPersistentData().getDouble("targetY") - 1.0,
                     entity.getPersistentData().getDouble("targetZ") + 1.0
                  )
               )
               .canOcclude()
            && !world.getBlockState(
                  BlockPos.containing(
                     entity.getPersistentData().getDouble("targetX"),
                     entity.getPersistentData().getDouble("targetY") - 1.0,
                     entity.getPersistentData().getDouble("targetZ") - 1.0
                  )
               )
               .canOcclude()
            && !world.getBlockState(
                  BlockPos.containing(
                     entity.getPersistentData().getDouble("targetX") + 1.0,
                     entity.getPersistentData().getDouble("targetY") - 1.0,
                     entity.getPersistentData().getDouble("targetZ") - 1.0
                  )
               )
               .canOcclude()
            && !world.getBlockState(
                  BlockPos.containing(
                     entity.getPersistentData().getDouble("targetX") - 1.0,
                     entity.getPersistentData().getDouble("targetY") - 1.0,
                     entity.getPersistentData().getDouble("targetZ") - 1.0
                  )
               )
               .canOcclude()
            && !world.getBlockState(
                  BlockPos.containing(
                     entity.getPersistentData().getDouble("targetX") + 1.0,
                     entity.getPersistentData().getDouble("targetY") - 1.0,
                     entity.getPersistentData().getDouble("targetZ") + 1.0
                  )
               )
               .canOcclude()
            && !world.getBlockState(
                  BlockPos.containing(
                     entity.getPersistentData().getDouble("targetX") - 1.0,
                     entity.getPersistentData().getDouble("targetY") - 1.0,
                     entity.getPersistentData().getDouble("targetZ") + 1.0
                  )
               )
               .canOcclude()
            && !entity.level().isClientSide()) {
            entity.discard();
         }

         entity.fallDistance = 0.0F;
         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 60, 1, false, false));
         }

         lineX = entity.getX() - entity.getPersistentData().getDouble("targetX");
         lineY = entity.getY() + 3.0 - entity.getPersistentData().getDouble("targetY");
         lineZ = entity.getZ() - entity.getPersistentData().getDouble("targetZ");
         expand = expand;
         if (entity.isVehicle()) {
            for (int index0 = 0; index0 < 10; index0++) {
               if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                  if (world instanceof ServerLevel _level) {
                     _level.sendParticles(
                        (SimpleParticleType)ArphexModParticleTypes.THIN_WEB.get(),
                        entity.getX() + lineX * expand,
                        entity.getY() + 3.0 + lineY * expand,
                        entity.getZ() + lineZ * expand,
                        1,
                        0.05,
                        0.2,
                        0.05,
                        0.0
                     );
                  }

                  expand -= 0.1;
               }
            }
         } else {
            ArphexMod.queueServerWork(5, () -> {
               if (!entity.isVehicle() && !entity.level().isClientSide()) {
                  entity.discard();
               }
            });
         }
      }
   }
}
