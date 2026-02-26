package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.TormentorVoidlasherSummonEntity;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class DraconFireWhileProjectileFlyingTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         boolean tpup = false;
         double homing = 0.0;
         double source_distance = 0.0;
         ArphexMod.queueServerWork(80, () -> immediatesourceentity.getPersistentData().putBoolean("chargedpowers", true));
         immediatesourceentity.setNoGravity(true);
         if (entity instanceof TormentorVoidlasherSummonEntity) {
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3.0), e -> true)
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

         if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null) {
            immediatesourceentity.setDeltaMovement(
               new Vec3((double)Mth.nextInt(RandomSource.create(), -1, 1), 0.0, (double)Mth.nextInt(RandomSource.create(), -1, 1))
            );
         } else {
            homing = Math.sqrt(
               Math.pow((entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getX() - immediatesourceentity.getX(), 2.0)
                  + Math.pow((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getY() - immediatesourceentity.getY(), 2.0)
                  + Math.pow((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getZ() - immediatesourceentity.getZ(), 2.0)
            );
            if (entity instanceof TormentorVoidlasherSummonEntity) {
               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                           .withSuppressedOutput(),
                        "particle arphex:long_heavy_purple_smoke ~ ~ ~ 1.4 1.4 1.4 0 50 force"
                     );
               }

               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                           .withSuppressedOutput(),
                        "particle arphex:solid_smoke ~ ~ ~ 0.1 0.1 0.1 0 5 force"
                     );
               }

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
               } else if (immediatesourceentity.getPersistentData().getBoolean("chargedpowers")) {
                  immediatesourceentity.setDeltaMovement(
                     new Vec3(
                        ((entity instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null).getX() - immediatesourceentity.getX()) / homing * 0.9,
                        ((entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getY() - immediatesourceentity.getY()) / homing * 0.9,
                        ((entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getZ() - immediatesourceentity.getZ()) / homing * 0.9
                     )
                  );
               }
            } else {
               if (world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_PURPLE_SMOKE.get(), x, y, z, 5, 0.3, 0.3, 2.0, 0.0);
               }

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
               } else {
                  immediatesourceentity.setDeltaMovement(
                     new Vec3(
                        ((entity instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null).getX() - immediatesourceentity.getX()) / homing * 0.3,
                        ((entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getY() - immediatesourceentity.getY()) / homing * 0.3,
                        ((entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getZ() - immediatesourceentity.getZ()) / homing * 0.3
                     )
                  );
               }
            }
         }

         if (entity instanceof TormentorVoidlasherSummonEntity) {
            ArphexMod.queueServerWork(380, () -> {
               if (!immediatesourceentity.level().isClientSide()) {
                  immediatesourceentity.discard();
               }
            });
         } else {
            ArphexMod.queueServerWork(Mth.nextInt(RandomSource.create(), 150, 300), () -> {
               if (!immediatesourceentity.level().isClientSide()) {
                  immediatesourceentity.discard();
               }
            });
         }
      }
   }
}
