package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.TORMENTOREntity;
import net.arphex.entity.TormentorTendrilEntity;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class TormentBlastTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         boolean nearest = false;
         Entity entity_variable_limits_scans = null;
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
         if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
            if (world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                        .withSuppressedOutput(),
                     "particle arphex:solid_core ~ ~ ~ 0.05 0.05 0.05 0 1 force"
                  );
            }
         } else if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "particle arphex:solid_core_2 ~ ~ ~ 0.05 0.05 0.05 0 1 force"
               );
         }

         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "particle arphex:solid_smoke ~ ~ ~ 0.5 0.5 0.5 0.6 7 force"
               );
         }

         ArphexMod.queueServerWork(450, () -> {
            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }
         });
         ArphexMod.queueServerWork(80, () -> immediatesourceentity.getPersistentData().putBoolean("allow_selfharm", true));
         Vec3 _center = new Vec3(x, y, z);

         for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10.0), e -> true)
            .stream()
            .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
            .toList()) {
            if (immediatesourceentity.getPersistentData().getBoolean("allow_selfharm") && entityiterator instanceof TORMENTOREntity) {
               entityiterator.getPersistentData().putDouble("able_to_harm_self", 20.0);
            }

            if (entityiterator.getPersistentData().getBoolean("tormentor_target")
               && entity != entityiterator
               && !(entityiterator instanceof TormentorTendrilEntity)) {
               if (entityiterator instanceof Player) {
                  double _setval = 60.0;
                  entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.shadertime = _setval;
                     capability.syncPlayerVariables(entityiterator);
                  });
               }

               if (world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.DEATH_SMOKE.get(), x, y, z, 10, 1.0, 1.0, 1.0, 0.4);
               }

               if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) > 200.0F) {
                  if ((entityiterator instanceof LivingEntity _livEntxxx ? _livEntxxx.getMaxHealth() : -1.0F)
                        - (entityiterator instanceof LivingEntity _livEntxx ? _livEntxx.getMaxHealth() : -1.0F) / 10.0F
                     < (entityiterator instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)) {
                     entityiterator.hurt(
                        new DamageSource(
                           world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), immediatesourceentity, entity
                        ),
                        (float)(
                           (40.0 + ArphexModVariables.MapVariables.get(world).tormentor_tier * 10.0)
                              / ((double)((entityiterator instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getArmorValue() : 0) + 3) / 1.2)
                        )
                     );
                     if ((entityiterator instanceof LivingEntity _livEntxxxxxx ? _livEntxxxxxx.getHealth() : -1.0F)
                           - (entityiterator instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMaxHealth() : -1.0F) / 10.0F
                        > 0.0F) {
                        if (entityiterator instanceof LivingEntity _entity) {
                           _entity.setHealth(
                              (entityiterator instanceof LivingEntity _livEntxxxxxxxx ? _livEntxxxxxxxx.getHealth() : -1.0F)
                                 - (entityiterator instanceof LivingEntity _livEntxxxxxxx ? _livEntxxxxxxx.getMaxHealth() : -1.0F) / 10.0F
                           );
                        }
                     } else {
                        if (entityiterator instanceof LivingEntity _entity) {
                           _entity.setHealth(1.0F);
                        }

                        entityiterator.hurt(
                           new DamageSource(
                              world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC),
                              immediatesourceentity,
                              entity
                           ),
                           99999.0F
                        );
                     }
                  } else {
                     entityiterator.hurt(
                        new DamageSource(
                           world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), immediatesourceentity, entity
                        ),
                        (float)(
                           (40.0 + ArphexModVariables.MapVariables.get(world).tormentor_tier * 10.0)
                              / ((double)((entityiterator instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getArmorValue() : 0) + 3) / 1.2)
                        )
                     );
                  }
               } else if (((entityiterator instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getArmorValue() : 0) + 3) / 16 != 0) {
                  entityiterator.hurt(
                     new DamageSource(
                        world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), immediatesourceentity, entity
                     ),
                     (float)(
                        (double)(70 / (((entityiterator instanceof LivingEntity _livEntxxxxxxx ? _livEntxxxxxxx.getArmorValue() : 0) + 3) / 16))
                           * (1.9 + ArphexModVariables.MapVariables.get(world).tormentor_tier / 2.0)
                     )
                  );
               }

               if (world instanceof Level _level && !_level.isClientSide()) {
                  _level.explode(null, x, y, z, 10.0F, ExplosionInteraction.MOB);
               }

               if (!immediatesourceentity.level().isClientSide()) {
                  immediatesourceentity.discard();
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

         if ((Boolean)ConfigurationSettingsConfiguration.TORMENTOR_GRIEFING.get()
            && !world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))
            && world instanceof Level _level
            && !_level.isClientSide()) {
            _level.explode(null, entity.getX(), entity.getY(), entity.getZ(), 20.0F, ExplosionInteraction.MOB);
         }

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
