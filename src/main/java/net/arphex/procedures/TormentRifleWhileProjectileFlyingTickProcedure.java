package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
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
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class TormentRifleWhileProjectileFlyingTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         double homing = 0.0;
         double source_distance = 0.0;
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
            }
         }

         ArphexMod.queueServerWork(5, () -> {
            immediatesourceentity.getPersistentData().putDouble("fixedxvel", immediatesourceentity.getDeltaMovement().x());
            immediatesourceentity.getPersistentData().putDouble("fixedyvel", immediatesourceentity.getDeltaMovement().y());
            immediatesourceentity.getPersistentData().putDouble("fixedzvel", immediatesourceentity.getDeltaMovement().z());
         });
         ArphexMod.queueServerWork(2, () -> immediatesourceentity.setNoGravity(true));
         ArphexMod.queueServerWork(450, () -> {
            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }
         });
         if (!world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x, y, z), 40.0, 40.0, 40.0), e -> true).isEmpty()) {
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiterator instanceof Player) {
                  double _setval = 60.0;
                  entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.shadertime = _setval;
                     capability.syncPlayerVariables(entityiterator);
                  });
               }

               if (entityiterator instanceof LivingEntity && entityiterator != entity) {
                  if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.TORMENT.get(), 20, 0, false, false));
                  }

                  if (world instanceof ServerLevel _level) {
                     _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 20, 0.6, 0.7, 0.6, 0.5);
                  }

                  if ((float)(100 / (((entityiterator instanceof LivingEntity _livEntx ? _livEntx.getArmorValue() : 0) + 4) / 4))
                     > (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 20.0F) {
                     entityiterator.hurt(
                        new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_PROJECTILE), entity),
                        (float)(100 / (((entityiterator instanceof LivingEntity _livEntxx ? _livEntxx.getArmorValue() : 0) + 4) / 4))
                     );
                  } else {
                     entityiterator.hurt(
                        new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_PROJECTILE), entity),
                        (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 20.0F
                     );
                  }

                  if ((Boolean)ConfigurationSettingsConfiguration.TORMENTOR_GRIEFING.get() && world instanceof Level _level && !_level.isClientSide()) {
                     _level.explode(null, x, y, z, 7.0F, ExplosionInteraction.MOB);
                  }

                  if (!immediatesourceentity.level().isClientSide()) {
                     immediatesourceentity.discard();
                  }

                  entityiterator.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
               }
            }

            if (Mth.nextInt(RandomSource.create(), 1, 60) == 1) {
               _center = new Vec3(x, y, z);

               for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiterator instanceof LivingEntity && entityiterator != entity && entityiterator.getPersistentData().getBoolean("tormentor_target")) {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.DEATH_SMOKE.get(), x, y, z, 2, 0.6, 0.7, 0.6, 0.5);
                     }

                     if ((float)(50 / (((entityiterator instanceof LivingEntity _livEntx ? _livEntx.getArmorValue() : 0) + 4) / 4))
                        > (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 20.0F) {
                        entityiterator.hurt(
                           new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_PROJECTILE)),
                           (float)(50 / (((entityiterator instanceof LivingEntity _livEntxx ? _livEntxx.getArmorValue() : 0) + 4) / 4))
                        );
                     } else {
                        entityiterator.hurt(
                           new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_PROJECTILE)),
                           (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 40.0F
                        );
                     }

                     if ((Boolean)ConfigurationSettingsConfiguration.TORMENTOR_GRIEFING.get() && world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.explode(null, x, y, z, 12.0F, ExplosionInteraction.MOB);
                        }
                     }

                     if (!immediatesourceentity.level().isClientSide()) {
                        immediatesourceentity.discard();
                     }
                  }
               }
            }
         }

         if (immediatesourceentity.getPersistentData().getDouble("fixedxvel") != 0.0) {
            immediatesourceentity.setDeltaMovement(
               new Vec3(
                  immediatesourceentity.getPersistentData().getDouble("fixedxvel"),
                  immediatesourceentity.getPersistentData().getDouble("fixedyvel"),
                  immediatesourceentity.getPersistentData().getDouble("fixedzvel")
               )
            );
         }

         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "particle arphex:solid_smoke ~ ~ ~ 0 0 0 0 5 force"
               );
         }

         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "particle arphex:white_particles ~ ~2 ~ 0 0 0 0 1 force"
               );
         }

         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "particle arphex:white_particles ~ ~-2 ~ 0 0 0 0 1 force"
               );
         }

         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "particle arphex:white_particles ~2 ~ ~ 0 0 0 0 1 force"
               );
         }

         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "particle arphex:white_particles ~-2 ~ ~ 0 0 0 0 1 force"
               );
         }

         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "particle arphex:white_particles ~ ~ ~2 0 0 0 0 1 force"
               );
         }

         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "particle arphex:white_particles ~ ~ ~-2 0 0 0 0 1 force"
               );
         }

         ArphexMod.queueServerWork(
            4,
            () -> {
               if (world instanceof ServerLevel _levelx) {
                  _levelx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelx, 4, "", Component.literal(""), _levelx.getServer(), null
                           )
                           .withSuppressedOutput(),
                        "particle arphex:heavy_white_smokes ~ ~ ~ 0.05 0.05 0.05 0 1 force"
                     );
               }
            }
         );
         if (!(ArphexModVariables.MapVariables.get(world).tormentor_health > 0.0)) {
            if (world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                        .withSuppressedOutput(),
                     "kill @e[type=arphex:torment_rifle]"
                  );
            }

            if (world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                        .withSuppressedOutput(),
                     "kill @e[type=arphex:torment_blast]"
                  );
            }
         }
      }
   }
}
