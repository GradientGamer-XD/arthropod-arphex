package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.TormentorVoidlasherSummonEntity;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class VoidSpearWhileProjectileFlyingTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         double homing = 0.0;
         double source_distance = 0.0;
         ArphexMod.queueServerWork(8, () -> entity.getPersistentData().putBoolean("firedaway", true));
         ArphexMod.queueServerWork(2, () -> immediatesourceentity.setNoGravity(true));
         if (immediatesourceentity.isNoGravity()) {
            if (immediatesourceentity.getPersistentData().getBoolean("reverse_mirror_attack")) {
               source_distance = Math.sqrt(
                  (immediatesourceentity.getX() - entity.getX()) * (immediatesourceentity.getX() - entity.getX())
                     + (immediatesourceentity.getY() - entity.getY()) * (immediatesourceentity.getY() - entity.getY())
                     + (immediatesourceentity.getZ() - entity.getZ()) * (immediatesourceentity.getZ() - entity.getZ())
               );
               if (source_distance != 0.0) {
                  immediatesourceentity.getPersistentData().putDouble("fixedxvel", (entity.getX() - immediatesourceentity.getX()) / source_distance * 2.0);
                  immediatesourceentity.getPersistentData().putDouble("fixedyvel", (entity.getY() - immediatesourceentity.getY()) / source_distance * 2.0);
                  immediatesourceentity.getPersistentData().putDouble("fixedzvel", (entity.getZ() - immediatesourceentity.getZ()) / source_distance * 2.0);
                  immediatesourceentity.setDeltaMovement(
                     new Vec3(
                        immediatesourceentity.getPersistentData().getDouble("fixedxvel"),
                        immediatesourceentity.getPersistentData().getDouble("fixedyvel"),
                        immediatesourceentity.getPersistentData().getDouble("fixedzvel")
                     )
                  );
               }
            }
         } else {
            immediatesourceentity.teleportTo(
               x + (double)Mth.nextInt(RandomSource.create(), -2, 2), y + 2.5, z + (double)Mth.nextInt(RandomSource.create(), -2, 2)
            );
            if (immediatesourceentity instanceof ServerPlayer _serverPlayer) {
               _serverPlayer.connection
                  .teleport(
                     x + (double)Mth.nextInt(RandomSource.create(), -2, 2),
                     y + 2.5,
                     z + (double)Mth.nextInt(RandomSource.create(), -2, 2),
                     immediatesourceentity.getYRot(),
                     immediatesourceentity.getXRot()
                  );
            }

            if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null) {
               if (!immediatesourceentity.level().isClientSide()) {
                  immediatesourceentity.discard();
               }
            } else {
               homing = Math.sqrt(
                  Math.pow((entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getX() - immediatesourceentity.getX(), 2.0)
                     + Math.pow((entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getY() + 0.6 - immediatesourceentity.getY(), 2.0)
                     + Math.pow((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getZ() - immediatesourceentity.getZ(), 2.0)
               );
               if (entity instanceof TormentorVoidlasherSummonEntity) {
                  immediatesourceentity.setDeltaMovement(
                     new Vec3(
                        (
                              (entity instanceof Mob _mobEntxxxxxx ? _mobEntxxxxxx.getTarget() : null).getX()
                                 + Mth.nextDouble(RandomSource.create(), -2.0, 2.0)
                                 - immediatesourceentity.getX()
                           )
                           / homing
                           * 3.0,
                        (
                              (entity instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null).getY()
                                 + Mth.nextDouble(RandomSource.create(), 0.0, 1.3)
                                 - immediatesourceentity.getY()
                           )
                           / homing
                           * 3.0,
                        (
                              (entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getZ()
                                 + Mth.nextDouble(RandomSource.create(), -2.0, 2.0)
                                 - immediatesourceentity.getZ()
                           )
                           / homing
                           * 3.0
                     )
                  );
               } else {
                  immediatesourceentity.setDeltaMovement(
                     new Vec3(
                        ((entity instanceof Mob _mobEntxxxxxx ? _mobEntxxxxxx.getTarget() : null).getX() - immediatesourceentity.getX()) / homing * 0.9,
                        ((entity instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null).getY() + 0.2 - immediatesourceentity.getY()) / homing * 0.9,
                        ((entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getZ() - immediatesourceentity.getZ()) / homing * 0.9
                     )
                  );
               }
            }
         }

         if (entity instanceof TormentorVoidlasherSummonEntity) {
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (!immediatesourceentity.getPersistentData().getBoolean("doneit") && entityiterator instanceof LivingEntity && entityiterator != entity) {
                  immediatesourceentity.getPersistentData().putBoolean("doneit", true);
                  if ((entityiterator instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F) / 10.0F
                     > (float)(50 - (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) / 10)) {
                     entityiterator.hurt(
                        new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity),
                        (entityiterator instanceof LivingEntity _livEntxx ? _livEntxx.getMaxHealth() : -1.0F) / 10.0F
                     );
                  } else {
                     entityiterator.hurt(
                        new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity),
                        (float)(50 - (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) / 10)
                     );
                  }

                  if (!immediatesourceentity.level().isClientSide()) {
                     immediatesourceentity.discard();
                  }

                  if (world instanceof ServerLevel _level) {
                     _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 15, 0.3, 0.3, 0.3, 0.6);
                  }
               }
            }
         }

         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 15, 0.0, 0.0, 0.0, 0.2);
         }

         ArphexMod.queueServerWork(Mth.nextInt(RandomSource.create(), 150, 300), () -> {
            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }
         });
      }
   }
}
